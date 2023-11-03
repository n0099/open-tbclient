package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes2.dex */
public final class MappingUtilKt {
    public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        boolean z;
        if (classDescriptor.getDeclaredTypeParameters().size() == classDescriptor2.getDeclaredTypeParameters().size()) {
            z = true;
        } else {
            z = false;
        }
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError(classDescriptor + " and " + classDescriptor2 + " should have same number of type parameters, but " + classDescriptor.getDeclaredTypeParameters().size() + " / " + classDescriptor2.getDeclaredTypeParameters().size() + " found");
        }
        TypeConstructorSubstitution.Companion companion = TypeConstructorSubstitution.Companion;
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(declaredTypeParameters, "from.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(declaredTypeParameters, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : declaredTypeParameters) {
            arrayList.add(typeParameterDescriptor.getTypeConstructor());
        }
        List<TypeParameterDescriptor> declaredTypeParameters2 = classDescriptor2.getDeclaredTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(declaredTypeParameters2, "to.declaredTypeParameters");
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(declaredTypeParameters2, 10));
        for (TypeParameterDescriptor it : declaredTypeParameters2) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            SimpleType defaultType = it.getDefaultType();
            Intrinsics.checkExpressionValueIsNotNull(defaultType, "it.defaultType");
            arrayList2.add(TypeUtilsKt.asTypeProjection(defaultType));
        }
        return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(companion, MapsKt__MapsKt.toMap(CollectionsKt___CollectionsKt.zip(arrayList, arrayList2)), false, 2, null);
    }
}
