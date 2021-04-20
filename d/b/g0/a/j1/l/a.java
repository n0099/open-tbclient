package d.b.g0.a.j1.l;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f45296a;

    /* renamed from: b  reason: collision with root package name */
    public long f45297b;

    /* renamed from: c  reason: collision with root package name */
    public long f45298c;

    public String a() {
        return this.f45296a;
    }

    public long b() {
        return this.f45298c - this.f45297b;
    }

    public long c() {
        return this.f45298c;
    }

    public long d() {
        return this.f45297b;
    }

    public void e(String str) {
        this.f45296a = str;
    }

    public void f(long j) {
        this.f45298c = j;
    }

    public void g(long j) {
        this.f45297b = j;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.f45296a + "', mStart=" + this.f45297b + ", mEnd=" + this.f45298c + '}';
    }
}
