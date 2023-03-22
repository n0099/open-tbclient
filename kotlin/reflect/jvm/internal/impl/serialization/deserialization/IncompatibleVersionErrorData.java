package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
/* loaded from: classes9.dex */
public final class IncompatibleVersionErrorData<T extends BinaryVersion> {
    public final T actualVersion;
    public final ClassId classId;
    public final T expectedVersion;
    public final String filePath;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof IncompatibleVersionErrorData) {
                IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
                return Intrinsics.areEqual(this.actualVersion, incompatibleVersionErrorData.actualVersion) && Intrinsics.areEqual(this.expectedVersion, incompatibleVersionErrorData.expectedVersion) && Intrinsics.areEqual(this.filePath, incompatibleVersionErrorData.filePath) && Intrinsics.areEqual(this.classId, incompatibleVersionErrorData.classId);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t = this.actualVersion;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        T t2 = this.expectedVersion;
        int hashCode2 = (hashCode + (t2 != null ? t2.hashCode() : 0)) * 31;
        String str = this.filePath;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        ClassId classId = this.classId;
        return hashCode3 + (classId != null ? classId.hashCode() : 0);
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + SmallTailInfo.EMOTION_SUFFIX;
    }

    public IncompatibleVersionErrorData(T t, T t2, String str, ClassId classId) {
        this.actualVersion = t;
        this.expectedVersion = t2;
        this.filePath = str;
        this.classId = classId;
    }
}
