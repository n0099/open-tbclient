package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;
@JvmName(name = "SpecialBuiltinMembers")
/* loaded from: classes9.dex */
public final class SpecialBuiltinMembers {
    public static final FqName child(FqName fqName, String str) {
        FqName child = fqName.child(Name.identifier(str));
        Intrinsics.checkExpressionValueIsNotNull(child, "child(Name.identifier(name))");
        return child;
    }

    public static final FqName childSafe(FqNameUnsafe fqNameUnsafe, String str) {
        FqName safe = fqNameUnsafe.child(Name.identifier(str)).toSafe();
        Intrinsics.checkExpressionValueIsNotNull(safe, "child(Name.identifier(name)).toSafe()");
        return safe;
    }

    public static final NameAndSignature method(String str, String str2, String str3, String str4) {
        Name identifier = Name.identifier(str2);
        Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(name)");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        return new NameAndSignature(identifier, signatureBuildingComponents.signature(str, str2 + '(' + str3 + ')' + str4));
    }

    public static final boolean doesOverrideBuiltinWithDifferentJvmName(CallableMemberDescriptor callableMemberDescriptor) {
        if (getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor) != null) {
            return true;
        }
        return false;
    }

    public static final String getJvmMethodNameIfSpecial(CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor propertyIfAccessor;
        Name jvmName;
        CallableMemberDescriptor overriddenBuiltinThatAffectsJvmName = getOverriddenBuiltinThatAffectsJvmName(callableMemberDescriptor);
        if (overriddenBuiltinThatAffectsJvmName == null || (propertyIfAccessor = DescriptorUtilsKt.getPropertyIfAccessor(overriddenBuiltinThatAffectsJvmName)) == null) {
            return null;
        }
        if (propertyIfAccessor instanceof PropertyDescriptor) {
            return BuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(propertyIfAccessor);
        }
        if (!(propertyIfAccessor instanceof SimpleFunctionDescriptor) || (jvmName = BuiltinMethodsWithDifferentJvmName.INSTANCE.getJvmName((SimpleFunctionDescriptor) propertyIfAccessor)) == null) {
            return null;
        }
        return jvmName.asString();
    }

    public static final CallableMemberDescriptor getOverriddenBuiltinThatAffectsJvmName(CallableMemberDescriptor callableMemberDescriptor) {
        if (KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
            return getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor);
        }
        return null;
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(T t) {
        T t2 = (T) getOverriddenBuiltinWithDifferentJvmName(t);
        if (t2 != null) {
            return t2;
        }
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
        Name name = t.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "name");
        if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return null;
        }
        return (T) DescriptorUtilsKt.firstOverridden$default(t, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return Boolean.valueOf(invoke2(callableMemberDescriptor));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
                if (KotlinBuiltIns.isBuiltIn(callableMemberDescriptor) && BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo(callableMemberDescriptor) != null) {
                    return true;
                }
                return false;
            }
        }, 1, null);
    }

    public static final boolean isFromJava(CallableMemberDescriptor callableMemberDescriptor) {
        return DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor).getContainingDeclaration() instanceof JavaClassDescriptor;
    }

    public static final boolean isFromJavaOrBuiltins(CallableMemberDescriptor callableMemberDescriptor) {
        if (!isFromJava(callableMemberDescriptor) && !KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
            return false;
        }
        return true;
    }

    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(T t) {
        if (!BuiltinMethodsWithDifferentJvmName.INSTANCE.getORIGINAL_SHORT_NAMES().contains(t.getName()) && !BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES$descriptors_jvm().contains(DescriptorUtilsKt.getPropertyIfAccessor(t).getName())) {
            return null;
        }
        if ((t instanceof PropertyDescriptor) || (t instanceof PropertyAccessorDescriptor)) {
            return (T) DescriptorUtilsKt.firstOverridden$default(t, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                    return Boolean.valueOf(invoke2(callableMemberDescriptor));
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
                    return BuiltinSpecialProperties.INSTANCE.hasBuiltinSpecialPropertyFqName(DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor));
                }
            }, 1, null);
        }
        if (!(t instanceof SimpleFunctionDescriptor)) {
            return null;
        }
        return (T) DescriptorUtilsKt.firstOverridden$default(t, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return Boolean.valueOf(invoke2(callableMemberDescriptor));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
                return BuiltinMethodsWithDifferentJvmName.INSTANCE.isBuiltinFunctionWithDifferentNameInJvm((SimpleFunctionDescriptor) callableMemberDescriptor);
            }
        }, 1, null);
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(ClassDescriptor classDescriptor, CallableDescriptor callableDescriptor) {
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        if (containingDeclaration != null) {
            SimpleType defaultType = ((ClassDescriptor) containingDeclaration).getDefaultType();
            Intrinsics.checkExpressionValueIsNotNull(defaultType, "(specialCallableDescript…ssDescriptor).defaultType");
            ClassDescriptor superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(classDescriptor);
            while (true) {
                boolean z = false;
                if (superClassDescriptor == null) {
                    return false;
                }
                if (!(superClassDescriptor instanceof JavaClassDescriptor)) {
                    if (TypeCheckingProcedure.findCorrespondingSupertype(superClassDescriptor.getDefaultType(), defaultType) != null) {
                        z = true;
                    }
                    if (z) {
                        return !KotlinBuiltIns.isBuiltIn(superClassDescriptor);
                    }
                }
                superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(superClassDescriptor);
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
    }
}
