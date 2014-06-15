package test.mybatis

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mybatis.mapper.BlogMapper
import org.mybatis.pojos.Blog

/**
 * @author Administrator
 * @version 1.0 2014/6/10,15:33
 */
class SqlSessionTest extends MybatisTestCase {


    @Test
    public void queryFromStatement() throws Exception {
        assert session.selectOne("org.mybatis.mapper.BlogMapper.selectBlog", 1).title == "MyBatis";
    }

    @Test
    public void queryByMapper() throws Exception {
        assert session.getMapper(BlogMapper.class).selectBlog(1).title == "MyBatis";
    }

    @Test
    public void insertBlog() throws Exception {
        int expectedEffectLines = 1;
        assert blogs.createNewBlog(new Blog(id: 3, title: 'Groovy')) == expectedEffectLines;
        session.commit();
        resetSession();
        assert session.getMapper(BlogMapper.class).selectBlog(3).title == "Groovy";
    }

    @Test
    public void deleteBlog() throws Exception {
        int expectedEffectLines = 1;
        assert blogs.deleteBlog(1) == expectedEffectLines;
        session.commit();
        resetSession();
        assert session.getMapper(BlogMapper.class).selectBlog(1) == null;
    }

    @Test
    public void autoCommitTurnedOff() throws Exception {
        int expectedEffectLines = 1;
        assert blogs.deleteBlog(1) == expectedEffectLines;
        resetSession();
        assert session.getMapper(BlogMapper.class).selectBlog(1).title == "MyBatis";
    }

    @Test
    public void updateBlog() throws Exception {
        int expectedEffectLines = 1;
        assert blogs.updateBlog(new Blog(id: 1, title: 'mybatis')) == expectedEffectLines;
        session.commit();
        resetSession();
        assert session.getMapper(BlogMapper.class).selectBlog(1).title == "mybatis";
    }
}
