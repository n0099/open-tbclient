package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.name.Name;
/* loaded from: classes9.dex */
public interface JavaValueParameter extends JavaAnnotationOwner {
    Name getName();

    JavaType getType();

    boolean isVararg();
}
