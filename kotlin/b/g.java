package kotlin.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class g extends f {
    public static final a et(int i, int i2) {
        return a.nBX.au(i, i2, -1);
    }

    public static final c eu(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? c.nCa.dJy() : new c(i, i2 - 1);
    }

    public static final int ev(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final int ew(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final int av(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
        }
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }
}
