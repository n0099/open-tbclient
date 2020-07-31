package com.squareup.wire;

import com.squareup.wire.Message;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes8.dex */
public @interface ProtoField {
    boolean deprecated() default false;

    Message.Label label() default Message.Label.OPTIONAL;

    int tag();

    Message.Datatype type() default Message.Datatype.MESSAGE;
}
