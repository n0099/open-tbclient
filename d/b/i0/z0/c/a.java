package d.b.i0.z0.c;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f62809f = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f62810a = 0;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Long> f62811b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f62812c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Long> f62813d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<Long> f62814e = new SparseArray<>();

    public static a d() {
        return f62809f;
    }

    public long a(int i) {
        Long l = this.f62812c.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long b() {
        return this.f62810a;
    }

    public long c(int i) {
        Long l = this.f62811b.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long e(int i) {
        Long l = this.f62814e.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long f(int i) {
        Long l = this.f62813d.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.f62812c.put(i, Long.valueOf(j));
    }

    public void h(long j) {
        this.f62810a = j;
    }

    public void i(long j, int i) {
        this.f62811b.put(i, Long.valueOf(j));
    }

    public void j(long j, int i) {
        this.f62814e.put(i, Long.valueOf(j));
    }

    public void k(long j, int i) {
        this.f62813d.put(i, Long.valueOf(j));
    }
}
