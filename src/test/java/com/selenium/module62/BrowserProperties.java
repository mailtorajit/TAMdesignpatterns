package com.selenium.module62;

public class BrowserProperties {

	private String browserClassPath;
	private String browserDriverPath;

	private BrowserProperties(Builder builder) {
		this.browserDriverPath = builder.browserDriverPath;
		this.browserClassPath = builder.browserClassPath;
	}

	public String getbrowserClassPath() {
		return browserClassPath;
	}

	public String getbrowserDriverPath() {
		return browserDriverPath;
	}

	public static class Builder {
		private String browserClassPath;
		private String browserDriverPath;

		public Builder() {
		}

		public BrowserProperties build() {
			return new BrowserProperties(this);
		}

		public Builder browserClassPath(String browserClassPath) {
			this.browserClassPath = browserClassPath;
			return this;
		}

		public Builder browserDriverPath(String browserDriverPath) {
			this.browserDriverPath = browserDriverPath;
			return this;
		}
	}
}
