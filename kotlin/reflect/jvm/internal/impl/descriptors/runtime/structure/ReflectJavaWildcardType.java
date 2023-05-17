package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
/* loaded from: classes10.dex */
public final class ReflectJavaWildcardType extends ReflectJavaType implements JavaWildcardType {
    public final WildcardType reflectType;

    public ReflectJavaWildcardType(WildcardType wildcardType) {
        this.reflectType = wildcardType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public ReflectJavaType getBound() {
        Type[] upperBounds = getReflectType().getUpperBounds();
        Type[] lowerBounds = getReflectType().getLowerBounds();
        if (upperBounds.length <= 1 && lowerBounds.length <= 1) {
            if (lowerBounds.length == 1) {
                ReflectJavaType.Factory factory = ReflectJavaType.Factory;
                Intrinsics.checkExpressionValueIsNotNull(lowerBounds, "lowerBounds");
                Object single = ArraysKt___ArraysKt.single(lowerBounds);
                Intrinsics.checkExpressionValueIsNotNull(single, "lowerBounds.single()");
                return factory.create((Type) single);
            } else if (upperBounds.length != 1) {
                return null;
            } else {
                Intrinsics.checkExpressionValueIsNotNull(upperBounds, "upperBounds");
                Type ub = (Type) ArraysKt___ArraysKt.single(upperBounds);
                if (!(!Intrinsics.areEqual(ub, Object.class))) {
                    return null;
                }
                ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
                Intrinsics.checkExpressionValueIsNotNull(ub, "ub");
                return factory2.create(ub);
            }
        }
        throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public boolean isExtends() {
        Type[] upperBounds = getReflectType().getUpperBounds();
        Intrinsics.checkExpressionValueIsNotNull(upperBounds, "reflectType.upperBounds");
        return !Intrinsics.areEqual((Type) ArraysKt___ArraysKt.firstOrNull(upperBounds), Object.class);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public WildcardType getReflectType() {
        return this.reflectType;
    }
}
