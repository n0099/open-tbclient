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
    public final int f66264a;

    /* renamed from: b  reason: collision with root package name */
    public final Comparator<? super T> f66265b;

    /* renamed from: c  reason: collision with root package name */
    public final T[] f66266c;

    /* renamed from: d  reason: collision with root package name */
    public int f66267d;

    /* renamed from: e  reason: collision with root package name */
    public T f66268e;

    public z0(Comparator<? super T> comparator, int i2) {
        d.g.c.a.n.q(comparator, "comparator");
        this.f66265b = comparator;
        this.f66264a = i2;
        d.g.c.a.n.f(i2 >= 0, "k must be nonnegative, was %s", i2);
        this.f66266c = (T[]) new Object[i2 * 2];
        this.f66267d = 0;
        this.f66268e = null;
    }

    public static <T> z0<T> a(int i2, Comparator<? super T> comparator) {
        return new z0<>(comparator, i2);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: T, ? super T */
    public void b(T t) {
        int i2 = this.f66264a;
        if (i2 == 0) {
            return;
        }
        int i3 = this.f66267d;
        if (i3 == 0) {
            this.f66266c[0] = t;
            this.f66268e = t;
            this.f66267d = 1;
        } else if (i3 < i2) {
            T[] tArr = this.f66266c;
            this.f66267d = i3 + 1;
            tArr[i3] = t;
            if (this.f66265b.compare(t, (T) this.f66268e) > 0) {
                this.f66268e = t;
            }
        } else if (this.f66265b.compare(t, (T) this.f66268e) < 0) {
            T[] tArr2 = this.f66266c;
            int i4 = this.f66267d;
            int i5 = i4 + 1;
            this.f66267d = i5;
            tArr2[i4] = t;
            if (i5 == this.f66264a * 2) {
                g();
            }
        }
    }

    public void c(Iterator<? extends T> it) {
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public final int d(int i2, int i3, int i4) {
        T[] tArr = this.f66266c;
        T t = tArr[i4];
        tArr[i4] = tArr[i3];
        int i5 = i2;
        while (i2 < i3) {
            if (this.f66265b.compare((Object) this.f66266c[i2], t) < 0) {
                e(i5, i2);
                i5++;
            }
            i2++;
        }
        T[] tArr2 = this.f66266c;
        tArr2[i3] = tArr2[i5];
        tArr2[i5] = t;
        return i5;
    }

    public final void e(int i2, int i3) {
        T[] tArr = this.f66266c;
        T t = tArr[i2];
        tArr[i2] = tArr[i3];
        tArr[i3] = t;
    }

    public List<T> f() {
        Arrays.sort(this.f66266c, 0, this.f66267d, this.f66265b);
        int i2 = this.f66267d;
        int i3 = this.f66264a;
        if (i2 > i3) {
            T[] tArr = this.f66266c;
            Arrays.fill(tArr, i3, tArr.length, (Object) null);
            int i4 = this.f66264a;
            this.f66267d = i4;
            this.f66268e = this.f66266c[i4 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f66266c, this.f66267d)));
    }

    /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: T, ? super T */
    public final void g() {
        int i2 = (this.f66264a * 2) - 1;
        int d2 = d.g.c.f.c.d(i2 + 0, RoundingMode.CEILING) * 3;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 < i2) {
                int d3 = d(i3, i2, ((i3 + i2) + 1) >>> 1);
                int i6 = this.f66264a;
                if (d3 <= i6) {
                    if (d3 >= i6) {
                        break;
                    }
                    i3 = Math.max(d3, i3 + 1);
                    i5 = d3;
                } else {
                    i2 = d3 - 1;
                }
                i4++;
                if (i4 >= d2) {
                    Arrays.sort(this.f66266c, i3, i2, this.f66265b);
                    break;
                }
            } else {
                break;
            }
        }
        this.f66267d = this.f66264a;
        this.f66268e = this.f66266c[i5];
        while (true) {
            i5++;
            if (i5 >= this.f66264a) {
                return;
            }
            if (this.f66265b.compare((Object) this.f66266c[i5], (T) this.f66268e) > 0) {
                this.f66268e = this.f66266c[i5];
            }
        }
    }
}
