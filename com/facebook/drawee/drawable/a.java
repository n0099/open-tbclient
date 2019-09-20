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
    private p kfH;
    private final Drawable[] kfJ;
    private final c[] kfK;
    private final d kfI = new d();
    private final Rect mTmpRect = new Rect();
    private boolean kfL = false;
    private boolean kfM = false;
    private boolean kfN = false;

    public a(Drawable[] drawableArr) {
        com.facebook.common.internal.g.checkNotNull(drawableArr);
        this.kfJ = drawableArr;
        for (int i = 0; i < this.kfJ.length; i++) {
            e.a(this.kfJ[i], this, this);
        }
        this.kfK = new c[this.kfJ.length];
    }

    public int cHq() {
        return this.kfJ.length;
    }

    @Nullable
    public Drawable getDrawable(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.kfJ.length);
        return this.kfJ[i];
    }

    @Nullable
    public Drawable a(int i, @Nullable Drawable drawable) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.kfJ.length);
        Drawable drawable2 = this.kfJ[i];
        if (drawable != drawable2) {
            if (drawable != null && this.kfN) {
                drawable.mutate();
            }
            e.a(this.kfJ[i], null, null);
            e.a(drawable, null, null);
            e.a(drawable, this.kfI);
            e.c(drawable, this);
            e.a(drawable, this, this);
            this.kfM = false;
            this.kfJ[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.kfJ.length; i2++) {
            Drawable drawable = this.kfJ[i2];
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
        for (int i2 = 0; i2 < this.kfJ.length; i2++) {
            Drawable drawable = this.kfJ[i2];
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
        for (int i = 0; i < this.kfJ.length; i++) {
            Drawable drawable = this.kfJ[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.kfM) {
            this.kfL = false;
            for (int i = 0; i < this.kfJ.length; i++) {
                Drawable drawable = this.kfJ[i];
                this.kfL = (drawable != null && drawable.isStateful()) | this.kfL;
            }
            this.kfM = true;
        }
        return this.kfL;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i = 0; i < this.kfJ.length; i++) {
            Drawable drawable = this.kfJ[i];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean z = false;
        for (int i2 = 0; i2 < this.kfJ.length; i2++) {
            Drawable drawable = this.kfJ[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.kfJ.length; i++) {
            Drawable drawable = this.kfJ[i];
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
        for (int i = 0; i < this.kfJ.length; i++) {
            Drawable drawable = this.kfJ[i];
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
        for (int i = 0; i < this.kfJ.length; i++) {
            Drawable drawable = this.kfJ[i];
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.kfN = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.kfJ.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.kfJ.length; i2++) {
            Drawable drawable = this.kfJ[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.kfI.setAlpha(i);
        for (int i2 = 0; i2 < this.kfJ.length; i2++) {
            Drawable drawable = this.kfJ[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.kfI.setColorFilter(colorFilter);
        for (int i = 0; i < this.kfJ.length; i++) {
            Drawable drawable = this.kfJ[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.kfI.setDither(z);
        for (int i = 0; i < this.kfJ.length; i++) {
            Drawable drawable = this.kfJ[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.kfI.setFilterBitmap(z);
        for (int i = 0; i < this.kfJ.length; i++) {
            Drawable drawable = this.kfJ[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (int i = 0; i < this.kfJ.length; i++) {
            Drawable drawable = this.kfJ[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
        }
        return visible;
    }

    public c DI(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.kfK.length);
        if (this.kfK[i] == null) {
            this.kfK[i] = DJ(i);
        }
        return this.kfK[i];
    }

    private c DJ(final int i) {
        return new c() { // from class: com.facebook.drawee.drawable.a.1
            @Override // com.facebook.drawee.drawable.c
            public Drawable h(Drawable drawable) {
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
        this.kfH = pVar;
    }

    @Override // com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        if (this.kfH != null) {
            this.kfH.e(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.p
    public void b(RectF rectF) {
        if (this.kfH != null) {
            this.kfH.b(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        for (int i = 0; i < this.kfJ.length; i++) {
            Drawable drawable = this.kfJ[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
        }
    }
}
