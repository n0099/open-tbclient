package d.b.i0.i2;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f57005h = new b();

    /* renamed from: a  reason: collision with root package name */
    public long f57006a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f57007b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f57008c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f57009d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f57010e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f57011f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f57012g = 0;

    public static b d() {
        return f57005h;
    }

    public long a() {
        return this.f57010e;
    }

    public long b() {
        return this.f57006a;
    }

    public long c() {
        return this.f57009d;
    }

    public long e() {
        return this.f57007b;
    }

    public long f() {
        return this.f57008c;
    }

    public long g() {
        return this.f57012g;
    }

    public long h() {
        return this.f57011f;
    }

    public void i() {
        this.f57006a = 0L;
        this.f57007b = 0L;
        this.f57008c = 0L;
        this.f57009d = 0L;
        this.f57010e = 0L;
        this.f57011f = 0L;
        this.f57012g = 0L;
    }

    public void j(long j) {
        this.f57010e = j;
    }

    public void k(long j) {
        this.f57006a = j;
    }

    public void l(long j) {
        this.f57009d = j;
    }

    public void m(long j) {
        if (this.f57007b == 0) {
            this.f57007b = j;
        }
    }

    public void n(long j) {
        this.f57008c = j;
    }

    public void o(long j) {
        if (this.f57012g == 0) {
            this.f57012g = j;
        }
    }

    public void p(long j) {
        this.f57011f = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.f57010e);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.f57006a);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.f57012g);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.f57011f);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.f57009d);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.f57008c);
        return stringBuffer.toString();
    }
}
