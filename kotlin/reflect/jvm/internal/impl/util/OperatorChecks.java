package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck;
/* loaded from: classes2.dex */
public final class OperatorChecks extends AbstractModifierChecks {
    public static final OperatorChecks INSTANCE = new OperatorChecks();
    public static final List<Checks> checks = CollectionsKt__CollectionsKt.listOf((Object[]) new Checks[]{new Checks(OperatorNameConventions.GET, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(1)}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.SET, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, new ValueParameterCountCheck.AtLeast(2)}, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(FunctionDescriptor functionDescriptor) {
            boolean z;
            List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(valueParameters, "valueParameters");
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) valueParameters);
            boolean z2 = false;
            if (valueParameterDescriptor != null) {
                if (!DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    z2 = true;
                }
            }
            OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
            if (!z2) {
                return "last parameter should not have a default value or be a vararg";
            }
            return null;
        }
    }), new Checks(OperatorNameConventions.GET_VALUE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(2), IsKPropertyCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.SET_VALUE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.AtLeast(3), IsKPropertyCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.PROVIDE_DELEGATE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new ValueParameterCountCheck.Equals(2), IsKPropertyCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.INVOKE, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.CONTAINS, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.ITERATOR, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.NEXT, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.HAS_NEXT, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE, ReturnsCheck.ReturnsBoolean.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.RANGE_TO, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.EQUALS, new Check[]{MemberKindCheck.Member.INSTANCE}, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2

        /* renamed from: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2$1  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(DeclarationDescriptor declarationDescriptor) {
                return Boolean.valueOf(invoke2(declarationDescriptor));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(DeclarationDescriptor declarationDescriptor) {
                if ((declarationDescriptor instanceof ClassDescriptor) && KotlinBuiltIns.isAny((ClassDescriptor) declarationDescriptor)) {
                    return true;
                }
                return false;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(FunctionDescriptor functionDescriptor) {
            boolean z;
            AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
            OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
            DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
            Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "containingDeclaration");
            boolean invoke2 = anonymousClass1.invoke2(containingDeclaration);
            boolean z2 = true;
            if (!invoke2) {
                Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
                Intrinsics.checkExpressionValueIsNotNull(overriddenDescriptors, "overriddenDescriptors");
                if (!(overriddenDescriptors instanceof Collection) || !overriddenDescriptors.isEmpty()) {
                    for (FunctionDescriptor it : overriddenDescriptors) {
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.INSTANCE;
                        Intrinsics.checkExpressionValueIsNotNull(it, "it");
                        DeclarationDescriptor containingDeclaration2 = it.getContainingDeclaration();
                        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration2, "it.containingDeclaration");
                        if (anonymousClass12.invoke2(containingDeclaration2)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    z2 = false;
                }
            }
            if (!z2) {
                return "must override ''equals()'' in Any";
            }
            return null;
        }
    }), new Checks(OperatorNameConventions.COMPARE_TO, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsInt.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.BINARY_OPERATION_NAMES, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.SIMPLE_UNARY_OPERATION_NAMES, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(CollectionsKt__CollectionsKt.listOf((Object[]) new Name[]{OperatorNameConventions.INC, OperatorNameConventions.DEC}), new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE}, new Function1<FunctionDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(FunctionDescriptor functionDescriptor) {
            boolean z;
            ReceiverParameterDescriptor dispatchReceiverParameter = functionDescriptor.getDispatchReceiverParameter();
            if (dispatchReceiverParameter == null) {
                dispatchReceiverParameter = functionDescriptor.getExtensionReceiverParameter();
            }
            OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
            boolean z2 = false;
            if (dispatchReceiverParameter != null) {
                KotlinType returnType = functionDescriptor.getReturnType();
                if (returnType != null) {
                    KotlinType type = dispatchReceiverParameter.getType();
                    Intrinsics.checkExpressionValueIsNotNull(type, "receiver.type");
                    z = TypeUtilsKt.isSubtypeOf(returnType, type);
                } else {
                    z = false;
                }
                if (z) {
                    z2 = true;
                }
            }
            if (!z2) {
                return "receiver must be a supertype of the return type";
            }
            return null;
        }
    }), new Checks(OperatorNameConventions.ASSIGNMENT_OPERATIONS, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ReturnsCheck.ReturnsUnit.INSTANCE, ValueParameterCountCheck.SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null), new Checks(OperatorNameConventions.COMPONENT_REGEX, new Check[]{MemberKindCheck.MemberOrExtension.INSTANCE, ValueParameterCountCheck.NoValueParameters.INSTANCE}, (Function1) null, 4, (DefaultConstructorMarker) null)});

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks
    public List<Checks> getChecks$descriptors() {
        return checks;
    }
}
