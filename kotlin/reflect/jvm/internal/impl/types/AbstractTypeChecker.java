package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
/* loaded from: classes2.dex */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;

    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TypeVariance.INV.ordinal()] = 1;
            $EnumSwitchMapping$0[TypeVariance.OUT.ordinal()] = 2;
            $EnumSwitchMapping$0[TypeVariance.IN.ordinal()] = 3;
            int[] iArr2 = new int[AbstractTypeCheckerContext.LowerCapturedTypePolicy.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            $EnumSwitchMapping$1[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            $EnumSwitchMapping$1[AbstractTypeCheckerContext.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1] */
    private final Boolean checkSubtypeForIntegerLiteralType(final AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        if (!abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker) && !abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker2)) {
            return null;
        }
        ?? r0 = new Function3<SimpleTypeMarker, SimpleTypeMarker, Boolean, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1
            {
                super(3);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(SimpleTypeMarker simpleTypeMarker3, SimpleTypeMarker simpleTypeMarker4, Boolean bool) {
                return Boolean.valueOf(invoke(simpleTypeMarker3, simpleTypeMarker4, bool.booleanValue()));
            }

            public final boolean invoke(SimpleTypeMarker simpleTypeMarker3, SimpleTypeMarker simpleTypeMarker4, boolean z) {
                boolean z2;
                Collection<KotlinTypeMarker> possibleIntegerTypes = AbstractTypeCheckerContext.this.possibleIntegerTypes(simpleTypeMarker3);
                if (!(possibleIntegerTypes instanceof Collection) || !possibleIntegerTypes.isEmpty()) {
                    for (KotlinTypeMarker kotlinTypeMarker : possibleIntegerTypes) {
                        if (!Intrinsics.areEqual(AbstractTypeCheckerContext.this.typeConstructor(kotlinTypeMarker), AbstractTypeCheckerContext.this.typeConstructor(simpleTypeMarker4)) && (!z || !AbstractTypeChecker.INSTANCE.isSubtypeOf(AbstractTypeCheckerContext.this, simpleTypeMarker4, kotlinTypeMarker))) {
                            z2 = false;
                            continue;
                        } else {
                            z2 = true;
                            continue;
                        }
                        if (z2) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        if (abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker) && abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker2)) {
            return Boolean.TRUE;
        }
        if (abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker)) {
            if (r0.invoke(simpleTypeMarker, simpleTypeMarker2, false)) {
                return Boolean.TRUE;
            }
        } else if (abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker2) && r0.invoke(simpleTypeMarker2, simpleTypeMarker, true)) {
            return Boolean.TRUE;
        }
        return null;
    }

    private final Boolean checkSubtypeForSpecialCases(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        KotlinTypeMarker kotlinTypeMarker;
        boolean z = false;
        if (!abstractTypeCheckerContext.isError(simpleTypeMarker) && !abstractTypeCheckerContext.isError(simpleTypeMarker2)) {
            if (!abstractTypeCheckerContext.isStubType(simpleTypeMarker) && !abstractTypeCheckerContext.isStubType(simpleTypeMarker2)) {
                CapturedTypeMarker asCapturedType = abstractTypeCheckerContext.asCapturedType(simpleTypeMarker2);
                if (asCapturedType != null) {
                    kotlinTypeMarker = abstractTypeCheckerContext.lowerType(asCapturedType);
                } else {
                    kotlinTypeMarker = null;
                }
                if (asCapturedType != null && kotlinTypeMarker != null) {
                    int i = WhenMappings.$EnumSwitchMapping$1[abstractTypeCheckerContext.getLowerCapturedTypePolicy(simpleTypeMarker, asCapturedType).ordinal()];
                    if (i != 1) {
                        if (i == 2 && isSubtypeOf(abstractTypeCheckerContext, simpleTypeMarker, kotlinTypeMarker)) {
                            return Boolean.TRUE;
                        }
                    } else {
                        return Boolean.valueOf(isSubtypeOf(abstractTypeCheckerContext, simpleTypeMarker, kotlinTypeMarker));
                    }
                }
                TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2);
                if (!abstractTypeCheckerContext.isIntersection(typeConstructor)) {
                    return null;
                }
                boolean z2 = !abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2);
                if (_Assertions.ENABLED && !z2) {
                    throw new AssertionError("Intersection type should not be marked nullable!: " + simpleTypeMarker2);
                }
                Collection<KotlinTypeMarker> supertypes = abstractTypeCheckerContext.supertypes(typeConstructor);
                if (!(supertypes instanceof Collection) || !supertypes.isEmpty()) {
                    for (KotlinTypeMarker kotlinTypeMarker2 : supertypes) {
                        if (!INSTANCE.isSubtypeOf(abstractTypeCheckerContext, simpleTypeMarker, kotlinTypeMarker2)) {
                            break;
                        }
                    }
                }
                z = true;
                return Boolean.valueOf(z);
            }
            return Boolean.valueOf(abstractTypeCheckerContext.isStubTypeEqualsToAnything());
        } else if (abstractTypeCheckerContext.isErrorTypeEqualsToAnything()) {
            return Boolean.TRUE;
        } else {
            if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker) && !abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2)) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(abstractTypeCheckerContext, abstractTypeCheckerContext.withNullability(simpleTypeMarker, false), abstractTypeCheckerContext.withNullability(simpleTypeMarker2, false)));
        }
    }

    private final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy substitutionSupertypePolicy;
        List<SimpleTypeMarker> fastCorrespondingSupertypes = abstractTypeCheckerContext.fastCorrespondingSupertypes(simpleTypeMarker, typeConstructorMarker);
        if (fastCorrespondingSupertypes != null) {
            return fastCorrespondingSupertypes;
        }
        if (!abstractTypeCheckerContext.isClassTypeConstructor(typeConstructorMarker) && abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (abstractTypeCheckerContext.isCommonFinalClassConstructor(typeConstructorMarker)) {
            if (abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker)) {
                SimpleTypeMarker captureFromArguments = abstractTypeCheckerContext.captureFromArguments(simpleTypeMarker, CaptureStatus.FOR_SUBTYPING);
                if (captureFromArguments != null) {
                    simpleTypeMarker = captureFromArguments;
                }
                return CollectionsKt__CollectionsJVMKt.listOf(simpleTypeMarker);
            }
            return CollectionsKt__CollectionsKt.emptyList();
        }
        SmartList smartList = new SmartList();
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
                    SimpleTypeMarker captureFromArguments2 = abstractTypeCheckerContext.captureFromArguments(current, CaptureStatus.FOR_SUBTYPING);
                    if (captureFromArguments2 == null) {
                        captureFromArguments2 = current;
                    }
                    if (abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(captureFromArguments2), typeConstructorMarker)) {
                        smartList.add(captureFromArguments2);
                        substitutionSupertypePolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                    } else if (abstractTypeCheckerContext.argumentsCount(captureFromArguments2) == 0) {
                        substitutionSupertypePolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    } else {
                        substitutionSupertypePolicy = abstractTypeCheckerContext.substitutionSupertypePolicy(captureFromArguments2);
                    }
                    if (!(!Intrinsics.areEqual(substitutionSupertypePolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        substitutionSupertypePolicy = null;
                    }
                    if (substitutionSupertypePolicy != null) {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(current))) {
                            supertypesDeque.add(substitutionSupertypePolicy.mo2114transformType(abstractTypeCheckerContext, kotlinTypeMarker));
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null)).toString());
            }
        }
        abstractTypeCheckerContext.clear();
        return smartList;
    }

    public final List<SimpleTypeMarker> findCorrespondingSupertypes(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        if (abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
            return collectAndFilter(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        }
        if (!abstractTypeCheckerContext.isClassTypeConstructor(typeConstructorMarker) && !abstractTypeCheckerContext.isIntegerLiteralTypeConstructor(typeConstructorMarker)) {
            return collectAllSupertypesWithGivenTypeConstructor(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        }
        SmartList<SimpleTypeMarker> smartList = new SmartList();
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
                    if (abstractTypeCheckerContext.isClassType(current)) {
                        smartList.add(current);
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual(supertypesPolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(current))) {
                            supertypesDeque.add(supertypesPolicy.mo2114transformType(abstractTypeCheckerContext, kotlinTypeMarker));
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt___CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null)).toString());
            }
        }
        abstractTypeCheckerContext.clear();
        ArrayList arrayList = new ArrayList();
        for (SimpleTypeMarker it : smartList) {
            AbstractTypeChecker abstractTypeChecker = INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, abstractTypeChecker.collectAndFilter(abstractTypeCheckerContext, it, typeConstructorMarker));
        }
        return arrayList;
    }

    public final boolean isSubtypeForSameConstructor(AbstractTypeCheckerContext abstractTypeCheckerContext, TypeArgumentListMarker typeArgumentListMarker, SimpleTypeMarker simpleTypeMarker) {
        boolean z;
        int i;
        int i2;
        boolean equalTypes;
        int i3;
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker);
        int parametersCount = abstractTypeCheckerContext.parametersCount(typeConstructor);
        for (int i4 = 0; i4 < parametersCount; i4++) {
            TypeArgumentMarker argument = abstractTypeCheckerContext.getArgument(simpleTypeMarker, i4);
            if (!abstractTypeCheckerContext.isStarProjection(argument)) {
                KotlinTypeMarker type = abstractTypeCheckerContext.getType(argument);
                TypeArgumentMarker typeArgumentMarker = abstractTypeCheckerContext.get(typeArgumentListMarker, i4);
                if (abstractTypeCheckerContext.getVariance(typeArgumentMarker) == TypeVariance.INV) {
                    z = true;
                } else {
                    z = false;
                }
                if (_Assertions.ENABLED && !z) {
                    throw new AssertionError("Incorrect sub argument: " + typeArgumentMarker);
                }
                KotlinTypeMarker type2 = abstractTypeCheckerContext.getType(typeArgumentMarker);
                TypeVariance effectiveVariance = effectiveVariance(abstractTypeCheckerContext.getVariance(abstractTypeCheckerContext.getParameter(typeConstructor, i4)), abstractTypeCheckerContext.getVariance(argument));
                if (effectiveVariance != null) {
                    i = abstractTypeCheckerContext.argumentsDepth;
                    if (i <= 100) {
                        i2 = abstractTypeCheckerContext.argumentsDepth;
                        abstractTypeCheckerContext.argumentsDepth = i2 + 1;
                        int i5 = WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()];
                        if (i5 != 1) {
                            if (i5 != 2) {
                                if (i5 == 3) {
                                    equalTypes = INSTANCE.isSubtypeOf(abstractTypeCheckerContext, type, type2);
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                equalTypes = INSTANCE.isSubtypeOf(abstractTypeCheckerContext, type2, type);
                            }
                        } else {
                            equalTypes = INSTANCE.equalTypes(abstractTypeCheckerContext, type2, type);
                        }
                        i3 = abstractTypeCheckerContext.argumentsDepth;
                        abstractTypeCheckerContext.argumentsDepth = i3 - 1;
                        if (!equalTypes) {
                            return false;
                        }
                    } else {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + type2).toString());
                    }
                } else {
                    return abstractTypeCheckerContext.isErrorTypeEqualsToAnything();
                }
            }
        }
        return true;
    }

    private final List<SimpleTypeMarker> collectAndFilter(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return selectOnlyPureKotlinSupertypes(abstractTypeCheckerContext, collectAllSupertypesWithGivenTypeConstructor(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker));
    }

    private final boolean completeIsSubTypeOf(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        Boolean checkSubtypeForSpecialCases = checkSubtypeForSpecialCases(abstractTypeCheckerContext, abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker), abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker2));
        if (checkSubtypeForSpecialCases != null) {
            boolean booleanValue = checkSubtypeForSpecialCases.booleanValue();
            abstractTypeCheckerContext.addSubtypeConstraint(kotlinTypeMarker, kotlinTypeMarker2);
            return booleanValue;
        }
        Boolean addSubtypeConstraint = abstractTypeCheckerContext.addSubtypeConstraint(kotlinTypeMarker, kotlinTypeMarker2);
        if (addSubtypeConstraint != null) {
            return addSubtypeConstraint.booleanValue();
        }
        return isSubtypeOfForSingleClassifierType(abstractTypeCheckerContext, abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker), abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker2));
    }

    public final boolean isSubtypeOf(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        return INSTANCE.completeIsSubTypeOf(abstractTypeCheckerContext, abstractTypeCheckerContext.prepareType(abstractTypeCheckerContext.refineType(kotlinTypeMarker)), abstractTypeCheckerContext.prepareType(abstractTypeCheckerContext.refineType(kotlinTypeMarker2)));
    }

    private final boolean hasNothingSupertype(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker);
        if (abstractTypeCheckerContext.isClassTypeConstructor(typeConstructor)) {
            return abstractTypeCheckerContext.isNothingConstructor(typeConstructor);
        }
        if (abstractTypeCheckerContext.isNothingConstructor(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker))) {
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
                    if (abstractTypeCheckerContext.isClassType(current)) {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual(supertypesPolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        for (KotlinTypeMarker kotlinTypeMarker : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(current))) {
                            SimpleTypeMarker mo2114transformType = supertypesPolicy.mo2114transformType(abstractTypeCheckerContext, kotlinTypeMarker);
                            if (abstractTypeCheckerContext.isNothingConstructor(abstractTypeCheckerContext.typeConstructor(mo2114transformType))) {
                                abstractTypeCheckerContext.clear();
                                return true;
                            }
                            supertypesDeque.add(mo2114transformType);
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

    private final boolean isCommonDenotableType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
        if (abstractTypeCheckerContext.isDenotable(abstractTypeCheckerContext.typeConstructor(kotlinTypeMarker)) && !abstractTypeCheckerContext.isDynamic(kotlinTypeMarker) && !abstractTypeCheckerContext.isDefinitelyNotNullType(kotlinTypeMarker) && Intrinsics.areEqual(abstractTypeCheckerContext.typeConstructor(abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker)), abstractTypeCheckerContext.typeConstructor(abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker)))) {
            return true;
        }
        return false;
    }

    public final TypeVariance effectiveVariance(TypeVariance typeVariance, TypeVariance typeVariance2) {
        TypeVariance typeVariance3 = TypeVariance.INV;
        if (typeVariance == typeVariance3) {
            return typeVariance2;
        }
        if (typeVariance2 == typeVariance3) {
            return typeVariance;
        }
        if (typeVariance == typeVariance2) {
            return typeVariance;
        }
        return null;
    }

    private final boolean isSubtypeOfForSingleClassifierType(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        boolean z;
        KotlinTypeMarker type;
        boolean z2;
        boolean z3;
        if (RUN_SLOW_ASSERTIONS) {
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker) && !abstractTypeCheckerContext.isIntersection(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker)) && !abstractTypeCheckerContext.isAllowedTypeVariable(simpleTypeMarker)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (_Assertions.ENABLED && !z2) {
                throw new AssertionError("Not singleClassifierType and not intersection subType: " + simpleTypeMarker);
            }
            if (!abstractTypeCheckerContext.isSingleClassifierType(simpleTypeMarker2) && !abstractTypeCheckerContext.isAllowedTypeVariable(simpleTypeMarker2)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (_Assertions.ENABLED && !z3) {
                throw new AssertionError("Not singleClassifierType superType: " + simpleTypeMarker2);
            }
        }
        if (!AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(abstractTypeCheckerContext, simpleTypeMarker, simpleTypeMarker2)) {
            return false;
        }
        Boolean checkSubtypeForIntegerLiteralType = checkSubtypeForIntegerLiteralType(abstractTypeCheckerContext, abstractTypeCheckerContext.lowerBoundIfFlexible(simpleTypeMarker), abstractTypeCheckerContext.upperBoundIfFlexible(simpleTypeMarker2));
        if (checkSubtypeForIntegerLiteralType != null) {
            boolean booleanValue = checkSubtypeForIntegerLiteralType.booleanValue();
            abstractTypeCheckerContext.addSubtypeConstraint(simpleTypeMarker, simpleTypeMarker2);
            return booleanValue;
        }
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2);
        if ((abstractTypeCheckerContext.isEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructor) && abstractTypeCheckerContext.parametersCount(typeConstructor) == 0) || abstractTypeCheckerContext.isAnyConstructor(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2))) {
            return true;
        }
        List<SimpleTypeMarker> findCorrespondingSupertypes = findCorrespondingSupertypes(abstractTypeCheckerContext, simpleTypeMarker, typeConstructor);
        int size = findCorrespondingSupertypes.size();
        if (size != 0) {
            if (size != 1) {
                ArgumentList argumentList = new ArgumentList(abstractTypeCheckerContext.parametersCount(typeConstructor));
                int parametersCount = abstractTypeCheckerContext.parametersCount(typeConstructor);
                boolean z4 = false;
                for (int i = 0; i < parametersCount; i++) {
                    if (!z4 && abstractTypeCheckerContext.getVariance(abstractTypeCheckerContext.getParameter(typeConstructor, i)) == TypeVariance.OUT) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    if (!z4) {
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(findCorrespondingSupertypes, 10));
                        for (SimpleTypeMarker simpleTypeMarker3 : findCorrespondingSupertypes) {
                            TypeArgumentMarker argumentOrNull = abstractTypeCheckerContext.getArgumentOrNull(simpleTypeMarker3, i);
                            if (argumentOrNull != null) {
                                if (abstractTypeCheckerContext.getVariance(argumentOrNull) == TypeVariance.INV) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    argumentOrNull = null;
                                }
                                if (argumentOrNull != null && (type = abstractTypeCheckerContext.getType(argumentOrNull)) != null) {
                                    arrayList.add(type);
                                }
                            }
                            throw new IllegalStateException(("Incorrect type: " + simpleTypeMarker3 + ", subType: " + simpleTypeMarker + ", superType: " + simpleTypeMarker2).toString());
                        }
                        argumentList.add(abstractTypeCheckerContext.asTypeArgument(abstractTypeCheckerContext.intersectTypes(arrayList)));
                    }
                }
                if (!z4 && isSubtypeForSameConstructor(abstractTypeCheckerContext, argumentList, simpleTypeMarker2)) {
                    return true;
                }
                if (!(findCorrespondingSupertypes instanceof Collection) || !findCorrespondingSupertypes.isEmpty()) {
                    for (SimpleTypeMarker simpleTypeMarker4 : findCorrespondingSupertypes) {
                        if (INSTANCE.isSubtypeForSameConstructor(abstractTypeCheckerContext, abstractTypeCheckerContext.asArgumentList(simpleTypeMarker4), simpleTypeMarker2)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return isSubtypeForSameConstructor(abstractTypeCheckerContext, abstractTypeCheckerContext.asArgumentList((SimpleTypeMarker) CollectionsKt___CollectionsKt.first((List<? extends Object>) findCorrespondingSupertypes)), simpleTypeMarker2);
        }
        return hasNothingSupertype(abstractTypeCheckerContext, simpleTypeMarker);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker> */
    /* JADX WARN: Multi-variable type inference failed */
    private final List<SimpleTypeMarker> selectOnlyPureKotlinSupertypes(AbstractTypeCheckerContext abstractTypeCheckerContext, List<? extends SimpleTypeMarker> list) {
        boolean z;
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TypeArgumentListMarker asArgumentList = abstractTypeCheckerContext.asArgumentList((SimpleTypeMarker) next);
            int size = abstractTypeCheckerContext.size(asArgumentList);
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (abstractTypeCheckerContext.asFlexibleType(abstractTypeCheckerContext.getType(abstractTypeCheckerContext.get(asArgumentList, i))) == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    z2 = false;
                    break;
                }
                i++;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        return list;
    }

    public final boolean equalTypes(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (INSTANCE.isCommonDenotableType(abstractTypeCheckerContext, kotlinTypeMarker) && INSTANCE.isCommonDenotableType(abstractTypeCheckerContext, kotlinTypeMarker2)) {
            KotlinTypeMarker refineType = abstractTypeCheckerContext.refineType(kotlinTypeMarker);
            KotlinTypeMarker refineType2 = abstractTypeCheckerContext.refineType(kotlinTypeMarker2);
            SimpleTypeMarker lowerBoundIfFlexible = abstractTypeCheckerContext.lowerBoundIfFlexible(refineType);
            if (!abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(refineType), abstractTypeCheckerContext.typeConstructor(refineType2))) {
                return false;
            }
            if (abstractTypeCheckerContext.argumentsCount(lowerBoundIfFlexible) == 0) {
                if (abstractTypeCheckerContext.hasFlexibleNullability(refineType) || abstractTypeCheckerContext.hasFlexibleNullability(refineType2) || abstractTypeCheckerContext.isMarkedNullable(lowerBoundIfFlexible) == abstractTypeCheckerContext.isMarkedNullable(abstractTypeCheckerContext.lowerBoundIfFlexible(refineType2))) {
                    return true;
                }
                return false;
            }
        }
        if (INSTANCE.isSubtypeOf(abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2) && INSTANCE.isSubtypeOf(abstractTypeCheckerContext, kotlinTypeMarker2, kotlinTypeMarker)) {
            return true;
        }
        return false;
    }
}
