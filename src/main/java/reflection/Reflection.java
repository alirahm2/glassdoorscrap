package reflection;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Reflection {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflection reflection = new Reflection();
        reflection.run();
    }

    public void run() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        File file = new File("/Users/alirahmani/IdeaProjects/testjarfile/out/artifacts/testjarfile_jar/testjarfile.jar");
        URL[] urls = new URL[]{file.toURL()};
        URLClassLoader child = new URLClassLoader(urls, this.getClass().getClassLoader());
        Class classToLoad = Class.forName("testClass", true, child);
        Method method = classToLoad.getDeclaredMethod("exec",String.class);
        Object instance = classToLoad.newInstance();
        Object result = method.invoke(instance,"khooobi");
    }
}
