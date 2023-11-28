package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.List;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
/* loaded from: classes2.dex */
public final class FunctionTypesKt {
    @JvmOverloads
    public static final SimpleType createFunctionType(KotlinBuiltIns kotlinBuiltIns, Annotations annotations, KotlinType kotlinType, List<? extends KotlinType> list, List<Name> list2, KotlinType kotlinType2, boolean z) {
        ClassDescriptor function;
        List<TypeProjection> functionTypeArgumentProjections = getFunctionTypeArgumentProjections(kotlinType, list, list2, kotlinType2, kotlinBuiltIns);
        int size = list.size();
        if (kotlinType != null) {
            size++;
        }
        if (z) {
            function = kotlinBuiltIns.getSuspendFunction(size);
        } else {
            function = kotlinBuiltIns.getFunction(size);
        }
        Intrinsics.checkExpressionValueIsNotNull(function, "if (suspendFunction) bui…tFunction(parameterCount)");
        if (kotlinType != null) {
            FqName fqName = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
            Intrinsics.checkExpressionValueIsNotNull(fqName, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
            if (annotations.mo2109findAnnotation(fqName) == null) {
                Annotations.Companion companion = Annotations.Companion;
                FqName fqName2 = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
                Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
                annotations = companion.create(CollectionsKt___CollectionsKt.plus(annotations, new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName2, MapsKt__MapsKt.emptyMap())));
            }
        }
        return KotlinTypeFactory.simpleNotNullType(annotations, function, functionTypeArgumentProjections);
    }

    public static /* synthetic */ SimpleType createFunctionType$default(KotlinBuiltIns kotlinBuiltIns, Annotations annotations, KotlinType kotlinType, List list, List list2, KotlinType kotlinType2, boolean z, int i, Object obj) {
        boolean z2;
        if ((i & 64) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        return createFunctionType(kotlinBuiltIns, annotations, kotlinType, list, list2, kotlinType2, z2);
    }

    public static final Name extractParameterNameFromFunctionTypeArgument(KotlinType kotlinType) {
        String value;
        Annotations annotations = kotlinType.getAnnotations();
        FqName fqName = KotlinBuiltIns.FQ_NAMES.parameterName;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "KotlinBuiltIns.FQ_NAMES.parameterName");
        AnnotationDescriptor mo2109findAnnotation = annotations.mo2109findAnnotation(fqName);
        if (mo2109findAnnotation != null) {
            Object singleOrNull = CollectionsKt___CollectionsKt.singleOrNull(mo2109findAnnotation.getAllValueArguments().values());
            if (!(singleOrNull instanceof StringValue)) {
                singleOrNull = null;
            }
            StringValue stringValue = (StringValue) singleOrNull;
            if (stringValue != null && (value = stringValue.getValue()) != null) {
                if (!Name.isValidIdentifier(value)) {
                    value = null;
                }
                if (value != null) {
                    return Name.identifier(value);
                }
            }
        }
        return null;
    }

    public static final KotlinType getReceiverTypeFromFunctionType(KotlinType kotlinType) {
        boolean isBuiltinFunctionalType = isBuiltinFunctionalType(kotlinType);
        if (_Assertions.ENABLED && !isBuiltinFunctionalType) {
            throw new AssertionError("Not a function type: " + kotlinType);
        } else if (isTypeAnnotatedWithExtensionFunctionType(kotlinType)) {
            return ((TypeProjection) CollectionsKt___CollectionsKt.first((List<? extends Object>) kotlinType.getArguments())).getType();
        } else {
            return null;
        }
    }

