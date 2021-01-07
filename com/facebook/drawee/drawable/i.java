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
    final Matrix pxc;
    private int pxd;
    private int pxe;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Drawable drawable, int i, int i2) {
        super(drawable);
        boolean z = true;
        this.mTempMatrix = new Matrix();
        this.mTempRectF = new RectF();
        com.facebook.common.internal.g.checkArgument(i % 90 == 0);
        com.facebook.common.internal.g.checkArgument((i2 < 0 || i2 > 8) ? false : z);
        this.pxc = new Matrix();
        this.pxd = i;
        this.pxe = i2;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.pxd <= 0 && (this.pxe == 0 || this.pxe == 1)) {
            super.draw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.concat(this.pxc);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (this.pxe == 5 || this.pxe == 7 || this.pxd % 180 != 0) ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (this.pxe == 5 || this.pxe == 7 || this.pxd % 180 != 0) ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable current = getCurrent();
        if (this.pxd > 0 || (this.pxe != 0 && this.pxe != 1)) {
            switch (this.pxe) {
                case 2:
                    this.pxc.setScale(-1.0f, 1.0f);
                    break;
                case 3:
                case 6:
                default:
                    this.pxc.setRotate(this.pxd, rect.centerX(), rect.centerY());
                    break;
                case 4:
                    this.pxc.setScale(1.0f, -1.0f);
                    break;
                case 5:
                    this.pxc.setRotate(270.0f, rect.centerX(), rect.centerY());
                    this.pxc.postScale(1.0f, -1.0f);
                    break;
                case 7:
                    this.pxc.setRotate(270.0f, rect.centerX(), rect.centerY());
                    this.pxc.postScale(-1.0f, 1.0f);
                    break;
            }
            this.mTempMatrix.reset();
            this.pxc.invert(this.mTempMatrix);
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
        if (!this.pxc.isIdentity()) {
            matrix.preConcat(this.pxc);
        }
    }
}
