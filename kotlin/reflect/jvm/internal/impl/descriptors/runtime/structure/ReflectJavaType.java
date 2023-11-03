package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
/* loaded from: classes2.dex */
public abstract class ReflectJavaType implements JavaType {
    public static final Factory Factory = new Factory(null);

    public abstract Type getReflectType();

    /* loaded from: classes2.dex */
    public static final class Factory {
        public Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReflectJavaType create(Type type) {
            ReflectJavaType reflectJavaArrayType;
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new ReflectJavaPrimitiveType(cls);
                }
            }
            if (!(type instanceof GenericArrayType) && (!z || !((Class) type).isArray())) {
                if (type instanceof WildcardType) {
                    reflectJavaArrayType = new ReflectJavaWildcardType((WildcardType) type);
                } else {
                    reflectJavaArrayType = new ReflectJavaClassifierType(type);
                }
            } else {
                reflectJavaArrayType = new ReflectJavaArrayType(type);
            }
            return reflectJavaArrayType;
        }
    }

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ReflectJavaType) && Intrinsics.areEqual(getReflectType(), ((ReflectJavaType) obj).getReflectType())) {
            return true;
        }
        return false;
    }
}
