package d.p.a.b.a.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements d.p.a.a.a.c.b {

    /* renamed from: a  reason: collision with root package name */
    public int f67531a;

    /* renamed from: b  reason: collision with root package name */
    public int f67532b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67533c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67534d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67535e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67536f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67537g;

    /* renamed from: h  reason: collision with root package name */
    public Object f67538h;
    public Object i;

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f67539a;

        /* renamed from: b  reason: collision with root package name */
        public int f67540b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f67541c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67542d;

        /* renamed from: e  reason: collision with root package name */
        public Object f67543e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67544f;

        /* renamed from: g  reason: collision with root package name */
        public int f67545g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f67546h;
        public Object i;
        public boolean k;
        public boolean j = true;
        public boolean l = true;

        public b b(int i) {
            this.f67539a = i;
            return this;
        }

        public b c(Object obj) {
            this.f67543e = obj;
            return this;
        }

        public b d(boolean z) {
            this.f67541c = z;
            return this;
        }

        public a e() {
            return new a(this);
        }

        public b g(int i) {
            this.f67540b = i;
            return this;
        }

        public b h(boolean z) {
            this.f67542d = z;
            return this;
        }

        @Deprecated
        public b i(boolean z) {
            return this;
        }

        public b k(boolean z) {
            this.f67544f = z;
            return this;
        }

        public b m(boolean z) {
            this.j = z;
            return this;
        }
    }

    @Override // d.p.a.a.a.c.b
    public int a() {
        return this.f67531a;
    }

    @Override // d.p.a.a.a.c.b
    public int b() {
        return this.f67532b;
    }

    @Override // d.p.a.a.a.c.b
    public boolean c() {
        return this.f67533c;
    }

    @Override // d.p.a.a.a.c.b
    public boolean d() {
        return this.f67534d;
    }

    @Override // d.p.a.a.a.c.b
    public boolean e() {
        return this.f67535e;
    }

    @Override // d.p.a.a.a.c.b
    public boolean f() {
        return this.f67536f;
    }

    @Override // d.p.a.a.a.c.b
    public boolean g() {
        return this.f67537g;
    }

    public a(b bVar) {
        this.f67535e = true;
        this.f67537g = true;
        this.f67531a = bVar.f67539a;
        this.f67532b = bVar.f67540b;
        this.f67533c = bVar.f67541c;
        this.f67534d = bVar.f67542d;
        this.f67538h = bVar.f67543e;
        boolean unused = bVar.f67544f;
        int unused2 = bVar.f67545g;
        JSONObject unused3 = bVar.f67546h;
        this.i = bVar.i;
        this.f67535e = bVar.j;
        this.f67536f = bVar.k;
        this.f67537g = bVar.l;
    }

    @Override // d.p.a.a.a.c.b
    public void a(int i) {
        this.f67532b = i;
    }

    @Override // d.p.a.a.a.c.b
    public void b(int i) {
        this.f67531a = i;
    }

    @Override // d.p.a.a.a.c.b
    public void a(boolean z) {
        this.f67537g = z;
    }
}
