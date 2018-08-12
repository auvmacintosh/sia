package qly.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.naming.NamingException;
import javax.sql.DataSource;

import qly.data.QlyUserMapper;

@Configuration
@ComponentScan(basePackages = "qly",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
@PropertySource({"classpath:persistence-jndi.properties"})
public class RepoConfig {

//    public DataSource dataSource2() {
//        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//        dsLookup.setResourceRef(true);
//        DataSource dataSource = dsLookup.getDataSource("jdbc/wbqly");
//        return dataSource;
//    }

//    public DataSource dataSource1() {
//        JndiObjectFactoryBean jndiObjectFactoryBean =
//                new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("jdbc/wbqly");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
//        return (DataSource) jndiObjectFactoryBean.getObject();
//    }

    @Autowired
    private Environment env;

    public DataSource dataSource() throws NamingException {
//        return (DataSource) new JndiTemplate().lookup(env.getProperty("jdbc.url"));
        return (DataSource) new JndiTemplate().lookup("java:comp/env/db");
    }

    @Bean
    public QlyUserMapper getQlyUserMapper() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().addMapper(QlyUserMapper.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        QlyUserMapper qlyUserMapper = sqlSession.getMapper(QlyUserMapper.class);
        return qlyUserMapper;
    }

}
