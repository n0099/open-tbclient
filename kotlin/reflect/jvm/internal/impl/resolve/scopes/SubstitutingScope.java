package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
/* loaded from: classes2.dex */
public final class SubstitutingScope implements MemberScope {
    public final Lazy _allDescriptors$delegate;
    public Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
    public final TypeSubstitutor substitutor;
    public final MemberScope workerScope;

    private final Collection<DeclarationDescriptor> get_allDescriptors() {
        return (Collection) this._allDescriptors$delegate.getValue();
    }

    public SubstitutingScope(MemberScope memberScope, TypeSubstitutor typeSubstitutor) {
        this.workerScope = memberScope;
        TypeSubstitution substitution = typeSubstitutor.getSubstitution();
        Intrinsics.checkExpressionValueIsNotNull(substitution, "givenSubstitutor.substitution");
        this.substitutor = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(substitution, false, 1, null).buildSubstitutor();
        this._allDescriptors$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Collection<? extends DeclarationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope$_allDescriptors$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends DeclarationDescriptor> invoke() {
                MemberScope memberScope2;
                Collection<? extends DeclarationDescriptor> substitute;
                SubstitutingScope substitutingScope = SubstitutingScope.this;
                memberScope2 = substitutingScope.workerScope;
                substitute = substitutingScope.substitute(ResolutionScope.DefaultImpls.getContributedDescriptors$default(memberScope2, null, null, 3, null));
                return substitute;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2106getContributedClassifier(Name name, LookupLocation lookupLocation) {
        ClassifierDescriptor mo2106getContributedClassifier = this.workerScope.mo2106getContributedClassifier(name, lookupLocation);
        if (mo2106getContributedClassifier != null) {
            return (ClassifierDescriptor) substitute((SubstitutingScope) mo2106getContributedClassifier);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        return get_allDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        return substitute(this.workerScope.getContributedFunctions(name, lookupLocation));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        return substitute(this.workerScope.getContributedVariables(name, lookupLocation));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Collection<? extends D extends kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> collection) {
        if (this.substitutor.isEmpty()) {
            return collection;
        }
        if (collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet newLinkedHashSetWithExpectedSize = CollectionsKt.newLinkedHashSetWithExpectedSize(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            newLinkedHashSetWithExpectedSize.add(substitute((SubstitutingScope) ((DeclarationDescriptor) it.next())));
        }
        return newLinkedHashSetWithExpectedSize;
    }

    private final <D extends DeclarationDescriptor> D substitute(D d) {
        if (this.substitutor.isEmpty()) {
            return d;
        }
        if (this.substitutedDescriptors == null) {
            this.substitutedDescriptors = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map = this.substitutedDescriptors;
        if (map == null) {
            Intrinsics.throwNpe();
        }
        DeclarationDescriptor declarationDescriptor = map.get(d);
        if (declarationDescriptor == null) {
            if (d instanceof Substitutable) {
                declarationDescriptor = ((Substitutable) d).substitute(this.substitutor);
                if (declarationDescriptor != null) {
                    map.put(d, declarationDescriptor);
                } else {
                    throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
                }
            } else {
                throw new IllegalStateException(("Unknown descriptor in scope: " + d).toString());
            }
        }
        D d2 = (D) declarationDescriptor;
        if (d2 != null) {
            return d2;
        }
        throw new TypeCastException("null cannot be cast to non-null type D");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }
}
