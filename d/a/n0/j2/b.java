package d.a.n0.j2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f56257h = new b();

    /* renamed from: a  reason: collision with root package name */
    public long f56258a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f56259b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f56260c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f56261d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f56262e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f56263f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f56264g = 0;

    public static b d() {
        return f56257h;
    }

    public long a() {
        return this.f56262e;
    }

    public long b() {
        return this.f56258a;
    }

    public long c() {
        return this.f56261d;
    }

    public long e() {
        return this.f56259b;
    }

    public long f() {
        return this.f56260c;
    }

    public long g() {
        return this.f56264g;
    }

    public long h() {
        return this.f56263f;
    }

    public void i() {
        this.f56258a = 0L;
        this.f56259b = 0L;
        this.f56260c = 0L;
        this.f56261d = 0L;
        this.f56262e = 0L;
        this.f56263f = 0L;
        this.f56264g = 0L;
    }

    public void j(long j) {
        this.f56262e = j;
    }

    public void k(long j) {
        this.f56258a = j;
    }

    public void l(long j) {
        this.f56261d = j;
    }

    public void m(long j) {
        if (this.f56259b == 0) {
            this.f56259b = j;
        }
    }

    public void n(long j) {
        this.f56260c = j;
    }

    public void o(long j) {
        if (this.f56264g == 0) {
            this.f56264g = j;
        }
    }

    public void p(long j) {
        this.f56263f = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.f56262e);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.f56258a);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.f56264g);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.f56263f);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.f56261d);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.f56260c);
        return stringBuffer.toString();
    }
}
