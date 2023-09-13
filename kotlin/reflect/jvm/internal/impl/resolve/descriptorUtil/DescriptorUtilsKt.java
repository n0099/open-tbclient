package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
/* loaded from: classes2.dex */
public final class DescriptorUtilsKt {
    public static final Name RETENTION_PARAMETER_NAME;

    static {
        Name identifier = Name.identifier("value");
        Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(\"value\")");
        RETENTION_PARAMETER_NAME = identifier;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$computeSealedSubclasses$1] */
    public static final Collection<ClassDescriptor> computeSealedSubclasses(final ClassDescriptor classDescriptor) {
        if (classDescriptor.getModality() != Modality.SEALED) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        ?? r1 = new Function2<MemberScope, Boolean, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$computeSealedSubclasses$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(MemberScope memberScope, Boolean bool) {
                invoke(memberScope, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(MemberScope memberScope, boolean z) {
                for (DeclarationDescriptor declarationDescriptor : ResolutionScope.DefaultImpls.getContributedDescriptors$default(memberScope, DescriptorKindFilter.CLASSIFIERS, null, 2, null)) {
                    if (declarationDescriptor instanceof ClassDescriptor) {
                        ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor;
                        if (DescriptorUtils.isDirectSubclass(classDescriptor2, ClassDescriptor.this)) {
                            linkedHashSet.add(declarationDescriptor);
                        }
                        if (z) {
                            MemberScope unsubstitutedInnerClassesScope = classDescriptor2.getUnsubstitutedInnerClassesScope();
                            Intrinsics.checkExpressionValueIsNotNull(unsubstitutedInnerClassesScope, "descriptor.unsubstitutedInnerClassesScope");
                            invoke(unsubstitutedInnerClassesScope, z);
                        }
                    }
                }
            }
        };
        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "sealedClass.containingDeclaration");
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            r1.invoke(((PackageFragmentDescriptor) containingDeclaration).getMemberScope(), false);
        }
        MemberScope unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
        Intrinsics.checkExpressionValueIsNotNull(unsubstitutedInnerClassesScope, "sealedClass.unsubstitutedInnerClassesScope");
        r1.invoke(unsubstitutedInnerClassesScope, true);
        return linkedHashSet;
    }

    public static final ClassId getClassId(ClassifierDescriptor classifierDescriptor) {
        DeclarationDescriptor containingDeclaration;
        ClassId classId;
        if (classifierDescriptor == null || (containingDeclaration = classifierDescriptor.getContainingDeclaration()) == null) {
            return null;
        }
        if (containingDeclaration instanceof PackageFragmentDescriptor) {
            return new ClassId(((PackageFragmentDescriptor) containingDeclaration).getFqName(), classifierDescriptor.getName());
        }
        if (!(containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) || (classId = getClassId((ClassifierDescriptor) containingDeclaration)) == null) {
            return null;
        }
        return classId.createNestedClassId(classifierDescriptor.getName());
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor classDescriptor) {
        for (KotlinType kotlinType : classDescriptor.getDefaultType().getConstructor().mo2106getSupertypes()) {
            if (!KotlinBuiltIns.isAnyOrNullableAny(kotlinType)) {
                ClassifierDescriptor mo2105getDeclarationDescriptor = kotlinType.getConstructor().mo2105getDeclarationDescriptor();
                if (DescriptorUtils.isClassOrEnumClass(mo2105getDeclarationDescriptor)) {
                    if (mo2105getDeclarationDescriptor != null) {
                        return (ClassDescriptor) mo2105getDeclarationDescriptor;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                }
            }
        }
        return null;
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor valueParameterDescriptor) {
        Boolean ifAny = DFS.ifAny(CollectionsKt__CollectionsJVMKt.listOf(valueParameterDescriptor), new DFS.Neighbors<N>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$declaresOrInheritsDefaultValue$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public final List<ValueParameterDescriptor> getNeighbors(ValueParameterDescriptor current) {
                Intrinsics.checkExpressionValueIsNotNull(current, "current");
                Collection<ValueParameterDescriptor> overriddenDescriptors = current.getOverriddenDescriptors();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(overriddenDescriptors, 10));
                for (ValueParameterDescriptor valueParameterDescriptor2 : overriddenDescriptors) {
                    arrayList.add(valueParameterDescriptor2.getOriginal());
                }
                return arrayList;
            }
        }, DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(ifAny, "DFS.ifAny(\n        listO…eclaresDefaultValue\n    )");
        return ifAny.booleanValue();
    }

    public static final ConstantValue<?> firstArgument(AnnotationDescriptor annotationDescriptor) {
        return (ConstantValue) CollectionsKt___CollectionsKt.firstOrNull(annotationDescriptor.getAllValueArguments().values());
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor declarationDescriptor) {
        FqNameUnsafe fqNameUnsafe = getFqNameUnsafe(declarationDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            fqNameUnsafe = null;
        }
        if (fqNameUnsafe == null) {
            return null;
        }
        return fqNameUnsafe.toSafe();
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor annotationDescriptor) {
        ClassifierDescriptor mo2105getDeclarationDescriptor = annotationDescriptor.getType().getConstructor().mo2105getDeclarationDescriptor();
        if (!(mo2105getDeclarationDescriptor instanceof ClassDescriptor)) {
            mo2105getDeclarationDescriptor = null;
        }
        return (ClassDescriptor) mo2105getDeclarationDescriptor;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor declarationDescriptor) {
        return getModule(declarationDescriptor).getBuiltIns();
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor declarationDescriptor) {
        FqName fqNameSafe = DescriptorUtils.getFqNameSafe(declarationDescriptor);
        Intrinsics.checkExpressionValueIsNotNull(fqNameSafe, "DescriptorUtils.getFqNameSafe(this)");
        return fqNameSafe;
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor declarationDescriptor) {
        FqNameUnsafe fqName = DescriptorUtils.getFqName(declarationDescriptor);
        Intrinsics.checkExpressionValueIsNotNull(fqName, "DescriptorUtils.getFqName(this)");
        return fqName;
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor moduleDescriptor) {
        KotlinTypeRefiner kotlinTypeRefiner;
        Ref ref = (Ref) moduleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (ref == null || (kotlinTypeRefiner = (KotlinTypeRefiner) ref.getValue()) == null) {
            return KotlinTypeRefiner.Default.INSTANCE;
        }
        return kotlinTypeRefiner;
    }

    public static final ModuleDescriptor getModule(DeclarationDescriptor declarationDescriptor) {
        ModuleDescriptor containingModule = DescriptorUtils.getContainingModule(declarationDescriptor);
        Intrinsics.checkExpressionValueIsNotNull(containingModule, "DescriptorUtils.getContainingModule(this)");
        return containingModule;
    }

    public static final Sequence<DeclarationDescriptor> getParents(DeclarationDescriptor declarationDescriptor) {
        return SequencesKt___SequencesKt.drop(getParentsWithSelf(declarationDescriptor), 1);
    }

    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor declarationDescriptor) {
        return SequencesKt__SequencesKt.generateSequence(declarationDescriptor, new Function1<DeclarationDescriptor, DeclarationDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$parentsWithSelf$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final DeclarationDescriptor invoke(DeclarationDescriptor declarationDescriptor2) {
                return declarationDescriptor2.getContainingDeclaration();
            }
        });
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor instanceof PropertyAccessorDescriptor) {
            PropertyDescriptor correspondingProperty = ((PropertyAccessorDescriptor) callableMemberDescriptor).getCorrespondingProperty();
            Intrinsics.checkExpressionValueIsNotNull(correspondingProperty, "correspondingProperty");
            return correspondingProperty;
        }
        return callableMemberDescriptor;
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor moduleDescriptor) {
        KotlinTypeRefiner kotlinTypeRefiner;
        Ref ref = (Ref) moduleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (ref != null) {
            kotlinTypeRefiner = (KotlinTypeRefiner) ref.getValue();
        } else {
            kotlinTypeRefiner = null;
        }
        if (kotlinTypeRefiner != null) {
            return true;
        }
        return false;
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor callableMemberDescriptor, final boolean z, final Function1<? super CallableMemberDescriptor, Boolean> function1) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        return (CallableMemberDescriptor) DFS.dfs(CollectionsKt__CollectionsJVMKt.listOf(callableMemberDescriptor), new DFS.Neighbors<N>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$firstOverridden$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor2) {
                Collection<? extends CallableMemberDescriptor> overriddenDescriptors;
                if (z) {
                    if (callableMemberDescriptor2 != null) {
                        callableMemberDescriptor2 = callableMemberDescriptor2.getOriginal();
                    } else {
                        callableMemberDescriptor2 = null;
                    }
                }
                if (callableMemberDescriptor2 == null || (overriddenDescriptors = callableMemberDescriptor2.getOverriddenDescriptors()) == null) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                return overriddenDescriptors;
            }
        }, new DFS.AbstractNodeHandler<CallableMemberDescriptor, CallableMemberDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$firstOverridden$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public void afterChildren(CallableMemberDescriptor callableMemberDescriptor2) {
                if (((CallableMemberDescriptor) Ref.ObjectRef.this.element) == null && ((Boolean) function1.invoke(callableMemberDescriptor2)).booleanValue()) {
                    Ref.ObjectRef.this.element = callableMemberDescriptor2;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(CallableMemberDescriptor callableMemberDescriptor2) {
                if (((CallableMemberDescriptor) Ref.ObjectRef.this.element) == null) {
                    return true;
                }
                return false;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public CallableMemberDescriptor result() {
                return (CallableMemberDescriptor) Ref.ObjectRef.this.element;
            }
        });
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor callableMemberDescriptor, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return firstOverridden(callableMemberDescriptor, z, function1);
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor moduleDescriptor, FqName fqName, LookupLocation lookupLocation) {
        boolean z = !fqName.isRoot();
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Assertion failed");
        }
        FqName parent = fqName.parent();
        Intrinsics.checkExpressionValueIsNotNull(parent, "topLevelClassFqName.parent()");
        MemberScope memberScope = moduleDescriptor.getPackage(parent).getMemberScope();
        Name shortName = fqName.shortName();
        Intrinsics.checkExpressionValueIsNotNull(shortName, "topLevelClassFqName.shortName()");
        ClassifierDescriptor mo2107getContributedClassifier = memberScope.mo2107getContributedClassifier(shortName, lookupLocation);
        if (!(mo2107getContributedClassifier instanceof ClassDescriptor)) {
            mo2107getContributedClassifier = null;
        }
        return (ClassDescriptor) mo2107getContributedClassifier;
    }
}
