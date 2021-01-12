package kotlin.b;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.e
/* loaded from: classes5.dex */
public class n extends m {
    public static final f eo(int i, int i2) {
        return f.qjC.ap(i, i2, -1);
    }

    public static final h ep(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? h.qjE.eJi() : new h(i, i2 - 1);
    }

    public static final int eq(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final int er(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final int aq(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
        }
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }
}
