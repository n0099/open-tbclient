package d.a.n0.j2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static b f59946h = new b();

    /* renamed from: a  reason: collision with root package name */
    public long f59947a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f59948b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f59949c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f59950d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f59951e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f59952f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f59953g = 0;

    public static b d() {
        return f59946h;
    }

    public long a() {
        return this.f59951e;
    }

    public long b() {
        return this.f59947a;
    }

    public long c() {
        return this.f59950d;
    }

    public long e() {
        return this.f59948b;
    }

    public long f() {
        return this.f59949c;
    }

    public long g() {
        return this.f59953g;
    }

    public long h() {
        return this.f59952f;
    }

    public void i() {
        this.f59947a = 0L;
        this.f59948b = 0L;
        this.f59949c = 0L;
        this.f59950d = 0L;
        this.f59951e = 0L;
        this.f59952f = 0L;
        this.f59953g = 0L;
    }

    public void j(long j) {
        this.f59951e = j;
    }

    public void k(long j) {
        this.f59947a = j;
    }

    public void l(long j) {
        this.f59950d = j;
    }

    public void m(long j) {
        if (this.f59948b == 0) {
            this.f59948b = j;
        }
    }

    public void n(long j) {
        this.f59949c = j;
    }

    public void o(long j) {
        if (this.f59953g == 0) {
            this.f59953g = j;
        }
    }

    public void p(long j) {
        this.f59952f = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.f59951e);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.f59947a);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.f59953g);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.f59952f);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.f59950d);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.f59949c);
        return stringBuffer.toString();
    }
}
