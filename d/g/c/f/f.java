package d.g.c.f;

import com.google.common.math.Stats;
import com.google.common.primitives.Doubles;
import java.util.Iterator;
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public long f70055a = 0;

    /* renamed from: b  reason: collision with root package name */
    public double f70056b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    public double f70057c = 0.0d;

    /* renamed from: d  reason: collision with root package name */
    public double f70058d = Double.NaN;

    /* renamed from: e  reason: collision with root package name */
    public double f70059e = Double.NaN;

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
        long j = this.f70055a;
        if (j == 0) {
            this.f70055a = 1L;
            this.f70056b = d2;
            this.f70058d = d2;
            this.f70059e = d2;
            if (Doubles.f(d2)) {
                return;
            }
            this.f70057c = Double.NaN;
            return;
        }
        this.f70055a = j + 1;
        if (Doubles.f(d2) && Doubles.f(this.f70056b)) {
            double d3 = this.f70056b;
            double d4 = d2 - d3;
            double d5 = d3 + (d4 / this.f70055a);
            this.f70056b = d5;
            this.f70057c += d4 * (d2 - d5);
        } else {
            this.f70056b = g(this.f70056b, d2);
            this.f70057c = Double.NaN;
        }
        this.f70058d = Math.min(this.f70058d, d2);
        this.f70059e = Math.max(this.f70059e, d2);
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
        return new Stats(this.f70055a, this.f70056b, this.f70057c, this.f70058d, this.f70059e);
    }
}
