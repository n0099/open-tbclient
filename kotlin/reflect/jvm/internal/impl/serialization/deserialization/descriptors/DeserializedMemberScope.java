package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
/* loaded from: classes2.dex */
public abstract class DeserializedMemberScope extends MemberScopeImpl {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "variableNamesLazy", "getVariableNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;"))};
    public final DeserializationContext c;
    public final NotNullLazyValue classNames$delegate;
    public final NotNullLazyValue functionNamesLazy$delegate;
    public final Map<Name, byte[]> functionProtosBytes;
    public final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    public final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
    public final Map<Name, byte[]> propertyProtosBytes;
    public final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
    public final Map<Name, byte[]> typeAliasBytes;
    public final NotNullLazyValue variableNamesLazy$delegate;

    private final Set<Name> getFunctionNamesLazy() {
        return (Set) StorageKt.getValue(this.functionNamesLazy$delegate, this, $$delegatedProperties[0]);
    }

    private final Set<Name> getVariableNamesLazy() {
        return (Set) StorageKt.getValue(this.variableNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    public abstract void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1);

    public void computeNonDeclaredFunctions(Name name, Collection<SimpleFunctionDescriptor> collection) {
    }

    public void computeNonDeclaredProperties(Name name, Collection<PropertyDescriptor> collection) {
    }

    public abstract ClassId createClassId(Name name);

    public final Set<Name> getClassNames$deserialization() {
        return (Set) StorageKt.getValue(this.classNames$delegate, this, $$delegatedProperties[2]);
    }

    public abstract Set<Name> getNonDeclaredFunctionNames();

    public abstract Set<Name> getNonDeclaredVariableNames();

    public DeserializedMemberScope(DeserializationContext deserializationContext, Collection<ProtoBuf.Function> collection, Collection<ProtoBuf.Property> collection2, Collection<ProtoBuf.TypeAlias> collection3, final Function0<? extends Collection<Name>> function0) {
        Map<Name, byte[]> emptyMap;
        this.c = deserializationContext;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : collection) {
            Name name = NameResolverUtilKt.getName(this.c.getNameResolver(), ((ProtoBuf.Function) ((MessageLite) obj)).getName());
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.functionProtosBytes = packToByteArray(linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : collection2) {
            Name name2 = NameResolverUtilKt.getName(this.c.getNameResolver(), ((ProtoBuf.Property) ((MessageLite) obj3)).getName());
            Object obj4 = linkedHashMap2.get(name2);
            if (obj4 == null) {
                obj4 = new ArrayList();
                linkedHashMap2.put(name2, obj4);
            }
            ((List) obj4).add(obj3);
        }
        this.propertyProtosBytes = packToByteArray(linkedHashMap2);
        if (this.c.getComponents().getConfiguration().getTypeAliasesAllowed()) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Object obj5 : collection3) {
                Name name3 = NameResolverUtilKt.getName(this.c.getNameResolver(), ((ProtoBuf.TypeAlias) ((MessageLite) obj5)).getName());
                Object obj6 = linkedHashMap3.get(name3);
                if (obj6 == null) {
                    obj6 = new ArrayList();
                    linkedHashMap3.put(name3, obj6);
                }
                ((List) obj6).add(obj5);
            }
            emptyMap = packToByteArray(linkedHashMap3);
        } else {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        this.typeAliasBytes = emptyMap;
        this.functions = this.c.getStorageManager().createMemoizedFunction(new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$functions$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final Collection<SimpleFunctionDescriptor> invoke(Name name4) {
                Collection<SimpleFunctionDescriptor> computeFunctions;
                computeFunctions = DeserializedMemberScope.this.computeFunctions(name4);
                return computeFunctions;
            }
        });
        this.properties = this.c.getStorageManager().createMemoizedFunction(new Function1<Name, Collection<? extends PropertyDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$properties$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final Collection<PropertyDescriptor> invoke(Name name4) {
                Collection<PropertyDescriptor> computeProperties;
                computeProperties = DeserializedMemberScope.this.computeProperties(name4);
                return computeProperties;
            }
        });
        this.typeAliasByName = this.c.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<Name, TypeAliasDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$typeAliasByName$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final TypeAliasDescriptor invoke(Name name4) {
                TypeAliasDescriptor createTypeAlias;
                createTypeAlias = DeserializedMemberScope.this.createTypeAlias(name4);
                return createTypeAlias;
            }
        });
        this.functionNamesLazy$delegate = this.c.getStorageManager().createLazyValue(new Function0<Set<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$functionNamesLazy$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends Name> invoke() {
                Map map;
                map = DeserializedMemberScope.this.functionProtosBytes;
                return SetsKt___SetsKt.plus(map.keySet(), (Iterable) DeserializedMemberScope.this.getNonDeclaredFunctionNames());
            }
        });
        this.variableNamesLazy$delegate = this.c.getStorageManager().createLazyValue(new Function0<Set<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$variableNamesLazy$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends Name> invoke() {
                Map map;
                map = DeserializedMemberScope.this.propertyProtosBytes;
                return SetsKt___SetsKt.plus(map.keySet(), (Iterable) DeserializedMemberScope.this.getNonDeclaredVariableNames());
            }
        });
        this.classNames$delegate = this.c.getStorageManager().createLazyValue(new Function0<Set<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$classNames$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends Name> invoke() {
                return CollectionsKt___CollectionsKt.toSet((Iterable) Function0.this.invoke());
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2104getContributedClassifier(Name name, LookupLocation lookupLocation) {
        if (hasClass(name)) {
            return deserializeClass(name);
        }
        if (getTypeAliasNames().contains(name)) {
            return this.typeAliasByName.invoke(name);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        if (!getFunctionNames().contains(name)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return this.functions.invoke(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        if (!getVariableNames().contains(name)) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return this.properties.invoke(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TypeAliasDescriptor createTypeAlias(Name name) {
        ProtoBuf.TypeAlias parseDelimitedFrom;
        byte[] bArr = this.typeAliasBytes.get(name);
        if (bArr == null || (parseDelimitedFrom = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), this.c.getComponents().getExtensionRegistryLite())) == null) {
            return null;
        }
        return this.c.getMemberDeserializer().loadTypeAlias(parseDelimitedFrom);
    }

    private final ClassDescriptor deserializeClass(Name name) {
        return this.c.getComponents().deserializeClass(createClassId(name));
    }

    public boolean hasClass(Name name) {
        return getClassNames$deserialization().contains(name);
    }

    private final void addFunctionsAndProperties(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
            Set<Name> variableNames = getVariableNames();
            ArrayList arrayList = new ArrayList();
            for (Name name : variableNames) {
                if (function1.invoke(name).booleanValue()) {
                    arrayList.addAll(getContributedVariables(name, lookupLocation));
                }
            }
            MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(nameAndTypeMemberComparator, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, nameAndTypeMemberComparator);
            collection.addAll(arrayList);
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
            Set<Name> functionNames = getFunctionNames();
            ArrayList arrayList2 = new ArrayList();
            for (Name name2 : functionNames) {
                if (function1.invoke(name2).booleanValue()) {
                    arrayList2.addAll(getContributedFunctions(name2, lookupLocation));
                }
            }
            MemberComparator.NameAndTypeMemberComparator nameAndTypeMemberComparator2 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(nameAndTypeMemberComparator2, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, nameAndTypeMemberComparator2);
            collection.addAll(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r0 != null) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Collection<SimpleFunctionDescriptor> computeFunctions(Name name) {
        List<ProtoBuf.Function> emptyList;
        Map<Name, byte[]> map = this.functionProtosBytes;
        final Parser<ProtoBuf.Function> parser = ProtoBuf.Function.PARSER;
        Intrinsics.checkExpressionValueIsNotNull(parser, "ProtoBuf.Function.PARSER");
        byte[] bArr = map.get(name);
        if (bArr != null) {
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            emptyList = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.generateSequence(new Function0<M>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Incorrect return type in method signature: ()TM; */
                @Override // kotlin.jvm.functions.Function0
                public final MessageLite invoke() {
                    return (MessageLite) parser.parseDelimitedFrom(byteArrayInputStream, this.getC().getComponents().getExtensionRegistryLite());
                }
            }));
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        ArrayList arrayList = new ArrayList();
        for (ProtoBuf.Function it : emptyList) {
            MemberDeserializer memberDeserializer = this.c.getMemberDeserializer();
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            arrayList.add(memberDeserializer.loadFunction(it));
        }
        computeNonDeclaredFunctions(name, arrayList);
        return CollectionsKt.compact(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r0 != null) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Collection<PropertyDescriptor> computeProperties(Name name) {
        List<ProtoBuf.Property> emptyList;
        Map<Name, byte[]> map = this.propertyProtosBytes;
        final Parser<ProtoBuf.Property> parser = ProtoBuf.Property.PARSER;
        Intrinsics.checkExpressionValueIsNotNull(parser, "ProtoBuf.Property.PARSER");
        byte[] bArr = map.get(name);
        if (bArr != null) {
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            emptyList = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.generateSequence(new Function0<M>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Incorrect return type in method signature: ()TM; */
                @Override // kotlin.jvm.functions.Function0
                public final MessageLite invoke() {
                    return (MessageLite) parser.parseDelimitedFrom(byteArrayInputStream, this.getC().getComponents().getExtensionRegistryLite());
                }
            }));
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        ArrayList arrayList = new ArrayList();
        for (ProtoBuf.Property it : emptyList) {
            MemberDeserializer memberDeserializer = this.c.getMemberDeserializer();
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            arrayList.add(memberDeserializer.loadProperty(it));
        }
        computeNonDeclaredProperties(name, arrayList);
        return CollectionsKt.compact(arrayList);
    }

    private final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterable<AbstractMessageLite> iterable = (Iterable) entry.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (AbstractMessageLite abstractMessageLite : iterable) {
                abstractMessageLite.writeDelimitedTo(byteArrayOutputStream);
                arrayList.add(Unit.INSTANCE);
            }
            linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
        }
        return linkedHashMap;
    }

    private final Set<Name> getTypeAliasNames() {
        return this.typeAliasBytes.keySet();
    }

    public final DeserializationContext getC() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return getFunctionNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return getVariableNamesLazy();
    }

    public final Collection<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
        ArrayList arrayList = new ArrayList(0);
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getSINGLETON_CLASSIFIERS_MASK())) {
            addEnumEntryDescriptors(arrayList, function1);
        }
        addFunctionsAndProperties(arrayList, descriptorKindFilter, function1, lookupLocation);
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name name : getClassNames$deserialization()) {
                if (function1.invoke(name).booleanValue()) {
                    CollectionsKt.addIfNotNull(arrayList, deserializeClass(name));
                }
            }
        }
        if (descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK())) {
            for (Name name2 : getTypeAliasNames()) {
                if (function1.invoke(name2).booleanValue()) {
                    CollectionsKt.addIfNotNull(arrayList, this.typeAliasByName.invoke(name2));
                }
            }
        }
        return CollectionsKt.compact(arrayList);
    }
}
