package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class h extends g {
    private Matrix IK;
    private int ibQ;
    private int ibR;
    private Matrix mMatrix;

    public h(Drawable drawable, Matrix matrix) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.ibQ = 0;
        this.ibR = 0;
        this.mMatrix = matrix;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        bSI();
        return j;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        bSH();
        if (this.IK != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.IK);
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
        bSI();
    }

    private void bSH() {
        if (this.ibQ != getCurrent().getIntrinsicWidth() || this.ibR != getCurrent().getIntrinsicHeight()) {
            bSI();
        }
    }

    private void bSI() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.ibQ = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.ibR = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IK = null;
            return;
        }
        current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.IK = this.mMatrix;
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        super.e(matrix);
        if (this.IK != null) {
            matrix.preConcat(this.IK);
        }
    }
}
