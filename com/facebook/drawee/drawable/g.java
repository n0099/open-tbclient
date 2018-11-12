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
    private static final Matrix ibP = new Matrix();
    private Drawable ibO;
    protected p ibt;
    private final d ibu = new d();

    public g(Drawable drawable) {
        this.ibO = drawable;
        e.a(this.ibO, this, this);
    }

    public Drawable j(Drawable drawable) {
        Drawable k = k(drawable);
        invalidateSelf();
        return k;
    }

    protected Drawable k(Drawable drawable) {
        Drawable drawable2 = this.ibO;
        e.a(drawable2, null, null);
        e.a(drawable, null, null);
        e.a(drawable, this.ibu);
        e.a(drawable, this);
        e.a(drawable, this, this);
        this.ibO = drawable;
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.ibO.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.ibu.setAlpha(i);
        this.ibO.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.ibu.setColorFilter(colorFilter);
        this.ibO.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.ibu.setDither(z);
        this.ibO.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.ibu.setFilterBitmap(z);
        this.ibO.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        super.setVisible(z, z2);
        return this.ibO.setVisible(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.ibO.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.ibO.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.ibO.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.ibO.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.ibO.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.ibO.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.ibO.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.ibO.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.ibO.mutate();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.ibO;
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
        this.ibt = pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Matrix matrix) {
        if (this.ibt != null) {
            this.ibt.e(matrix);
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
        if (this.ibt != null) {
            this.ibt.b(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        this.ibO.setHotspot(f, f2);
    }
}
