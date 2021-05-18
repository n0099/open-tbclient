package d.a.k0.i2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f56073h = new b();

    /* renamed from: a  reason: collision with root package name */
    public long f56074a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f56075b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f56076c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f56077d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f56078e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f56079f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f56080g = 0;

    public static b d() {
        return f56073h;
    }

    public long a() {
        return this.f56078e;
    }

    public long b() {
        return this.f56074a;
    }

    public long c() {
        return this.f56077d;
    }

    public long e() {
        return this.f56075b;
    }

    public long f() {
        return this.f56076c;
    }

    public long g() {
        return this.f56080g;
    }

    public long h() {
        return this.f56079f;
    }

    public void i() {
        this.f56074a = 0L;
        this.f56075b = 0L;
        this.f56076c = 0L;
        this.f56077d = 0L;
        this.f56078e = 0L;
        this.f56079f = 0L;
        this.f56080g = 0L;
    }

    public void j(long j) {
        this.f56078e = j;
    }

    public void k(long j) {
        this.f56074a = j;
    }

    public void l(long j) {
        this.f56077d = j;
    }

    public void m(long j) {
        if (this.f56075b == 0) {
            this.f56075b = j;
        }
    }

    public void n(long j) {
        this.f56076c = j;
    }

    public void o(long j) {
        if (this.f56080g == 0) {
            this.f56080g = j;
        }
    }

    public void p(long j) {
        this.f56079f = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.f56078e);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.f56074a);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.f56080g);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.f56079f);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.f56077d);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.f56076c);
        return stringBuffer.toString();
    }
}
