package my.study.advanced;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by thanh on 12/24/16.
 */
public class ReflectionMain {
    public static void main(String[] args) throws Exception {
        final SimpleAnnotation annotation =
                SampleClass.class.getAnnotation( SimpleAnnotation.class );
        if( annotation != null ) {
            // Some implementation here
        }
    }
}
