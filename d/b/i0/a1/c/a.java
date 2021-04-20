package d.b.i0.a1.c;

import android.util.SparseArray;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static a f52428f = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f52429a = 0;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<Long> f52430b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f52431c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<Long> f52432d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<Long> f52433e = new SparseArray<>();

    public static a d() {
        return f52428f;
    }

    public long a(int i) {
        Long l = this.f52431c.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long b() {
        return this.f52429a;
    }

    public long c(int i) {
        Long l = this.f52430b.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long e(int i) {
        Long l = this.f52433e.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public long f(int i) {
        Long l = this.f52432d.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void g(long j, int i) {
        this.f52431c.put(i, Long.valueOf(j));
    }

    public void h(long j) {
        this.f52429a = j;
    }

    public void i(long j, int i) {
        this.f52430b.put(i, Long.valueOf(j));
    }

    public void j(long j, int i) {
        this.f52433e.put(i, Long.valueOf(j));
    }

    public void k(long j, int i) {
        this.f52432d.put(i, Long.valueOf(j));
    }
}
