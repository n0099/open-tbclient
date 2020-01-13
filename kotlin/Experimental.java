package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes5.dex */
public @interface Experimental {

    /* loaded from: classes5.dex */
    public enum Level {
        WARNING,
        ERROR
    }
}
