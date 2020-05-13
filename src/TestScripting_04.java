import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestScripting_04 {

    static ScriptEngineManager factory;
    static ScriptEngine engine;

    public TestScripting_04() {
        factory = new ScriptEngineManager();
        engine = factory.getEngineByName("groovy");
    }

    public static void main (String[] args) throws ScriptException, NoSuchMethodException {
        TestScripting_04 ts = new TestScripting_04();
        String fact = "def factorial(n) { n == 1 ? 1 : n * factorial(n - 1) }";

        // load script from a file instead of using string above

        engine.eval(fact);
        Invocable inv = (Invocable) engine;
        Object[] params = {5};
        Object result = inv.invokeFunction("factorial", params);
        System.out.println(result);
    }
}
