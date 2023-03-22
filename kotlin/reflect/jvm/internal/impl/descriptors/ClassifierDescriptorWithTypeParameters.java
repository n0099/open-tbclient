package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
/* loaded from: classes9.dex */
public interface ClassifierDescriptorWithTypeParameters extends ClassifierDescriptor, DeclarationDescriptorWithVisibility, MemberDescriptor, Substitutable<ClassifierDescriptorWithTypeParameters> {
    List<TypeParameterDescriptor> getDeclaredTypeParameters();

    boolean isInner();
}
