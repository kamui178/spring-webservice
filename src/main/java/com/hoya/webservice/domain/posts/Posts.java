package com.hoya.webservice.domain.posts;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.hoya.webservice.domain.BaseTimeEntitiy;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity // table�� link �Ǿ��� class
public class Posts extends BaseTimeEntitiy {
	
	@Id // �ش� ���̺� pk
	@GeneratedValue // pk ������Ģ (default : auto_increment)
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	private String author;
	
	@Builder
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

}
