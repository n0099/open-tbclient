package d.a.j0.a1.c;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f50546f = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f50547a = 0;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Long> f50548b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f50549c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Long> f50550d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<Long> f50551e = new SparseArray<>();

    public static a d() {
        return f50546f;
    }

    public long a(int i2) {
        Long l = this.f50549c.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long b() {
        return this.f50547a;
    }

    public long c(int i2) {
        Long l = this.f50548b.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long e(int i2) {
        Long l = this.f50551e.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long f(int i2) {
        Long l = this.f50550d.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i2) {
        this.f50549c.put(i2, Long.valueOf(j));
    }

    public void h(long j) {
        this.f50547a = j;
    }

    public void i(long j, int i2) {
        this.f50548b.put(i2, Long.valueOf(j));
    }

    public void j(long j, int i2) {
        this.f50551e.put(i2, Long.valueOf(j));
    }

    public void k(long j, int i2) {
        this.f50550d.put(i2, Long.valueOf(j));
    }
}
