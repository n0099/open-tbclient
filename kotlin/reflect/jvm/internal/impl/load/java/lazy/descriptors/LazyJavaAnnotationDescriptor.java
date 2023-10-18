package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
/* loaded from: classes10.dex */
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaAnnotationDescriptor.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    public final NotNullLazyValue allValueArguments$delegate;
    public final LazyJavaResolverContext c;
    public final NullableLazyValue fqName$delegate;
    public final boolean isIdeExternalAnnotation;
    public final JavaAnnotation javaAnnotation;
    public final JavaSourceElement source;
    public final NotNullLazyValue type$delegate;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map) StorageKt.getValue(this.allValueArguments$delegate, this, $$delegatedProperties[2]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public FqName getFqName() {
        return (FqName) StorageKt.getValue(this.fqName$delegate, this, $$delegatedProperties[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.type$delegate, this, $$delegatedProperties[1]);
    }

    public LazyJavaAnnotationDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotation javaAnnotation) {
        this.c = lazyJavaResolverContext;
        this.javaAnnotation = javaAnnotation;
        this.fqName$delegate = lazyJavaResolverContext.getStorageManager().createNullableLazyValue(new Function0<FqName>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$fqName$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final FqName invoke() {
                JavaAnnotation javaAnnotation2;
                javaAnnotation2 = LazyJavaAnnotationDescriptor.this.javaAnnotation;
                ClassId classId = javaAnnotation2.getClassId();
                if (classId != null) {
                    return classId.asSingleFqName();
                }
                return null;
            }
        });
        this.type$delegate = this.c.getStorageManager().createLazyValue(new Function0<SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$type$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final SimpleType invoke() {
                JavaAnnotation javaAnnotation2;
                LazyJavaResolverContext lazyJavaResolverContext2;
                JavaAnnotation javaAnnotation3;
                LazyJavaResolverContext lazyJavaResolverContext3;
                FqName fqName = LazyJavaAnnotationDescriptor.this.getFqName();
                if (fqName != null) {
                    Intrinsics.checkExpressionValueIsNotNull(fqName, "fqName ?: return@createL…fqName: $javaAnnotation\")");
                    JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
                    lazyJavaResolverContext2 = LazyJavaAnnotationDescriptor.this.c;
                    ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMap.mapJavaToKotlin$default(javaToKotlinClassMap, fqName, lazyJavaResolverContext2.getModule().getBuiltIns(), null, 4, null);
                    if (mapJavaToKotlin$default == null) {
                        javaAnnotation3 = LazyJavaAnnotationDescriptor.this.javaAnnotation;
                        JavaClass resolve = javaAnnotation3.resolve();
                        if (resolve == null) {
                            mapJavaToKotlin$default = null;
                        } else {
                            lazyJavaResolverContext3 = LazyJavaAnnotationDescriptor.this.c;
                            mapJavaToKotlin$default = lazyJavaResolverContext3.getComponents().getModuleClassResolver().resolveClass(resolve);
                        }
                    }
                    if (mapJavaToKotlin$default == null) {
                        mapJavaToKotlin$default = LazyJavaAnnotationDescriptor.this.createTypeForMissingDependencies(fqName);
                    }
                    return mapJavaToKotlin$default.getDefaultType();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("No fqName: ");
                javaAnnotation2 = LazyJavaAnnotationDescriptor.this.javaAnnotation;
                sb.append(javaAnnotation2);
                return ErrorUtils.createErrorType(sb.toString());
            }
        });
        this.source = this.c.getComponents().getSourceElementFactory().source(this.javaAnnotation);
        this.allValueArguments$delegate = this.c.getStorageManager().createLazyValue(new Function0<Map<Name, ? extends ConstantValue<?>>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor$allValueArguments$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Map<Name, ? extends ConstantValue<?>> invoke() {
                JavaAnnotation javaAnnotation2;
                ConstantValue resolveAnnotationArgument;
                Pair pair;
                javaAnnotation2 = LazyJavaAnnotationDescriptor.this.javaAnnotation;
                Collection<JavaAnnotationArgument> arguments = javaAnnotation2.getArguments();
                ArrayList arrayList = new ArrayList();
                for (JavaAnnotationArgument javaAnnotationArgument : arguments) {
                    Name name = javaAnnotationArgument.getName();
                    if (name == null) {
                        name = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
                    }
                    resolveAnnotationArgument = LazyJavaAnnotationDescriptor.this.resolveAnnotationArgument(javaAnnotationArgument);
                    if (resolveAnnotationArgument != null) {
                        pair = TuplesKt.to(name, resolveAnnotationArgument);
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
        this.isIdeExternalAnnotation = this.javaAnnotation.isIdeExternalAnnotation();
    }

    private final ConstantValue<?> resolveFromEnumValue(ClassId classId, Name name) {
        if (classId != null && name != null) {
            return new EnumValue(classId, name);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor createTypeForMissingDependencies(FqName fqName) {
        ModuleDescriptor module = this.c.getModule();
        ClassId classId = ClassId.topLevel(fqName);
        Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(fqName)");
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(module, classId, this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
    }

    private final ConstantValue<?> resolveFromAnnotation(JavaAnnotation javaAnnotation) {
        return new AnnotationValue(new LazyJavaAnnotationDescriptor(this.c, javaAnnotation));
    }

    private final ConstantValue<?> resolveFromJavaClassObjectType(JavaType javaType) {
        return KClassValue.Companion.create(this.c.getTypeResolver().transformJavaType(javaType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConstantValue<?> resolveAnnotationArgument(JavaAnnotationArgument javaAnnotationArgument) {
        if (javaAnnotationArgument instanceof JavaLiteralAnnotationArgument) {
            return ConstantValueFactory.INSTANCE.createConstantValue(((JavaLiteralAnnotationArgument) javaAnnotationArgument).getValue());
        }
        if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
            return resolveFromEnumValue(javaEnumValueAnnotationArgument.getEnumClassId(), javaEnumValueAnnotationArgument.getEntryName());
        } else if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
            Name DEFAULT_ANNOTATION_MEMBER_NAME = javaAnnotationArgument.getName();
            if (DEFAULT_ANNOTATION_MEMBER_NAME == null) {
                DEFAULT_ANNOTATION_MEMBER_NAME = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
                Intrinsics.checkExpressionValueIsNotNull(DEFAULT_ANNOTATION_MEMBER_NAME, "DEFAULT_ANNOTATION_MEMBER_NAME");
            }
            return resolveFromArray(DEFAULT_ANNOTATION_MEMBER_NAME, ((JavaArrayAnnotationArgument) javaAnnotationArgument).getElements());
        } else if (javaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument) {
            return resolveFromAnnotation(((JavaAnnotationAsAnnotationArgument) javaAnnotationArgument).getAnnotation());
        } else {
            if (javaAnnotationArgument instanceof JavaClassObjectAnnotationArgument) {
                return resolveFromJavaClassObjectType(((JavaClassObjectAnnotationArgument) javaAnnotationArgument).getReferencedType());
            }
            return null;
        }
    }

    private final ConstantValue<?> resolveFromArray(Name name, List<? extends JavaAnnotationArgument> list) {
        KotlinType arrayType;
        SimpleType type = getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "type");
        if (KotlinTypeKt.isError(type)) {
            return null;
        }
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(this);
        if (annotationClass == null) {
            Intrinsics.throwNpe();
        }
        ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name, annotationClass);
        if (annotationParameterByName == null || (arrayType = annotationParameterByName.getType()) == null) {
            arrayType = this.c.getComponents().getModule().getBuiltIns().getArrayType(Variance.INVARIANT, ErrorUtils.createErrorType("Unknown array element type"));
        }
        Intrinsics.checkExpressionValueIsNotNull(arrayType, "DescriptorResolverUtils.… type\")\n                )");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (JavaAnnotationArgument javaAnnotationArgument : list) {
            ConstantValue<?> resolveAnnotationArgument = resolveAnnotationArgument(javaAnnotationArgument);
            if (resolveAnnotationArgument == null) {
                resolveAnnotationArgument = new NullValue();
            }
            arrayList.add(resolveAnnotationArgument);
        }
        return ConstantValueFactory.INSTANCE.createArrayValue(arrayList, arrayType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }

    public String toString() {
        return DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.FQ_NAMES_IN_TYPES, this, null, 2, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public JavaSourceElement getSource() {
        return this.source;
    }
}
