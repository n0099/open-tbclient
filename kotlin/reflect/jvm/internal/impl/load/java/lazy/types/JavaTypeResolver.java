package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes2.dex */
public final class JavaTypeResolver {
    public final LazyJavaResolverContext c;
    public final TypeParameterResolver typeParameterResolver;

    public JavaTypeResolver(LazyJavaResolverContext lazyJavaResolverContext, TypeParameterResolver typeParameterResolver) {
        this.c = lazyJavaResolverContext;
        this.typeParameterResolver = typeParameterResolver;
    }

    private final boolean isConflictingArgumentFor(Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor.getVariance() == Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) {
            return false;
        }
        return true;
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType javaClassifierType, ClassDescriptor classDescriptor) {
        Variance variance;
        if (!JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1.INSTANCE.invoke2((JavaType) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) javaClassifierType.getTypeArguments()))) {
            return false;
        }
        TypeConstructor typeConstructor = JavaToKotlinClassMap.INSTANCE.convertReadOnlyToMutable(classDescriptor).getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "JavaToKotlinClassMap.con…         .typeConstructor");
        List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
        Intrinsics.checkExpressionValueIsNotNull(parameters, "JavaToKotlinClassMap.con…ypeConstructor.parameters");
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) parameters);
        if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(variance, "JavaToKotlinClassMap.con….variance ?: return false");
        if (variance == Variance.OUT_VARIANCE) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
        if ((!r3.isEmpty()) != false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<TypeProjection> computeArguments(JavaClassifierType javaClassifierType, final JavaTypeAttributes javaTypeAttributes, final TypeConstructor typeConstructor) {
        boolean z;
        boolean z2;
        JavaTypeAttributes withFlexibility;
        final boolean isRaw = javaClassifierType.isRaw();
        if (!isRaw) {
            if (javaClassifierType.getTypeArguments().isEmpty()) {
                List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
                Intrinsics.checkExpressionValueIsNotNull(parameters, "constructor.parameters");
            }
            z = false;
            List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters2, "constructor.parameters");
            if (!z) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters2, 10));
                for (final TypeParameterDescriptor parameter : parameters2) {
                    LazyWrappedType lazyWrappedType = new LazyWrappedType(this.c.getStorageManager(), new Function0<KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$$inlined$map$lambda$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final KotlinType invoke() {
                            TypeParameterDescriptor parameter2 = TypeParameterDescriptor.this;
                            Intrinsics.checkExpressionValueIsNotNull(parameter2, "parameter");
                            return JavaTypeResolverKt.getErasedUpperBound(parameter2, javaTypeAttributes.getUpperBoundOfTypeParameter(), new Function0<KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$computeArguments$$inlined$map$lambda$1.1
                                {
                                    super(0);
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // kotlin.jvm.functions.Function0
                                public final KotlinType invoke() {
                                    ClassifierDescriptor mo2105getDeclarationDescriptor = typeConstructor.mo2105getDeclarationDescriptor();
                                    if (mo2105getDeclarationDescriptor == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    Intrinsics.checkExpressionValueIsNotNull(mo2105getDeclarationDescriptor, "constructor.declarationDescriptor!!");
                                    SimpleType defaultType = mo2105getDeclarationDescriptor.getDefaultType();
                                    Intrinsics.checkExpressionValueIsNotNull(defaultType, "constructor.declarationDescriptor!!.defaultType");
                                    return TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType);
                                }
                            });
                        }
                    });
                    RawSubstitution rawSubstitution = RawSubstitution.INSTANCE;
                    Intrinsics.checkExpressionValueIsNotNull(parameter, "parameter");
                    if (isRaw) {
                        withFlexibility = javaTypeAttributes;
                    } else {
                        withFlexibility = javaTypeAttributes.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
                    }
                    arrayList.add(rawSubstitution.computeProjection(parameter, withFlexibility, lazyWrappedType));
                }
                return CollectionsKt___CollectionsKt.toList(arrayList);
            } else if (parameters2.size() != javaClassifierType.getTypeArguments().size()) {
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters2, 10));
                for (TypeParameterDescriptor p : parameters2) {
                    Intrinsics.checkExpressionValueIsNotNull(p, "p");
                    arrayList2.add(new TypeProjectionImpl(ErrorUtils.createErrorType(p.getName().asString())));
                }
                return CollectionsKt___CollectionsKt.toList(arrayList2);
            } else {
                Iterable<IndexedValue> withIndex = CollectionsKt___CollectionsKt.withIndex(javaClassifierType.getTypeArguments());
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10));
                for (IndexedValue indexedValue : withIndex) {
                    int component1 = indexedValue.component1();
                    JavaType javaType = (JavaType) indexedValue.component2();
                    if (component1 < parameters2.size()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (_Assertions.ENABLED && !z2) {
                        throw new AssertionError("Argument index should be less then type parameters count, but " + component1 + " > " + parameters2.size());
                    }
                    TypeParameterDescriptor parameter2 = parameters2.get(component1);
                    JavaTypeAttributes attributes$default = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null);
                    Intrinsics.checkExpressionValueIsNotNull(parameter2, "parameter");
                    arrayList3.add(transformToTypeProjection(javaType, attributes$default, parameter2));
                }
                return CollectionsKt___CollectionsKt.toList(arrayList3);
            }
        }
        z = true;
        List<TypeParameterDescriptor> parameters22 = typeConstructor.getParameters();
        Intrinsics.checkExpressionValueIsNotNull(parameters22, "constructor.parameters");
        if (!z) {
        }
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, SimpleType simpleType) {
        Annotations lazyJavaAnnotations;
        if (simpleType == null || (lazyJavaAnnotations = simpleType.getAnnotations()) == null) {
            lazyJavaAnnotations = new LazyJavaAnnotations(this.c, javaClassifierType);
        }
        Annotations annotations = lazyJavaAnnotations;
        TypeConstructor computeTypeConstructor = computeTypeConstructor(javaClassifierType, javaTypeAttributes);
        TypeConstructor typeConstructor = null;
        if (computeTypeConstructor == null) {
            return null;
        }
        boolean isNullable = isNullable(javaTypeAttributes);
        if (simpleType != null) {
            typeConstructor = simpleType.getConstructor();
        }
        if (Intrinsics.areEqual(typeConstructor, computeTypeConstructor) && !javaClassifierType.isRaw() && isNullable) {
            return simpleType.makeNullableAsSpecified(true);
        }
        return KotlinTypeFactory.simpleType$default(annotations, computeTypeConstructor, computeArguments(javaClassifierType, javaTypeAttributes, computeTypeConstructor), isNullable, null, 16, null);
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes javaTypeAttributes, TypeParameterDescriptor typeParameterDescriptor) {
        Variance variance;
        if (javaType instanceof JavaWildcardType) {
            JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
            JavaType bound = javaWildcardType.getBound();
            if (javaWildcardType.isExtends()) {
                variance = Variance.OUT_VARIANCE;
            } else {
                variance = Variance.IN_VARIANCE;
            }
            if (bound != null && !isConflictingArgumentFor(variance, typeParameterDescriptor)) {
                return TypeUtilsKt.createProjection(transformJavaType(bound, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null)), variance, typeParameterDescriptor);
            }
            return JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
        }
        return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(javaType, javaTypeAttributes));
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        TypeConstructor typeConstructor;
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier != null) {
            if (classifier instanceof JavaClass) {
                JavaClass javaClass = (JavaClass) classifier;
                FqName fqName = javaClass.getFqName();
                if (fqName != null) {
                    ClassDescriptor mapKotlinClass = mapKotlinClass(javaClassifierType, javaTypeAttributes, fqName);
                    if (mapKotlinClass == null) {
                        mapKotlinClass = this.c.getComponents().getModuleClassResolver().resolveClass(javaClass);
                    }
                    if (mapKotlinClass == null || (typeConstructor = mapKotlinClass.getTypeConstructor()) == null) {
                        return createNotFoundClass(javaClassifierType);
                    }
                    return typeConstructor;
                }
                throw new AssertionError("Class type should have a FQ name: " + classifier);
            } else if (classifier instanceof JavaTypeParameter) {
                TypeParameterDescriptor resolveTypeParameter = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) classifier);
                if (resolveTypeParameter != null) {
                    return resolveTypeParameter.getTypeConstructor();
                }
                return null;
            } else {
                throw new IllegalStateException("Unknown classifier kind: " + classifier);
            }
        }
        return createNotFoundClass(javaClassifierType);
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaClassifierType) {
        ClassId classId = ClassId.topLevel(new FqName(javaClassifierType.getClassifierQualifiedName()));
        Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(FqName(…classifierQualifiedName))");
        TypeConstructor typeConstructor = this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsKt__CollectionsJVMKt.listOf(0)).getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "c.components.deserialize…istOf(0)).typeConstructor");
        return typeConstructor;
    }

    private final boolean isNullable(JavaTypeAttributes javaTypeAttributes) {
        if (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return false;
        }
        return true;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, FqName fqName) {
        if (javaTypeAttributes.isForAnnotationParameter() && Intrinsics.areEqual(fqName, JavaTypeResolverKt.access$getJAVA_LANG_CLASS_FQ_NAME$p())) {
            return this.c.getComponents().getReflectionTypes().getKClass();
        }
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMap.mapJavaToKotlin$default(javaToKotlinClassMap, fqName, this.c.getModule().getBuiltIns(), null, 4, null);
        if (mapJavaToKotlin$default != null) {
            if (javaToKotlinClassMap.isReadOnly(mapJavaToKotlin$default) && (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE || argumentsMakeSenseOnlyForMutableContainer(javaClassifierType, mapJavaToKotlin$default))) {
                return javaToKotlinClassMap.convertReadOnlyToMutable(mapJavaToKotlin$default);
            }
            return mapJavaToKotlin$default;
        }
        return null;
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, z);
    }

    private final KotlinType transformJavaClassifierType(final JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        boolean z;
        Function0<SimpleType> function0 = new Function0<SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver$transformJavaClassifierType$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final SimpleType invoke() {
                SimpleType createErrorType = ErrorUtils.createErrorType("Unresolved java class " + JavaClassifierType.this.getPresentableText());
                Intrinsics.checkExpressionValueIsNotNull(createErrorType, "ErrorUtils.createErrorTy…vaType.presentableText}\")");
                return createErrorType;
            }
        };
        if (!javaTypeAttributes.isForAnnotationParameter() && javaTypeAttributes.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE) {
            z = true;
        } else {
            z = false;
        }
        boolean isRaw = javaClassifierType.isRaw();
        if (!isRaw && !z) {
            SimpleType computeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes, null);
            if (computeSimpleJavaClassifierType == null) {
                return function0.invoke();
            }
            return computeSimpleJavaClassifierType;
        }
        SimpleType computeSimpleJavaClassifierType2 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (computeSimpleJavaClassifierType2 != null) {
            SimpleType computeSimpleJavaClassifierType3 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), computeSimpleJavaClassifierType2);
            if (computeSimpleJavaClassifierType3 != null) {
                if (isRaw) {
                    return new RawTypeImpl(computeSimpleJavaClassifierType2, computeSimpleJavaClassifierType3);
                }
                return KotlinTypeFactory.flexibleType(computeSimpleJavaClassifierType2, computeSimpleJavaClassifierType3);
            }
            return function0.invoke();
        }
        return function0.invoke();
    }

    public final KotlinType transformArrayType(JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z) {
        JavaType javaType;
        PrimitiveType primitiveType;
        Variance variance;
        JavaType componentType = javaArrayType.getComponentType();
        if (!(componentType instanceof JavaPrimitiveType)) {
            javaType = null;
        } else {
            javaType = componentType;
        }
        JavaPrimitiveType javaPrimitiveType = (JavaPrimitiveType) javaType;
        if (javaPrimitiveType != null) {
            primitiveType = javaPrimitiveType.getType();
        } else {
            primitiveType = null;
        }
        if (primitiveType != null) {
            SimpleType primitiveArrayKotlinType = this.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(primitiveType);
            Intrinsics.checkExpressionValueIsNotNull(primitiveArrayKotlinType, "c.module.builtIns.getPri…KotlinType(primitiveType)");
            if (!javaTypeAttributes.isForAnnotationParameter()) {
                return KotlinTypeFactory.flexibleType(primitiveArrayKotlinType, primitiveArrayKotlinType.makeNullableAsSpecified(true));
            }
            return primitiveArrayKotlinType;
        }
        KotlinType transformJavaType = transformJavaType(componentType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, javaTypeAttributes.isForAnnotationParameter(), null, 2, null));
        if (javaTypeAttributes.isForAnnotationParameter()) {
            if (z) {
                variance = Variance.OUT_VARIANCE;
            } else {
                variance = Variance.INVARIANT;
            }
            SimpleType arrayType = this.c.getModule().getBuiltIns().getArrayType(variance, transformJavaType);
            Intrinsics.checkExpressionValueIsNotNull(arrayType, "c.module.builtIns.getArr…ctionKind, componentType)");
            return arrayType;
        }
        SimpleType arrayType2 = this.c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, transformJavaType);
        Intrinsics.checkExpressionValueIsNotNull(arrayType2, "c.module.builtIns.getArr…INVARIANT, componentType)");
        return KotlinTypeFactory.flexibleType(arrayType2, this.c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, transformJavaType).makeNullableAsSpecified(true));
    }

    public final KotlinType transformJavaType(JavaType javaType, JavaTypeAttributes javaTypeAttributes) {
        KotlinType transformJavaType;
        SimpleType unitType;
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            if (type != null) {
                unitType = this.c.getModule().getBuiltIns().getPrimitiveKotlinType(type);
            } else {
                unitType = this.c.getModule().getBuiltIns().getUnitType();
            }
            Intrinsics.checkExpressionValueIsNotNull(unitType, "if (primitiveType != nul….module.builtIns.unitType");
            return unitType;
        } else if (javaType instanceof JavaClassifierType) {
            return transformJavaClassifierType((JavaClassifierType) javaType, javaTypeAttributes);
        } else {
            if (javaType instanceof JavaArrayType) {
                return transformArrayType$default(this, (JavaArrayType) javaType, javaTypeAttributes, false, 4, null);
            }
            if (javaType instanceof JavaWildcardType) {
                JavaType bound = ((JavaWildcardType) javaType).getBound();
                if (bound == null || (transformJavaType = transformJavaType(bound, javaTypeAttributes)) == null) {
                    SimpleType defaultBound = this.c.getModule().getBuiltIns().getDefaultBound();
                    Intrinsics.checkExpressionValueIsNotNull(defaultBound, "c.module.builtIns.defaultBound");
                    return defaultBound;
                }
                return transformJavaType;
            } else if (javaType == null) {
                SimpleType defaultBound2 = this.c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkExpressionValueIsNotNull(defaultBound2, "c.module.builtIns.defaultBound");
                return defaultBound2;
            } else {
                throw new UnsupportedOperationException("Unsupported type: " + javaType);
            }
        }
    }
}
