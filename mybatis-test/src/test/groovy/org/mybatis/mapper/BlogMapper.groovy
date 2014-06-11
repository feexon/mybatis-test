package org.mybatis.mapper

import org.mybatis.pojos.Blog

/**
 * @author Administrator
 * @version 1.0 2014/6/10,16:29
 */
public interface BlogMapper {
    Blog selectBlog(int blogId);

    def createNewBlog(Blog blog);

    def deleteBlog(int blogId);

    def updateBlog(Blog blog);
}