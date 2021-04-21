package d.h.c.f;

import com.google.common.math.Stats;
import com.google.common.primitives.Doubles;
import java.util.Iterator;
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public long f67179a = 0;

    /* renamed from: b  reason: collision with root package name */
    public double f67180b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    public double f67181c = 0.0d;

    /* renamed from: d  reason: collision with root package name */
    public double f67182d = Double.NaN;

    /* renamed from: e  reason: collision with root package name */
    public double f67183e = Double.NaN;

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
        long j = this.f67179a;
        if (j == 0) {
            this.f67179a = 1L;
            this.f67180b = d2;
            this.f67182d = d2;
            this.f67183e = d2;
            if (Doubles.f(d2)) {
                return;
            }
            this.f67181c = Double.NaN;
            return;
        }
        this.f67179a = j + 1;
        if (Doubles.f(d2) && Doubles.f(this.f67180b)) {
            double d3 = this.f67180b;
            double d4 = d2 - d3;
            double d5 = d3 + (d4 / this.f67179a);
            this.f67180b = d5;
            this.f67181c += d4 * (d2 - d5);
        } else {
            this.f67180b = g(this.f67180b, d2);
            this.f67181c = Double.NaN;
        }
        this.f67182d = Math.min(this.f67182d, d2);
        this.f67183e = Math.max(this.f67183e, d2);
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
        return new Stats(this.f67179a, this.f67180b, this.f67181c, this.f67182d, this.f67183e);
    }
}
