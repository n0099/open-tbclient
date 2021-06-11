package com.kwad.sdk.glide.load.resource.d;

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
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.kwad.sdk.glide.load.resource.d.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends Drawable implements Animatable, Animatable2Compat, g.b {

    /* renamed from: a  reason: collision with root package name */
    public final a f36410a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36411b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36412c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36413d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36414e;

    /* renamed from: f  reason: collision with root package name */
    public int f36415f;

    /* renamed from: g  reason: collision with root package name */
    public int f36416g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36417h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f36418i;
    public Rect j;
    public List<Animatable2Compat.AnimationCallback> k;

    /* loaded from: classes7.dex */
    public static final class a extends Drawable.ConstantState {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        public final g f36419a;

        public a(g gVar) {
            this.f36419a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new c(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public c(Context context, com.kwad.sdk.glide.b.a aVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, int i2, int i3, Bitmap bitmap) {
        this(new a(new g(com.kwad.sdk.glide.c.a(context), aVar, i2, i3, hVar, bitmap)));
    }

    public c(a aVar) {
        this.f36414e = true;
        this.f36416g = -1;
        this.f36410a = (a) com.kwad.sdk.glide.g.j.a(aVar);
    }

    private void h() {
        this.f36415f = 0;
    }

    private void i() {
        com.kwad.sdk.glide.g.j.a(!this.f36413d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f36410a.f36419a.g() != 1) {
            if (this.f36411b) {
                return;
            }
            this.f36411b = true;
            this.f36410a.f36419a.a(this);
        }
        invalidateSelf();
    }

    private void j() {
        this.f36411b = false;
        this.f36410a.f36419a.b(this);
    }

    private Rect k() {
        if (this.j == null) {
            this.j = new Rect();
        }
        return this.j;
    }

    private Paint l() {
        if (this.f36418i == null) {
            this.f36418i = new Paint(2);
        }
        return this.f36418i;
    }

    private Drawable.Callback m() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private void n() {
        List<Animatable2Compat.AnimationCallback> list = this.k;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.k.get(i2).onAnimationEnd(this);
            }
        }
    }

    public int a() {
        return this.f36410a.f36419a.d();
    }

    public void a(com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f36410a.f36419a.a(hVar, bitmap);
    }

    public Bitmap b() {
        return this.f36410a.f36419a.a();
    }

    public ByteBuffer c() {
        return this.f36410a.f36419a.f();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.k;
        if (list != null) {
            list.clear();
        }
    }

    public int d() {
        return this.f36410a.f36419a.g();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f36413d) {
            return;
        }
        if (this.f36417h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), k());
            this.f36417h = false;
        }
        canvas.drawBitmap(this.f36410a.f36419a.i(), (Rect) null, k(), l());
    }

    public int e() {
        return this.f36410a.f36419a.e();
    }

    @Override // com.kwad.sdk.glide.load.resource.d.g.b
    public void f() {
        if (m() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f36415f++;
        }
        int i2 = this.f36416g;
        if (i2 == -1 || this.f36415f < i2) {
            return;
        }
        n();
        stop();
    }

    public void g() {
        this.f36413d = true;
        this.f36410a.f36419a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f36410a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f36410a.f36419a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f36410a.f36419a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f36411b;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f36417h = true;
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
    public void setAlpha(int i2) {
        l().setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        l().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        com.kwad.sdk.glide.g.j.a(!this.f36413d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f36414e = z;
        if (!z) {
            j();
        } else if (this.f36412c) {
            i();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f36412c = true;
        h();
        if (this.f36414e) {
            i();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f36412c = false;
        j();
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
