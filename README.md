# junit5-basics

## Test Life Cycle:
1	@BeforeAll - Called even before the test class instance is created
2	@AfterAll - Called after the instance of the test class is destroyed
3	@BeforeEach - Called before executing each test method
4	@AfterEach -  Called after executing each test method
5	@TestInstance - Used to change the behavior of test class instance creation
6	@DisplayName - Used to provide a meaning full name to the test method
7	@Disabled - Used to disable/skip the test method

## Conditional Executions:
1	@EnabledOnOS(OS.LINUX)
2	@EnabledOnJre(JRE.JAVA_11)
3	@EnabledIf
4	@EnabledIfSystemProperty
5	@EnabledIfEnvironmentVariable
