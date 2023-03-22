package kotlin.reflect.jvm.internal;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.vivo.push.PushClientConstants;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.KCallable;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ap\u0010\u0011\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u001d\u0010\u0010\u001a\u0019\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0002\b\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a5\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a/\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001e\u001a$\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0080\b¢\u0006\u0004\b\"\u0010#\u001a\u001b\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010%*\u0004\u0018\u00010$H\u0000¢\u0006\u0004\b&\u0010'\u001a\u0017\u0010)\u001a\u0004\u0018\u00010(*\u0004\u0018\u00010$H\u0000¢\u0006\u0004\b)\u0010*\u001a\u001b\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0004\u0018\u00010$H\u0000¢\u0006\u0004\b,\u0010-\u001a\u0019\u00101\u001a\b\u0012\u0004\u0012\u0002000/*\u00020.H\u0000¢\u0006\u0004\b1\u00102\u001a\u0015\u00104\u001a\u0004\u0018\u000100*\u000203H\u0002¢\u0006\u0004\b4\u00105\u001a\u0019\u00107\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004*\u000206H\u0000¢\u0006\u0004\b7\u00108\u001a\u0015\u0010;\u001a\u0004\u0018\u00010:*\u000209H\u0000¢\u0006\u0004\b;\u0010<\u001a!\u0010>\u001a\u0004\u0018\u00010$*\u0006\u0012\u0002\b\u00030=2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b>\u0010?\"\u001c\u0010A\u001a\u00020@8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u001c\u0010H\u001a\u0004\u0018\u00010E*\u00020\u00028@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "M", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "D", "Ljava/lang/Class;", "moduleAnchor", DpStatConstants.KEY_PROTO, "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "metadataVersion", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "createDescriptor", "deserializeToDescriptor", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "Ljava/lang/ClassLoader;", "classLoader", "", "packageName", PushClientConstants.TAG_CLASS_NAME, "", "arrayDimensions", "loadClass", "(Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "kotlinClassId", "(Ljava/lang/ClassLoader;Lkotlin/reflect/jvm/internal/impl/name/ClassId;I)Ljava/lang/Class;", "R", "Lkotlin/Function0;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "reflectionCall", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "asKCallableImpl", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKFunctionImpl", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "asKPropertyImpl", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/KPropertyImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "", "", "computeAnnotations", "(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;)Ljava/util/List;", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toAnnotationInstance", "(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;)Ljava/lang/annotation/Annotation;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toJavaClass", "(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "Lkotlin/reflect/KVisibility;", "toKVisibility", "(Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;)Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "toRuntimeValue", "(Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;Ljava/lang/ClassLoader;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "instanceReceiverParameter", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class UtilKt {
    public static final FqName JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");

    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    public static final KCallableImpl<?> asKCallableImpl(Object obj) {
        Object obj2;
        if (!(obj instanceof KCallableImpl)) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        KCallableImpl<?> kCallableImpl = (KCallableImpl) obj2;
        if (kCallableImpl == null) {
            kCallableImpl = asKFunctionImpl(obj);
        }
        if (kCallableImpl == null) {
            return asKPropertyImpl(obj);
        }
        return kCallableImpl;
    }

    public static final KFunctionImpl asKFunctionImpl(Object obj) {
        Object obj2;
        KCallable kCallable;
        KFunctionImpl kFunctionImpl = null;
        if (!(obj instanceof KFunctionImpl)) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        KFunctionImpl kFunctionImpl2 = (KFunctionImpl) obj2;
        if (kFunctionImpl2 == null) {
            if (!(obj instanceof FunctionReference)) {
                obj = null;
            }
            FunctionReference functionReference = (FunctionReference) obj;
            if (functionReference != null) {
                kCallable = functionReference.compute();
            } else {
                kCallable = null;
            }
            if (kCallable instanceof KFunctionImpl) {
                kFunctionImpl = kCallable;
            }
            return kFunctionImpl;
        }
        return kFunctionImpl2;
    }

    public static final KPropertyImpl<?> asKPropertyImpl(Object obj) {
        Object obj2;
        KCallable kCallable;
        KPropertyImpl<?> kPropertyImpl = null;
        if (!(obj instanceof KPropertyImpl)) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        KPropertyImpl<?> kPropertyImpl2 = (KPropertyImpl) obj2;
        if (kPropertyImpl2 == null) {
            if (!(obj instanceof PropertyReference)) {
                obj = null;
            }
            PropertyReference propertyReference = (PropertyReference) obj;
            if (propertyReference != null) {
                kCallable = propertyReference.compute();
            } else {
                kCallable = null;
            }
            if (kCallable instanceof KPropertyImpl) {
                kPropertyImpl = kCallable;
            }
            return kPropertyImpl;
        }
        return kPropertyImpl2;
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(CallableDescriptor callableDescriptor) {
        if (callableDescriptor.getDispatchReceiverParameter() != null) {
            DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
            if (containingDeclaration != null) {
                return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        return null;
    }

    public static final List<Annotation> computeAnnotations(Annotated annotated) {
        Annotations annotations = annotated.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations) {
            SourceElement source = annotationDescriptor.getSource();
            Annotation annotation = null;
            if (source instanceof ReflectAnnotationSource) {
                annotation = ((ReflectAnnotationSource) source).getAnnotation();
            } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
                ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
                if (!(javaElement instanceof ReflectJavaAnnotation)) {
                    javaElement = null;
                }
                ReflectJavaAnnotation reflectJavaAnnotation = (ReflectJavaAnnotation) javaElement;
                if (reflectJavaAnnotation != null) {
                    annotation = reflectJavaAnnotation.getAnnotation();
                }
            } else {
                annotation = toAnnotationInstance(annotationDescriptor);
            }
            if (annotation != null) {
                arrayList.add(annotation);
            }
        }
        return arrayList;
    }

    public static final Class<?> toJavaClass(ClassDescriptor classDescriptor) {
        SourceElement source = classDescriptor.getSource();
        Intrinsics.checkExpressionValueIsNotNull(source, "source");
        if (source instanceof KotlinJvmBinarySourceElement) {
            KotlinJvmBinaryClass binaryClass = ((KotlinJvmBinarySourceElement) source).getBinaryClass();
            if (binaryClass != null) {
                return ((ReflectKotlinClass) binaryClass).getKlass();
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
        } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
            ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
            if (javaElement != null) {
                return ((ReflectJavaClass) javaElement).getElement();
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
        } else {
            ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
            if (classId != null) {
                return loadClass(ReflectClassUtilKt.getSafeClassLoader(classDescriptor.getClass()), classId, 0);
            }
            return null;
        }
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> cls, M m, NameResolver nameResolver, TypeTable typeTable, BinaryVersion binaryVersion, Function2<? super MemberDeserializer, ? super M, ? extends D> function2) {
        List<ProtoBuf.TypeParameter> typeParameterList;
        RuntimeModuleData orCreateModule = ModuleByClassLoaderKt.getOrCreateModule(cls);
        if (m instanceof ProtoBuf.Function) {
            typeParameterList = ((ProtoBuf.Function) m).getTypeParameterList();
        } else if (m instanceof ProtoBuf.Property) {
            typeParameterList = ((ProtoBuf.Property) m).getTypeParameterList();
        } else {
            throw new IllegalStateException(("Unsupported message: " + m).toString());
        }
        List<ProtoBuf.TypeParameter> typeParameters = typeParameterList;
        DeserializationComponents deserialization = orCreateModule.getDeserialization();
        ModuleDescriptor module = orCreateModule.getModule();
        VersionRequirementTable empty = VersionRequirementTable.Companion.getEMPTY();
        Intrinsics.checkExpressionValueIsNotNull(typeParameters, "typeParameters");
        return function2.invoke(new MemberDeserializer(new DeserializationContext(deserialization, nameResolver, module, typeTable, empty, binaryVersion, null, null, typeParameters)), m);
    }

    public static final Class<?> loadClass(ClassLoader classLoader, String str, String str2, int i) {
        if (Intrinsics.areEqual(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        String str3 = str + IStringUtil.EXTENSION_SEPARATOR + StringsKt__StringsJVMKt.replace$default(str2, (char) IStringUtil.EXTENSION_SEPARATOR, '$', false, 4, (Object) null);
        if (i > 0) {
            str3 = StringsKt__StringsJVMKt.repeat(PreferencesUtil.LEFT_MOUNT, i) + 'L' + str3 + WebvttCueParser.CHAR_SEMI_COLON;
        }
        return ReflectJavaClassFinderKt.tryLoadClass(classLoader, str3);
    }

    public static final Class<?> loadClass(ClassLoader classLoader, ClassId classId, int i) {
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics.checkExpressionValueIsNotNull(unsafe, "kotlinClassId.asSingleFqName().toUnsafe()");
        ClassId mapKotlinToJava = javaToKotlinClassMap.mapKotlinToJava(unsafe);
        if (mapKotlinToJava != null) {
            classId = mapKotlinToJava;
        }
        String asString = classId.getPackageFqName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "javaClassId.packageFqName.asString()");
        String asString2 = classId.getRelativeClassName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString2, "javaClassId.relativeClassName.asString()");
        return loadClass(classLoader, asString, asString2, i);
    }

    public static /* synthetic */ Class loadClass$default(ClassLoader classLoader, ClassId classId, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return loadClass(classLoader, classId, i);
    }

    public static final Annotation toAnnotationInstance(AnnotationDescriptor annotationDescriptor) {
        Class<?> cls;
        Pair pair;
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass != null) {
            cls = toJavaClass(annotationClass);
        } else {
            cls = null;
        }
        if (!(cls instanceof Class)) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        Set<Map.Entry<Name, ConstantValue<?>>> entrySet = annotationDescriptor.getAllValueArguments().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Name name = (Name) entry.getKey();
            ClassLoader classLoader = cls.getClassLoader();
            Intrinsics.checkExpressionValueIsNotNull(classLoader, "annotationClass.classLoader");
            Object runtimeValue = toRuntimeValue((ConstantValue) entry.getValue(), classLoader);
            if (runtimeValue != null) {
                pair = TuplesKt.to(name.asString(), runtimeValue);
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return (Annotation) AnnotationConstructorCallerKt.createAnnotationInstance$default(cls, MapsKt__MapsKt.toMap(arrayList), null, 4, null);
    }

    public static final KVisibility toKVisibility(Visibility visibility) {
        if (Intrinsics.areEqual(visibility, Visibilities.PUBLIC)) {
            return KVisibility.PUBLIC;
        }
        if (Intrinsics.areEqual(visibility, Visibilities.PROTECTED)) {
            return KVisibility.PROTECTED;
        }
        if (Intrinsics.areEqual(visibility, Visibilities.INTERNAL)) {
            return KVisibility.INTERNAL;
        }
        if (Intrinsics.areEqual(visibility, Visibilities.PRIVATE) || Intrinsics.areEqual(visibility, Visibilities.PRIVATE_TO_THIS)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }

    public static final Object toRuntimeValue(ConstantValue<?> constantValue, ClassLoader classLoader) {
        if (constantValue instanceof AnnotationValue) {
            return toAnnotationInstance(((AnnotationValue) constantValue).getValue());
        }
        if (constantValue instanceof ArrayValue) {
            List<? extends ConstantValue<?>> value = ((ArrayValue) constantValue).getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(value, 10));
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(toRuntimeValue((ConstantValue) it.next(), classLoader));
            }
            Object[] array = arrayList.toArray(new Object[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            return array;
        } else if (constantValue instanceof EnumValue) {
            Pair<? extends ClassId, ? extends Name> value2 = ((EnumValue) constantValue).getValue();
            Name component2 = value2.component2();
            Class loadClass$default = loadClass$default(classLoader, value2.component1(), 0, 4, null);
            if (loadClass$default == null) {
                return null;
            }
            if (loadClass$default != null) {
                return Util.getEnumConstantByName(loadClass$default, component2.asString());
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
        } else if (constantValue instanceof KClassValue) {
            KClassValue.Value value3 = ((KClassValue) constantValue).getValue();
            if (value3 instanceof KClassValue.Value.NormalClass) {
                KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value3;
                return loadClass(classLoader, normalClass.getClassId(), normalClass.getArrayDimensions());
            } else if (value3 instanceof KClassValue.Value.LocalClass) {
                ClassifierDescriptor mo2023getDeclarationDescriptor = ((KClassValue.Value.LocalClass) value3).getType().getConstructor().mo2023getDeclarationDescriptor();
                if (!(mo2023getDeclarationDescriptor instanceof ClassDescriptor)) {
                    mo2023getDeclarationDescriptor = null;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) mo2023getDeclarationDescriptor;
                if (classDescriptor == null) {
                    return null;
                }
                return toJavaClass(classDescriptor);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if ((constantValue instanceof ErrorValue) || (constantValue instanceof NullValue)) {
            return null;
        } else {
            return constantValue.getValue();
        }
    }
}
