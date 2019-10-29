package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes2.dex */
public class i extends g {
    final Matrix ken;
    private int keo;
    private final Matrix mTempMatrix;
    private final RectF mTempRectF;

    public i(Drawable drawable, int i) {
        super(drawable);
        this.mTempMatrix = new Matrix();
        this.mTempRectF = new RectF();
        com.facebook.common.internal.g.checkArgument(i % 90 == 0);
        this.ken = new Matrix();
        this.keo = i;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.keo <= 0) {
            super.draw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.concat(this.ken);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.keo % SubsamplingScaleImageView.ORIENTATION_180 == 0 ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.keo % SubsamplingScaleImageView.ORIENTATION_180 == 0 ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable current = getCurrent();
        if (this.keo > 0) {
            this.ken.setRotate(this.keo, rect.centerX(), rect.centerY());
            this.mTempMatrix.reset();
            this.ken.invert(this.mTempMatrix);
            this.mTempRectF.set(rect);
            this.mTempMatrix.mapRect(this.mTempRectF);
            current.setBounds((int) this.mTempRectF.left, (int) this.mTempRectF.top, (int) this.mTempRectF.right, (int) this.mTempRectF.bottom);
            return;
        }
        current.setBounds(rect);
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void d(Matrix matrix) {
        e(matrix);
        if (!this.ken.isIdentity()) {
            matrix.preConcat(this.ken);
        }
    }
}
