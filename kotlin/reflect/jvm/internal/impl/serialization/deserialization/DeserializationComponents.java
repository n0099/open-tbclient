package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl;
/* loaded from: classes9.dex */
public final class DeserializationComponents {
    public final AdditionalClassPartsProvider additionalClassPartsProvider;
    public final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader;
    public final ClassDataFinder classDataFinder;
    public final ClassDeserializer classDeserializer;
    public final DeserializationConfiguration configuration;
    public final ContractDeserializer contractDeserializer;
    public final ErrorReporter errorReporter;
    public final ExtensionRegistryLite extensionRegistryLite;
    public final Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories;
    public final FlexibleTypeDeserializer flexibleTypeDeserializer;
    public final NewKotlinTypeChecker kotlinTypeChecker;
    public final LocalClassifierTypeSettings localClassifierTypeSettings;
    public final LookupTracker lookupTracker;
    public final ModuleDescriptor moduleDescriptor;
    public final NotFoundClasses notFoundClasses;
    public final PackageFragmentProvider packageFragmentProvider;
    public final PlatformDependentDeclarationFilter platformDependentDeclarationFilter;
    public final StorageManager storageManager;

    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: java.lang.Iterable<? extends kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public DeserializationComponents(StorageManager storageManager, ModuleDescriptor moduleDescriptor, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder, AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends ConstantValue<?>> annotationAndConstantLoader, PackageFragmentProvider packageFragmentProvider, LocalClassifierTypeSettings localClassifierTypeSettings, ErrorReporter errorReporter, LookupTracker lookupTracker, FlexibleTypeDeserializer flexibleTypeDeserializer, Iterable<? extends ClassDescriptorFactory> iterable, NotFoundClasses notFoundClasses, ContractDeserializer contractDeserializer, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, ExtensionRegistryLite extensionRegistryLite, NewKotlinTypeChecker newKotlinTypeChecker) {
        this.storageManager = storageManager;
        this.moduleDescriptor = moduleDescriptor;
        this.configuration = deserializationConfiguration;
        this.classDataFinder = classDataFinder;
        this.annotationAndConstantLoader = annotationAndConstantLoader;
        this.packageFragmentProvider = packageFragmentProvider;
        this.localClassifierTypeSettings = localClassifierTypeSettings;
        this.errorReporter = errorReporter;
        this.lookupTracker = lookupTracker;
        this.flexibleTypeDeserializer = flexibleTypeDeserializer;
        this.fictitiousClassDescriptorFactories = iterable;
        this.notFoundClasses = notFoundClasses;
        this.contractDeserializer = contractDeserializer;
        this.additionalClassPartsProvider = additionalClassPartsProvider;
        this.platformDependentDeclarationFilter = platformDependentDeclarationFilter;
        this.extensionRegistryLite = extensionRegistryLite;
        this.kotlinTypeChecker = newKotlinTypeChecker;
        this.classDeserializer = new ClassDeserializer(this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DeserializationComponents(StorageManager storageManager, ModuleDescriptor moduleDescriptor, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder, AnnotationAndConstantLoader annotationAndConstantLoader, PackageFragmentProvider packageFragmentProvider, LocalClassifierTypeSettings localClassifierTypeSettings, ErrorReporter errorReporter, LookupTracker lookupTracker, FlexibleTypeDeserializer flexibleTypeDeserializer, Iterable iterable, NotFoundClasses notFoundClasses, ContractDeserializer contractDeserializer, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, ExtensionRegistryLite extensionRegistryLite, NewKotlinTypeChecker newKotlinTypeChecker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, moduleDescriptor, deserializationConfiguration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, localClassifierTypeSettings, errorReporter, lookupTracker, flexibleTypeDeserializer, iterable, notFoundClasses, contractDeserializer, r16, r17, extensionRegistryLite, r19);
        AdditionalClassPartsProvider.None none;
        PlatformDependentDeclarationFilter.All all;
        NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl;
        if ((i & 8192) != 0) {
            none = AdditionalClassPartsProvider.None.INSTANCE;
        } else {
            none = additionalClassPartsProvider;
        }
        if ((i & 16384) != 0) {
            all = PlatformDependentDeclarationFilter.All.INSTANCE;
        } else {
            all = platformDependentDeclarationFilter;
        }
        if ((i & 65536) != 0) {
            newKotlinTypeCheckerImpl = NewKotlinTypeChecker.Companion.getDefault();
        } else {
            newKotlinTypeCheckerImpl = newKotlinTypeChecker;
        }
    }

    public final DeserializationContext createContext(PackageFragmentDescriptor packageFragmentDescriptor, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource) {
        return new DeserializationContext(this, nameResolver, packageFragmentDescriptor, typeTable, versionRequirementTable, binaryVersion, deserializedContainerSource, null, CollectionsKt__CollectionsKt.emptyList());
    }

    public final ClassDescriptor deserializeClass(ClassId classId) {
        return ClassDeserializer.deserializeClass$default(this.classDeserializer, classId, null, 2, null);
    }

    public final AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return this.additionalClassPartsProvider;
    }

    public final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> getAnnotationAndConstantLoader() {
        return this.annotationAndConstantLoader;
    }

    public final ClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    public final ClassDeserializer getClassDeserializer() {
        return this.classDeserializer;
    }

    public final DeserializationConfiguration getConfiguration() {
        return this.configuration;
    }

    public final ContractDeserializer getContractDeserializer() {
        return this.contractDeserializer;
    }

    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final ExtensionRegistryLite getExtensionRegistryLite() {
        return this.extensionRegistryLite;
    }

    public final Iterable<ClassDescriptorFactory> getFictitiousClassDescriptorFactories() {
        return this.fictitiousClassDescriptorFactories;
    }

    public final FlexibleTypeDeserializer getFlexibleTypeDeserializer() {
        return this.flexibleTypeDeserializer;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.kotlinTypeChecker;
    }

    public final LocalClassifierTypeSettings getLocalClassifierTypeSettings() {
        return this.localClassifierTypeSettings;
    }

    public final LookupTracker getLookupTracker() {
        return this.lookupTracker;
    }

    public final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    public final NotFoundClasses getNotFoundClasses() {
        return this.notFoundClasses;
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        return this.packageFragmentProvider;
    }

    public final PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return this.platformDependentDeclarationFilter;
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }
}
