package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes10.dex */
public final class ReflectionTypes {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReflectionTypes.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    public static final Companion Companion = new Companion(null);
    public final Lazy kotlinReflectScope$delegate;
    public final NotFoundClasses notFoundClasses;
    public final ClassLookup kClass$delegate = new ClassLookup(1);
    public final ClassLookup kProperty$delegate = new ClassLookup(1);
    public final ClassLookup kProperty0$delegate = new ClassLookup(1);
    public final ClassLookup kProperty1$delegate = new ClassLookup(2);
    public final ClassLookup kProperty2$delegate = new ClassLookup(3);
    public final ClassLookup kMutableProperty0$delegate = new ClassLookup(1);
    public final ClassLookup kMutableProperty1$delegate = new ClassLookup(2);
    public final ClassLookup kMutableProperty2$delegate = new ClassLookup(3);

    private final MemberScope getKotlinReflectScope() {
        return (MemberScope) this.kotlinReflectScope$delegate.getValue();
    }

    public final ClassDescriptor getKClass() {
        return this.kClass$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* loaded from: classes10.dex */
    public static final class ClassLookup {
        public final int numberOfTypeParameters;

        public ClassLookup(int i) {
            this.numberOfTypeParameters = i;
        }

        public final ClassDescriptor getValue(ReflectionTypes reflectionTypes, KProperty<?> kProperty) {
            return reflectionTypes.find(StringsKt__StringsJVMKt.capitalize(kProperty.getName()), this.numberOfTypeParameters);
        }
    }

    /* loaded from: classes10.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KotlinType createKPropertyStarType(ModuleDescriptor moduleDescriptor) {
            ClassId classId = KotlinBuiltIns.FQ_NAMES.kProperty;
            Intrinsics.checkExpressionValueIsNotNull(classId, "KotlinBuiltIns.FQ_NAMES.kProperty");
            ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, classId);
            if (findClassAcrossModuleDependencies != null) {
                Annotations empty = Annotations.Companion.getEMPTY();
                TypeConstructor typeConstructor = findClassAcrossModuleDependencies.getTypeConstructor();
                Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "kPropertyClass.typeConstructor");
                List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
                Intrinsics.checkExpressionValueIsNotNull(parameters, "kPropertyClass.typeConstructor.parameters");
                Object single = CollectionsKt___CollectionsKt.single((List<? extends Object>) parameters);
                Intrinsics.checkExpressionValueIsNotNull(single, "kPropertyClass.typeConstructor.parameters.single()");
                return KotlinTypeFactory.simpleNotNullType(empty, findClassAcrossModuleDependencies, CollectionsKt__CollectionsJVMKt.listOf(new StarProjectionImpl((TypeParameterDescriptor) single)));
            }
            return null;
        }
    }

    public ReflectionTypes(final ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses) {
        this.notFoundClasses = notFoundClasses;
        this.kotlinReflectScope$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<MemberScope>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes$kotlinReflectScope$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final MemberScope invoke() {
                return ModuleDescriptor.this.getPackage(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME()).getMemberScope();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor find(String str, int i) {
        Name identifier = Name.identifier(str);
        Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(className)");
        ClassifierDescriptor mo2103getContributedClassifier = getKotlinReflectScope().mo2103getContributedClassifier(identifier, NoLookupLocation.FROM_REFLECTION);
        if (!(mo2103getContributedClassifier instanceof ClassDescriptor)) {
            mo2103getContributedClassifier = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) mo2103getContributedClassifier;
        if (classDescriptor == null) {
            return this.notFoundClasses.getClass(new ClassId(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), identifier), CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i)));
        }
        return classDescriptor;
    }
}
