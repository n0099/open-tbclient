package h.s;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final long f68001a;

    /* renamed from: b  reason: collision with root package name */
    public final T f68002b;

    public a(long j, T t) {
        this.f68002b = t;
        this.f68001a = j;
    }

    public long a() {
        return this.f68001a;
    }

    public T b() {
        return this.f68002b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.f68001a == aVar.f68001a) {
                T t = this.f68002b;
                T t2 = aVar.f68002b;
                if (t == t2) {
                    return true;
                }
                if (t != null && t.equals(t2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f68001a;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.f68002b;
        return i + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f68001a), this.f68002b.toString());
    }
}
