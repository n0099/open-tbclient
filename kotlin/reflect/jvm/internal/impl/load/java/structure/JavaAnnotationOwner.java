package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* loaded from: classes10.dex */
public interface JavaAnnotationOwner extends JavaElement {
    JavaAnnotation findAnnotation(FqName fqName);

    Collection<JavaAnnotation> getAnnotations();

    boolean isDeprecatedInJavaDoc();
}
