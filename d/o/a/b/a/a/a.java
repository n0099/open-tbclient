package d.o.a.b.a.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements d.o.a.a.a.c.b {

    /* renamed from: a  reason: collision with root package name */
    public int f65867a;

    /* renamed from: b  reason: collision with root package name */
    public int f65868b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65869c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65870d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65871e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65872f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65873g;

    /* renamed from: h  reason: collision with root package name */
    public Object f65874h;

    /* renamed from: i  reason: collision with root package name */
    public Object f65875i;

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f65876a;

        /* renamed from: b  reason: collision with root package name */
        public int f65877b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65878c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f65879d;

        /* renamed from: e  reason: collision with root package name */
        public Object f65880e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65881f;

        /* renamed from: g  reason: collision with root package name */
        public int f65882g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f65883h;

        /* renamed from: i  reason: collision with root package name */
        public Object f65884i;
        public boolean k;
        public boolean j = true;
        public boolean l = true;

        public b b(int i2) {
            this.f65876a = i2;
            return this;
        }

        public b c(Object obj) {
            this.f65880e = obj;
            return this;
        }

        public b d(boolean z) {
            this.f65878c = z;
            return this;
        }

        public a e() {
            return new a(this);
        }

        public b g(int i2) {
            this.f65877b = i2;
            return this;
        }

        public b h(boolean z) {
            this.f65879d = z;
            return this;
        }

        @Deprecated
        public b i(boolean z) {
            return this;
        }

        public b k(boolean z) {
            this.f65881f = z;
            return this;
        }

        public b m(boolean z) {
            this.j = z;
            return this;
        }
    }

    @Override // d.o.a.a.a.c.b
    public int a() {
        return this.f65867a;
    }

    @Override // d.o.a.a.a.c.b
    public int b() {
        return this.f65868b;
    }

    @Override // d.o.a.a.a.c.b
    public boolean c() {
        return this.f65869c;
    }

    @Override // d.o.a.a.a.c.b
    public boolean d() {
        return this.f65870d;
    }

    @Override // d.o.a.a.a.c.b
    public boolean e() {
        return this.f65871e;
    }

    @Override // d.o.a.a.a.c.b
    public boolean f() {
        return this.f65872f;
    }

    @Override // d.o.a.a.a.c.b
    public boolean g() {
        return this.f65873g;
    }

    public a(b bVar) {
        this.f65871e = true;
        this.f65873g = true;
        this.f65867a = bVar.f65876a;
        this.f65868b = bVar.f65877b;
        this.f65869c = bVar.f65878c;
        this.f65870d = bVar.f65879d;
        this.f65874h = bVar.f65880e;
        boolean unused = bVar.f65881f;
        int unused2 = bVar.f65882g;
        JSONObject unused3 = bVar.f65883h;
        this.f65875i = bVar.f65884i;
        this.f65871e = bVar.j;
        this.f65872f = bVar.k;
        this.f65873g = bVar.l;
    }

    @Override // d.o.a.a.a.c.b
    public void a(int i2) {
        this.f65868b = i2;
    }

    @Override // d.o.a.a.a.c.b
    public void b(int i2) {
        this.f65867a = i2;
    }

    @Override // d.o.a.a.a.c.b
    public void a(boolean z) {
        this.f65873g = z;
    }
}
