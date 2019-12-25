package kotlin.jvm.internal;

import kotlin.collections.aj;
import kotlin.collections.w;
import kotlin.collections.y;
import kotlin.collections.z;
/* loaded from: classes4.dex */
public final class i {
    public static final kotlin.collections.l aD(byte[] bArr) {
        p.j(bArr, "array");
        return new b(bArr);
    }

    public static final kotlin.collections.m g(char[] cArr) {
        p.j(cArr, "array");
        return new c(cArr);
    }

    public static final aj b(short[] sArr) {
        p.j(sArr, "array");
        return new k(sArr);
    }

    public static final y q(int[] iArr) {
        p.j(iArr, "array");
        return new f(iArr);
    }

    public static final z b(long[] jArr) {
        p.j(jArr, "array");
        return new j(jArr);
    }

    public static final w m(float[] fArr) {
        p.j(fArr, "array");
        return new e(fArr);
    }

    public static final kotlin.collections.u q(double[] dArr) {
        p.j(dArr, "array");
        return new d(dArr);
    }

    public static final kotlin.collections.k c(boolean[] zArr) {
        p.j(zArr, "array");
        return new a(zArr);
    }
}
