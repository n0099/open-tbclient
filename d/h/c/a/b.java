package d.h.c.a;
/* loaded from: classes6.dex */
public abstract class b implements o<Character> {

    /* loaded from: classes6.dex */
    public static abstract class a extends b {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // d.h.c.a.o
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.b(ch);
        }
    }

    /* renamed from: d.h.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1840b extends a {

        /* renamed from: e  reason: collision with root package name */
        public final char f67082e;

        /* renamed from: f  reason: collision with root package name */
        public final char f67083f;

        public C1840b(char c2, char c3) {
            n.d(c3 >= c2);
            this.f67082e = c2;
            this.f67083f = c3;
        }

        @Override // d.h.c.a.b
        public boolean f(char c2) {
            return this.f67082e <= c2 && c2 <= this.f67083f;
        }

        public String toString() {
            return "CharMatcher.inRange('" + b.g(this.f67082e) + "', '" + b.g(this.f67083f) + "')";
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends a {

        /* renamed from: e  reason: collision with root package name */
        public final char f67084e;

        public c(char c2) {
            this.f67084e = c2;
        }

        @Override // d.h.c.a.b
        public boolean f(char c2) {
            return c2 == this.f67084e;
        }

        public String toString() {
            return "CharMatcher.is('" + b.g(this.f67084e) + "')";
        }
    }

    public static b c(char c2, char c3) {
        return new C1840b(c2, c3);
    }

    public static b e(char c2) {
        return new c(c2);
    }

    public static String g(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public boolean b(Character ch) {
        return f(ch.charValue());
    }

    public int d(CharSequence charSequence, int i) {
        int length = charSequence.length();
        n.t(i, length);
        while (i < length) {
            if (f(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean f(char c2);
}
