package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes2.dex */
public final class TypeAliasExpander {
    public static final Companion Companion = new Companion(null);
    public static final TypeAliasExpander NON_REPORTING = new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);
    public final TypeAliasExpansionReportStrategy reportStrategy;
    public final boolean shouldCheckBounds;

    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void assertRecursionDepth(int i, TypeAliasDescriptor typeAliasDescriptor) {
            if (i <= 100) {
                return;
            }
            throw new AssertionError("Too deep recursion while expanding type alias " + typeAliasDescriptor.getName());
        }

        public final void checkBoundsInTypeAlias(TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, KotlinType kotlinType, KotlinType kotlinType2, TypeParameterDescriptor typeParameterDescriptor, TypeSubstitutor typeSubstitutor) {
            for (KotlinType kotlinType3 : typeParameterDescriptor.getUpperBounds()) {
                KotlinType safeSubstitute = typeSubstitutor.safeSubstitute(kotlinType3, Variance.INVARIANT);
                Intrinsics.checkExpressionValueIsNotNull(safeSubstitute, "substitutor.safeSubstitu…ound, Variance.INVARIANT)");
                if (!KotlinTypeChecker.DEFAULT.isSubtypeOf(kotlinType2, safeSubstitute)) {
                    typeAliasExpansionReportStrategy.boundsViolationInSubstitution(safeSubstitute, kotlinType, kotlinType2, typeParameterDescriptor);
                }
            }
        }
    }

    public TypeAliasExpander(TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy, boolean z) {
        this.reportStrategy = typeAliasExpansionReportStrategy;
        this.shouldCheckBounds = z;
    }

    private final DynamicType combineAnnotations(DynamicType dynamicType, Annotations annotations) {
        return dynamicType.replaceAnnotations(createCombinedAnnotations(dynamicType, annotations));
    }

    private final SimpleType combineNullability(SimpleType simpleType, KotlinType kotlinType) {
        SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(simpleType, kotlinType.isMarkedNullable());
        Intrinsics.checkExpressionValueIsNotNull(makeNullableIfNeeded, "TypeUtils.makeNullableIf…romType.isMarkedNullable)");
        return makeNullableIfNeeded;
    }

    private final SimpleType combineNullabilityAndAnnotations(SimpleType simpleType, KotlinType kotlinType) {
        return combineAnnotations(combineNullability(simpleType, kotlinType), kotlinType.getAnnotations());
    }

    private final Annotations createCombinedAnnotations(KotlinType kotlinType, Annotations annotations) {
        if (KotlinTypeKt.isError(kotlinType)) {
            return kotlinType.getAnnotations();
        }
        return AnnotationsKt.composeAnnotations(annotations, kotlinType.getAnnotations());
    }

    public final SimpleType expand(TypeAliasExpansion typeAliasExpansion, Annotations annotations) {
        return expandRecursively(typeAliasExpansion, annotations, false, 0, true);
    }

    private final void checkRepeatedAnnotations(Annotations annotations, Annotations annotations2) {
        HashSet hashSet = new HashSet();
        Iterator<AnnotationDescriptor> it = annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getFqName());
        }
        for (AnnotationDescriptor annotationDescriptor : annotations2) {
            if (hashSet.contains(annotationDescriptor.getFqName())) {
                this.reportStrategy.repeatedAnnotation(annotationDescriptor);
            }
        }
    }

    private final void checkTypeArgumentsSubstitution(KotlinType kotlinType, KotlinType kotlinType2) {
        TypeSubstitutor create = TypeSubstitutor.create(kotlinType2);
        Intrinsics.checkExpressionValueIsNotNull(create, "TypeSubstitutor.create(substitutedType)");
        int i = 0;
        for (Object obj : kotlinType2.getArguments()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (!typeProjection.isStarProjection()) {
                KotlinType type = typeProjection.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "substitutedArgument.type");
                if (!TypeUtilsKt.containsTypeAliasParameters(type)) {
                    TypeProjection typeProjection2 = kotlinType.getArguments().get(i);
                    TypeParameterDescriptor typeParameter = kotlinType.getConstructor().getParameters().get(i);
                    if (this.shouldCheckBounds) {
                        Companion companion = Companion;
                        TypeAliasExpansionReportStrategy typeAliasExpansionReportStrategy = this.reportStrategy;
                        KotlinType type2 = typeProjection2.getType();
                        Intrinsics.checkExpressionValueIsNotNull(type2, "unsubstitutedArgument.type");
                        KotlinType type3 = typeProjection.getType();
                        Intrinsics.checkExpressionValueIsNotNull(type3, "substitutedArgument.type");
                        Intrinsics.checkExpressionValueIsNotNull(typeParameter, "typeParameter");
                        companion.checkBoundsInTypeAlias(typeAliasExpansionReportStrategy, type2, type3, typeParameter, create);
                    }
                }
            }
            i = i2;
        }
    }

    private final SimpleType combineAnnotations(SimpleType simpleType, Annotations annotations) {
        if (!KotlinTypeKt.isError(simpleType)) {
            return TypeSubstitutionKt.replace$default(simpleType, (List) null, createCombinedAnnotations(simpleType, annotations), 1, (Object) null);
        }
        return simpleType;
    }

    private final SimpleType createAbbreviation(TypeAliasExpansion typeAliasExpansion, Annotations annotations, boolean z) {
        TypeConstructor typeConstructor = typeAliasExpansion.getDescriptor().getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "descriptor.typeConstructor");
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, typeAliasExpansion.getArguments(), z, MemberScope.Empty.INSTANCE);
    }

    private final TypeProjection expandNonArgumentTypeProjection(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, int i) {
        boolean z;
        UnwrappedType unwrap = typeProjection.getType().unwrap();
        if (DynamicTypesKt.isDynamic(unwrap)) {
            return typeProjection;
        }
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(unwrap);
        if (!KotlinTypeKt.isError(asSimpleType) && TypeUtilsKt.requiresTypeAliasExpansion(asSimpleType)) {
            TypeConstructor constructor = asSimpleType.getConstructor();
            ClassifierDescriptor mo2114getDeclarationDescriptor = constructor.mo2114getDeclarationDescriptor();
            int i2 = 0;
            if (constructor.getParameters().size() == asSimpleType.getArguments().size()) {
                z = true;
            } else {
                z = false;
            }
            if (_Assertions.ENABLED && !z) {
                throw new AssertionError("Unexpected malformed type: " + asSimpleType);
            } else if (!(mo2114getDeclarationDescriptor instanceof TypeParameterDescriptor)) {
                if (mo2114getDeclarationDescriptor instanceof TypeAliasDescriptor) {
                    TypeAliasDescriptor typeAliasDescriptor = (TypeAliasDescriptor) mo2114getDeclarationDescriptor;
                    if (typeAliasExpansion.isRecursion(typeAliasDescriptor)) {
                        this.reportStrategy.recursiveTypeAlias(typeAliasDescriptor);
                        Variance variance = Variance.INVARIANT;
                        return new TypeProjectionImpl(variance, ErrorUtils.createErrorType("Recursive type alias: " + typeAliasDescriptor.getName()));
                    }
                    List<TypeProjection> arguments = asSimpleType.getArguments();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10));
                    for (Object obj : arguments) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        arrayList.add(expandTypeProjection((TypeProjection) obj, typeAliasExpansion, constructor.getParameters().get(i2), i + 1));
                        i2 = i3;
                    }
                    SimpleType expandRecursively = expandRecursively(TypeAliasExpansion.Companion.create(typeAliasExpansion, typeAliasDescriptor, arrayList), asSimpleType.getAnnotations(), asSimpleType.isMarkedNullable(), i + 1, false);
                    SimpleType substituteArguments = substituteArguments(asSimpleType, typeAliasExpansion, i);
                    if (!DynamicTypesKt.isDynamic(expandRecursively)) {
                        expandRecursively = SpecialTypesKt.withAbbreviation(expandRecursively, substituteArguments);
                    }
                    return new TypeProjectionImpl(typeProjection.getProjectionKind(), expandRecursively);
                }
                SimpleType substituteArguments2 = substituteArguments(asSimpleType, typeAliasExpansion, i);
                checkTypeArgumentsSubstitution(asSimpleType, substituteArguments2);
                return new TypeProjectionImpl(typeProjection.getProjectionKind(), substituteArguments2);
            } else {
                return typeProjection;
            }
        }
        return typeProjection;
    }

    private final SimpleType expandRecursively(TypeAliasExpansion typeAliasExpansion, Annotations annotations, boolean z, int i, boolean z2) {
        boolean z3;
        TypeProjection expandTypeProjection = expandTypeProjection(new TypeProjectionImpl(Variance.INVARIANT, typeAliasExpansion.getDescriptor().getUnderlyingType()), typeAliasExpansion, null, i);
        KotlinType type = expandTypeProjection.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "expandedProjection.type");
        SimpleType asSimpleType = TypeSubstitutionKt.asSimpleType(type);
        if (KotlinTypeKt.isError(asSimpleType)) {
            return asSimpleType;
        }
        if (expandTypeProjection.getProjectionKind() == Variance.INVARIANT) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (_Assertions.ENABLED && !z3) {
            throw new AssertionError("Type alias expansion: result for " + typeAliasExpansion.getDescriptor() + " is " + expandTypeProjection.getProjectionKind() + ", should be invariant");
        }
        checkRepeatedAnnotations(asSimpleType.getAnnotations(), annotations);
        SimpleType makeNullableIfNeeded = TypeUtils.makeNullableIfNeeded(combineAnnotations(asSimpleType, annotations), z);
        Intrinsics.checkExpressionValueIsNotNull(makeNullableIfNeeded, "expandedType.combineAnno…fNeeded(it, isNullable) }");
        if (z2) {
            return SpecialTypesKt.withAbbreviation(makeNullableIfNeeded, createAbbreviation(typeAliasExpansion, annotations, z));
        }
        return makeNullableIfNeeded;
    }

    private final TypeProjection expandTypeProjection(TypeProjection typeProjection, TypeAliasExpansion typeAliasExpansion, TypeParameterDescriptor typeParameterDescriptor, int i) {
        Variance variance;
        KotlinType combineNullabilityAndAnnotations;
        Variance variance2;
        Variance variance3;
        Companion.assertRecursionDepth(i, typeAliasExpansion.getDescriptor());
        if (typeProjection.isStarProjection()) {
            if (typeParameterDescriptor == null) {
                Intrinsics.throwNpe();
            }
            TypeProjection makeStarProjection = TypeUtils.makeStarProjection(typeParameterDescriptor);
            Intrinsics.checkExpressionValueIsNotNull(makeStarProjection, "TypeUtils.makeStarProjec…ypeParameterDescriptor!!)");
            return makeStarProjection;
        }
        KotlinType type = typeProjection.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "underlyingProjection.type");
        TypeProjection replacement = typeAliasExpansion.getReplacement(type.getConstructor());
        if (replacement != null) {
            if (replacement.isStarProjection()) {
                if (typeParameterDescriptor == null) {
                    Intrinsics.throwNpe();
                }
                TypeProjection makeStarProjection2 = TypeUtils.makeStarProjection(typeParameterDescriptor);
                Intrinsics.checkExpressionValueIsNotNull(makeStarProjection2, "TypeUtils.makeStarProjec…ypeParameterDescriptor!!)");
                return makeStarProjection2;
            }
            UnwrappedType unwrap = replacement.getType().unwrap();
            Variance projectionKind = replacement.getProjectionKind();
            Intrinsics.checkExpressionValueIsNotNull(projectionKind, "argument.projectionKind");
            Variance projectionKind2 = typeProjection.getProjectionKind();
            Intrinsics.checkExpressionValueIsNotNull(projectionKind2, "underlyingProjection.projectionKind");
            if (projectionKind2 != projectionKind && projectionKind2 != (variance3 = Variance.INVARIANT)) {
                if (projectionKind == variance3) {
                    projectionKind = projectionKind2;
                } else {
                    this.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap);
                }
            }
            if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null) {
                variance = Variance.INVARIANT;
            }
            Intrinsics.checkExpressionValueIsNotNull(variance, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
            if (variance != projectionKind && variance != (variance2 = Variance.INVARIANT)) {
                if (projectionKind == variance2) {
                    projectionKind = variance2;
                } else {
                    this.reportStrategy.conflictingProjection(typeAliasExpansion.getDescriptor(), typeParameterDescriptor, unwrap);
                }
            }
            checkRepeatedAnnotations(type.getAnnotations(), unwrap.getAnnotations());
            if (unwrap instanceof DynamicType) {
                combineNullabilityAndAnnotations = combineAnnotations((DynamicType) unwrap, type.getAnnotations());
            } else {
                combineNullabilityAndAnnotations = combineNullabilityAndAnnotations(TypeSubstitutionKt.asSimpleType(unwrap), type);
            }
            return new TypeProjectionImpl(projectionKind, combineNullabilityAndAnnotations);
        }
        return expandNonArgumentTypeProjection(typeProjection, typeAliasExpansion, i);
    }

    private final SimpleType substituteArguments(SimpleType simpleType, TypeAliasExpansion typeAliasExpansion, int i) {
        TypeConstructor constructor = simpleType.getConstructor();
        List<TypeProjection> arguments = simpleType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10));
        int i2 = 0;
        for (Object obj : arguments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            TypeProjection expandTypeProjection = expandTypeProjection(typeProjection, typeAliasExpansion, constructor.getParameters().get(i2), i + 1);
            if (!expandTypeProjection.isStarProjection()) {
                expandTypeProjection = new TypeProjectionImpl(expandTypeProjection.getProjectionKind(), TypeUtils.makeNullableIfNeeded(expandTypeProjection.getType(), typeProjection.getType().isMarkedNullable()));
            }
            arrayList.add(expandTypeProjection);
            i2 = i3;
        }
        return TypeSubstitutionKt.replace$default(simpleType, (List) arrayList, (Annotations) null, 2, (Object) null);
    }
}
