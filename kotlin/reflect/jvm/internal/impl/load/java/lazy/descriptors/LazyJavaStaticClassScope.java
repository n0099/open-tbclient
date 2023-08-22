package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.SequencesKt___SequencesKt;
/* loaded from: classes2.dex */
public final class LazyJavaStaticClassScope extends LazyJavaStaticScope {
    public final JavaClass jClass;
    public final LazyJavaClassDescriptor ownerDescriptor;

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2106getContributedClassifier(Name name, LookupLocation lookupLocation) {
        return null;
    }

    public LazyJavaStaticClassScope(LazyJavaResolverContext lazyJavaResolverContext, JavaClass javaClass, LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(lazyJavaResolverContext);
        this.jClass = javaClass;
        this.ownerDescriptor = lazyJavaClassDescriptor;
    }

    private final <R> Set<R> flatMapJavaStaticSupertypesScopes(final ClassDescriptor classDescriptor, final Set<R> set, final Function1<? super MemberScope, ? extends Collection<? extends R>> function1) {
        DFS.dfs(CollectionsKt__CollectionsJVMKt.listOf(classDescriptor), new DFS.Neighbors<N>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor it) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                TypeConstructor typeConstructor = it.getTypeConstructor();
                Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "it.typeConstructor");
                Collection<KotlinType> mo2105getSupertypes = typeConstructor.mo2105getSupertypes();
                Intrinsics.checkExpressionValueIsNotNull(mo2105getSupertypes, "it.typeConstructor.supertypes");
                return SequencesKt___SequencesKt.asIterable(SequencesKt___SequencesKt.mapNotNull(CollectionsKt___CollectionsKt.asSequence(mo2105getSupertypes), new Function1<KotlinType, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final ClassDescriptor invoke(KotlinType kotlinType) {
                        ClassifierDescriptor mo2104getDeclarationDescriptor = kotlinType.getConstructor().mo2104getDeclarationDescriptor();
                        if (!(mo2104getDeclarationDescriptor instanceof ClassDescriptor)) {
                            mo2104getDeclarationDescriptor = null;
                        }
                        return (ClassDescriptor) mo2104getDeclarationDescriptor;
                    }
                }));
            }
        }, new DFS.AbstractNodeHandler<ClassDescriptor, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2
            /* JADX DEBUG: Possible override for method kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler.result()Ljava/lang/Object; */
            /* renamed from: result  reason: collision with other method in class */
            public void m2101result() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(ClassDescriptor classDescriptor2) {
                if (classDescriptor2 == ClassDescriptor.this) {
                    return true;
                }
                MemberScope staticScope = classDescriptor2.getStaticScope();
                Intrinsics.checkExpressionValueIsNotNull(staticScope, "current.staticScope");
                if (!(staticScope instanceof LazyJavaStaticScope)) {
                    return true;
                }
                set.addAll((Collection) function1.invoke(staticScope));
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public /* bridge */ /* synthetic */ Object result() {
                m2101result();
                return Unit.INSTANCE;
            }
        });
        return set;
    }

    private final PropertyDescriptor getRealOriginal(PropertyDescriptor propertyDescriptor) {
        CallableMemberDescriptor.Kind kind = propertyDescriptor.getKind();
        Intrinsics.checkExpressionValueIsNotNull(kind, "this.kind");
        if (kind.isReal()) {
            return propertyDescriptor;
        }
        Collection<? extends PropertyDescriptor> overriddenDescriptors = propertyDescriptor.getOverriddenDescriptors();
        Intrinsics.checkExpressionValueIsNotNull(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (PropertyDescriptor it : overriddenDescriptors) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            arrayList.add(getRealOriginal(it));
        }
        return (PropertyDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) CollectionsKt___CollectionsKt.distinct(arrayList));
    }

    private final Set<SimpleFunctionDescriptor> getStaticFunctionsFromJavaSuperClasses(Name name, ClassDescriptor classDescriptor) {
        LazyJavaStaticClassScope parentJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(classDescriptor);
        if (parentJavaStaticClassScope != null) {
            return CollectionsKt___CollectionsKt.toSet(parentJavaStaticClassScope.getContributedFunctions(name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return SetsKt__SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeClassNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        return SetsKt__SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computePropertyNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Set<Name> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getFieldNames());
        flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), mutableSet, new Function1<MemberScope, Set<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$computePropertyNames$1$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final Set<Name> invoke(MemberScope memberScope) {
                return memberScope.getVariableNames();
            }
        });
        return mutableSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Set<Name> set;
        Set<Name> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(getDeclaredMemberIndex().invoke().getMethodNames());
        LazyJavaStaticClassScope parentJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(getOwnerDescriptor());
        if (parentJavaStaticClassScope != null) {
            set = parentJavaStaticClassScope.getFunctionNames();
        } else {
            set = null;
        }
        if (set == null) {
            set = SetsKt__SetsKt.emptySet();
        }
        mutableSet.addAll(set);
        if (this.jClass.isEnum()) {
            mutableSet.addAll(CollectionsKt__CollectionsKt.listOf((Object[]) new Name[]{DescriptorUtils.ENUM_VALUE_OF, DescriptorUtils.ENUM_VALUES}));
        }
        return mutableSet;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, new Function1<JavaMember, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$computeMemberIndex$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(JavaMember javaMember) {
                return Boolean.valueOf(invoke2(javaMember));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(JavaMember javaMember) {
                return javaMember.isStatic();
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public LazyJavaClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Collection<? extends SimpleFunctionDescriptor> resolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, getStaticFunctionsFromJavaSuperClasses(name, getOwnerDescriptor()), collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics.checkExpressionValueIsNotNull(resolveOverridesForStaticMembers, "resolveOverridesForStati….overridingUtil\n        )");
        collection.addAll(resolveOverridesForStaticMembers);
        if (this.jClass.isEnum()) {
            if (Intrinsics.areEqual(name, DescriptorUtils.ENUM_VALUE_OF)) {
                SimpleFunctionDescriptor createEnumValueOfMethod = DescriptorFactory.createEnumValueOfMethod(getOwnerDescriptor());
                Intrinsics.checkExpressionValueIsNotNull(createEnumValueOfMethod, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(createEnumValueOfMethod);
            } else if (Intrinsics.areEqual(name, DescriptorUtils.ENUM_VALUES)) {
                SimpleFunctionDescriptor createEnumValuesMethod = DescriptorFactory.createEnumValuesMethod(getOwnerDescriptor());
                Intrinsics.checkExpressionValueIsNotNull(createEnumValuesMethod, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(createEnumValuesMethod);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredProperties(final Name name, Collection<PropertyDescriptor> collection) {
        Set flatMapJavaStaticSupertypesScopes = flatMapJavaStaticSupertypesScopes(getOwnerDescriptor(), new LinkedHashSet(), new Function1<MemberScope, Collection<? extends PropertyDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final Collection<? extends PropertyDescriptor> invoke(MemberScope memberScope) {
                return memberScope.getContributedVariables(Name.this, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            }
        });
        if (!collection.isEmpty()) {
            Collection<? extends PropertyDescriptor> resolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, flatMapJavaStaticSupertypesScopes, collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics.checkExpressionValueIsNotNull(resolveOverridesForStaticMembers, "resolveOverridesForStati…ingUtil\n                )");
            collection.addAll(resolveOverridesForStaticMembers);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : flatMapJavaStaticSupertypesScopes) {
            PropertyDescriptor realOriginal = getRealOriginal((PropertyDescriptor) obj);
            Object obj2 = linkedHashMap.get(realOriginal);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(realOriginal, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, DescriptorResolverUtils.resolveOverridesForStaticMembers(name, (Collection) entry.getValue(), collection, getOwnerDescriptor(), getC().getComponents().getErrorReporter(), getC().getComponents().getKotlinTypeChecker().getOverridingUtil()));
        }
        collection.addAll(arrayList);
    }
}
