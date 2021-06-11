package d.a.l0.n.i.m;
/* loaded from: classes3.dex */
public class c extends g {

    /* renamed from: d  reason: collision with root package name */
    public String f51776d;

    /* renamed from: e  reason: collision with root package name */
    public long f51777e;

    /* renamed from: f  reason: collision with root package name */
    public String f51778f;

    /* renamed from: g  reason: collision with root package name */
    public long f51779g;

    /* renamed from: h  reason: collision with root package name */
    public String f51780h;

    /* renamed from: i  reason: collision with root package name */
    public String f51781i;
    public long j;
    public long k;

    public c(String str, int i2) {
        super(i2);
        this.f51777e = -1L;
        this.f51779g = -1L;
        this.j = -1L;
        this.k = 0L;
        this.f51776d = str;
    }

    public long f() {
        return this.f51779g;
    }

    public String g() {
        return this.f51776d;
    }

    public long h() {
        return this.j;
    }

    public String i() {
        return this.f51780h;
    }

    public String j() {
        return this.f51778f;
    }

    public String k() {
        return this.f51781i;
    }

    public long l() {
        return this.f51777e;
    }

    public long m() {
        return this.k;
    }

    public c n(long j) {
        this.f51779g = j;
        return this;
    }

    public c o(long j) {
        this.j = j;
        return this;
    }

    public c p(String str) {
        this.f51780h = str;
        return this;
    }

    public c q(String str) {
        this.f51778f = str;
        return this;
    }

    public c r(String str) {
        this.f51781i = str;
        return this;
    }

    public c s(long j) {
        this.f51777e = j;
        return this;
    }

    public void t(long j) {
        this.k = j;
    }
}
