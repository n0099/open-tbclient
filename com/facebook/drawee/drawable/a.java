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
    private p kcY;
    private final Drawable[] kda;
    private final c[] kdb;
    private final d kcZ = new d();
    private final Rect mTmpRect = new Rect();
    private boolean kdc = false;
    private boolean kdd = false;
    private boolean kde = false;

    public a(Drawable[] drawableArr) {
        com.facebook.common.internal.g.checkNotNull(drawableArr);
        this.kda = drawableArr;
        for (int i = 0; i < this.kda.length; i++) {
            e.a(this.kda[i], this, this);
        }
        this.kdb = new c[this.kda.length];
    }

    public int cEm() {
        return this.kda.length;
    }

    @Nullable
    public Drawable getDrawable(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.kda.length);
        return this.kda[i];
    }

    @Nullable
    public Drawable a(int i, @Nullable Drawable drawable) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.kda.length);
        Drawable drawable2 = this.kda[i];
        if (drawable != drawable2) {
            if (drawable != null && this.kde) {
                drawable.mutate();
            }
            e.a(this.kda[i], null, null);
            e.a(drawable, null, null);
            e.a(drawable, this.kcZ);
            e.c(drawable, this);
            e.a(drawable, this, this);
            this.kdd = false;
            this.kda[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.kda.length; i2++) {
            Drawable drawable = this.kda[i2];
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
        for (int i2 = 0; i2 < this.kda.length; i2++) {
            Drawable drawable = this.kda[i2];
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
        for (int i = 0; i < this.kda.length; i++) {
            Drawable drawable = this.kda[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.kdd) {
            this.kdc = false;
            for (int i = 0; i < this.kda.length; i++) {
                Drawable drawable = this.kda[i];
                this.kdc = (drawable != null && drawable.isStateful()) | this.kdc;
            }
            this.kdd = true;
        }
        return this.kdc;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i = 0; i < this.kda.length; i++) {
            Drawable drawable = this.kda[i];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean z = false;
        for (int i2 = 0; i2 < this.kda.length; i2++) {
            Drawable drawable = this.kda[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.kda.length; i++) {
            Drawable drawable = this.kda[i];
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
        for (int i = 0; i < this.kda.length; i++) {
            Drawable drawable = this.kda[i];
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
        for (int i = 0; i < this.kda.length; i++) {
            Drawable drawable = this.kda[i];
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.kde = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.kda.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.kda.length; i2++) {
            Drawable drawable = this.kda[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.kcZ.setAlpha(i);
        for (int i2 = 0; i2 < this.kda.length; i2++) {
            Drawable drawable = this.kda[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.kcZ.setColorFilter(colorFilter);
        for (int i = 0; i < this.kda.length; i++) {
            Drawable drawable = this.kda[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.kcZ.setDither(z);
        for (int i = 0; i < this.kda.length; i++) {
            Drawable drawable = this.kda[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.kcZ.setFilterBitmap(z);
        for (int i = 0; i < this.kda.length; i++) {
            Drawable drawable = this.kda[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (int i = 0; i < this.kda.length; i++) {
            Drawable drawable = this.kda[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
        }
        return visible;
    }

    public c Cd(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.kdb.length);
        if (this.kdb[i] == null) {
            this.kdb[i] = Ce(i);
        }
        return this.kdb[i];
    }

    private c Ce(final int i) {
        return new c() { // from class: com.facebook.drawee.drawable.a.1
            @Override // com.facebook.drawee.drawable.c
            public Drawable g(Drawable drawable) {
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
        this.kcY = pVar;
    }

    @Override // com.facebook.drawee.drawable.p
    public void d(Matrix matrix) {
        if (this.kcY != null) {
            this.kcY.d(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.p
    public void a(RectF rectF) {
        if (this.kcY != null) {
            this.kcY.a(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        for (int i = 0; i < this.kda.length; i++) {
            Drawable drawable = this.kda[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
        }
    }
}
