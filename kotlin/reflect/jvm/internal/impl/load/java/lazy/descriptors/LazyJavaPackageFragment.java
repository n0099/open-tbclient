package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
/* loaded from: classes2.dex */
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    public final Annotations annotations;
    public final NotNullLazyValue binaryClasses$delegate;
    public final LazyJavaResolverContext c;
    public final JavaPackage jPackage;
    public final NotNullLazyValue partToFacade$delegate;
    public final JvmPackageScope scope;
    public final NotNullLazyValue<List<FqName>> subPackages;

    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
            $EnumSwitchMapping$0[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
        }
    }

    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) StorageKt.getValue(this.binaryClasses$delegate, this, $$delegatedProperties[0]);
    }

    public LazyJavaPackageFragment(LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage) {
        super(lazyJavaResolverContext.getModule(), javaPackage.getFqName());
        Annotations resolveAnnotations;
        this.jPackage = javaPackage;
        LazyJavaResolverContext childForClassOrPackage$default = ContextKt.childForClassOrPackage$default(lazyJavaResolverContext, this, null, 0, 6, null);
        this.c = childForClassOrPackage$default;
        this.binaryClasses$delegate = childForClassOrPackage$default.getStorageManager().createLazyValue(new Function0<Map<String, ? extends KotlinJvmBinaryClass>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$binaryClasses$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends KotlinJvmBinaryClass> invoke() {
                LazyJavaResolverContext lazyJavaResolverContext2;
                LazyJavaResolverContext lazyJavaResolverContext3;
                Pair pair;
                lazyJavaResolverContext2 = LazyJavaPackageFragment.this.c;
                PackagePartProvider packagePartProvider = lazyJavaResolverContext2.getComponents().getPackagePartProvider();
                String asString = LazyJavaPackageFragment.this.getFqName().asString();
                Intrinsics.checkExpressionValueIsNotNull(asString, "fqName.asString()");
                List<String> findPackageParts = packagePartProvider.findPackageParts(asString);
                ArrayList arrayList = new ArrayList();
                for (String str : findPackageParts) {
                    JvmClassName byInternalName = JvmClassName.byInternalName(str);
                    Intrinsics.checkExpressionValueIsNotNull(byInternalName, "JvmClassName.byInternalName(partName)");
                    ClassId classId = ClassId.topLevel(byInternalName.getFqNameForTopLevelClassMaybeWithDollars());
                    Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(JvmClas…velClassMaybeWithDollars)");
                    lazyJavaResolverContext3 = LazyJavaPackageFragment.this.c;
                    KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(lazyJavaResolverContext3.getComponents().getKotlinClassFinder(), classId);
                    if (findKotlinClass != null) {
                        pair = TuplesKt.to(str, findKotlinClass);
                    } else {
                        pair = null;
                    }
                    if (pair != null) {
                        arrayList.add(pair);
                    }
                }
                return MapsKt__MapsKt.toMap(arrayList);
            }
        });
        this.scope = new JvmPackageScope(this.c, this.jPackage, this);
        this.subPackages = this.c.getStorageManager().createRecursionTolerantLazyValue(new Function0<List<? extends FqName>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$subPackages$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends FqName> invoke() {
                JavaPackage javaPackage2;
                javaPackage2 = LazyJavaPackageFragment.this.jPackage;
                Collection<JavaPackage> subPackages = javaPackage2.getSubPackages();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subPackages, 10));
                for (JavaPackage javaPackage3 : subPackages) {
                    arrayList.add(javaPackage3.getFqName());
                }
                return arrayList;
            }
        }, CollectionsKt__CollectionsKt.emptyList());
        if (this.c.getComponents().getAnnotationTypeQualifierResolver().getDisabled()) {
            resolveAnnotations = Annotations.Companion.getEMPTY();
        } else {
            resolveAnnotations = LazyJavaAnnotationsKt.resolveAnnotations(this.c, this.jPackage);
        }
        this.annotations = resolveAnnotations;
        this.partToFacade$delegate = this.c.getStorageManager().createLazyValue(new Function0<HashMap<JvmClassName, JvmClassName>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$partToFacade$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<JvmClassName, JvmClassName> invoke() {
                HashMap<JvmClassName, JvmClassName> hashMap = new HashMap<>();
                for (Map.Entry<String, KotlinJvmBinaryClass> entry : LazyJavaPackageFragment.this.getBinaryClasses$descriptors_jvm().entrySet()) {
                    JvmClassName byInternalName = JvmClassName.byInternalName(entry.getKey());
                    Intrinsics.checkExpressionValueIsNotNull(byInternalName, "JvmClassName.byInternalName(partInternalName)");
                    KotlinClassHeader classHeader = entry.getValue().getClassHeader();
                    int i = LazyJavaPackageFragment.WhenMappings.$EnumSwitchMapping$0[classHeader.getKind().ordinal()];
                    if (i != 1) {
                        if (i == 2) {
                            hashMap.put(byInternalName, byInternalName);
                        }
                    } else {
                        String multifileClassName = classHeader.getMultifileClassName();
                        if (multifileClassName != null) {
                            JvmClassName byInternalName2 = JvmClassName.byInternalName(multifileClassName);
                            Intrinsics.checkExpressionValueIsNotNull(byInternalName2, "JvmClassName.byInternalN…: continue@kotlinClasses)");
                            hashMap.put(byInternalName, byInternalName2);
                        }
                    }
                }
                return hashMap;
            }
        });
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass javaClass) {
        return this.scope.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(javaClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public JvmPackageScope getMemberScope() {
        return this.scope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return this.subPackages.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "Lazy Java package fragment: " + getFqName();
    }
}
