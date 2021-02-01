package kotlin.b;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes6.dex */
public class n extends m {
    public static final f el(int i, int i2) {
        return f.qtH.an(i, i2, -1);
    }

    public static final h em(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? h.qtJ.eLy() : new h(i, i2 - 1);
    }

    public static final int en(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final int eo(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final int ao(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
        }
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }
}
