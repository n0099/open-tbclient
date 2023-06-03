package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes10.dex */
public final class TypeSignatureMappingKt {
    public static final <T> T boxTypeIfNeeded(JvmTypeFactory<T> jvmTypeFactory, T t, boolean z) {
        if (z) {
            return jvmTypeFactory.boxType(t);
        }
        return t;
    }

    public static final String computeInternalName(ClassDescriptor classDescriptor, TypeMappingConfiguration<?> typeMappingConfiguration) {
        DeclarationDescriptor declarationDescriptor;
        String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(classDescriptor);
        if (predefinedFullInternalNameForClass != null) {
            return predefinedFullInternalNameForClass;
        }
        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "klass.containingDeclaration");
        Name safeIdentifier = SpecialNames.safeIdentifier(classDescriptor.getName());
        Intrinsics.checkExpressionValueIsNotNull(safeIdentifier, "SpecialNames.safeIdentifier(klass.name)");
        String identifier = safeIdentifier.getIdentifier();
        Intrinsics.checkExpressionValueIsNotNull(identifier, "SpecialNames.safeIdentifier(klass.name).identifier");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            FqName fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
            if (!fqName.isRoot()) {
                StringBuilder sb = new StringBuilder();
                String asString = fqName.asString();
                Intrinsics.checkExpressionValueIsNotNull(asString, "fqName.asString()");
                sb.append(StringsKt__StringsJVMKt.replace$default(asString, (char) IStringUtil.EXTENSION_SEPARATOR, (char) WebvttCueParser.CHAR_SLASH, false, 4, (Object) null));
                sb.append(WebvttCueParser.CHAR_SLASH);
                sb.append(identifier);
                return sb.toString();
            }
            return identifier;
        }
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        } else {
            declarationDescriptor = containingDeclaration;
        }
        ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor;
        if (classDescriptor2 != null) {
            String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor2);
            if (predefinedInternalNameForClass == null) {
                predefinedInternalNameForClass = computeInternalName(classDescriptor2, typeMappingConfiguration);
            }
            return predefinedInternalNameForClass + '$' + identifier;
        }
        throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + classDescriptor);
    }

    public static /* synthetic */ String computeInternalName$default(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMappingConfiguration = TypeMappingConfigurationImpl.INSTANCE;
        }
        return computeInternalName(classDescriptor, typeMappingConfiguration);
    }

    public static final boolean hasVoidReturnType(CallableDescriptor callableDescriptor) {
        if (callableDescriptor instanceof ConstructorDescriptor) {
            return true;
        }
        KotlinType returnType = callableDescriptor.getReturnType();
        if (returnType == null) {
            Intrinsics.throwNpe();
        }
        if (KotlinBuiltIns.isUnit(returnType)) {
            KotlinType returnType2 = callableDescriptor.getReturnType();
            if (returnType2 == null) {
                Intrinsics.throwNpe();
            }
            if (!TypeUtils.isNullableType(returnType2) && !(callableDescriptor instanceof PropertyGetterDescriptor)) {
                return true;
            }
        }
        return false;
    }

    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker, JvmTypeFactory<T> jvmTypeFactory, TypeMappingMode typeMappingMode) {
        ClassId classId;
        TypeConstructorMarker typeConstructor = typeSystemCommonBackendContext.typeConstructor(kotlinTypeMarker);
        if (!typeSystemCommonBackendContext.isClassTypeConstructor(typeConstructor)) {
            return null;
        }
        PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(typeConstructor);
        boolean z = true;
        if (primitiveType != null) {
            JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(primitiveType);
            Intrinsics.checkExpressionValueIsNotNull(jvmPrimitiveType, "JvmPrimitiveType.get(primitiveType)");
            String desc = jvmPrimitiveType.getDesc();
            Intrinsics.checkExpressionValueIsNotNull(desc, "JvmPrimitiveType.get(primitiveType).desc");
            T createFromString = jvmTypeFactory.createFromString(desc);
            if (!typeSystemCommonBackendContext.isNullableType(kotlinTypeMarker) && !TypeEnhancementKt.hasEnhancedNullability(typeSystemCommonBackendContext, kotlinTypeMarker)) {
                z = false;
            }
            return (T) boxTypeIfNeeded(jvmTypeFactory, createFromString, z);
        }
        PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(typeConstructor);
        if (primitiveArrayType != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.get(primitiveArrayType);
            Intrinsics.checkExpressionValueIsNotNull(jvmPrimitiveType2, "JvmPrimitiveType.get(arrayElementType)");
            sb.append(jvmPrimitiveType2.getDesc());
            return jvmTypeFactory.createFromString(sb.toString());
        }
        if (typeSystemCommonBackendContext.isUnderKotlinPackage(typeConstructor)) {
            FqNameUnsafe classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(typeConstructor);
            if (classFqNameUnsafe != null) {
                classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(classFqNameUnsafe);
            } else {
                classId = null;
            }
            if (classId != null) {
                if (!typeMappingMode.getKotlinCollectionsToJavaCollections()) {
                    List<JavaToKotlinClassMap.PlatformMutabilityMapping> mutabilityMappings = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
                    if (!(mutabilityMappings instanceof Collection) || !mutabilityMappings.isEmpty()) {
                        for (JavaToKotlinClassMap.PlatformMutabilityMapping platformMutabilityMapping : mutabilityMappings) {
                            if (Intrinsics.areEqual(platformMutabilityMapping.getJavaClass(), classId)) {
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        return null;
                    }
                }
                JvmClassName byClassId = JvmClassName.byClassId(classId);
                Intrinsics.checkExpressionValueIsNotNull(byClassId, "JvmClassName.byClassId(classId)");
                String internalName = byClassId.getInternalName();
                Intrinsics.checkExpressionValueIsNotNull(internalName, "JvmClassName.byClassId(classId).internalName");
                return jvmTypeFactory.createObjectType(internalName);
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory<T> */
    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [T, java.lang.Object] */
    public static final <T> T mapType(KotlinType kotlinType, JvmTypeFactory<T> jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration<? extends T> typeMappingConfiguration, JvmDescriptorTypeWriter<T> jvmDescriptorTypeWriter, Function3<? super KotlinType, ? super T, ? super TypeMappingMode, Unit> function3) {
        Object obj;
        KotlinType kotlinType2;
        Object mapType;
        KotlinType preprocessType = typeMappingConfiguration.preprocessType(kotlinType);
        if (preprocessType != null) {
            return (T) mapType(preprocessType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
        }
        if (FunctionTypesKt.isSuspendFunctionType(kotlinType)) {
            return (T) mapType(SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(kotlinType, typeMappingConfiguration.releaseCoroutines()), jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
        }
        Object mapBuiltInType = mapBuiltInType(SimpleClassicTypeSystemContext.INSTANCE, kotlinType, jvmTypeFactory, typeMappingMode);
        if (mapBuiltInType != null) {
            ?? r10 = (Object) boxTypeIfNeeded(jvmTypeFactory, mapBuiltInType, typeMappingMode.getNeedPrimitiveBoxing());
            function3.invoke(kotlinType, r10, typeMappingMode);
            return r10;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (constructor instanceof IntersectionTypeConstructor) {
            return (T) mapType(TypeUtilsKt.replaceArgumentsWithStarProjections(typeMappingConfiguration.commonSupertype(((IntersectionTypeConstructor) constructor).mo2100getSupertypes())), jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
        }
        ClassifierDescriptor mo2099getDeclarationDescriptor = constructor.mo2099getDeclarationDescriptor();
        if (mo2099getDeclarationDescriptor != null) {
            Intrinsics.checkExpressionValueIsNotNull(mo2099getDeclarationDescriptor, "constructor.declarationD…structor of $kotlinType\")");
            if (ErrorUtils.isError(mo2099getDeclarationDescriptor)) {
                T t = (T) jvmTypeFactory.createObjectType("error/NonExistentClass");
                if (mo2099getDeclarationDescriptor != null) {
                    typeMappingConfiguration.processErrorType(kotlinType, (ClassDescriptor) mo2099getDeclarationDescriptor);
                    if (jvmDescriptorTypeWriter != 0) {
                        jvmDescriptorTypeWriter.writeClass(t);
                    }
                    return t;
                }
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            boolean z = mo2099getDeclarationDescriptor instanceof ClassDescriptor;
            if (z && KotlinBuiltIns.isArray(kotlinType)) {
                if (kotlinType.getArguments().size() == 1) {
                    TypeProjection typeProjection = kotlinType.getArguments().get(0);
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkExpressionValueIsNotNull(type, "memberProjection.type");
                    if (typeProjection.getProjectionKind() == Variance.IN_VARIANCE) {
                        mapType = jvmTypeFactory.createObjectType("java/lang/Object");
                        if (jvmDescriptorTypeWriter != 0) {
                            jvmDescriptorTypeWriter.writeArrayType();
                            jvmDescriptorTypeWriter.writeClass(mapType);
                            jvmDescriptorTypeWriter.writeArrayEnd();
                        }
                    } else {
                        if (jvmDescriptorTypeWriter != 0) {
                            jvmDescriptorTypeWriter.writeArrayType();
                        }
                        Variance projectionKind = typeProjection.getProjectionKind();
                        Intrinsics.checkExpressionValueIsNotNull(projectionKind, "memberProjection.projectionKind");
                        mapType = mapType(type, jvmTypeFactory, typeMappingMode.toGenericArgumentMode(projectionKind), typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
                        if (jvmDescriptorTypeWriter != 0) {
                            jvmDescriptorTypeWriter.writeArrayEnd();
                        }
                    }
                    return (T) jvmTypeFactory.createFromString(PreferencesUtil.LEFT_MOUNT + jvmTypeFactory.toString(mapType));
                }
                throw new UnsupportedOperationException("arrays must have one type argument");
            } else if (z) {
                ClassDescriptor classDescriptor = (ClassDescriptor) mo2099getDeclarationDescriptor;
                if (classDescriptor.isInline() && !typeMappingMode.getNeedInlineClassWrapping() && (kotlinType2 = (KotlinType) InlineClassMappingKt.computeExpandedTypeForInlineClass(SimpleClassicTypeSystemContext.INSTANCE, kotlinType)) != null) {
                    return (T) mapType(kotlinType2, jvmTypeFactory, typeMappingMode.wrapInlineClassesMode(), typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
                }
                if (typeMappingMode.isForAnnotationParameter() && KotlinBuiltIns.isKClass(classDescriptor)) {
                    obj = (Object) jvmTypeFactory.getJavaLangClassType();
                } else {
                    ClassDescriptor original = classDescriptor.getOriginal();
                    Intrinsics.checkExpressionValueIsNotNull(original, "descriptor.original");
                    T predefinedTypeForClass = typeMappingConfiguration.getPredefinedTypeForClass(original);
                    if (predefinedTypeForClass != null) {
                        obj = (Object) predefinedTypeForClass;
                    } else {
                        if (classDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
                            DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
                            if (containingDeclaration != null) {
                                classDescriptor = (ClassDescriptor) containingDeclaration;
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                            }
                        }
                        ClassDescriptor original2 = classDescriptor.getOriginal();
                        Intrinsics.checkExpressionValueIsNotNull(original2, "enumClassIfEnumEntry.original");
                        obj = (Object) jvmTypeFactory.createObjectType(computeInternalName(original2, typeMappingConfiguration));
                    }
                }
                function3.invoke(kotlinType, obj, typeMappingMode);
                return (T) obj;
            } else if (mo2099getDeclarationDescriptor instanceof TypeParameterDescriptor) {
                T t2 = (T) mapType(TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) mo2099getDeclarationDescriptor), jvmTypeFactory, typeMappingMode, typeMappingConfiguration, null, FunctionsKt.getDO_NOTHING_3());
                if (jvmDescriptorTypeWriter != 0) {
                    Name name = mo2099getDeclarationDescriptor.getName();
                    Intrinsics.checkExpressionValueIsNotNull(name, "descriptor.getName()");
                    jvmDescriptorTypeWriter.writeTypeVariable(name, t2);
                }
                return t2;
            } else {
                throw new UnsupportedOperationException("Unknown type " + kotlinType);
            }
        }
        throw new UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
    }

    public static /* synthetic */ Object mapType$default(KotlinType kotlinType, JvmTypeFactory jvmTypeFactory, TypeMappingMode typeMappingMode, TypeMappingConfiguration typeMappingConfiguration, JvmDescriptorTypeWriter jvmDescriptorTypeWriter, Function3 function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = FunctionsKt.getDO_NOTHING_3();
        }
        return mapType(kotlinType, jvmTypeFactory, typeMappingMode, typeMappingConfiguration, jvmDescriptorTypeWriter, function3);
    }
}
