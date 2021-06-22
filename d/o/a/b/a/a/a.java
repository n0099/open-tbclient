package d.o.a.b.a.a;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements d.o.a.a.a.c.b {

    /* renamed from: a  reason: collision with root package name */
    public int f70486a;

    /* renamed from: b  reason: collision with root package name */
    public int f70487b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f70488c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f70489d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f70490e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70491f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f70492g;

    /* renamed from: h  reason: collision with root package name */
    public Object f70493h;

    /* renamed from: i  reason: collision with root package name */
    public Object f70494i;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f70495a;

        /* renamed from: b  reason: collision with root package name */
        public int f70496b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f70497c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f70498d;

        /* renamed from: e  reason: collision with root package name */
        public Object f70499e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f70500f;

        /* renamed from: g  reason: collision with root package name */
        public int f70501g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f70502h;

        /* renamed from: i  reason: collision with root package name */
        public Object f70503i;
        public boolean k;
        public boolean j = true;
        public boolean l = true;

        public b b(int i2) {
            this.f70495a = i2;
            return this;
        }

        public b c(Object obj) {
            this.f70499e = obj;
            return this;
        }

        public b d(boolean z) {
            this.f70497c = z;
            return this;
        }

        public a e() {
            return new a(this);
        }

        public b g(int i2) {
            this.f70496b = i2;
            return this;
        }

        public b h(boolean z) {
            this.f70498d = z;
            return this;
        }

        @Deprecated
        public b i(boolean z) {
            return this;
        }

        public b k(boolean z) {
            this.f70500f = z;
            return this;
        }

        public b m(boolean z) {
            this.j = z;
            return this;
        }
    }

    @Override // d.o.a.a.a.c.b
    public int a() {
        return this.f70486a;
    }

    @Override // d.o.a.a.a.c.b
    public int b() {
        return this.f70487b;
    }

    @Override // d.o.a.a.a.c.b
    public boolean c() {
        return this.f70488c;
    }

    @Override // d.o.a.a.a.c.b
    public boolean d() {
        return this.f70489d;
    }

    @Override // d.o.a.a.a.c.b
    public boolean e() {
        return this.f70490e;
    }

    @Override // d.o.a.a.a.c.b
    public boolean f() {
        return this.f70491f;
    }

    @Override // d.o.a.a.a.c.b
    public boolean g() {
        return this.f70492g;
    }

    public a(b bVar) {
        this.f70490e = true;
        this.f70492g = true;
        this.f70486a = bVar.f70495a;
        this.f70487b = bVar.f70496b;
        this.f70488c = bVar.f70497c;
        this.f70489d = bVar.f70498d;
        this.f70493h = bVar.f70499e;
        boolean unused = bVar.f70500f;
        int unused2 = bVar.f70501g;
        JSONObject unused3 = bVar.f70502h;
        this.f70494i = bVar.f70503i;
        this.f70490e = bVar.j;
        this.f70491f = bVar.k;
        this.f70492g = bVar.l;
    }

    @Override // d.o.a.a.a.c.b
    public void a(int i2) {
        this.f70487b = i2;
    }

    @Override // d.o.a.a.a.c.b
    public void b(int i2) {
        this.f70486a = i2;
    }

    @Override // d.o.a.a.a.c.b
    public void a(boolean z) {
        this.f70492g = z;
    }
}
