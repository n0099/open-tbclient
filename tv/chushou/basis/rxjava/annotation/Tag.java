package tv.chushou.basis.rxjava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes4.dex */
public @interface Tag {
    public static final String DEFAULT = "rxbus_default_tag";

    String value() default "rxbus_default_tag";
}
