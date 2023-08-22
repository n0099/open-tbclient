package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
/* loaded from: classes2.dex */
public interface TypeParameterResolver {

    /* loaded from: classes2.dex */
    public static final class EMPTY implements TypeParameterResolver {
        public static final EMPTY INSTANCE = new EMPTY();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
        public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter) {
            return null;
        }
    }

    TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter);
}
