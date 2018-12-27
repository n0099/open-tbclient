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
    private final Path bIA;
    private float imG;
    private final float[] imK;
    Type imM;
    private int imN;
    private final RectF imO;
    private boolean ims;
    final float[] imv;
    private int mBorderColor;
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
        this.imM = Type.OVERLAY_COLOR;
        this.imK = new float[8];
        this.imv = new float[8];
        this.mPaint = new Paint(1);
        this.ims = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.imN = 0;
        this.imG = 0.0f;
        this.mPath = new Path();
        this.bIA = new Path();
        this.imO = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void oX(boolean z) {
        this.ims = z;
        bVH();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.imK, f);
        bVH();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void e(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.imK, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.imK, 0, 8);
        }
        bVH();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.imN = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        bVH();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aI(float f) {
        this.imG = f;
        bVH();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bVH();
    }

    private void bVH() {
        this.mPath.reset();
        this.bIA.reset();
        this.imO.set(getBounds());
        this.imO.inset(this.imG, this.imG);
        if (this.ims) {
            this.mPath.addCircle(this.imO.centerX(), this.imO.centerY(), Math.min(this.imO.width(), this.imO.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.imO, this.imK, Path.Direction.CW);
        }
        this.imO.inset(-this.imG, -this.imG);
        this.imO.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ims) {
            this.bIA.addCircle(this.imO.centerX(), this.imO.centerY(), Math.min(this.imO.width(), this.imO.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.imv.length; i++) {
                this.imv[i] = (this.imK[i] + this.imG) - (this.mBorderWidth / 2.0f);
            }
            this.bIA.addRoundRect(this.imO, this.imv, Path.Direction.CW);
        }
        this.imO.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.imM) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.imN);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.ims) {
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
        if (this.mBorderColor != 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            this.mPath.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.bIA, this.mPaint);
        }
    }
}
