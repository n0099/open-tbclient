package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
/* loaded from: classes2.dex */
public final class DeserializedDescriptorResolver {
    public DeserializationComponents components;
    public static final Companion Companion = new Companion(null);
    public static final Set<KotlinClassHeader.Kind> KOTLIN_CLASS = SetsKt__SetsJVMKt.setOf(KotlinClassHeader.Kind.CLASS);
    public static final Set<KotlinClassHeader.Kind> KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART = SetsKt__SetsKt.setOf((Object[]) new KotlinClassHeader.Kind[]{KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART});
    public static final JvmMetadataVersion KOTLIN_1_1_EAP_METADATA_VERSION = new JvmMetadataVersion(1, 1, 2);
    public static final JvmMetadataVersion KOTLIN_1_3_M1_METADATA_VERSION = new JvmMetadataVersion(1, 1, 11);
    public static final JvmMetadataVersion KOTLIN_1_3_RC_METADATA_VERSION = new JvmMetadataVersion(1, 1, 13);

    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public final JvmMetadataVersion getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return DeserializedDescriptorResolver.KOTLIN_1_3_RC_METADATA_VERSION;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getSkipMetadataVersionCheck() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("components");
        }
        return deserializationComponents.getConfiguration().getSkipMetadataVersionCheck();
    }

    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("components");
        }
        return deserializationComponents;
    }

    private final IncompatibleVersionErrorData<JvmMetadataVersion> getIncompatibility(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (!getSkipMetadataVersionCheck() && !kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
            return new IncompatibleVersionErrorData<>(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), JvmMetadataVersion.INSTANCE, kotlinJvmBinaryClass.getLocation(), kotlinJvmBinaryClass.getClassId());
        }
        return null;
    }

    private final boolean isCompiledWith13M1(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("components");
        }
        if (!deserializationComponents.getConfiguration().getSkipMetadataVersionCheck() && kotlinJvmBinaryClass.getClassHeader().isPreRelease() && Intrinsics.areEqual(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), KOTLIN_1_3_M1_METADATA_VERSION)) {
            return true;
        }
        return false;
    }

    public final ClassDescriptor resolveClass(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        ClassData readClassData$descriptors_jvm = readClassData$descriptors_jvm(kotlinJvmBinaryClass);
        if (readClassData$descriptors_jvm != null) {
            DeserializationComponents deserializationComponents = this.components;
            if (deserializationComponents == null) {
                Intrinsics.throwUninitializedPropertyAccessException("components");
            }
            return deserializationComponents.getClassDeserializer().deserializeClass(kotlinJvmBinaryClass.getClassId(), readClassData$descriptors_jvm);
        }
        return null;
    }

    public final void setComponents(DeserializationComponentsForJava deserializationComponentsForJava) {
        this.components = deserializationComponentsForJava.getComponents();
    }

    private final boolean isPreReleaseInvisible(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("components");
        }
        if ((deserializationComponents.getConfiguration().getReportErrorsOnPreReleaseDependencies() && (kotlinJvmBinaryClass.getClassHeader().isPreRelease() || Intrinsics.areEqual(kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), KOTLIN_1_1_EAP_METADATA_VERSION))) || isCompiledWith13M1(kotlinJvmBinaryClass)) {
            return true;
        }
        return false;
    }

    private final String[] readData(KotlinJvmBinaryClass kotlinJvmBinaryClass, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader classHeader = kotlinJvmBinaryClass.getClassHeader();
        String[] data = classHeader.getData();
        if (data == null) {
            data = classHeader.getIncompatibleData();
        }
        if (data == null || !set.contains(classHeader.getKind())) {
            return null;
        }
        return data;
    }

    public final MemberScope createKotlinPackagePartScope(PackageFragmentDescriptor packageFragmentDescriptor, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Pair<JvmNameResolver, ProtoBuf.Package> pair;
        String[] readData = readData(kotlinJvmBinaryClass, KOTLIN_FILE_FACADE_OR_MULTIFILE_CLASS_PART);
        if (readData != null) {
            String[] strings = kotlinJvmBinaryClass.getClassHeader().getStrings();
            try {
            } catch (Throwable th) {
                if (!getSkipMetadataVersionCheck() && !kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
                    pair = null;
                } else {
                    throw th;
                }
            }
            if (strings != null) {
                try {
                    pair = JvmProtoBufUtil.readPackageDataFrom(readData, strings);
                    if (pair == null) {
                        return null;
                    }
                    JvmNameResolver component1 = pair.component1();
                    ProtoBuf.Package component2 = pair.component2();
                    JvmPackagePartSource jvmPackagePartSource = new JvmPackagePartSource(kotlinJvmBinaryClass, component2, component1, getIncompatibility(kotlinJvmBinaryClass), isPreReleaseInvisible(kotlinJvmBinaryClass));
                    JvmMetadataVersion metadataVersion = kotlinJvmBinaryClass.getClassHeader().getMetadataVersion();
                    DeserializationComponents deserializationComponents = this.components;
                    if (deserializationComponents == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("components");
                    }
                    return new DeserializedPackageMemberScope(packageFragmentDescriptor, component2, component1, metadataVersion, jvmPackagePartSource, deserializationComponents, new Function0<List<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver$createKotlinPackagePartScope$2
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.name.Name>' to match base method */
                        @Override // kotlin.jvm.functions.Function0
                        public final List<? extends Name> invoke() {
                            return CollectionsKt__CollectionsKt.emptyList();
                        }
                    });
                } catch (InvalidProtocolBufferException e) {
                    throw new IllegalStateException("Could not read data from " + kotlinJvmBinaryClass.getLocation(), e);
                }
            }
        }
        return null;
    }

    public final ClassData readClassData$descriptors_jvm(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Pair<JvmNameResolver, ProtoBuf.Class> pair;
        String[] readData = readData(kotlinJvmBinaryClass, KOTLIN_CLASS);
        if (readData != null) {
            String[] strings = kotlinJvmBinaryClass.getClassHeader().getStrings();
            try {
            } catch (Throwable th) {
                if (!getSkipMetadataVersionCheck() && !kotlinJvmBinaryClass.getClassHeader().getMetadataVersion().isCompatible()) {
                    pair = null;
                } else {
                    throw th;
                }
            }
            if (strings != null) {
                try {
                    pair = JvmProtoBufUtil.readClassDataFrom(readData, strings);
                    if (pair == null) {
                        return null;
                    }
                    return new ClassData(pair.component1(), pair.component2(), kotlinJvmBinaryClass.getClassHeader().getMetadataVersion(), new KotlinJvmBinarySourceElement(kotlinJvmBinaryClass, getIncompatibility(kotlinJvmBinaryClass), isPreReleaseInvisible(kotlinJvmBinaryClass)));
                } catch (InvalidProtocolBufferException e) {
                    throw new IllegalStateException("Could not read data from " + kotlinJvmBinaryClass.getLocation(), e);
                }
            }
        }
        return null;
    }
}
