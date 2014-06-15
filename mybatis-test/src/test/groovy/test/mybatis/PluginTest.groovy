package test.mybatis

import org.apache.ibatis.executor.Executor
import org.apache.ibatis.mapping.MappedStatement
import org.apache.ibatis.plugin.Intercepts
import org.apache.ibatis.plugin.Invocation
import org.apache.ibatis.plugin.Plugin
import org.apache.ibatis.plugin.Signature
import org.apache.ibatis.session.ResultHandler
import org.apache.ibatis.session.RowBounds
import org.apache.ibatis.session.SqlSessionFactory
import org.junit.Test
import org.mybatis.pojos.Blog

/**
 * @author Administrator
 * @version 1.0 2014/6/10,15:33
 */
class PluginTest extends MybatisTestCase {
    private InterceptorMonitor interceptor = new InterceptorMonitor();
    @Intercepts(@Signature(type = Executor, method = "query", args = [MappedStatement, Object, RowBounds, ResultHandler]))
    public static class InterceptorMonitor implements org.apache.ibatis.plugin.Interceptor {
        def intercepted = false;

        Object intercept(Invocation invocation) throws Throwable {
            intercepted = true;
            return invocation.proceed();
        }

        Object plugin(Object target) {
            return Plugin.wrap(target, this);
        }

        void setProperties(Properties properties) {

        }
    }


    protected configure(SqlSessionFactory sessionFactory) {
        sessionFactory.configuration.addInterceptor(interceptor)
    }


    @Test
    public void queryWillIntercepted() throws Exception {
        assert blogs.selectBlog(1).title == "MyBatis";
        assert interceptor.intercepted;
    }

    @Test
    public void updateSkipped() throws Exception {
        blogs.updateBlog(new Blog(id: 1, title: 'mybatis'));
        assert !interceptor.intercepted;

    }
}
