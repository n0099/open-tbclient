package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public class ImplicitClassReceiver implements ImplicitReceiver, ThisClassReceiver {
    public final ClassDescriptor classDescriptor;
    public final ClassDescriptor declarationDescriptor;
    public final ImplicitClassReceiver original;

    public ImplicitClassReceiver(ClassDescriptor classDescriptor, ImplicitClassReceiver implicitClassReceiver) {
        this.classDescriptor = classDescriptor;
        this.original = implicitClassReceiver == null ? this : implicitClassReceiver;
        this.declarationDescriptor = this.classDescriptor;
    }

    public boolean equals(Object obj) {
        ClassDescriptor classDescriptor = this.classDescriptor;
        ClassDescriptor classDescriptor2 = null;
        if (!(obj instanceof ImplicitClassReceiver)) {
            obj = null;
        }
        ImplicitClassReceiver implicitClassReceiver = (ImplicitClassReceiver) obj;
        if (implicitClassReceiver != null) {
            classDescriptor2 = implicitClassReceiver.classDescriptor;
        }
        return Intrinsics.areEqual(classDescriptor, classDescriptor2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver
    public final ClassDescriptor getClassDescriptor() {
        return this.classDescriptor;
    }

    public int hashCode() {
        return this.classDescriptor.hashCode();
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    public SimpleType getType() {
        SimpleType defaultType = this.classDescriptor.getDefaultType();
        Intrinsics.checkExpressionValueIsNotNull(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }
}
