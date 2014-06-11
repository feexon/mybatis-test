package org.mybatis.test

import org.junit.Test
import org.junit.runner.RunWith
import org.mybatis.mapper.BlogMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * @author Administrator
 * @version 1.0 2014/6/11,10:07
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("classpath:mybatis-spring.xml")
class SpringMybatisTest {
    @Autowired
    private BlogMapper blogs;

    @Test
    public void selectBlog() throws Exception {
        assert blogs.selectBlog(1).title == "MyBatis";
    }
}
