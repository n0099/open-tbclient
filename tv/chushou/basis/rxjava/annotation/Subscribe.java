package tv.chushou.basis.rxjava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import tv.chushou.basis.rxjava.thread.EventThread;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes4.dex */
public @interface Subscribe {
    Tag[] tags() default {};

    EventThread thread() default EventThread.MAIN_THREAD;
}
