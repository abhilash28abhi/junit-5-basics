# junit5-basics

## Test Life Cycle
`` @BeforeAll - Called even before the test class instance is created
`` @AfterAll - Called after the instance of the test class is destroyed
`` @BeforeEach - Called before executing each test method
`` @AfterEach -  Called after executing each test method
`` @TestInstance - Used to change the behavior of test class instance creation
`` @DisplayName - Used to provide a meaning full name to the test method
`` @Disabled - Used to disable/skip the test method

## Conditional Executions:
`` @EnabledOnOS(OS.LINUX)
`` @EnabledOnJre(JRE.JAVA_11)
`` @EnabledIf
`` @EnabledIfSystemProperty
`` @EnabledIfEnvironmentVariable