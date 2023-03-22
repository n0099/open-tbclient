package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
/* loaded from: classes9.dex */
public final class ErasedOverridabilityCondition implements ExternalOverridabilityCondition {

    /* loaded from: classes9.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        List<TypeParameterDescriptor> typeParameters;
        OverridingUtil.OverrideCompatibilityInfo.Result result;
        boolean z;
        List<TypeParameterDescriptor> typeParameters2;
        boolean z2;
        if (callableDescriptor2 instanceof JavaMethodDescriptor) {
            JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
            Intrinsics.checkExpressionValueIsNotNull(javaMethodDescriptor.getTypeParameters(), "subDescriptor.typeParameters");
            if (!(!typeParameters.isEmpty())) {
                OverridingUtil.OverrideCompatibilityInfo basicOverridabilityProblem = OverridingUtil.getBasicOverridabilityProblem(callableDescriptor, callableDescriptor2);
                KotlinType kotlinType = null;
                if (basicOverridabilityProblem != null) {
                    result = basicOverridabilityProblem.getResult();
                } else {
                    result = null;
                }
                if (result != null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                List<ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters, "subDescriptor.valueParameters");
                Sequence map = SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(valueParameters), new Function1<ValueParameterDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition$isOverridable$signatureTypes$1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final KotlinType invoke(ValueParameterDescriptor it) {
                        Intrinsics.checkExpressionValueIsNotNull(it, "it");
                        return it.getType();
                    }
                });
                KotlinType returnType = javaMethodDescriptor.getReturnType();
                if (returnType == null) {
                    Intrinsics.throwNpe();
                }
                Sequence plus = SequencesKt___SequencesKt.plus(map, returnType);
                ReceiverParameterDescriptor extensionReceiverParameter = javaMethodDescriptor.getExtensionReceiverParameter();
                if (extensionReceiverParameter != null) {
                    kotlinType = extensionReceiverParameter.getType();
                }
                Iterator it = SequencesKt___SequencesKt.plus(plus, (Iterable) CollectionsKt__CollectionsKt.listOfNotNull(kotlinType)).iterator();
                while (true) {
                    if (it.hasNext()) {
                        KotlinType kotlinType2 = (KotlinType) it.next();
                        if ((!kotlinType2.getArguments().isEmpty()) && !(kotlinType2.unwrap() instanceof RawTypeImpl)) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                CallableDescriptor substitute = callableDescriptor.substitute(RawSubstitution.INSTANCE.buildSubstitutor());
                if (substitute != null) {
                    if (substitute instanceof SimpleFunctionDescriptor) {
                        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) substitute;
                        Intrinsics.checkExpressionValueIsNotNull(simpleFunctionDescriptor.getTypeParameters(), "erasedSuper.typeParameters");
                        if ((!typeParameters2.isEmpty()) && (substitute = simpleFunctionDescriptor.newCopyBuilder().setTypeParameters(CollectionsKt__CollectionsKt.emptyList()).build()) == null) {
                            Intrinsics.throwNpe();
                        }
                    }
                    OverridingUtil.OverrideCompatibilityInfo isOverridableByWithoutExternalConditions = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(substitute, callableDescriptor2, false);
                    Intrinsics.checkExpressionValueIsNotNull(isOverridableByWithoutExternalConditions, "OverridingUtil.DEFAULT.i…er, subDescriptor, false)");
                    OverridingUtil.OverrideCompatibilityInfo.Result result2 = isOverridableByWithoutExternalConditions.getResult();
                    Intrinsics.checkExpressionValueIsNotNull(result2, "OverridingUtil.DEFAULT.i…Descriptor, false).result");
                    if (WhenMappings.$EnumSwitchMapping$0[result2.ordinal()] != 1) {
                        return ExternalOverridabilityCondition.Result.UNKNOWN;
                    }
                    return ExternalOverridabilityCondition.Result.OVERRIDABLE;
                }
                return ExternalOverridabilityCondition.Result.UNKNOWN;
            }
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
