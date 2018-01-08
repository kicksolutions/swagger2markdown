package com.kicksolutions.swagger.markdown;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

/**
 * MSANTOSH
 *
 */
public class MarkdownGenerator 
{
	private static final Logger LOGGER = Logger.getLogger(MarkdownGenerator.class.getName());
	
	public MarkdownGenerator() {
		super();
	}
	    
    /**
     * 
     * @param specFile
     * @param output
     */
    public void transformSwagger2Markdown(String specFile,String output){
    	LOGGER.entering(LOGGER.getName(), "transformSwagger2Markdown");
    	
    	File swaggerSpecFile = new File(specFile);
    	File targetLocation = new File(output);
    	
    	if(swaggerSpecFile.exists() && !swaggerSpecFile.isDirectory() 
    			&& targetLocation.exists() && targetLocation.isDirectory()) { 
    		
    		Swagger swaggerObject = new SwaggerParser().read(swaggerSpecFile.getAbsolutePath());
    		SwaggerMarkdownCodegen codegen = new SwaggerMarkdownCodegen(swaggerObject, targetLocation);
    		String markdownPath = null;
    		
    		try{
    			LOGGER.info("Processing File --> "+ specFile);
    			markdownPath = codegen.generateMarkdown();    		
    			LOGGER.info("Sucessfully Created Markdown !!!");
    		}
    		catch(Exception e){
    			LOGGER.log(Level.SEVERE, e.getMessage(),e);
    			throw new RuntimeException(e);
    		}
    	}else{
    		throw new RuntimeException("Spec File or Ouput Locations are not valid");
    	}
    	
    	LOGGER.exiting(LOGGER.getName(), "transformSwagger2Markdown");
    }
}