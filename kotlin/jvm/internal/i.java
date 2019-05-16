package kotlin.jvm.internal;

import kotlin.collections.ag;
import kotlin.collections.u;
import kotlin.collections.w;
import kotlin.collections.y;
import kotlin.collections.z;
/* loaded from: classes2.dex */
public final class i {
    public static final kotlin.collections.l ad(byte[] bArr) {
        p.k(bArr, "array");
        return new b(bArr);
    }

    public static final kotlin.collections.m c(char[] cArr) {
        p.k(cArr, "array");
        return new c(cArr);
    }

    public static final ag b(short[] sArr) {
        p.k(sArr, "array");
        return new k(sArr);
    }

    public static final y m(int[] iArr) {
        p.k(iArr, "array");
        return new f(iArr);
    }

    public static final z b(long[] jArr) {
        p.k(jArr, "array");
        return new j(jArr);
    }

    public static final w k(float[] fArr) {
        p.k(fArr, "array");
        return new e(fArr);
    }

    public static final u j(double[] dArr) {
        p.k(dArr, "array");
        return new d(dArr);
    }

    public static final kotlin.collections.k c(boolean[] zArr) {
        p.k(zArr, "array");
        return new a(zArr);
    }
}
