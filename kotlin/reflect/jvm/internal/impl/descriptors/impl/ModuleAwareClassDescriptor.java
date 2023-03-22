package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes9.dex */
public abstract class ModuleAwareClassDescriptor implements ClassDescriptor {
    public static final Companion Companion = new Companion(null);

    public abstract MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner);

    public abstract MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner);

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberScope getRefinedMemberScopeIfPossible$descriptors(ClassDescriptor classDescriptor, TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
            ClassDescriptor classDescriptor2;
            MemberScope memberScope;
            if (!(classDescriptor instanceof ModuleAwareClassDescriptor)) {
                classDescriptor2 = null;
            } else {
                classDescriptor2 = classDescriptor;
            }
            ModuleAwareClassDescriptor moduleAwareClassDescriptor = (ModuleAwareClassDescriptor) classDescriptor2;
            if (moduleAwareClassDescriptor == null || (memberScope = moduleAwareClassDescriptor.getMemberScope(typeSubstitution, kotlinTypeRefiner)) == null) {
                MemberScope memberScope2 = classDescriptor.getMemberScope(typeSubstitution);
                Intrinsics.checkExpressionValueIsNotNull(memberScope2, "this.getMemberScope(\n   …ubstitution\n            )");
                return memberScope2;
            }
            return memberScope;
        }

        public final MemberScope getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(ClassDescriptor classDescriptor, KotlinTypeRefiner kotlinTypeRefiner) {
            ClassDescriptor classDescriptor2;
            MemberScope unsubstitutedMemberScope;
            if (!(classDescriptor instanceof ModuleAwareClassDescriptor)) {
                classDescriptor2 = null;
            } else {
                classDescriptor2 = classDescriptor;
            }
            ModuleAwareClassDescriptor moduleAwareClassDescriptor = (ModuleAwareClassDescriptor) classDescriptor2;
            if (moduleAwareClassDescriptor == null || (unsubstitutedMemberScope = moduleAwareClassDescriptor.getUnsubstitutedMemberScope(kotlinTypeRefiner)) == null) {
                MemberScope unsubstitutedMemberScope2 = classDescriptor.getUnsubstitutedMemberScope();
                Intrinsics.checkExpressionValueIsNotNull(unsubstitutedMemberScope2, "this.unsubstitutedMemberScope");
                return unsubstitutedMemberScope2;
            }
            return unsubstitutedMemberScope;
        }
    }
}
