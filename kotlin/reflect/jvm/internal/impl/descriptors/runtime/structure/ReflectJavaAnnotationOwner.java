package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* loaded from: classes10.dex */
public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {
    AnnotatedElement getElement();

    /* loaded from: classes10.dex */
    public static final class DefaultImpls {
        public static boolean isDeprecatedInJavaDoc(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            return false;
        }

        public static ReflectJavaAnnotation findAnnotation(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner, FqName fqName) {
            Annotation[] declaredAnnotations;
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            if (element != null && (declaredAnnotations = element.getDeclaredAnnotations()) != null) {
                return ReflectJavaAnnotationOwnerKt.findAnnotation(declaredAnnotations, fqName);
            }
            return null;
        }

        public static List<ReflectJavaAnnotation> getAnnotations(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            Annotation[] declaredAnnotations;
            List<ReflectJavaAnnotation> annotations;
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null || (annotations = ReflectJavaAnnotationOwnerKt.getAnnotations(declaredAnnotations)) == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return annotations;
        }
    }
}
