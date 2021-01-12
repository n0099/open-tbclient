package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes3.dex */
public class i extends g {
    private final Matrix mTempMatrix;
    private final RectF mTempRectF;
    final Matrix psA;
    private int psB;
    private int psC;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Drawable drawable, int i, int i2) {
        super(drawable);
        boolean z = true;
        this.mTempMatrix = new Matrix();
        this.mTempRectF = new RectF();
        com.facebook.common.internal.g.checkArgument(i % 90 == 0);
        com.facebook.common.internal.g.checkArgument((i2 < 0 || i2 > 8) ? false : z);
        this.psA = new Matrix();
        this.psB = i;
        this.psC = i2;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.psB <= 0 && (this.psC == 0 || this.psC == 1)) {
            super.draw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.concat(this.psA);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (this.psC == 5 || this.psC == 7 || this.psB % 180 != 0) ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (this.psC == 5 || this.psC == 7 || this.psB % 180 != 0) ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable current = getCurrent();
        if (this.psB > 0 || (this.psC != 0 && this.psC != 1)) {
            switch (this.psC) {
                case 2:
                    this.psA.setScale(-1.0f, 1.0f);
                    break;
                case 3:
                case 6:
                default:
                    this.psA.setRotate(this.psB, rect.centerX(), rect.centerY());
                    break;
                case 4:
                    this.psA.setScale(1.0f, -1.0f);
                    break;
                case 5:
                    this.psA.setRotate(270.0f, rect.centerX(), rect.centerY());
                    this.psA.postScale(1.0f, -1.0f);
                    break;
                case 7:
                    this.psA.setRotate(270.0f, rect.centerX(), rect.centerY());
                    this.psA.postScale(-1.0f, 1.0f);
                    break;
            }
            this.mTempMatrix.reset();
            this.psA.invert(this.mTempMatrix);
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
        if (!this.psA.isIdentity()) {
            matrix.preConcat(this.psA);
        }
    }
}
