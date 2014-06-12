package org.mybatis.test

import org.junit.Test
import org.junit.runner.RunWith
import org.mybatis.mapper.BlogMapper
import org.mybatis.pojos.Blog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.transaction.annotation.Transactional

/**
 * @author Administrator
 * @version 1.0 2014/6/11,10:07
 */

@ContextConfiguration("classpath:mybatis-spring.xml")
@TransactionConfiguration
class SpringMybatisTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private BlogMapper blogs;

    @Test
    public void selectBlog() throws Exception {
        assert blogs.selectBlog(1).title == "MyBatis";
    }

    @Test
    public void insertBlog() throws Exception {
        blogs.createNewBlog(new Blog(id: 4, title: 'mybatis-spring'));
        assert blogs.selectBlog(4).title == 'mybatis-spring';
    }

    @Test
    public void cacheDisabled() throws Exception {
        assert blogs.selectBlog(1).title == 'MyBatis';

        blogs.updateBlog(new Blog(id: 1, title: 'mybatis'));

        assert blogs.selectBlog(1).title == 'mybatis'

    }
}
