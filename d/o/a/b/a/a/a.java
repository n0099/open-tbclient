package d.o.a.b.a.a;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements d.o.a.a.a.c.b {

    /* renamed from: a  reason: collision with root package name */
    public int f70382a;

    /* renamed from: b  reason: collision with root package name */
    public int f70383b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f70384c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f70385d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f70386e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70387f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f70388g;

    /* renamed from: h  reason: collision with root package name */
    public Object f70389h;

    /* renamed from: i  reason: collision with root package name */
    public Object f70390i;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f70391a;

        /* renamed from: b  reason: collision with root package name */
        public int f70392b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f70393c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f70394d;

        /* renamed from: e  reason: collision with root package name */
        public Object f70395e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f70396f;

        /* renamed from: g  reason: collision with root package name */
        public int f70397g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f70398h;

        /* renamed from: i  reason: collision with root package name */
        public Object f70399i;
        public boolean k;
        public boolean j = true;
        public boolean l = true;

        public b b(int i2) {
            this.f70391a = i2;
            return this;
        }

        public b c(Object obj) {
            this.f70395e = obj;
            return this;
        }

        public b d(boolean z) {
            this.f70393c = z;
            return this;
        }

        public a e() {
            return new a(this);
        }

        public b g(int i2) {
            this.f70392b = i2;
            return this;
        }

        public b h(boolean z) {
            this.f70394d = z;
            return this;
        }

        @Deprecated
        public b i(boolean z) {
            return this;
        }

        public b k(boolean z) {
            this.f70396f = z;
            return this;
        }

        public b m(boolean z) {
            this.j = z;
            return this;
        }
    }

    @Override // d.o.a.a.a.c.b
    public int a() {
        return this.f70382a;
    }

    @Override // d.o.a.a.a.c.b
    public int b() {
        return this.f70383b;
    }

    @Override // d.o.a.a.a.c.b
    public boolean c() {
        return this.f70384c;
    }

    @Override // d.o.a.a.a.c.b
    public boolean d() {
        return this.f70385d;
    }

    @Override // d.o.a.a.a.c.b
    public boolean e() {
        return this.f70386e;
    }

    @Override // d.o.a.a.a.c.b
    public boolean f() {
        return this.f70387f;
    }

    @Override // d.o.a.a.a.c.b
    public boolean g() {
        return this.f70388g;
    }

    public a(b bVar) {
        this.f70386e = true;
        this.f70388g = true;
        this.f70382a = bVar.f70391a;
        this.f70383b = bVar.f70392b;
        this.f70384c = bVar.f70393c;
        this.f70385d = bVar.f70394d;
        this.f70389h = bVar.f70395e;
        boolean unused = bVar.f70396f;
        int unused2 = bVar.f70397g;
        JSONObject unused3 = bVar.f70398h;
        this.f70390i = bVar.f70399i;
        this.f70386e = bVar.j;
        this.f70387f = bVar.k;
        this.f70388g = bVar.l;
    }

    @Override // d.o.a.a.a.c.b
    public void a(int i2) {
        this.f70383b = i2;
    }

    @Override // d.o.a.a.a.c.b
    public void b(int i2) {
        this.f70382a = i2;
    }

    @Override // d.o.a.a.a.c.b
    public void a(boolean z) {
        this.f70388g = z;
    }
}
