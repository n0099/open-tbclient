package d.b.j0.i2;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f57426h = new b();

    /* renamed from: a  reason: collision with root package name */
    public long f57427a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f57428b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f57429c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f57430d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f57431e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f57432f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f57433g = 0;

    public static b d() {
        return f57426h;
    }

    public long a() {
        return this.f57431e;
    }

    public long b() {
        return this.f57427a;
    }

    public long c() {
        return this.f57430d;
    }

    public long e() {
        return this.f57428b;
    }

    public long f() {
        return this.f57429c;
    }

    public long g() {
        return this.f57433g;
    }

    public long h() {
        return this.f57432f;
    }

    public void i() {
        this.f57427a = 0L;
        this.f57428b = 0L;
        this.f57429c = 0L;
        this.f57430d = 0L;
        this.f57431e = 0L;
        this.f57432f = 0L;
        this.f57433g = 0L;
    }

    public void j(long j) {
        this.f57431e = j;
    }

    public void k(long j) {
        this.f57427a = j;
    }

    public void l(long j) {
        this.f57430d = j;
    }

    public void m(long j) {
        if (this.f57428b == 0) {
            this.f57428b = j;
        }
    }

    public void n(long j) {
        this.f57429c = j;
    }

    public void o(long j) {
        if (this.f57433g == 0) {
            this.f57433g = j;
        }
    }

    public void p(long j) {
        this.f57432f = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.f57431e);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.f57427a);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.f57433g);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.f57432f);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.f57430d);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.f57429c);
        return stringBuffer.toString();
    }
}
