package d.a.k0.u;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import d.a.k0.u.b;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: d  reason: collision with root package name */
    public double f62021d;

    /* renamed from: e  reason: collision with root package name */
    public double f62022e;

    /* renamed from: f  reason: collision with root package name */
    public double f62023f;

    /* renamed from: g  reason: collision with root package name */
    public double f62024g;

    /* renamed from: h  reason: collision with root package name */
    public double f62025h;

    /* renamed from: i  reason: collision with root package name */
    public double f62026i;

    /* renamed from: a  reason: collision with root package name */
    public double f62018a = Math.sqrt(1500.0d);

    /* renamed from: b  reason: collision with root package name */
    public double f62019b = 0.5d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62020c = false;
    public final b.i j = new b.i();

    public e(float f2) {
        this.f62026i = Double.MAX_VALUE;
        this.f62026i = f2;
    }

    public float a() {
        return (float) this.f62026i;
    }

    public final void b() {
        if (this.f62020c) {
            return;
        }
        if (this.f62026i != Double.MAX_VALUE) {
            double d2 = this.f62019b;
            if (d2 > 1.0d) {
                double d3 = this.f62018a;
                this.f62023f = ((-d2) * d3) + (d3 * Math.sqrt((d2 * d2) - 1.0d));
                double d4 = this.f62019b;
                double d5 = this.f62018a;
                this.f62024g = ((-d4) * d5) - (d5 * Math.sqrt((d4 * d4) - 1.0d));
            } else if (d2 >= 0.0d && d2 < 1.0d) {
                this.f62025h = this.f62018a * Math.sqrt(1.0d - (d2 * d2));
            }
            this.f62020c = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(float f2, float f3) {
        return ((double) Math.abs(f3)) < this.f62022e && ((double) Math.abs(f2 - a())) < this.f62021d;
    }

    public e d(@FloatRange(from = 0.0d) float f2) {
        if (f2 >= 0.0f) {
            this.f62019b = f2;
            this.f62020c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public e e(float f2) {
        this.f62026i = f2;
        return this;
    }

    public e f(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        if (f2 > 0.0f) {
            this.f62018a = Math.sqrt(f2);
            this.f62020c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void g(double d2) {
        double abs = Math.abs(d2);
        this.f62021d = abs;
        this.f62022e = abs * 62.5d;
    }

    public b.i h(double d2, double d3, long j) {
        double cos;
        double d4;
        b();
        double d5 = j / 1000.0d;
        double d6 = d2 - this.f62026i;
        double d7 = this.f62019b;
        if (d7 > 1.0d) {
            double d8 = this.f62024g;
            double d9 = this.f62023f;
            double d10 = d6 - (((d8 * d6) - d3) / (d8 - d9));
            double d11 = ((d6 * d8) - d3) / (d8 - d9);
            d4 = (Math.pow(2.718281828459045d, d8 * d5) * d10) + (Math.pow(2.718281828459045d, this.f62023f * d5) * d11);
            double d12 = this.f62024g;
            double pow = d10 * d12 * Math.pow(2.718281828459045d, d12 * d5);
            double d13 = this.f62023f;
            cos = pow + (d11 * d13 * Math.pow(2.718281828459045d, d13 * d5));
        } else if (d7 == 1.0d) {
            double d14 = this.f62018a;
            double d15 = d3 + (d14 * d6);
            double d16 = d6 + (d15 * d5);
            d4 = Math.pow(2.718281828459045d, (-d14) * d5) * d16;
            double pow2 = d16 * Math.pow(2.718281828459045d, (-this.f62018a) * d5);
            double d17 = this.f62018a;
            cos = (d15 * Math.pow(2.718281828459045d, (-d17) * d5)) + (pow2 * (-d17));
        } else {
            double d18 = 1.0d / this.f62025h;
            double d19 = this.f62018a;
            double d20 = d18 * ((d7 * d19 * d6) + d3);
            double pow3 = Math.pow(2.718281828459045d, (-d7) * d19 * d5) * ((Math.cos(this.f62025h * d5) * d6) + (Math.sin(this.f62025h * d5) * d20));
            double d21 = this.f62018a;
            double d22 = this.f62019b;
            double d23 = (-d21) * pow3 * d22;
            double pow4 = Math.pow(2.718281828459045d, (-d22) * d21 * d5);
            double d24 = this.f62025h;
            double sin = (-d24) * d6 * Math.sin(d24 * d5);
            double d25 = this.f62025h;
            cos = d23 + (pow4 * (sin + (d20 * d25 * Math.cos(d25 * d5))));
            d4 = pow3;
        }
        b.i iVar = this.j;
        iVar.f62016a = (float) (d4 + this.f62026i);
        iVar.f62017b = (float) cos;
        return iVar;
    }
}
