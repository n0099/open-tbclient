package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.text.Typography;
/* loaded from: classes10.dex */
public final class RawSubstitution extends TypeSubstitution {
    public static final RawSubstitution INSTANCE = new RawSubstitution();
    public static final JavaTypeAttributes lowerTypeAttr = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
    public static final JavaTypeAttributes upperTypeAttr = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);

    /* loaded from: classes10.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JavaTypeFlexibility.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            $EnumSwitchMapping$0[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            $EnumSwitchMapping$0[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    public static /* synthetic */ TypeProjection computeProjection$default(RawSubstitution rawSubstitution, TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, KotlinType kotlinType, int i, Object obj) {
        if ((i & 4) != 0) {
            kotlinType = JavaTypeResolverKt.getErasedUpperBound$default(typeParameterDescriptor, null, null, 3, null);
        }
        return rawSubstitution.computeProjection(typeParameterDescriptor, javaTypeAttributes, kotlinType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(final SimpleType simpleType, final ClassDescriptor classDescriptor, final JavaTypeAttributes javaTypeAttributes) {
        if (simpleType.getConstructor().getParameters().isEmpty()) {
            return TuplesKt.to(simpleType, Boolean.FALSE);
        }
        if (KotlinBuiltIns.isArray(simpleType)) {
            TypeProjection typeProjection = simpleType.getArguments().get(0);
            Variance projectionKind = typeProjection.getProjectionKind();
            KotlinType type = typeProjection.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "componentTypeProjection.type");
            return TuplesKt.to(KotlinTypeFactory.simpleType$default(simpleType.getAnnotations(), simpleType.getConstructor(), CollectionsKt__CollectionsJVMKt.listOf(new TypeProjectionImpl(projectionKind, eraseType(type))), simpleType.isMarkedNullable(), null, 16, null), Boolean.FALSE);
        } else if (KotlinTypeKt.isError(simpleType)) {
            return TuplesKt.to(ErrorUtils.createErrorType("Raw error type: " + simpleType.getConstructor()), Boolean.FALSE);
        } else {
            MemberScope memberScope = classDescriptor.getMemberScope(INSTANCE);
            Intrinsics.checkExpressionValueIsNotNull(memberScope, "declaration.getMemberScope(RawSubstitution)");
            Annotations annotations = simpleType.getAnnotations();
            TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "declaration.typeConstructor");
            TypeConstructor typeConstructor2 = classDescriptor.getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "declaration.typeConstructor");
            List<TypeParameterDescriptor> parameters = typeConstructor2.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "declaration.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10));
            for (TypeParameterDescriptor parameter : parameters) {
                RawSubstitution rawSubstitution = INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(parameter, "parameter");
                arrayList.add(computeProjection$default(rawSubstitution, parameter, javaTypeAttributes, null, 4, null));
            }
            return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, arrayList, simpleType.isMarkedNullable(), memberScope, new Function1<KotlinTypeRefiner, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
                    ClassId classId;
                    ClassDescriptor findClassAcrossModuleDependencies;
                    Pair eraseInflexibleBasedOnClassDescriptor;
                    ClassDescriptor classDescriptor2 = ClassDescriptor.this;
                    if (!(classDescriptor2 instanceof ClassDescriptor)) {
                        classDescriptor2 = null;
                    }
                    if (classDescriptor2 != null && (classId = DescriptorUtilsKt.getClassId(classDescriptor2)) != null && (findClassAcrossModuleDependencies = kotlinTypeRefiner.findClassAcrossModuleDependencies(classId)) != null && !Intrinsics.areEqual(findClassAcrossModuleDependencies, ClassDescriptor.this)) {
                        eraseInflexibleBasedOnClassDescriptor = RawSubstitution.INSTANCE.eraseInflexibleBasedOnClassDescriptor(simpleType, findClassAcrossModuleDependencies, javaTypeAttributes);
                        return (SimpleType) eraseInflexibleBasedOnClassDescriptor.getFirst();
                    }
                    return null;
                }
            }), Boolean.TRUE);
        }
    }

    private final KotlinType eraseType(KotlinType kotlinType) {
        ClassifierDescriptor mo2106getDeclarationDescriptor = kotlinType.getConstructor().mo2106getDeclarationDescriptor();
        if (mo2106getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            return eraseType(JavaTypeResolverKt.getErasedUpperBound$default((TypeParameterDescriptor) mo2106getDeclarationDescriptor, null, null, 3, null));
        }
        if (mo2106getDeclarationDescriptor instanceof ClassDescriptor) {
            ClassifierDescriptor mo2106getDeclarationDescriptor2 = FlexibleTypesKt.upperIfFlexible(kotlinType).getConstructor().mo2106getDeclarationDescriptor();
            if (mo2106getDeclarationDescriptor2 instanceof ClassDescriptor) {
                Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(kotlinType), (ClassDescriptor) mo2106getDeclarationDescriptor, lowerTypeAttr);
                SimpleType component1 = eraseInflexibleBasedOnClassDescriptor.component1();
                boolean booleanValue = eraseInflexibleBasedOnClassDescriptor.component2().booleanValue();
                Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor2 = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(kotlinType), (ClassDescriptor) mo2106getDeclarationDescriptor2, upperTypeAttr);
                SimpleType component12 = eraseInflexibleBasedOnClassDescriptor2.component1();
                boolean booleanValue2 = eraseInflexibleBasedOnClassDescriptor2.component2().booleanValue();
                if (!booleanValue && !booleanValue2) {
                    return KotlinTypeFactory.flexibleType(component1, component12);
                }
                return new RawTypeImpl(component1, component12);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + mo2106getDeclarationDescriptor2 + "\" while for lower it's \"" + mo2106getDeclarationDescriptor + Typography.quote).toString());
        }
        throw new IllegalStateException(("Unexpected declaration kind: " + mo2106getDeclarationDescriptor).toString());
    }

    public final TypeProjection computeProjection(TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, KotlinType kotlinType) {
        TypeProjection makeStarProjection;
        int i = WhenMappings.$EnumSwitchMapping$0[javaTypeAttributes.getFlexibility().ordinal()];
        if (i != 1) {
            if (i != 2 && i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            if (!typeParameterDescriptor.getVariance().getAllowsOutPosition()) {
                return new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(typeParameterDescriptor).getNothingType());
            }
            List<TypeParameterDescriptor> parameters = kotlinType.getConstructor().getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "erasedUpperBound.constructor.parameters");
            if (!parameters.isEmpty()) {
                makeStarProjection = new TypeProjectionImpl(Variance.OUT_VARIANCE, kotlinType);
            } else {
                makeStarProjection = JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
            }
            return makeStarProjection;
        }
        return new TypeProjectionImpl(Variance.INVARIANT, kotlinType);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* renamed from: get */
    public TypeProjectionImpl mo2111get(KotlinType kotlinType) {
        return new TypeProjectionImpl(eraseType(kotlinType));
    }
}
