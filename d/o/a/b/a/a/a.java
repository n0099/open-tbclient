package d.o.a.b.a.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements d.o.a.a.a.c.b {

    /* renamed from: a  reason: collision with root package name */
    public int f67384a;

    /* renamed from: b  reason: collision with root package name */
    public int f67385b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67386c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67387d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67388e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67389f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67390g;

    /* renamed from: h  reason: collision with root package name */
    public Object f67391h;
    public Object i;

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f67392a;

        /* renamed from: b  reason: collision with root package name */
        public int f67393b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f67394c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67395d;

        /* renamed from: e  reason: collision with root package name */
        public Object f67396e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67397f;

        /* renamed from: g  reason: collision with root package name */
        public int f67398g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f67399h;
        public Object i;
        public boolean k;
        public boolean j = true;
        public boolean l = true;

        public b b(int i) {
            this.f67392a = i;
            return this;
        }

        public b c(Object obj) {
            this.f67396e = obj;
            return this;
        }

        public b d(boolean z) {
            this.f67394c = z;
            return this;
        }

        public a e() {
            return new a(this);
        }

        public b g(int i) {
            this.f67393b = i;
            return this;
        }

        public b h(boolean z) {
            this.f67395d = z;
            return this;
        }

        @Deprecated
        public b i(boolean z) {
            return this;
        }

        public b k(boolean z) {
            this.f67397f = z;
            return this;
        }

        public b m(boolean z) {
            this.j = z;
            return this;
        }
    }

    @Override // d.o.a.a.a.c.b
    public int a() {
        return this.f67384a;
    }

    @Override // d.o.a.a.a.c.b
    public int b() {
        return this.f67385b;
    }

    @Override // d.o.a.a.a.c.b
    public boolean c() {
        return this.f67386c;
    }

    @Override // d.o.a.a.a.c.b
    public boolean d() {
        return this.f67387d;
    }

    @Override // d.o.a.a.a.c.b
    public boolean e() {
        return this.f67388e;
    }

    @Override // d.o.a.a.a.c.b
    public boolean f() {
        return this.f67389f;
    }

    @Override // d.o.a.a.a.c.b
    public boolean g() {
        return this.f67390g;
    }

    public a(b bVar) {
        this.f67388e = true;
        this.f67390g = true;
        this.f67384a = bVar.f67392a;
        this.f67385b = bVar.f67393b;
        this.f67386c = bVar.f67394c;
        this.f67387d = bVar.f67395d;
        this.f67391h = bVar.f67396e;
        boolean unused = bVar.f67397f;
        int unused2 = bVar.f67398g;
        JSONObject unused3 = bVar.f67399h;
        this.i = bVar.i;
        this.f67388e = bVar.j;
        this.f67389f = bVar.k;
        this.f67390g = bVar.l;
    }

    @Override // d.o.a.a.a.c.b
    public void a(int i) {
        this.f67385b = i;
    }

    @Override // d.o.a.a.a.c.b
    public void b(int i) {
        this.f67384a = i;
    }

    @Override // d.o.a.a.a.c.b
    public void a(boolean z) {
        this.f67390g = z;
    }
}
