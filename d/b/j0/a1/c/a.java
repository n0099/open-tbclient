package d.b.j0.a1.c;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f52849f = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f52850a = 0;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Long> f52851b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f52852c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Long> f52853d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<Long> f52854e = new SparseArray<>();

    public static a d() {
        return f52849f;
    }

    public long a(int i) {
        Long l = this.f52852c.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long b() {
        return this.f52850a;
    }

    public long c(int i) {
        Long l = this.f52851b.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long e(int i) {
        Long l = this.f52854e.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long f(int i) {
        Long l = this.f52853d.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.f52852c.put(i, Long.valueOf(j));
    }

    public void h(long j) {
        this.f52850a = j;
    }

    public void i(long j, int i) {
        this.f52851b.put(i, Long.valueOf(j));
    }

    public void j(long j, int i) {
        this.f52854e.put(i, Long.valueOf(j));
    }

    public void k(long j, int i) {
        this.f52853d.put(i, Long.valueOf(j));
    }
}
