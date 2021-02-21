package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* loaded from: classes15.dex */
public class h extends g {
    private Matrix mDrawMatrix;
    private Matrix mMatrix;
    private int pDi;
    private int pDj;

    @Override // com.facebook.drawee.drawable.g
    public Drawable x(Drawable drawable) {
        Drawable x = super.x(drawable);
        euz();
        return x;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        euy();
        if (this.mDrawMatrix != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        euz();
    }

    private void euy() {
        if (this.pDi != getCurrent().getIntrinsicWidth() || this.pDj != getCurrent().getIntrinsicHeight()) {
            euz();
        }
    }

    private void euz() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.pDi = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.pDj = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
            return;
        }
        current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.mDrawMatrix = this.mMatrix;
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        super.f(matrix);
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
