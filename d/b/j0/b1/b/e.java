package d.b.j0.b1.b;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: f  reason: collision with root package name */
    public static float f53725f = 8.0f;

    /* renamed from: g  reason: collision with root package name */
    public static float f53726g = 1.0f / n(1.0f);

    /* renamed from: a  reason: collision with root package name */
    public int f53727a;

    /* renamed from: b  reason: collision with root package name */
    public final a f53728b;

    /* renamed from: c  reason: collision with root package name */
    public final a f53729c;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f53730d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f53731e;

    /* loaded from: classes4.dex */
    public static class a {
        public static float p = (float) (Math.log(0.78d) / Math.log(0.9d));
        public static final float[] q = new float[101];
        public static final float[] r = new float[101];

        /* renamed from: a  reason: collision with root package name */
        public int f53732a;

        /* renamed from: b  reason: collision with root package name */
        public int f53733b;

        /* renamed from: c  reason: collision with root package name */
        public int f53734c;

        /* renamed from: d  reason: collision with root package name */
        public int f53735d;

        /* renamed from: e  reason: collision with root package name */
        public float f53736e;

        /* renamed from: f  reason: collision with root package name */
        public float f53737f;

        /* renamed from: g  reason: collision with root package name */
        public long f53738g;

        /* renamed from: h  reason: collision with root package name */
        public int f53739h;
        public int i;
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
            for (int i = 0; i < 100; i++) {
                float f14 = i / 100.0f;
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
                q[i] = (f6 * ((f5 * 0.5f) + f3)) + f7;
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
                r[i] = (f10 * ((f9 * 0.175f) + (f8 * 0.35000002f))) + f11;
            }
            float[] fArr = q;
            r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        public a(Context context) {
            this.o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        public static float m(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        public final void h(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (abs * 100.0f);
            if (i4 < 100) {
                float f2 = i4 / 100.0f;
                int i5 = i4 + 1;
                float[] fArr = r;
                float f3 = fArr[i4];
                this.f53739h = (int) (this.f53739h * (f3 + (((abs - f2) / ((i5 / 100.0f) - f2)) * (fArr[i5] - f3))));
            }
        }

        public boolean i() {
            int i = this.n;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                if (i == 2) {
                    this.f53738g += this.f53739h;
                    x(this.f53734c, this.f53732a, 0);
                }
            } else if (this.f53739h >= this.i) {
                return false;
            } else {
                this.f53732a = this.f53734c;
                int i2 = (int) this.f53736e;
                this.f53735d = i2;
                this.f53737f = m(i2);
                this.f53738g += this.f53739h;
                r();
            }
            y();
            return true;
        }

        public void j() {
            this.f53733b = this.f53734c;
            this.k = true;
        }

        public final void k(int i, int i2, int i3) {
            float f2 = this.f53737f;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(f2)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.f53737f));
            this.f53738g -= (int) ((sqrt - ((-i3) / f2)) * 1000.0f);
            this.f53732a = i2;
            this.f53735d = (int) ((-this.f53737f) * sqrt);
        }

        public void l(int i, int i2, int i3, int i4, int i5) {
            float f2;
            this.l = i5;
            this.k = false;
            this.f53735d = i2;
            this.f53736e = i2;
            this.i = 0;
            this.f53739h = 0;
            this.f53738g = AnimationUtils.currentAnimationTimeMillis();
            this.f53732a = i;
            this.f53733b = i;
            if (i <= i4 && i >= i3) {
                this.n = 0;
                double d2 = 0.0d;
                if (i2 != 0) {
                    int p2 = p(i2);
                    this.i = p2;
                    this.f53739h = p2;
                    d2 = o(i2);
                }
                int signum = (int) (d2 * Math.signum(f2));
                this.j = signum;
                int i6 = i + signum;
                this.f53734c = i6;
                if (i6 < i3) {
                    h(this.f53732a, i6, i3);
                    this.f53734c = i3;
                }
                int i7 = this.f53734c;
                if (i7 > i4) {
                    h(this.f53732a, i7, i4);
                    this.f53734c = i4;
                    return;
                }
                return;
            }
            u(i, i3, i4, i2);
        }

        public final double n(int i) {
            return Math.log((Math.abs(i) * 0.35f) / (this.m * this.o));
        }

        public final double o(int i) {
            double n = n(i);
            float f2 = p;
            return this.m * this.o * Math.exp((f2 / (f2 - 1.0d)) * n);
        }

        public final int p(int i) {
            return (int) (Math.exp(n(i) / (p - 1.0d)) * 1000.0d);
        }

        public void q(int i, int i2, int i3) {
            if (this.n == 0) {
                this.l = i3;
                this.f53738g = AnimationUtils.currentAnimationTimeMillis();
                u(i, i2, i2, (int) this.f53736e);
            }
        }

        public final void r() {
            int i = this.f53735d;
            float abs = (i * i) / (Math.abs(this.f53737f) * 2.0f);
            float signum = Math.signum(this.f53735d);
            int i2 = this.l;
            if (abs > i2) {
                float f2 = -signum;
                int i3 = this.f53735d;
                this.f53737f = ((f2 * i3) * i3) / (i2 * 2.0f);
                abs = i2;
            }
            this.l = (int) abs;
            this.n = 2;
            int i4 = this.f53732a;
            if (this.f53735d <= 0) {
                abs = -abs;
            }
            this.f53734c = i4 + ((int) abs);
            this.f53739h = -((int) ((this.f53735d * 1000.0f) / this.f53737f));
        }

        public void s(float f2) {
            this.m = f2;
        }

        public boolean t(int i, int i2, int i3) {
            this.k = true;
            this.f53734c = i;
            this.f53732a = i;
            this.f53735d = 0;
            this.f53738g = AnimationUtils.currentAnimationTimeMillis();
            this.f53739h = 0;
            if (i < i2) {
                x(i, i2, 0);
            } else if (i > i3) {
                x(i, i3, 0);
            }
            return !this.k;
        }

        public final void u(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.k = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                v(i, i5, i4);
            } else if (o(i4) > Math.abs(i6)) {
                l(i, i4, z ? i2 : i, z ? i : i3, this.l);
            } else {
                x(i, i5, i4);
            }
        }

        public final void v(int i, int i2, int i3) {
            this.f53737f = m(i3 == 0 ? i - i2 : i3);
            k(i, i2, i3);
            r();
        }

        public void w(int i, int i2, int i3) {
            this.k = false;
            this.f53732a = i;
            this.f53734c = i + i2;
            this.f53738g = AnimationUtils.currentAnimationTimeMillis();
            this.f53739h = i3;
            this.f53737f = 0.0f;
            this.f53735d = 0;
        }

        public final void x(int i, int i2, int i3) {
            this.k = false;
            this.n = 1;
            this.f53732a = i;
            this.f53734c = i2;
            int i4 = i - i2;
            this.f53737f = m(i4);
            this.f53735d = -i4;
            this.l = Math.abs(i4);
            this.f53739h = (int) (Math.sqrt((i4 * (-2.0d)) / this.f53737f) * 1000.0d);
        }

        public boolean y() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f53738g;
            int i = this.f53739h;
            if (currentAnimationTimeMillis > i) {
                return false;
            }
            double d2 = 0.0d;
            int i2 = this.n;
            if (i2 == 0) {
                float f2 = ((float) currentAnimationTimeMillis) / this.i;
                int i3 = (int) (f2 * 100.0f);
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (i3 < 100) {
                    float f5 = i3 / 100.0f;
                    int i4 = i3 + 1;
                    float[] fArr = q;
                    float f6 = fArr[i3];
                    f4 = (fArr[i4] - f6) / ((i4 / 100.0f) - f5);
                    f3 = f6 + ((f2 - f5) * f4);
                }
                int i5 = this.j;
                this.f53736e = ((f4 * i5) / this.i) * 1000.0f;
                d2 = f3 * i5;
            } else if (i2 == 1) {
                float f7 = ((float) currentAnimationTimeMillis) / i;
                float f8 = f7 * f7;
                float signum = Math.signum(this.f53735d);
                int i6 = this.l;
                this.f53736e = signum * i6 * 6.0f * ((-f7) + f8);
                d2 = i6 * signum * ((3.0f * f8) - ((2.0f * f7) * f8));
            } else if (i2 == 2) {
                float f9 = ((float) currentAnimationTimeMillis) / 1000.0f;
                int i7 = this.f53735d;
                float f10 = this.f53737f;
                this.f53736e = i7 + (f10 * f9);
                d2 = (i7 * f9) + (((f10 * f9) * f9) / 2.0f);
            }
            this.f53733b = this.f53732a + ((int) Math.round(d2));
            return true;
        }

        public void z(float f2) {
            int i = this.f53732a;
            this.f53733b = i + Math.round(f2 * (this.f53734c - i));
        }
    }

    public e(Context context) {
        this(context, null);
    }

    public static float n(float f2) {
        float exp;
        float f3 = f2 * f53725f;
        if (f3 < 1.0f) {
            exp = f3 - (1.0f - ((float) Math.exp(-f3)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f3))) * 0.63212055f) + 0.36787945f;
        }
        return exp * f53726g;
    }

    public void a() {
        this.f53728b.j();
        this.f53729c.j();
    }

    public boolean b() {
        float interpolation;
        if (g()) {
            return false;
        }
        int i = this.f53727a;
        if (i == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f53728b.f53738g;
            int i2 = this.f53728b.f53739h;
            if (currentAnimationTimeMillis < i2) {
                float f2 = ((float) currentAnimationTimeMillis) / i2;
                Interpolator interpolator = this.f53730d;
                if (interpolator == null) {
                    interpolation = n(f2);
                } else {
                    interpolation = interpolator.getInterpolation(f2);
                }
                this.f53728b.z(interpolation);
                this.f53729c.z(interpolation);
            } else {
                a();
            }
        } else if (i == 1) {
            if (!this.f53728b.k && !this.f53728b.y() && !this.f53728b.i()) {
                this.f53728b.j();
            }
            if (!this.f53729c.k && !this.f53729c.y() && !this.f53729c.i()) {
                this.f53729c.j();
            }
        }
        return true;
    }

    public void c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        d(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void d(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (!this.f53731e || g()) {
            i11 = i3;
        } else {
            float f2 = this.f53728b.f53736e;
            float f3 = this.f53729c.f53736e;
            i11 = i3;
            float f4 = i11;
            if (Math.signum(f4) == Math.signum(f2)) {
                i12 = i4;
                float f5 = i12;
                if (Math.signum(f5) == Math.signum(f3)) {
                    i13 = (int) (f5 + f3);
                    i14 = (int) (f4 + f2);
                    this.f53727a = 1;
                    this.f53728b.l(i, i14, i5, i6, i9);
                    this.f53729c.l(i2, i13, i7, i8, i10);
                }
                i13 = i12;
                i14 = i11;
                this.f53727a = 1;
                this.f53728b.l(i, i14, i5, i6, i9);
                this.f53729c.l(i2, i13, i7, i8, i10);
            }
        }
        i12 = i4;
        i13 = i12;
        i14 = i11;
        this.f53727a = 1;
        this.f53728b.l(i, i14, i5, i6, i9);
        this.f53729c.l(i2, i13, i7, i8, i10);
    }

    public float e() {
        return (float) Math.sqrt((this.f53728b.f53736e * this.f53728b.f53736e) + (this.f53729c.f53736e * this.f53729c.f53736e));
    }

    public final int f() {
        return this.f53728b.f53733b;
    }

    public final boolean g() {
        return this.f53728b.k && this.f53729c.k;
    }

    public boolean h(float f2, float f3) {
        return !g() && Math.signum(f2) == Math.signum((float) (this.f53728b.f53734c - this.f53728b.f53732a)) && Math.signum(f3) == Math.signum((float) (this.f53729c.f53734c - this.f53729c.f53732a));
    }

    public void i(int i, int i2, int i3) {
        this.f53728b.q(i, i2, i3);
    }

    public final void j(float f2) {
        this.f53728b.s(f2);
        this.f53729c.s(f2);
    }

    public void k(Interpolator interpolator) {
        this.f53730d = interpolator;
    }

    public boolean l(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f53727a = 1;
        return this.f53728b.t(i, i3, i4) || this.f53729c.t(i2, i5, i6);
    }

    public void m(int i, int i2, int i3, int i4, int i5) {
        this.f53727a = 0;
        this.f53728b.w(i, i3, i5);
        this.f53729c.w(i2, i4, i5);
    }

    public e(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public e(Context context, Interpolator interpolator, boolean z) {
        this.f53730d = interpolator;
        this.f53731e = z;
        this.f53728b = new a(context);
        this.f53729c = new a(context);
    }
}
