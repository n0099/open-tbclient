package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes15.dex */
public class g extends Drawable implements Drawable.Callback, c, q, r {
    private static final Matrix pDh = new Matrix();
    protected r pCM;
    private final d pCN = new d();
    private Drawable pDg;

    public g(Drawable drawable) {
        this.pDg = drawable;
        e.a(this.pDg, this, this);
    }

    public Drawable x(Drawable drawable) {
        Drawable y = y(drawable);
        invalidateSelf();
        return y;
    }

    protected Drawable y(Drawable drawable) {
        Drawable drawable2 = this.pDg;
        e.a(drawable2, null, null);
        e.a(drawable, null, null);
        e.a(drawable, this.pCN);
        e.d(drawable, this);
        e.a(drawable, this, this);
        this.pDg = drawable;
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.pDg.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pCN.setAlpha(i);
        this.pDg.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.pCN.setColorFilter(colorFilter);
        this.pDg.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.pCN.setDither(z);
        this.pDg.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.pCN.setFilterBitmap(z);
        this.pDg.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        super.setVisible(z, z2);
        return this.pDg.setVisible(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.pDg.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.pDg.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.pDg.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.pDg.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.pDg.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.pDg.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pDg.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pDg.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.pDg.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.pDg.mutate();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.pDg;
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
        this.pCM = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Matrix matrix) {
        if (this.pCM != null) {
            this.pCM.f(matrix);
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
        if (this.pCM != null) {
            this.pCM.b(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        this.pDg.setHotspot(f, f2);
    }
}
