/**
 * 
 */
package com.kicksolutions.swagger.markdown.vo;

import io.swagger.models.Path;

/**
 * @author MBARDIYA
 *
 */
public class CodegenOperation {

	private String uri;
	private Path path;
	
	@Override
	public String toString() {
		return "CodegenOperation [uri=" + uri + ", path=" + path + "]";
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	/**
	 * 
	 * @param uri
	 * @param path
	 */
	public CodegenOperation(String uri, Path path) {
		super();
		this.uri = uri;
		this.path = path;
	}
}