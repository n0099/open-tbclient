package d.b.i0.u;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import d.b.i0.u.b;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: d  reason: collision with root package name */
    public double f61230d;

    /* renamed from: e  reason: collision with root package name */
    public double f61231e;

    /* renamed from: f  reason: collision with root package name */
    public double f61232f;

    /* renamed from: g  reason: collision with root package name */
    public double f61233g;

    /* renamed from: h  reason: collision with root package name */
    public double f61234h;
    public double i;

    /* renamed from: a  reason: collision with root package name */
    public double f61227a = Math.sqrt(1500.0d);

    /* renamed from: b  reason: collision with root package name */
    public double f61228b = 0.5d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61229c = false;
    public final b.i j = new b.i();

    public e(float f2) {
        this.i = Double.MAX_VALUE;
        this.i = f2;
    }

    public float a() {
        return (float) this.i;
    }

    public final void b() {
        if (this.f61229c) {
            return;
        }
        if (this.i != Double.MAX_VALUE) {
            double d2 = this.f61228b;
            if (d2 > 1.0d) {
                double d3 = this.f61227a;
                this.f61232f = ((-d2) * d3) + (d3 * Math.sqrt((d2 * d2) - 1.0d));
                double d4 = this.f61228b;
                double d5 = this.f61227a;
                this.f61233g = ((-d4) * d5) - (d5 * Math.sqrt((d4 * d4) - 1.0d));
            } else if (d2 >= 0.0d && d2 < 1.0d) {
                this.f61234h = this.f61227a * Math.sqrt(1.0d - (d2 * d2));
            }
            this.f61229c = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(float f2, float f3) {
        return ((double) Math.abs(f3)) < this.f61231e && ((double) Math.abs(f2 - a())) < this.f61230d;
    }

    public e d(@FloatRange(from = 0.0d) float f2) {
        if (f2 >= 0.0f) {
            this.f61228b = f2;
            this.f61229c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public e e(float f2) {
        this.i = f2;
        return this;
    }

    public e f(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        if (f2 > 0.0f) {
            this.f61227a = Math.sqrt(f2);
            this.f61229c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void g(double d2) {
        double abs = Math.abs(d2);
        this.f61230d = abs;
        this.f61231e = abs * 62.5d;
    }

    public b.i h(double d2, double d3, long j) {
        double cos;
        double d4;
        b();
        double d5 = j;
        Double.isNaN(d5);
        double d6 = d5 / 1000.0d;
        double d7 = d2 - this.i;
        double d8 = this.f61228b;
        if (d8 > 1.0d) {
            double d9 = this.f61233g;
            double d10 = this.f61232f;
            double d11 = d7 - (((d9 * d7) - d3) / (d9 - d10));
            double d12 = ((d7 * d9) - d3) / (d9 - d10);
            d4 = (Math.pow(2.718281828459045d, d9 * d6) * d11) + (Math.pow(2.718281828459045d, this.f61232f * d6) * d12);
            double d13 = this.f61233g;
            double pow = d11 * d13 * Math.pow(2.718281828459045d, d13 * d6);
            double d14 = this.f61232f;
            cos = pow + (d12 * d14 * Math.pow(2.718281828459045d, d14 * d6));
        } else if (d8 == 1.0d) {
            double d15 = this.f61227a;
            double d16 = d3 + (d15 * d7);
            double d17 = d7 + (d16 * d6);
            d4 = Math.pow(2.718281828459045d, (-d15) * d6) * d17;
            double pow2 = d17 * Math.pow(2.718281828459045d, (-this.f61227a) * d6);
            double d18 = this.f61227a;
            cos = (d16 * Math.pow(2.718281828459045d, (-d18) * d6)) + (pow2 * (-d18));
        } else {
            double d19 = 1.0d / this.f61234h;
            double d20 = this.f61227a;
            double d21 = d19 * ((d8 * d20 * d7) + d3);
            double pow3 = Math.pow(2.718281828459045d, (-d8) * d20 * d6) * ((Math.cos(this.f61234h * d6) * d7) + (Math.sin(this.f61234h * d6) * d21));
            double d22 = this.f61227a;
            double d23 = this.f61228b;
            double d24 = (-d22) * pow3 * d23;
            double pow4 = Math.pow(2.718281828459045d, (-d23) * d22 * d6);
            double d25 = this.f61234h;
            double sin = (-d25) * d7 * Math.sin(d25 * d6);
            double d26 = this.f61234h;
            cos = d24 + (pow4 * (sin + (d21 * d26 * Math.cos(d26 * d6))));
            d4 = pow3;
        }
        b.i iVar = this.j;
        iVar.f61225a = (float) (d4 + this.i);
        iVar.f61226b = (float) cos;
        return iVar;
    }
}
