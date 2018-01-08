package com.kicksolutions.swagger;

import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.kicksolutions.CliArgs;
import com.kicksolutions.swagger.markdown.MarkdownGenerator;

/**
 * MSANTOSH
 *
 */
public class Swagger2MarkDown 
{
	private static final Logger LOGGER = Logger.getLogger(Swagger2MarkDown.class.getName());
	private static final String USAGE = new StringBuilder()
			.append(" Usage: ")
			.append(Swagger2MarkDown.class.getName()).append(" <options> \n")
			.append(" -i <spec file> ")
			.append(" -o <output directory> ").toString();
	
	public Swagger2MarkDown() {
		super();
	}
	
	/**
	 * 
	 * @param args
	 */
    public static void main( String[] args )
    {
    	Swagger2MarkDown swagger2PlantUML = new Swagger2MarkDown();
    	swagger2PlantUML.init(args);   	
    }
    
    /**
     * 
     * @param args
     */
    private void init(String args[]){
    	LOGGER.entering(LOGGER.getName(), "init");
    	
    	CliArgs cliArgs = new CliArgs(args);
    	String specFile = cliArgs.getArgumentValue("-i", "");
    	String output = cliArgs.getArgumentValue("-o","");
    	
    	if(StringUtils.isNotEmpty(specFile) && StringUtils.isNotEmpty(output)){
    		process(specFile, output);
    	}
    	else{
    		LOGGER.severe(USAGE);
    	}
    	
    	LOGGER.exiting(LOGGER.getName(), "init");
    }
    
    /**
     * 
     * @param specFile
     * @param output
     */
    private void process(String specFile,String output){
    	MarkdownGenerator generator = new MarkdownGenerator();
    	generator.transformSwagger2Markdown(specFile, output);
    }    
}