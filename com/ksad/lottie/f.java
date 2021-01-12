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
import com.baidu.mapapi.map.WeightedLatLng;
import com.ksad.lottie.c.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes4.dex */
public class f extends Drawable implements Animatable, Drawable.Callback {
    private static final String c = f.class.getSimpleName();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    com.ksad.lottie.a f8009a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    m f8010b;
    private d e;
    @Nullable
    private com.ksad.lottie.b.b j;
    @Nullable
    private String k;
    @Nullable
    private b l;
    @Nullable
    private com.ksad.lottie.b.a m;
    private boolean n;
    @Nullable
    private com.ksad.lottie.model.layer.b o;
    private boolean q;
    private final Matrix d = new Matrix();
    private final com.ksad.lottie.d.c f = new com.ksad.lottie.d.c();
    private float g = 1.0f;
    private final Set<Object> h = new HashSet();
    private final ArrayList<a> i = new ArrayList<>();
    private int p = 255;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void a(d dVar);
    }

    public f() {
        this.f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ksad.lottie.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (f.this.o != null) {
                    f.this.o.a(f.this.f.d());
                }
            }
        });
    }

    private float a(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.e.b().width(), canvas.getHeight() / this.e.b().height());
    }

    private void u() {
        this.o = new com.ksad.lottie.model.layer.b(this, s.a(this.e), this.e.g(), this.e);
    }

    private void v() {
        if (this.e == null) {
            return;
        }
        float q = q();
        setBounds(0, 0, (int) (this.e.b().width() * q), (int) (q * this.e.b().height()));
    }

    private com.ksad.lottie.b.b w() {
        if (getCallback() == null) {
            return null;
        }
        if (this.j != null && !this.j.a(y())) {
            this.j.a();
            this.j = null;
        }
        if (this.j == null) {
            this.j = new com.ksad.lottie.b.b(getCallback(), this.k, this.l, this.e.j());
        }
        return this.j;
    }

    private com.ksad.lottie.b.a x() {
        if (getCallback() == null) {
            return null;
        }
        if (this.m == null) {
            this.m = new com.ksad.lottie.b.a(getCallback(), this.f8009a);
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

    public void a(final float f) {
        if (this.e == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.6
                @Override // com.ksad.lottie.f.a
                public void a(d dVar) {
                    f.this.a(f);
                }
            });
        } else {
            a((int) com.ksad.lottie.d.e.a(this.e.d(), this.e.e(), f));
        }
    }

    public void a(final int i) {
        if (this.e == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.5
                @Override // com.ksad.lottie.f.a
                public void a(d dVar) {
                    f.this.a(i);
                }
            });
        } else {
            this.f.b(i);
        }
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.f.addListener(animatorListener);
    }

    public void a(com.ksad.lottie.a aVar) {
        this.f8009a = aVar;
        if (this.m != null) {
            this.m.a(aVar);
        }
    }

    public void a(b bVar) {
        this.l = bVar;
        if (this.j != null) {
            this.j.a(bVar);
        }
    }

    public void a(m mVar) {
        this.f8010b = mVar;
    }

    public void a(@Nullable String str) {
        this.k = str;
    }

    public void a(boolean z) {
        if (this.n == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(c, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.n = z;
        if (this.e != null) {
            u();
        }
    }

    public boolean a() {
        return this.n;
    }

    public boolean a(d dVar) {
        if (this.e == dVar) {
            return false;
        }
        e();
        this.e = dVar;
        u();
        this.f.a(dVar);
        d(this.f.getAnimatedFraction());
        e(this.g);
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

    public void b(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.e == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.8
                @Override // com.ksad.lottie.f.a
                public void a(d dVar) {
                    f.this.b(f);
                }
            });
        } else {
            b((int) com.ksad.lottie.d.e.a(this.e.d(), this.e.e(), f));
        }
    }

    public void b(final int i) {
        if (this.e == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.7
                @Override // com.ksad.lottie.f.a
                public void a(d dVar) {
                    f.this.b(i);
                }
            });
        } else {
            this.f.c(i);
        }
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.f.removeListener(animatorListener);
    }

    public void b(boolean z) {
        this.q = z;
        if (this.e != null) {
            this.e.a(z);
        }
    }

    public void c() {
        if (this.j != null) {
            this.j.a();
        }
    }

    public void c(float f) {
        this.f.a(f);
    }

    public void c(final int i) {
        if (this.e == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.2
                @Override // com.ksad.lottie.f.a
                public void a(d dVar) {
                    f.this.c(i);
                }
            });
        } else {
            this.f.a(i);
        }
    }

    @Nullable
    public l d() {
        if (this.e != null) {
            return this.e.a();
        }
        return null;
    }

    public void d(@FloatRange(from = 0.0d, to = 1.0d) final float f) {
        if (this.e == null) {
            this.i.add(new a() { // from class: com.ksad.lottie.f.3
                @Override // com.ksad.lottie.f.a
                public void a(d dVar) {
                    f.this.d(f);
                }
            });
        } else {
            c((int) com.ksad.lottie.d.e.a(this.e.d(), this.e.e(), f));
        }
    }

    public void d(int i) {
        this.f.setRepeatMode(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f;
        c.c("Drawable#draw");
        if (this.o == null) {
            return;
        }
        float f2 = this.g;
        float a2 = a(canvas);
        if (f2 > a2) {
            f = this.g / a2;
        } else {
            f = 1.0f;
            a2 = f2;
        }
        if (f > 1.0f) {
            canvas.save();
            float width = this.e.b().width() / 2.0f;
            float height = this.e.b().height() / 2.0f;
            float f3 = width * a2;
            float f4 = height * a2;
            canvas.translate((width * q()) - f3, (height * q()) - f4);
            canvas.scale(f, f, f3, f4);
        }
        this.d.reset();
        this.d.preScale(a2, a2);
        this.o.a(canvas, this.d, this.p);
        c.d("Drawable#draw");
        if (f > 1.0f) {
            canvas.restore();
        }
    }

    public void e() {
        c();
        if (this.f.isRunning()) {
            this.f.cancel();
        }
        this.e = null;
        this.o = null;
        this.j = null;
        this.f.f();
        invalidateSelf();
    }

    public void e(float f) {
        this.g = f;
        v();
    }

    public void e(int i) {
        this.f.setRepeatCount(i);
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
            this.f.i();
        }
    }

    @MainThread
    public void g() {
        this.i.clear();
        this.f.j();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.e == null) {
            return -1;
        }
        return (int) (this.e.b().height() * q());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.e == null) {
            return -1;
        }
        return (int) (this.e.b().width() * q());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        return this.f.k();
    }

    public float i() {
        return this.f.l();
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
        return this.f.h();
    }

    public int k() {
        return (int) this.f.e();
    }

    public int l() {
        return this.f.getRepeatMode();
    }

    public int m() {
        return this.f.getRepeatCount();
    }

    public boolean n() {
        return this.f.isRunning();
    }

    @Nullable
    public m o() {
        return this.f8010b;
    }

    public boolean p() {
        return this.f8010b == null && this.e.h().size() > 0;
    }

    public float q() {
        return this.g;
    }

    public d r() {
        return this.e;
    }

    public void s() {
        this.i.clear();
        this.f.cancel();
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

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float t() {
        return this.f.d();
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
