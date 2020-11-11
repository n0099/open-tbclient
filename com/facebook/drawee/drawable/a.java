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
    private final Drawable[] oOE;
    private final c[] oOF;
    private final d mDrawableProperties = new d();
    private final Rect mTmpRect = new Rect();
    private boolean oOG = false;
    private boolean oOH = false;
    private boolean oOI = false;

    public a(Drawable[] drawableArr) {
        com.facebook.common.internal.g.checkNotNull(drawableArr);
        this.oOE = drawableArr;
        for (int i = 0; i < this.oOE.length; i++) {
            e.a(this.oOE[i], this, this);
        }
        this.oOF = new c[this.oOE.length];
    }

    public int elM() {
        return this.oOE.length;
    }

    @Nullable
    public Drawable getDrawable(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.oOE.length);
        return this.oOE[i];
    }

    @Nullable
    public Drawable a(int i, @Nullable Drawable drawable) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.oOE.length);
        Drawable drawable2 = this.oOE[i];
        if (drawable != drawable2) {
            if (drawable != null && this.oOI) {
                drawable.mutate();
            }
            e.a(this.oOE[i], null, null);
            e.a(drawable, null, null);
            e.a(drawable, this.mDrawableProperties);
            e.d(drawable, this);
            e.a(drawable, this, this);
            this.oOH = false;
            this.oOE[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.oOE.length; i2++) {
            Drawable drawable = this.oOE[i2];
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
        for (int i2 = 0; i2 < this.oOE.length; i2++) {
            Drawable drawable = this.oOE[i2];
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
        for (int i = 0; i < this.oOE.length; i++) {
            Drawable drawable = this.oOE[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.oOH) {
            this.oOG = false;
            for (int i = 0; i < this.oOE.length; i++) {
                Drawable drawable = this.oOE[i];
                this.oOG = (drawable != null && drawable.isStateful()) | this.oOG;
            }
            this.oOH = true;
        }
        return this.oOG;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i = 0; i < this.oOE.length; i++) {
            Drawable drawable = this.oOE[i];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean z = false;
        for (int i2 = 0; i2 < this.oOE.length; i2++) {
            Drawable drawable = this.oOE[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.oOE.length; i++) {
            Drawable drawable = this.oOE[i];
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
        for (int i = 0; i < this.oOE.length; i++) {
            Drawable drawable = this.oOE[i];
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
        for (int i = 0; i < this.oOE.length; i++) {
            Drawable drawable = this.oOE[i];
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.oOI = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.oOE.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.oOE.length; i2++) {
            Drawable drawable = this.oOE[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mDrawableProperties.setAlpha(i);
        for (int i2 = 0; i2 < this.oOE.length; i2++) {
            Drawable drawable = this.oOE[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawableProperties.setColorFilter(colorFilter);
        for (int i = 0; i < this.oOE.length; i++) {
            Drawable drawable = this.oOE[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.mDrawableProperties.setDither(z);
        for (int i = 0; i < this.oOE.length; i++) {
            Drawable drawable = this.oOE[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mDrawableProperties.setFilterBitmap(z);
        for (int i = 0; i < this.oOE.length; i++) {
            Drawable drawable = this.oOE[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (int i = 0; i < this.oOE.length; i++) {
            Drawable drawable = this.oOE[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
        }
        return visible;
    }

    public c OB(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.oOF.length);
        if (this.oOF[i] == null) {
            this.oOF[i] = OC(i);
        }
        return this.oOF[i];
    }

    private c OC(final int i) {
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
        for (int i = 0; i < this.oOE.length; i++) {
            Drawable drawable = this.oOE[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
        }
    }
}
