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
    private r mTransformCallback;
    private final Drawable[] nNS;
    private final c[] nNT;
    private final d mDrawableProperties = new d();
    private final Rect mTmpRect = new Rect();
    private boolean nNU = false;
    private boolean nNV = false;
    private boolean nNW = false;

    public a(Drawable[] drawableArr) {
        com.facebook.common.internal.g.checkNotNull(drawableArr);
        this.nNS = drawableArr;
        for (int i = 0; i < this.nNS.length; i++) {
            e.a(this.nNS[i], this, this);
        }
        this.nNT = new c[this.nNS.length];
    }

    public int dXZ() {
        return this.nNS.length;
    }

    @Nullable
    public Drawable getDrawable(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.nNS.length);
        return this.nNS[i];
    }

    @Nullable
    public Drawable a(int i, @Nullable Drawable drawable) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.nNS.length);
        Drawable drawable2 = this.nNS[i];
        if (drawable != drawable2) {
            if (drawable != null && this.nNW) {
                drawable.mutate();
            }
            e.a(this.nNS[i], null, null);
            e.a(drawable, null, null);
            e.a(drawable, this.mDrawableProperties);
            e.d(drawable, this);
            e.a(drawable, this, this);
            this.nNV = false;
            this.nNS[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.nNS.length; i2++) {
            Drawable drawable = this.nNS[i2];
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
        for (int i2 = 0; i2 < this.nNS.length; i2++) {
            Drawable drawable = this.nNS[i2];
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
        for (int i = 0; i < this.nNS.length; i++) {
            Drawable drawable = this.nNS[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.nNV) {
            this.nNU = false;
            for (int i = 0; i < this.nNS.length; i++) {
                Drawable drawable = this.nNS[i];
                this.nNU = (drawable != null && drawable.isStateful()) | this.nNU;
            }
            this.nNV = true;
        }
        return this.nNU;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i = 0; i < this.nNS.length; i++) {
            Drawable drawable = this.nNS[i];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean z = false;
        for (int i2 = 0; i2 < this.nNS.length; i2++) {
            Drawable drawable = this.nNS[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.nNS.length; i++) {
            Drawable drawable = this.nNS[i];
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
        for (int i = 0; i < this.nNS.length; i++) {
            Drawable drawable = this.nNS[i];
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
        for (int i = 0; i < this.nNS.length; i++) {
            Drawable drawable = this.nNS[i];
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.nNW = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.nNS.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.nNS.length; i2++) {
            Drawable drawable = this.nNS[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mDrawableProperties.setAlpha(i);
        for (int i2 = 0; i2 < this.nNS.length; i2++) {
            Drawable drawable = this.nNS[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawableProperties.setColorFilter(colorFilter);
        for (int i = 0; i < this.nNS.length; i++) {
            Drawable drawable = this.nNS[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.mDrawableProperties.setDither(z);
        for (int i = 0; i < this.nNS.length; i++) {
            Drawable drawable = this.nNS[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mDrawableProperties.setFilterBitmap(z);
        for (int i = 0; i < this.nNS.length; i++) {
            Drawable drawable = this.nNS[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (int i = 0; i < this.nNS.length; i++) {
            Drawable drawable = this.nNS[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
        }
        return visible;
    }

    public c Mp(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.nNT.length);
        if (this.nNT[i] == null) {
            this.nNT[i] = Mq(i);
        }
        return this.nNT[i];
    }

    private c Mq(final int i) {
        return new c() { // from class: com.facebook.drawee.drawable.a.1
            @Override // com.facebook.drawee.drawable.c
            public Drawable setDrawable(Drawable drawable) {
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
    public void setTransformCallback(r rVar) {
        this.mTransformCallback = rVar;
    }

    @Override // com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void getRootBounds(RectF rectF) {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getRootBounds(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        for (int i = 0; i < this.nNS.length; i++) {
            Drawable drawable = this.nNS[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
        }
    }
}
