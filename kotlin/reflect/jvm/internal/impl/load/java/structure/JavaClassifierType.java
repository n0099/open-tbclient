package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
/* loaded from: classes9.dex */
public interface JavaClassifierType extends JavaAnnotationOwner, JavaType {
    JavaClassifier getClassifier();

    String getClassifierQualifiedName();

    String getPresentableText();

    List<JavaType> getTypeArguments();

    boolean isRaw();
}
