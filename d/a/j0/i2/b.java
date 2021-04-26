package d.a.j0.i2;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f55366h = new b();

    /* renamed from: a  reason: collision with root package name */
    public long f55367a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f55368b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f55369c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f55370d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f55371e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f55372f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f55373g = 0;

    public static b d() {
        return f55366h;
    }

    public long a() {
        return this.f55371e;
    }

    public long b() {
        return this.f55367a;
    }

    public long c() {
        return this.f55370d;
    }

    public long e() {
        return this.f55368b;
    }

    public long f() {
        return this.f55369c;
    }

    public long g() {
        return this.f55373g;
    }

    public long h() {
        return this.f55372f;
    }

    public void i() {
        this.f55367a = 0L;
        this.f55368b = 0L;
        this.f55369c = 0L;
        this.f55370d = 0L;
        this.f55371e = 0L;
        this.f55372f = 0L;
        this.f55373g = 0L;
    }

    public void j(long j) {
        this.f55371e = j;
    }

    public void k(long j) {
        this.f55367a = j;
    }

    public void l(long j) {
        this.f55370d = j;
    }

    public void m(long j) {
        if (this.f55368b == 0) {
            this.f55368b = j;
        }
    }

    public void n(long j) {
        this.f55369c = j;
    }

    public void o(long j) {
        if (this.f55373g == 0) {
            this.f55373g = j;
        }
    }

    public void p(long j) {
        this.f55372f = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.f55371e);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.f55367a);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.f55373g);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.f55372f);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.f55370d);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.f55369c);
        return stringBuffer.toString();
    }
}
