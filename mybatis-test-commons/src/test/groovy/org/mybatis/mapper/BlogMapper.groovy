package org.mybatis.mapper

import org.mybatis.pojos.Blog
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/**
 * @author Administrator
 * @version 1.0 2014/6/10,16:29
 */
@Transactional(propagation = Propagation.REQUIRED)
public interface BlogMapper {
    @Transactional(readOnly = true)
    Blog selectBlog(int blogId);

    int createNewBlog(Blog blog);

    int deleteBlog(int blogId);

    int updateBlog(Blog blog);
}