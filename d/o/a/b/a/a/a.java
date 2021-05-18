package d.o.a.b.a.a;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements d.o.a.a.a.c.b {

    /* renamed from: a  reason: collision with root package name */
    public int f66553a;

    /* renamed from: b  reason: collision with root package name */
    public int f66554b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66555c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66556d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66557e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66558f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66559g;

    /* renamed from: h  reason: collision with root package name */
    public Object f66560h;

    /* renamed from: i  reason: collision with root package name */
    public Object f66561i;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f66562a;

        /* renamed from: b  reason: collision with root package name */
        public int f66563b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f66564c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f66565d;

        /* renamed from: e  reason: collision with root package name */
        public Object f66566e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f66567f;

        /* renamed from: g  reason: collision with root package name */
        public int f66568g;

        /* renamed from: h  reason: collision with root package name */
        public JSONObject f66569h;

        /* renamed from: i  reason: collision with root package name */
        public Object f66570i;
        public boolean k;
        public boolean j = true;
        public boolean l = true;

        public b b(int i2) {
            this.f66562a = i2;
            return this;
        }

        public b c(Object obj) {
            this.f66566e = obj;
            return this;
        }

        public b d(boolean z) {
            this.f66564c = z;
            return this;
        }

        public a e() {
            return new a(this);
        }

        public b g(int i2) {
            this.f66563b = i2;
            return this;
        }

        public b h(boolean z) {
            this.f66565d = z;
            return this;
        }

        @Deprecated
        public b i(boolean z) {
            return this;
        }

        public b k(boolean z) {
            this.f66567f = z;
            return this;
        }

        public b m(boolean z) {
            this.j = z;
            return this;
        }
    }

    @Override // d.o.a.a.a.c.b
    public int a() {
        return this.f66553a;
    }

    @Override // d.o.a.a.a.c.b
    public int b() {
        return this.f66554b;
    }

    @Override // d.o.a.a.a.c.b
    public boolean c() {
        return this.f66555c;
    }

    @Override // d.o.a.a.a.c.b
    public boolean d() {
        return this.f66556d;
    }

    @Override // d.o.a.a.a.c.b
    public boolean e() {
        return this.f66557e;
    }

    @Override // d.o.a.a.a.c.b
    public boolean f() {
        return this.f66558f;
    }

    @Override // d.o.a.a.a.c.b
    public boolean g() {
        return this.f66559g;
    }

    public a(b bVar) {
        this.f66557e = true;
        this.f66559g = true;
        this.f66553a = bVar.f66562a;
        this.f66554b = bVar.f66563b;
        this.f66555c = bVar.f66564c;
        this.f66556d = bVar.f66565d;
        this.f66560h = bVar.f66566e;
        boolean unused = bVar.f66567f;
        int unused2 = bVar.f66568g;
        JSONObject unused3 = bVar.f66569h;
        this.f66561i = bVar.f66570i;
        this.f66557e = bVar.j;
        this.f66558f = bVar.k;
        this.f66559g = bVar.l;
    }

    @Override // d.o.a.a.a.c.b
    public void a(int i2) {
        this.f66554b = i2;
    }

    @Override // d.o.a.a.a.c.b
    public void b(int i2) {
        this.f66553a = i2;
    }

    @Override // d.o.a.a.a.c.b
    public void a(boolean z) {
        this.f66559g = z;
    }
}
