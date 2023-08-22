package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
/* loaded from: classes2.dex */
public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    public final Constructor<?> member;

    public ReflectJavaConstructor(Constructor<?> constructor) {
        this.member = constructor;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Constructor<?> getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = getMember().getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    public List<JavaValueParameter> getValueParameters() {
        boolean z;
        Type[] realTypes = getMember().getGenericParameterTypes();
        Intrinsics.checkExpressionValueIsNotNull(realTypes, "types");
        if (realTypes.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Class<?> klass = getMember().getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(klass, "klass");
        if (klass.getDeclaringClass() != null && !Modifier.isStatic(klass.getModifiers())) {
            realTypes = (Type[]) ArraysKt___ArraysJvmKt.copyOfRange(realTypes, 1, realTypes.length);
        }
        Annotation[][] realAnnotations = getMember().getParameterAnnotations();
        if (realAnnotations.length >= realTypes.length) {
            if (realAnnotations.length > realTypes.length) {
                Intrinsics.checkExpressionValueIsNotNull(realAnnotations, "annotations");
                realAnnotations = (Annotation[][]) ArraysKt___ArraysJvmKt.copyOfRange(realAnnotations, realAnnotations.length - realTypes.length, realAnnotations.length);
            }
            Intrinsics.checkExpressionValueIsNotNull(realTypes, "realTypes");
            Intrinsics.checkExpressionValueIsNotNull(realAnnotations, "realAnnotations");
            return getValueParameters(realTypes, realAnnotations, getMember().isVarArgs());
        }
        throw new IllegalStateException("Illegal generic signature: " + getMember());
    }
}
