package com.hoya.webservice.dto.posts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.hoya.webservice.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsMainResponseDto {

	private Long id;
	private String title;
	private String author;
	private String modifiedDate;

	public PostsMainResponseDto(Posts entity) {
		id = entity.getId();
		title = entity.getTitle();
		author = entity.getAuthor();
		modifiedDate = toStringDateTime(entity.getModfiedDate());
	}

	// java 8 version
	private String toStringDateTime(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return Optional.ofNullable(localDateTime)
				.map(formatter::format).orElse("");
	}

	// java 7 version
	private String toStringDateTimeVer7(LocalDateTime localDateTime) {
		if (localDateTime == null) {
			return "";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:MM:SS");
		return formatter.format(localDateTime);
	}

}
