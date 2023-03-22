package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
/* loaded from: classes9.dex */
public final class JvmBuiltInClassDescriptorFactory implements ClassDescriptorFactory {
    public static final ClassId CLONEABLE_CLASS_ID;
    public static final Name CLONEABLE_NAME;
    public final NotNullLazyValue cloneable$delegate;
    public final Function1<ModuleDescriptor, DeclarationDescriptor> computeContainingDeclaration;
    public final ModuleDescriptor moduleDescriptor;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInClassDescriptorFactory.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    public static final Companion Companion = new Companion(null);
    public static final FqName KOTLIN_FQ_NAME = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;

    private final ClassDescriptorImpl getCloneable() {
        return (ClassDescriptorImpl) StorageKt.getValue(this.cloneable$delegate, this, $$delegatedProperties[0]);
    }

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public final ClassId getCLONEABLE_CLASS_ID() {
            return JvmBuiltInClassDescriptorFactory.CLONEABLE_CLASS_ID;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Name shortName = KotlinBuiltIns.FQ_NAMES.cloneable.shortName();
        Intrinsics.checkExpressionValueIsNotNull(shortName, "KotlinBuiltIns.FQ_NAMES.cloneable.shortName()");
        CLONEABLE_NAME = shortName;
        ClassId classId = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.cloneable.toSafe());
        Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(KotlinB…NAMES.cloneable.toSafe())");
        CLONEABLE_CLASS_ID = classId;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, ? extends kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    public JvmBuiltInClassDescriptorFactory(final StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1<? super ModuleDescriptor, ? extends DeclarationDescriptor> function1) {
        this.moduleDescriptor = moduleDescriptor;
        this.computeContainingDeclaration = function1;
        this.cloneable$delegate = storageManager.createLazyValue(new Function0<ClassDescriptorImpl>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory$cloneable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final ClassDescriptorImpl invoke() {
                Function1 function12;
                ModuleDescriptor moduleDescriptor2;
                Name name;
                ModuleDescriptor moduleDescriptor3;
                function12 = JvmBuiltInClassDescriptorFactory.this.computeContainingDeclaration;
                moduleDescriptor2 = JvmBuiltInClassDescriptorFactory.this.moduleDescriptor;
                DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) function12.invoke(moduleDescriptor2);
                name = JvmBuiltInClassDescriptorFactory.CLONEABLE_NAME;
                Modality modality = Modality.ABSTRACT;
                ClassKind classKind = ClassKind.INTERFACE;
                moduleDescriptor3 = JvmBuiltInClassDescriptorFactory.this.moduleDescriptor;
                ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(declarationDescriptor, name, modality, classKind, CollectionsKt__CollectionsJVMKt.listOf(moduleDescriptor3.getBuiltIns().getAnyType()), SourceElement.NO_SOURCE, false, storageManager);
                classDescriptorImpl.initialize(new CloneableClassScope(storageManager, classDescriptorImpl), SetsKt__SetsKt.emptySet(), null);
                return classDescriptorImpl;
            }
        });
    }

    public /* synthetic */ JvmBuiltInClassDescriptorFactory(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager, moduleDescriptor, (i & 4) != 0 ? new Function1<ModuleDescriptor, BuiltInsPackageFragment>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final BuiltInsPackageFragment invoke(ModuleDescriptor moduleDescriptor2) {
                FqName KOTLIN_FQ_NAME2 = JvmBuiltInClassDescriptorFactory.KOTLIN_FQ_NAME;
                Intrinsics.checkExpressionValueIsNotNull(KOTLIN_FQ_NAME2, "KOTLIN_FQ_NAME");
                List<PackageFragmentDescriptor> fragments = moduleDescriptor2.getPackage(KOTLIN_FQ_NAME2).getFragments();
                ArrayList arrayList = new ArrayList();
                for (Object obj : fragments) {
                    if (obj instanceof BuiltInsPackageFragment) {
                        arrayList.add(obj);
                    }
                }
                return (BuiltInsPackageFragment) CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            }
        } : function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        if (Intrinsics.areEqual(classId, CLONEABLE_CLASS_ID)) {
            return getCloneable();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName) {
        if (Intrinsics.areEqual(fqName, KOTLIN_FQ_NAME)) {
            return SetsKt__SetsJVMKt.setOf(getCloneable());
        }
        return SetsKt__SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName fqName, Name name) {
        if (Intrinsics.areEqual(name, CLONEABLE_NAME) && Intrinsics.areEqual(fqName, KOTLIN_FQ_NAME)) {
            return true;
        }
        return false;
    }
}
