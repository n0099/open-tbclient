package d.a.o0.j2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f60071h = new b();

    /* renamed from: a  reason: collision with root package name */
    public long f60072a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f60073b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f60074c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f60075d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f60076e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f60077f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f60078g = 0;

    public static b d() {
        return f60071h;
    }

    public long a() {
        return this.f60076e;
    }

    public long b() {
        return this.f60072a;
    }

    public long c() {
        return this.f60075d;
    }

    public long e() {
        return this.f60073b;
    }

    public long f() {
        return this.f60074c;
    }

    public long g() {
        return this.f60078g;
    }

    public long h() {
        return this.f60077f;
    }

    public void i() {
        this.f60072a = 0L;
        this.f60073b = 0L;
        this.f60074c = 0L;
        this.f60075d = 0L;
        this.f60076e = 0L;
        this.f60077f = 0L;
        this.f60078g = 0L;
    }

    public void j(long j) {
        this.f60076e = j;
    }

    public void k(long j) {
        this.f60072a = j;
    }

    public void l(long j) {
        this.f60075d = j;
    }

    public void m(long j) {
        if (this.f60073b == 0) {
            this.f60073b = j;
        }
    }

    public void n(long j) {
        this.f60074c = j;
    }

    public void o(long j) {
        if (this.f60078g == 0) {
            this.f60078g = j;
        }
    }

    public void p(long j) {
        this.f60077f = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.f60076e);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.f60072a);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.f60078g);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.f60077f);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.f60075d);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.f60074c);
        return stringBuffer.toString();
    }
}
