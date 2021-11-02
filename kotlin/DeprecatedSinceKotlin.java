package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@SinceKotlin(version = "1.4")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.TYPEALIAS})
@Retention(RetentionPolicy.RUNTIME)
@MustBeDocumented
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u00038\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0013\u0010\u0007\u001a\u00020\u00038\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lkotlin/DeprecatedSinceKotlin;", "Ljava/lang/annotation/Annotation;", "Lkotlin/Any;", "", "errorSince", "()Ljava/lang/String;", "hiddenSince", "warningSince", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@Documented
/* loaded from: classes3.dex */
public @interface DeprecatedSinceKotlin {
    String errorSince() default "";

    String hiddenSince() default "";

    String warningSince() default "";
}
