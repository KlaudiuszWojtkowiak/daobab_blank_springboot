package io.daobab.example.springboot.blank.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.daobab.generator.ClassGenerator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

//@Configuration
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DaobabCreator {

    private static String SCHEMA="";
    private static String JAVA_PACKAGE="io.daobab.example.springboot.blank.dao";
    private static String SOURCE_FOLDER="C:\\Users\\Klaudiusz\\IdeaProjects\\elephant\\daobab2-example\\src\\main\\java\\io\\daobab\\example\\dao";


    public static void main(String[] args){
        ClassGenerator cg=new ClassGenerator(mySQLDatabase(),SCHEMA,JAVA_PACKAGE,SOURCE_FOLDER);

    }

    private static DataSource mySQLDatabase(){

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("");
        dataSource.setUser("root");
        dataSource.setPassword("admin");
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/pizza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        return dataSource;

    }


    private static DataSource oracleDatabase(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( "jdbc:oracle:thin://@10.0.0.8:1521/orcl" );
        config.setUsername( "USERMANAG" );
        config.setPassword( "YZgTL4mc" );
        config.setDriverClassName("oracle.jdbc.OracleDriver");
        config.setSchema(SCHEMA);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        return new HikariDataSource( config );
    }
}
