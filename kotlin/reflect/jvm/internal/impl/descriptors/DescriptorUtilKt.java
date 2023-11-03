package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
/* loaded from: classes2.dex */
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
        ClassifierDescriptor mo2112getContributedClassifier = memberScope.mo2112getContributedClassifier(shortName, lookupLocation);
        if (!(mo2112getContributedClassifier instanceof ClassDescriptor)) {
            mo2112getContributedClassifier = null;
        }
        ClassDescriptor classDescriptor2 = (ClassDescriptor) mo2112getContributedClassifier;
        if (classDescriptor2 != null) {
            return classDescriptor2;
        }
        FqName parent2 = fqName.parent();
        Intrinsics.checkExpressionValueIsNotNull(parent2, "fqName.parent()");
        ClassDescriptor resolveClassByFqName = resolveClassByFqName(moduleDescriptor, parent2, lookupLocation);
        if (resolveClassByFqName != null && (unsubstitutedInnerClassesScope = resolveClassByFqName.getUnsubstitutedInnerClassesScope()) != null) {
            Name shortName2 = fqName.shortName();
            Intrinsics.checkExpressionValueIsNotNull(shortName2, "fqName.shortName()");
            classifierDescriptor = unsubstitutedInnerClassesScope.mo2112getContributedClassifier(shortName2, lookupLocation);
        } else {
            classifierDescriptor = null;
        }
        if (classifierDescriptor instanceof ClassDescriptor) {
            classDescriptor = classifierDescriptor;
        }
        return classDescriptor;
    }
}
