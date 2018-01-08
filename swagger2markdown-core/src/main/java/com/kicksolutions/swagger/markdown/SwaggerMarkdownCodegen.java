/**
 * 
 */
package com.kicksolutions.swagger.markdown;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.kicksolutions.swagger.markdown.vo.CodegenOperation;

import io.swagger.models.Path;
import io.swagger.models.Swagger;

/**
 * @author MSANTOSH
 * 
 */
public class SwaggerMarkdownCodegen {

	private static final Logger LOGGER = Logger.getLogger(SwaggerMarkdownCodegen.class.getName());
	
	private Swagger swagger;
	private File targetLocation;

	/**
	 * 
	 */
	public SwaggerMarkdownCodegen(Swagger swagger, File targetLocation) {
		this.swagger = swagger;
		this.targetLocation = targetLocation;
	}

	/**
	 * 
	 */
	public String generateMarkdown() throws IOException, IllegalAccessException {
		LOGGER.entering(LOGGER.getName(), "generateMarkdown");

		Map<String, Object> additionalProperties = new HashMap<>();
		additionalProperties.put("swagger", swagger);
		additionalProperties.putAll(handleMapItems(swagger));

		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile("markdown.mustache");
		Writer writer = null;
		String markdownFilePath = new StringBuilder().append(targetLocation.getAbsolutePath()).append(File.separator)
				.append("swagger.md").toString();
		try {
			writer = new FileWriter(markdownFilePath);
			mustache.execute(writer, additionalProperties);

			LOGGER.log(Level.FINEST, "Sucessfully Written Markdown File @ " + markdownFilePath);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw new IllegalAccessException(e.getMessage());
		} finally {
			if (writer != null) {
				writer.flush();
			}
		}

		LOGGER.exiting(LOGGER.getName(), "generateMarkdown");
		return markdownFilePath;
	}
	
	/**
	 * 
	 * @param swagger
	 * @return
	 */
	private Map<String, Object> handleMapItems(Swagger swagger){
		Map<String, Object> specialMap = new HashMap<>();
		Map<String,Path> paths = swagger.getPaths();
		
		List<CodegenOperation> operations = new ArrayList<>();
		
		for(Map.Entry<String, Path> entry: paths.entrySet()) {
			
			Path pathObject = entry.getValue();
			
			operations.add(new CodegenOperation(entry.getKey(), pathObject));
		}
		
		specialMap.put("operations", operations);
		
		return specialMap;
	}
}