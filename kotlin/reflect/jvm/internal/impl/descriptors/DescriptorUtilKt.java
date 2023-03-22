package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
/* loaded from: classes9.dex */
public final class DescriptorUtilKt {
    public static final ClassDescriptor resolveClassByFqName(ModuleDescriptor moduleDescriptor, FqName fqName, LookupLocation lookupLocation) {
        ClassifierDescriptor classifierDescriptor;
        MemberScope unsubstitutedInnerClassesScope;
        ClassDescriptor classDescriptor = null;
        if (fqName.isRoot()) {
            return null;
        }
        FqName parent = fqName.parent();
        Intrinsics.checkExpressionValueIsNotNull(parent, "fqName.parent()");
        MemberScope memberScope = moduleDescriptor.getPackage(parent).getMemberScope();
        Name shortName = fqName.shortName();
        Intrinsics.checkExpressionValueIsNotNull(shortName, "fqName.shortName()");
        ClassifierDescriptor mo2025getContributedClassifier = memberScope.mo2025getContributedClassifier(shortName, lookupLocation);
        if (!(mo2025getContributedClassifier instanceof ClassDescriptor)) {
            mo2025getContributedClassifier = null;
        }
        ClassDescriptor classDescriptor2 = (ClassDescriptor) mo2025getContributedClassifier;
        if (classDescriptor2 != null) {
            return classDescriptor2;
        }
        FqName parent2 = fqName.parent();
        Intrinsics.checkExpressionValueIsNotNull(parent2, "fqName.parent()");
        ClassDescriptor resolveClassByFqName = resolveClassByFqName(moduleDescriptor, parent2, lookupLocation);
        if (resolveClassByFqName != null && (unsubstitutedInnerClassesScope = resolveClassByFqName.getUnsubstitutedInnerClassesScope()) != null) {
            Name shortName2 = fqName.shortName();
            Intrinsics.checkExpressionValueIsNotNull(shortName2, "fqName.shortName()");
            classifierDescriptor = unsubstitutedInnerClassesScope.mo2025getContributedClassifier(shortName2, lookupLocation);
        } else {
            classifierDescriptor = null;
        }
        if (classifierDescriptor instanceof ClassDescriptor) {
            classDescriptor = classifierDescriptor;
        }
        return classDescriptor;
    }
}
