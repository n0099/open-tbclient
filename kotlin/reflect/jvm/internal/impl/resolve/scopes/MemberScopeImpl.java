package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
/* loaded from: classes2.dex */
public abstract class MemberScopeImpl implements MemberScope {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2108getContributedClassifier(Name name, LookupLocation lookupLocation) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        MemberScope.DefaultImpls.recordLookup(this, name, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        Collection<DeclarationDescriptor> contributedDescriptors = getContributedDescriptors(DescriptorKindFilter.FUNCTIONS, FunctionsKt.alwaysTrue());
        ArrayList<SimpleFunctionDescriptor> arrayList = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof SimpleFunctionDescriptor) {
                arrayList.add(obj);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (SimpleFunctionDescriptor simpleFunctionDescriptor : arrayList) {
            linkedHashSet.add(simpleFunctionDescriptor.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        Collection<DeclarationDescriptor> contributedDescriptors = getContributedDescriptors(DescriptorKindFilter.VARIABLES, FunctionsKt.alwaysTrue());
        ArrayList<VariableDescriptor> arrayList = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (obj instanceof VariableDescriptor) {
                arrayList.add(obj);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (VariableDescriptor variableDescriptor : arrayList) {
            linkedHashSet.add(variableDescriptor.getName());
        }
        return linkedHashSet;
    }
}
