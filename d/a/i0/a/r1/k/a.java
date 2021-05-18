package d.a.i0.a.r1.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f44284a;

    /* renamed from: b  reason: collision with root package name */
    public long f44285b;

    /* renamed from: c  reason: collision with root package name */
    public long f44286c;

    /* renamed from: d  reason: collision with root package name */
    public int f44287d = 0;

    public String a() {
        return this.f44284a;
    }

    public int b() {
        return this.f44287d;
    }

    public long c() {
        return this.f44286c - this.f44285b;
    }

    public long d() {
        return this.f44286c;
    }

    public long e() {
        return this.f44285b;
    }

    public void f(String str) {
        this.f44284a = str;
    }

    public void g(int i2) {
        this.f44287d = i2;
    }

    public void h(long j) {
        this.f44286c = j;
    }

    public void i(long j) {
        this.f44285b = j;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.f44284a + "', mStart=" + this.f44285b + ", mEnd=" + this.f44286c + ", cost = " + (this.f44286c - this.f44285b) + "ms}";
    }
}
