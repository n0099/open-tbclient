package d.a.l0.a.r1.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48134a;

    /* renamed from: b  reason: collision with root package name */
    public long f48135b;

    /* renamed from: c  reason: collision with root package name */
    public long f48136c;

    /* renamed from: d  reason: collision with root package name */
    public int f48137d = 0;

    public String a() {
        return this.f48134a;
    }

    public int b() {
        return this.f48137d;
    }

    public long c() {
        return this.f48136c - this.f48135b;
    }

    public long d() {
        return this.f48136c;
    }

    public long e() {
        return this.f48135b;
    }

    public void f(String str) {
        this.f48134a = str;
    }

    public void g(int i2) {
        this.f48137d = i2;
    }

    public void h(long j) {
        this.f48136c = j;
    }

    public void i(long j) {
        this.f48135b = j;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.f48134a + "', mStart=" + this.f48135b + ", mEnd=" + this.f48136c + ", cost = " + (this.f48136c - this.f48135b) + "ms}";
    }
}
