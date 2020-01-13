package kotlin.coroutines.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface c {
    String c() default "";

    int[] dJf() default {};

    String f() default "";

    String m() default "";

    int v() default 1;
}
