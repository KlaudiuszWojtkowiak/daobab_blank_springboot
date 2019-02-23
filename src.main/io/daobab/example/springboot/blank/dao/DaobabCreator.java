package io.daobab.example.springboot.blank.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.daobab.generator.ClassGenerator;

import javax.sql.DataSource;

//@Configuration
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DaobabCreator {

    private static String IP="";
    private static String PORT="";
    private static String USER="";
    private static String PASS="";

   private static String SCHEMA="";
   private static String JAVA_PACKAGE="io.daobab.example.springboot.blank.dao";
   private static String FILE_DIRECTIRY_PATH ="C:\\daobab";



    public static void main(String[] args){
        ClassGenerator cg=new ClassGenerator(mySQLDatabase());
        cg.setSchema(SCHEMA);
        cg.setJavaPackage(JAVA_PACKAGE);
        cg.setFileDirectoryPath(FILE_DIRECTIRY_PATH);
        cg.setGenerateTypeScriptClasses(true);

    }

    private static DataSource mySQLDatabase(){

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://"+IP+":"+PORT+"/"+SCHEMA+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        config.setUsername(USER);
        config.setPassword(PASS);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setSchema(SCHEMA);
        return new HikariDataSource( config );

    }


    private static DataSource oracleDatabase(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( "jdbc:oracle:thin://@IP:PORT/orcl" );
        config.setUsername( USER );
        config.setPassword( PASS );
        config.setDriverClassName("oracle.jdbc.OracleDriver");
        config.setSchema(SCHEMA);
        return new HikariDataSource( config );
    }
}
