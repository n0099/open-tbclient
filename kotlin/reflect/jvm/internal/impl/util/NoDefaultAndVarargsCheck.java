package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;
/* loaded from: classes2.dex */
public final class NoDefaultAndVarargsCheck implements Check {
    public static final NoDefaultAndVarargsCheck INSTANCE = new NoDefaultAndVarargsCheck();
    public static final String description = description;
    public static final String description = description;

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor functionDescriptor) {
        boolean z;
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters, "functionDescriptor.valueParameters");
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            for (ValueParameterDescriptor it : valueParameters) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                if (!DescriptorUtilsKt.declaresOrInheritsDefaultValue(it) && it.getVarargElementType() == null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }
}
