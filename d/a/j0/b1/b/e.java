package d.a.j0.b1.b;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static float f51473f = 8.0f;

    /* renamed from: g  reason: collision with root package name */
    public static float f51474g = 1.0f / n(1.0f);

    /* renamed from: a  reason: collision with root package name */
    public int f51475a;

    /* renamed from: b  reason: collision with root package name */
    public final a f51476b;

    /* renamed from: c  reason: collision with root package name */
    public final a f51477c;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f51478d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f51479e;

    /* loaded from: classes4.dex */
    public static class a {
        public static float p = (float) (Math.log(0.78d) / Math.log(0.9d));
        public static final float[] q = new float[101];
        public static final float[] r = new float[101];

        /* renamed from: a  reason: collision with root package name */
        public int f51480a;

        /* renamed from: b  reason: collision with root package name */
        public int f51481b;

        /* renamed from: c  reason: collision with root package name */
        public int f51482c;

        /* renamed from: d  reason: collision with root package name */
        public int f51483d;

        /* renamed from: e  reason: collision with root package name */
        public float f51484e;

        /* renamed from: f  reason: collision with root package name */
        public float f51485f;

        /* renamed from: g  reason: collision with root package name */
        public long f51486g;

        /* renamed from: h  reason: collision with root package name */
        public int f51487h;

        /* renamed from: i  reason: collision with root package name */
        public int f51488i;
        public int j;
        public int l;
        public float o;
        public float m = ViewConfiguration.getScrollFriction();
        public int n = 0;
        public boolean k = true;

        static {
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12 = 0.0f;
            float f13 = 0.0f;
            for (int i2 = 0; i2 < 100; i2++) {
                float f14 = i2 / 100.0f;
                float f15 = 1.0f;
                while (true) {
                    f2 = 2.0f;
                    f3 = ((f15 - f12) / 2.0f) + f12;
                    f4 = 3.0f;
                    f5 = 1.0f - f3;
                    f6 = f3 * 3.0f * f5;
                    f7 = f3 * f3 * f3;
                    float f16 = (((f5 * 0.175f) + (f3 * 0.35000002f)) * f6) + f7;
                    if (Math.abs(f16 - f14) < 1.0E-5d) {
                        break;
                    } else if (f16 > f14) {
                        f15 = f3;
                    } else {
                        f12 = f3;
                    }
                }
                q[i2] = (f6 * ((f5 * 0.5f) + f3)) + f7;
                float f17 = 1.0f;
                while (true) {
                    f8 = ((f17 - f13) / f2) + f13;
                    f9 = 1.0f - f8;
                    f10 = f8 * f4 * f9;
                    f11 = f8 * f8 * f8;
                    float f18 = (((f9 * 0.5f) + f8) * f10) + f11;
                    if (Math.abs(f18 - f14) < 1.0E-5d) {
                        break;
                    }
                    if (f18 > f14) {
                        f17 = f8;
                    } else {
                        f13 = f8;
                    }
                    f2 = 2.0f;
                    f4 = 3.0f;
                }
                r[i2] = (f10 * ((f9 * 0.175f) + (f8 * 0.35000002f))) + f11;
            }
            float[] fArr = q;
            r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        public a(Context context) {
            this.o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        public static float m(int i2) {
            return i2 > 0 ? -2000.0f : 2000.0f;
        }

        public final void h(int i2, int i3, int i4) {
            float abs = Math.abs((i4 - i2) / (i3 - i2));
            int i5 = (int) (abs * 100.0f);
            if (i5 < 100) {
                float f2 = i5 / 100.0f;
                int i6 = i5 + 1;
                float[] fArr = r;
                float f3 = fArr[i5];
                this.f51487h = (int) (this.f51487h * (f3 + (((abs - f2) / ((i6 / 100.0f) - f2)) * (fArr[i6] - f3))));
            }
        }

        public boolean i() {
            int i2 = this.n;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                if (i2 == 2) {
                    this.f51486g += this.f51487h;
                    x(this.f51482c, this.f51480a, 0);
                }
            } else if (this.f51487h >= this.f51488i) {
                return false;
            } else {
                this.f51480a = this.f51482c;
                int i3 = (int) this.f51484e;
                this.f51483d = i3;
                this.f51485f = m(i3);
                this.f51486g += this.f51487h;
                r();
            }
            y();
            return true;
        }

        public void j() {
            this.f51481b = this.f51482c;
            this.k = true;
        }

        public final void k(int i2, int i3, int i4) {
            float f2 = this.f51485f;
            float sqrt = (float) Math.sqrt((((((i4 * i4) / 2.0f) / Math.abs(f2)) + Math.abs(i3 - i2)) * 2.0d) / Math.abs(this.f51485f));
            this.f51486g -= (int) ((sqrt - ((-i4) / f2)) * 1000.0f);
            this.f51480a = i3;
            this.f51483d = (int) ((-this.f51485f) * sqrt);
        }

        public void l(int i2, int i3, int i4, int i5, int i6) {
            float f2;
            this.l = i6;
            this.k = false;
            this.f51483d = i3;
            this.f51484e = i3;
            this.f51488i = 0;
            this.f51487h = 0;
            this.f51486g = AnimationUtils.currentAnimationTimeMillis();
            this.f51480a = i2;
            this.f51481b = i2;
            if (i2 <= i5 && i2 >= i4) {
                this.n = 0;
                double d2 = 0.0d;
                if (i3 != 0) {
                    int p2 = p(i3);
                    this.f51488i = p2;
                    this.f51487h = p2;
                    d2 = o(i3);
                }
                int signum = (int) (d2 * Math.signum(f2));
                this.j = signum;
                int i7 = i2 + signum;
                this.f51482c = i7;
                if (i7 < i4) {
                    h(this.f51480a, i7, i4);
                    this.f51482c = i4;
                }
                int i8 = this.f51482c;
                if (i8 > i5) {
                    h(this.f51480a, i8, i5);
                    this.f51482c = i5;
                    return;
                }
                return;
            }
            u(i2, i4, i5, i3);
        }

        public final double n(int i2) {
            return Math.log((Math.abs(i2) * 0.35f) / (this.m * this.o));
        }

        public final double o(int i2) {
            double n = n(i2);
            float f2 = p;
            return this.m * this.o * Math.exp((f2 / (f2 - 1.0d)) * n);
        }

        public final int p(int i2) {
            return (int) (Math.exp(n(i2) / (p - 1.0d)) * 1000.0d);
        }

        public void q(int i2, int i3, int i4) {
            if (this.n == 0) {
                this.l = i4;
                this.f51486g = AnimationUtils.currentAnimationTimeMillis();
                u(i2, i3, i3, (int) this.f51484e);
            }
        }

        public final void r() {
            int i2 = this.f51483d;
            float abs = (i2 * i2) / (Math.abs(this.f51485f) * 2.0f);
            float signum = Math.signum(this.f51483d);
            int i3 = this.l;
            if (abs > i3) {
                float f2 = -signum;
                int i4 = this.f51483d;
                this.f51485f = ((f2 * i4) * i4) / (i3 * 2.0f);
                abs = i3;
            }
            this.l = (int) abs;
            this.n = 2;
            int i5 = this.f51480a;
            if (this.f51483d <= 0) {
                abs = -abs;
            }
            this.f51482c = i5 + ((int) abs);
            this.f51487h = -((int) ((this.f51483d * 1000.0f) / this.f51485f));
        }

        public void s(float f2) {
            this.m = f2;
        }

        public boolean t(int i2, int i3, int i4) {
            this.k = true;
            this.f51482c = i2;
            this.f51480a = i2;
            this.f51483d = 0;
            this.f51486g = AnimationUtils.currentAnimationTimeMillis();
            this.f51487h = 0;
            if (i2 < i3) {
                x(i2, i3, 0);
            } else if (i2 > i4) {
                x(i2, i4, 0);
            }
            return !this.k;
        }

        public final void u(int i2, int i3, int i4, int i5) {
            if (i2 > i3 && i2 < i4) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.k = true;
                return;
            }
            boolean z = i2 > i4;
            int i6 = z ? i4 : i3;
            int i7 = i2 - i6;
            if (i7 * i5 >= 0) {
                v(i2, i6, i5);
            } else if (o(i5) > Math.abs(i7)) {
                l(i2, i5, z ? i3 : i2, z ? i2 : i4, this.l);
            } else {
                x(i2, i6, i5);
            }
        }

        public final void v(int i2, int i3, int i4) {
            this.f51485f = m(i4 == 0 ? i2 - i3 : i4);
            k(i2, i3, i4);
            r();
        }

        public void w(int i2, int i3, int i4) {
            this.k = false;
            this.f51480a = i2;
            this.f51482c = i2 + i3;
            this.f51486g = AnimationUtils.currentAnimationTimeMillis();
            this.f51487h = i4;
            this.f51485f = 0.0f;
            this.f51483d = 0;
        }

        public final void x(int i2, int i3, int i4) {
            this.k = false;
            this.n = 1;
            this.f51480a = i2;
            this.f51482c = i3;
            int i5 = i2 - i3;
            this.f51485f = m(i5);
            this.f51483d = -i5;
            this.l = Math.abs(i5);
            this.f51487h = (int) (Math.sqrt((i5 * (-2.0d)) / this.f51485f) * 1000.0d);
        }

        public boolean y() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f51486g;
            int i2 = this.f51487h;
            if (currentAnimationTimeMillis > i2) {
                return false;
            }
            double d2 = 0.0d;
            int i3 = this.n;
            if (i3 == 0) {
                float f2 = ((float) currentAnimationTimeMillis) / this.f51488i;
                int i4 = (int) (f2 * 100.0f);
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (i4 < 100) {
                    float f5 = i4 / 100.0f;
                    int i5 = i4 + 1;
                    float[] fArr = q;
                    float f6 = fArr[i4];
                    f4 = (fArr[i5] - f6) / ((i5 / 100.0f) - f5);
                    f3 = f6 + ((f2 - f5) * f4);
                }
                int i6 = this.j;
                this.f51484e = ((f4 * i6) / this.f51488i) * 1000.0f;
                d2 = f3 * i6;
            } else if (i3 == 1) {
                float f7 = ((float) currentAnimationTimeMillis) / i2;
                float f8 = f7 * f7;
                float signum = Math.signum(this.f51483d);
                int i7 = this.l;
                this.f51484e = signum * i7 * 6.0f * ((-f7) + f8);
                d2 = i7 * signum * ((3.0f * f8) - ((2.0f * f7) * f8));
            } else if (i3 == 2) {
                float f9 = ((float) currentAnimationTimeMillis) / 1000.0f;
                int i8 = this.f51483d;
                float f10 = this.f51485f;
                this.f51484e = i8 + (f10 * f9);
                d2 = (i8 * f9) + (((f10 * f9) * f9) / 2.0f);
            }
            this.f51481b = this.f51480a + ((int) Math.round(d2));
            return true;
        }

        public void z(float f2) {
            int i2 = this.f51480a;
            this.f51481b = i2 + Math.round(f2 * (this.f51482c - i2));
        }
    }

    public e(Context context) {
        this(context, null);
    }

    public static float n(float f2) {
        float exp;
        float f3 = f2 * f51473f;
        if (f3 < 1.0f) {
            exp = f3 - (1.0f - ((float) Math.exp(-f3)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f3))) * 0.63212055f) + 0.36787945f;
        }
        return exp * f51474g;
    }

    public void a() {
        this.f51476b.j();
        this.f51477c.j();
    }

    public boolean b() {
        float interpolation;
        if (g()) {
            return false;
        }
        int i2 = this.f51475a;
        if (i2 == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f51476b.f51486g;
            int i3 = this.f51476b.f51487h;
            if (currentAnimationTimeMillis < i3) {
                float f2 = ((float) currentAnimationTimeMillis) / i3;
                Interpolator interpolator = this.f51478d;
                if (interpolator == null) {
                    interpolation = n(f2);
                } else {
                    interpolation = interpolator.getInterpolation(f2);
                }
                this.f51476b.z(interpolation);
                this.f51477c.z(interpolation);
            } else {
                a();
            }
        } else if (i2 == 1) {
            if (!this.f51476b.k && !this.f51476b.y() && !this.f51476b.i()) {
                this.f51476b.j();
            }
            if (!this.f51477c.k && !this.f51477c.y() && !this.f51477c.i()) {
                this.f51477c.j();
            }
        }
        return true;
    }

    public void c(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        d(i2, i3, i4, i5, i6, i7, i8, i9, 0, 0);
    }

    public void d(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        if (!this.f51479e || g()) {
            i12 = i4;
        } else {
            float f2 = this.f51476b.f51484e;
            float f3 = this.f51477c.f51484e;
            i12 = i4;
            float f4 = i12;
            if (Math.signum(f4) == Math.signum(f2)) {
                i13 = i5;
                float f5 = i13;
                if (Math.signum(f5) == Math.signum(f3)) {
                    i14 = (int) (f5 + f3);
                    i15 = (int) (f4 + f2);
                    this.f51475a = 1;
                    this.f51476b.l(i2, i15, i6, i7, i10);
                    this.f51477c.l(i3, i14, i8, i9, i11);
                }
                i14 = i13;
                i15 = i12;
                this.f51475a = 1;
                this.f51476b.l(i2, i15, i6, i7, i10);
                this.f51477c.l(i3, i14, i8, i9, i11);
            }
        }
        i13 = i5;
        i14 = i13;
        i15 = i12;
        this.f51475a = 1;
        this.f51476b.l(i2, i15, i6, i7, i10);
        this.f51477c.l(i3, i14, i8, i9, i11);
    }

    public float e() {
        return (float) Math.sqrt((this.f51476b.f51484e * this.f51476b.f51484e) + (this.f51477c.f51484e * this.f51477c.f51484e));
    }

    public final int f() {
        return this.f51476b.f51481b;
    }

    public final boolean g() {
        return this.f51476b.k && this.f51477c.k;
    }

    public boolean h(float f2, float f3) {
        return !g() && Math.signum(f2) == Math.signum((float) (this.f51476b.f51482c - this.f51476b.f51480a)) && Math.signum(f3) == Math.signum((float) (this.f51477c.f51482c - this.f51477c.f51480a));
    }

    public void i(int i2, int i3, int i4) {
        this.f51476b.q(i2, i3, i4);
    }

    public final void j(float f2) {
        this.f51476b.s(f2);
        this.f51477c.s(f2);
    }

    public void k(Interpolator interpolator) {
        this.f51478d = interpolator;
    }

    public boolean l(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f51475a = 1;
        return this.f51476b.t(i2, i4, i5) || this.f51477c.t(i3, i6, i7);
    }

    public void m(int i2, int i3, int i4, int i5, int i6) {
        this.f51475a = 0;
        this.f51476b.w(i2, i4, i6);
        this.f51477c.w(i3, i5, i6);
    }

    public e(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public e(Context context, Interpolator interpolator, boolean z) {
        this.f51478d = interpolator;
        this.f51479e = z;
        this.f51476b = new a(context);
        this.f51477c = new a(context);
    }
}
