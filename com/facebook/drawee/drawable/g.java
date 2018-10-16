package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class g extends Drawable implements Drawable.Callback, c, o, p {
    private static final Matrix iae = new Matrix();
    protected p hZI;
    private final d hZJ = new d();
    private Drawable iad;

    public g(Drawable drawable) {
        this.iad = drawable;
        e.a(this.iad, this, this);
    }

    public Drawable j(Drawable drawable) {
        Drawable k = k(drawable);
        invalidateSelf();
        return k;
    }

    protected Drawable k(Drawable drawable) {
        Drawable drawable2 = this.iad;
        e.a(drawable2, null, null);
        e.a(drawable, null, null);
        e.a(drawable, this.hZJ);
        e.a(drawable, this);
        e.a(drawable, this, this);
        this.iad = drawable;
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.iad.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.hZJ.setAlpha(i);
        this.iad.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.hZJ.setColorFilter(colorFilter);
        this.iad.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.hZJ.setDither(z);
        this.iad.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.hZJ.setFilterBitmap(z);
        this.iad.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        super.setVisible(z, z2);
        return this.iad.setVisible(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.iad.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.iad.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.iad.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.iad.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.iad.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.iad.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.iad.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.iad.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.iad.mutate();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.iad;
    }

    @Override // com.facebook.drawee.drawable.c
    public Drawable h(Drawable drawable) {
        return j(drawable);
    }

    @Override // com.facebook.drawee.drawable.c
    public Drawable getDrawable() {
        return getCurrent();
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
        this.hZI = pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Matrix matrix) {
        if (this.hZI != null) {
            this.hZI.e(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
    }

    @Override // com.facebook.drawee.drawable.p
    public void b(RectF rectF) {
        if (this.hZI != null) {
            this.hZI.b(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        this.iad.setHotspot(f, f2);
    }
}
