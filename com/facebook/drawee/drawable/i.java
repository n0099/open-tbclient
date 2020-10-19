package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes15.dex */
public class i extends g {
    private final Matrix mTempMatrix;
    private final RectF mTempRectF;
    final Matrix nOn;
    private int nOo;
    private int nOp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Drawable drawable, int i, int i2) {
        super(drawable);
        boolean z = true;
        this.mTempMatrix = new Matrix();
        this.mTempRectF = new RectF();
        com.facebook.common.internal.g.checkArgument(i % 90 == 0);
        com.facebook.common.internal.g.checkArgument((i2 < 0 || i2 > 8) ? false : z);
        this.nOn = new Matrix();
        this.nOo = i;
        this.nOp = i2;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.nOo <= 0 && (this.nOp == 0 || this.nOp == 1)) {
            super.draw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.concat(this.nOn);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (this.nOp == 5 || this.nOp == 7 || this.nOo % 180 != 0) ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (this.nOp == 5 || this.nOp == 7 || this.nOo % 180 != 0) ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable current = getCurrent();
        if (this.nOo > 0 || (this.nOp != 0 && this.nOp != 1)) {
            switch (this.nOp) {
                case 2:
                    this.nOn.setScale(-1.0f, 1.0f);
                    break;
                case 3:
                case 6:
                default:
                    this.nOn.setRotate(this.nOo, rect.centerX(), rect.centerY());
                    break;
                case 4:
                    this.nOn.setScale(1.0f, -1.0f);
                    break;
                case 5:
                    this.nOn.setRotate(270.0f, rect.centerX(), rect.centerY());
                    this.nOn.postScale(1.0f, -1.0f);
                    break;
                case 7:
                    this.nOn.setRotate(270.0f, rect.centerX(), rect.centerY());
                    this.nOn.postScale(-1.0f, 1.0f);
                    break;
            }
            this.mTempMatrix.reset();
            this.nOn.invert(this.mTempMatrix);
            this.mTempRectF.set(rect);
            this.mTempMatrix.mapRect(this.mTempRectF);
            current.setBounds((int) this.mTempRectF.left, (int) this.mTempRectF.top, (int) this.mTempRectF.right, (int) this.mTempRectF.bottom);
            return;
        }
        current.setBounds(rect);
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        if (!this.nOn.isIdentity()) {
            matrix.preConcat(this.nOn);
        }
    }
}
