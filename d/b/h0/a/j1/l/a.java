package d.b.h0.a.j1.l;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f45625a;

    /* renamed from: b  reason: collision with root package name */
    public long f45626b;

    /* renamed from: c  reason: collision with root package name */
    public long f45627c;

    public String a() {
        return this.f45625a;
    }

    public long b() {
        return this.f45627c - this.f45626b;
    }

    public long c() {
        return this.f45627c;
    }

    public long d() {
        return this.f45626b;
    }

    public void e(String str) {
        this.f45625a = str;
    }

    public void f(long j) {
        this.f45627c = j;
    }

    public void g(long j) {
        this.f45626b = j;
    }

    public String toString() {
        return "ApiCalledInfo{mApiName='" + this.f45625a + "', mStart=" + this.f45626b + ", mEnd=" + this.f45627c + '}';
    }
}
