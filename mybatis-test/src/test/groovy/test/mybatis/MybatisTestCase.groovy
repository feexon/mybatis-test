package test.mybatis

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.After
import org.junit.Before
import org.mybatis.mapper.BlogMapper

/**
 * Created by L.x on 14-6-15.
 */
abstract class MybatisTestCase {
    protected SqlSession session
    private SqlSessionFactory sessionFactory
    protected BlogMapper blogs

    @Before
    public void beginSession() throws Exception {
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder()
        sessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis.xml"))
        assert sessionFactory;
        configure(sessionFactory);
        resetSession();
        blogs = session.getMapper(BlogMapper);
    }

    protected configure(SqlSessionFactory sessionFactory) {

    }

    protected void resetSession() {
        if (session != null) {
            session.close();
        }
        session = sessionFactory.openSession();
        assert session;
    }

    @After
    public void endSession() throws Exception {
        session.close();
    }
}
