package d.a.k0.a1.c;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f51243f = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f51244a = 0;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Long> f51245b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f51246c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Long> f51247d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<Long> f51248e = new SparseArray<>();

    public static a d() {
        return f51243f;
    }

    public long a(int i2) {
        Long l = this.f51246c.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long b() {
        return this.f51244a;
    }

    public long c(int i2) {
        Long l = this.f51245b.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long e(int i2) {
        Long l = this.f51248e.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long f(int i2) {
        Long l = this.f51247d.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i2) {
        this.f51246c.put(i2, Long.valueOf(j));
    }

    public void h(long j) {
        this.f51244a = j;
    }

    public void i(long j, int i2) {
        this.f51245b.put(i2, Long.valueOf(j));
    }

    public void j(long j, int i2) {
        this.f51248e.put(i2, Long.valueOf(j));
    }

    public void k(long j, int i2) {
        this.f51247d.put(i2, Long.valueOf(j));
    }
}
