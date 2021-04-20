package com.kwad.sdk.glide.webp.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.kwad.sdk.glide.webp.decoder.o;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class k extends Drawable implements Animatable, Animatable2Compat, o.b {

    /* renamed from: a  reason: collision with root package name */
    public final a f36147a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36148b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36149c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36150d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36151e;

    /* renamed from: f  reason: collision with root package name */
    public int f36152f;

    /* renamed from: g  reason: collision with root package name */
    public int f36153g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36154h;
    public Paint i;
    public Rect j;
    public List<Animatable2Compat.AnimationCallback> k;

    /* loaded from: classes6.dex */
    public static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36155a;

        /* renamed from: b  reason: collision with root package name */
        public final o f36156b;

        public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, o oVar) {
            this.f36155a = eVar;
            this.f36156b = oVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new k(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public k(Context context, i iVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, int i, int i2, Bitmap bitmap) {
        this(new a(eVar, new o(com.kwad.sdk.glide.c.a(context), iVar, i, i2, hVar, bitmap)));
    }

    public k(a aVar) {
        this.f36151e = true;
        this.f36153g = -1;
        this.f36151e = true;
        this.f36153g = -1;
        this.f36147a = (a) com.kwad.sdk.glide.g.j.a(aVar);
    }

    private void i() {
        this.f36152f = 0;
    }

    private void j() {
        com.kwad.sdk.glide.g.j.a(!this.f36150d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f36147a.f36156b.g() != 1) {
            if (this.f36148b) {
                return;
            }
            this.f36148b = true;
            this.f36147a.f36156b.a(this);
        }
        invalidateSelf();
    }

    private void k() {
        this.f36148b = false;
        this.f36147a.f36156b.b(this);
    }

    private Rect l() {
        if (this.j == null) {
            this.j = new Rect();
        }
        return this.j;
    }

    private Paint m() {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        return this.i;
    }

    private Drawable.Callback n() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private void o() {
        List<Animatable2Compat.AnimationCallback> list = this.k;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.k.get(i).onAnimationEnd(this);
            }
        }
    }

    public int a() {
        return this.f36147a.f36156b.d();
    }

    public void a(com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f36147a.f36156b.a(hVar, bitmap);
    }

    public Bitmap b() {
        return this.f36147a.f36156b.a();
    }

    public ByteBuffer c() {
        return this.f36147a.f36156b.f();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.k;
        if (list != null) {
            list.clear();
        }
    }

    public int d() {
        return this.f36147a.f36156b.g();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (h()) {
            return;
        }
        if (this.f36154h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), l());
            this.f36154h = false;
        }
        canvas.drawBitmap(this.f36147a.f36156b.i(), (Rect) null, l(), m());
    }

    public int e() {
        return this.f36147a.f36156b.e();
    }

    @Override // com.kwad.sdk.glide.webp.decoder.o.b
    public void f() {
        if (n() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f36152f++;
        }
        int i = this.f36153g;
        if (i == -1 || this.f36152f < i) {
            return;
        }
        stop();
        o();
    }

    public void g() {
        this.f36150d = true;
        this.f36147a.f36156b.h();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f36147a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f36147a.f36156b.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f36147a.f36156b.b();
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public int getOpacity() {
        return -2;
    }

    public boolean h() {
        return this.f36150d;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f36148b;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f36154h = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        m().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        m().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        com.kwad.sdk.glide.g.j.a(!this.f36150d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f36151e = z;
        if (!z) {
            k();
        } else if (this.f36149c) {
            j();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f36149c = true;
        i();
        if (this.f36151e) {
            j();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f36149c = false;
        k();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }
}
