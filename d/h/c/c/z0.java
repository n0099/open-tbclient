package d.h.c.c;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public final class z0<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f67162a;

    /* renamed from: b  reason: collision with root package name */
    public final Comparator<? super T> f67163b;

    /* renamed from: c  reason: collision with root package name */
    public final T[] f67164c;

    /* renamed from: d  reason: collision with root package name */
    public int f67165d;

    /* renamed from: e  reason: collision with root package name */
    public T f67166e;

    public z0(Comparator<? super T> comparator, int i) {
        d.h.c.a.n.q(comparator, "comparator");
        this.f67163b = comparator;
        this.f67162a = i;
        d.h.c.a.n.f(i >= 0, "k must be nonnegative, was %s", i);
        this.f67164c = (T[]) new Object[i * 2];
        this.f67165d = 0;
        this.f67166e = null;
    }

    public static <T> z0<T> a(int i, Comparator<? super T> comparator) {
        return new z0<>(comparator, i);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: T, ? super T */
    public void b(T t) {
        int i = this.f67162a;
        if (i == 0) {
            return;
        }
        int i2 = this.f67165d;
        if (i2 == 0) {
            this.f67164c[0] = t;
            this.f67166e = t;
            this.f67165d = 1;
        } else if (i2 < i) {
            T[] tArr = this.f67164c;
            this.f67165d = i2 + 1;
            tArr[i2] = t;
            if (this.f67163b.compare(t, (T) this.f67166e) > 0) {
                this.f67166e = t;
            }
        } else if (this.f67163b.compare(t, (T) this.f67166e) < 0) {
            T[] tArr2 = this.f67164c;
            int i3 = this.f67165d;
            int i4 = i3 + 1;
            this.f67165d = i4;
            tArr2[i3] = t;
            if (i4 == this.f67162a * 2) {
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
        T[] tArr = this.f67164c;
        T t = tArr[i3];
        tArr[i3] = tArr[i2];
        int i4 = i;
        while (i < i2) {
            if (this.f67163b.compare((Object) this.f67164c[i], t) < 0) {
                e(i4, i);
                i4++;
            }
            i++;
        }
        T[] tArr2 = this.f67164c;
        tArr2[i2] = tArr2[i4];
        tArr2[i4] = t;
        return i4;
    }

    public final void e(int i, int i2) {
        T[] tArr = this.f67164c;
        T t = tArr[i];
        tArr[i] = tArr[i2];
        tArr[i2] = t;
    }

    public List<T> f() {
        Arrays.sort(this.f67164c, 0, this.f67165d, this.f67163b);
        int i = this.f67165d;
        int i2 = this.f67162a;
        if (i > i2) {
            T[] tArr = this.f67164c;
            Arrays.fill(tArr, i2, tArr.length, (Object) null);
            int i3 = this.f67162a;
            this.f67165d = i3;
            this.f67166e = this.f67164c[i3 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f67164c, this.f67165d)));
    }

    /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: T, ? super T */
    public final void g() {
        int i = (this.f67162a * 2) - 1;
        int d2 = d.h.c.f.c.d(i + 0, RoundingMode.CEILING) * 3;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 < i) {
                int d3 = d(i2, i, ((i2 + i) + 1) >>> 1);
                int i5 = this.f67162a;
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
                    Arrays.sort(this.f67164c, i2, i, this.f67163b);
                    break;
                }
            } else {
                break;
            }
        }
        this.f67165d = this.f67162a;
        this.f67166e = this.f67164c[i4];
        while (true) {
            i4++;
            if (i4 >= this.f67162a) {
                return;
            }
            if (this.f67163b.compare((Object) this.f67164c[i4], (T) this.f67166e) > 0) {
                this.f67166e = this.f67164c[i4];
            }
        }
    }
}
