package d.g.c.f;

import com.google.common.math.Stats;
import com.google.common.primitives.Doubles;
import java.util.Iterator;
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public long f66324a = 0;

    /* renamed from: b  reason: collision with root package name */
    public double f66325b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    public double f66326c = 0.0d;

    /* renamed from: d  reason: collision with root package name */
    public double f66327d = Double.NaN;

    /* renamed from: e  reason: collision with root package name */
    public double f66328e = Double.NaN;

    public static double g(double d2, double d3) {
        if (Doubles.f(d2)) {
            return d3;
        }
        if (Doubles.f(d3) || d2 == d3) {
            return d2;
        }
        return Double.NaN;
    }

    public void a(double d2) {
        long j = this.f66324a;
        if (j == 0) {
            this.f66324a = 1L;
            this.f66325b = d2;
            this.f66327d = d2;
            this.f66328e = d2;
            if (Doubles.f(d2)) {
                return;
            }
            this.f66326c = Double.NaN;
            return;
        }
        this.f66324a = j + 1;
        if (Doubles.f(d2) && Doubles.f(this.f66325b)) {
            double d3 = this.f66325b;
            double d4 = d2 - d3;
            double d5 = d3 + (d4 / this.f66324a);
            this.f66325b = d5;
            this.f66326c += d4 * (d2 - d5);
        } else {
            this.f66325b = g(this.f66325b, d2);
            this.f66326c = Double.NaN;
        }
        this.f66327d = Math.min(this.f66327d, d2);
        this.f66328e = Math.max(this.f66328e, d2);
    }

    public void b(Iterable<? extends Number> iterable) {
        for (Number number : iterable) {
            a(number.doubleValue());
        }
    }

    public void c(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            a(it.next().doubleValue());
        }
    }

    public void d(double... dArr) {
        for (double d2 : dArr) {
            a(d2);
        }
    }

    public void e(int... iArr) {
        for (int i2 : iArr) {
            a(i2);
        }
    }

    public void f(long... jArr) {
        for (long j : jArr) {
            a(j);
        }
    }

    public Stats h() {
        return new Stats(this.f66324a, this.f66325b, this.f66326c, this.f66327d, this.f66328e);
    }
}
