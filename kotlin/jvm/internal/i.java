package kotlin.jvm.internal;

import kotlin.collections.ag;
import kotlin.collections.u;
import kotlin.collections.w;
import kotlin.collections.y;
import kotlin.collections.z;
/* loaded from: classes2.dex */
public final class i {
    public static final kotlin.collections.l S(byte[] bArr) {
        p.i(bArr, "array");
        return new b(bArr);
    }

    public static final kotlin.collections.m c(char[] cArr) {
        p.i(cArr, "array");
        return new c(cArr);
    }

    public static final ag b(short[] sArr) {
        p.i(sArr, "array");
        return new k(sArr);
    }

    public static final y i(int[] iArr) {
        p.i(iArr, "array");
        return new f(iArr);
    }

    public static final z b(long[] jArr) {
        p.i(jArr, "array");
        return new j(jArr);
    }

    public static final w k(float[] fArr) {
        p.i(fArr, "array");
        return new e(fArr);
    }

    public static final u j(double[] dArr) {
        p.i(dArr, "array");
        return new d(dArr);
    }

    public static final kotlin.collections.k c(boolean[] zArr) {
        p.i(zArr, "array");
        return new a(zArr);
    }
}
