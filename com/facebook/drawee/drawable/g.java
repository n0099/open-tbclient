package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class g extends Drawable implements Drawable.Callback, c, q, r {
    private static final Matrix psx = new Matrix();
    protected r psc;
    private final d psd = new d();
    private Drawable psw;

    public g(Drawable drawable) {
        this.psw = drawable;
        e.a(this.psw, this, this);
    }

    public Drawable x(Drawable drawable) {
        Drawable y = y(drawable);
        invalidateSelf();
        return y;
    }

    protected Drawable y(Drawable drawable) {
        Drawable drawable2 = this.psw;
        e.a(drawable2, null, null);
        e.a(drawable, null, null);
        e.a(drawable, this.psd);
        e.d(drawable, this);
        e.a(drawable, this, this);
        this.psw = drawable;
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.psw.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.psd.setAlpha(i);
        this.psw.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.psd.setColorFilter(colorFilter);
        this.psw.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.psd.setDither(z);
        this.psw.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.psd.setFilterBitmap(z);
        this.psw.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        super.setVisible(z, z2);
        return this.psw.setVisible(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.psw.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.psw.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.psw.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.psw.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.psw.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.psw.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.psw.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.psw.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.psw.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.psw.mutate();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.psw;
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
        this.psc = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Matrix matrix) {
        if (this.psc != null) {
            this.psc.f(matrix);
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
        if (this.psc != null) {
            this.psc.b(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        this.psw.setHotspot(f, f2);
    }
}
