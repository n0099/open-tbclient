package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
/* loaded from: classes10.dex */
public final class ClassData {
    public final ProtoBuf.Class classProto;
    public final BinaryVersion metadataVersion;
    public final NameResolver nameResolver;
    public final SourceElement sourceElement;

    public final NameResolver component1() {
        return this.nameResolver;
    }

    public final ProtoBuf.Class component2() {
        return this.classProto;
    }

    public final BinaryVersion component3() {
        return this.metadataVersion;
    }

    public final SourceElement component4() {
        return this.sourceElement;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ClassData) {
                ClassData classData = (ClassData) obj;
                return Intrinsics.areEqual(this.nameResolver, classData.nameResolver) && Intrinsics.areEqual(this.classProto, classData.classProto) && Intrinsics.areEqual(this.metadataVersion, classData.metadataVersion) && Intrinsics.areEqual(this.sourceElement, classData.sourceElement);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        NameResolver nameResolver = this.nameResolver;
        int hashCode = (nameResolver != null ? nameResolver.hashCode() : 0) * 31;
        ProtoBuf.Class r2 = this.classProto;
        int hashCode2 = (hashCode + (r2 != null ? r2.hashCode() : 0)) * 31;
        BinaryVersion binaryVersion = this.metadataVersion;
        int hashCode3 = (hashCode2 + (binaryVersion != null ? binaryVersion.hashCode() : 0)) * 31;
        SourceElement sourceElement = this.sourceElement;
        return hashCode3 + (sourceElement != null ? sourceElement.hashCode() : 0);
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.nameResolver + ", classProto=" + this.classProto + ", metadataVersion=" + this.metadataVersion + ", sourceElement=" + this.sourceElement + SmallTailInfo.EMOTION_SUFFIX;
    }

    public ClassData(NameResolver nameResolver, ProtoBuf.Class r2, BinaryVersion binaryVersion, SourceElement sourceElement) {
        this.nameResolver = nameResolver;
        this.classProto = r2;
        this.metadataVersion = binaryVersion;
        this.sourceElement = sourceElement;
    }
}
