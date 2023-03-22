package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
/* loaded from: classes9.dex */
public final class VisibilityUtilKt {
    public static final CallableMemberDescriptor findMemberWithMaxVisibility(Collection<? extends CallableMemberDescriptor> collection) {
        Integer compare;
        boolean z = !collection.isEmpty();
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Assertion failed");
        }
        CallableMemberDescriptor callableMemberDescriptor = null;
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            if (callableMemberDescriptor == null || ((compare = Visibilities.compare(callableMemberDescriptor.getVisibility(), callableMemberDescriptor2.getVisibility())) != null && compare.intValue() < 0)) {
                callableMemberDescriptor = callableMemberDescriptor2;
            }
        }
        if (callableMemberDescriptor == null) {
            Intrinsics.throwNpe();
        }
        return callableMemberDescriptor;
    }
}
