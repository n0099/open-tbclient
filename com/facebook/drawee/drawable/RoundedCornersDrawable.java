package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundedCornersDrawable extends g implements j {
    private int GW;
    private final float[] bbZ;
    private final Path deM;
    private boolean kcD;
    final float[] kcG;
    private float kcR;
    Type kcW;
    private int kcX;
    private final RectF kcY;
    private float mBorderWidth;
    final Paint mPaint;
    private final Path mPath;

    /* loaded from: classes2.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.kcW = Type.OVERLAY_COLOR;
        this.bbZ = new float[8];
        this.kcG = new float[8];
        this.mPaint = new Paint(1);
        this.kcD = false;
        this.mBorderWidth = 0.0f;
        this.GW = 0;
        this.kcX = 0;
        this.kcR = 0.0f;
        this.mPath = new Path();
        this.deM = new Path();
        this.kcY = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void sx(boolean z) {
        this.kcD = z;
        cGt();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bbZ, f);
        cGt();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bbZ, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bbZ, 0, 8);
        }
        cGt();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.kcX = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        this.GW = i;
        this.mBorderWidth = f;
        cGt();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void ba(float f) {
        this.kcR = f;
        cGt();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        cGt();
    }

    private void cGt() {
        this.mPath.reset();
        this.deM.reset();
        this.kcY.set(getBounds());
        this.kcY.inset(this.kcR, this.kcR);
        if (this.kcD) {
            this.mPath.addCircle(this.kcY.centerX(), this.kcY.centerY(), Math.min(this.kcY.width(), this.kcY.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.kcY, this.bbZ, Path.Direction.CW);
        }
        this.kcY.inset(-this.kcR, -this.kcR);
        this.kcY.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.kcD) {
            this.deM.addCircle(this.kcY.centerX(), this.kcY.centerY(), Math.min(this.kcY.width(), this.kcY.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.kcG.length; i++) {
                this.kcG[i] = (this.bbZ[i] + this.kcR) - (this.mBorderWidth / 2.0f);
            }
            this.deM.addRoundRect(this.kcY, this.kcG, Path.Direction.CW);
        }
        this.kcY.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.kcW) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.kcX);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.kcD) {
                    float width = ((bounds.width() - bounds.height()) + this.mBorderWidth) / 2.0f;
                    float height = ((bounds.height() - bounds.width()) + this.mBorderWidth) / 2.0f;
                    if (width > 0.0f) {
                        canvas.drawRect(bounds.left, bounds.top, bounds.left + width, bounds.bottom, this.mPaint);
                        canvas.drawRect(bounds.right - width, bounds.top, bounds.right, bounds.bottom, this.mPaint);
                    }
                    if (height > 0.0f) {
                        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.top + height, this.mPaint);
                        canvas.drawRect(bounds.left, bounds.bottom - height, bounds.right, bounds.bottom, this.mPaint);
                        break;
                    }
                }
                break;
        }
        if (this.GW != 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.GW);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.deM, this.mPaint);
        }
    }
}
