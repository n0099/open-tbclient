package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* loaded from: classes12.dex */
public class i extends g {
    final Matrix lLu;
    private int lLv;
    private int lLw;
    private final Matrix mTempMatrix;
    private final RectF mTempRectF;

    public i(Drawable drawable, int i) {
        this(drawable, i, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Drawable drawable, int i, int i2) {
        super(drawable);
        boolean z = true;
        this.mTempMatrix = new Matrix();
        this.mTempRectF = new RectF();
        com.facebook.common.internal.g.checkArgument(i % 90 == 0);
        com.facebook.common.internal.g.checkArgument((i2 < 0 || i2 > 8) ? false : z);
        this.lLu = new Matrix();
        this.lLv = i;
        this.lLw = i2;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.lLv <= 0 && (this.lLw == 0 || this.lLw == 1)) {
            super.draw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.concat(this.lLu);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (this.lLw == 5 || this.lLw == 7 || this.lLv % 180 != 0) ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (this.lLw == 5 || this.lLw == 7 || this.lLv % 180 != 0) ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable current = getCurrent();
        if (this.lLv > 0 || (this.lLw != 0 && this.lLw != 1)) {
            switch (this.lLw) {
                case 2:
                    this.lLu.setScale(-1.0f, 1.0f);
                    break;
                case 3:
                case 6:
                default:
                    this.lLu.setRotate(this.lLv, rect.centerX(), rect.centerY());
                    break;
                case 4:
                    this.lLu.setScale(1.0f, -1.0f);
                    break;
                case 5:
                    this.lLu.setRotate(270.0f, rect.centerX(), rect.centerY());
                    this.lLu.postScale(1.0f, -1.0f);
                    break;
                case 7:
                    this.lLu.setRotate(270.0f, rect.centerX(), rect.centerY());
                    this.lLu.postScale(-1.0f, 1.0f);
                    break;
            }
            this.mTempMatrix.reset();
            this.lLu.invert(this.mTempMatrix);
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
        if (!this.lLu.isIdentity()) {
            matrix.preConcat(this.lLu);
        }
    }
}
