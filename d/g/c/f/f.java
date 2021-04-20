package d.g.c.f;

import com.google.common.math.Stats;
import com.google.common.primitives.Doubles;
import java.util.Iterator;
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public long f67032a = 0;

    /* renamed from: b  reason: collision with root package name */
    public double f67033b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    public double f67034c = 0.0d;

    /* renamed from: d  reason: collision with root package name */
    public double f67035d = Double.NaN;

    /* renamed from: e  reason: collision with root package name */
    public double f67036e = Double.NaN;

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
        long j = this.f67032a;
        if (j == 0) {
            this.f67032a = 1L;
            this.f67033b = d2;
            this.f67035d = d2;
            this.f67036e = d2;
            if (Doubles.f(d2)) {
                return;
            }
            this.f67034c = Double.NaN;
            return;
        }
        this.f67032a = j + 1;
        if (Doubles.f(d2) && Doubles.f(this.f67033b)) {
            double d3 = this.f67033b;
            double d4 = d2 - d3;
            double d5 = d3 + (d4 / this.f67032a);
            this.f67033b = d5;
            this.f67034c += d4 * (d2 - d5);
        } else {
            this.f67033b = g(this.f67033b, d2);
            this.f67034c = Double.NaN;
        }
        this.f67035d = Math.min(this.f67035d, d2);
        this.f67036e = Math.max(this.f67036e, d2);
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
        for (int i : iArr) {
            a(i);
        }
    }

    public void f(long... jArr) {
        for (long j : jArr) {
            a(j);
        }
    }

    public Stats h() {
        return new Stats(this.f67032a, this.f67033b, this.f67034c, this.f67035d, this.f67036e);
    }
}
