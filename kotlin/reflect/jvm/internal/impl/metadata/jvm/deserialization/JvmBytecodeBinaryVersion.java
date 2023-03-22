package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
/* loaded from: classes9.dex */
public final class JvmBytecodeBinaryVersion extends BinaryVersion {
    public static final Companion Companion = new Companion(null);
    @JvmField
    public static final JvmBytecodeBinaryVersion INSTANCE = new JvmBytecodeBinaryVersion(1, 0, 3);
    @JvmField
    public static final JvmBytecodeBinaryVersion INVALID_VERSION = new JvmBytecodeBinaryVersion(new int[0]);

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public JvmBytecodeBinaryVersion(int... iArr) {
        super(Arrays.copyOf(iArr, iArr.length));
    }
}
