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
    private p jCg;
    private final Drawable[] jCi;
    private final c[] jCj;
    private final d jCh = new d();
    private final Rect mTmpRect = new Rect();
    private boolean jCk = false;
    private boolean jCl = false;
    private boolean jCm = false;

    public a(Drawable[] drawableArr) {
        com.facebook.common.internal.g.checkNotNull(drawableArr);
        this.jCi = drawableArr;
        for (int i = 0; i < this.jCi.length; i++) {
            e.a(this.jCi[i], this, this);
        }
        this.jCj = new c[this.jCi.length];
    }

    public int getNumberOfLayers() {
        return this.jCi.length;
    }

    @Nullable
    public Drawable getDrawable(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.jCi.length);
        return this.jCi[i];
    }

    @Nullable
    public Drawable a(int i, @Nullable Drawable drawable) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.jCi.length);
        Drawable drawable2 = this.jCi[i];
        if (drawable != drawable2) {
            if (drawable != null && this.jCm) {
                drawable.mutate();
            }
            e.a(this.jCi[i], null, null);
            e.a(drawable, null, null);
            e.a(drawable, this.jCh);
            e.c(drawable, this);
            e.a(drawable, this, this);
            this.jCl = false;
            this.jCi[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.jCi.length; i2++) {
            Drawable drawable = this.jCi[i2];
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
        for (int i2 = 0; i2 < this.jCi.length; i2++) {
            Drawable drawable = this.jCi[i2];
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
        for (int i = 0; i < this.jCi.length; i++) {
            Drawable drawable = this.jCi[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.jCl) {
            this.jCk = false;
            for (int i = 0; i < this.jCi.length; i++) {
                Drawable drawable = this.jCi[i];
                this.jCk = (drawable != null && drawable.isStateful()) | this.jCk;
            }
            this.jCl = true;
        }
        return this.jCk;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i = 0; i < this.jCi.length; i++) {
            Drawable drawable = this.jCi[i];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean z = false;
        for (int i2 = 0; i2 < this.jCi.length; i2++) {
            Drawable drawable = this.jCi[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.jCi.length; i++) {
            Drawable drawable = this.jCi[i];
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
        for (int i = 0; i < this.jCi.length; i++) {
            Drawable drawable = this.jCi[i];
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
        for (int i = 0; i < this.jCi.length; i++) {
            Drawable drawable = this.jCi[i];
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.jCm = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.jCi.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.jCi.length; i2++) {
            Drawable drawable = this.jCi[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.jCh.setAlpha(i);
        for (int i2 = 0; i2 < this.jCi.length; i2++) {
            Drawable drawable = this.jCi[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.jCh.setColorFilter(colorFilter);
        for (int i = 0; i < this.jCi.length; i++) {
            Drawable drawable = this.jCi[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.jCh.setDither(z);
        for (int i = 0; i < this.jCi.length; i++) {
            Drawable drawable = this.jCi[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.jCh.setFilterBitmap(z);
        for (int i = 0; i < this.jCi.length; i++) {
            Drawable drawable = this.jCi[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (int i = 0; i < this.jCi.length; i++) {
            Drawable drawable = this.jCi[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
        }
        return visible;
    }

    public c BR(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.jCj.length);
        if (this.jCj[i] == null) {
            this.jCj[i] = BS(i);
        }
        return this.jCj[i];
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
        this.jCg = pVar;
    }

    @Override // com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        if (this.jCg != null) {
            this.jCg.e(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.p
    public void b(RectF rectF) {
        if (this.jCg != null) {
            this.jCg.b(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        for (int i = 0; i < this.jCi.length; i++) {
            Drawable drawable = this.jCi[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
        }
    }
}
