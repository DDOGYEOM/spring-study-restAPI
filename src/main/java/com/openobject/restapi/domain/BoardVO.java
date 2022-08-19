package com.openobject.restapi.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

public class BoardVO {
	@JsonProperty("board_id")
	private int id;
	private String title;
	private String content;
	private String writer;
	@JsonProperty("writer_id")
	private String writerId;
	@JsonProperty("post_date")
	private String postDate;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

}
