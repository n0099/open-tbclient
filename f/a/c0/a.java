package f.a.c0;

import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f67453a;

    /* renamed from: b  reason: collision with root package name */
    public final long f67454b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f67455c;

    public a(T t, long j, TimeUnit timeUnit) {
        this.f67453a = t;
        this.f67454b = j;
        f.a.x.b.a.b(timeUnit, "unit is null");
        this.f67455c = timeUnit;
    }

    public long a() {
        return this.f67454b;
    }

    public T b() {
        return this.f67453a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.a.x.b.a.a(this.f67453a, aVar.f67453a) && this.f67454b == aVar.f67454b && f.a.x.b.a.a(this.f67455c, aVar.f67455c);
        }
        return false;
    }

    public int hashCode() {
        T t = this.f67453a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.f67454b;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.f67455c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f67454b + ", unit=" + this.f67455c + ", value=" + this.f67453a + "]";
    }
}
