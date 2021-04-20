package d.g.c.c;
/* loaded from: classes6.dex */
public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f67001a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final o f67002b = new b(-1);

    /* renamed from: c  reason: collision with root package name */
    public static final o f67003c = new b(1);

    /* loaded from: classes6.dex */
    public static class a extends o {
        public a() {
            super(null);
        }

        @Override // d.g.c.c.o
        public o d(Comparable comparable, Comparable comparable2) {
            return g(comparable.compareTo(comparable2));
        }

        @Override // d.g.c.c.o
        public int e() {
            return 0;
        }

        public o g(int i) {
            if (i < 0) {
                return o.f67002b;
            }
            return i > 0 ? o.f67003c : o.f67001a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends o {

        /* renamed from: d  reason: collision with root package name */
        public final int f67004d;

        public b(int i) {
            super(null);
            this.f67004d = i;
        }

        @Override // d.g.c.c.o
        public o d(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // d.g.c.c.o
        public int e() {
            return this.f67004d;
        }
    }

    public /* synthetic */ o(a aVar) {
        this();
    }

    public static o f() {
        return f67001a;
    }

    public abstract o d(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract int e();

    public o() {
    }
}
