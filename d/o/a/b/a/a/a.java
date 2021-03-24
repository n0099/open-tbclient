package d.o.a.b.a.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements d.o.a.a.a.c.b {

    /* renamed from: a  reason: collision with root package name */
    public int f66390a;

    /* renamed from: b  reason: collision with root package name */
    public int f66391b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66392c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66393d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66394e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66395f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66396g;

    /* renamed from: h  reason: collision with root package name */
    public Object f66397h;
    public Object i;

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f66398a;

        /* renamed from: b  reason: collision with root package name */
        public int f66399b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f66400c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66401d;

        /* renamed from: e  reason: collision with root package name */
        public Object f66402e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f66403f;

        /* renamed from: g  reason: collision with root package name */
        public int f66404g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f66405h;
        public Object i;
        public boolean k;
        public boolean j = true;
        public boolean l = true;

        public b b(int i) {
            this.f66398a = i;
            return this;
        }

        public b c(Object obj) {
            this.f66402e = obj;
            return this;
        }

        public b d(boolean z) {
            this.f66400c = z;
            return this;
        }

        public a e() {
            return new a(this);
        }

        public b g(int i) {
            this.f66399b = i;
            return this;
        }

        public b h(boolean z) {
            this.f66401d = z;
            return this;
        }

        @Deprecated
        public b i(boolean z) {
            return this;
        }

        public b k(boolean z) {
            this.f66403f = z;
            return this;
        }

        public b m(boolean z) {
            this.j = z;
            return this;
        }
    }

    @Override // d.o.a.a.a.c.b
    public int a() {
        return this.f66390a;
    }

    @Override // d.o.a.a.a.c.b
    public int b() {
        return this.f66391b;
    }

    @Override // d.o.a.a.a.c.b
    public boolean c() {
        return this.f66392c;
    }

    @Override // d.o.a.a.a.c.b
    public boolean d() {
        return this.f66393d;
    }

    @Override // d.o.a.a.a.c.b
    public boolean e() {
        return this.f66394e;
    }

    @Override // d.o.a.a.a.c.b
    public boolean f() {
        return this.f66395f;
    }

    @Override // d.o.a.a.a.c.b
    public boolean g() {
        return this.f66396g;
    }

    public a(b bVar) {
        this.f66394e = true;
        this.f66396g = true;
        this.f66390a = bVar.f66398a;
        this.f66391b = bVar.f66399b;
        this.f66392c = bVar.f66400c;
        this.f66393d = bVar.f66401d;
        this.f66397h = bVar.f66402e;
        boolean unused = bVar.f66403f;
        int unused2 = bVar.f66404g;
        JSONObject unused3 = bVar.f66405h;
        this.i = bVar.i;
        this.f66394e = bVar.j;
        this.f66395f = bVar.k;
        this.f66396g = bVar.l;
    }

    @Override // d.o.a.a.a.c.b
    public void a(int i) {
        this.f66391b = i;
    }

    @Override // d.o.a.a.a.c.b
    public void b(int i) {
        this.f66390a = i;
    }

    @Override // d.o.a.a.a.c.b
    public void a(boolean z) {
        this.f66396g = z;
    }
}
