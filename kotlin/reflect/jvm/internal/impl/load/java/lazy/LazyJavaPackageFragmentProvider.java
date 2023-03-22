package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.List;
import kotlin.LazyKt__LazyKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
/* loaded from: classes9.dex */
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProvider {
    public final LazyJavaResolverContext c;
    public final CacheWithNotNullValues<FqName, LazyJavaPackageFragment> packageFragments;

    public LazyJavaPackageFragmentProvider(JavaResolverComponents javaResolverComponents) {
        LazyJavaResolverContext lazyJavaResolverContext = new LazyJavaResolverContext(javaResolverComponents, TypeParameterResolver.EMPTY.INSTANCE, LazyKt__LazyKt.lazyOf(null));
        this.c = lazyJavaResolverContext;
        this.packageFragments = lazyJavaResolverContext.getStorageManager().createCacheWithNotNullValues();
    }

    private final LazyJavaPackageFragment getPackageFragment(FqName fqName) {
        final JavaPackage findPackage = this.c.getComponents().getFinder().findPackage(fqName);
        if (findPackage != null) {
            return this.packageFragments.computeIfAbsent(fqName, new Function0<LazyJavaPackageFragment>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider$getPackageFragment$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final LazyJavaPackageFragment invoke() {
                    LazyJavaResolverContext lazyJavaResolverContext;
                    lazyJavaResolverContext = LazyJavaPackageFragmentProvider.this.c;
                    return new LazyJavaPackageFragment(lazyJavaResolverContext, findPackage);
                }
            });
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<LazyJavaPackageFragment> getPackageFragments(FqName fqName) {
        return CollectionsKt__CollectionsKt.listOfNotNull(getPackageFragment(fqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public /* bridge */ /* synthetic */ Collection getSubPackagesOf(FqName fqName, Function1 function1) {
        return getSubPackagesOf(fqName, (Function1<? super Name, Boolean>) function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        List<FqName> list;
        LazyJavaPackageFragment packageFragment = getPackageFragment(fqName);
        if (packageFragment != null) {
            list = packageFragment.getSubPackageFqNames$descriptors_jvm();
        } else {
            list = null;
        }
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }
}
