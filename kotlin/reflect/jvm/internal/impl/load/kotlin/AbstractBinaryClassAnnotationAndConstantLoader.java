package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.baidu.android.common.others.IStringUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes9.dex */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> implements AnnotationAndConstantLoader<A, C> {
    public static final Companion Companion = new Companion(null);
    public static final Set<ClassId> SPECIAL_ANNOTATIONS;
    public final KotlinClassFinder kotlinClassFinder;
    public final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, Storage<A, C>> storage;

    /* loaded from: classes9.dex */
    public enum PropertyRelatedElement {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    /* loaded from: classes9.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            $EnumSwitchMapping$0[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            $EnumSwitchMapping$0[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
        }
    }

    public byte[] getCachedFileContent(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        return null;
    }

    public abstract KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(ClassId classId, SourceElement sourceElement, List<A> list);

    public abstract C loadConstant(String str, Object obj);

    public abstract A loadTypeAnnotation(ProtoBuf.Annotation annotation, NameResolver nameResolver);

    public abstract C transformToUnsignedConstant(C c);

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public static final class Storage<A, C> {
        public final Map<MemberSignature, List<A>> memberAnnotations;
        public final Map<MemberSignature, C> propertyConstants;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, ? extends java.util.List<? extends A>> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, ? extends C> */
        /* JADX WARN: Multi-variable type inference failed */
        public Storage(Map<MemberSignature, ? extends List<? extends A>> map, Map<MemberSignature, ? extends C> map2) {
            this.memberAnnotations = map;
            this.propertyConstants = map2;
        }

        public final Map<MemberSignature, List<A>> getMemberAnnotations() {
            return this.memberAnnotations;
        }

        public final Map<MemberSignature, C> getPropertyConstants() {
            return this.propertyConstants;
        }
    }

    static {
        List<FqName> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FqName[]{JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName("java.lang.annotation.Target"), new FqName("java.lang.annotation.Retention"), new FqName("java.lang.annotation.Documented")});
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listOf, 10));
        for (FqName fqName : listOf) {
            arrayList.add(ClassId.topLevel(fqName));
        }
        SPECIAL_ANNOTATIONS = CollectionsKt___CollectionsKt.toSet(arrayList);
    }

    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        this.kotlinClassFinder = kotlinClassFinder;
        this.storage = storageManager.createMemoizedFunction(new Function1<KotlinJvmBinaryClass, Storage<? extends A, ? extends C>>() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$storage$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final AbstractBinaryClassAnnotationAndConstantLoader.Storage<A, C> invoke(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
                AbstractBinaryClassAnnotationAndConstantLoader.Storage<A, C> loadAnnotationsAndInitializers;
                loadAnnotationsAndInitializers = AbstractBinaryClassAnnotationAndConstantLoader.this.loadAnnotationsAndInitializers(kotlinJvmBinaryClass);
                return loadAnnotationsAndInitializers;
            }
        });
    }

    private final KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers(ProtoContainer protoContainer, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass == null) {
            if (protoContainer instanceof ProtoContainer.Class) {
                return toBinaryClass((ProtoContainer.Class) protoContainer);
            }
            return null;
        }
        return kotlinJvmBinaryClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property) {
        return loadPropertyAnnotations(protoContainer, property, PropertyRelatedElement.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property) {
        return loadPropertyAnnotations(protoContainer, property, PropertyRelatedElement.DELEGATE_FIELD);
    }

    private final int computeJvmParameterIndexShift(ProtoContainer protoContainer, MessageLite messageLite) {
        if (messageLite instanceof ProtoBuf.Function) {
            if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Function) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf.Property) {
            if (ProtoTypeTableUtilKt.hasReceiver((ProtoBuf.Property) messageLite)) {
                return 1;
            }
        } else if (messageLite instanceof ProtoBuf.Constructor) {
            if (protoContainer != null) {
                ProtoContainer.Class r4 = (ProtoContainer.Class) protoContainer;
                if (r4.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS) {
                    return 2;
                }
                if (r4.isInner()) {
                    return 1;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
            }
        } else {
            throw new UnsupportedOperationException("Unsupported message: " + messageLite.getClass());
        }
        return 0;
    }

    private final List<A> findClassAndLoadMemberAnnotations(ProtoContainer protoContainer, MemberSignature memberSignature, boolean z, boolean z2, Boolean bool, boolean z3) {
        KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers = findClassWithAnnotationsAndInitializers(protoContainer, getSpecialCaseContainerClass(protoContainer, z, z2, bool, z3));
        if (findClassWithAnnotationsAndInitializers != null) {
            List<A> list = this.storage.invoke(findClassWithAnnotationsAndInitializers).getMemberAnnotations().get(memberSignature);
            if (list == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return list;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static /* synthetic */ List findClassAndLoadMemberAnnotations$default(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoContainer protoContainer, MemberSignature memberSignature, boolean z, boolean z2, Boolean bool, boolean z3, int i, Object obj) {
        boolean z4;
        boolean z5;
        Boolean bool2;
        boolean z6;
        if (obj == null) {
            if ((i & 4) != 0) {
                z4 = false;
            } else {
                z4 = z;
            }
            if ((i & 8) != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if ((i & 16) != 0) {
                bool2 = null;
            } else {
                bool2 = bool;
            }
            if ((i & 32) != 0) {
                z6 = false;
            } else {
                z6 = z3;
            }
            return abstractBinaryClassAnnotationAndConstantLoader.findClassAndLoadMemberAnnotations(protoContainer, memberSignature, z4, z5, bool2, z6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    public static /* synthetic */ MemberSignature getPropertySignature$default(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z, boolean z2, boolean z3, int i, Object obj) {
        boolean z4;
        boolean z5;
        boolean z6;
        if (obj == null) {
            if ((i & 8) != 0) {
                z4 = false;
            } else {
                z4 = z;
            }
            if ((i & 16) != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if ((i & 32) != 0) {
                z6 = true;
            } else {
                z6 = z3;
            }
            return abstractBinaryClassAnnotationAndConstantLoader.getPropertySignature(property, nameResolver, typeTable, z4, z5, z6);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final MemberSignature getCallableSignature(MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z) {
        if (messageLite instanceof ProtoBuf.Constructor) {
            MemberSignature.Companion companion = MemberSignature.Companion;
            JvmMemberSignature.Method jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature((ProtoBuf.Constructor) messageLite, nameResolver, typeTable);
            if (jvmConstructorSignature == null) {
                return null;
            }
            return companion.fromJvmMemberSignature(jvmConstructorSignature);
        } else if (messageLite instanceof ProtoBuf.Function) {
            MemberSignature.Companion companion2 = MemberSignature.Companion;
            JvmMemberSignature.Method jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature((ProtoBuf.Function) messageLite, nameResolver, typeTable);
            if (jvmMethodSignature == null) {
                return null;
            }
            return companion2.fromJvmMemberSignature(jvmMethodSignature);
        } else if (!(messageLite instanceof ProtoBuf.Property)) {
            return null;
        } else {
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
            Intrinsics.checkExpressionValueIsNotNull(propertySignature, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull((GeneratedMessageLite.ExtendableMessage) messageLite, propertySignature);
            if (jvmPropertySignature == null) {
                return null;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return getPropertySignature((ProtoBuf.Property) messageLite, nameResolver, typeTable, true, true, z);
                } else if (!jvmPropertySignature.hasSetter()) {
                    return null;
                } else {
                    MemberSignature.Companion companion3 = MemberSignature.Companion;
                    JvmProtoBuf.JvmMethodSignature setter = jvmPropertySignature.getSetter();
                    Intrinsics.checkExpressionValueIsNotNull(setter, "signature.setter");
                    return companion3.fromMethod(nameResolver, setter);
                }
            } else if (!jvmPropertySignature.hasGetter()) {
                return null;
            } else {
                MemberSignature.Companion companion4 = MemberSignature.Companion;
                JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                Intrinsics.checkExpressionValueIsNotNull(getter, "signature.getter");
                return companion4.fromMethod(nameResolver, getter);
            }
        }
    }

    public static /* synthetic */ MemberSignature getCallableSignature$default(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind, boolean z, int i, Object obj) {
        boolean z2;
        if (obj == null) {
            if ((i & 16) != 0) {
                z2 = false;
            } else {
                z2 = z;
            }
            return abstractBinaryClassAnnotationAndConstantLoader.getCallableSignature(messageLite, nameResolver, typeTable, annotatedCallableKind, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    private final MemberSignature getPropertySignature(ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z, boolean z2, boolean z3) {
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
        Intrinsics.checkExpressionValueIsNotNull(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(property, propertySignature);
        if (jvmPropertySignature != null) {
            if (z) {
                JvmMemberSignature.Field jvmFieldSignature = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(property, nameResolver, typeTable, z3);
                if (jvmFieldSignature == null) {
                    return null;
                }
                return MemberSignature.Companion.fromJvmMemberSignature(jvmFieldSignature);
            } else if (z2 && jvmPropertySignature.hasSyntheticMethod()) {
                MemberSignature.Companion companion = MemberSignature.Companion;
                JvmProtoBuf.JvmMethodSignature syntheticMethod = jvmPropertySignature.getSyntheticMethod();
                Intrinsics.checkExpressionValueIsNotNull(syntheticMethod, "signature.syntheticMethod");
                return companion.fromMethod(nameResolver, syntheticMethod);
            }
        }
        return null;
    }

    private final KotlinJvmBinaryClass getSpecialCaseContainerClass(ProtoContainer protoContainer, boolean z, boolean z2, Boolean bool, boolean z3) {
        ProtoContainer.Class outerClass;
        JvmClassName jvmClassName;
        if (z) {
            if (bool != null) {
                if (protoContainer instanceof ProtoContainer.Class) {
                    ProtoContainer.Class r8 = (ProtoContainer.Class) protoContainer;
                    if (r8.getKind() == ProtoBuf.Class.Kind.INTERFACE) {
                        KotlinClassFinder kotlinClassFinder = this.kotlinClassFinder;
                        ClassId createNestedClassId = r8.getClassId().createNestedClassId(Name.identifier("DefaultImpls"));
                        Intrinsics.checkExpressionValueIsNotNull(createNestedClassId, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder, createNestedClassId);
                    }
                }
                if (bool.booleanValue() && (protoContainer instanceof ProtoContainer.Package)) {
                    SourceElement source = protoContainer.getSource();
                    if (!(source instanceof JvmPackagePartSource)) {
                        source = null;
                    }
                    JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) source;
                    if (jvmPackagePartSource != null) {
                        jvmClassName = jvmPackagePartSource.getFacadeClassName();
                    } else {
                        jvmClassName = null;
                    }
                    if (jvmClassName != null) {
                        KotlinClassFinder kotlinClassFinder2 = this.kotlinClassFinder;
                        String internalName = jvmClassName.getInternalName();
                        Intrinsics.checkExpressionValueIsNotNull(internalName, "facadeClassName.internalName");
                        ClassId classId = ClassId.topLevel(new FqName(StringsKt__StringsJVMKt.replace$default(internalName, (char) WebvttCueParser.CHAR_SLASH, (char) IStringUtil.EXTENSION_SEPARATOR, false, 4, (Object) null)));
                        Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(FqName(…lName.replace('/', '.')))");
                        return KotlinClassFinderKt.findKotlinClass(kotlinClassFinder2, classId);
                    }
                }
            } else {
                throw new IllegalStateException(("isConst should not be null for property (container=" + protoContainer + ')').toString());
            }
        }
        if (z2 && (protoContainer instanceof ProtoContainer.Class)) {
            ProtoContainer.Class r82 = (ProtoContainer.Class) protoContainer;
            if (r82.getKind() == ProtoBuf.Class.Kind.COMPANION_OBJECT && (outerClass = r82.getOuterClass()) != null && (outerClass.getKind() == ProtoBuf.Class.Kind.CLASS || outerClass.getKind() == ProtoBuf.Class.Kind.ENUM_CLASS || (z3 && (outerClass.getKind() == ProtoBuf.Class.Kind.INTERFACE || outerClass.getKind() == ProtoBuf.Class.Kind.ANNOTATION_CLASS)))) {
                return toBinaryClass(outerClass);
            }
        }
        if (!(protoContainer instanceof ProtoContainer.Package) || !(protoContainer.getSource() instanceof JvmPackagePartSource)) {
            return null;
        }
        SourceElement source2 = protoContainer.getSource();
        if (source2 != null) {
            JvmPackagePartSource jvmPackagePartSource2 = (JvmPackagePartSource) source2;
            KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource2.getKnownJvmBinaryClass();
            if (knownJvmBinaryClass == null) {
                return KotlinClassFinderKt.findKotlinClass(this.kotlinClassFinder, jvmPackagePartSource2.getClassId());
            }
            return knownJvmBinaryClass;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial(ClassId classId, SourceElement sourceElement, List<A> list) {
        if (SPECIAL_ANNOTATIONS.contains(classId)) {
            return null;
        }
        return loadAnnotation(classId, sourceElement, list);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        MemberSignature callableSignature$default = getCallableSignature$default(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        if (callableSignature$default != null) {
            return findClassAndLoadMemberAnnotations$default(this, protoContainer, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(callableSignature$default, 0), false, false, null, false, 60, null);
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Storage<A, C> loadAnnotationsAndInitializers(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        kotlinJvmBinaryClass.visitMembers(new KotlinJvmBinaryClass.MemberVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1

            /* loaded from: classes9.dex */
            public final class AnnotationVisitorForMethod extends MemberAnnotationVisitor implements KotlinJvmBinaryClass.MethodAnnotationVisitor {
                public AnnotationVisitorForMethod(MemberSignature memberSignature) {
                    super(memberSignature);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i, ClassId classId, SourceElement sourceElement) {
                    KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial;
                    MemberSignature fromMethodSignatureAndParameterIndex = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(getSignature(), i);
                    List list = (List) hashMap.get(fromMethodSignatureAndParameterIndex);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(fromMethodSignatureAndParameterIndex, list);
                    }
                    loadAnnotationIfNotSpecial = AbstractBinaryClassAnnotationAndConstantLoader.this.loadAnnotationIfNotSpecial(classId, sourceElement, list);
                    return loadAnnotationIfNotSpecial;
                }
            }

            /* loaded from: classes9.dex */
            public class MemberAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
                public final ArrayList<A> result = new ArrayList<>();
                public final MemberSignature signature;

                public MemberAnnotationVisitor(MemberSignature memberSignature) {
                    this.signature = memberSignature;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
                    KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial;
                    loadAnnotationIfNotSpecial = AbstractBinaryClassAnnotationAndConstantLoader.this.loadAnnotationIfNotSpecial(classId, sourceElement, this.result);
                    return loadAnnotationIfNotSpecial;
                }

                public final MemberSignature getSignature() {
                    return this.signature;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public void visitEnd() {
                    if (!this.result.isEmpty()) {
                        hashMap.put(this.signature, this.result);
                    }
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
            public KotlinJvmBinaryClass.AnnotationVisitor visitField(Name name, String str, Object obj) {
                Object loadConstant;
                MemberSignature.Companion companion = MemberSignature.Companion;
                String asString = name.asString();
                Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
                MemberSignature fromFieldNameAndDesc = companion.fromFieldNameAndDesc(asString, str);
                if (obj != null && (loadConstant = AbstractBinaryClassAnnotationAndConstantLoader.this.loadConstant(str, obj)) != null) {
                    hashMap2.put(fromFieldNameAndDesc, loadConstant);
                }
                return new MemberAnnotationVisitor(fromFieldNameAndDesc);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
            public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(Name name, String str) {
                MemberSignature.Companion companion = MemberSignature.Companion;
                String asString = name.asString();
                Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
                return new AnnotationVisitorForMethod(companion.fromMethodNameAndDesc(asString, str));
            }
        }, getCachedFileContent(kotlinJvmBinaryClass));
        return new Storage<>(hashMap, hashMap2);
    }

    private final KotlinJvmBinaryClass toBinaryClass(ProtoContainer.Class r3) {
        SourceElement source = r3.getSource();
        if (!(source instanceof KotlinJvmBinarySourceElement)) {
            source = null;
        }
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = (KotlinJvmBinarySourceElement) source;
        if (kotlinJvmBinarySourceElement == null) {
            return null;
        }
        return kotlinJvmBinarySourceElement.getBinaryClass();
    }

    private final List<A> loadPropertyAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property, PropertyRelatedElement propertyRelatedElement) {
        Boolean bool = Flags.IS_CONST.get(property.getFlags());
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_CONST.get(proto.flags)");
        boolean booleanValue = bool.booleanValue();
        boolean isMovedFromInterfaceCompanion = JvmProtoBufUtil.isMovedFromInterfaceCompanion(property);
        if (propertyRelatedElement == PropertyRelatedElement.PROPERTY) {
            MemberSignature propertySignature$default = getPropertySignature$default(this, property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), false, true, false, 40, null);
            if (propertySignature$default != null) {
                return findClassAndLoadMemberAnnotations$default(this, protoContainer, propertySignature$default, true, false, Boolean.valueOf(booleanValue), isMovedFromInterfaceCompanion, 8, null);
            }
            return CollectionsKt__CollectionsKt.emptyList();
        }
        MemberSignature propertySignature$default2 = getPropertySignature$default(this, property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), true, false, false, 48, null);
        if (propertySignature$default2 != null) {
            boolean z = false;
            boolean contains$default = StringsKt__StringsKt.contains$default((CharSequence) propertySignature$default2.getSignature$descriptors_jvm(), (CharSequence) "$delegate", false, 2, (Object) null);
            if (propertyRelatedElement == PropertyRelatedElement.DELEGATE_FIELD) {
                z = true;
            }
            if (contains$default != z) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            return findClassAndLoadMemberAnnotations(protoContainer, propertySignature$default2, true, true, Boolean.valueOf(booleanValue), isMovedFromInterfaceCompanion);
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        if (annotatedCallableKind == AnnotatedCallableKind.PROPERTY) {
            return loadPropertyAnnotations(protoContainer, (ProtoBuf.Property) messageLite, PropertyRelatedElement.PROPERTY);
        }
        MemberSignature callableSignature$default = getCallableSignature$default(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        if (callableSignature$default != null) {
            return findClassAndLoadMemberAnnotations$default(this, protoContainer, callableSignature$default, false, false, null, false, 60, null);
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class r4) {
        KotlinJvmBinaryClass binaryClass = toBinaryClass(r4);
        if (binaryClass != null) {
            final ArrayList arrayList = new ArrayList(1);
            binaryClass.loadClassAnnotations(new KotlinJvmBinaryClass.AnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadClassAnnotations$1
                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public void visitEnd() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
                    KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotationIfNotSpecial;
                    loadAnnotationIfNotSpecial = AbstractBinaryClassAnnotationAndConstantLoader.this.loadAnnotationIfNotSpecial(classId, sourceElement, arrayList);
                    return loadAnnotationIfNotSpecial;
                }
            }, getCachedFileContent(binaryClass));
            return arrayList;
        }
        throw new IllegalStateException(("Class for loading annotations is not found: " + r4.debugFqName()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer protoContainer, ProtoBuf.EnumEntry enumEntry) {
        MemberSignature.Companion companion = MemberSignature.Companion;
        String string = protoContainer.getNameResolver().getString(enumEntry.getName());
        String asString = ((ProtoContainer.Class) protoContainer).getClassId().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "(container as ProtoConta…Class).classId.asString()");
        return findClassAndLoadMemberAnnotations$default(this, protoContainer, companion.fromFieldNameAndDesc(string, ClassMapperLite.mapClass(asString)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadTypeAnnotations(ProtoBuf.Type type, NameResolver nameResolver) {
        Object extension = type.getExtension(JvmProtoBuf.typeAnnotation);
        Intrinsics.checkExpressionValueIsNotNull(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation it : iterable) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            arrayList.add(loadTypeAnnotation(it, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf.TypeParameter typeParameter, NameResolver nameResolver) {
        Object extension = typeParameter.getExtension(JvmProtoBuf.typeParameterAnnotation);
        Intrinsics.checkExpressionValueIsNotNull(extension, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation it : iterable) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            arrayList.add(loadTypeAnnotation(it, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadPropertyConstant(ProtoContainer protoContainer, ProtoBuf.Property property, KotlinType kotlinType) {
        C c;
        KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers = findClassWithAnnotationsAndInitializers(protoContainer, getSpecialCaseContainerClass(protoContainer, true, true, Flags.IS_CONST.get(property.getFlags()), JvmProtoBufUtil.isMovedFromInterfaceCompanion(property)));
        if (findClassWithAnnotationsAndInitializers != null) {
            MemberSignature callableSignature = getCallableSignature(property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), AnnotatedCallableKind.PROPERTY, findClassWithAnnotationsAndInitializers.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()));
            if (callableSignature != null && (c = this.storage.invoke(findClassWithAnnotationsAndInitializers).getPropertyConstants().get(callableSignature)) != null) {
                if (UnsignedTypes.INSTANCE.isUnsignedType(kotlinType)) {
                    return transformToUnsignedConstant(c);
                }
                return c;
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public List<A> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf.ValueParameter valueParameter) {
        MemberSignature callableSignature$default = getCallableSignature$default(this, messageLite, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, false, 16, null);
        if (callableSignature$default != null) {
            return findClassAndLoadMemberAnnotations$default(this, protoContainer, MemberSignature.Companion.fromMethodSignatureAndParameterIndex(callableSignature$default, i + computeJvmParameterIndexShift(protoContainer, messageLite)), false, false, null, false, 60, null);
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }
}
