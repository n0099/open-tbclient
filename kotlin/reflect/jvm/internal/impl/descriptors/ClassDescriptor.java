package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
/* loaded from: classes10.dex */
public interface ClassDescriptor extends ClassOrPackageFragmentDescriptor, ClassifierDescriptorWithTypeParameters {
    /* renamed from: getCompanionObjectDescriptor */
    ClassDescriptor mo2099getCompanionObjectDescriptor();

    Collection<ClassConstructorDescriptor> getConstructors();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    DeclarationDescriptor getContainingDeclaration();

    List<TypeParameterDescriptor> getDeclaredTypeParameters();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    SimpleType getDefaultType();

    ClassKind getKind();

    MemberScope getMemberScope(TypeSubstitution typeSubstitution);

    Modality getModality();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    ClassDescriptor getOriginal();

    Collection<ClassDescriptor> getSealedSubclasses();

    MemberScope getStaticScope();

    ReceiverParameterDescriptor getThisAsReceiverParameter();

    MemberScope getUnsubstitutedInnerClassesScope();

    MemberScope getUnsubstitutedMemberScope();

    /* renamed from: getUnsubstitutedPrimaryConstructor */
    ClassConstructorDescriptor mo2100getUnsubstitutedPrimaryConstructor();

    Visibility getVisibility();

    boolean isCompanionObject();

    boolean isData();

    boolean isInline();
}
