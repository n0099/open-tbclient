package kotlin.reflect.jvm.internal.impl.types.checker;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StubType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes9.dex */
public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, TypeSystemInferenceExtensionContext {
    @Override // 
    SimpleTypeMarker asSimpleType(KotlinTypeMarker kotlinTypeMarker);

    @Override // 
    TypeConstructorMarker typeConstructor(SimpleTypeMarker simpleTypeMarker);

    /* loaded from: classes9.dex */
    public static final class DefaultImpls {
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.fastCorrespondingSupertypes(classicTypeSystemContext, simpleTypeMarker, typeConstructorMarker);
        }

        public static TypeArgumentMarker get(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentListMarker typeArgumentListMarker, int i) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.get(classicTypeSystemContext, typeArgumentListMarker, i);
        }

        public static TypeArgumentMarker getArgumentOrNull(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, int i) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.getArgumentOrNull(classicTypeSystemContext, simpleTypeMarker, i);
        }

        public static boolean hasFlexibleNullability(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.hasFlexibleNullability(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isClassType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.isClassType(classicTypeSystemContext, simpleTypeMarker);
        }

        public static boolean isDefinitelyNotNullType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDefinitelyNotNullType(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isDynamic(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDynamic(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isIntegerLiteralType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.isIntegerLiteralType(classicTypeSystemContext, simpleTypeMarker);
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemCommonBackendContext.DefaultImpls.isMarkedNullable(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isNothing(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.isNothing(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.lowerBoundIfFlexible(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static KotlinTypeMarker makeNullable(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemCommonBackendContext.DefaultImpls.makeNullable(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static int size(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentListMarker typeArgumentListMarker) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.size(classicTypeSystemContext, typeArgumentListMarker);
        }

        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.typeConstructor(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static SimpleTypeMarker upperBoundIfFlexible(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            return TypeSystemInferenceExtensionContext.DefaultImpls.upperBoundIfFlexible(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static int argumentsCount(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static CapturedTypeMarker asCapturedType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            if (simpleTypeMarker instanceof SimpleType) {
                if (!(simpleTypeMarker instanceof NewCapturedType)) {
                    simpleTypeMarker = null;
                }
                return (NewCapturedType) simpleTypeMarker;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            if (simpleTypeMarker instanceof SimpleType) {
                if (!(simpleTypeMarker instanceof DefinitelyNotNullType)) {
                    simpleTypeMarker = null;
                }
                return (DefinitelyNotNullType) simpleTypeMarker;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static DynamicTypeMarker asDynamicType(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
            if (flexibleTypeMarker instanceof FlexibleType) {
                if (!(flexibleTypeMarker instanceof DynamicType)) {
                    flexibleTypeMarker = null;
                }
                return (DynamicType) flexibleTypeMarker;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
        }

        public static FlexibleTypeMarker asFlexibleType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            if (kotlinTypeMarker instanceof KotlinType) {
                UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
                if (!(unwrap instanceof FlexibleType)) {
                    unwrap = null;
                }
                return (FlexibleType) unwrap;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static SimpleTypeMarker asSimpleType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            if (kotlinTypeMarker instanceof KotlinType) {
                UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
                if (!(unwrap instanceof SimpleType)) {
                    unwrap = null;
                }
                return (SimpleType) unwrap;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static TypeArgumentMarker asTypeArgument(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            if (kotlinTypeMarker instanceof KotlinType) {
                return TypeUtilsKt.asTypeProjection((KotlinType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static FqNameUnsafe getClassFqNameUnsafe(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo2023getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2023getDeclarationDescriptor();
                if (mo2023getDeclarationDescriptor != null) {
                    return DescriptorUtilsKt.getFqNameUnsafe((ClassDescriptor) mo2023getDeclarationDescriptor);
                }
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveArrayType(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo2023getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2023getDeclarationDescriptor();
                if (mo2023getDeclarationDescriptor != null) {
                    return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) mo2023getDeclarationDescriptor);
                }
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static PrimitiveType getPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo2023getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2023getDeclarationDescriptor();
                if (mo2023getDeclarationDescriptor != null) {
                    return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) mo2023getDeclarationDescriptor);
                }
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static KotlinTypeMarker getRepresentativeUpperBound(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker) {
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                return TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) typeParameterMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass())).toString());
        }

        public static KotlinTypeMarker getSubstitutedUnderlyingType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            if (kotlinTypeMarker instanceof KotlinType) {
                return InlineClassesUtilsKt.substitutedUnderlyingType((KotlinType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static KotlinTypeMarker getType(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).getType().unwrap();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
        }

        public static TypeParameterMarker getTypeParameterClassifier(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo2023getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2023getDeclarationDescriptor();
                if (!(mo2023getDeclarationDescriptor instanceof TypeParameterDescriptor)) {
                    mo2023getDeclarationDescriptor = null;
                }
                return (TypeParameterDescriptor) mo2023getDeclarationDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
            if (typeArgumentMarker instanceof TypeProjection) {
                Variance projectionKind = ((TypeProjection) typeArgumentMarker).getProjectionKind();
                Intrinsics.checkExpressionValueIsNotNull(projectionKind, "this.projectionKind");
                return ClassicTypeSystemContextKt.convertVariance(projectionKind);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
        }

        public static boolean isAnyConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, KotlinBuiltIns.FQ_NAMES.any);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isClassTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).mo2023getDeclarationDescriptor() instanceof ClassDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isDenotable(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).isDenotable();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isError(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            if (kotlinTypeMarker instanceof KotlinType) {
                return KotlinTypeKt.isError((KotlinType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean isMarkedNullable(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).isMarkedNullable();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static boolean isNothingConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, KotlinBuiltIns.FQ_NAMES.nothing);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isNullableType(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
            if (kotlinTypeMarker instanceof KotlinType) {
                return TypeUtils.isNullableType((KotlinType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean isPrimitiveType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            if (simpleTypeMarker instanceof KotlinType) {
                return KotlinBuiltIns.isPrimitiveType((KotlinType) simpleTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static boolean isStarProjection(ClassicTypeSystemContext classicTypeSystemContext, TypeArgumentMarker typeArgumentMarker) {
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).isStarProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
        }

        public static boolean isUnderKotlinPackage(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo2023getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2023getDeclarationDescriptor();
                if (mo2023getDeclarationDescriptor != null && KotlinBuiltIns.isUnderKotlinPackage(mo2023getDeclarationDescriptor)) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static SimpleTypeMarker lowerBound(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
            if (flexibleTypeMarker instanceof FlexibleType) {
                return ((FlexibleType) flexibleTypeMarker).getLowerBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
        }

        public static KotlinTypeMarker lowerType(ClassicTypeSystemContext classicTypeSystemContext, CapturedTypeMarker capturedTypeMarker) {
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).getLowerType();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass())).toString());
        }

        public static int parametersCount(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static Collection<KotlinTypeMarker> possibleIntegerTypes(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            TypeConstructorMarker typeConstructor = classicTypeSystemContext.typeConstructor(simpleTypeMarker);
            if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) typeConstructor).getPossibleTypes();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static Collection<KotlinTypeMarker> supertypes(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                Collection<KotlinType> mo2024getSupertypes = ((TypeConstructor) typeConstructorMarker).mo2024getSupertypes();
                Intrinsics.checkExpressionValueIsNotNull(mo2024getSupertypes, "this.supertypes");
                return mo2024getSupertypes;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).getConstructor();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static SimpleTypeMarker upperBound(ClassicTypeSystemContext classicTypeSystemContext, FlexibleTypeMarker flexibleTypeMarker) {
            if (flexibleTypeMarker instanceof FlexibleType) {
                return ((FlexibleType) flexibleTypeMarker).getUpperBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
        }

        public static TypeArgumentListMarker asArgumentList(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            if (simpleTypeMarker instanceof SimpleType) {
                return (TypeArgumentListMarker) simpleTypeMarker;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static KotlinTypeMarker intersectTypes(ClassicTypeSystemContext classicTypeSystemContext, List<? extends KotlinTypeMarker> list) {
            return IntersectionTypeKt.intersectTypes(list);
        }

        public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntegerLiteralTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isIntersection(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntersectionTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isStubType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            if (simpleTypeMarker instanceof SimpleType) {
                return simpleTypeMarker instanceof StubType;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static SimpleTypeMarker captureFromArguments(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, CaptureStatus captureStatus) {
            if (simpleTypeMarker instanceof SimpleType) {
                return NewCapturedTypeKt.captureFromArguments((SimpleType) simpleTypeMarker, captureStatus);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static TypeArgumentMarker getArgument(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, int i) {
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments().get(i);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static TypeParameterMarker getParameter(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker, int i) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) typeConstructorMarker).getParameters().get(i);
                Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "this.parameters[index]");
                return typeParameterDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean hasAnnotation(ClassicTypeSystemContext classicTypeSystemContext, KotlinTypeMarker kotlinTypeMarker, FqName fqName) {
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getAnnotations().hasAnnotation(fqName);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static SimpleTypeMarker withNullability(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, boolean z) {
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).makeNullableAsSpecified(z);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static TypeVariance getVariance(ClassicTypeSystemContext classicTypeSystemContext, TypeParameterMarker typeParameterMarker) {
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                Variance variance = ((TypeParameterDescriptor) typeParameterMarker).getVariance();
                Intrinsics.checkExpressionValueIsNotNull(variance, "this.variance");
                return ClassicTypeSystemContextKt.convertVariance(variance);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass())).toString());
        }

        public static boolean identicalArguments(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
            if (simpleTypeMarker instanceof SimpleType) {
                if (simpleTypeMarker2 instanceof SimpleType) {
                    if (((SimpleType) simpleTypeMarker).getArguments() == ((SimpleType) simpleTypeMarker2).getArguments()) {
                        return true;
                    }
                    return false;
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker2.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo2023getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2023getDeclarationDescriptor();
                if (!(mo2023getDeclarationDescriptor instanceof ClassDescriptor)) {
                    mo2023getDeclarationDescriptor = null;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) mo2023getDeclarationDescriptor;
                if (classDescriptor == null || !ModalityKt.isFinalClass(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isInlineClass(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor mo2023getDeclarationDescriptor = ((TypeConstructor) typeConstructorMarker).mo2023getDeclarationDescriptor();
                if (!(mo2023getDeclarationDescriptor instanceof ClassDescriptor)) {
                    mo2023getDeclarationDescriptor = null;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) mo2023getDeclarationDescriptor;
                if (classDescriptor != null && classDescriptor.isInline()) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isEqualTypeConstructors(ClassicTypeSystemContext classicTypeSystemContext, TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2) {
            if (typeConstructorMarker instanceof TypeConstructor) {
                if (typeConstructorMarker2 instanceof TypeConstructor) {
                    return Intrinsics.areEqual(typeConstructorMarker, typeConstructorMarker2);
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker2.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isSingleClassifierType(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            if (simpleTypeMarker instanceof SimpleType) {
                if (!KotlinTypeKt.isError((KotlinType) simpleTypeMarker)) {
                    SimpleType simpleType = (SimpleType) simpleTypeMarker;
                    if (!(simpleType.getConstructor().mo2023getDeclarationDescriptor() instanceof TypeAliasDescriptor) && (simpleType.getConstructor().mo2023getDeclarationDescriptor() != null || (simpleTypeMarker instanceof CapturedType) || (simpleTypeMarker instanceof NewCapturedType) || (simpleTypeMarker instanceof DefinitelyNotNullType) || (simpleType.getConstructor() instanceof IntegerLiteralTypeConstructor))) {
                        return true;
                    }
                }
                return false;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + StringUtil.ARRAY_ELEMENT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static AbstractTypeCheckerContext newBaseTypeCheckerContext(ClassicTypeSystemContext classicTypeSystemContext, boolean z, boolean z2) {
            return new ClassicTypeCheckerContext(z, z2, false, null, 12, null);
        }
    }
}
