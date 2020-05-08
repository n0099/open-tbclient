package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] bbu;
    private final Path cEo;
    private boolean ehQ;
    final float[] lVC;
    private float lVE;
    private boolean lVF;
    Type lVH;
    @Nullable
    private RectF lVI;
    @Nullable
    private Matrix lVJ;
    private int lVK;
    private final RectF lVL;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    final Paint mPaint;
    private final Path mPath;

    /* loaded from: classes13.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lVH = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bbu = new float[8];
        this.lVC = new float[8];
        this.mPaint = new Paint(1);
        this.ehQ = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.lVK = 0;
        this.lVE = 0.0f;
        this.lVF = false;
        this.mPath = new Path();
        this.cEo = new Path();
        this.lVL = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vD(boolean z) {
        this.ehQ = z;
        doQ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bbu, f);
        doQ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void y(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bbu, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bbu, 0, 8);
        }
        doQ();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.lVK = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        doQ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aC(float f) {
        this.lVE = f;
        doQ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vE(boolean z) {
        this.lVF = z;
        doQ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        a(colorFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        doQ();
    }

    private void doQ() {
        this.mPath.reset();
        this.cEo.reset();
        this.lVL.set(getBounds());
        this.lVL.inset(this.lVE, this.lVE);
        this.mPath.addRect(this.lVL, Path.Direction.CW);
        if (this.ehQ) {
            this.mPath.addCircle(this.lVL.centerX(), this.lVL.centerY(), Math.min(this.lVL.width(), this.lVL.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lVL, this.bbu, Path.Direction.CW);
        }
        this.lVL.inset(-this.lVE, -this.lVE);
        this.lVL.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ehQ) {
            this.cEo.addCircle(this.lVL.centerX(), this.lVL.centerY(), Math.min(this.lVL.width(), this.lVL.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lVC.length; i++) {
                this.lVC[i] = (this.bbu[i] + this.lVE) - (this.mBorderWidth / 2.0f);
            }
            this.cEo.addRoundRect(this.lVL, this.lVC, Path.Direction.CW);
        }
        this.lVL.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.lVH) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.lVF) {
                    if (this.lVI == null) {
                        this.lVI = new RectF(this.mBounds);
                        this.lVJ = new Matrix();
                    } else {
                        this.lVI.set(this.mBounds);
                    }
                    this.lVI.inset(this.mBorderWidth, this.mBorderWidth);
                    this.lVJ.setRectToRect(this.mBounds, this.lVI, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.lVJ);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lVK);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.ehQ) {
                    float width = ((this.mBounds.width() - this.mBounds.height()) + this.mBorderWidth) / 2.0f;
                    float height = ((this.mBounds.height() - this.mBounds.width()) + this.mBorderWidth) / 2.0f;
                    if (width > 0.0f) {
                        canvas.drawRect(this.mBounds.left, this.mBounds.top, this.mBounds.left + width, this.mBounds.bottom, this.mPaint);
                        canvas.drawRect(this.mBounds.right - width, this.mBounds.top, this.mBounds.right, this.mBounds.bottom, this.mPaint);
                    }
                    if (height > 0.0f) {
                        canvas.drawRect(this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.top + height, this.mPaint);
                        canvas.drawRect(this.mBounds.left, this.mBounds.bottom - height, this.mBounds.right, this.mBounds.bottom, this.mPaint);
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
            canvas.drawPath(this.cEo, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
