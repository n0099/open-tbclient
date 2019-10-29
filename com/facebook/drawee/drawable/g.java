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
    private static final Matrix kek = new Matrix();
    protected p kdP;
    private final d kdQ = new d();
    private Drawable kej;

    public g(Drawable drawable) {
        this.kej = drawable;
        e.a(this.kej, this, this);
    }

    public Drawable h(Drawable drawable) {
        Drawable i = i(drawable);
        invalidateSelf();
        return i;
    }

    protected Drawable i(Drawable drawable) {
        Drawable drawable2 = this.kej;
        e.a(drawable2, null, null);
        e.a(drawable, null, null);
        e.a(drawable, this.kdQ);
        e.c(drawable, this);
        e.a(drawable, this, this);
        this.kej = drawable;
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.kej.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.kdQ.setAlpha(i);
        this.kej.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.kdQ.setColorFilter(colorFilter);
        this.kej.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.kdQ.setDither(z);
        this.kej.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.kdQ.setFilterBitmap(z);
        this.kej.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        super.setVisible(z, z2);
        return this.kej.setVisible(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.kej.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.kej.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.kej.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.kej.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.kej.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.kej.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.kej.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.kej.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.kej.mutate();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.kej;
    }

    @Override // com.facebook.drawee.drawable.c
    public Drawable f(Drawable drawable) {
        return h(drawable);
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
        this.kdP = pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Matrix matrix) {
        if (this.kdP != null) {
            this.kdP.d(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.p
    public void d(Matrix matrix) {
        e(matrix);
    }

    @Override // com.facebook.drawee.drawable.p
    public void a(RectF rectF) {
        if (this.kdP != null) {
            this.kdP.a(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        this.kej.setHotspot(f, f2);
    }
}
