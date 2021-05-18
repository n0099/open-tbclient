package d.a.c.j.k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends Drawable implements Animatable {
    public static final Interpolator p = new LinearInterpolator();
    public static final Interpolator q = new FastOutSlowInInterpolator();
    public static final int[] r = {-16777216};

    /* renamed from: f  reason: collision with root package name */
    public final d f39670f;

    /* renamed from: g  reason: collision with root package name */
    public float f39671g;

    /* renamed from: h  reason: collision with root package name */
    public Resources f39672h;

    /* renamed from: i  reason: collision with root package name */
    public View f39673i;
    public Animation j;
    public float k;
    public double l;
    public double m;
    public boolean n;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<Animation> f39669e = new ArrayList<>();
    public final Drawable.Callback o = new c();

    /* renamed from: d.a.c.j.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0515a extends Animation {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f39674e;

        public C0515a(d dVar) {
            this.f39674e = dVar;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            a aVar = a.this;
            if (aVar.n) {
                aVar.a(f2, this.f39674e);
                return;
            }
            float c2 = aVar.c(this.f39674e);
            float j = this.f39674e.j();
            float l = this.f39674e.l();
            float k = this.f39674e.k();
            a.this.m(f2, this.f39674e);
            if (f2 <= 0.5f) {
                Interpolator interpolator = a.q;
                this.f39674e.D(l + ((0.8f - c2) * interpolator.getInterpolation(f2 / 0.5f)));
            }
            if (f2 > 0.5f) {
                Interpolator interpolator2 = a.q;
                this.f39674e.z(j + ((0.8f - c2) * interpolator2.getInterpolation((f2 - 0.5f) / 0.5f)));
            }
            this.f39674e.B(k + (0.25f * f2));
            a aVar2 = a.this;
            aVar2.h((f2 * 216.0f) + ((aVar2.k / 5.0f) * 1080.0f));
        }
    }

    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f39676a;

        public b(d dVar) {
            this.f39676a = dVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            this.f39676a.F();
            this.f39676a.n();
            d dVar = this.f39676a;
            dVar.D(dVar.e());
            a aVar = a.this;
            if (aVar.n) {
                aVar.n = false;
                animation.setDuration(1332L);
                this.f39676a.C(false);
                return;
            }
            aVar.k = (aVar.k + 1.0f) % 5.0f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            a.this.k = 0.0f;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Drawable.Callback {
        public c() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            a.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            a.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            a.this.unscheduleSelf(runnable);
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: d  reason: collision with root package name */
        public final Drawable.Callback f39682d;
        public int[] j;
        public int k;
        public float l;
        public float m;
        public float n;
        public boolean o;
        public Path p;
        public float q;
        public double r;
        public int s;
        public int t;
        public int u;
        public int w;
        public int x;

        /* renamed from: a  reason: collision with root package name */
        public final RectF f39679a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        public final Paint f39680b = new Paint();

        /* renamed from: c  reason: collision with root package name */
        public final Paint f39681c = new Paint();

        /* renamed from: e  reason: collision with root package name */
        public float f39683e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f39684f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f39685g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        public float f39686h = 5.0f;

        /* renamed from: i  reason: collision with root package name */
        public float f39687i = 2.5f;
        public final Paint v = new Paint(1);

        public d(Drawable.Callback callback) {
            this.f39682d = callback;
            this.f39680b.setStrokeCap(Paint.Cap.SQUARE);
            this.f39680b.setAntiAlias(true);
            this.f39680b.setStyle(Paint.Style.STROKE);
            this.f39681c.setStyle(Paint.Style.FILL);
            this.f39681c.setAntiAlias(true);
        }

        public void A(int i2, int i3) {
            float min = Math.min(i2, i3);
            double d2 = this.r;
            this.f39687i = (float) ((d2 <= 0.0d || min < 0.0f) ? Math.ceil(this.f39686h / 2.0f) : (min / 2.0f) - d2);
        }

        public void B(float f2) {
            this.f39685g = f2;
            o();
        }

        public void C(boolean z) {
            if (this.o != z) {
                this.o = z;
                o();
            }
        }

        public void D(float f2) {
            this.f39683e = f2;
            o();
        }

        public void E(float f2) {
            this.f39686h = f2;
            this.f39680b.setStrokeWidth(f2);
            o();
        }

        public void F() {
            this.l = this.f39683e;
            this.m = this.f39684f;
            this.n = this.f39685g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f39679a;
            rectF.set(rect);
            float f2 = this.f39687i;
            rectF.inset(f2, f2);
            float f3 = this.f39683e;
            float f4 = this.f39685g;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.f39684f + f4) * 360.0f) - f5;
            this.f39680b.setColor(this.x);
            canvas.drawArc(rectF, f5, f6, false, this.f39680b);
            b(canvas, f5, f6, rect);
            if (this.u < 255) {
                this.v.setColor(this.w);
                this.v.setAlpha(255 - this.u);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.v);
            }
        }

        public final void b(Canvas canvas, float f2, float f3, Rect rect) {
            if (this.o) {
                Path path = this.p;
                if (path == null) {
                    Path path2 = new Path();
                    this.p = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f4 = (((int) this.f39687i) / 2) * this.q;
                float sin = (float) ((this.r * Math.sin(0.0d)) + rect.exactCenterY());
                this.p.moveTo(0.0f, 0.0f);
                this.p.lineTo(this.s * this.q, 0.0f);
                Path path3 = this.p;
                float f5 = this.q;
                path3.lineTo((this.s * f5) / 2.0f, this.t * f5);
                this.p.offset(((float) ((this.r * Math.cos(0.0d)) + rect.exactCenterX())) - f4, sin);
                this.p.close();
                this.f39681c.setColor(this.x);
                canvas.rotate((f2 + f3) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.p, this.f39681c);
            }
        }

        public int c() {
            return this.u;
        }

        public double d() {
            return this.r;
        }

        public float e() {
            return this.f39684f;
        }

        public int f() {
            return this.j[g()];
        }

        public final int g() {
            return (this.k + 1) % this.j.length;
        }

        public float h() {
            return this.f39683e;
        }

        public int i() {
            return this.j[this.k];
        }

        public float j() {
            return this.m;
        }

        public float k() {
            return this.n;
        }

        public float l() {
            return this.l;
        }

        public float m() {
            return this.f39686h;
        }

        public void n() {
            x(g());
        }

        public final void o() {
            this.f39682d.invalidateDrawable(null);
        }

        public void p() {
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0.0f;
            D(0.0f);
            z(0.0f);
            B(0.0f);
        }

        public void q(int i2) {
            this.u = i2;
        }

        public void r(float f2, float f3) {
            this.s = (int) f2;
            this.t = (int) f3;
        }

        public void s(float f2) {
            if (f2 != this.q) {
                this.q = f2;
                o();
            }
        }

        public void t(int i2) {
            this.w = i2;
        }

        public void u(double d2) {
            this.r = d2;
        }

        public void v(int i2) {
            this.x = i2;
        }

        public void w(ColorFilter colorFilter) {
            this.f39680b.setColorFilter(colorFilter);
            o();
        }

        public void x(int i2) {
            this.k = i2;
            this.x = this.j[i2];
        }

        public void y(@NonNull int[] iArr) {
            this.j = iArr;
            x(0);
        }

        public void z(float f2) {
            this.f39684f = f2;
            o();
        }
    }

    public a(Context context, View view) {
        this.f39673i = view;
        this.f39672h = context.getResources();
        d dVar = new d(this.o);
        this.f39670f = dVar;
        dVar.y(r);
        n(1);
        k();
    }

    public void a(float f2, d dVar) {
        m(f2, dVar);
        dVar.D(dVar.l() + (((dVar.j() - c(dVar)) - dVar.l()) * f2));
        dVar.z(dVar.j());
        dVar.B(dVar.k() + ((((float) (Math.floor(dVar.k() / 0.8f) + 1.0d)) - dVar.k()) * f2));
    }

    public final int b(float f2, int i2, int i3) {
        int intValue = Integer.valueOf(i2).intValue();
        int i4 = (intValue >> 24) & 255;
        int i5 = (intValue >> 16) & 255;
        int i6 = (intValue >> 8) & 255;
        int i7 = intValue & 255;
        int intValue2 = Integer.valueOf(i3).intValue();
        return ((i4 + ((int) ((((intValue2 >> 24) & 255) - i4) * f2))) << 24) | ((i5 + ((int) ((((intValue2 >> 16) & 255) - i5) * f2))) << 16) | ((i6 + ((int) ((((intValue2 >> 8) & 255) - i6) * f2))) << 8) | (i7 + ((int) (f2 * ((intValue2 & 255) - i7))));
    }

    public float c(d dVar) {
        return (float) Math.toRadians(dVar.m() / (dVar.d() * 6.283185307179586d));
    }

    public void d(float f2) {
        this.f39670f.s(f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f39671g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f39670f.a(canvas, bounds);
        if (save < 1 || save > canvas.getSaveCount()) {
            return;
        }
        canvas.restoreToCount(save);
    }

    public void e(int i2) {
        this.f39670f.t(i2);
    }

    public void f(int... iArr) {
        this.f39670f.y(iArr);
        this.f39670f.x(0);
    }

    public void g(float f2) {
        this.f39670f.B(f2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f39670f.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(float f2) {
        this.f39671g = f2;
        invalidateSelf();
    }

    public final void i(double d2, double d3, double d4, double d5, float f2, float f3) {
        d dVar = this.f39670f;
        float f4 = this.f39672h.getDisplayMetrics().density;
        double d6 = f4;
        this.l = d2 * d6;
        this.m = d3 * d6;
        dVar.E(((float) d5) * f4);
        dVar.u(d4 * d6);
        dVar.x(0);
        dVar.r(f2 * f4, f3 * f4);
        dVar.A((int) this.l, (int) this.m);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.f39669e;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Animation animation = arrayList.get(i2);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void j(float f2, float f3) {
        this.f39670f.D(f2);
        this.f39670f.z(f3);
    }

    public final void k() {
        d dVar = this.f39670f;
        C0515a c0515a = new C0515a(dVar);
        c0515a.setRepeatCount(-1);
        c0515a.setRepeatMode(1);
        c0515a.setInterpolator(p);
        c0515a.setAnimationListener(new b(dVar));
        this.j = c0515a;
    }

    public void l(boolean z) {
        this.f39670f.C(z);
    }

    public void m(float f2, d dVar) {
        if (f2 > 0.75f) {
            dVar.v(b((f2 - 0.75f) / 0.25f, dVar.i(), dVar.f()));
        }
    }

    public void n(int i2) {
        if (i2 == 0) {
            i(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            i(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f39670f.q(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f39670f.w(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.j.reset();
        this.f39670f.F();
        if (this.f39670f.e() != this.f39670f.h()) {
            this.n = true;
            this.j.setDuration(666L);
            this.f39673i.startAnimation(this.j);
            return;
        }
        this.f39670f.x(0);
        this.f39670f.p();
        this.j.setDuration(1332L);
        this.f39673i.startAnimation(this.j);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f39673i.clearAnimation();
        h(0.0f);
        this.f39670f.C(false);
        this.f39670f.x(0);
        this.f39670f.p();
    }
}
