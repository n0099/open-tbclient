package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
/* loaded from: classes6.dex */
public class OrientedDrawable extends ForwardingDrawable {
    public int mExifOrientation;
    public int mRotationAngle;
    @VisibleForTesting
    public final Matrix mRotationMatrix;
    public final Matrix mTempMatrix;
    public final RectF mTempRectF;

    public OrientedDrawable(Drawable drawable, int i) {
        this(drawable, i, 0);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        if (this.mRotationAngle <= 0 && ((i = this.mExifOrientation) == 0 || i == 1)) {
            super.draw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.concat(this.mRotationMatrix);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = this.mExifOrientation;
        if (i != 5 && i != 7 && this.mRotationAngle % 180 == 0) {
            return super.getIntrinsicHeight();
        }
        return super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = this.mExifOrientation;
        if (i != 5 && i != 7 && this.mRotationAngle % 180 == 0) {
            return super.getIntrinsicWidth();
        }
        return super.getIntrinsicHeight();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        if (this.mRotationMatrix.isIdentity()) {
            return;
        }
        matrix.preConcat(this.mRotationMatrix);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i;
        Drawable current = getCurrent();
        if (this.mRotationAngle <= 0 && ((i = this.mExifOrientation) == 0 || i == 1)) {
            current.setBounds(rect);
            return;
        }
        int i2 = this.mExifOrientation;
        if (i2 == 2) {
            this.mRotationMatrix.setScale(-1.0f, 1.0f);
        } else if (i2 == 7) {
            this.mRotationMatrix.setRotate(270.0f, rect.centerX(), rect.centerY());
            this.mRotationMatrix.postScale(-1.0f, 1.0f);
        } else if (i2 == 4) {
            this.mRotationMatrix.setScale(1.0f, -1.0f);
        } else if (i2 != 5) {
            this.mRotationMatrix.setRotate(this.mRotationAngle, rect.centerX(), rect.centerY());
        } else {
            this.mRotationMatrix.setRotate(270.0f, rect.centerX(), rect.centerY());
            this.mRotationMatrix.postScale(1.0f, -1.0f);
        }
        this.mTempMatrix.reset();
        this.mRotationMatrix.invert(this.mTempMatrix);
        this.mTempRectF.set(rect);
        this.mTempMatrix.mapRect(this.mTempRectF);
        RectF rectF = this.mTempRectF;
        current.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public OrientedDrawable(Drawable drawable, int i, int i2) {
        super(drawable);
        this.mTempMatrix = new Matrix();
        this.mTempRectF = new RectF();
        boolean z = true;
        Preconditions.checkArgument(i % 90 == 0);
        Preconditions.checkArgument((i2 < 0 || i2 > 8) ? false : false);
        this.mRotationMatrix = new Matrix();
        this.mRotationAngle = i;
        this.mExifOrientation = i2;
    }
}
