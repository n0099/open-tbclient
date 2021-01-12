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
/* loaded from: classes3.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] bPQ;
    private final Path eTX;
    private boolean fLW;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    final float[] psE;
    private boolean psG;
    Type psI;
    @Nullable
    private RectF psJ;
    @Nullable
    private Matrix psK;
    private int psL;
    private final RectF psM;

    /* loaded from: classes3.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.psI = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bPQ = new float[8];
        this.psE = new float[8];
        this.mPaint = new Paint(1);
        this.fLW = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.psL = 0;
        this.mPadding = 0.0f;
        this.psG = false;
        this.mPath = new Path();
        this.eTX = new Path();
        this.psM = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void AU(boolean z) {
        this.fLW = z;
        esb();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bPQ, f);
        esb();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bPQ, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bPQ, 0, 8);
        }
        esb();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.psL = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        esb();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bF(float f) {
        this.mPadding = f;
        esb();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void AV(boolean z) {
        this.psG = z;
        esb();
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
        esb();
    }

    private void esb() {
        this.mPath.reset();
        this.eTX.reset();
        this.psM.set(getBounds());
        this.psM.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.psM, Path.Direction.CW);
        if (this.fLW) {
            this.mPath.addCircle(this.psM.centerX(), this.psM.centerY(), Math.min(this.psM.width(), this.psM.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.psM, this.bPQ, Path.Direction.CW);
        }
        this.psM.inset(-this.mPadding, -this.mPadding);
        this.psM.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.fLW) {
            this.eTX.addCircle(this.psM.centerX(), this.psM.centerY(), Math.min(this.psM.width(), this.psM.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.psE.length; i++) {
                this.psE[i] = (this.bPQ[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.eTX.addRoundRect(this.psM, this.psE, Path.Direction.CW);
        }
        this.psM.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.psI) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.psG) {
                    if (this.psJ == null) {
                        this.psJ = new RectF(this.mBounds);
                        this.psK = new Matrix();
                    } else {
                        this.psJ.set(this.mBounds);
                    }
                    this.psJ.inset(this.mBorderWidth, this.mBorderWidth);
                    this.psK.setRectToRect(this.mBounds, this.psJ, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.psK);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.psL);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.fLW) {
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
            canvas.drawPath(this.eTX, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