    public static final KotlinType getReturnTypeFromFunctionType(KotlinType kotlinType) {
        boolean isBuiltinFunctionalType = isBuiltinFunctionalType(kotlinType);
        if (_Assertions.ENABLED && !isBuiltinFunctionalType) {
            throw new AssertionError("Not a function type: " + kotlinType);
        }
        KotlinType type = ((TypeProjection) CollectionsKt___CollectionsKt.last((List<? extends Object>) kotlinType.getArguments())).getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "arguments.last().type");
        return type;
    }

    public static final List<TypeProjection> getFunctionTypeArgumentProjections(KotlinType kotlinType, List<? extends KotlinType> list, List<Name> list2, KotlinType kotlinType2, KotlinBuiltIns kotlinBuiltIns) {
        int i;
        TypeProjection typeProjection;
        int size = list.size();
        int i2 = 0;
        if (kotlinType != null) {
            i = 1;
        } else {
            i = 0;
        }
        ArrayList arrayList = new ArrayList(size + i + 1);
        if (kotlinType != null) {
            typeProjection = TypeUtilsKt.asTypeProjection(kotlinType);
        } else {
            typeProjection = null;
        }
        CollectionsKt.addIfNotNull(arrayList, typeProjection);
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            KotlinType kotlinType3 = (KotlinType) obj;
            Name name = (list2 == null || (name = list2.get(i2)) == null || name.isSpecial()) ? null : null;
            if (name != null) {
                FqName fqName = KotlinBuiltIns.FQ_NAMES.parameterName;
                Intrinsics.checkExpressionValueIsNotNull(fqName, "KotlinBuiltIns.FQ_NAMES.parameterName");
                Name identifier = Name.identifier("name");
                String asString = name.asString();
                Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
                kotlinType3 = TypeUtilsKt.replaceAnnotations(kotlinType3, Annotations.Companion.create(CollectionsKt___CollectionsKt.plus(kotlinType3.getAnnotations(), new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsKt__MapsJVMKt.mapOf(TuplesKt.to(identifier, new StringValue(asString)))))));
            }
            arrayList.add(TypeUtilsKt.asTypeProjection(kotlinType3));
            i2 = i3;
        }
        arrayList.add(TypeUtilsKt.asTypeProjection(kotlinType2));
        return arrayList;
    }

    public static final FunctionClassDescriptor.Kind getFunctionalClassKind(DeclarationDescriptor declarationDescriptor) {
        if (!(declarationDescriptor instanceof ClassDescriptor) || !KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
            return null;
        }
        return getFunctionalClassKind(DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor));
    }

    public static final boolean isBuiltinExtensionFunctionalType(KotlinType kotlinType) {
        if (isBuiltinFunctionalType(kotlinType) && isTypeAnnotatedWithExtensionFunctionType(kotlinType)) {
            return true;
        }
        return false;
    }

    public static final boolean isBuiltinFunctionalType(KotlinType kotlinType) {
        FunctionClassDescriptor.Kind kind;
        ClassifierDescriptor mo2114getDeclarationDescriptor = kotlinType.getConstructor().mo2114getDeclarationDescriptor();
        if (mo2114getDeclarationDescriptor != null) {
            kind = getFunctionalClassKind(mo2114getDeclarationDescriptor);
        } else {
            kind = null;
        }
        if (kind != FunctionClassDescriptor.Kind.Function && kind != FunctionClassDescriptor.Kind.SuspendFunction) {
            return false;
        }
        return true;
    }

    public static final boolean isFunctionType(KotlinType kotlinType) {
        FunctionClassDescriptor.Kind kind;
        ClassifierDescriptor mo2114getDeclarationDescriptor = kotlinType.getConstructor().mo2114getDeclarationDescriptor();
        if (mo2114getDeclarationDescriptor != null) {
            kind = getFunctionalClassKind(mo2114getDeclarationDescriptor);
        } else {
            kind = null;
        }
        if (kind == FunctionClassDescriptor.Kind.Function) {
            return true;
        }
        return false;
    }

    public static final boolean isSuspendFunctionType(KotlinType kotlinType) {
        FunctionClassDescriptor.Kind kind;
        ClassifierDescriptor mo2114getDeclarationDescriptor = kotlinType.getConstructor().mo2114getDeclarationDescriptor();
        if (mo2114getDeclarationDescriptor != null) {
            kind = getFunctionalClassKind(mo2114getDeclarationDescriptor);
        } else {
            kind = null;
        }
        if (kind == FunctionClassDescriptor.Kind.SuspendFunction) {
            return true;
        }
        return false;
    }

    public static final boolean isTypeAnnotatedWithExtensionFunctionType(KotlinType kotlinType) {
        Annotations annotations = kotlinType.getAnnotations();
        FqName fqName = KotlinBuiltIns.FQ_NAMES.extensionFunctionType;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        if (annotations.mo2109findAnnotation(fqName) != null) {
            return true;
        }
        return false;
    }

    public static final FunctionClassDescriptor.Kind getFunctionalClassKind(FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe.isSafe() && !fqNameUnsafe.isRoot()) {
            BuiltInFictitiousFunctionClassFactory.Companion companion = BuiltInFictitiousFunctionClassFactory.Companion;
            String asString = fqNameUnsafe.shortName().asString();
            Intrinsics.checkExpressionValueIsNotNull(asString, "shortName().asString()");
            FqName parent = fqNameUnsafe.toSafe().parent();
            Intrinsics.checkExpressionValueIsNotNull(parent, "toSafe().parent()");
            return companion.getFunctionalClassKind(asString, parent);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    public static final List<TypeProjection> getValueParameterTypesFromFunctionType(KotlinType kotlinType) {
        boolean isBuiltinFunctionalType = isBuiltinFunctionalType(kotlinType);
        if (_Assertions.ENABLED && !isBuiltinFunctionalType) {
            throw new AssertionError("Not a function type: " + kotlinType);
        }
        List<TypeProjection> arguments = kotlinType.getArguments();
        ?? isBuiltinExtensionFunctionalType = isBuiltinExtensionFunctionalType(kotlinType);
        boolean z = true;
        int size = arguments.size() - 1;
        if (isBuiltinExtensionFunctionalType > size) {
            z = false;
        }
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Not an exact function type: " + kotlinType);
        }
        return arguments.subList(isBuiltinExtensionFunctionalType == true ? 1 : 0, size);
    }
}
