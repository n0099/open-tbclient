package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
/* loaded from: classes10.dex */
public final class RuntimeErrorReporter implements ErrorReporter {
    public static final RuntimeErrorReporter INSTANCE = new RuntimeErrorReporter();

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportCannotInferVisibility(CallableMemberDescriptor callableMemberDescriptor) {
        throw new IllegalStateException("Cannot infer visibility for " + callableMemberDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter
    public void reportIncompleteHierarchy(ClassDescriptor classDescriptor, List<String> list) {
        throw new IllegalStateException("Incomplete hierarchy for class " + classDescriptor.getName() + ", unresolved classes " + list);
    }
}
