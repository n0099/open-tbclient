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
/* loaded from: classes6.dex */
public class c extends Drawable implements Animatable, Animatable2Compat, g.b {

    /* renamed from: a  reason: collision with root package name */
    public final a f36005a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36006b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36007c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36008d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36009e;

    /* renamed from: f  reason: collision with root package name */
    public int f36010f;

    /* renamed from: g  reason: collision with root package name */
    public int f36011g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36012h;
    public Paint i;
    public Rect j;
    public List<Animatable2Compat.AnimationCallback> k;

    /* loaded from: classes6.dex */
    public static final class a extends Drawable.ConstantState {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        public final g f36013a;

        public a(g gVar) {
            this.f36013a = gVar;
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

    public c(Context context, com.kwad.sdk.glide.b.a aVar, com.kwad.sdk.glide.load.h<Bitmap> hVar, int i, int i2, Bitmap bitmap) {
        this(new a(new g(com.kwad.sdk.glide.c.a(context), aVar, i, i2, hVar, bitmap)));
    }

    public c(a aVar) {
        this.f36009e = true;
        this.f36011g = -1;
        this.f36005a = (a) com.kwad.sdk.glide.g.j.a(aVar);
    }

    private void h() {
        this.f36010f = 0;
    }

    private void i() {
        com.kwad.sdk.glide.g.j.a(!this.f36008d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f36005a.f36013a.g() != 1) {
            if (this.f36006b) {
                return;
            }
            this.f36006b = true;
            this.f36005a.f36013a.a(this);
        }
        invalidateSelf();
    }

    private void j() {
        this.f36006b = false;
        this.f36005a.f36013a.b(this);
    }

    private Rect k() {
        if (this.j == null) {
            this.j = new Rect();
        }
        return this.j;
    }

    private Paint l() {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        return this.i;
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
            for (int i = 0; i < size; i++) {
                this.k.get(i).onAnimationEnd(this);
            }
        }
    }

    public int a() {
        return this.f36005a.f36013a.d();
    }

    public void a(com.kwad.sdk.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f36005a.f36013a.a(hVar, bitmap);
    }

    public Bitmap b() {
        return this.f36005a.f36013a.a();
    }

    public ByteBuffer c() {
        return this.f36005a.f36013a.f();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.k;
        if (list != null) {
            list.clear();
        }
    }

    public int d() {
        return this.f36005a.f36013a.g();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f36008d) {
            return;
        }
        if (this.f36012h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), k());
            this.f36012h = false;
        }
        canvas.drawBitmap(this.f36005a.f36013a.i(), (Rect) null, k(), l());
    }

    public int e() {
        return this.f36005a.f36013a.e();
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
            this.f36010f++;
        }
        int i = this.f36011g;
        if (i == -1 || this.f36010f < i) {
            return;
        }
        n();
        stop();
    }

    public void g() {
        this.f36008d = true;
        this.f36005a.f36013a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f36005a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f36005a.f36013a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f36005a.f36013a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f36006b;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f36012h = true;
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
        l().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        l().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        com.kwad.sdk.glide.g.j.a(!this.f36008d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f36009e = z;
        if (!z) {
            j();
        } else if (this.f36007c) {
            i();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f36007c = true;
        h();
        if (this.f36009e) {
            i();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f36007c = false;
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
