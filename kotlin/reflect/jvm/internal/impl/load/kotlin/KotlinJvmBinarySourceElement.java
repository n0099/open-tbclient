package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
/* loaded from: classes9.dex */
public final class KotlinJvmBinarySourceElement implements DeserializedContainerSource {
    public final KotlinJvmBinaryClass binaryClass;
    public final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
    public final boolean isPreReleaseInvisible;

    public KotlinJvmBinarySourceElement(KotlinJvmBinaryClass kotlinJvmBinaryClass, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z) {
        this.binaryClass = kotlinJvmBinaryClass;
        this.incompatibility = incompatibleVersionErrorData;
        this.isPreReleaseInvisible = z;
    }

    public final KotlinJvmBinaryClass getBinaryClass() {
        return this.binaryClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkExpressionValueIsNotNull(sourceFile, "SourceFile.NO_SOURCE_FILE");
        return sourceFile;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    public String getPresentableString() {
        return "Class '" + this.binaryClass.getClassId().asSingleFqName().asString() + '\'';
    }

    public String toString() {
        return KotlinJvmBinarySourceElement.class.getSimpleName() + ": " + this.binaryClass;
    }
}
