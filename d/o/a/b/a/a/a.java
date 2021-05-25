package d.o.a.b.a.a;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements d.o.a.a.a.c.b {

    /* renamed from: a  reason: collision with root package name */
    public int f66596a;

    /* renamed from: b  reason: collision with root package name */
    public int f66597b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66598c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66599d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66600e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66601f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66602g;

    /* renamed from: h  reason: collision with root package name */
    public Object f66603h;

    /* renamed from: i  reason: collision with root package name */
    public Object f66604i;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f66605a;

        /* renamed from: b  reason: collision with root package name */
        public int f66606b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f66607c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66608d;

        /* renamed from: e  reason: collision with root package name */
        public Object f66609e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f66610f;

        /* renamed from: g  reason: collision with root package name */
        public int f66611g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f66612h;

        /* renamed from: i  reason: collision with root package name */
        public Object f66613i;
        public boolean k;
        public boolean j = true;
        public boolean l = true;

        public b b(int i2) {
            this.f66605a = i2;
            return this;
        }

        public b c(Object obj) {
            this.f66609e = obj;
            return this;
        }

        public b d(boolean z) {
            this.f66607c = z;
            return this;
        }

        public a e() {
            return new a(this);
        }

        public b g(int i2) {
            this.f66606b = i2;
            return this;
        }

        public b h(boolean z) {
            this.f66608d = z;
            return this;
        }

        @Deprecated
        public b i(boolean z) {
            return this;
        }

        public b k(boolean z) {
            this.f66610f = z;
            return this;
        }

        public b m(boolean z) {
            this.j = z;
            return this;
        }
    }

    @Override // d.o.a.a.a.c.b
    public int a() {
        return this.f66596a;
    }

    @Override // d.o.a.a.a.c.b
    public int b() {
        return this.f66597b;
    }

    @Override // d.o.a.a.a.c.b
    public boolean c() {
        return this.f66598c;
    }

    @Override // d.o.a.a.a.c.b
    public boolean d() {
        return this.f66599d;
    }

    @Override // d.o.a.a.a.c.b
    public boolean e() {
        return this.f66600e;
    }

    @Override // d.o.a.a.a.c.b
    public boolean f() {
        return this.f66601f;
    }

    @Override // d.o.a.a.a.c.b
    public boolean g() {
        return this.f66602g;
    }

    public a(b bVar) {
        this.f66600e = true;
        this.f66602g = true;
        this.f66596a = bVar.f66605a;
        this.f66597b = bVar.f66606b;
        this.f66598c = bVar.f66607c;
        this.f66599d = bVar.f66608d;
        this.f66603h = bVar.f66609e;
        boolean unused = bVar.f66610f;
        int unused2 = bVar.f66611g;
        JSONObject unused3 = bVar.f66612h;
        this.f66604i = bVar.f66613i;
        this.f66600e = bVar.j;
        this.f66601f = bVar.k;
        this.f66602g = bVar.l;
    }

    @Override // d.o.a.a.a.c.b
    public void a(int i2) {
        this.f66597b = i2;
    }

    @Override // d.o.a.a.a.c.b
    public void b(int i2) {
        this.f66596a = i2;
    }

    @Override // d.o.a.a.a.c.b
    public void a(boolean z) {
        this.f66602g = z;
    }
}
