package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
/* loaded from: classes9.dex */
public final class LazyPackageViewDescriptorImpl extends DeclarationDescriptorImpl implements PackageViewDescriptor {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;"))};
    public final FqName fqName;
    public final NotNullLazyValue fragments$delegate;
    public final MemberScope memberScope;
    public final ModuleDescriptorImpl module;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public List<PackageFragmentDescriptor> getFragments() {
        return (List) StorageKt.getValue(this.fragments$delegate, this, $$delegatedProperties[0]);
    }

    public LazyPackageViewDescriptorImpl(ModuleDescriptorImpl moduleDescriptorImpl, FqName fqName, StorageManager storageManager) {
        super(Annotations.Companion.getEMPTY(), fqName.shortNameOrSpecial());
        this.module = moduleDescriptorImpl;
        this.fqName = fqName;
        this.fragments$delegate = storageManager.createLazyValue(new Function0<List<? extends PackageFragmentDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$fragments$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends PackageFragmentDescriptor> invoke() {
                return LazyPackageViewDescriptorImpl.this.getModule().getPackageFragmentProvider().getPackageFragments(LazyPackageViewDescriptorImpl.this.getFqName());
            }
        });
        this.memberScope = new LazyScopeAdapter(storageManager.createLazyValue(new Function0<MemberScope>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl$memberScope$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final MemberScope invoke() {
                if (LazyPackageViewDescriptorImpl.this.getFragments().isEmpty()) {
                    return MemberScope.Empty.INSTANCE;
                }
                List<PackageFragmentDescriptor> fragments = LazyPackageViewDescriptorImpl.this.getFragments();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(fragments, 10));
                for (PackageFragmentDescriptor packageFragmentDescriptor : fragments) {
                    arrayList.add(packageFragmentDescriptor.getMemberScope());
                }
                List plus = CollectionsKt___CollectionsKt.plus((Collection<? extends SubpackagesScope>) arrayList, new SubpackagesScope(LazyPackageViewDescriptorImpl.this.getModule(), LazyPackageViewDescriptorImpl.this.getFqName()));
                return new ChainedMemberScope("package view scope for " + LazyPackageViewDescriptorImpl.this.getFqName() + " in " + LazyPackageViewDescriptorImpl.this.getModule().getName(), plus);
            }
        }));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPackageViewDescriptor(this, d);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PackageViewDescriptor)) {
            obj = null;
        }
        PackageViewDescriptor packageViewDescriptor = (PackageViewDescriptor) obj;
        if (packageViewDescriptor == null || !Intrinsics.areEqual(getFqName(), packageViewDescriptor.getFqName()) || !Intrinsics.areEqual(getModule(), packageViewDescriptor.getModule())) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public int hashCode() {
        return (getModule().hashCode() * 31) + getFqName().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public boolean isEmpty() {
        return PackageViewDescriptor.DefaultImpls.isEmpty(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().isRoot()) {
            return null;
        }
        ModuleDescriptorImpl module = getModule();
        FqName parent = getFqName().parent();
        Intrinsics.checkExpressionValueIsNotNull(parent, "fqName.parent()");
        return module.getPackage(parent);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor
    public ModuleDescriptorImpl getModule() {
        return this.module;
    }
}
