package d.a.h0.a.j1.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f42948a;

    /* renamed from: b  reason: collision with root package name */
    public long f42949b;

    /* renamed from: c  reason: collision with root package name */
    public long f42950c;

    public String a() {
        return this.f42948a;
    }

    public long b() {
        return this.f42950c - this.f42949b;
    }

    public long c() {
        return this.f42950c;
    }

    public long d() {
        return this.f42949b;
    }

    public void e(String str) {
        this.f42948a = str;
    }

    public void f(long j) {
        this.f42950c = j;
    }

    public void g(long j) {
        this.f42949b = j;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.f42948a + "', mStart=" + this.f42949b + ", mEnd=" + this.f42950c + '}';
    }
}
