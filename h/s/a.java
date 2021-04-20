package h.s;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final long f69016a;

    /* renamed from: b  reason: collision with root package name */
    public final T f69017b;

    public a(long j, T t) {
        this.f69017b = t;
        this.f69016a = j;
    }

    public long a() {
        return this.f69016a;
    }

    public T b() {
        return this.f69017b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.f69016a == aVar.f69016a) {
                T t = this.f69017b;
                T t2 = aVar.f69017b;
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
        long j = this.f69016a;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.f69017b;
        return i + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f69016a), this.f69017b.toString());
    }
}
