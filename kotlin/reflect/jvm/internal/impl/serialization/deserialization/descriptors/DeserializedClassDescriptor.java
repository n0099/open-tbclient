package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes2.dex */
public final class DeserializedClassDescriptor extends AbstractClassDescriptor {
    public final Annotations annotations;
    public final DeserializationContext c;
    public final ClassId classId;
    public final ProtoBuf.Class classProto;
    public final NullableLazyValue<ClassDescriptor> companionObjectDescriptor;
    public final NotNullLazyValue<Collection<ClassConstructorDescriptor>> constructors;
    public final DeclarationDescriptor containingDeclaration;
    public final EnumEntryClassDescriptors enumEntries;
    public final ClassKind kind;
    public final ScopesHolderForClass<DeserializedClassMemberScope> memberScopeHolder;
    public final BinaryVersion metadataVersion;
    public final Modality modality;
    public final NullableLazyValue<ClassConstructorDescriptor> primaryConstructor;
    public final NotNullLazyValue<Collection<ClassDescriptor>> sealedSubclasses;
    public final SourceElement sourceElement;
    public final MemberScopeImpl staticScope;
    public final ProtoContainer.Class thisAsProtoContainer;
    public final DeserializedClassTypeConstructor typeConstructor;
    public final Visibility visibility;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    /* loaded from: classes2.dex */
    public final class DeserializedClassMemberScope extends DeserializedMemberScope {
        public final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        public final KotlinTypeRefiner kotlinTypeRefiner;
        public final NotNullLazyValue<Collection<KotlinType>> refinedSupertypes;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DeserializedClassMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
            super(r1, r2, r3, r4, new Function0<List<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.name.Name>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends Name> invoke() {
                    return r1;
                }
            });
            DeserializationContext c = DeserializedClassDescriptor.this.getC();
            List<ProtoBuf.Function> functionList = DeserializedClassDescriptor.this.getClassProto().getFunctionList();
            Intrinsics.checkExpressionValueIsNotNull(functionList, "classProto.functionList");
            List<ProtoBuf.Property> propertyList = DeserializedClassDescriptor.this.getClassProto().getPropertyList();
            Intrinsics.checkExpressionValueIsNotNull(propertyList, "classProto.propertyList");
            List<ProtoBuf.TypeAlias> typeAliasList = DeserializedClassDescriptor.this.getClassProto().getTypeAliasList();
            Intrinsics.checkExpressionValueIsNotNull(typeAliasList, "classProto.typeAliasList");
            List<Integer> nestedClassNameList = DeserializedClassDescriptor.this.getClassProto().getNestedClassNameList();
            Intrinsics.checkExpressionValueIsNotNull(nestedClassNameList, "classProto.nestedClassNameList");
            NameResolver nameResolver = DeserializedClassDescriptor.this.getC().getNameResolver();
            final List arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(nestedClassNameList, 10));
            for (Number number : nestedClassNameList) {
                arrayList.add(NameResolverUtilKt.getName(nameResolver, number.intValue()));
            }
            this.kotlinTypeRefiner = kotlinTypeRefiner;
            this.allDescriptors = getC().getStorageManager().createLazyValue(new Function0<Collection<? extends DeclarationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends DeclarationDescriptor> invoke() {
                    return DeserializedClassDescriptor.DeserializedClassMemberScope.this.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                }
            });
            this.refinedSupertypes = getC().getStorageManager().createLazyValue(new Function0<Collection<? extends KotlinType>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KotlinType> invoke() {
                    KotlinTypeRefiner kotlinTypeRefiner2;
                    DeserializedClassDescriptor classDescriptor;
                    kotlinTypeRefiner2 = DeserializedClassDescriptor.DeserializedClassMemberScope.this.kotlinTypeRefiner;
                    classDescriptor = DeserializedClassDescriptor.DeserializedClassMemberScope.this.getClassDescriptor();
                    return kotlinTypeRefiner2.refineSupertypes(classDescriptor);
                }
            });
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public ClassId createClassId(Name name) {
            ClassId createNestedClassId = DeserializedClassDescriptor.this.classId.createNestedClassId(name);
            Intrinsics.checkExpressionValueIsNotNull(createNestedClassId, "classId.createNestedClassId(name)");
            return createNestedClassId;
        }

        private final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name name, Collection<? extends D> collection, final Collection<D> collection2) {
            getC().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(name, collection, new ArrayList(collection2), getClassDescriptor(), new NonReportingOverrideStrategy() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1
                @Override // kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
                public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                }

                @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
                public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
                    OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
                    collection2.add(callableMemberDescriptor);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DeserializedClassDescriptor getClassDescriptor() {
            return DeserializedClassDescriptor.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public Set<Name> getNonDeclaredVariableNames() {
            List<KotlinType> mo2105getSupertypes = getClassDescriptor().typeConstructor.mo2105getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (KotlinType kotlinType : mo2105getSupertypes) {
                CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, kotlinType.getMemberScope().getVariableNames());
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1) {
            Collection<ClassDescriptor> collection2;
            EnumEntryClassDescriptors enumEntryClassDescriptors = getClassDescriptor().enumEntries;
            if (enumEntryClassDescriptors != null) {
                collection2 = enumEntryClassDescriptors.all();
            } else {
                collection2 = null;
            }
            if (collection2 == null) {
                collection2 = CollectionsKt__CollectionsKt.emptyList();
            }
            collection.addAll(collection2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> collection) {
            ArrayList arrayList = new ArrayList();
            for (KotlinType kotlinType : this.refinedSupertypes.invoke()) {
                arrayList.addAll(kotlinType.getMemberScope().getContributedVariables(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            generateFakeOverrides(name, arrayList, collection);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        /* renamed from: getContributedClassifier */
        public ClassifierDescriptor mo2106getContributedClassifier(Name name, LookupLocation lookupLocation) {
            ClassDescriptor findEnumEntry;
            recordLookup(name, lookupLocation);
            EnumEntryClassDescriptors enumEntryClassDescriptors = getClassDescriptor().enumEntries;
            if (enumEntryClassDescriptors != null && (findEnumEntry = enumEntryClassDescriptors.findEnumEntry(name)) != null) {
                return findEnumEntry;
            }
            return super.mo2106getContributedClassifier(name, lookupLocation);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            return this.allDescriptors.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            recordLookup(name, lookupLocation);
            return super.getContributedFunctions(name, lookupLocation);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            recordLookup(name, lookupLocation);
            return super.getContributedVariables(name, lookupLocation);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl
        public void recordLookup(Name name, LookupLocation lookupLocation) {
            UtilsKt.record(getC().getComponents().getLookupTracker(), lookupLocation, getClassDescriptor(), name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public void computeNonDeclaredFunctions(Name name, Collection<SimpleFunctionDescriptor> collection) {
            ArrayList arrayList = new ArrayList();
            for (KotlinType kotlinType : this.refinedSupertypes.invoke()) {
                arrayList.addAll(kotlinType.getMemberScope().getContributedFunctions(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            CollectionsKt__MutableCollectionsKt.retainAll(collection, new Function1<SimpleFunctionDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$computeNonDeclaredFunctions$1
                {
                    super(1);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
                    return Boolean.valueOf(invoke2(simpleFunctionDescriptor));
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(SimpleFunctionDescriptor simpleFunctionDescriptor) {
                    return DeserializedClassDescriptor.DeserializedClassMemberScope.this.getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(DeserializedClassDescriptor.this, simpleFunctionDescriptor);
                }
            });
            collection.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctions(name, DeserializedClassDescriptor.this));
            generateFakeOverrides(name, arrayList, collection);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        public Set<Name> getNonDeclaredFunctionNames() {
            List<KotlinType> mo2105getSupertypes = getClassDescriptor().typeConstructor.mo2105getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (KotlinType kotlinType : mo2105getSupertypes) {
                CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, kotlinType.getMemberScope().getFunctionNames());
            }
            linkedHashSet.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(DeserializedClassDescriptor.this));
            return linkedHashSet;
        }
    }

    /* loaded from: classes2.dex */
    public final class DeserializedClassTypeConstructor extends AbstractClassTypeConstructor {
        public final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public DeserializedClassTypeConstructor() {
            super(DeserializedClassDescriptor.this.getC().getStorageManager());
            this.parameters = DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue(new Function0<List<? extends TypeParameterDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends TypeParameterDescriptor> invoke() {
                    return TypeParameterUtilsKt.computeConstructorTypeParameters(DeserializedClassDescriptor.this);
                }
            });
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public Collection<KotlinType> computeSupertypes() {
            String asString;
            FqName asSingleFqName;
            List<ProtoBuf.Type> supertypes = ProtoTypeTableUtilKt.supertypes(DeserializedClassDescriptor.this.getClassProto(), DeserializedClassDescriptor.this.getC().getTypeTable());
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(supertypes, 10));
            for (ProtoBuf.Type type : supertypes) {
                arrayList.add(DeserializedClassDescriptor.this.getC().getTypeDeserializer().type(type));
            }
            List<KotlinType> plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) DeserializedClassDescriptor.this.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(DeserializedClassDescriptor.this));
            ArrayList<NotFoundClasses.MockClassDescriptor> arrayList2 = new ArrayList();
            for (KotlinType kotlinType : plus) {
                ClassifierDescriptor mo2104getDeclarationDescriptor = kotlinType.getConstructor().mo2104getDeclarationDescriptor();
                if (!(mo2104getDeclarationDescriptor instanceof NotFoundClasses.MockClassDescriptor)) {
                    mo2104getDeclarationDescriptor = null;
                }
                NotFoundClasses.MockClassDescriptor mockClassDescriptor = (NotFoundClasses.MockClassDescriptor) mo2104getDeclarationDescriptor;
                if (mockClassDescriptor != null) {
                    arrayList2.add(mockClassDescriptor);
                }
            }
            if (!arrayList2.isEmpty()) {
                ErrorReporter errorReporter = DeserializedClassDescriptor.this.getC().getComponents().getErrorReporter();
                DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                for (NotFoundClasses.MockClassDescriptor mockClassDescriptor2 : arrayList2) {
                    ClassId classId = DescriptorUtilsKt.getClassId(mockClassDescriptor2);
                    if (classId == null || (asSingleFqName = classId.asSingleFqName()) == null || (asString = asSingleFqName.asString()) == null) {
                        asString = mockClassDescriptor2.getName().asString();
                    }
                    arrayList3.add(asString);
                }
                errorReporter.reportIncompleteHierarchy(deserializedClassDescriptor, arrayList3);
            }
            return CollectionsKt___CollectionsKt.toList(plus);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.parameters.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }

        public String toString() {
            String name = DeserializedClassDescriptor.this.getName().toString();
            Intrinsics.checkExpressionValueIsNotNull(name, "name.toString()");
            return name;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getDeclarationDescriptor */
        public DeserializedClassDescriptor mo2104getDeclarationDescriptor() {
            return DeserializedClassDescriptor.this;
        }
    }

    /* loaded from: classes2.dex */
    public final class EnumEntryClassDescriptors {
        public final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
        public final Map<Name, ProtoBuf.EnumEntry> enumEntryProtos;
        public final NotNullLazyValue<Set<Name>> enumMemberNames;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public EnumEntryClassDescriptors() {
            List<ProtoBuf.EnumEntry> enumEntryList = DeserializedClassDescriptor.this.getClassProto().getEnumEntryList();
            Intrinsics.checkExpressionValueIsNotNull(enumEntryList, "classProto.enumEntryList");
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(enumEntryList, 10)), 16));
            for (Object obj : enumEntryList) {
                ProtoBuf.EnumEntry it = (ProtoBuf.EnumEntry) obj;
                NameResolver nameResolver = DeserializedClassDescriptor.this.getC().getNameResolver();
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                linkedHashMap.put(NameResolverUtilKt.getName(nameResolver, it.getName()), obj);
            }
            this.enumEntryProtos = linkedHashMap;
            this.enumEntryByName = DeserializedClassDescriptor.this.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(this));
            this.enumMemberNames = DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue(new Function0<Set<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final Set<? extends Name> invoke() {
                    Set<? extends Name> computeEnumMemberNames;
                    computeEnumMemberNames = DeserializedClassDescriptor.EnumEntryClassDescriptors.this.computeEnumMemberNames();
                    return computeEnumMemberNames;
                }
            });
        }

        public final ClassDescriptor findEnumEntry(Name name) {
            return this.enumEntryByName.invoke(name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<Name> computeEnumMemberNames() {
            HashSet hashSet = new HashSet();
            for (KotlinType kotlinType : DeserializedClassDescriptor.this.getTypeConstructor().mo2105getSupertypes()) {
                for (DeclarationDescriptor declarationDescriptor : ResolutionScope.DefaultImpls.getContributedDescriptors$default(kotlinType.getMemberScope(), null, null, 3, null)) {
                    if ((declarationDescriptor instanceof SimpleFunctionDescriptor) || (declarationDescriptor instanceof PropertyDescriptor)) {
                        hashSet.add(declarationDescriptor.getName());
                    }
                }
            }
            List<ProtoBuf.Function> functionList = DeserializedClassDescriptor.this.getClassProto().getFunctionList();
            Intrinsics.checkExpressionValueIsNotNull(functionList, "classProto.functionList");
            for (ProtoBuf.Function it : functionList) {
                NameResolver nameResolver = DeserializedClassDescriptor.this.getC().getNameResolver();
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                hashSet.add(NameResolverUtilKt.getName(nameResolver, it.getName()));
            }
            List<ProtoBuf.Property> propertyList = DeserializedClassDescriptor.this.getClassProto().getPropertyList();
            Intrinsics.checkExpressionValueIsNotNull(propertyList, "classProto.propertyList");
            for (ProtoBuf.Property it2 : propertyList) {
                NameResolver nameResolver2 = DeserializedClassDescriptor.this.getC().getNameResolver();
                Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                hashSet.add(NameResolverUtilKt.getName(nameResolver2, it2.getName()));
            }
            return SetsKt___SetsKt.plus((Set) hashSet, (Iterable) hashSet);
        }

        public final Collection<ClassDescriptor> all() {
            Set<Name> keySet = this.enumEntryProtos.keySet();
            ArrayList arrayList = new ArrayList();
            for (Name name : keySet) {
                ClassDescriptor findEnumEntry = findEnumEntry(name);
                if (findEnumEntry != null) {
                    arrayList.add(findEnumEntry);
                }
            }
            return arrayList;
        }
    }

    public DeserializedClassDescriptor(DeserializationContext deserializationContext, ProtoBuf.Class r9, NameResolver nameResolver, BinaryVersion binaryVersion, SourceElement sourceElement) {
        super(deserializationContext.getStorageManager(), NameResolverUtilKt.getClassId(nameResolver, r9.getFqName()).getShortClassName());
        MemberScopeImpl memberScopeImpl;
        EnumEntryClassDescriptors enumEntryClassDescriptors;
        Annotations nonEmptyDeserializedAnnotations;
        this.classProto = r9;
        this.metadataVersion = binaryVersion;
        this.sourceElement = sourceElement;
        this.classId = NameResolverUtilKt.getClassId(nameResolver, r9.getFqName());
        this.modality = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(this.classProto.getFlags()));
        this.visibility = ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(this.classProto.getFlags()));
        this.kind = ProtoEnumFlags.INSTANCE.classKind(Flags.CLASS_KIND.get(this.classProto.getFlags()));
        List<ProtoBuf.TypeParameter> typeParameterList = this.classProto.getTypeParameterList();
        Intrinsics.checkExpressionValueIsNotNull(typeParameterList, "classProto.typeParameterList");
        ProtoBuf.TypeTable typeTable = this.classProto.getTypeTable();
        Intrinsics.checkExpressionValueIsNotNull(typeTable, "classProto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable versionRequirementTable = this.classProto.getVersionRequirementTable();
        Intrinsics.checkExpressionValueIsNotNull(versionRequirementTable, "classProto.versionRequirementTable");
        this.c = deserializationContext.childContext(this, typeParameterList, nameResolver, typeTable2, companion.create(versionRequirementTable), this.metadataVersion);
        if (this.kind == ClassKind.ENUM_CLASS) {
            memberScopeImpl = new StaticScopeForKotlinEnum(this.c.getStorageManager(), this);
        } else {
            memberScopeImpl = MemberScope.Empty.INSTANCE;
        }
        this.staticScope = memberScopeImpl;
        this.typeConstructor = new DeserializedClassTypeConstructor();
        this.memberScopeHolder = ScopesHolderForClass.Companion.create(this, this.c.getStorageManager(), this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        if (this.kind == ClassKind.ENUM_CLASS) {
            enumEntryClassDescriptors = new EnumEntryClassDescriptors();
        } else {
            enumEntryClassDescriptors = null;
        }
        this.enumEntries = enumEntryClassDescriptors;
        this.containingDeclaration = deserializationContext.getContainingDeclaration();
        this.primaryConstructor = this.c.getStorageManager().createNullableLazyValue(new Function0<ClassConstructorDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$primaryConstructor$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final ClassConstructorDescriptor invoke() {
                ClassConstructorDescriptor computePrimaryConstructor;
                computePrimaryConstructor = DeserializedClassDescriptor.this.computePrimaryConstructor();
                return computePrimaryConstructor;
            }
        });
        this.constructors = this.c.getStorageManager().createLazyValue(new Function0<Collection<? extends ClassConstructorDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$constructors$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends ClassConstructorDescriptor> invoke() {
                Collection<? extends ClassConstructorDescriptor> computeConstructors;
                computeConstructors = DeserializedClassDescriptor.this.computeConstructors();
                return computeConstructors;
            }
        });
        this.companionObjectDescriptor = this.c.getStorageManager().createNullableLazyValue(new Function0<ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$companionObjectDescriptor$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final ClassDescriptor invoke() {
                ClassDescriptor computeCompanionObjectDescriptor;
                computeCompanionObjectDescriptor = DeserializedClassDescriptor.this.computeCompanionObjectDescriptor();
                return computeCompanionObjectDescriptor;
            }
        });
        this.sealedSubclasses = this.c.getStorageManager().createLazyValue(new Function0<Collection<? extends ClassDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$sealedSubclasses$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends ClassDescriptor> invoke() {
                Collection<? extends ClassDescriptor> computeSubclassesForSealedClass;
                computeSubclassesForSealedClass = DeserializedClassDescriptor.this.computeSubclassesForSealedClass();
                return computeSubclassesForSealedClass;
            }
        });
        ProtoBuf.Class r1 = this.classProto;
        NameResolver nameResolver2 = this.c.getNameResolver();
        TypeTable typeTable3 = this.c.getTypeTable();
        SourceElement sourceElement2 = this.sourceElement;
        DeclarationDescriptor declarationDescriptor = this.containingDeclaration;
        DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) (declarationDescriptor instanceof DeserializedClassDescriptor ? declarationDescriptor : null);
        this.thisAsProtoContainer = new ProtoContainer.Class(r1, nameResolver2, typeTable3, sourceElement2, deserializedClassDescriptor != null ? deserializedClassDescriptor.thisAsProtoContainer : null);
        if (!Flags.HAS_ANNOTATIONS.get(this.classProto.getFlags()).booleanValue()) {
            nonEmptyDeserializedAnnotations = Annotations.Companion.getEMPTY();
        } else {
            nonEmptyDeserializedAnnotations = new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$annotations$1
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends AnnotationDescriptor> invoke() {
                    return CollectionsKt___CollectionsKt.toList(DeserializedClassDescriptor.this.getC().getComponents().getAnnotationAndConstantLoader().loadClassAnnotations(DeserializedClassDescriptor.this.getThisAsProtoContainer$deserialization()));
                }
            });
        }
        this.annotations = nonEmptyDeserializedAnnotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        return this.memberScopeHolder.getScope(kotlinTypeRefiner);
    }

    public final boolean hasNestedClass$deserialization(Name name) {
        return getMemberScope().getClassNames$deserialization().contains(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor computeCompanionObjectDescriptor() {
        ClassDescriptor classDescriptor = null;
        if (!this.classProto.hasCompanionObjectName()) {
            return null;
        }
        ClassifierDescriptor mo2106getContributedClassifier = getMemberScope().mo2106getContributedClassifier(NameResolverUtilKt.getName(this.c.getNameResolver(), this.classProto.getCompanionObjectName()), NoLookupLocation.FROM_DESERIALIZATION);
        if (mo2106getContributedClassifier instanceof ClassDescriptor) {
            classDescriptor = mo2106getContributedClassifier;
        }
        return classDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<ClassConstructorDescriptor> computeConstructors() {
        return CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) computeSecondaryConstructors(), (Iterable) CollectionsKt__CollectionsKt.listOfNotNull(mo2098getUnsubstitutedPrimaryConstructor())), (Iterable) this.c.getComponents().getAdditionalClassPartsProvider().getConstructors(this));
    }

    private final DeserializedClassMemberScope getMemberScope() {
        return this.memberScopeHolder.getScope(this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    public final DeserializationContext getC() {
        return this.c;
    }

    public final ProtoBuf.Class getClassProto() {
        return this.classProto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo2097getCompanionObjectDescriptor() {
        return this.companionObjectDescriptor.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        return this.constructors.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.c.getTypeDeserializer().getOwnTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        return this.kind;
    }

    public final BinaryVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        return this.modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        return this.sealedSubclasses.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return this.sourceElement;
    }

    public final ProtoContainer.Class getThisAsProtoContainer$deserialization() {
        return this.thisAsProtoContainer;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo2098getUnsubstitutedPrimaryConstructor() {
        return this.primaryConstructor.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        if (Flags.CLASS_KIND.get(this.classProto.getFlags()) == ProtoBuf.Class.Kind.COMPANION_OBJECT) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        Boolean bool = Flags.IS_DATA.get(this.classProto.getFlags());
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_DATA.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        Boolean bool = Flags.IS_EXPECT_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_EXPECT_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        Boolean bool = Flags.IS_EXTERNAL_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_EXTERNAL_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        Boolean bool = Flags.IS_INLINE_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_INLINE_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        Boolean bool = Flags.IS_INNER.get(this.classProto.getFlags());
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_INNER.get(classProto.flags)");
        return bool.booleanValue();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("deserialized ");
        if (isExpect()) {
            str = "expect";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(" class ");
        sb.append(getName());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassConstructorDescriptor computePrimaryConstructor() {
        Object obj;
        if (this.kind.isSingleton()) {
            ClassConstructorDescriptorImpl createPrimaryConstructorForObject = DescriptorFactory.createPrimaryConstructorForObject(this, SourceElement.NO_SOURCE);
            createPrimaryConstructorForObject.setReturnType(getDefaultType());
            return createPrimaryConstructorForObject;
        }
        List<ProtoBuf.Constructor> constructorList = this.classProto.getConstructorList();
        Intrinsics.checkExpressionValueIsNotNull(constructorList, "classProto.constructorList");
        Iterator<T> it = constructorList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                ProtoBuf.Constructor it2 = (ProtoBuf.Constructor) obj;
                Flags.BooleanFlagField booleanFlagField = Flags.IS_SECONDARY;
                Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                if (!booleanFlagField.get(it2.getFlags()).booleanValue()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        ProtoBuf.Constructor constructor = (ProtoBuf.Constructor) obj;
        if (constructor == null) {
            return null;
        }
        return this.c.getMemberDeserializer().loadConstructor(constructor, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<ClassDescriptor> computeSubclassesForSealedClass() {
        if (this.modality != Modality.SEALED) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Integer> fqNames = this.classProto.getSealedSubclassFqNameList();
        Intrinsics.checkExpressionValueIsNotNull(fqNames, "fqNames");
        if (!fqNames.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Integer index : fqNames) {
                DeserializationComponents components = this.c.getComponents();
                NameResolver nameResolver = this.c.getNameResolver();
                Intrinsics.checkExpressionValueIsNotNull(index, "index");
                ClassDescriptor deserializeClass = components.deserializeClass(NameResolverUtilKt.getClassId(nameResolver, index.intValue()));
                if (deserializeClass != null) {
                    arrayList.add(deserializeClass);
                }
            }
            return arrayList;
        }
        return DescriptorUtilsKt.computeSealedSubclasses(this);
    }

    private final List<ClassConstructorDescriptor> computeSecondaryConstructors() {
        List<ProtoBuf.Constructor> constructorList = this.classProto.getConstructorList();
        Intrinsics.checkExpressionValueIsNotNull(constructorList, "classProto.constructorList");
        ArrayList<ProtoBuf.Constructor> arrayList = new ArrayList();
        for (Object obj : constructorList) {
            ProtoBuf.Constructor it = (ProtoBuf.Constructor) obj;
            Flags.BooleanFlagField booleanFlagField = Flags.IS_SECONDARY;
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            Boolean bool = booleanFlagField.get(it.getFlags());
            Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_SECONDARY.get(it.flags)");
            if (bool.booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (ProtoBuf.Constructor it2 : arrayList) {
            MemberDeserializer memberDeserializer = this.c.getMemberDeserializer();
            Intrinsics.checkExpressionValueIsNotNull(it2, "it");
            arrayList2.add(memberDeserializer.loadConstructor(it2, false));
        }
        return arrayList2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScopeImpl getStaticScope() {
        return this.staticScope;
    }
}
