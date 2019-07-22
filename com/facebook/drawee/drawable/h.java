package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class h extends g {
    private Matrix GH;
    private int kcA;
    private int kcz;
    private Matrix mMatrix;

    public h(Drawable drawable, Matrix matrix) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.kcz = 0;
        this.kcA = 0;
        this.mMatrix = matrix;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        cGq();
        return j;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cGp();
        if (this.GH != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.GH);
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
        cGq();
    }

    private void cGp() {
        if (this.kcz != getCurrent().getIntrinsicWidth() || this.kcA != getCurrent().getIntrinsicHeight()) {
            cGq();
        }
    }

    private void cGq() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.kcz = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.kcA = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.GH = null;
            return;
        }
        current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.GH = this.mMatrix;
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        super.e(matrix);
        if (this.GH != null) {
            matrix.preConcat(this.GH);
        }
    }
}
