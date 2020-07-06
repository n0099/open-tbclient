package kotlin.coroutines.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.h;
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@h
/* loaded from: classes7.dex */
public @interface c {
    String c() default "";

    int[] dQF() default {};

    String f() default "";

    String m() default "";

    int v() default 1;
}
