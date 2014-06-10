package test.mybatis

import org.apache.ibatis.io.Resources
import org.junit.Test

/**
 * @author Administrator
 * @version 1.0 2014/6/10,15:28
 */
class ResourcesTest {
    @Test
    public void resourceUrl() throws Exception {
        assert Resources.getResourceURL("test.txt") == ClassLoader.getSystemResource("test.txt");
    }

    @Test
    public void unknownResource() throws Exception {
        assert !Resources.getResourceURL("unknown");
    }
}
