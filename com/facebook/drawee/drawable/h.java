package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class h extends g {
    private Matrix IR;
    private int jCC;
    private int jCD;
    private Matrix mMatrix;

    public h(Drawable drawable, Matrix matrix) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jCC = 0;
        this.jCD = 0;
        this.mMatrix = matrix;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable k(Drawable drawable) {
        Drawable k = super.k(drawable);
        cvr();
        return k;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cvq();
        if (this.IR != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.IR);
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
        cvr();
    }

    private void cvq() {
        if (this.jCC != getCurrent().getIntrinsicWidth() || this.jCD != getCurrent().getIntrinsicHeight()) {
            cvr();
        }
    }

    private void cvr() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.jCC = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.jCD = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IR = null;
            return;
        }
        current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.IR = this.mMatrix;
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        super.e(matrix);
        if (this.IR != null) {
            matrix.preConcat(this.IR);
        }
    }
}
