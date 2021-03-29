package d.o.a.b.a.a;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements d.o.a.a.a.c.b {

    /* renamed from: a  reason: collision with root package name */
    public int f66391a;

    /* renamed from: b  reason: collision with root package name */
    public int f66392b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66393c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66394d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66395e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66396f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66397g;

    /* renamed from: h  reason: collision with root package name */
    public Object f66398h;
    public Object i;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f66399a;

        /* renamed from: b  reason: collision with root package name */
        public int f66400b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f66401c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66402d;

        /* renamed from: e  reason: collision with root package name */
        public Object f66403e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f66404f;

        /* renamed from: g  reason: collision with root package name */
        public int f66405g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f66406h;
        public Object i;
        public boolean k;
        public boolean j = true;
        public boolean l = true;

        public b b(int i) {
            this.f66399a = i;
            return this;
        }

        public b c(Object obj) {
            this.f66403e = obj;
            return this;
        }

        public b d(boolean z) {
            this.f66401c = z;
            return this;
        }

        public a e() {
            return new a(this);
        }

        public b g(int i) {
            this.f66400b = i;
            return this;
        }

        public b h(boolean z) {
            this.f66402d = z;
            return this;
        }

        @Deprecated
        public b i(boolean z) {
            return this;
        }

        public b k(boolean z) {
            this.f66404f = z;
            return this;
        }

        public b m(boolean z) {
            this.j = z;
            return this;
        }
    }

    @Override // d.o.a.a.a.c.b
    public int a() {
        return this.f66391a;
    }

    @Override // d.o.a.a.a.c.b
    public int b() {
        return this.f66392b;
    }

    @Override // d.o.a.a.a.c.b
    public boolean c() {
        return this.f66393c;
    }

    @Override // d.o.a.a.a.c.b
    public boolean d() {
        return this.f66394d;
    }

    @Override // d.o.a.a.a.c.b
    public boolean e() {
        return this.f66395e;
    }

    @Override // d.o.a.a.a.c.b
    public boolean f() {
        return this.f66396f;
    }

    @Override // d.o.a.a.a.c.b
    public boolean g() {
        return this.f66397g;
    }

    public a(b bVar) {
        this.f66395e = true;
        this.f66397g = true;
        this.f66391a = bVar.f66399a;
        this.f66392b = bVar.f66400b;
        this.f66393c = bVar.f66401c;
        this.f66394d = bVar.f66402d;
        this.f66398h = bVar.f66403e;
        boolean unused = bVar.f66404f;
        int unused2 = bVar.f66405g;
        JSONObject unused3 = bVar.f66406h;
        this.i = bVar.i;
        this.f66395e = bVar.j;
        this.f66396f = bVar.k;
        this.f66397g = bVar.l;
    }

    @Override // d.o.a.a.a.c.b
    public void a(int i) {
        this.f66392b = i;
    }

    @Override // d.o.a.a.a.c.b
    public void b(int i) {
        this.f66391a = i;
    }

    @Override // d.o.a.a.a.c.b
    public void a(boolean z) {
        this.f66397g = z;
    }
}
