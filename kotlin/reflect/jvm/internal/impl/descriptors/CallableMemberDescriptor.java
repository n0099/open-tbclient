package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
/* loaded from: classes9.dex */
public interface CallableMemberDescriptor extends CallableDescriptor, MemberDescriptor {
    CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, Visibility visibility, Kind kind, boolean z);

    Kind getKind();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    CallableMemberDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    Collection<? extends CallableMemberDescriptor> getOverriddenDescriptors();

    void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection);

    /* loaded from: classes9.dex */
    public enum Kind {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public boolean isReal() {
            if (this != FAKE_OVERRIDE) {
                return true;
            }
            return false;
        }
    }
}
