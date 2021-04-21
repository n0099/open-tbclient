package h.s;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final long f69163a;

    /* renamed from: b  reason: collision with root package name */
    public final T f69164b;

    public a(long j, T t) {
        this.f69164b = t;
        this.f69163a = j;
    }

    public long a() {
        return this.f69163a;
    }

    public T b() {
        return this.f69164b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.f69163a == aVar.f69163a) {
                T t = this.f69164b;
                T t2 = aVar.f69164b;
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
        long j = this.f69163a;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.f69164b;
        return i + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f69163a), this.f69164b.toString());
    }
}
