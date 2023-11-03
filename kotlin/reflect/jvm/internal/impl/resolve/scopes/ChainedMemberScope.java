package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
/* loaded from: classes2.dex */
public final class ChainedMemberScope implements MemberScope {
    public static final Companion Companion = new Companion(null);
    public final String debugName;
    public final List<MemberScope> scopes;

    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberScope create(String str, List<? extends MemberScope> list) {
            int size = list.size();
            if (size != 0) {
                if (size != 1) {
                    return new ChainedMemberScope(str, list);
                }
                return (MemberScope) CollectionsKt___CollectionsKt.single((List<? extends Object>) list);
            }
            return MemberScope.Empty.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> */
    /* JADX WARN: Multi-variable type inference failed */
    public ChainedMemberScope(String str, List<? extends MemberScope> list) {
        this.debugName = str;
        this.scopes = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2112getContributedClassifier(Name name, LookupLocation lookupLocation) {
        ClassifierDescriptor classifierDescriptor = null;
        for (MemberScope memberScope : this.scopes) {
            ClassifierDescriptor mo2112getContributedClassifier = memberScope.mo2112getContributedClassifier(name, lookupLocation);
            if (mo2112getContributedClassifier != null) {
                if ((mo2112getContributedClassifier instanceof ClassifierDescriptorWithTypeParameters) && ((ClassifierDescriptorWithTypeParameters) mo2112getContributedClassifier).isExpect()) {
                    if (classifierDescriptor == null) {
                        classifierDescriptor = mo2112getContributedClassifier;
                    }
                } else {
                    return mo2112getContributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        List<MemberScope> list = this.scopes;
        if (list.isEmpty()) {
            return SetsKt__SetsKt.emptySet();
        }
        Collection<DeclarationDescriptor> collection = null;
        for (MemberScope memberScope : list) {
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedDescriptors(descriptorKindFilter, function1));
        }
        if (collection != null) {
            return collection;
        }
        return SetsKt__SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        List<MemberScope> list = this.scopes;
        if (list.isEmpty()) {
            return SetsKt__SetsKt.emptySet();
        }
        Collection<SimpleFunctionDescriptor> collection = null;
        for (MemberScope memberScope : list) {
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedFunctions(name, lookupLocation));
        }
        if (collection != null) {
            return collection;
        }
        return SetsKt__SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        List<MemberScope> list = this.scopes;
        if (list.isEmpty()) {
            return SetsKt__SetsKt.emptySet();
        }
        Collection<PropertyDescriptor> collection = null;
        for (MemberScope memberScope : list) {
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedVariables(name, lookupLocation));
        }
        if (collection != null) {
            return collection;
        }
        return SetsKt__SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        List<MemberScope> list = this.scopes;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : list) {
            CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, memberScope.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        List<MemberScope> list = this.scopes;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : list) {
            CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, memberScope.getVariableNames());
        }
        return linkedHashSet;
    }

    public String toString() {
        return this.debugName;
    }
}
