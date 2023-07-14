package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes2.dex */
public final class CapturedTypeApproximationKt {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Variance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Variance.INVARIANT.ordinal()] = 1;
            $EnumSwitchMapping$0[Variance.IN_VARIANCE.ordinal()] = 2;
            $EnumSwitchMapping$0[Variance.OUT_VARIANCE.ordinal()] = 3;
            int[] iArr2 = new int[Variance.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Variance.IN_VARIANCE.ordinal()] = 1;
            $EnumSwitchMapping$1[Variance.OUT_VARIANCE.ordinal()] = 2;
        }
    }

    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(final KotlinType kotlinType) {
        Object replaceTypeArguments;
        if (FlexibleTypesKt.isFlexible(kotlinType)) {
            ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(kotlinType));
            ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(kotlinType));
            return new ApproximationBounds<>(TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(approximateCapturedTypes.getLower()), FlexibleTypesKt.upperIfFlexible(approximateCapturedTypes2.getLower())), kotlinType), TypeWithEnhancementKt.inheritEnhancement(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(approximateCapturedTypes.getUpper()), FlexibleTypesKt.upperIfFlexible(approximateCapturedTypes2.getUpper())), kotlinType));
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        boolean z = true;
        if (CapturedTypeConstructorKt.isCaptured(kotlinType)) {
            if (constructor != null) {
                TypeProjection projection = ((CapturedTypeConstructor) constructor).getProjection();
                Function1<KotlinType, KotlinType> function1 = new Function1<KotlinType, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$approximateCapturedTypes$1
                    {
                        super(1);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final KotlinType invoke(KotlinType kotlinType2) {
                        KotlinType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(kotlinType2, KotlinType.this.isMarkedNullable());
                        Intrinsics.checkExpressionValueIsNotNull(makeNullableIfNeeded, "TypeUtils.makeNullableIf…s, type.isMarkedNullable)");
                        return makeNullableIfNeeded;
                    }
                };
                KotlinType type = projection.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "typeProjection.type");
                KotlinType invoke = function1.invoke(type);
                int i = WhenMappings.$EnumSwitchMapping$1[projection.getProjectionKind().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        SimpleType nothingType = TypeUtilsKt.getBuiltIns(kotlinType).getNothingType();
                        Intrinsics.checkExpressionValueIsNotNull(nothingType, "type.builtIns.nothingType");
                        return new ApproximationBounds<>(function1.invoke((KotlinType) nothingType), invoke);
                    }
                    throw new AssertionError("Only nontrivial projections should have been captured, not: " + projection);
                }
                SimpleType nullableAnyType = TypeUtilsKt.getBuiltIns(kotlinType).getNullableAnyType();
                Intrinsics.checkExpressionValueIsNotNull(nullableAnyType, "type.builtIns.nullableAnyType");
                return new ApproximationBounds<>(invoke, nullableAnyType);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
        } else if (!kotlinType.getArguments().isEmpty() && kotlinType.getArguments().size() == constructor.getParameters().size()) {
            ArrayList<TypeArgument> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<TypeProjection> arguments = kotlinType.getArguments();
            List<TypeParameterDescriptor> parameters = constructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "typeConstructor.parameters");
            for (Pair pair : CollectionsKt___CollectionsKt.zip(arguments, parameters)) {
                TypeProjection typeProjection = (TypeProjection) pair.component1();
                TypeParameterDescriptor typeParameter = (TypeParameterDescriptor) pair.component2();
                Intrinsics.checkExpressionValueIsNotNull(typeParameter, "typeParameter");
                TypeArgument typeArgument = toTypeArgument(typeProjection, typeParameter);
                if (typeProjection.isStarProjection()) {
                    arrayList.add(typeArgument);
                    arrayList2.add(typeArgument);
                } else {
                    ApproximationBounds<TypeArgument> approximateProjection = approximateProjection(typeArgument);
                    arrayList.add(approximateProjection.component1());
                    arrayList2.add(approximateProjection.component2());
                }
            }
            if (!arrayList.isEmpty()) {
                for (TypeArgument typeArgument2 : arrayList) {
                    if (!typeArgument2.isConsistent()) {
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                replaceTypeArguments = TypeUtilsKt.getBuiltIns(kotlinType).getNothingType();
                Intrinsics.checkExpressionValueIsNotNull(replaceTypeArguments, "type.builtIns.nothingType");
            } else {
                replaceTypeArguments = replaceTypeArguments(kotlinType, arrayList);
            }
            return new ApproximationBounds<>(replaceTypeArguments, replaceTypeArguments(kotlinType, arrayList2));
        } else {
            return new ApproximationBounds<>(kotlinType, kotlinType);
        }
    }

    public static final TypeProjection approximateCapturedTypesIfNecessary(TypeProjection typeProjection, boolean z) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "typeProjection.type");
        if (!TypeUtils.contains(type, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(UnwrappedType unwrappedType) {
                return Boolean.valueOf(invoke2(unwrappedType));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(UnwrappedType it) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                return CapturedTypeConstructorKt.isCaptured(it);
            }
        })) {
            return typeProjection;
        }
        Variance projectionKind = typeProjection.getProjectionKind();
        Intrinsics.checkExpressionValueIsNotNull(projectionKind, "typeProjection.projectionKind");
        if (projectionKind == Variance.OUT_VARIANCE) {
            return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getUpper());
        }
        if (z) {
            return new TypeProjectionImpl(projectionKind, approximateCapturedTypes(type).getLower());
        }
        return substituteCapturedTypesWithProjections(typeProjection);
    }

    public static final KotlinType replaceTypeArguments(KotlinType kotlinType, List<TypeArgument> list) {
        boolean z;
        if (kotlinType.getArguments().size() == list.size()) {
            z = true;
        } else {
            z = false;
        }
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Incorrect type arguments " + list);
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (TypeArgument typeArgument : list) {
            arrayList.add(toTypeProjection(typeArgument));
        }
        return TypeSubstitutionKt.replace$default(kotlinType, arrayList, (Annotations) null, 2, (Object) null);
    }

    public static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument typeArgument) {
        ApproximationBounds<KotlinType> approximateCapturedTypes = approximateCapturedTypes(typeArgument.getInProjection());
        ApproximationBounds<KotlinType> approximateCapturedTypes2 = approximateCapturedTypes(typeArgument.getOutProjection());
        return new ApproximationBounds<>(new TypeArgument(typeArgument.getTypeParameter(), approximateCapturedTypes.component2(), approximateCapturedTypes2.component1()), new TypeArgument(typeArgument.getTypeParameter(), approximateCapturedTypes.component1(), approximateCapturedTypes2.component2()));
    }

    public static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection typeProjection) {
        TypeSubstitutor create = TypeSubstitutor.create(new TypeConstructorSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$substituteCapturedTypesWithProjections$typeSubstitutor$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
            public TypeProjection get(TypeConstructor typeConstructor) {
                if (!(typeConstructor instanceof CapturedTypeConstructor)) {
                    typeConstructor = null;
                }
                CapturedTypeConstructor capturedTypeConstructor = (CapturedTypeConstructor) typeConstructor;
                if (capturedTypeConstructor == null) {
                    return null;
                }
                if (capturedTypeConstructor.getProjection().isStarProjection()) {
                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.getProjection().getType());
                }
                return capturedTypeConstructor.getProjection();
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(create, "TypeSubstitutor.create(o…ojection\n        }\n    })");
        return create.substituteWithoutApproximation(typeProjection);
    }

    public static final TypeArgument toTypeArgument(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        int i = WhenMappings.$EnumSwitchMapping$0[TypeSubstitutor.combine(typeParameterDescriptor.getVariance(), typeProjection).ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    SimpleType nothingType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType();
                    Intrinsics.checkExpressionValueIsNotNull(nothingType, "typeParameter.builtIns.nothingType");
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkExpressionValueIsNotNull(type, "type");
                    return new TypeArgument(typeParameterDescriptor, nothingType, type);
                }
                throw new NoWhenBranchMatchedException();
            }
            KotlinType type2 = typeProjection.getType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "type");
            SimpleType nullableAnyType = DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNullableAnyType();
            Intrinsics.checkExpressionValueIsNotNull(nullableAnyType, "typeParameter.builtIns.nullableAnyType");
            return new TypeArgument(typeParameterDescriptor, type2, nullableAnyType);
        }
        KotlinType type3 = typeProjection.getType();
        Intrinsics.checkExpressionValueIsNotNull(type3, "type");
        KotlinType type4 = typeProjection.getType();
        Intrinsics.checkExpressionValueIsNotNull(type4, "type");
        return new TypeArgument(typeParameterDescriptor, type3, type4);
    }

    public static final TypeProjection toTypeProjection(final TypeArgument typeArgument) {
        TypeProjectionImpl typeProjectionImpl;
        boolean isConsistent = typeArgument.isConsistent();
        if (_Assertions.ENABLED && !isConsistent) {
            DescriptorRenderer withOptions = DescriptorRenderer.Companion.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$toTypeProjection$1$descriptorRenderer$1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                    invoke2(descriptorRendererOptions);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DescriptorRendererOptions descriptorRendererOptions) {
                    descriptorRendererOptions.setClassifierNamePolicy(ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
                }
            });
            throw new AssertionError("Only consistent enhanced type projection can be converted to type projection, but [" + withOptions.render(typeArgument.getTypeParameter()) + ": <" + withOptions.renderType(typeArgument.getInProjection()) + StringUtil.ARRAY_ELEMENT_SEPARATOR + withOptions.renderType(typeArgument.getOutProjection()) + ">] was found");
        }
        Function1<Variance, Variance> function1 = new Function1<Variance, Variance>() { // from class: kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$toTypeProjection$2
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final Variance invoke(Variance variance) {
                if (variance == TypeArgument.this.getTypeParameter().getVariance()) {
                    return Variance.INVARIANT;
                }
                return variance;
            }
        };
        if (Intrinsics.areEqual(typeArgument.getInProjection(), typeArgument.getOutProjection())) {
            return new TypeProjectionImpl(typeArgument.getInProjection());
        }
        if (KotlinBuiltIns.isNothing(typeArgument.getInProjection()) && typeArgument.getTypeParameter().getVariance() != Variance.IN_VARIANCE) {
            typeProjectionImpl = new TypeProjectionImpl(function1.invoke(Variance.OUT_VARIANCE), typeArgument.getOutProjection());
        } else if (KotlinBuiltIns.isNullableAny(typeArgument.getOutProjection())) {
            typeProjectionImpl = new TypeProjectionImpl(function1.invoke(Variance.IN_VARIANCE), typeArgument.getInProjection());
        } else {
            typeProjectionImpl = new TypeProjectionImpl(function1.invoke(Variance.OUT_VARIANCE), typeArgument.getOutProjection());
        }
        return typeProjectionImpl;
    }
}
