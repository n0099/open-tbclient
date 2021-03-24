package f.a.c0;

import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f67448a;

    /* renamed from: b  reason: collision with root package name */
    public final long f67449b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f67450c;

    public a(T t, long j, TimeUnit timeUnit) {
        this.f67448a = t;
        this.f67449b = j;
        f.a.x.b.a.b(timeUnit, "unit is null");
        this.f67450c = timeUnit;
    }

    public long a() {
        return this.f67449b;
    }

    public T b() {
        return this.f67448a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.a.x.b.a.a(this.f67448a, aVar.f67448a) && this.f67449b == aVar.f67449b && f.a.x.b.a.a(this.f67450c, aVar.f67450c);
        }
        return false;
    }

    public int hashCode() {
        T t = this.f67448a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.f67449b;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.f67450c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f67449b + ", unit=" + this.f67450c + ", value=" + this.f67448a + "]";
    }
}
