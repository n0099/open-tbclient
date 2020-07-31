package kotlin.b;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class o extends n {
    public static final f dY(int i, int i2) {
        return f.nYW.al(i, i2, -1);
    }

    public static final h dZ(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? h.nYY.dUv() : new h(i, i2 - 1);
    }

    public static final int ea(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final int eb(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final int am(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
        }
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }
}
