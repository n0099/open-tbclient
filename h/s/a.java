package h.s;
/* loaded from: classes8.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final long f72110a;

    /* renamed from: b  reason: collision with root package name */
    public final T f72111b;

    public a(long j, T t) {
        this.f72111b = t;
        this.f72110a = j;
    }

    public long a() {
        return this.f72110a;
    }

    public T b() {
        return this.f72111b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.f72110a == aVar.f72110a) {
                T t = this.f72111b;
                T t2 = aVar.f72111b;
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
        long j = this.f72110a;
        int i2 = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.f72111b;
        return i2 + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f72110a), this.f72111b.toString());
    }
}
