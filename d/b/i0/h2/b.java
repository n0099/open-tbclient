package d.b.i0.h2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f55147h = new b();

    /* renamed from: a  reason: collision with root package name */
    public long f55148a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f55149b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f55150c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f55151d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f55152e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f55153f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f55154g = 0;

    public static b d() {
        return f55147h;
    }

    public long a() {
        return this.f55152e;
    }

    public long b() {
        return this.f55148a;
    }

    public long c() {
        return this.f55151d;
    }

    public long e() {
        return this.f55149b;
    }

    public long f() {
        return this.f55150c;
    }

    public long g() {
        return this.f55154g;
    }

    public long h() {
        return this.f55153f;
    }

    public void i() {
        this.f55148a = 0L;
        this.f55149b = 0L;
        this.f55150c = 0L;
        this.f55151d = 0L;
        this.f55152e = 0L;
        this.f55153f = 0L;
        this.f55154g = 0L;
    }

    public void j(long j) {
        this.f55152e = j;
    }

    public void k(long j) {
        this.f55148a = j;
    }

    public void l(long j) {
        this.f55151d = j;
    }

    public void m(long j) {
        if (this.f55149b == 0) {
            this.f55149b = j;
        }
    }

    public void n(long j) {
        this.f55150c = j;
    }

    public void o(long j) {
        if (this.f55154g == 0) {
            this.f55154g = j;
        }
    }

    public void p(long j) {
        this.f55153f = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.f55152e);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.f55148a);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.f55154g);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.f55153f);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.f55151d);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.f55150c);
        return stringBuffer.toString();
    }
}
