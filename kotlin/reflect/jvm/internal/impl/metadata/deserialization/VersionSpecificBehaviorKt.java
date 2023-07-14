package kotlin.reflect.jvm.internal.impl.metadata.deserialization;
/* loaded from: classes2.dex */
public final class VersionSpecificBehaviorKt {
    public static final boolean isKotlin1Dot4OrLater(BinaryVersion binaryVersion) {
        if (binaryVersion.getMajor() == 1 && binaryVersion.getMinor() >= 4) {
            return true;
        }
        return false;
    }

    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion binaryVersion) {
        return isKotlin1Dot4OrLater(binaryVersion);
    }
}
