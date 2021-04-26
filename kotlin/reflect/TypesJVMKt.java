package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a)\u0010\u0006\u001a\u00020\u00052\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\u000f\u001a\u00020\u0005*\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b\u000f\u0010\u0010\" \u0010\u0015\u001a\u00020\u0005*\u00020\f8F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\" \u0010\u0015\u001a\u00020\u0005*\u00020\u00038B@\u0003X\u0083\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0011\u0010\u0016¨\u0006\u0018"}, d2 = {"Ljava/lang/Class;", "jClass", "", "Lkotlin/reflect/KTypeProjection;", "arguments", "Ljava/lang/reflect/Type;", "createPossiblyInnerType", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Type;", "type", "", "typeToString", "(Ljava/lang/reflect/Type;)Ljava/lang/String;", "Lkotlin/reflect/KType;", "", "forceWrapper", "computeJavaType", "(Lkotlin/reflect/KType;Z)Ljava/lang/reflect/Type;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "javaType", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "(Lkotlin/reflect/KTypeProjection;)V", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class TypesJVMKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[KVariance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KVariance.IN.ordinal()] = 1;
            $EnumSwitchMapping$0[KVariance.INVARIANT.ordinal()] = 2;
            $EnumSwitchMapping$0[KVariance.OUT.ordinal()] = 3;
            int[] iArr2 = new int[KVariance.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[KVariance.INVARIANT.ordinal()] = 1;
            $EnumSwitchMapping$1[KVariance.IN.ordinal()] = 2;
            $EnumSwitchMapping$1[KVariance.OUT.ordinal()] = 3;
        }
    }

    @ExperimentalStdlibApi
    public static final Type computeJavaType(KType kType, boolean z) {
        int i2;
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) classifier);
        }
        if (classifier instanceof KClass) {
            KClass kClass = (KClass) classifier;
            Class javaObjectType = z ? JvmClassMappingKt.getJavaObjectType(kClass) : JvmClassMappingKt.getJavaClass(kClass);
            List<KTypeProjection> arguments = kType.getArguments();
            if (arguments.isEmpty()) {
                return javaObjectType;
            }
            if (javaObjectType.isArray()) {
                if (javaObjectType.getComponentType().isPrimitive()) {
                    return javaObjectType;
                }
                KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt___CollectionsKt.singleOrNull((List<? extends Object>) arguments);
                if (kTypeProjection != null) {
                    KVariance component1 = kTypeProjection.component1();
                    KType component2 = kTypeProjection.component2();
                    if (component1 == null || (i2 = WhenMappings.$EnumSwitchMapping$0[component1.ordinal()]) == 1) {
                        return javaObjectType;
                    }
                    if (i2 != 2 && i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Intrinsics.checkNotNull(component2);
                    Type computeJavaType$default = computeJavaType$default(component2, false, 1, null);
                    return computeJavaType$default instanceof Class ? javaObjectType : new GenericArrayTypeImpl(computeJavaType$default);
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
            }
            return createPossiblyInnerType(javaObjectType, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
    }

    public static /* synthetic */ Type computeJavaType$default(KType kType, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return computeJavaType(kType, z);
    }

    @ExperimentalStdlibApi
    public static final Type createPossiblyInnerType(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass != null) {
            if (Modifier.isStatic(cls.getModifiers())) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                for (KTypeProjection kTypeProjection : list) {
                    arrayList.add(getJavaType(kTypeProjection));
                }
                return new ParameterizedTypeImpl(cls, declaringClass, arrayList);
            }
            int length = cls.getTypeParameters().length;
            Type createPossiblyInnerType = createPossiblyInnerType(declaringClass, list.subList(length, list.size()));
            List<KTypeProjection> subList = list.subList(0, length);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subList, 10));
            for (KTypeProjection kTypeProjection2 : subList) {
                arrayList2.add(getJavaType(kTypeProjection2));
            }
            return new ParameterizedTypeImpl(cls, createPossiblyInnerType, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (KTypeProjection kTypeProjection3 : list) {
            arrayList3.add(getJavaType(kTypeProjection3));
        }
        return new ParameterizedTypeImpl(cls, null, arrayList3);
    }

    public static final Type getJavaType(KType javaType) {
        Type javaType2;
        Intrinsics.checkNotNullParameter(javaType, "$this$javaType");
        return (!(javaType instanceof KTypeBase) || (javaType2 = ((KTypeBase) javaType).getJavaType()) == null) ? computeJavaType$default(javaType, false, 1, null) : javaType2;
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static /* synthetic */ void getJavaType$annotations(KType kType) {
    }

    @ExperimentalStdlibApi
    public static /* synthetic */ void getJavaType$annotations(KTypeProjection kTypeProjection) {
    }

    public static final String typeToString(Type type) {
        String name;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                Sequence generateSequence = SequencesKt__SequencesKt.generateSequence(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                name = ((Class) SequencesKt___SequencesKt.last(generateSequence)).getName() + StringsKt__StringsJVMKt.repeat("[]", SequencesKt___SequencesKt.count(generateSequence));
            } else {
                name = cls.getName();
            }
            Intrinsics.checkNotNullExpressionValue(name, "if (type.isArray) {\n    …\n        } else type.name");
            return name;
        }
        return type.toString();
    }

    public static final Type getJavaType(KTypeProjection kTypeProjection) {
        KVariance variance = kTypeProjection.getVariance();
        if (variance != null) {
            KType type = kTypeProjection.getType();
            Intrinsics.checkNotNull(type);
            int i2 = WhenMappings.$EnumSwitchMapping$1[variance.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return new WildcardTypeImpl(computeJavaType(type, true), null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return new WildcardTypeImpl(null, computeJavaType(type, true));
            }
            return computeJavaType(type, true);
        }
        return WildcardTypeImpl.Companion.getSTAR();
    }
}
