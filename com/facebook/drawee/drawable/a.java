package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class a extends Drawable implements Drawable.Callback, q, r {
    private r pER;
    private final Drawable[] pET;
    private final c[] pEU;
    private final d pES = new d();
    private final Rect mTmpRect = new Rect();
    private boolean pEV = false;
    private boolean pEW = false;
    private boolean pEX = false;

    public a(Drawable[] drawableArr) {
        com.facebook.common.internal.g.checkNotNull(drawableArr);
        this.pET = drawableArr;
        for (int i = 0; i < this.pET.length; i++) {
            e.a(this.pET[i], this, this);
        }
        this.pEU = new c[this.pET.length];
    }

    public int euz() {
        return this.pET.length;
    }

    @Nullable
    public Drawable getDrawable(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.pET.length);
        return this.pET[i];
    }

    @Nullable
    public Drawable a(int i, @Nullable Drawable drawable) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.pET.length);
        Drawable drawable2 = this.pET[i];
        if (drawable != drawable2) {
            if (drawable != null && this.pEX) {
                drawable.mutate();
            }
            e.a(this.pET[i], null, null);
            e.a(drawable, null, null);
            e.a(drawable, this.pES);
            e.d(drawable, this);
            e.a(drawable, this, this);
            this.pEW = false;
            this.pET[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.pET.length; i2++) {
            Drawable drawable = this.pET[i2];
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
        for (int i2 = 0; i2 < this.pET.length; i2++) {
            Drawable drawable = this.pET[i2];
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
        for (int i = 0; i < this.pET.length; i++) {
            Drawable drawable = this.pET[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.pEW) {
            this.pEV = false;
            for (int i = 0; i < this.pET.length; i++) {
                Drawable drawable = this.pET[i];
                this.pEV = (drawable != null && drawable.isStateful()) | this.pEV;
            }
            this.pEW = true;
        }
        return this.pEV;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = z;
            if (i < this.pET.length) {
                Drawable drawable = this.pET[i];
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
            if (i2 < this.pET.length) {
                Drawable drawable = this.pET[i2];
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
        for (int i = 0; i < this.pET.length; i++) {
            Drawable drawable = this.pET[i];
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
        for (int i = 0; i < this.pET.length; i++) {
            Drawable drawable = this.pET[i];
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
        for (int i = 0; i < this.pET.length; i++) {
            Drawable drawable = this.pET[i];
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.pEX = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.pET.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.pET.length; i2++) {
            Drawable drawable = this.pET[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pES.setAlpha(i);
        for (int i2 = 0; i2 < this.pET.length; i2++) {
            Drawable drawable = this.pET[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.pES.setColorFilter(colorFilter);
        for (int i = 0; i < this.pET.length; i++) {
            Drawable drawable = this.pET[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.pES.setDither(z);
        for (int i = 0; i < this.pET.length; i++) {
            Drawable drawable = this.pET[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.pES.setFilterBitmap(z);
        for (int i = 0; i < this.pET.length; i++) {
            Drawable drawable = this.pET[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        for (int i = 0; i < this.pET.length; i++) {
            Drawable drawable = this.pET[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
        }
        return visible;
    }

    public c Pj(int i) {
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i < this.pEU.length);
        if (this.pEU[i] == null) {
            this.pEU[i] = Pk(i);
        }
        return this.pEU[i];
    }

    private c Pk(final int i) {
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
        this.pER = rVar;
    }

    @Override // com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        if (this.pER != null) {
            this.pER.f(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void b(RectF rectF) {
        if (this.pER != null) {
            this.pER.b(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        for (int i = 0; i < this.pET.length; i++) {
            Drawable drawable = this.pET[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
        }
    }
}
