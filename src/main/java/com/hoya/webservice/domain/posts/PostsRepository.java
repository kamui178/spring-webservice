package com.hoya.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>  {

	@Query // 쿼리 넣고 post 마무리 
}
