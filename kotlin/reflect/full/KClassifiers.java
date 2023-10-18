package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a5\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a=\u0010\u0010\u001a\u00020\u000f*\u00020\f2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\" \u0010\u0016\u001a\u00020\u000f*\u00020\f8F@\u0007X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;", "typeAnnotations", "Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;", "typeConstructor", "", "Lkotlin/reflect/KTypeProjection;", "arguments", "", "nullable", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "createKotlinType", "(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;Ljava/util/List;Z)Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "Lkotlin/reflect/KClassifier;", "", "annotations", "Lkotlin/reflect/KType;", "createType", "(Lkotlin/reflect/KClassifier;Ljava/util/List;ZLjava/util/List;)Lkotlin/reflect/KType;", "getStarProjectedType", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KType;", "starProjectedType$annotations", "(Lkotlin/reflect/KClassifier;)V", "starProjectedType", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "KClassifiers")
/* loaded from: classes10.dex */
public final class KClassifiers {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            $EnumSwitchMapping$0[KVariance.IN.ordinal()] = 2;
            $EnumSwitchMapping$0[KVariance.OUT.ordinal()] = 3;
        }
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void starProjectedType$annotations(KClassifier kClassifier) {
    }

    public static final SimpleType createKotlinType(Annotations annotations, TypeConstructor typeConstructor, List<KTypeProjection> list, boolean z) {
        KotlinType kotlinType;
        TypeProjectionBase typeProjectionImpl;
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkExpressionValueIsNotNull(parameters, "typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            KTypeProjection kTypeProjection = (KTypeProjection) obj;
            KTypeImpl kTypeImpl = (KTypeImpl) kTypeProjection.getType();
            if (kTypeImpl != null) {
                kotlinType = kTypeImpl.getType();
            } else {
                kotlinType = null;
            }
            KVariance variance = kTypeProjection.getVariance();
            if (variance == null) {
                TypeParameterDescriptor typeParameterDescriptor = parameters.get(i);
                Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "parameters[index]");
                typeProjectionImpl = new StarProjectionImpl(typeParameterDescriptor);
            } else {
                int i3 = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            Variance variance2 = Variance.OUT_VARIANCE;
                            if (kotlinType == null) {
                                Intrinsics.throwNpe();
                            }
                            typeProjectionImpl = new TypeProjectionImpl(variance2, kotlinType);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        Variance variance3 = Variance.IN_VARIANCE;
                        if (kotlinType == null) {
                            Intrinsics.throwNpe();
                        }
                        typeProjectionImpl = new TypeProjectionImpl(variance3, kotlinType);
                    }
                } else {
                    Variance variance4 = Variance.INVARIANT;
                    if (kotlinType == null) {
                        Intrinsics.throwNpe();
                    }
                    typeProjectionImpl = new TypeProjectionImpl(variance4, kotlinType);
                }
            }
            arrayList.add(typeProjectionImpl);
            i = i2;
        }
        return KotlinTypeFactory.simpleType$default(annotations, typeConstructor, arrayList, z, null, 16, null);
    }

    @SinceKotlin(version = "1.1")
    public static final KType createType(final KClassifier kClassifier, List<KTypeProjection> list, boolean z, List<? extends Annotation> list2) {
        KClassifier kClassifier2;
        ClassifierDescriptor descriptor;
        Annotations empty;
        if (!(kClassifier instanceof KClassifierImpl)) {
            kClassifier2 = null;
        } else {
            kClassifier2 = kClassifier;
        }
        KClassifierImpl kClassifierImpl = (KClassifierImpl) kClassifier2;
        if (kClassifierImpl != null && (descriptor = kClassifierImpl.getDescriptor()) != null) {
            TypeConstructor typeConstructor = descriptor.getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "descriptor.typeConstructor");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "typeConstructor.parameters");
            if (parameters.size() == list.size()) {
                if (list2.isEmpty()) {
                    empty = Annotations.Companion.getEMPTY();
                } else {
                    empty = Annotations.Companion.getEMPTY();
                }
                return new KTypeImpl(createKotlinType(empty, typeConstructor, list, z), new Function0() { // from class: kotlin.reflect.full.KClassifiers$createType$1
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final Void invoke() {
                        throw new NotImplementedError("An operation is not implemented: " + ("Java type is not yet supported for types created with createType (classifier = " + KClassifier.this + ')'));
                    }
                });
            }
            throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + list.size() + " were provided.");
        }
        throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + kClassifier + " (" + kClassifier.getClass() + ')');
    }

    public static /* synthetic */ KType createType$default(KClassifier kClassifier, List list, boolean z, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return createType(kClassifier, list, z, list2);
    }

    public static final KType getStarProjectedType(KClassifier kClassifier) {
        KClassifier kClassifier2;
        ClassifierDescriptor descriptor;
        if (!(kClassifier instanceof KClassifierImpl)) {
            kClassifier2 = null;
        } else {
            kClassifier2 = kClassifier;
        }
        KClassifierImpl kClassifierImpl = (KClassifierImpl) kClassifier2;
        if (kClassifierImpl != null && (descriptor = kClassifierImpl.getDescriptor()) != null) {
            TypeConstructor typeConstructor = descriptor.getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "descriptor.typeConstructor");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "descriptor.typeConstructor.parameters");
            if (parameters.isEmpty()) {
                return createType$default(kClassifier, null, false, null, 7, null);
            }
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10));
            for (TypeParameterDescriptor typeParameterDescriptor : parameters) {
                arrayList.add(KTypeProjection.Companion.getSTAR());
            }
            return createType$default(kClassifier, arrayList, false, null, 6, null);
        }
        return createType$default(kClassifier, null, false, null, 7, null);
    }
}
