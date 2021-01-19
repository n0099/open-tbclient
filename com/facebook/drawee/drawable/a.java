package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a extends Drawable implements Drawable.Callback, q, r {
    private r psd;
    private final Drawable[] psf;
    private final c[] psg;
    private final d pse = new d();
    private final Rect mTmpRect = new Rect();
    private boolean psh = false;
    private boolean psi = false;
    private boolean psj = false;

    public a(Drawable[] drawableArr) {
        com.facebook.common.internal.g.checkNotNull(drawableArr);
        this.psf = drawableArr;
        for (int i = 0; i < this.psf.length; i++) {
            e.a(this.psf[i], this, this);
        }
        this.psg = new c[this.psf.length];
    }

    public int erQ() {
        return this.psf.length;
    }

    @Nullable
    public Drawable getDrawable(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.psf.length);
        return this.psf[i];
    }

    @Nullable
    public Drawable a(int i, @Nullable Drawable drawable) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.psf.length);
        Drawable drawable2 = this.psf[i];
        if (drawable != drawable2) {
            if (drawable != null && this.psj) {
                drawable.mutate();
            }
            e.a(this.psf[i], null, null);
            e.a(drawable, null, null);
            e.a(drawable, this.pse);
            e.d(drawable, this);
            e.a(drawable, this, this);
            this.psi = false;
            this.psf[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.psf.length; i2++) {
            Drawable drawable = this.psf[i2];
            if (drawable != null) {
                i = Math.max(i, drawable.getIntrinsicWidth());
            }
        }
        if (i > 0) {
            return i;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = -1;
        for (int i2 = 0; i2 < this.psf.length; i2++) {
            Drawable drawable = this.psf[i2];
            if (drawable != null) {
                i = Math.max(i, drawable.getIntrinsicHeight());
            }
        }
        if (i > 0) {
            return i;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        for (int i = 0; i < this.psf.length; i++) {
            Drawable drawable = this.psf[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.psi) {
            this.psh = false;
            for (int i = 0; i < this.psf.length; i++) {
                Drawable drawable = this.psf[i];
                this.psh = (drawable != null && drawable.isStateful()) | this.psh;
            }
            this.psi = true;
        }
        return this.psh;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = z;
            if (i < this.psf.length) {
                Drawable drawable = this.psf[i];
                if (drawable != null && drawable.setState(iArr)) {
                    z2 = true;
                }
                z = z2;
                i++;
            } else {
                return z2;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean z = false;
        int i2 = 0;
        while (true) {
            boolean z2 = z;
            if (i2 < this.psf.length) {
                Drawable drawable = this.psf[i2];
                if (drawable != null && drawable.setLevel(i)) {
                    z2 = true;
                }
                z = z2;
                i2++;
            } else {
                return z2;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.psf.length; i++) {
            Drawable drawable = this.psf[i];
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.mTmpRect;
        for (int i = 0; i < this.psf.length; i++) {
            Drawable drawable = this.psf[i];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        for (int i = 0; i < this.psf.length; i++) {
            Drawable drawable = this.psf[i];
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.psj = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.psf.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.psf.length; i2++) {
            Drawable drawable = this.psf[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pse.setAlpha(i);
        for (int i2 = 0; i2 < this.psf.length; i2++) {
            Drawable drawable = this.psf[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.pse.setColorFilter(colorFilter);
        for (int i = 0; i < this.psf.length; i++) {
            Drawable drawable = this.psf[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.pse.setDither(z);
        for (int i = 0; i < this.psf.length; i++) {
            Drawable drawable = this.psf[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.pse.setFilterBitmap(z);
        for (int i = 0; i < this.psf.length; i++) {
            Drawable drawable = this.psf[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (int i = 0; i < this.psf.length; i++) {
            Drawable drawable = this.psf[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
        }
        return visible;
    }

    public c OJ(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.psg.length);
        if (this.psg[i] == null) {
            this.psg[i] = OK(i);
        }
        return this.psg[i];
    }

    private c OK(final int i) {
        return new c() { // from class: com.facebook.drawee.drawable.a.1
            @Override // com.facebook.drawee.drawable.c
            public Drawable v(Drawable drawable) {
                return a.this.a(i, drawable);
            }

            @Override // com.facebook.drawee.drawable.c
            public Drawable getDrawable() {
                return a.this.getDrawable(i);
            }
        };
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // com.facebook.drawee.drawable.q
    public void a(r rVar) {
        this.psd = rVar;
    }

    @Override // com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        if (this.psd != null) {
            this.psd.f(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void b(RectF rectF) {
        if (this.psd != null) {
            this.psd.b(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        for (int i = 0; i < this.psf.length; i++) {
            Drawable drawable = this.psf[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
        }
    }
}
