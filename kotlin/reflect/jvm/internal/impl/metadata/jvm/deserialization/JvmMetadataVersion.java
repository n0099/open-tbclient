package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
/* loaded from: classes2.dex */
public final class JvmMetadataVersion extends BinaryVersion {
    public static final Companion Companion = new Companion(null);
    @JvmField
    public static final JvmMetadataVersion INSTANCE = new JvmMetadataVersion(1, 1, 16);
    @JvmField
    public static final JvmMetadataVersion INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    public final boolean isStrictSemantics;

    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public boolean isCompatible() {
        boolean z;
        if (getMajor() == 1 && getMinor() == 0) {
            return false;
        }
        if (this.isStrictSemantics) {
            z = isCompatibleTo(INSTANCE);
        } else if (getMajor() == 1 && getMinor() <= 4) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    public JvmMetadataVersion(int... iArr) {
        this(iArr, false);
    }

    public JvmMetadataVersion(int[] iArr, boolean z) {
        super(Arrays.copyOf(iArr, iArr.length));
        this.isStrictSemantics = z;
    }
}
