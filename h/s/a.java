package h.s;
/* loaded from: classes7.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final long f68006a;

    /* renamed from: b  reason: collision with root package name */
    public final T f68007b;

    public a(long j, T t) {
        this.f68007b = t;
        this.f68006a = j;
    }

    public long a() {
        return this.f68006a;
    }

    public T b() {
        return this.f68007b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (this.f68006a == aVar.f68006a) {
                T t = this.f68007b;
                T t2 = aVar.f68007b;
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
        long j = this.f68006a;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.f68007b;
        return i + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f68006a), this.f68007b.toString());
    }
}
