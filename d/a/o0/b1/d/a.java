package d.a.o0.b1.d;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f55216f = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f55217a = 0;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Long> f55218b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f55219c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Long> f55220d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<Long> f55221e = new SparseArray<>();

    public static a d() {
        return f55216f;
    }

    public long a(int i2) {
        Long l = this.f55219c.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long b() {
        return this.f55217a;
    }

    public long c(int i2) {
        Long l = this.f55218b.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long e(int i2) {
        Long l = this.f55221e.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long f(int i2) {
        Long l = this.f55220d.get(i2);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i2) {
        this.f55219c.put(i2, Long.valueOf(j));
    }

    public void h(long j) {
        this.f55217a = j;
    }

    public void i(long j, int i2) {
        this.f55218b.put(i2, Long.valueOf(j));
    }

    public void j(long j, int i2) {
        this.f55221e.put(i2, Long.valueOf(j));
    }

    public void k(long j, int i2) {
        this.f55220d.put(i2, Long.valueOf(j));
    }
}
