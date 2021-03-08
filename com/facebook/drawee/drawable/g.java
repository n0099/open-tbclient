package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes4.dex */
public class g extends Drawable implements Drawable.Callback, c, q, r {
    private static final Matrix pFm = new Matrix();
    protected r pER;
    private final d pES = new d();
    private Drawable pFl;

    public g(Drawable drawable) {
        this.pFl = drawable;
        e.a(this.pFl, this, this);
    }

    public Drawable x(Drawable drawable) {
        Drawable y = y(drawable);
        invalidateSelf();
        return y;
    }

    protected Drawable y(Drawable drawable) {
        Drawable drawable2 = this.pFl;
        e.a(drawable2, null, null);
        e.a(drawable, null, null);
        e.a(drawable, this.pES);
        e.d(drawable, this);
        e.a(drawable, this, this);
        this.pFl = drawable;
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.pFl.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pES.setAlpha(i);
        this.pFl.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.pES.setColorFilter(colorFilter);
        this.pFl.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.pES.setDither(z);
        this.pFl.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.pES.setFilterBitmap(z);
        this.pFl.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        super.setVisible(z, z2);
        return this.pFl.setVisible(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.pFl.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.pFl.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.pFl.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.pFl.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.pFl.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.pFl.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pFl.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pFl.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.pFl.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.pFl.mutate();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.pFl;
    }

    @Override // com.facebook.drawee.drawable.c
    public Drawable v(Drawable drawable) {
        return x(drawable);
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

    @Override // com.facebook.drawee.drawable.q
    public void a(r rVar) {
        this.pER = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Matrix matrix) {
        if (this.pER != null) {
            this.pER.f(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        g(matrix);
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
        this.pFl.setHotspot(f, f2);
    }
}
