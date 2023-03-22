package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
/* loaded from: classes9.dex */
public abstract class Visibility {
    public final boolean isPublicAPI;
    public final String name;

    public abstract boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor);

    public Visibility normalize() {
        return this;
    }

    public Visibility(String str, boolean z) {
        this.name = str;
        this.isPublicAPI = z;
    }

    public Integer compareTo(Visibility visibility) {
        return Visibilities.compareLocal(this, visibility);
    }

    public String getInternalDisplayName() {
        return this.name;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    public final String toString() {
        return getInternalDisplayName();
    }
}
