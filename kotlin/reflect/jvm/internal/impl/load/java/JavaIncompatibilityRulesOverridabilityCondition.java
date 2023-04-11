package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes9.dex */
public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isPrimitiveCompareTo(FunctionDescriptor functionDescriptor) {
            if (functionDescriptor.getValueParameters().size() != 1) {
                return false;
            }
            DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            ClassDescriptor classDescriptor = null;
            if (!(containingDeclaration instanceof ClassDescriptor)) {
                containingDeclaration = null;
            }
            ClassDescriptor classDescriptor2 = (ClassDescriptor) containingDeclaration;
            if (classDescriptor2 != null) {
                List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters, "f.valueParameters");
                Object single = CollectionsKt___CollectionsKt.single((List<? extends Object>) valueParameters);
                Intrinsics.checkExpressionValueIsNotNull(single, "f.valueParameters.single()");
                ClassifierDescriptor mo2025getDeclarationDescriptor = ((ValueParameterDescriptor) single).getType().getConstructor().mo2025getDeclarationDescriptor();
                if (mo2025getDeclarationDescriptor instanceof ClassDescriptor) {
                    classDescriptor = mo2025getDeclarationDescriptor;
                }
                ClassDescriptor classDescriptor3 = classDescriptor;
                if (classDescriptor3 != null && KotlinBuiltIns.isPrimitiveClass(classDescriptor2) && Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(classDescriptor2), DescriptorUtilsKt.getFqNameSafe(classDescriptor3))) {
                    return true;
                }
                return false;
            }
            return false;
        }

        private final JvmType mapValueParameterType(FunctionDescriptor functionDescriptor, ValueParameterDescriptor valueParameterDescriptor) {
            if (!MethodSignatureMappingKt.forceSingleValueParameterBoxing(functionDescriptor) && !isPrimitiveCompareTo(functionDescriptor)) {
                KotlinType type = valueParameterDescriptor.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "valueParameterDescriptor.type");
                return MethodSignatureMappingKt.mapToJvmType(type);
            }
            KotlinType type2 = valueParameterDescriptor.getType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "valueParameterDescriptor.type");
            return MethodSignatureMappingKt.mapToJvmType(TypeUtilsKt.makeNullable(type2));
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
            boolean z;
            if ((callableDescriptor2 instanceof JavaMethodDescriptor) && (callableDescriptor instanceof FunctionDescriptor)) {
                JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
                FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
                if (javaMethodDescriptor.getValueParameters().size() == functionDescriptor.getValueParameters().size()) {
                    z = true;
                } else {
                    z = false;
                }
                if (_Assertions.ENABLED && !z) {
                    throw new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size");
                }
                SimpleFunctionDescriptor original = javaMethodDescriptor.getOriginal();
                Intrinsics.checkExpressionValueIsNotNull(original, "subDescriptor.original");
                List<ValueParameterDescriptor> valueParameters = original.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters, "subDescriptor.original.valueParameters");
                FunctionDescriptor original2 = functionDescriptor.getOriginal();
                Intrinsics.checkExpressionValueIsNotNull(original2, "superDescriptor.original");
                List<ValueParameterDescriptor> valueParameters2 = original2.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters2, "superDescriptor.original.valueParameters");
                for (Pair pair : CollectionsKt___CollectionsKt.zip(valueParameters, valueParameters2)) {
                    ValueParameterDescriptor subParameter = (ValueParameterDescriptor) pair.component1();
                    ValueParameterDescriptor superParameter = (ValueParameterDescriptor) pair.component2();
                    Intrinsics.checkExpressionValueIsNotNull(subParameter, "subParameter");
                    boolean z2 = mapValueParameterType((FunctionDescriptor) callableDescriptor2, subParameter) instanceof JvmType.Primitive;
                    Intrinsics.checkExpressionValueIsNotNull(superParameter, "superParameter");
                    if (z2 != (mapValueParameterType(functionDescriptor, superParameter) instanceof JvmType.Primitive)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        CallableDescriptor callableDescriptor3;
        boolean z;
        if ((callableDescriptor instanceof CallableMemberDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && !KotlinBuiltIns.isBuiltIn(callableDescriptor2)) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.INSTANCE;
            FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor2;
            Name name = functionDescriptor.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "subDescriptor.name");
            if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
                BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.INSTANCE;
                Name name2 = functionDescriptor.getName();
                Intrinsics.checkExpressionValueIsNotNull(name2, "subDescriptor.name");
                if (!builtinMethodsWithDifferentJvmName.getSameAsRenamedInJvmBuiltin(name2)) {
                    return false;
                }
            }
            CallableMemberDescriptor overriddenSpecialBuiltin = SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor) callableDescriptor);
            boolean isHiddenToOvercomeSignatureClash = functionDescriptor.isHiddenToOvercomeSignatureClash();
            boolean z2 = callableDescriptor instanceof FunctionDescriptor;
            if (!z2) {
                callableDescriptor3 = null;
            } else {
                callableDescriptor3 = callableDescriptor;
            }
            FunctionDescriptor functionDescriptor2 = (FunctionDescriptor) callableDescriptor3;
            if (functionDescriptor2 != null && isHiddenToOvercomeSignatureClash == functionDescriptor2.isHiddenToOvercomeSignatureClash()) {
                z = false;
            } else {
                z = true;
            }
            if (z && (overriddenSpecialBuiltin == null || !functionDescriptor.isHiddenToOvercomeSignatureClash())) {
                return true;
            }
            if ((classDescriptor instanceof JavaClassDescriptor) && functionDescriptor.getInitialSignatureDescriptor() == null && overriddenSpecialBuiltin != null && !SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(classDescriptor, overriddenSpecialBuiltin)) {
                if ((overriddenSpecialBuiltin instanceof FunctionDescriptor) && z2 && BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor) overriddenSpecialBuiltin) != null) {
                    String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 2, null);
                    FunctionDescriptor original = ((FunctionDescriptor) callableDescriptor).getOriginal();
                    Intrinsics.checkExpressionValueIsNotNull(original, "superDescriptor.original");
                    if (Intrinsics.areEqual(computeJvmDescriptor$default, MethodSignatureMappingKt.computeJvmDescriptor$default(original, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if (isIncompatibleInAccordanceWithBuiltInOverridabilityRules(callableDescriptor, callableDescriptor2, classDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor, callableDescriptor2)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
