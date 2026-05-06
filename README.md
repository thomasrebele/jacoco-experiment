# Reproduce a problem with Surefire argLine

In combination with SurefireForkNodeFactory, running maven tests may lead to a blocking, if the variables of the <argLine> are not initialized.

How to run it: `mvn test`

```
...
[INFO] --- surefire:3.5.5:test (default-test) @ jacoco-experiment ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
Error: could not open `{jacoco.agent.argLine}'
```

The process cannot be killed with Ctrl+C or `kill $pid`. It can be killed with `kill -9 $pid`.

## References

The source code was inspired by https://devll.org/blog/2020/java/jacoco-argline.html.
