package d.h.c.c;
/* loaded from: classes6.dex */
public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f67148a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final o f67149b = new b(-1);

    /* renamed from: c  reason: collision with root package name */
    public static final o f67150c = new b(1);

    /* loaded from: classes6.dex */
    public static class a extends o {
        public a() {
            super(null);
        }

        @Override // d.h.c.c.o
        public o d(Comparable comparable, Comparable comparable2) {
            return g(comparable.compareTo(comparable2));
        }

        @Override // d.h.c.c.o
        public int e() {
            return 0;
        }

        public o g(int i) {
            if (i < 0) {
                return o.f67149b;
            }
            return i > 0 ? o.f67150c : o.f67148a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends o {

        /* renamed from: d  reason: collision with root package name */
        public final int f67151d;

        public b(int i) {
            super(null);
            this.f67151d = i;
        }

        @Override // d.h.c.c.o
        public o d(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // d.h.c.c.o
        public int e() {
            return this.f67151d;
        }
    }

    public /* synthetic */ o(a aVar) {
        this();
    }

    public static o f() {
        return f67148a;
    }

    public abstract o d(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract int e();

    public o() {
    }
}
