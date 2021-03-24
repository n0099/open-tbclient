package d.b.i0.h2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f55146h = new b();

    /* renamed from: a  reason: collision with root package name */
    public long f55147a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f55148b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f55149c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f55150d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f55151e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f55152f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f55153g = 0;

    public static b d() {
        return f55146h;
    }

    public long a() {
        return this.f55151e;
    }

    public long b() {
        return this.f55147a;
    }

    public long c() {
        return this.f55150d;
    }

    public long e() {
        return this.f55148b;
    }

    public long f() {
        return this.f55149c;
    }

    public long g() {
        return this.f55153g;
    }

    public long h() {
        return this.f55152f;
    }

    public void i() {
        this.f55147a = 0L;
        this.f55148b = 0L;
        this.f55149c = 0L;
        this.f55150d = 0L;
        this.f55151e = 0L;
        this.f55152f = 0L;
        this.f55153g = 0L;
    }

    public void j(long j) {
        this.f55151e = j;
    }

    public void k(long j) {
        this.f55147a = j;
    }

    public void l(long j) {
        this.f55150d = j;
    }

    public void m(long j) {
        if (this.f55148b == 0) {
            this.f55148b = j;
        }
    }

    public void n(long j) {
        this.f55149c = j;
    }

    public void o(long j) {
        if (this.f55153g == 0) {
            this.f55153g = j;
        }
    }

    public void p(long j) {
        this.f55152f = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.f55151e);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.f55147a);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.f55153g);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.f55152f);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.f55150d);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.f55149c);
        return stringBuffer.toString();
    }
}
