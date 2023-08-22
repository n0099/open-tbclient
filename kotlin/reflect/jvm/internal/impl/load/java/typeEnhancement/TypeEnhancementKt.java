package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes2.dex */
public final class TypeEnhancementKt {
    public static final EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS;
    public static final EnhancedTypeAnnotations ENHANCED_NULLABILITY_ANNOTATIONS;

    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MutabilityQualifier.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MutabilityQualifier.READ_ONLY.ordinal()] = 1;
            $EnumSwitchMapping$0[MutabilityQualifier.MUTABLE.ordinal()] = 2;
            int[] iArr2 = new int[NullabilityQualifier.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            $EnumSwitchMapping$1[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
        }
    }

    static {
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        ENHANCED_NULLABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName);
        FqName fqName2 = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
        ENHANCED_MUTABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName2);
    }

    public static final Annotations compositeAnnotationsOrSingle(List<? extends Annotations> list) {
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                return new CompositeAnnotations(CollectionsKt___CollectionsKt.toList(list));
            }
            return (Annotations) CollectionsKt___CollectionsKt.single((List<? extends Object>) list);
        }
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    public static final <T> EnhancementResult<T> enhancedMutability(T t) {
        return new EnhancementResult<>(t, ENHANCED_MUTABILITY_ANNOTATIONS);
    }

    public static final <T> EnhancementResult<T> enhancedNullability(T t) {
        return new EnhancementResult<>(t, ENHANCED_NULLABILITY_ANNOTATIONS);
    }

    public static final boolean hasEnhancedNullability(KotlinType kotlinType) {
        return hasEnhancedNullability(SimpleClassicTypeSystemContext.INSTANCE, kotlinType);
    }

    public static final <T> EnhancementResult<T> noChange(T t) {
        return new EnhancementResult<>(t, null);
    }

    public static final boolean shouldEnhance(TypeComponentPosition typeComponentPosition) {
        if (typeComponentPosition != TypeComponentPosition.INFLEXIBLE) {
            return true;
        }
        return false;
    }

    public static final KotlinType enhance(KotlinType kotlinType, Function1<? super Integer, JavaTypeQualifiers> function1) {
        return enhancePossiblyFlexible(kotlinType.unwrap(), function1, 0).getTypeIfChanged();
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker) {
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(kotlinTypeMarker, fqName);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x013a */
    public static final SimpleResult enhanceInflexible(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i, TypeComponentPosition typeComponentPosition) {
        boolean z;
        boolean z2;
        boolean z3;
        TypeProjection createProjection;
        if (!shouldEnhance(typeComponentPosition) && simpleType.getArguments().isEmpty()) {
            return new SimpleResult(simpleType, 1, false);
        }
        ClassifierDescriptor mo2104getDeclarationDescriptor = simpleType.getConstructor().mo2104getDeclarationDescriptor();
        if (mo2104getDeclarationDescriptor != null) {
            Intrinsics.checkExpressionValueIsNotNull(mo2104getDeclarationDescriptor, "constructor.declarationD…pleResult(this, 1, false)");
            JavaTypeQualifiers invoke = function1.invoke(Integer.valueOf(i));
            EnhancementResult<ClassifierDescriptor> enhanceMutability = enhanceMutability(mo2104getDeclarationDescriptor, invoke, typeComponentPosition);
            ClassifierDescriptor component1 = enhanceMutability.component1();
            Annotations component2 = enhanceMutability.component2();
            TypeConstructor typeConstructor = component1.getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "enhancedClassifier.typeConstructor");
            int i2 = i + 1;
            if (component2 != null) {
                z = true;
            } else {
                z = false;
            }
            List<TypeProjection> arguments = simpleType.getArguments();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10));
            int i3 = 0;
            for (Object obj : arguments) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                TypeProjection typeProjection = (TypeProjection) obj;
                if (typeProjection.isStarProjection()) {
                    i2++;
                    TypeConstructor typeConstructor2 = component1.getTypeConstructor();
                    Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "enhancedClassifier.typeConstructor");
                    createProjection = TypeUtils.makeStarProjection(typeConstructor2.getParameters().get(i3));
                } else {
                    Result enhancePossiblyFlexible = enhancePossiblyFlexible(typeProjection.getType().unwrap(), function1, i2);
                    if (!z && !enhancePossiblyFlexible.getWereChanges()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    i2 += enhancePossiblyFlexible.getSubtreeSize();
                    KotlinType type = enhancePossiblyFlexible.getType();
                    Variance projectionKind = typeProjection.getProjectionKind();
                    Intrinsics.checkExpressionValueIsNotNull(projectionKind, "arg.projectionKind");
                    createProjection = TypeUtilsKt.createProjection(type, projectionKind, typeConstructor.getParameters().get(i3));
                }
                arrayList.add(createProjection);
                i3 = i4;
            }
            EnhancementResult<Boolean> enhancedNullability = getEnhancedNullability(simpleType, invoke, typeComponentPosition);
            boolean booleanValue = enhancedNullability.component1().booleanValue();
            Annotations component22 = enhancedNullability.component2();
            if (!z && component22 == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            int i5 = i2 - i;
            if (!z2) {
                return new SimpleResult(simpleType, i5, false);
            }
            SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(compositeAnnotationsOrSingle(CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new Annotations[]{simpleType.getAnnotations(), component2, component22})), typeConstructor, arrayList, booleanValue, null, 16, null);
            UnwrappedType unwrappedType = simpleType$default;
            if (invoke.isNotNullTypeParameter()) {
                unwrappedType = new NotNullTypeParameter(simpleType$default);
            }
            if (component22 != null && invoke.isNullabilityQualifierForWarning()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                unwrappedType = TypeWithEnhancementKt.wrapEnhancement(simpleType, unwrappedType);
            }
            if (unwrappedType != null) {
                return new SimpleResult((SimpleType) unwrappedType, i5, true);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        }
        return new SimpleResult(simpleType, 1, false);
    }

    public static final EnhancementResult<ClassifierDescriptor> enhanceMutability(ClassifierDescriptor classifierDescriptor, JavaTypeQualifiers javaTypeQualifiers, TypeComponentPosition typeComponentPosition) {
        if (!shouldEnhance(typeComponentPosition)) {
            return noChange(classifierDescriptor);
        }
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            return noChange(classifierDescriptor);
        }
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        MutabilityQualifier mutability = javaTypeQualifiers.getMutability();
        if (mutability != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[mutability.ordinal()];
            if (i != 1) {
                if (i == 2 && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                    ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
                    if (javaToKotlinClassMap.isReadOnly(classDescriptor)) {
                        return enhancedMutability(javaToKotlinClassMap.convertReadOnlyToMutable(classDescriptor));
                    }
                }
            } else if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) classifierDescriptor;
                if (javaToKotlinClassMap.isMutable(classDescriptor2)) {
                    return enhancedMutability(javaToKotlinClassMap.convertMutableToReadOnly(classDescriptor2));
                }
            }
        }
        return noChange(classifierDescriptor);
    }

    public static final Result enhancePossiblyFlexible(UnwrappedType unwrappedType, Function1<? super Integer, JavaTypeQualifiers> function1, int i) {
        boolean z;
        UnwrappedType flexibleType;
        boolean z2 = false;
        if (KotlinTypeKt.isError(unwrappedType)) {
            return new Result(unwrappedType, 1, false);
        }
        if (unwrappedType instanceof FlexibleType) {
            FlexibleType flexibleType2 = (FlexibleType) unwrappedType;
            SimpleResult enhanceInflexible = enhanceInflexible(flexibleType2.getLowerBound(), function1, i, TypeComponentPosition.FLEXIBLE_LOWER);
            SimpleResult enhanceInflexible2 = enhanceInflexible(flexibleType2.getUpperBound(), function1, i, TypeComponentPosition.FLEXIBLE_UPPER);
            if (enhanceInflexible.getSubtreeSize() == enhanceInflexible2.getSubtreeSize()) {
                z = true;
            } else {
                z = false;
            }
            if (_Assertions.ENABLED && !z) {
                throw new AssertionError("Different tree sizes of bounds: lower = (" + flexibleType2.getLowerBound() + StringUtil.ARRAY_ELEMENT_SEPARATOR + enhanceInflexible.getSubtreeSize() + "), upper = (" + flexibleType2.getUpperBound() + StringUtil.ARRAY_ELEMENT_SEPARATOR + enhanceInflexible2.getSubtreeSize() + ')');
            }
            z2 = (enhanceInflexible.getWereChanges() || enhanceInflexible2.getWereChanges()) ? true : true;
            KotlinType enhancement = TypeWithEnhancementKt.getEnhancement(enhanceInflexible.getType());
            if (enhancement == null) {
                enhancement = TypeWithEnhancementKt.getEnhancement(enhanceInflexible2.getType());
            }
            if (z2) {
                if (unwrappedType instanceof RawTypeImpl) {
                    flexibleType = new RawTypeImpl(enhanceInflexible.getType(), enhanceInflexible2.getType());
                } else {
                    flexibleType = KotlinTypeFactory.flexibleType(enhanceInflexible.getType(), enhanceInflexible2.getType());
                }
                unwrappedType = TypeWithEnhancementKt.wrapEnhancement(flexibleType, enhancement);
            }
            return new Result(unwrappedType, enhanceInflexible.getSubtreeSize(), z2);
        } else if (unwrappedType instanceof SimpleType) {
            return enhanceInflexible((SimpleType) unwrappedType, function1, i, TypeComponentPosition.INFLEXIBLE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final EnhancementResult<Boolean> getEnhancedNullability(KotlinType kotlinType, JavaTypeQualifiers javaTypeQualifiers, TypeComponentPosition typeComponentPosition) {
        if (!shouldEnhance(typeComponentPosition)) {
            return noChange(Boolean.valueOf(kotlinType.isMarkedNullable()));
        }
        NullabilityQualifier nullability = javaTypeQualifiers.getNullability();
        if (nullability != null) {
            int i = WhenMappings.$EnumSwitchMapping$1[nullability.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return enhancedNullability(Boolean.FALSE);
                }
            } else {
                return enhancedNullability(Boolean.TRUE);
            }
        }
        return noChange(Boolean.valueOf(kotlinType.isMarkedNullable()));
    }
}
