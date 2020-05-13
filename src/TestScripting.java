import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static org.testng.Assert.assertEquals;

public class TestScripting {

    static ScriptEngineManager factory;
    static ScriptEngine engine;

    public TestScripting() {
        factory = new ScriptEngineManager();
        engine = factory.getEngineByName("groovy");
    }

    public static void main (String[] args) throws ScriptException {
        TestScripting ts = new TestScripting();
        Integer sum = (Integer) engine.eval("(1..10).sum()");
        assertEquals(Integer.valueOf(55), sum);
        System.out.println("55 is " + sum);
    }
}
