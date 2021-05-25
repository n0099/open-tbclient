package d.a.l0.n.i.m;
/* loaded from: classes3.dex */
public class c extends g {

    /* renamed from: d  reason: collision with root package name */
    public String f48102d;

    /* renamed from: e  reason: collision with root package name */
    public long f48103e;

    /* renamed from: f  reason: collision with root package name */
    public String f48104f;

    /* renamed from: g  reason: collision with root package name */
    public long f48105g;

    /* renamed from: h  reason: collision with root package name */
    public String f48106h;

    /* renamed from: i  reason: collision with root package name */
    public String f48107i;
    public long j;
    public long k;

    public c(String str, int i2) {
        super(i2);
        this.f48103e = -1L;
        this.f48105g = -1L;
        this.j = -1L;
        this.k = 0L;
        this.f48102d = str;
    }

    public long f() {
        return this.f48105g;
    }

    public String g() {
        return this.f48102d;
    }

    public long h() {
        return this.j;
    }

    public String i() {
        return this.f48106h;
    }

    public String j() {
        return this.f48104f;
    }

    public String k() {
        return this.f48107i;
    }

    public long l() {
        return this.f48103e;
    }

    public long m() {
        return this.k;
    }

    public c n(long j) {
        this.f48105g = j;
        return this;
    }

    public c o(long j) {
        this.j = j;
        return this;
    }

    public c p(String str) {
        this.f48106h = str;
        return this;
    }

    public c q(String str) {
        this.f48104f = str;
        return this;
    }

    public c r(String str) {
        this.f48107i = str;
        return this;
    }

    public c s(long j) {
        this.f48103e = j;
        return this;
    }

    public void t(long j) {
        this.k = j;
    }
}
