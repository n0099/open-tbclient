package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
/* loaded from: classes2.dex */
public final class AbstractNullabilityChecker {
    public static final AbstractNullabilityChecker INSTANCE = new AbstractNullabilityChecker();

    private final boolean isApplicableAsEndNode(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        if (abstractTypeCheckerContext.isNothing(simpleTypeMarker)) {
            return true;
        }
        if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker)) {
            return false;
        }
        if (abstractTypeCheckerContext.isStubTypeEqualsToAnything() && abstractTypeCheckerContext.isStubType(simpleTypeMarker)) {
            return true;
        }
        return abstractTypeCheckerContext.isEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker);
    }

    public final boolean isPossibleSubtype(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        return runIsPossibleSubtype(abstractTypeCheckerContext, simpleTypeMarker, simpleTypeMarker2);
    }

    private final boolean runIsPossibleSubtype(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        boolean z;
        boolean z2;
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker) && !abstractTypeCheckerContext.isIntersection(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker)) && !abstractTypeCheckerContext.isAllowedTypeVariable(simpleTypeMarker)) {
                z = false;
            } else {
                z = true;
            }
            if (_Assertions.ENABLED && !z) {
                throw new AssertionError("Not singleClassifierType and not intersection subType: " + simpleTypeMarker);
            }
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker2) && !abstractTypeCheckerContext.isAllowedTypeVariable(simpleTypeMarker2)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (_Assertions.ENABLED && !z2) {
                throw new AssertionError("Not singleClassifierType superType: " + simpleTypeMarker2);
            }
        }
        if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2) || abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker) || hasNotNullSupertype(abstractTypeCheckerContext, simpleTypeMarker, AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if (abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker2) || hasNotNullSupertype(abstractTypeCheckerContext, simpleTypeMarker2, AbstractTypeCheckerContext.SupertypesPolicy.UpperIfFlexible.INSTANCE) || abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
            return false;
        }
        return hasPathByNotMarkedNullableNodes(abstractTypeCheckerContext, simpleTypeMarker, abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2));
    }

    public final boolean hasPathByNotMarkedNullableNodes(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        if (INSTANCE.isApplicableAsEndNode(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker)) {
            return true;
        }
        abstractTypeCheckerContext.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
        if (supertypesDeque == null) {
            Intrinsics.throwNpe();
        }
        Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
        if (supertypesSet == null) {
            Intrinsics.throwNpe();
        }
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker current = supertypesDeque.pop();
                Intrinsics.checkExpressionValueIsNotNull(current, "current");
                if (supertypesSet.add(current)) {
                    if (abstractTypeCheckerContext.isMarkedNullable(current)) {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual(supertypesPolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(current))) {
                            SimpleTypeMarker mo2109transformType = supertypesPolicy.mo2109transformType(abstractTypeCheckerContext, kotlinTypeMarker);
                            if (INSTANCE.isApplicableAsEndNode(abstractTypeCheckerContext, mo2109transformType, typeConstructorMarker)) {
                                abstractTypeCheckerContext.clear();
                                return true;
                            }
                            supertypesDeque.add(mo2109transformType);
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null)).toString());
            }
        }
        abstractTypeCheckerContext.clear();
        return false;
    }

    public final boolean hasNotNullSupertype(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy) {
        boolean z;
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy2;
        boolean z2;
        if ((abstractTypeCheckerContext.isClassType(simpleTypeMarker) && !abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker)) || abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            abstractTypeCheckerContext.initialize();
            ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
            if (supertypesDeque == null) {
                Intrinsics.throwNpe();
            }
            Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
            if (supertypesSet == null) {
                Intrinsics.throwNpe();
            }
            supertypesDeque.push(simpleTypeMarker);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() <= 1000) {
                    SimpleTypeMarker current = supertypesDeque.pop();
                    Intrinsics.checkExpressionValueIsNotNull(current, "current");
                    if (supertypesSet.add(current)) {
                        if (abstractTypeCheckerContext.isMarkedNullable(current)) {
                            supertypesPolicy2 = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                        } else {
                            supertypesPolicy2 = supertypesPolicy;
                        }
                        if (!(!Intrinsics.areEqual(supertypesPolicy2, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                            supertypesPolicy2 = null;
                        }
                        if (supertypesPolicy2 != null) {
                            for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(current))) {
                                SimpleTypeMarker mo2109transformType = supertypesPolicy2.mo2109transformType(abstractTypeCheckerContext, kotlinTypeMarker);
                                if ((abstractTypeCheckerContext.isClassType(mo2109transformType) && !abstractTypeCheckerContext.isMarkedNullable(mo2109transformType)) || abstractTypeCheckerContext.isDefinitelyNotNullType(mo2109transformType)) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    abstractTypeCheckerContext.clear();
                                } else {
                                    supertypesDeque.add(mo2109transformType);
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                } else {
                    throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null)).toString());
                }
            }
            abstractTypeCheckerContext.clear();
            return false;
        }
        return true;
    }
}
