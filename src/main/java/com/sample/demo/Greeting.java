package com.sample.demo;

public class Greeting {
	private final long id;
	private final String content;
	private final String timestamp;
	
	
	public Greeting(long id, String content, String timestamp) {
		this.id = id;
		this.content = content;
		this.timestamp = timestamp;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	
	
}
