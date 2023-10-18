package kotlin.reflect.jvm.internal.impl.descriptors;
/* loaded from: classes10.dex */
public interface MemberDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility {
    Modality getModality();

    Visibility getVisibility();

    boolean isActual();

    boolean isExpect();

    boolean isExternal();
}
