package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
/* loaded from: classes9.dex */
public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    public final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;
    public final JavaPackage jPackage;
    public final NullableLazyValue<Set<String>> knownClassNamesInPackage;
    public final LazyJavaPackageFragment ownerDescriptor;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> collection, Name name) {
    }

    /* loaded from: classes9.dex */
    public static abstract class KotlinClassLookupResult {

        /* loaded from: classes9.dex */
        public static final class Found extends KotlinClassLookupResult {
            public final ClassDescriptor descriptor;

            public Found(ClassDescriptor classDescriptor) {
                super(null);
                this.descriptor = classDescriptor;
            }

            public final ClassDescriptor getDescriptor() {
                return this.descriptor;
            }
        }

        /* loaded from: classes9.dex */
        public static final class NotFound extends KotlinClassLookupResult {
            public static final NotFound INSTANCE = new NotFound();

            public NotFound() {
                super(null);
            }
        }

        /* loaded from: classes9.dex */
        public static final class SyntheticClass extends KotlinClassLookupResult {
            public static final SyntheticClass INSTANCE = new SyntheticClass();

            public SyntheticClass() {
                super(null);
            }
        }

        public KotlinClassLookupResult() {
        }

        public /* synthetic */ KotlinClassLookupResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public static final class FindClassRequest {
        public final JavaClass javaClass;
        public final Name name;

        public FindClassRequest(Name name, JavaClass javaClass) {
            this.name = name;
            this.javaClass = javaClass;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof FindClassRequest) && Intrinsics.areEqual(this.name, ((FindClassRequest) obj).name)) {
                return true;
            }
            return false;
        }

        public final JavaClass getJavaClass() {
            return this.javaClass;
        }

        public final Name getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    public LazyJavaPackageScope(final LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage, LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(lazyJavaResolverContext);
        this.jPackage = javaPackage;
        this.ownerDescriptor = lazyJavaPackageFragment;
        this.knownClassNamesInPackage = lazyJavaResolverContext.getStorageManager().createNullableLazyValue(new Function0<Set<? extends String>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$knownClassNamesInPackage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.Set<java.lang.String>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                return lazyJavaResolverContext.getComponents().getFinder().knownClassNamesInPackage(LazyJavaPackageScope.this.getOwnerDescriptor().getFqName());
            }
        });
        this.classes = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<FindClassRequest, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$classes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final ClassDescriptor invoke(LazyJavaPackageScope.FindClassRequest findClassRequest) {
                KotlinClassFinder.Result findKotlinClassOrContent;
                KotlinJvmBinaryClass kotlinJvmBinaryClass;
                ClassId classId;
                LazyJavaPackageScope.KotlinClassLookupResult resolveKotlinBinaryClass;
                byte[] bArr;
                LightClassOriginKind lightClassOriginKind;
                FqName fqName;
                ClassId classId2 = new ClassId(LazyJavaPackageScope.this.getOwnerDescriptor().getFqName(), findClassRequest.getName());
                if (findClassRequest.getJavaClass() != null) {
                    findKotlinClassOrContent = lazyJavaResolverContext.getComponents().getKotlinClassFinder().findKotlinClassOrContent(findClassRequest.getJavaClass());
                } else {
                    findKotlinClassOrContent = lazyJavaResolverContext.getComponents().getKotlinClassFinder().findKotlinClassOrContent(classId2);
                }
                if (findKotlinClassOrContent != null) {
                    kotlinJvmBinaryClass = findKotlinClassOrContent.toKotlinJvmBinaryClass();
                } else {
                    kotlinJvmBinaryClass = null;
                }
                if (kotlinJvmBinaryClass != null) {
                    classId = kotlinJvmBinaryClass.getClassId();
                } else {
                    classId = null;
                }
                if (classId == null || (!classId.isNestedClass() && !classId.isLocal())) {
                    resolveKotlinBinaryClass = LazyJavaPackageScope.this.resolveKotlinBinaryClass(kotlinJvmBinaryClass);
                    if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.Found) {
                        return ((LazyJavaPackageScope.KotlinClassLookupResult.Found) resolveKotlinBinaryClass).getDescriptor();
                    }
                    if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass) {
                        return null;
                    }
                    if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.NotFound) {
                        JavaClass javaClass = findClassRequest.getJavaClass();
                        if (javaClass == null) {
                            JavaClassFinder finder = lazyJavaResolverContext.getComponents().getFinder();
                            if (findKotlinClassOrContent != null) {
                                if (!(findKotlinClassOrContent instanceof KotlinClassFinder.Result.ClassFileContent)) {
                                    findKotlinClassOrContent = null;
                                }
                                KotlinClassFinder.Result.ClassFileContent classFileContent = (KotlinClassFinder.Result.ClassFileContent) findKotlinClassOrContent;
                                if (classFileContent != null) {
                                    bArr = classFileContent.getContent();
                                    javaClass = finder.findClass(new JavaClassFinder.Request(classId2, bArr, null, 4, null));
                                }
                            }
                            bArr = null;
                            javaClass = finder.findClass(new JavaClassFinder.Request(classId2, bArr, null, 4, null));
                        }
                        JavaClass javaClass2 = javaClass;
                        if (javaClass2 != null) {
                            lightClassOriginKind = javaClass2.getLightClassOriginKind();
                        } else {
                            lightClassOriginKind = null;
                        }
                        if (lightClassOriginKind != LightClassOriginKind.BINARY) {
                            if (javaClass2 != null) {
                                fqName = javaClass2.getFqName();
                            } else {
                                fqName = null;
                            }
                            if (fqName == null || fqName.isRoot() || (!Intrinsics.areEqual(fqName.parent(), LazyJavaPackageScope.this.getOwnerDescriptor().getFqName()))) {
                                return null;
                            }
                            LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(lazyJavaResolverContext, LazyJavaPackageScope.this.getOwnerDescriptor(), javaClass2, null, 8, null);
                            lazyJavaResolverContext.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                            return lazyJavaClassDescriptor;
                        }
                        throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + javaClass2 + "\nClassId: " + classId2 + "\nfindKotlinClass(JavaClass) = " + KotlinClassFinderKt.findKotlinClass(lazyJavaResolverContext.getComponents().getKotlinClassFinder(), javaClass2) + "\nfindKotlinClass(ClassId) = " + KotlinClassFinderKt.findKotlinClass(lazyJavaResolverContext.getComponents().getKotlinClassFinder(), classId2) + '\n');
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return null;
            }
        });
    }

    private final ClassDescriptor findClassifier(Name name, JavaClass javaClass) {
        if (!SpecialNames.isSafeIdentifier(name)) {
            return null;
        }
        Set<String> invoke = this.knownClassNamesInPackage.invoke();
        if (javaClass == null && invoke != null && !invoke.contains(name.asString())) {
            return null;
        }
        return this.classes.invoke(new FindClassRequest(name, javaClass));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeFunctionNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        return SetsKt__SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computePropertyNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        return SetsKt__SetsKt.emptySet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassDescriptor mo2025getContributedClassifier(Name name, LookupLocation lookupLocation) {
        return findClassifier(name, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass == null) {
            return KotlinClassLookupResult.NotFound.INSTANCE;
        }
        if (kotlinJvmBinaryClass.getClassHeader().getKind() == KotlinClassHeader.Kind.CLASS) {
            ClassDescriptor resolveClass = getC().getComponents().getDeserializedDescriptorResolver().resolveClass(kotlinJvmBinaryClass);
            if (resolveClass != null) {
                return new KotlinClassLookupResult.Found(resolveClass);
            }
            return KotlinClassLookupResult.NotFound.INSTANCE;
        }
        return KotlinClassLookupResult.SyntheticClass.INSTANCE;
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass javaClass) {
        return findClassifier(javaClass.getName(), javaClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeClassNames(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Name name;
        if (!descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return SetsKt__SetsKt.emptySet();
        }
        Set<String> invoke = this.knownClassNamesInPackage.invoke();
        if (invoke != null) {
            HashSet hashSet = new HashSet();
            for (String str : invoke) {
                hashSet.add(Name.identifier(str));
            }
            return hashSet;
        }
        JavaPackage javaPackage = this.jPackage;
        if (function1 == null) {
            function1 = FunctionsKt.alwaysTrue();
        }
        Collection<JavaClass> classes = javaPackage.getClasses(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaClass javaClass : classes) {
            if (javaClass.getLightClassOriginKind() == LightClassOriginKind.SOURCE) {
                name = null;
            } else {
                name = javaClass.getName();
            }
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002b A[SYNTHETIC] */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        boolean z;
        if (!descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK() | DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : getAllDescriptors().invoke()) {
            DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
            if (declarationDescriptor instanceof ClassDescriptor) {
                Name name = ((ClassDescriptor) declarationDescriptor).getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "it.name");
                if (function1.invoke(name).booleanValue()) {
                    z = true;
                    if (!z) {
                        arrayList.add(obj);
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}
