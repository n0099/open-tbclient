package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
/* loaded from: classes10.dex */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProvider {
    public DeserializationComponents components;
    public final KotlinMetadataFinder finder;
    public final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments;
    public final ModuleDescriptor moduleDescriptor;
    public final StorageManager storageManager;

    public abstract DeserializedPackageFragment findPackage(FqName fqName);

    public AbstractDeserializedPackageFragmentProvider(StorageManager storageManager, KotlinMetadataFinder kotlinMetadataFinder, ModuleDescriptor moduleDescriptor) {
        this.storageManager = storageManager;
        this.finder = kotlinMetadataFinder;
        this.moduleDescriptor = moduleDescriptor;
        this.fragments = storageManager.createMemoizedFunctionWithNullableValues(new Function1<FqName, DeserializedPackageFragment>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider$fragments$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final DeserializedPackageFragment invoke(FqName fqName) {
                DeserializedPackageFragment findPackage = AbstractDeserializedPackageFragmentProvider.this.findPackage(fqName);
                if (findPackage != null) {
                    findPackage.initialize(AbstractDeserializedPackageFragmentProvider.this.getComponents());
                    return findPackage;
                }
                return null;
            }
        });
    }

    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("components");
        }
        return deserializationComponents;
    }

    public final KotlinMetadataFinder getFinder() {
        return this.finder;
    }

    public final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        return CollectionsKt__CollectionsKt.listOfNotNull(this.fragments.invoke(fqName));
    }

    public final void setComponents(DeserializationComponents deserializationComponents) {
        this.components = deserializationComponents;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        return SetsKt__SetsKt.emptySet();
    }
}
