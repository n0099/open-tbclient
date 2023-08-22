package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;
/* loaded from: classes2.dex */
public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {
    public final KotlinBuiltIns builtIns;
    public final Map<ModuleDescriptor.Capability<?>, Object> capabilities;
    public ModuleDependencies dependencies;
    public boolean isValid;
    public PackageFragmentProvider packageFragmentProviderForModuleContent;
    public final Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;
    public final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;
    public final TargetPlatform platform;
    public final Name stableName;
    public final StorageManager storageManager;

    @JvmOverloads
    public ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform) {
        this(name, storageManager, kotlinBuiltIns, targetPlatform, null, null, 48, null);
    }

    private final CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies() {
        return (CompositePackageFragmentProvider) this.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue();
    }

    @JvmOverloads
    public ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map<ModuleDescriptor.Capability<?>, ? extends Object> map, Name name2) {
        super(Annotations.Companion.getEMPTY(), name);
        this.storageManager = storageManager;
        this.builtIns = kotlinBuiltIns;
        this.platform = targetPlatform;
        this.stableName = name2;
        if (name.isSpecial()) {
            Map<ModuleDescriptor.Capability<?>, Object> mutableMap = MapsKt__MapsKt.toMutableMap(map);
            this.capabilities = mutableMap;
            mutableMap.put(KotlinTypeRefinerKt.getREFINER_CAPABILITY(), new Ref(null));
            this.isValid = true;
            this.packages = this.storageManager.createMemoizedFunction(new Function1<FqName, LazyPackageViewDescriptorImpl>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packages$1
                {
                    super(1);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final LazyPackageViewDescriptorImpl invoke(FqName fqName) {
                    StorageManager storageManager2;
                    ModuleDescriptorImpl moduleDescriptorImpl = ModuleDescriptorImpl.this;
                    storageManager2 = moduleDescriptorImpl.storageManager;
                    return new LazyPackageViewDescriptorImpl(moduleDescriptorImpl, fqName, storageManager2);
                }
            });
            this.packageFragmentProviderForWholeModuleWithDependencies$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CompositePackageFragmentProvider>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final CompositePackageFragmentProvider invoke() {
                    ModuleDependencies moduleDependencies;
                    String id;
                    PackageFragmentProvider packageFragmentProvider;
                    boolean isInitialized;
                    String id2;
                    String id3;
                    String id4;
                    moduleDependencies = ModuleDescriptorImpl.this.dependencies;
                    if (moduleDependencies != null) {
                        List<ModuleDescriptorImpl> allDependencies = moduleDependencies.getAllDependencies();
                        boolean contains = allDependencies.contains(ModuleDescriptorImpl.this);
                        if (_Assertions.ENABLED && !contains) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Module ");
                            id4 = ModuleDescriptorImpl.this.getId();
                            sb.append(id4);
                            sb.append(" is not contained in his own dependencies, this is probably a misconfiguration");
                            throw new AssertionError(sb.toString());
                        }
                        for (ModuleDescriptorImpl moduleDescriptorImpl : allDependencies) {
                            isInitialized = moduleDescriptorImpl.isInitialized();
                            if (_Assertions.ENABLED && !isInitialized) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Dependency module ");
                                id2 = moduleDescriptorImpl.getId();
                                sb2.append(id2);
                                sb2.append(" was not initialized by the time contents of dependent module ");
                                id3 = ModuleDescriptorImpl.this.getId();
                                sb2.append(id3);
                                sb2.append(" were queried");
                                throw new AssertionError(sb2.toString());
                            }
                        }
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(allDependencies, 10));
                        for (ModuleDescriptorImpl moduleDescriptorImpl2 : allDependencies) {
                            packageFragmentProvider = moduleDescriptorImpl2.packageFragmentProviderForModuleContent;
                            if (packageFragmentProvider == null) {
                                Intrinsics.throwNpe();
                            }
                            arrayList.add(packageFragmentProvider);
                        }
                        return new CompositePackageFragmentProvider(arrayList);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Dependencies of module ");
                    id = ModuleDescriptorImpl.this.getId();
                    sb3.append(id);
                    sb3.append(" were not set before querying module content");
                    throw new AssertionError(sb3.toString());
                }
            });
            return;
        }
        throw new IllegalArgumentException("Module name must be special: " + name);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map map, Name name2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, storageManager, kotlinBuiltIns, r6, r7, r8);
        TargetPlatform targetPlatform2;
        Map map2;
        Name name3;
        if ((i & 8) != 0) {
            targetPlatform2 = null;
        } else {
            targetPlatform2 = targetPlatform;
        }
        if ((i & 16) != 0) {
            map2 = MapsKt__MapsKt.emptyMap();
        } else {
            map2 = map;
        }
        if ((i & 32) != 0) {
            name3 = null;
        } else {
            name3 = name2;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public <T> T getCapability(ModuleDescriptor.Capability<T> capability) {
        T t = (T) this.capabilities.get(capability);
        if (!(t instanceof Object)) {
            return null;
        }
        return t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public PackageViewDescriptor getPackage(FqName fqName) {
        assertValid();
        return this.packages.invoke(fqName);
    }

    public final void initialize(PackageFragmentProvider packageFragmentProvider) {
        boolean z = !isInitialized();
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Attempt to initialize module " + getId() + " twice");
        }
        this.packageFragmentProviderForModuleContent = packageFragmentProvider;
    }

    public final void setDependencies(List<ModuleDescriptorImpl> list) {
        setDependencies(list, SetsKt__SetsKt.emptySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(ModuleDescriptor moduleDescriptor) {
        if (Intrinsics.areEqual(this, moduleDescriptor)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.dependencies;
        if (moduleDependencies == null) {
            Intrinsics.throwNpe();
        }
        if (CollectionsKt___CollectionsKt.contains(moduleDependencies.getModulesWhoseInternalsAreVisible(), moduleDescriptor) || getExpectedByModules().contains(moduleDescriptor) || moduleDescriptor.getExpectedByModules().contains(this)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getId() {
        String name = getName().toString();
        Intrinsics.checkExpressionValueIsNotNull(name, "name.toString()");
        return name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInitialized() {
        if (this.packageFragmentProviderForModuleContent != null) {
            return true;
        }
        return false;
    }

    public void assertValid() {
        if (isValid()) {
            return;
        }
        throw new InvalidModuleException("Accessing invalid module descriptor " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies moduleDependencies = this.dependencies;
        if (moduleDependencies != null) {
            return moduleDependencies.getExpectedByDependencies();
        }
        throw new AssertionError("Dependencies of module " + getId() + " were not set");
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    public boolean isValid() {
        return this.isValid;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return (R) ModuleDescriptor.DefaultImpls.accept(this, declarationDescriptorVisitor, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(fqName, function1);
    }

    public final void setDependencies(List<ModuleDescriptorImpl> list, Set<ModuleDescriptorImpl> set) {
        setDependencies(new ModuleDependenciesImpl(list, set, CollectionsKt__CollectionsKt.emptyList()));
    }

    public final void setDependencies(ModuleDependencies moduleDependencies) {
        boolean z;
        if (this.dependencies == null) {
            z = true;
        } else {
            z = false;
        }
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Dependencies of " + getId() + " were already set");
        }
        this.dependencies = moduleDependencies;
    }

    public final void setDependencies(ModuleDescriptorImpl... moduleDescriptorImplArr) {
        setDependencies(ArraysKt___ArraysKt.toList(moduleDescriptorImplArr));
    }
}
