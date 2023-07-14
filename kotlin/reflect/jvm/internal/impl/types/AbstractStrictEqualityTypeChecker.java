package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
/* loaded from: classes2.dex */
public final class AbstractStrictEqualityTypeChecker {
    public static final AbstractStrictEqualityTypeChecker INSTANCE = new AbstractStrictEqualityTypeChecker();

    private final boolean strictEqualSimpleTypes(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        boolean z;
        boolean z2;
        if (typeSystemContext.argumentsCount(simpleTypeMarker) == typeSystemContext.argumentsCount(simpleTypeMarker2) && typeSystemContext.isMarkedNullable(simpleTypeMarker) == typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            if (typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker) == null) {
                z = true;
            } else {
                z = false;
            }
            if (typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2) == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z == z2 && typeSystemContext.isEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker), typeSystemContext.typeConstructor(simpleTypeMarker2))) {
                if (typeSystemContext.identicalArguments(simpleTypeMarker, simpleTypeMarker2)) {
                    return true;
                }
                int argumentsCount = typeSystemContext.argumentsCount(simpleTypeMarker);
                for (int i = 0; i < argumentsCount; i++) {
                    TypeArgumentMarker argument = typeSystemContext.getArgument(simpleTypeMarker, i);
                    TypeArgumentMarker argument2 = typeSystemContext.getArgument(simpleTypeMarker2, i);
                    if (typeSystemContext.isStarProjection(argument) != typeSystemContext.isStarProjection(argument2)) {
                        return false;
                    }
                    if (!typeSystemContext.isStarProjection(argument) && (typeSystemContext.getVariance(argument) != typeSystemContext.getVariance(argument2) || !strictEqualTypesInternal(typeSystemContext, typeSystemContext.getType(argument), typeSystemContext.getType(argument2)))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean strictEqualTypesInternal(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        SimpleTypeMarker asSimpleType2 = typeSystemContext.asSimpleType(kotlinTypeMarker2);
        if (asSimpleType != null && asSimpleType2 != null) {
            return strictEqualSimpleTypes(typeSystemContext, asSimpleType, asSimpleType2);
        }
        FlexibleTypeMarker asFlexibleType = typeSystemContext.asFlexibleType(kotlinTypeMarker);
        FlexibleTypeMarker asFlexibleType2 = typeSystemContext.asFlexibleType(kotlinTypeMarker2);
        if (asFlexibleType != null && asFlexibleType2 != null && strictEqualSimpleTypes(typeSystemContext, typeSystemContext.lowerBound(asFlexibleType), typeSystemContext.lowerBound(asFlexibleType2)) && strictEqualSimpleTypes(typeSystemContext, typeSystemContext.upperBound(asFlexibleType), typeSystemContext.upperBound(asFlexibleType2))) {
            return true;
        }
        return false;
    }

    public final boolean strictEqualTypes(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        return strictEqualTypesInternal(typeSystemContext, kotlinTypeMarker, kotlinTypeMarker2);
    }
}
