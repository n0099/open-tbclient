package d.b.i0.u;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import d.b.i0.u.b;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: d  reason: collision with root package name */
    public double f61231d;

    /* renamed from: e  reason: collision with root package name */
    public double f61232e;

    /* renamed from: f  reason: collision with root package name */
    public double f61233f;

    /* renamed from: g  reason: collision with root package name */
    public double f61234g;

    /* renamed from: h  reason: collision with root package name */
    public double f61235h;
    public double i;

    /* renamed from: a  reason: collision with root package name */
    public double f61228a = Math.sqrt(1500.0d);

    /* renamed from: b  reason: collision with root package name */
    public double f61229b = 0.5d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61230c = false;
    public final b.i j = new b.i();

    public e(float f2) {
        this.i = Double.MAX_VALUE;
        this.i = f2;
    }

    public float a() {
        return (float) this.i;
    }

    public final void b() {
        if (this.f61230c) {
            return;
        }
        if (this.i != Double.MAX_VALUE) {
            double d2 = this.f61229b;
            if (d2 > 1.0d) {
                double d3 = this.f61228a;
                this.f61233f = ((-d2) * d3) + (d3 * Math.sqrt((d2 * d2) - 1.0d));
                double d4 = this.f61229b;
                double d5 = this.f61228a;
                this.f61234g = ((-d4) * d5) - (d5 * Math.sqrt((d4 * d4) - 1.0d));
            } else if (d2 >= 0.0d && d2 < 1.0d) {
                this.f61235h = this.f61228a * Math.sqrt(1.0d - (d2 * d2));
            }
            this.f61230c = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(float f2, float f3) {
        return ((double) Math.abs(f3)) < this.f61232e && ((double) Math.abs(f2 - a())) < this.f61231d;
    }

    public e d(@FloatRange(from = 0.0d) float f2) {
        if (f2 >= 0.0f) {
            this.f61229b = f2;
            this.f61230c = false;
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
            this.f61228a = Math.sqrt(f2);
            this.f61230c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void g(double d2) {
        double abs = Math.abs(d2);
        this.f61231d = abs;
        this.f61232e = abs * 62.5d;
    }

    public b.i h(double d2, double d3, long j) {
        double cos;
        double d4;
        b();
        double d5 = j / 1000.0d;
        double d6 = d2 - this.i;
        double d7 = this.f61229b;
        if (d7 > 1.0d) {
            double d8 = this.f61234g;
            double d9 = this.f61233f;
            double d10 = d6 - (((d8 * d6) - d3) / (d8 - d9));
            double d11 = ((d6 * d8) - d3) / (d8 - d9);
            d4 = (Math.pow(2.718281828459045d, d8 * d5) * d10) + (Math.pow(2.718281828459045d, this.f61233f * d5) * d11);
            double d12 = this.f61234g;
            double pow = d10 * d12 * Math.pow(2.718281828459045d, d12 * d5);
            double d13 = this.f61233f;
            cos = pow + (d11 * d13 * Math.pow(2.718281828459045d, d13 * d5));
        } else if (d7 == 1.0d) {
            double d14 = this.f61228a;
            double d15 = d3 + (d14 * d6);
            double d16 = d6 + (d15 * d5);
            d4 = Math.pow(2.718281828459045d, (-d14) * d5) * d16;
            double pow2 = d16 * Math.pow(2.718281828459045d, (-this.f61228a) * d5);
            double d17 = this.f61228a;
            cos = (d15 * Math.pow(2.718281828459045d, (-d17) * d5)) + (pow2 * (-d17));
        } else {
            double d18 = 1.0d / this.f61235h;
            double d19 = this.f61228a;
            double d20 = d18 * ((d7 * d19 * d6) + d3);
            double pow3 = Math.pow(2.718281828459045d, (-d7) * d19 * d5) * ((Math.cos(this.f61235h * d5) * d6) + (Math.sin(this.f61235h * d5) * d20));
            double d21 = this.f61228a;
            double d22 = this.f61229b;
            double d23 = (-d21) * pow3 * d22;
            double pow4 = Math.pow(2.718281828459045d, (-d22) * d21 * d5);
            double d24 = this.f61235h;
            double sin = (-d24) * d6 * Math.sin(d24 * d5);
            double d25 = this.f61235h;
            cos = d23 + (pow4 * (sin + (d20 * d25 * Math.cos(d25 * d5))));
            d4 = pow3;
        }
        b.i iVar = this.j;
        iVar.f61226a = (float) (d4 + this.i);
        iVar.f61227b = (float) cos;
        return iVar;
    }
}
