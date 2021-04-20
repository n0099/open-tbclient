package com.ksad.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.lottie.c.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes6.dex */
public class f extends Drawable implements Animatable, Drawable.Callback {

    /* renamed from: c  reason: collision with root package name */
    public static final String f31691c = f.class.getSimpleName();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public com.ksad.lottie.a f31692a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public m f31693b;

    /* renamed from: e  reason: collision with root package name */
    public d f31695e;
    @Nullable
    public com.ksad.lottie.b.b j;
    @Nullable
    public String k;
    @Nullable
    public b l;
    @Nullable
    public com.ksad.lottie.b.a m;
    public boolean n;
    @Nullable
    public com.ksad.lottie.model.layer.b o;
    public boolean q;

    /* renamed from: d  reason: collision with root package name */
    public final Matrix f31694d = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.d.c f31696f = new com.ksad.lottie.d.c();

    /* renamed from: g  reason: collision with root package name */
    public float f31697g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public final Set<Object> f31698h = new HashSet();
    public final ArrayList<a> i = new ArrayList<>();
    public int p = 255;

    /* loaded from: classes6.dex */
    public interface a {
        void a(d dVar);
    }

    public f() {
        this.f31696f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ksad.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.o != null) {
                    f.this.o.a(f.this.f31696f.d());
                }
            }
        });
    }

    private float a(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f31695e.b().width(), canvas.getHeight() / this.f31695e.b().height());
    }

    private void u() {
        this.o = new com.ksad.lottie.model.layer.b(this, s.a(this.f31695e), this.f31695e.g(), this.f31695e);
    }

    private void v() {
        if (this.f31695e == null) {
            return;
        }
        float q = q();
        setBounds(0, 0, (int) (this.f31695e.b().width() * q), (int) (this.f31695e.b().height() * q));
    }

    private com.ksad.lottie.b.b w() {
        if (getCallback() == null) {
            return null;
        }
        com.ksad.lottie.b.b bVar = this.j;
        if (bVar != null && !bVar.a(y())) {
            this.j.a();
            this.j = null;
        }
        if (this.j == null) {
            this.j = new com.ksad.lottie.b.b(getCallback(), this.k, this.l, this.f31695e.j());
        }
        return this.j;
    }

    private com.ksad.lottie.b.a x() {
        if (getCallback() == null) {
            return null;
        }
        if (this.m == null) {
            this.m = new com.ksad.lottie.b.a(getCallback(), this.f31692a);
        }
        return this.m;
    }

    @Nullable
    private Context y() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Nullable
    public Typeface a(String str, String str2) {
        com.ksad.lottie.b.a x = x();
        if (x != null) {
            return x.a(str, str2);
        }
        return null;
    }

    public void a(final float f2) {
        d dVar = this.f31695e;
        if (dVar == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.6
                @Override // com.ksad.lottie.f.a
                public void a(d dVar2) {
                    f.this.a(f2);
                }
            });
        } else {
            a((int) com.ksad.lottie.d.e.a(dVar.d(), this.f31695e.e(), f2));
        }
    }

    public void a(final int i) {
        if (this.f31695e == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.5
                @Override // com.ksad.lottie.f.a
                public void a(d dVar) {
                    f.this.a(i);
                }
            });
        } else {
            this.f31696f.b(i);
        }
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.f31696f.addListener(animatorListener);
    }

    public void a(com.ksad.lottie.a aVar) {
        this.f31692a = aVar;
        com.ksad.lottie.b.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public void a(b bVar) {
        this.l = bVar;
        com.ksad.lottie.b.b bVar2 = this.j;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    public void a(m mVar) {
        this.f31693b = mVar;
    }

    public void a(@Nullable String str) {
        this.k = str;
    }

    public void a(boolean z) {
        if (this.n == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(f31691c, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.n = z;
        if (this.f31695e != null) {
            u();
        }
    }

    public boolean a() {
        return this.n;
    }

    public boolean a(d dVar) {
        if (this.f31695e == dVar) {
            return false;
        }
        e();
        this.f31695e = dVar;
        u();
        this.f31696f.a(dVar);
        d(this.f31696f.getAnimatedFraction());
        e(this.f31697g);
        v();
        Iterator it = new ArrayList(this.i).iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(dVar);
            it.remove();
        }
        this.i.clear();
        dVar.a(this.q);
        return true;
    }

    @Nullable
    public Bitmap b(String str) {
        com.ksad.lottie.b.b w = w();
        if (w != null) {
            return w.a(str);
        }
        return null;
    }

    @Nullable
    public String b() {
        return this.k;
    }

    public void b(@FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        d dVar = this.f31695e;
        if (dVar == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.8
                @Override // com.ksad.lottie.f.a
                public void a(d dVar2) {
                    f.this.b(f2);
                }
            });
        } else {
            b((int) com.ksad.lottie.d.e.a(dVar.d(), this.f31695e.e(), f2));
        }
    }

    public void b(final int i) {
        if (this.f31695e == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.7
                @Override // com.ksad.lottie.f.a
                public void a(d dVar) {
                    f.this.b(i);
                }
            });
        } else {
            this.f31696f.c(i);
        }
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.f31696f.removeListener(animatorListener);
    }

    public void b(boolean z) {
        this.q = z;
        d dVar = this.f31695e;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    public void c() {
        com.ksad.lottie.b.b bVar = this.j;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void c(float f2) {
        this.f31696f.a(f2);
    }

    public void c(final int i) {
        if (this.f31695e == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.2
                @Override // com.ksad.lottie.f.a
                public void a(d dVar) {
                    f.this.c(i);
                }
            });
        } else {
            this.f31696f.a(i);
        }
    }

    @Nullable
    public l d() {
        d dVar = this.f31695e;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public void d(@FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        d dVar = this.f31695e;
        if (dVar == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.3
                @Override // com.ksad.lottie.f.a
                public void a(d dVar2) {
                    f.this.d(f2);
                }
            });
        } else {
            c((int) com.ksad.lottie.d.e.a(dVar.d(), this.f31695e.e(), f2));
        }
    }

    public void d(int i) {
        this.f31696f.setRepeatMode(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f2;
        c.c("Drawable#draw");
        if (this.o == null) {
            return;
        }
        float f3 = this.f31697g;
        float a2 = a(canvas);
        if (f3 > a2) {
            f2 = this.f31697g / a2;
        } else {
            a2 = f3;
            f2 = 1.0f;
        }
        int i = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
        if (i > 0) {
            canvas.save();
            float width = this.f31695e.b().width() / 2.0f;
            float height = this.f31695e.b().height() / 2.0f;
            float f4 = width * a2;
            float f5 = height * a2;
            canvas.translate((q() * width) - f4, (q() * height) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.f31694d.reset();
        this.f31694d.preScale(a2, a2);
        this.o.a(canvas, this.f31694d, this.p);
        c.d("Drawable#draw");
        if (i > 0) {
            canvas.restore();
        }
    }

    public void e() {
        c();
        if (this.f31696f.isRunning()) {
            this.f31696f.cancel();
        }
        this.f31695e = null;
        this.o = null;
        this.j = null;
        this.f31696f.f();
        invalidateSelf();
    }

    public void e(float f2) {
        this.f31697g = f2;
        v();
    }

    public void e(int i) {
        this.f31696f.setRepeatCount(i);
    }

    @MainThread
    public void f() {
        if (this.o == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.4
                @Override // com.ksad.lottie.f.a
                public void a(d dVar) {
                    f.this.f();
                }
            });
        } else {
            this.f31696f.i();
        }
    }

    @MainThread
    public void g() {
        this.i.clear();
        this.f31696f.j();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        d dVar = this.f31695e;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.b().height() * q());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        d dVar = this.f31695e;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.b().width() * q());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        return this.f31696f.k();
    }

    public float i() {
        return this.f31696f.l();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return n();
    }

    public float j() {
        return this.f31696f.h();
    }

    public int k() {
        return (int) this.f31696f.e();
    }

    public int l() {
        return this.f31696f.getRepeatMode();
    }

    public int m() {
        return this.f31696f.getRepeatCount();
    }

    public boolean n() {
        return this.f31696f.isRunning();
    }

    @Nullable
    public m o() {
        return this.f31693b;
    }

    public boolean p() {
        return this.f31693b == null && this.f31695e.h().size() > 0;
    }

    public float q() {
        return this.f31697g;
    }

    public d r() {
        return this.f31695e;
    }

    public void s() {
        this.i.clear();
        this.f31696f.cancel();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.p = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        f();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        g();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float t() {
        return this.f31696f.d();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }
}
