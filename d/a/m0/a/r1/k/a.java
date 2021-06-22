package d.a.m0.a.r1.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48242a;

    /* renamed from: b  reason: collision with root package name */
    public long f48243b;

    /* renamed from: c  reason: collision with root package name */
    public long f48244c;

    /* renamed from: d  reason: collision with root package name */
    public int f48245d = 0;

    public String a() {
        return this.f48242a;
    }

    public int b() {
        return this.f48245d;
    }

    public long c() {
        return this.f48244c - this.f48243b;
    }

    public long d() {
        return this.f48244c;
    }

    public long e() {
        return this.f48243b;
    }

    public void f(String str) {
        this.f48242a = str;
    }

    public void g(int i2) {
        this.f48245d = i2;
    }

    public void h(long j) {
        this.f48244c = j;
    }

    public void i(long j) {
        this.f48243b = j;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.f48242a + "', mStart=" + this.f48243b + ", mEnd=" + this.f48244c + ", cost = " + (this.f48244c - this.f48243b) + "ms}";
    }
}
