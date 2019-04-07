package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a extends Drawable implements Drawable.Callback, o, p {
    private p jCf;
    private final Drawable[] jCh;
    private final c[] jCi;
    private final d jCg = new d();
    private final Rect mTmpRect = new Rect();
    private boolean jCj = false;
    private boolean jCk = false;
    private boolean jCl = false;

    public a(Drawable[] drawableArr) {
        com.facebook.common.internal.g.checkNotNull(drawableArr);
        this.jCh = drawableArr;
        for (int i = 0; i < this.jCh.length; i++) {
            e.a(this.jCh[i], this, this);
        }
        this.jCi = new c[this.jCh.length];
    }

    public int getNumberOfLayers() {
        return this.jCh.length;
    }

    @Nullable
    public Drawable getDrawable(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.jCh.length);
        return this.jCh[i];
    }

    @Nullable
    public Drawable a(int i, @Nullable Drawable drawable) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.jCh.length);
        Drawable drawable2 = this.jCh[i];
        if (drawable != drawable2) {
            if (drawable != null && this.jCl) {
                drawable.mutate();
            }
            e.a(this.jCh[i], null, null);
            e.a(drawable, null, null);
            e.a(drawable, this.jCg);
            e.c(drawable, this);
            e.a(drawable, this, this);
            this.jCk = false;
            this.jCh[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.jCh.length; i2++) {
            Drawable drawable = this.jCh[i2];
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
        for (int i2 = 0; i2 < this.jCh.length; i2++) {
            Drawable drawable = this.jCh[i2];
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
        for (int i = 0; i < this.jCh.length; i++) {
            Drawable drawable = this.jCh[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.jCk) {
            this.jCj = false;
            for (int i = 0; i < this.jCh.length; i++) {
                Drawable drawable = this.jCh[i];
                this.jCj = (drawable != null && drawable.isStateful()) | this.jCj;
            }
            this.jCk = true;
        }
        return this.jCj;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i = 0; i < this.jCh.length; i++) {
            Drawable drawable = this.jCh[i];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean z = false;
        for (int i2 = 0; i2 < this.jCh.length; i2++) {
            Drawable drawable = this.jCh[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.jCh.length; i++) {
            Drawable drawable = this.jCh[i];
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
        for (int i = 0; i < this.jCh.length; i++) {
            Drawable drawable = this.jCh[i];
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
        for (int i = 0; i < this.jCh.length; i++) {
            Drawable drawable = this.jCh[i];
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.jCl = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.jCh.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.jCh.length; i2++) {
            Drawable drawable = this.jCh[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.jCg.setAlpha(i);
        for (int i2 = 0; i2 < this.jCh.length; i2++) {
            Drawable drawable = this.jCh[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.jCg.setColorFilter(colorFilter);
        for (int i = 0; i < this.jCh.length; i++) {
            Drawable drawable = this.jCh[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.jCg.setDither(z);
        for (int i = 0; i < this.jCh.length; i++) {
            Drawable drawable = this.jCh[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.jCg.setFilterBitmap(z);
        for (int i = 0; i < this.jCh.length; i++) {
            Drawable drawable = this.jCh[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (int i = 0; i < this.jCh.length; i++) {
            Drawable drawable = this.jCh[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
        }
        return visible;
    }

    public c BR(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.jCi.length);
        if (this.jCi[i] == null) {
            this.jCi[i] = BS(i);
        }
        return this.jCi[i];
    }

    private c BS(final int i) {
        return new c() { // from class: com.facebook.drawee.drawable.a.1
            @Override // com.facebook.drawee.drawable.c
            public Drawable i(Drawable drawable) {
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

    @Override // com.facebook.drawee.drawable.o
    public void a(p pVar) {
        this.jCf = pVar;
    }

    @Override // com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        if (this.jCf != null) {
            this.jCf.e(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.p
    public void b(RectF rectF) {
        if (this.jCf != null) {
            this.jCf.b(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        for (int i = 0; i < this.jCh.length; i++) {
            Drawable drawable = this.jCh[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
        }
    }
}
