package d.g.c.a;
/* loaded from: classes6.dex */
public abstract class b implements o<Character> {

    /* loaded from: classes6.dex */
    public static abstract class a extends b {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // d.g.c.a.o
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.b(ch);
        }
    }

    /* renamed from: d.g.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1848b extends a {

        /* renamed from: e  reason: collision with root package name */
        public final char f66226e;

        /* renamed from: f  reason: collision with root package name */
        public final char f66227f;

        public C1848b(char c2, char c3) {
            n.d(c3 >= c2);
            this.f66226e = c2;
            this.f66227f = c3;
        }

        @Override // d.g.c.a.b
        public boolean f(char c2) {
            return this.f66226e <= c2 && c2 <= this.f66227f;
        }

        public String toString() {
            return "CharMatcher.inRange('" + b.g(this.f66226e) + "', '" + b.g(this.f66227f) + "')";
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends a {

        /* renamed from: e  reason: collision with root package name */
        public final char f66228e;

        public c(char c2) {
            this.f66228e = c2;
        }

        @Override // d.g.c.a.b
        public boolean f(char c2) {
            return c2 == this.f66228e;
        }

        public String toString() {
            return "CharMatcher.is('" + b.g(this.f66228e) + "')";
        }
    }

    public static b c(char c2, char c3) {
        return new C1848b(c2, c3);
    }

    public static b e(char c2) {
        return new c(c2);
    }

    public static String g(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public boolean b(Character ch) {
        return f(ch.charValue());
    }

    public int d(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        n.t(i2, length);
        while (i2 < length) {
            if (f(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public abstract boolean f(char c2);
}
