package d.h.c.a;
/* loaded from: classes6.dex */
public abstract class e {
    public static e compile(String str) {
        return m.a(str);
    }

    public static boolean isPcreLike() {
        return m.d();
    }

    public abstract int flags();

    public abstract d matcher(CharSequence charSequence);

    public abstract String pattern();

    public abstract String toString();
}
