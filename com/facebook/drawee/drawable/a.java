package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a extends Drawable implements Drawable.Callback, q, r {
    private r pCm;
    private final Drawable[] pCo;
    private final c[] pCp;
    private final d pCn = new d();
    private final Rect mTmpRect = new Rect();
    private boolean pCq = false;
    private boolean pCr = false;
    private boolean pCs = false;

    public a(Drawable[] drawableArr) {
        com.facebook.common.internal.g.checkNotNull(drawableArr);
        this.pCo = drawableArr;
        for (int i = 0; i < this.pCo.length; i++) {
            e.a(this.pCo[i], this, this);
        }
        this.pCp = new c[this.pCo.length];
    }

    public int eui() {
        return this.pCo.length;
    }

    @Nullable
    public Drawable getDrawable(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.pCo.length);
        return this.pCo[i];
    }

    @Nullable
    public Drawable a(int i, @Nullable Drawable drawable) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.pCo.length);
        Drawable drawable2 = this.pCo[i];
        if (drawable != drawable2) {
            if (drawable != null && this.pCs) {
                drawable.mutate();
            }
            e.a(this.pCo[i], null, null);
            e.a(drawable, null, null);
            e.a(drawable, this.pCn);
            e.d(drawable, this);
            e.a(drawable, this, this);
            this.pCr = false;
            this.pCo[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.pCo.length; i2++) {
            Drawable drawable = this.pCo[i2];
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
        for (int i2 = 0; i2 < this.pCo.length; i2++) {
            Drawable drawable = this.pCo[i2];
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
        for (int i = 0; i < this.pCo.length; i++) {
            Drawable drawable = this.pCo[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.pCr) {
            this.pCq = false;
            for (int i = 0; i < this.pCo.length; i++) {
                Drawable drawable = this.pCo[i];
                this.pCq = (drawable != null && drawable.isStateful()) | this.pCq;
            }
            this.pCr = true;
        }
        return this.pCq;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = z;
            if (i < this.pCo.length) {
                Drawable drawable = this.pCo[i];
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
            if (i2 < this.pCo.length) {
                Drawable drawable = this.pCo[i2];
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
        for (int i = 0; i < this.pCo.length; i++) {
            Drawable drawable = this.pCo[i];
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
        for (int i = 0; i < this.pCo.length; i++) {
            Drawable drawable = this.pCo[i];
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
        for (int i = 0; i < this.pCo.length; i++) {
            Drawable drawable = this.pCo[i];
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.pCs = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.pCo.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.pCo.length; i2++) {
            Drawable drawable = this.pCo[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pCn.setAlpha(i);
        for (int i2 = 0; i2 < this.pCo.length; i2++) {
            Drawable drawable = this.pCo[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.pCn.setColorFilter(colorFilter);
        for (int i = 0; i < this.pCo.length; i++) {
            Drawable drawable = this.pCo[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.pCn.setDither(z);
        for (int i = 0; i < this.pCo.length; i++) {
            Drawable drawable = this.pCo[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.pCn.setFilterBitmap(z);
        for (int i = 0; i < this.pCo.length; i++) {
            Drawable drawable = this.pCo[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (int i = 0; i < this.pCo.length; i++) {
            Drawable drawable = this.pCo[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
        }
        return visible;
    }

    public c Pe(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.pCp.length);
        if (this.pCp[i] == null) {
            this.pCp[i] = Pf(i);
        }
        return this.pCp[i];
    }

    private c Pf(final int i) {
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
        this.pCm = rVar;
    }

    @Override // com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        if (this.pCm != null) {
            this.pCm.f(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void b(RectF rectF) {
        if (this.pCm != null) {
            this.pCm.b(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        for (int i = 0; i < this.pCo.length; i++) {
            Drawable drawable = this.pCo[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
        }
    }
}
