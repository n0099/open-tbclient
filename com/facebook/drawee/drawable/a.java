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
    private p imY;
    private final Drawable[] ina;
    private final c[] inb;
    private final d imZ = new d();
    private final Rect mTmpRect = new Rect();
    private boolean inc = false;
    private boolean ind = false;
    private boolean ine = false;

    public a(Drawable[] drawableArr) {
        com.facebook.common.internal.g.checkNotNull(drawableArr);
        this.ina = drawableArr;
        for (int i = 0; i < this.ina.length; i++) {
            e.a(this.ina[i], this, this);
        }
        this.inb = new c[this.ina.length];
    }

    public int getNumberOfLayers() {
        return this.ina.length;
    }

    @Nullable
    public Drawable getDrawable(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.ina.length);
        return this.ina[i];
    }

    @Nullable
    public Drawable a(int i, @Nullable Drawable drawable) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.ina.length);
        Drawable drawable2 = this.ina[i];
        if (drawable != drawable2) {
            if (drawable != null && this.ine) {
                drawable.mutate();
            }
            e.a(this.ina[i], null, null);
            e.a(drawable, null, null);
            e.a(drawable, this.imZ);
            e.a(drawable, this);
            e.a(drawable, this, this);
            this.ind = false;
            this.ina[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.ina.length; i2++) {
            Drawable drawable = this.ina[i2];
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
        for (int i2 = 0; i2 < this.ina.length; i2++) {
            Drawable drawable = this.ina[i2];
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
        for (int i = 0; i < this.ina.length; i++) {
            Drawable drawable = this.ina[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.ind) {
            this.inc = false;
            for (int i = 0; i < this.ina.length; i++) {
                Drawable drawable = this.ina[i];
                this.inc = (drawable != null && drawable.isStateful()) | this.inc;
            }
            this.ind = true;
        }
        return this.inc;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i = 0; i < this.ina.length; i++) {
            Drawable drawable = this.ina[i];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean z = false;
        for (int i2 = 0; i2 < this.ina.length; i2++) {
            Drawable drawable = this.ina[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.ina.length; i++) {
            Drawable drawable = this.ina[i];
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
        for (int i = 0; i < this.ina.length; i++) {
            Drawable drawable = this.ina[i];
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
        for (int i = 0; i < this.ina.length; i++) {
            Drawable drawable = this.ina[i];
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.ine = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.ina.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.ina.length; i2++) {
            Drawable drawable = this.ina[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.imZ.setAlpha(i);
        for (int i2 = 0; i2 < this.ina.length; i2++) {
            Drawable drawable = this.ina[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.imZ.setColorFilter(colorFilter);
        for (int i = 0; i < this.ina.length; i++) {
            Drawable drawable = this.ina[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.imZ.setDither(z);
        for (int i = 0; i < this.ina.length; i++) {
            Drawable drawable = this.ina[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.imZ.setFilterBitmap(z);
        for (int i = 0; i < this.ina.length; i++) {
            Drawable drawable = this.ina[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (int i = 0; i < this.ina.length; i++) {
            Drawable drawable = this.ina[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
        }
        return visible;
    }

    public c yo(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.inb.length);
        if (this.inb[i] == null) {
            this.inb[i] = yp(i);
        }
        return this.inb[i];
    }

    private c yp(final int i) {
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
        this.imY = pVar;
    }

    @Override // com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        if (this.imY != null) {
            this.imY.e(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.p
    public void b(RectF rectF) {
        if (this.imY != null) {
            this.imY.b(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        for (int i = 0; i < this.ina.length; i++) {
            Drawable drawable = this.ina[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
        }
    }
}
