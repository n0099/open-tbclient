package f.b.c0;

import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f68606a;

    /* renamed from: b  reason: collision with root package name */
    public final long f68607b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f68608c;

    public a(T t, long j, TimeUnit timeUnit) {
        this.f68606a = t;
        this.f68607b = j;
        f.b.x.b.a.b(timeUnit, "unit is null");
        this.f68608c = timeUnit;
    }

    public long a() {
        return this.f68607b;
    }

    public T b() {
        return this.f68606a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.b.x.b.a.a(this.f68606a, aVar.f68606a) && this.f68607b == aVar.f68607b && f.b.x.b.a.a(this.f68608c, aVar.f68608c);
        }
        return false;
    }

    public int hashCode() {
        T t = this.f68606a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.f68607b;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.f68608c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f68607b + ", unit=" + this.f68608c + ", value=" + this.f68606a + "]";
    }
}
