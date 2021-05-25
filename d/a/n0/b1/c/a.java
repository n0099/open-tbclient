package d.a.n0.b1.c;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f51408f = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f51409a = 0;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Long> f51410b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f51411c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Long> f51412d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<Long> f51413e = new SparseArray<>();

    public static a d() {
        return f51408f;
    }

    public long a(int i2) {
        Long l = this.f51411c.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long b() {
        return this.f51409a;
    }

    public long c(int i2) {
        Long l = this.f51410b.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long e(int i2) {
        Long l = this.f51413e.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long f(int i2) {
        Long l = this.f51412d.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i2) {
        this.f51411c.put(i2, Long.valueOf(j));
    }

    public void h(long j) {
        this.f51409a = j;
    }

    public void i(long j, int i2) {
        this.f51410b.put(i2, Long.valueOf(j));
    }

    public void j(long j, int i2) {
        this.f51413e.put(i2, Long.valueOf(j));
    }

    public void k(long j, int i2) {
        this.f51412d.put(i2, Long.valueOf(j));
    }
}
