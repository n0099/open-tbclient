package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes2.dex */
public final class JvmPackagePartSource implements DeserializedContainerSource {
    public final JvmClassName className;
    public final JvmClassName facadeClassName;
    public final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
    public final boolean isPreReleaseInvisible;
    public final KotlinJvmBinaryClass knownJvmBinaryClass;
    public final String moduleName;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JvmPackagePartSource(KotlinJvmBinaryClass kotlinJvmBinaryClass, ProtoBuf.Package r11, NameResolver nameResolver, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z) {
        this(r2, r1, r11, nameResolver, incompatibleVersionErrorData, z, kotlinJvmBinaryClass);
        boolean z2;
        JvmClassName byClassId = JvmClassName.byClassId(kotlinJvmBinaryClass.getClassId());
        Intrinsics.checkExpressionValueIsNotNull(byClassId, "JvmClassName.byClassId(kotlinClass.classId)");
        String multifileClassName = kotlinJvmBinaryClass.getClassHeader().getMultifileClassName();
        JvmClassName jvmClassName = null;
        if (multifileClassName != null) {
            if (multifileClassName.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                jvmClassName = JvmClassName.byInternalName(multifileClassName);
            }
        }
    }

    public JvmPackagePartSource(JvmClassName jvmClassName, JvmClassName jvmClassName2, ProtoBuf.Package r3, NameResolver nameResolver, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        this.className = jvmClassName;
        this.facadeClassName = jvmClassName2;
        this.incompatibility = incompatibleVersionErrorData;
        this.isPreReleaseInvisible = z;
        this.knownJvmBinaryClass = kotlinJvmBinaryClass;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> generatedExtension = JvmProtoBuf.packageModuleName;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension, "JvmProtoBuf.packageModuleName");
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(r3, generatedExtension);
        this.moduleName = (num == null || (r1 = nameResolver.getString(num.intValue())) == null) ? "main" : "main";
    }

    public final ClassId getClassId() {
        return new ClassId(this.className.getPackageFqName(), getSimpleName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkExpressionValueIsNotNull(sourceFile, "SourceFile.NO_SOURCE_FILE");
        return sourceFile;
    }

    public final JvmClassName getFacadeClassName() {
        return this.facadeClassName;
    }

    public final KotlinJvmBinaryClass getKnownJvmBinaryClass() {
        return this.knownJvmBinaryClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    public String getPresentableString() {
        return "Class '" + getClassId().asSingleFqName().asString() + '\'';
    }

    public final Name getSimpleName() {
        String internalName = this.className.getInternalName();
        Intrinsics.checkExpressionValueIsNotNull(internalName, "className.internalName");
        Name identifier = Name.identifier(StringsKt__StringsKt.substringAfterLast$default(internalName, (char) WebvttCueParser.CHAR_SLASH, (String) null, 2, (Object) null));
        Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(classNam….substringAfterLast('/'))");
        return identifier;
    }

    public String toString() {
        return JvmPackagePartSource.class.getSimpleName() + ": " + this.className;
    }
}
