package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
/* loaded from: classes9.dex */
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {
    public final ReflectJavaType componentType;
    public final Type reflectType;

    public ReflectJavaArrayType(Type type) {
        ReflectJavaType create;
        this.reflectType = type;
        Type reflectType = getReflectType();
        if (reflectType instanceof GenericArrayType) {
            ReflectJavaType.Factory factory = ReflectJavaType.Factory;
            Type genericComponentType = ((GenericArrayType) reflectType).getGenericComponentType();
            Intrinsics.checkExpressionValueIsNotNull(genericComponentType, "genericComponentType");
            create = factory.create(genericComponentType);
        } else {
            if (reflectType instanceof Class) {
                Class cls = (Class) reflectType;
                if (cls.isArray()) {
                    ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
                    Class<?> componentType = cls.getComponentType();
                    Intrinsics.checkExpressionValueIsNotNull(componentType, "getComponentType()");
                    create = factory2.create(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + getReflectType().getClass() + "): " + getReflectType());
        }
        this.componentType = create;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public ReflectJavaType getComponentType() {
        return this.componentType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public Type getReflectType() {
        return this.reflectType;
    }
}
