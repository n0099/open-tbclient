package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* loaded from: classes2.dex */
public final class InnerClassesScopeWrapper extends MemberScopeImpl {
    public final MemberScope workerScope;

    public InnerClassesScopeWrapper(MemberScope memberScope) {
        this.workerScope = memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2103getContributedClassifier(Name name, LookupLocation lookupLocation) {
        ClassifierDescriptor classifierDescriptor;
        ClassifierDescriptor mo2103getContributedClassifier = this.workerScope.mo2103getContributedClassifier(name, lookupLocation);
        if (mo2103getContributedClassifier == null) {
            return null;
        }
        if (!(mo2103getContributedClassifier instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        } else {
            classifierDescriptor = mo2103getContributedClassifier;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        if (!(mo2103getContributedClassifier instanceof TypeAliasDescriptor)) {
            mo2103getContributedClassifier = null;
        }
        return (TypeAliasDescriptor) mo2103getContributedClassifier;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1 function1) {
        return getContributedDescriptors(descriptorKindFilter, (Function1<? super Name, Boolean>) function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<ClassifierDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        DescriptorKindFilter restrictedToKindsOrNull = descriptorKindFilter.restrictedToKindsOrNull(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
        if (restrictedToKindsOrNull != null) {
            Collection<DeclarationDescriptor> contributedDescriptors = this.workerScope.getContributedDescriptors(restrictedToKindsOrNull, function1);
            ArrayList arrayList = new ArrayList();
            for (Object obj : contributedDescriptors) {
                if (obj instanceof ClassifierDescriptorWithTypeParameters) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    public String toString() {
        return "Classes from " + this.workerScope;
    }
}
