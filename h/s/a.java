package h.s;
/* loaded from: classes8.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final long f72006a;

    /* renamed from: b  reason: collision with root package name */
    public final T f72007b;

    public a(long j, T t) {
        this.f72007b = t;
        this.f72006a = j;
    }

    public long a() {
        return this.f72006a;
    }

    public T b() {
        return this.f72007b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.f72006a == aVar.f72006a) {
                T t = this.f72007b;
                T t2 = aVar.f72007b;
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
        long j = this.f72006a;
        int i2 = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.f72007b;
        return i2 + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f72006a), this.f72007b.toString());
    }
}
