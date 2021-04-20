package f.b.c0;

import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f68459a;

    /* renamed from: b  reason: collision with root package name */
    public final long f68460b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f68461c;

    public a(T t, long j, TimeUnit timeUnit) {
        this.f68459a = t;
        this.f68460b = j;
        f.b.x.b.a.b(timeUnit, "unit is null");
        this.f68461c = timeUnit;
    }

    public long a() {
        return this.f68460b;
    }

    public T b() {
        return this.f68459a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.b.x.b.a.a(this.f68459a, aVar.f68459a) && this.f68460b == aVar.f68460b && f.b.x.b.a.a(this.f68461c, aVar.f68461c);
        }
        return false;
    }

    public int hashCode() {
        T t = this.f68459a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.f68460b;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.f68461c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f68460b + ", unit=" + this.f68461c + ", value=" + this.f68459a + "]";
    }
}
