package kotlin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@MustBeDocumented
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00038\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/annotation/Target;", "Ljava/lang/annotation/Annotation;", "Lkotlin/Any;", "", "Lkotlin/annotation/AnnotationTarget;", "allowedTargets", "()[Lkotlin/annotation/AnnotationTarget;", "<init>", "(Lcom/android/tools/r8/jetbrains/kotlin/Array;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Documented
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface Target {
    AnnotationTarget[] allowedTargets();
}
