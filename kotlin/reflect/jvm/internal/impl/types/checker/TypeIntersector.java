package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
/* loaded from: classes10.dex */
public final class TypeIntersector {
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes10.dex */
    public static final class ResultNullability {
        public static final /* synthetic */ ResultNullability[] $VALUES;
        public static final ResultNullability ACCEPT_NULL;
        public static final ResultNullability NOT_NULL;
        public static final ResultNullability START;
        public static final ResultNullability UNKNOWN;

        static {
            START start = new START("START", 0);
            START = start;
            ACCEPT_NULL accept_null = new ACCEPT_NULL("ACCEPT_NULL", 1);
            ACCEPT_NULL = accept_null;
            UNKNOWN unknown = new UNKNOWN("UNKNOWN", 2);
            UNKNOWN = unknown;
            NOT_NULL not_null = new NOT_NULL("NOT_NULL", 3);
            NOT_NULL = not_null;
            $VALUES = new ResultNullability[]{start, accept_null, unknown, not_null};
        }

        public static ResultNullability valueOf(String str) {
            return (ResultNullability) Enum.valueOf(ResultNullability.class, str);
        }

        public static ResultNullability[] values() {
            return (ResultNullability[]) $VALUES.clone();
        }

        public abstract ResultNullability combine(UnwrappedType unwrappedType);

        /* loaded from: classes10.dex */
        public static final class ACCEPT_NULL extends ResultNullability {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public ACCEPT_NULL(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType unwrappedType) {
                return getResultNullability(unwrappedType);
            }
        }

        /* loaded from: classes10.dex */
        public static final class NOT_NULL extends ResultNullability {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public NOT_NULL combine(UnwrappedType unwrappedType) {
                return this;
            }

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public NOT_NULL(String str, int i) {
                super(str, i, null);
            }
        }

        /* loaded from: classes10.dex */
        public static final class START extends ResultNullability {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public START(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType unwrappedType) {
                return getResultNullability(unwrappedType);
            }
        }

        /* loaded from: classes10.dex */
        public static final class UNKNOWN extends ResultNullability {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public UNKNOWN(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public ResultNullability combine(UnwrappedType unwrappedType) {
                ResultNullability resultNullability = getResultNullability(unwrappedType);
                if (resultNullability == ResultNullability.ACCEPT_NULL) {
                    return this;
                }
                return resultNullability;
            }
        }

        public ResultNullability(String str, int i) {
        }

        public /* synthetic */ ResultNullability(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public final ResultNullability getResultNullability(UnwrappedType unwrappedType) {
            if (unwrappedType.isMarkedNullable()) {
                return ACCEPT_NULL;
            }
            if (NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType)) {
                return NOT_NULL;
            }
            return UNKNOWN;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0051 A[EDGE_INSN: B:27:0x0051->B:18:0x0051 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Collection<SimpleType> filterTypes(Collection<? extends SimpleType> collection, Function2<? super SimpleType, ? super SimpleType, Boolean> function2) {
        boolean z;
        ArrayList<SimpleType> arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        Intrinsics.checkExpressionValueIsNotNull(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            SimpleType upper = (SimpleType) it.next();
            boolean z2 = true;
            if (!arrayList.isEmpty()) {
                for (SimpleType lower : arrayList) {
                    if (lower != upper) {
                        Intrinsics.checkExpressionValueIsNotNull(lower, "lower");
                        Intrinsics.checkExpressionValueIsNotNull(upper, "upper");
                        if (function2.invoke(lower, upper).booleanValue()) {
                            z = true;
                            continue;
                            if (z) {
                                break;
                            }
                        }
                    }
                    z = false;
                    continue;
                    if (z) {
                    }
                }
            }
            z2 = false;
            if (z2) {
                it.remove();
            }
        }
        return arrayList;
    }

    private final SimpleType intersectTypesWithoutIntersectionType(final Set<? extends SimpleType> set) {
        if (set.size() == 1) {
            return (SimpleType) CollectionsKt___CollectionsKt.single(set);
        }
        Function0<String> function0 = new Function0<String>() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "This collections cannot be empty! input types: " + CollectionsKt___CollectionsKt.joinToString$default(set, null, null, null, 0, null, null, 63, null);
            }
        };
        Collection<SimpleType> filterTypes = filterTypes(set, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        boolean z = !filterTypes.isEmpty();
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError(function0.invoke());
        }
        SimpleType findIntersectionType = IntegerLiteralTypeConstructor.Companion.findIntersectionType(filterTypes);
        if (findIntersectionType != null) {
            return findIntersectionType;
        }
        Collection<SimpleType> filterTypes2 = filterTypes(filterTypes, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeChecker.Companion.getDefault()));
        boolean isEmpty = true ^ filterTypes2.isEmpty();
        if (_Assertions.ENABLED && !isEmpty) {
            throw new AssertionError(function0.invoke());
        }
        if (filterTypes2.size() < 2) {
            return (SimpleType) CollectionsKt___CollectionsKt.single(filterTypes2);
        }
        return new IntersectionTypeConstructor(set).createType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isStrictSupertype(KotlinType kotlinType, KotlinType kotlinType2) {
        NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = NewKotlinTypeChecker.Companion.getDefault();
        if (newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType, kotlinType2) && !newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType2, kotlinType)) {
            return true;
        }
        return false;
    }

    public final SimpleType intersectTypes$descriptors(List<? extends SimpleType> list) {
        boolean z;
        if (list.size() > 1) {
            z = true;
        } else {
            z = false;
        }
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Size should be at least 2, but it is " + list.size());
        }
        ArrayList<UnwrappedType> arrayList = new ArrayList();
        for (SimpleType simpleType : list) {
            if (simpleType.getConstructor() instanceof IntersectionTypeConstructor) {
                Collection<KotlinType> mo2100getSupertypes = simpleType.getConstructor().mo2100getSupertypes();
                Intrinsics.checkExpressionValueIsNotNull(mo2100getSupertypes, "type.constructor.supertypes");
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mo2100getSupertypes, 10));
                for (KotlinType it : mo2100getSupertypes) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    SimpleType upperIfFlexible = FlexibleTypesKt.upperIfFlexible(it);
                    if (simpleType.isMarkedNullable()) {
                        upperIfFlexible = upperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(upperIfFlexible);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(simpleType);
            }
        }
        ResultNullability resultNullability = ResultNullability.START;
        for (UnwrappedType unwrappedType : arrayList) {
            resultNullability = resultNullability.combine(unwrappedType);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SimpleType simpleType2 = (SimpleType) it2.next();
            if (resultNullability == ResultNullability.NOT_NULL) {
                simpleType2 = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType2);
            }
            linkedHashSet.add(simpleType2);
        }
        return intersectTypesWithoutIntersectionType(linkedHashSet);
    }
}
