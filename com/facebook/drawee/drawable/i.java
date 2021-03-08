package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes4.dex */
public class i extends g {
    private final Matrix mTempMatrix;
    private final RectF mTempRectF;
    final Matrix pFp;
    private int pFq;
    private int pFr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Drawable drawable, int i, int i2) {
        super(drawable);
        boolean z = true;
        this.mTempMatrix = new Matrix();
        this.mTempRectF = new RectF();
        com.facebook.common.internal.g.checkArgument(i % 90 == 0);
        com.facebook.common.internal.g.checkArgument((i2 < 0 || i2 > 8) ? false : z);
        this.pFp = new Matrix();
        this.pFq = i;
        this.pFr = i2;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.pFq <= 0 && (this.pFr == 0 || this.pFr == 1)) {
            super.draw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.concat(this.pFp);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (this.pFr == 5 || this.pFr == 7 || this.pFq % 180 != 0) ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (this.pFr == 5 || this.pFr == 7 || this.pFq % 180 != 0) ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable current = getCurrent();
        if (this.pFq > 0 || (this.pFr != 0 && this.pFr != 1)) {
            switch (this.pFr) {
                case 2:
                    this.pFp.setScale(-1.0f, 1.0f);
                    break;
                case 3:
                case 6:
                default:
                    this.pFp.setRotate(this.pFq, rect.centerX(), rect.centerY());
                    break;
                case 4:
                    this.pFp.setScale(1.0f, -1.0f);
                    break;
                case 5:
                    this.pFp.setRotate(270.0f, rect.centerX(), rect.centerY());
                    this.pFp.postScale(1.0f, -1.0f);
                    break;
                case 7:
                    this.pFp.setRotate(270.0f, rect.centerX(), rect.centerY());
                    this.pFp.postScale(-1.0f, 1.0f);
                    break;
            }
            this.mTempMatrix.reset();
            this.pFp.invert(this.mTempMatrix);
            this.mTempRectF.set(rect);
            this.mTempMatrix.mapRect(this.mTempRectF);
            current.setBounds((int) this.mTempRectF.left, (int) this.mTempRectF.top, (int) this.mTempRectF.right, (int) this.mTempRectF.bottom);
            return;
        }
        current.setBounds(rect);
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        g(matrix);
        if (!this.pFp.isIdentity()) {
            matrix.preConcat(this.pFp);
        }
    }
}
