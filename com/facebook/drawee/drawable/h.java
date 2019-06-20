package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class h extends g {
    private Matrix Gz;
    private int jVv;
    private int jVw;
    private Matrix mMatrix;

    public h(Drawable drawable, Matrix matrix) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jVv = 0;
        this.jVw = 0;
        this.mMatrix = matrix;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        cDo();
        return j;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cDn();
        if (this.Gz != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.Gz);
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
        cDo();
    }

    private void cDn() {
        if (this.jVv != getCurrent().getIntrinsicWidth() || this.jVw != getCurrent().getIntrinsicHeight()) {
            cDo();
        }
    }

    private void cDo() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.jVv = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.jVw = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.Gz = null;
            return;
        }
        current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.Gz = this.mMatrix;
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        super.e(matrix);
        if (this.Gz != null) {
            matrix.preConcat(this.Gz);
        }
    }
}
