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
/* loaded from: classes9.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] bos;
    private boolean eLL;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    final float[] mUQ;
    private boolean mUS;
    private final Path mUT;
    Type mUV;
    @Nullable
    private RectF mUW;
    @Nullable
    private Matrix mUX;
    private int mUY;
    private final RectF mUZ;

    /* loaded from: classes9.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mUV = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bos = new float[8];
        this.mUQ = new float[8];
        this.mPaint = new Paint(1);
        this.eLL = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mUY = 0;
        this.mPadding = 0.0f;
        this.mUS = false;
        this.mPath = new Path();
        this.mUT = new Path();
        this.mUZ = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void xe(boolean z) {
        this.eLL = z;
        dEq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bos, f);
        dEq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bos, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bos, 0, 8);
        }
        dEq();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.mUY = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dEq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aG(float f) {
        this.mPadding = f;
        dEq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void xf(boolean z) {
        this.mUS = z;
        dEq();
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
        dEq();
    }

    private void dEq() {
        this.mPath.reset();
        this.mUT.reset();
        this.mUZ.set(getBounds());
        this.mUZ.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.mUZ, Path.Direction.CW);
        if (this.eLL) {
            this.mPath.addCircle(this.mUZ.centerX(), this.mUZ.centerY(), Math.min(this.mUZ.width(), this.mUZ.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mUZ, this.bos, Path.Direction.CW);
        }
        this.mUZ.inset(-this.mPadding, -this.mPadding);
        this.mUZ.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.eLL) {
            this.mUT.addCircle(this.mUZ.centerX(), this.mUZ.centerY(), Math.min(this.mUZ.width(), this.mUZ.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.mUQ.length; i++) {
                this.mUQ[i] = (this.bos[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.mUT.addRoundRect(this.mUZ, this.mUQ, Path.Direction.CW);
        }
        this.mUZ.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.mUV) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.mUS) {
                    if (this.mUW == null) {
                        this.mUW = new RectF(this.mBounds);
                        this.mUX = new Matrix();
                    } else {
                        this.mUW.set(this.mBounds);
                    }
                    this.mUW.inset(this.mBorderWidth, this.mBorderWidth);
                    this.mUX.setRectToRect(this.mBounds, this.mUW, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.mUX);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mUY);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.eLL) {
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
            canvas.drawPath(this.mUT, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
