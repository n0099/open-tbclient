package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
/* loaded from: classes2.dex */
public class DeserializedPackageMemberScope extends DeserializedMemberScope {
    public final PackageFragmentDescriptor packageDescriptor;
    public final FqName packageFqName;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1) {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DeserializedPackageMemberScope(PackageFragmentDescriptor packageFragmentDescriptor, ProtoBuf.Package r16, NameResolver nameResolver, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource, DeserializationComponents deserializationComponents, Function0<? extends Collection<Name>> function0) {
        super(r1, r2, r3, r4, function0);
        ProtoBuf.TypeTable typeTable = r16.getTypeTable();
        Intrinsics.checkExpressionValueIsNotNull(typeTable, "proto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable versionRequirementTable = r16.getVersionRequirementTable();
        Intrinsics.checkExpressionValueIsNotNull(versionRequirementTable, "proto.versionRequirementTable");
        DeserializationContext createContext = deserializationComponents.createContext(packageFragmentDescriptor, nameResolver, typeTable2, companion.create(versionRequirementTable), binaryVersion, deserializedContainerSource);
        List<ProtoBuf.Function> functionList = r16.getFunctionList();
        Intrinsics.checkExpressionValueIsNotNull(functionList, "proto.functionList");
        List<ProtoBuf.Property> propertyList = r16.getPropertyList();
        Intrinsics.checkExpressionValueIsNotNull(propertyList, "proto.propertyList");
        List<ProtoBuf.TypeAlias> typeAliasList = r16.getTypeAliasList();
        Intrinsics.checkExpressionValueIsNotNull(typeAliasList, "proto.typeAliasList");
        this.packageDescriptor = packageFragmentDescriptor;
        this.packageFqName = packageFragmentDescriptor.getFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public ClassId createClassId(Name name) {
        return new ClassId(this.packageFqName, name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2108getContributedClassifier(Name name, LookupLocation lookupLocation) {
        recordLookup(name, lookupLocation);
        return super.mo2108getContributedClassifier(name, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1 function1) {
        return getContributedDescriptors(descriptorKindFilter, (Function1<? super Name, Boolean>) function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl
    public void recordLookup(Name name, LookupLocation lookupLocation) {
        UtilsKt.record(getC().getComponents().getLookupTracker(), lookupLocation, this.packageDescriptor, name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Collection<DeclarationDescriptor> computeDescriptors = computeDescriptors(descriptorKindFilter, function1, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories = getC().getComponents().getFictitiousClassDescriptorFactories();
        ArrayList arrayList = new ArrayList();
        for (ClassDescriptorFactory classDescriptorFactory : fictitiousClassDescriptorFactories) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, classDescriptorFactory.getAllContributedClassesIfPossible(this.packageFqName));
        }
        return CollectionsKt___CollectionsKt.plus((Collection) computeDescriptors, (Iterable) arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public Set<Name> getNonDeclaredFunctionNames() {
        return SetsKt__SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public Set<Name> getNonDeclaredVariableNames() {
        return SetsKt__SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public boolean hasClass(Name name) {
        boolean z;
        if (super.hasClass(name)) {
            return true;
        }
        Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories = getC().getComponents().getFictitiousClassDescriptorFactories();
        if (!(fictitiousClassDescriptorFactories instanceof Collection) || !((Collection) fictitiousClassDescriptorFactories).isEmpty()) {
            for (ClassDescriptorFactory classDescriptorFactory : fictitiousClassDescriptorFactories) {
                if (classDescriptorFactory.shouldCreateClass(this.packageFqName, name)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return true;
        }
        return false;
    }
}
