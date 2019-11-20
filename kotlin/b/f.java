package kotlin.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class f extends e {
    public static final a cK(int i, int i2) {
        return a.kvp.ae(i, i2, -1);
    }

    public static final c cL(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? c.kvt.cNf() : new c(i, i2 - 1);
    }

    public static final int cM(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final int cN(int i, int i2) {
        return i > i2 ? i2 : i;
    }
}
