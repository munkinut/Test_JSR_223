import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static org.testng.Assert.assertEquals;


public class TestScripting_02 {

    static ScriptEngineManager factory;
    static ScriptEngine engine;

    public TestScripting_02() {
        factory = new ScriptEngineManager();
        engine = factory.getEngineByName("groovy");
    }

    public static void main (String[] args) throws ScriptException {
        TestScripting_02 ts = new TestScripting_02();
        engine.put("first", "HELLO");
        engine.put("second", "world");
        String result = (String) engine.eval("first.toLowerCase() + ' ' + second.toUpperCase()");
        assertEquals("hello WORLD", result);
        System.out.println(result);
    }
}
