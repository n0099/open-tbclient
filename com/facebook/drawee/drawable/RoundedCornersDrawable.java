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
/* loaded from: classes8.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] bPx;
    private final Path eOJ;
    private boolean fHb;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    final float[] pfP;
    private boolean pfR;
    Type pfT;
    @Nullable
    private RectF pfU;
    @Nullable
    private Matrix pfV;
    private int pfW;
    private final RectF pfX;

    /* loaded from: classes8.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pfT = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bPx = new float[8];
        this.pfP = new float[8];
        this.mPaint = new Paint(1);
        this.fHb = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.pfW = 0;
        this.mPadding = 0.0f;
        this.pfR = false;
        this.mPath = new Path();
        this.eOJ = new Path();
        this.pfX = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void AQ(boolean z) {
        this.fHb = z;
        erJ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bPx, f);
        erJ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void A(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bPx, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bPx, 0, 8);
        }
        erJ();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.pfW = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        erJ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bt(float f) {
        this.mPadding = f;
        erJ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void AR(boolean z) {
        this.pfR = z;
        erJ();
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
        erJ();
    }

    private void erJ() {
        this.mPath.reset();
        this.eOJ.reset();
        this.pfX.set(getBounds());
        this.pfX.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.pfX, Path.Direction.CW);
        if (this.fHb) {
            this.mPath.addCircle(this.pfX.centerX(), this.pfX.centerY(), Math.min(this.pfX.width(), this.pfX.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.pfX, this.bPx, Path.Direction.CW);
        }
        this.pfX.inset(-this.mPadding, -this.mPadding);
        this.pfX.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.fHb) {
            this.eOJ.addCircle(this.pfX.centerX(), this.pfX.centerY(), Math.min(this.pfX.width(), this.pfX.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.pfP.length; i++) {
                this.pfP[i] = (this.bPx[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.eOJ.addRoundRect(this.pfX, this.pfP, Path.Direction.CW);
        }
        this.pfX.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.pfT) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.pfR) {
                    if (this.pfU == null) {
                        this.pfU = new RectF(this.mBounds);
                        this.pfV = new Matrix();
                    } else {
                        this.pfU.set(this.mBounds);
                    }
                    this.pfU.inset(this.mBorderWidth, this.mBorderWidth);
                    this.pfV.setRectToRect(this.mBounds, this.pfU, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.pfV);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.pfW);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.fHb) {
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
            canvas.drawPath(this.eOJ, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
