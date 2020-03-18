package kotlin.b;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class o extends n {
    public static final f ex(int i, int i2) {
        return f.nEJ.av(i, i2, -1);
    }

    public static final h ey(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? h.nEL.dLl() : new h(i, i2 - 1);
    }

    public static final int ez(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final int eA(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final int aw(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
        }
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }
}
