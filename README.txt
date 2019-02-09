1. Run SpringBootWebApplication and check http://localhost:9111/test/t01 if it works.
2. In class DaobabCreator - Configure database connection. All set for MySql or Oracle database. Just fill host,port,username,pass ...
3. In class DaobabCreator - point schemaname and folder to generate classes
4. Run DaobabCreator to start reverse engeenering
5. Annotate generated target class with Spring annpotations (commented example at the top of DaobabCreator):
    @Configuration
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
6. Inject this target into controller
7. Fill controller methods with queries and redeploy application
8. Check JSON results on  http://localhost:9111/test/t01...
