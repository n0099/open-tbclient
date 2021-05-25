package d.a.l0.a.r1.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f44460a;

    /* renamed from: b  reason: collision with root package name */
    public long f44461b;

    /* renamed from: c  reason: collision with root package name */
    public long f44462c;

    /* renamed from: d  reason: collision with root package name */
    public int f44463d = 0;

    public String a() {
        return this.f44460a;
    }

    public int b() {
        return this.f44463d;
    }

    public long c() {
        return this.f44462c - this.f44461b;
    }

    public long d() {
        return this.f44462c;
    }

    public long e() {
        return this.f44461b;
    }

    public void f(String str) {
        this.f44460a = str;
    }

    public void g(int i2) {
        this.f44463d = i2;
    }

    public void h(long j) {
        this.f44462c = j;
    }

    public void i(long j) {
        this.f44461b = j;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.f44460a + "', mStart=" + this.f44461b + ", mEnd=" + this.f44462c + ", cost = " + (this.f44462c - this.f44461b) + "ms}";
    }
}
