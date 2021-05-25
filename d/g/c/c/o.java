package d.g.c.c;
/* loaded from: classes6.dex */
public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f66293a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final o f66294b = new b(-1);

    /* renamed from: c  reason: collision with root package name */
    public static final o f66295c = new b(1);

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

        public o g(int i2) {
            if (i2 < 0) {
                return o.f66294b;
            }
            return i2 > 0 ? o.f66295c : o.f66293a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends o {

        /* renamed from: d  reason: collision with root package name */
        public final int f66296d;

        public b(int i2) {
            super(null);
            this.f66296d = i2;
        }

        @Override // d.g.c.c.o
        public o d(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // d.g.c.c.o
        public int e() {
            return this.f66296d;
        }
    }

    public /* synthetic */ o(a aVar) {
        this();
    }

    public static o f() {
        return f66293a;
    }

    public abstract o d(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract int e();

    public o() {
    }
}
