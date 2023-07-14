package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
/* loaded from: classes2.dex */
public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {
    public final StorageManager storageManager;

    public abstract ClassDataFinder getClassDataFinder();

    public abstract void initialize(DeserializationComponents deserializationComponents);

    public DeserializedPackageFragment(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor) {
        super(moduleDescriptor, fqName);
        this.storageManager = storageManager;
    }

    public boolean hasTopLevelClass(Name name) {
        MemberScope memberScope = getMemberScope();
        if ((memberScope instanceof DeserializedMemberScope) && ((DeserializedMemberScope) memberScope).getClassNames$deserialization().contains(name)) {
            return true;
        }
        return false;
    }
}
