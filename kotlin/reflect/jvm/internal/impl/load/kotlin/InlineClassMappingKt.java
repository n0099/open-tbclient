package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.HashSet;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
/* loaded from: classes9.dex */
public final class InlineClassMappingKt {
    public static final KotlinTypeMarker computeExpandedTypeForInlineClass(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker) {
        return computeExpandedTypeInner(typeSystemCommonBackendContext, kotlinTypeMarker, new HashSet());
    }

    public static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, HashSet<TypeConstructorMarker> hashSet) {
        KotlinTypeMarker computeExpandedTypeInner;
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!hashSet.add(typeConstructor)) {
            return null;
        }
        TypeParameterMarker typeParameterClassifier = typeSystemCommonBackendContext.getTypeParameterClassifier(typeConstructor);
        if (typeParameterClassifier != null) {
            computeExpandedTypeInner = computeExpandedTypeInner(typeSystemCommonBackendContext, typeSystemCommonBackendContext.getRepresentativeUpperBound(typeParameterClassifier), hashSet);
            if (computeExpandedTypeInner == null) {
                return null;
            }
            if (!typeSystemCommonBackendContext.isNullableType(computeExpandedTypeInner) && typeSystemCommonBackendContext.isMarkedNullable(kotlinTypeMarker)) {
                return typeSystemCommonBackendContext.makeNullable(computeExpandedTypeInner);
            }
        } else if (typeSystemCommonBackendContext.isInlineClass(typeConstructor)) {
            KotlinTypeMarker substitutedUnderlyingType = typeSystemCommonBackendContext.getSubstitutedUnderlyingType(kotlinTypeMarker);
            if (substitutedUnderlyingType == null || (computeExpandedTypeInner = computeExpandedTypeInner(typeSystemCommonBackendContext, substitutedUnderlyingType, hashSet)) == null) {
                return null;
            }
            if (typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker)) {
                if (!typeSystemCommonBackendContext.isNullableType(computeExpandedTypeInner)) {
                    if (!(computeExpandedTypeInner instanceof SimpleTypeMarker) || !typeSystemCommonBackendContext.isPrimitiveType((SimpleTypeMarker) computeExpandedTypeInner)) {
                        return typeSystemCommonBackendContext.makeNullable(computeExpandedTypeInner);
                    }
                    return kotlinTypeMarker;
                }
                return kotlinTypeMarker;
            }
        } else {
            return kotlinTypeMarker;
        }
        return computeExpandedTypeInner;
    }
}
