package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
/* loaded from: classes2.dex */
public final class TypeIntersectionScope extends AbstractScopeAdapter {
    public static final Companion Companion = new Companion(null);
    public final ChainedMemberScope workerScope;

    @JvmStatic
    public static final MemberScope create(String str, Collection<? extends KotlinType> collection) {
        return Companion.create(str, collection);
    }

    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MemberScope create(String str, Collection<? extends KotlinType> collection) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10));
            for (KotlinType kotlinType : collection) {
                arrayList.add(kotlinType.getMemberScope());
            }
            ChainedMemberScope chainedMemberScope = new ChainedMemberScope(str, arrayList);
            if (collection.size() <= 1) {
                return chainedMemberScope;
            }
            return new TypeIntersectionScope(chainedMemberScope, null);
        }
    }

    public TypeIntersectionScope(ChainedMemberScope chainedMemberScope) {
        this.workerScope = chainedMemberScope;
    }

    public /* synthetic */ TypeIntersectionScope(ChainedMemberScope chainedMemberScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(chainedMemberScope);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(name, lookupLocation), new Function1<SimpleFunctionDescriptor, SimpleFunctionDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$getContributedFunctions$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final SimpleFunctionDescriptor invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
                return simpleFunctionDescriptor;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(name, lookupLocation), new Function1<PropertyDescriptor, PropertyDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$getContributedVariables$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final PropertyDescriptor invoke(PropertyDescriptor propertyDescriptor) {
                return propertyDescriptor;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Collection<DeclarationDescriptor> contributedDescriptors = super.getContributedDescriptors(descriptorKindFilter, function1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (((DeclarationDescriptor) obj) instanceof CallableDescriptor) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.component1();
        List list2 = (List) pair.component2();
        if (list != null) {
            return CollectionsKt___CollectionsKt.plus(OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(list, new Function1<CallableDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$getContributedDescriptors$2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final CallableDescriptor invoke(CallableDescriptor callableDescriptor) {
                    return callableDescriptor;
                }
            }), (Iterable) list2);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    public ChainedMemberScope getWorkerScope() {
        return this.workerScope;
    }
}
