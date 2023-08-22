package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
/* loaded from: classes2.dex */
public class JvmBuiltInsSettings implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    public static final Set<String> BLACK_LIST_CONSTRUCTOR_SIGNATURES;
    public static final Set<String> BLACK_LIST_METHOD_SIGNATURES;
    public static final Set<String> MUTABLE_METHOD_SIGNATURES;
    public static final Set<String> WHITE_LIST_CONSTRUCTOR_SIGNATURES;
    public static final Set<String> WHITE_LIST_METHOD_SIGNATURES;
    public final NotNullLazyValue cloneableType$delegate;
    public final Lazy isAdditionalBuiltInsFeatureSupported$delegate;
    public final JavaToKotlinClassMap j2kClassMap = JavaToKotlinClassMap.INSTANCE;
    public final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    public final KotlinType mockSerializableType;
    public final ModuleDescriptor moduleDescriptor;
    public final NotNullLazyValue notConsideredDeprecation$delegate;
    public final Lazy ownerModuleDescriptor$delegate;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsSettings.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsSettings.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    public static final Companion Companion = new Companion(null);
    public static final Set<String> DROP_LIST_METHOD_SIGNATURES = SetsKt___SetsKt.plus(SignatureBuildingComponents.INSTANCE.inJavaUtil("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");

    /* loaded from: classes2.dex */
    public enum JDKMemberStatus {
        BLACK_LIST,
        WHITE_LIST,
        NOT_CONSIDERED,
        DROP
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JDKMemberStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[JDKMemberStatus.BLACK_LIST.ordinal()] = 1;
            $EnumSwitchMapping$0[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 2;
            $EnumSwitchMapping$0[JDKMemberStatus.DROP.ordinal()] = 3;
            $EnumSwitchMapping$0[JDKMemberStatus.WHITE_LIST.ordinal()] = 4;
        }
    }

    private final SimpleType getCloneableType() {
        return (SimpleType) StorageKt.getValue(this.cloneableType$delegate, this, $$delegatedProperties[0]);
    }

    private final Annotations getNotConsideredDeprecation() {
        return (Annotations) StorageKt.getValue(this.notConsideredDeprecation$delegate, this, $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ModuleDescriptor getOwnerModuleDescriptor() {
        return (ModuleDescriptor) this.ownerModuleDescriptor$delegate.getValue();
    }

    private final boolean isAdditionalBuiltInsFeatureSupported() {
        return ((Boolean) this.isAdditionalBuiltInsFeatureSupported$delegate.getValue()).booleanValue();
    }

    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public final Set<String> getBLACK_LIST_METHOD_SIGNATURES() {
            return JvmBuiltInsSettings.BLACK_LIST_METHOD_SIGNATURES;
        }

        public final Set<String> getDROP_LIST_METHOD_SIGNATURES() {
            return JvmBuiltInsSettings.DROP_LIST_METHOD_SIGNATURES;
        }

        public final Set<String> getWHITE_LIST_METHOD_SIGNATURES() {
            return JvmBuiltInsSettings.WHITE_LIST_METHOD_SIGNATURES;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isArrayOrPrimitiveArray(FqNameUnsafe fqNameUnsafe) {
            if (!Intrinsics.areEqual(fqNameUnsafe, KotlinBuiltIns.FQ_NAMES.array) && !KotlinBuiltIns.isPrimitiveArray(fqNameUnsafe)) {
                return false;
            }
            return true;
        }

        public final boolean isSerializableInJava(FqNameUnsafe fqNameUnsafe) {
            if (isArrayOrPrimitiveArray(fqNameUnsafe)) {
                return true;
            }
            ClassId mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqNameUnsafe);
            if (mapKotlinToJava != null) {
                try {
                    return Serializable.class.isAssignableFrom(Class.forName(mapKotlinToJava.asSingleFqName().asString()));
                } catch (ClassNotFoundException unused) {
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<String> buildPrimitiveStringConstructorsSet() {
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            List<JvmPrimitiveType> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.BYTE, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, JvmPrimitiveType.BYTE, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT});
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (JvmPrimitiveType jvmPrimitiveType : listOf) {
                String asString = jvmPrimitiveType.getWrapperFqName().shortName().asString();
                Intrinsics.checkExpressionValueIsNotNull(asString, "it.wrapperFqName.shortName().asString()");
                String[] constructors = signatureBuildingComponents.constructors("Ljava/lang/String;");
                CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, signatureBuildingComponents.inJavaLang(asString, (String[]) Arrays.copyOf(constructors, constructors.length)));
            }
            return linkedHashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<String> buildPrimitiveValueMethodsSet() {
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            List<JvmPrimitiveType> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR});
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (JvmPrimitiveType jvmPrimitiveType : listOf) {
                String asString = jvmPrimitiveType.getWrapperFqName().shortName().asString();
                Intrinsics.checkExpressionValueIsNotNull(asString, "it.wrapperFqName.shortName().asString()");
                CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, signatureBuildingComponents.inJavaLang(asString, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
            }
            return linkedHashSet;
        }
    }

    static {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        BLACK_LIST_METHOD_SIGNATURES = SetsKt___SetsKt.plus(SetsKt___SetsKt.plus(SetsKt___SetsKt.plus(SetsKt___SetsKt.plus(SetsKt___SetsKt.plus(Companion.buildPrimitiveValueMethodsSet(), (Iterable) signatureBuildingComponents.inJavaUtil("List", "sort(Ljava/util/Comparator;)V")), (Iterable) signatureBuildingComponents.inJavaLang("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), (Iterable) signatureBuildingComponents.inJavaLang("Double", "isInfinite()Z", "isNaN()Z")), (Iterable) signatureBuildingComponents.inJavaLang("Float", "isInfinite()Z", "isNaN()Z")), (Iterable) signatureBuildingComponents.inJavaLang("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V"));
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.INSTANCE;
        WHITE_LIST_METHOD_SIGNATURES = SetsKt___SetsKt.plus(SetsKt___SetsKt.plus(SetsKt___SetsKt.plus(SetsKt___SetsKt.plus(SetsKt___SetsKt.plus(SetsKt___SetsKt.plus((Set) signatureBuildingComponents2.inJavaLang("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), (Iterable) signatureBuildingComponents2.inJavaUtil("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), (Iterable) signatureBuildingComponents2.inJavaLang("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), (Iterable) signatureBuildingComponents2.inJavaLang("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), (Iterable) signatureBuildingComponents2.inJavaUtil("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), (Iterable) signatureBuildingComponents2.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), (Iterable) signatureBuildingComponents2.inJavaUtil("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        SignatureBuildingComponents signatureBuildingComponents3 = SignatureBuildingComponents.INSTANCE;
        MUTABLE_METHOD_SIGNATURES = SetsKt___SetsKt.plus(SetsKt___SetsKt.plus((Set) signatureBuildingComponents3.inJavaUtil("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), (Iterable) signatureBuildingComponents3.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), (Iterable) signatureBuildingComponents3.inJavaUtil("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        SignatureBuildingComponents signatureBuildingComponents4 = SignatureBuildingComponents.INSTANCE;
        Set buildPrimitiveStringConstructorsSet = Companion.buildPrimitiveStringConstructorsSet();
        String[] constructors = signatureBuildingComponents4.constructors("D");
        Set plus = SetsKt___SetsKt.plus(buildPrimitiveStringConstructorsSet, (Iterable) signatureBuildingComponents4.inJavaLang("Float", (String[]) Arrays.copyOf(constructors, constructors.length)));
        String[] constructors2 = signatureBuildingComponents4.constructors("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        BLACK_LIST_CONSTRUCTOR_SIGNATURES = SetsKt___SetsKt.plus(plus, (Iterable) signatureBuildingComponents4.inJavaLang("String", (String[]) Arrays.copyOf(constructors2, constructors2.length)));
        SignatureBuildingComponents signatureBuildingComponents5 = SignatureBuildingComponents.INSTANCE;
        String[] constructors3 = signatureBuildingComponents5.constructors("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        WHITE_LIST_CONSTRUCTOR_SIGNATURES = signatureBuildingComponents5.inJavaLang("Throwable", (String[]) Arrays.copyOf(constructors3, constructors3.length));
    }

    public JvmBuiltInsSettings(ModuleDescriptor moduleDescriptor, final StorageManager storageManager, Function0<? extends ModuleDescriptor> function0, Function0<Boolean> function02) {
        this.moduleDescriptor = moduleDescriptor;
        this.ownerModuleDescriptor$delegate = LazyKt__LazyJVMKt.lazy(function0);
        this.isAdditionalBuiltInsFeatureSupported$delegate = LazyKt__LazyJVMKt.lazy(function02);
        this.mockSerializableType = createMockJavaIoSerializableType(storageManager);
        this.cloneableType$delegate = storageManager.createLazyValue(new Function0<SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$cloneableType$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final SimpleType invoke() {
                ModuleDescriptor ownerModuleDescriptor;
                ModuleDescriptor ownerModuleDescriptor2;
                ownerModuleDescriptor = JvmBuiltInsSettings.this.getOwnerModuleDescriptor();
                ClassId cloneable_class_id = JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_CLASS_ID();
                StorageManager storageManager2 = storageManager;
                ownerModuleDescriptor2 = JvmBuiltInsSettings.this.getOwnerModuleDescriptor();
                return FindClassInModuleKt.findNonGenericClassAcrossDependencies(ownerModuleDescriptor, cloneable_class_id, new NotFoundClasses(storageManager2, ownerModuleDescriptor2)).getDefaultType();
            }
        });
        this.javaAnalogueClassesWithCustomSupertypeCache = storageManager.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = storageManager.createLazyValue(new Function0<Annotations>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$notConsideredDeprecation$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final Annotations invoke() {
                ModuleDescriptor moduleDescriptor2;
                moduleDescriptor2 = JvmBuiltInsSettings.this.moduleDescriptor;
                return Annotations.Companion.create(CollectionsKt__CollectionsJVMKt.listOf(AnnotationUtilKt.createDeprecatedAnnotation$default(moduleDescriptor2.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
            }
        });
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor deserializedClassDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setOwner(deserializedClassDescriptor);
        newCopyBuilder.setVisibility(Visibilities.PUBLIC);
        newCopyBuilder.setReturnType(deserializedClassDescriptor.getDefaultType());
        newCopyBuilder.setDispatchReceiverParameter(deserializedClassDescriptor.getThisAsReceiverParameter());
        SimpleFunctionDescriptor build = newCopyBuilder.build();
        if (build == null) {
            Intrinsics.throwNpe();
        }
        return build;
    }

    private final KotlinType createMockJavaIoSerializableType(StorageManager storageManager) {
        final ModuleDescriptor moduleDescriptor = this.moduleDescriptor;
        final FqName fqName = new FqName("java.io");
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(new PackageFragmentDescriptorImpl(moduleDescriptor, fqName) { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
            public MemberScope.Empty getMemberScope() {
                return MemberScope.Empty.INSTANCE;
            }
        }, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, CollectionsKt__CollectionsJVMKt.listOf(new LazyWrappedType(storageManager, new Function0<SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$createMockJavaIoSerializableType$superTypes$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final SimpleType invoke() {
                ModuleDescriptor moduleDescriptor2;
                moduleDescriptor2 = JvmBuiltInsSettings.this.moduleDescriptor;
                SimpleType anyType = moduleDescriptor2.getBuiltIns().getAnyType();
                Intrinsics.checkExpressionValueIsNotNull(anyType, "moduleDescriptor.builtIns.anyType");
                return anyType;
            }
        })), SourceElement.NO_SOURCE, false, storageManager);
        classDescriptorImpl.initialize(MemberScope.Empty.INSTANCE, SetsKt__SetsKt.emptySet(), null);
        SimpleType defaultType = classDescriptorImpl.getDefaultType();
        Intrinsics.checkExpressionValueIsNotNull(defaultType, "mockSerializableClass.defaultType");
        return defaultType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor classDescriptor) {
        ClassId mapKotlinToJava;
        FqName asSingleFqName;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
        if (KotlinBuiltIns.isAny(classDescriptor) || !KotlinBuiltIns.isUnderKotlinPackage(classDescriptor)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        if (!fqNameUnsafe.isSafe() || (mapKotlinToJava = this.j2kClassMap.mapKotlinToJava(fqNameUnsafe)) == null || (asSingleFqName = mapKotlinToJava.asSingleFqName()) == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(asSingleFqName, "j2kClassMap.mapKotlinToJ…leFqName() ?: return null");
        ClassDescriptor resolveClassByFqName = DescriptorUtilKt.resolveClassByFqName(getOwnerModuleDescriptor(), asSingleFqName, NoLookupLocation.FROM_BUILTINS);
        if (resolveClassByFqName instanceof LazyJavaClassDescriptor) {
            lazyJavaClassDescriptor = resolveClassByFqName;
        }
        return lazyJavaClassDescriptor;
    }

    private final JDKMemberStatus getJdkMethodStatus(FunctionDescriptor functionDescriptor) {
        DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
        if (containingDeclaration != null) {
            final String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 3, null);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            Object dfs = DFS.dfs(CollectionsKt__CollectionsJVMKt.listOf((ClassDescriptor) containingDeclaration), new DFS.Neighbors<N>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$getJdkMethodStatus$1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
                public final List<LazyJavaClassDescriptor> getNeighbors(ClassDescriptor it) {
                    ClassifierDescriptor classifierDescriptor;
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    TypeConstructor typeConstructor = it.getTypeConstructor();
                    Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "it.typeConstructor");
                    Collection<KotlinType> mo2105getSupertypes = typeConstructor.mo2105getSupertypes();
                    Intrinsics.checkExpressionValueIsNotNull(mo2105getSupertypes, "it.typeConstructor.supertypes");
                    ArrayList arrayList = new ArrayList();
                    for (KotlinType kotlinType : mo2105getSupertypes) {
                        ClassifierDescriptor mo2104getDeclarationDescriptor = kotlinType.getConstructor().mo2104getDeclarationDescriptor();
                        LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
                        if (mo2104getDeclarationDescriptor != null) {
                            classifierDescriptor = mo2104getDeclarationDescriptor.getOriginal();
                        } else {
                            classifierDescriptor = null;
                        }
                        if (!(classifierDescriptor instanceof ClassDescriptor)) {
                            classifierDescriptor = null;
                        }
                        ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
                        if (classDescriptor != null) {
                            lazyJavaClassDescriptor = JvmBuiltInsSettings.this.getJavaAnalogue(classDescriptor);
                        }
                        if (lazyJavaClassDescriptor != null) {
                            arrayList.add(lazyJavaClassDescriptor);
                        }
                    }
                    return arrayList;
                }
            }, new DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$getJdkMethodStatus$2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Type inference failed for: r0v10, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$JDKMemberStatus] */
                /* JADX WARN: Type inference failed for: r0v11, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$JDKMemberStatus] */
                /* JADX WARN: Type inference failed for: r0v9, types: [T, kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$JDKMemberStatus] */
                @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
                public boolean beforeChildren(ClassDescriptor classDescriptor) {
                    String signature = SignatureBuildingComponents.INSTANCE.signature(classDescriptor, computeJvmDescriptor$default);
                    if (JvmBuiltInsSettings.Companion.getBLACK_LIST_METHOD_SIGNATURES().contains(signature)) {
                        objectRef.element = JvmBuiltInsSettings.JDKMemberStatus.BLACK_LIST;
                    } else if (JvmBuiltInsSettings.Companion.getWHITE_LIST_METHOD_SIGNATURES().contains(signature)) {
                        objectRef.element = JvmBuiltInsSettings.JDKMemberStatus.WHITE_LIST;
                    } else if (JvmBuiltInsSettings.Companion.getDROP_LIST_METHOD_SIGNATURES().contains(signature)) {
                        objectRef.element = JvmBuiltInsSettings.JDKMemberStatus.DROP;
                    }
                    if (((JvmBuiltInsSettings.JDKMemberStatus) objectRef.element) == null) {
                        return true;
                    }
                    return false;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
                public JvmBuiltInsSettings.JDKMemberStatus result() {
                    JvmBuiltInsSettings.JDKMemberStatus jDKMemberStatus = (JvmBuiltInsSettings.JDKMemberStatus) objectRef.element;
                    if (jDKMemberStatus == null) {
                        return JvmBuiltInsSettings.JDKMemberStatus.NOT_CONSIDERED;
                    }
                    return jDKMemberStatus;
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(dfs, "DFS.dfs<ClassDescriptor,…CONSIDERED\n            })");
            return (JDKMemberStatus) dfs;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        if (Companion.isArrayOrPrimitiveArray(fqNameUnsafe)) {
            SimpleType cloneableType = getCloneableType();
            Intrinsics.checkExpressionValueIsNotNull(cloneableType, "cloneableType");
            return CollectionsKt__CollectionsKt.listOf((Object[]) new KotlinType[]{cloneableType, this.mockSerializableType});
        } else if (Companion.isSerializableInJava(fqNameUnsafe)) {
            return CollectionsKt__CollectionsJVMKt.listOf(this.mockSerializableType);
        } else {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e6, code lost:
        if (isMutabilityViolation(r3, r10) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(ClassDescriptor classDescriptor, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        boolean z;
        final LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue != null) {
            Collection<ClassDescriptor> mapPlatformClass = this.j2kClassMap.mapPlatformClass(DescriptorUtilsKt.getFqNameSafe(javaAnalogue), FallbackBuiltIns.Companion.getInstance());
            final ClassDescriptor classDescriptor2 = (ClassDescriptor) CollectionsKt___CollectionsKt.lastOrNull(mapPlatformClass);
            if (classDescriptor2 != null) {
                SmartSet.Companion companion = SmartSet.Companion;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mapPlatformClass, 10));
                for (ClassDescriptor classDescriptor3 : mapPlatformClass) {
                    arrayList.add(DescriptorUtilsKt.getFqNameSafe(classDescriptor3));
                }
                SmartSet create = companion.create(arrayList);
                boolean isMutable = this.j2kClassMap.isMutable(classDescriptor);
                MemberScope unsubstitutedMemberScope = this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(DescriptorUtilsKt.getFqNameSafe(javaAnalogue), new Function0<LazyJavaClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$getAdditionalFunctions$fakeJavaClassDescriptor$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final LazyJavaClassDescriptor invoke() {
                        LazyJavaClassDescriptor lazyJavaClassDescriptor = LazyJavaClassDescriptor.this;
                        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
                        Intrinsics.checkExpressionValueIsNotNull(javaResolverCache, "JavaResolverCache.EMPTY");
                        return lazyJavaClassDescriptor.copy$descriptors_jvm(javaResolverCache, classDescriptor2);
                    }
                }).getUnsubstitutedMemberScope();
                Intrinsics.checkExpressionValueIsNotNull(unsubstitutedMemberScope, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : function1.invoke(unsubstitutedMemberScope)) {
                    SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
                    boolean z2 = true;
                    if (simpleFunctionDescriptor.getKind() == CallableMemberDescriptor.Kind.DECLARATION && simpleFunctionDescriptor.getVisibility().isPublicAPI() && !KotlinBuiltIns.isDeprecated(simpleFunctionDescriptor)) {
                        Collection<? extends FunctionDescriptor> overriddenDescriptors = simpleFunctionDescriptor.getOverriddenDescriptors();
                        Intrinsics.checkExpressionValueIsNotNull(overriddenDescriptors, "analogueMember.overriddenDescriptors");
                        if (!(overriddenDescriptors instanceof Collection) || !overriddenDescriptors.isEmpty()) {
                            for (FunctionDescriptor it : overriddenDescriptors) {
                                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                                DeclarationDescriptor containingDeclaration = it.getContainingDeclaration();
                                Intrinsics.checkExpressionValueIsNotNull(containingDeclaration, "it.containingDeclaration");
                                if (create.contains(DescriptorUtilsKt.getFqNameSafe(containingDeclaration))) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                    z2 = false;
                    if (z2) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    private final boolean isMutabilityViolation(SimpleFunctionDescriptor simpleFunctionDescriptor, boolean z) {
        DeclarationDescriptor containingDeclaration = simpleFunctionDescriptor.getContainingDeclaration();
        if (containingDeclaration != null) {
            String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null);
            if (z ^ MUTABLE_METHOD_SIGNATURES.contains(SignatureBuildingComponents.INSTANCE.signature((ClassDescriptor) containingDeclaration, computeJvmDescriptor$default))) {
                return true;
            }
            Boolean ifAny = DFS.ifAny(CollectionsKt__CollectionsJVMKt.listOf(simpleFunctionDescriptor), new DFS.Neighbors<N>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$isMutabilityViolation$1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
                public final Collection<? extends CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor it) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    CallableMemberDescriptor original = it.getOriginal();
                    Intrinsics.checkExpressionValueIsNotNull(original, "it.original");
                    return original.getOverriddenDescriptors();
                }
            }, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$isMutabilityViolation$2
                {
                    super(1);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                    return Boolean.valueOf(invoke2(callableMemberDescriptor));
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(CallableMemberDescriptor overridden) {
                    JavaToKotlinClassMap javaToKotlinClassMap;
                    Intrinsics.checkExpressionValueIsNotNull(overridden, "overridden");
                    if (overridden.getKind() == CallableMemberDescriptor.Kind.DECLARATION) {
                        javaToKotlinClassMap = JvmBuiltInsSettings.this.j2kClassMap;
                        DeclarationDescriptor containingDeclaration2 = overridden.getContainingDeclaration();
                        if (containingDeclaration2 != null) {
                            if (javaToKotlinClassMap.isMutable((ClassDescriptor) containingDeclaration2)) {
                                return true;
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        }
                    }
                    return false;
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(ifAny, "DFS.ifAny<CallableMember…lassDescriptor)\n        }");
            return ifAny.booleanValue();
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }

    private final boolean isTrivialCopyConstructorFor(ConstructorDescriptor constructorDescriptor, ClassDescriptor classDescriptor) {
        FqNameUnsafe fqNameUnsafe;
        if (constructorDescriptor.getValueParameters().size() == 1) {
            List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(valueParameters, "valueParameters");
            Object single = CollectionsKt___CollectionsKt.single((List<? extends Object>) valueParameters);
            Intrinsics.checkExpressionValueIsNotNull(single, "valueParameters.single()");
            ClassifierDescriptor mo2104getDeclarationDescriptor = ((ValueParameterDescriptor) single).getType().getConstructor().mo2104getDeclarationDescriptor();
            if (mo2104getDeclarationDescriptor != null) {
                fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(mo2104getDeclarationDescriptor);
            } else {
                fqNameUnsafe = null;
            }
            if (Intrinsics.areEqual(fqNameUnsafe, DescriptorUtilsKt.getFqNameUnsafe(classDescriptor))) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
        boolean z;
        if (classDescriptor.getKind() == ClassKind.CLASS && isAdditionalBuiltInsFeatureSupported()) {
            LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
            if (javaAnalogue != null) {
                ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMap.mapJavaToKotlin$default(this.j2kClassMap, DescriptorUtilsKt.getFqNameSafe(javaAnalogue), FallbackBuiltIns.Companion.getInstance(), null, 4, null);
                if (mapJavaToKotlin$default != null) {
                    final TypeSubstitutor buildSubstitutor = MappingUtilKt.createMappedTypeParametersSubstitution(mapJavaToKotlin$default, javaAnalogue).buildSubstitutor();
                    Function2<ConstructorDescriptor, ConstructorDescriptor, Boolean> function2 = new Function2<ConstructorDescriptor, ConstructorDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$getConstructors$1
                        {
                            super(2);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Boolean invoke(ConstructorDescriptor constructorDescriptor, ConstructorDescriptor constructorDescriptor2) {
                            return Boolean.valueOf(invoke2(constructorDescriptor, constructorDescriptor2));
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final boolean invoke2(ConstructorDescriptor constructorDescriptor, ConstructorDescriptor constructorDescriptor2) {
                            if (OverridingUtil.getBothWaysOverridability(constructorDescriptor, constructorDescriptor2.substitute(TypeSubstitutor.this)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                                return true;
                            }
                            return false;
                        }
                    };
                    List<ClassConstructorDescriptor> constructors = javaAnalogue.getConstructors();
                    ArrayList<ClassConstructorDescriptor> arrayList = new ArrayList();
                    Iterator<T> it = constructors.iterator();
                    while (true) {
                        boolean z2 = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        ClassConstructorDescriptor javaConstructor = (ClassConstructorDescriptor) next;
                        Intrinsics.checkExpressionValueIsNotNull(javaConstructor, "javaConstructor");
                        if (javaConstructor.getVisibility().isPublicAPI()) {
                            Collection<ClassConstructorDescriptor> constructors2 = mapJavaToKotlin$default.getConstructors();
                            Intrinsics.checkExpressionValueIsNotNull(constructors2, "defaultKotlinVersion.constructors");
                            if (!(constructors2 instanceof Collection) || !constructors2.isEmpty()) {
                                for (ClassConstructorDescriptor it2 : constructors2) {
                                    Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                                    if (function2.invoke2((ConstructorDescriptor) it2, (ConstructorDescriptor) javaConstructor)) {
                                        z = false;
                                        break;
                                    }
                                }
                            }
                            z = true;
                            if (z && !isTrivialCopyConstructorFor(javaConstructor, classDescriptor) && !KotlinBuiltIns.isDeprecated(javaConstructor) && !BLACK_LIST_CONSTRUCTOR_SIGNATURES.contains(SignatureBuildingComponents.INSTANCE.signature(javaAnalogue, MethodSignatureMappingKt.computeJvmDescriptor$default(javaConstructor, false, false, 3, null)))) {
                                z2 = true;
                            }
                        }
                        if (z2) {
                            arrayList.add(next);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                    for (ClassConstructorDescriptor javaConstructor2 : arrayList) {
                        FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder = javaConstructor2.newCopyBuilder();
                        newCopyBuilder.setOwner(classDescriptor);
                        newCopyBuilder.setReturnType(classDescriptor.getDefaultType());
                        newCopyBuilder.setPreserveSourceElement();
                        newCopyBuilder.setSubstitution(buildSubstitutor.getSubstitution());
                        Set<String> set = WHITE_LIST_CONSTRUCTOR_SIGNATURES;
                        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                        Intrinsics.checkExpressionValueIsNotNull(javaConstructor2, "javaConstructor");
                        if (!set.contains(signatureBuildingComponents.signature(javaAnalogue, MethodSignatureMappingKt.computeJvmDescriptor$default(javaConstructor2, false, false, 3, null)))) {
                            newCopyBuilder.setAdditionalAnnotations(getNotConsideredDeprecation());
                        }
                        FunctionDescriptor build = newCopyBuilder.build();
                        if (build != null) {
                            arrayList2.add((ClassConstructorDescriptor) build);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                        }
                    }
                    return arrayList2;
                }
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ed, code lost:
        if (r2 != 3) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0114  */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<SimpleFunctionDescriptor> getFunctions(final Name name, ClassDescriptor classDescriptor) {
        SimpleFunctionDescriptor build;
        boolean z = true;
        if (Intrinsics.areEqual(name, CloneableClassScope.Companion.getCLONE_NAME()) && (classDescriptor instanceof DeserializedClassDescriptor) && KotlinBuiltIns.isArrayOrPrimitiveArray(classDescriptor)) {
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) classDescriptor;
            List<ProtoBuf.Function> functionList = deserializedClassDescriptor.getClassProto().getFunctionList();
            Intrinsics.checkExpressionValueIsNotNull(functionList, "classDescriptor.classProto.functionList");
            if (!(functionList instanceof Collection) || !functionList.isEmpty()) {
                for (ProtoBuf.Function functionProto : functionList) {
                    NameResolver nameResolver = deserializedClassDescriptor.getC().getNameResolver();
                    Intrinsics.checkExpressionValueIsNotNull(functionProto, "functionProto");
                    if (Intrinsics.areEqual(NameResolverUtilKt.getName(nameResolver, functionProto.getName()), CloneableClassScope.Companion.getCLONE_NAME())) {
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return CollectionsKt__CollectionsJVMKt.listOf(createCloneForArray(deserializedClassDescriptor, (SimpleFunctionDescriptor) CollectionsKt___CollectionsKt.single(getCloneableType().getMemberScope().getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS))));
        } else if (!isAdditionalBuiltInsFeatureSupported()) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            Collection<SimpleFunctionDescriptor> additionalFunctions = getAdditionalFunctions(classDescriptor, new Function1<MemberScope, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings$getFunctions$2
                {
                    super(1);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final Collection<? extends SimpleFunctionDescriptor> invoke(MemberScope memberScope) {
                    return memberScope.getContributedFunctions(Name.this, NoLookupLocation.FROM_BUILTINS);
                }
            });
            ArrayList arrayList = new ArrayList();
            for (SimpleFunctionDescriptor simpleFunctionDescriptor : additionalFunctions) {
                DeclarationDescriptor containingDeclaration = simpleFunctionDescriptor.getContainingDeclaration();
                if (containingDeclaration != null) {
                    FunctionDescriptor substitute = simpleFunctionDescriptor.substitute(MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor) containingDeclaration, classDescriptor).buildSubstitutor());
                    if (substitute != null) {
                        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = ((SimpleFunctionDescriptor) substitute).newCopyBuilder();
                        newCopyBuilder.setOwner(classDescriptor);
                        newCopyBuilder.setDispatchReceiverParameter(classDescriptor.getThisAsReceiverParameter());
                        newCopyBuilder.setPreserveSourceElement();
                        int i = WhenMappings.$EnumSwitchMapping$0[getJdkMethodStatus(simpleFunctionDescriptor).ordinal()];
                        SimpleFunctionDescriptor simpleFunctionDescriptor2 = null;
                        if (i != 1) {
                            if (i == 2) {
                                Intrinsics.checkExpressionValueIsNotNull(newCopyBuilder.setAdditionalAnnotations(getNotConsideredDeprecation()), "setAdditionalAnnotations(notConsideredDeprecation)");
                            }
                            build = newCopyBuilder.build();
                            if (build == null) {
                                Intrinsics.throwNpe();
                            }
                            simpleFunctionDescriptor2 = build;
                        } else if (!ModalityKt.isFinalClass(classDescriptor)) {
                            Intrinsics.checkExpressionValueIsNotNull(newCopyBuilder.setHiddenForResolutionEverywhereBesideSupercalls(), "setHiddenForResolutionEverywhereBesideSupercalls()");
                            build = newCopyBuilder.build();
                            if (build == null) {
                            }
                            simpleFunctionDescriptor2 = build;
                        }
                        if (simpleFunctionDescriptor2 != null) {
                            arrayList.add(simpleFunctionDescriptor2);
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                }
            }
            return arrayList;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
    public Set<Name> getFunctionsNames(ClassDescriptor classDescriptor) {
        LazyJavaClassMemberScope unsubstitutedMemberScope;
        Set<Name> functionNames;
        if (!isAdditionalBuiltInsFeatureSupported()) {
            return SetsKt__SetsKt.emptySet();
        }
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue == null || (unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope()) == null || (functionNames = unsubstitutedMemberScope.getFunctionNames()) == null) {
            return SetsKt__SetsKt.emptySet();
        }
        return functionNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue == null || !simpleFunctionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
            return true;
        }
        if (!isAdditionalBuiltInsFeatureSupported()) {
            return false;
        }
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null);
        LazyJavaClassMemberScope unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope();
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "functionDescriptor.name");
        Collection<SimpleFunctionDescriptor> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
        if (!(contributedFunctions instanceof Collection) || !contributedFunctions.isEmpty()) {
            for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : contributedFunctions) {
                if (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor2, false, false, 3, null), computeJvmDescriptor$default)) {
                    return true;
                }
            }
        }
        return false;
    }
}
