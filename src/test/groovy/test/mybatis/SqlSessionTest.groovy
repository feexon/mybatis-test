package test.mybatis

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mybatis.pojos.Blog

/**
 * @author Administrator
 * @version 1.0 2014/6/10,15:33
 */
class SqlSessionTest {
    private SqlSession session

    @Before
    public void beginSession() throws Exception {
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder()
        SqlSessionFactory sessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis.xml"));
        assert sessionFactory;
        session = sessionFactory.openSession()
        assert this.session;
    }

    @After
    public void endSession() throws Exception {
        session.close();
    }

    @Test
    public void queryFromStatement() throws Exception {
        Blog blog = session.selectOne("org.mybatis.mapper.BlogMapper.selectBlog", 1);
        assert blog.title == "MyBatis";
    }
}
