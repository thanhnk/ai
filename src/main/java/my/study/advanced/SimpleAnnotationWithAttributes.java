package my.study.advanced;

public @interface SimpleAnnotationWithAttributes {
    String name();

    int order() default 0;
}
