package org.mybatis.mapper

import org.mybatis.pojos.Blog

/**
 * @author Administrator
 * @version 1.0 2014/6/10,16:29
 */
public interface BlogMapper {
    Blog selectBlog(int blogId);

    int createNewBlog(Blog blog);

    int deleteBlog(int blogId);

    int updateBlog(Blog blog);
}