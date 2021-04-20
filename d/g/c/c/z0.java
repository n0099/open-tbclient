package d.g.c.c;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public final class z0<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f67015a;

    /* renamed from: b  reason: collision with root package name */
    public final Comparator<? super T> f67016b;

    /* renamed from: c  reason: collision with root package name */
    public final T[] f67017c;

    /* renamed from: d  reason: collision with root package name */
    public int f67018d;

    /* renamed from: e  reason: collision with root package name */
    public T f67019e;

    public z0(Comparator<? super T> comparator, int i) {
        d.g.c.a.n.q(comparator, "comparator");
        this.f67016b = comparator;
        this.f67015a = i;
        d.g.c.a.n.f(i >= 0, "k must be nonnegative, was %s", i);
        this.f67017c = (T[]) new Object[i * 2];
        this.f67018d = 0;
        this.f67019e = null;
    }

    public static <T> z0<T> a(int i, Comparator<? super T> comparator) {
        return new z0<>(comparator, i);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: T, ? super T */
    public void b(T t) {
        int i = this.f67015a;
        if (i == 0) {
            return;
        }
        int i2 = this.f67018d;
        if (i2 == 0) {
            this.f67017c[0] = t;
            this.f67019e = t;
            this.f67018d = 1;
        } else if (i2 < i) {
            T[] tArr = this.f67017c;
            this.f67018d = i2 + 1;
            tArr[i2] = t;
            if (this.f67016b.compare(t, (T) this.f67019e) > 0) {
                this.f67019e = t;
            }
        } else if (this.f67016b.compare(t, (T) this.f67019e) < 0) {
            T[] tArr2 = this.f67017c;
            int i3 = this.f67018d;
            int i4 = i3 + 1;
            this.f67018d = i4;
            tArr2[i3] = t;
            if (i4 == this.f67015a * 2) {
                g();
            }
        }
    }

    public void c(Iterator<? extends T> it) {
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public final int d(int i, int i2, int i3) {
        T[] tArr = this.f67017c;
        T t = tArr[i3];
        tArr[i3] = tArr[i2];
        int i4 = i;
        while (i < i2) {
            if (this.f67016b.compare((Object) this.f67017c[i], t) < 0) {
                e(i4, i);
                i4++;
            }
            i++;
        }
        T[] tArr2 = this.f67017c;
        tArr2[i2] = tArr2[i4];
        tArr2[i4] = t;
        return i4;
    }

    public final void e(int i, int i2) {
        T[] tArr = this.f67017c;
        T t = tArr[i];
        tArr[i] = tArr[i2];
        tArr[i2] = t;
    }

    public List<T> f() {
        Arrays.sort(this.f67017c, 0, this.f67018d, this.f67016b);
        int i = this.f67018d;
        int i2 = this.f67015a;
        if (i > i2) {
            T[] tArr = this.f67017c;
            Arrays.fill(tArr, i2, tArr.length, (Object) null);
            int i3 = this.f67015a;
            this.f67018d = i3;
            this.f67019e = this.f67017c[i3 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f67017c, this.f67018d)));
    }

    /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: T, ? super T */
    public final void g() {
        int i = (this.f67015a * 2) - 1;
        int d2 = d.g.c.f.c.d(i + 0, RoundingMode.CEILING) * 3;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 < i) {
                int d3 = d(i2, i, ((i2 + i) + 1) >>> 1);
                int i5 = this.f67015a;
                if (d3 <= i5) {
                    if (d3 >= i5) {
                        break;
                    }
                    i2 = Math.max(d3, i2 + 1);
                    i4 = d3;
                } else {
                    i = d3 - 1;
                }
                i3++;
                if (i3 >= d2) {
                    Arrays.sort(this.f67017c, i2, i, this.f67016b);
                    break;
                }
            } else {
                break;
            }
        }
        this.f67018d = this.f67015a;
        this.f67019e = this.f67017c[i4];
        while (true) {
            i4++;
            if (i4 >= this.f67015a) {
                return;
            }
            if (this.f67016b.compare((Object) this.f67017c[i4], (T) this.f67019e) > 0) {
                this.f67019e = this.f67017c[i4];
            }
        }
    }
}
