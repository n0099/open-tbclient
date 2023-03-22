package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
/* loaded from: classes9.dex */
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {
    public MemberScope _memberScope;
    public ProtoBuf.PackageFragment _proto;
    public final ProtoBasedClassDataFinder classDataFinder;
    public final DeserializedContainerSource containerSource;
    public final BinaryVersion metadataVersion;
    public final NameResolverImpl nameResolver;

    public DeserializedPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource) {
        super(fqName, storageManager, moduleDescriptor);
        this.metadataVersion = binaryVersion;
        this.containerSource = deserializedContainerSource;
        ProtoBuf.StringTable strings = packageFragment.getStrings();
        Intrinsics.checkExpressionValueIsNotNull(strings, "proto.strings");
        ProtoBuf.QualifiedNameTable qualifiedNames = packageFragment.getQualifiedNames();
        Intrinsics.checkExpressionValueIsNotNull(qualifiedNames, "proto.qualifiedNames");
        NameResolverImpl nameResolverImpl = new NameResolverImpl(strings, qualifiedNames);
        this.nameResolver = nameResolverImpl;
        this.classDataFinder = new ProtoBasedClassDataFinder(packageFragment, nameResolverImpl, this.metadataVersion, new Function1<ClassId, SourceElement>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$classDataFinder$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final SourceElement invoke(ClassId classId) {
                DeserializedContainerSource deserializedContainerSource2;
                deserializedContainerSource2 = DeserializedPackageFragmentImpl.this.containerSource;
                if (deserializedContainerSource2 == null) {
                    SourceElement sourceElement = SourceElement.NO_SOURCE;
                    Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
                    return sourceElement;
                }
                return deserializedContainerSource2;
            }
        });
        this._proto = packageFragment;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public void initialize(DeserializationComponents deserializationComponents) {
        ProtoBuf.PackageFragment packageFragment = this._proto;
        if (packageFragment != null) {
            this._proto = null;
            ProtoBuf.Package r4 = packageFragment.getPackage();
            Intrinsics.checkExpressionValueIsNotNull(r4, "proto.`package`");
            this._memberScope = new DeserializedPackageMemberScope(this, r4, this.nameResolver, this.metadataVersion, this.containerSource, deserializationComponents, new Function0<List<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$initialize$1
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.name.Name>' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public final List<? extends Name> invoke() {
                    boolean z;
                    Collection<ClassId> allClassIds = DeserializedPackageFragmentImpl.this.getClassDataFinder().getAllClassIds();
                    ArrayList<ClassId> arrayList = new ArrayList();
                    for (Object obj : allClassIds) {
                        ClassId classId = (ClassId) obj;
                        if (!classId.isNestedClass() && !ClassDeserializer.Companion.getBLACK_LIST().contains(classId)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                    for (ClassId classId2 : arrayList) {
                        arrayList2.add(classId2.getShortClassName());
                    }
                    return arrayList2;
                }
            });
            return;
        }
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public MemberScope getMemberScope() {
        MemberScope memberScope = this._memberScope;
        if (memberScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
        }
        return memberScope;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }
}
