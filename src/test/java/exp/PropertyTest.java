package exp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.util.regex.Pattern;

public class PropertyTest {
  @Test
  void propIsSet1() {
    assertEquals("bar", System.getProperty("foo1"), "prop foo1");
  }

  @Test
  void propIsSet2() {
    assertEquals("bar", System.getProperty("foo2"), "prop foo2");
  }

  @Test
  void agentIsSet() {
    // example: "-javaagent:/home/user/.m2/split/cached/org/jacoco/org.jacoco.agent/0.8.12/org.jacoco.agent-0.8.12-runtime.jar=destfile=/home/user/dev/other/jacoco-experiment/target/jacoco.exec";
    String jvmArgs = ManagementFactory.getRuntimeMXBean().getInputArguments().toString();
    //System.out.println("Checking whether jacoco has been added to the jvm args: " + jvmArgs);
    //String pathRegex = "[a-zA-Z0-9/._-]*";
    //Pattern compile =
    //    Pattern.compile(Pattern.quote("-javaagent:") + pathRegex + "/org.jacoco.agent-0.8.12-runtime.jar=destfile=" + pathRegex + "/jacoco.exec");

    if(jvmArgs.contains("jacoco")) {
      throw new AssertionError("Warning: for the experiment, the jvm args should not mention a jacoco agent:\n" + jvmArgs);
    }
  }
}


