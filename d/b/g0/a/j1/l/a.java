package d.b.g0.a.j1.l;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f44904a;

    /* renamed from: b  reason: collision with root package name */
    public long f44905b;

    /* renamed from: c  reason: collision with root package name */
    public long f44906c;

    public String a() {
        return this.f44904a;
    }

    public long b() {
        return this.f44906c - this.f44905b;
    }

    public long c() {
        return this.f44906c;
    }

    public long d() {
        return this.f44905b;
    }

    public void e(String str) {
        this.f44904a = str;
    }

    public void f(long j) {
        this.f44906c = j;
    }

    public void g(long j) {
        this.f44905b = j;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.f44904a + "', mStart=" + this.f44905b + ", mEnd=" + this.f44906c + '}';
    }
}
