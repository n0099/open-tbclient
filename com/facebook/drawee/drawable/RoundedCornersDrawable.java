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
    private final float[] bnX;
    private boolean eFp;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    final float[] mME;
    private boolean mMG;
    private final Path mMH;
    Type mMJ;
    @Nullable
    private RectF mMK;
    @Nullable
    private Matrix mML;
    private int mMM;
    private final RectF mMN;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;

    /* loaded from: classes13.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mMJ = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bnX = new float[8];
        this.mME = new float[8];
        this.mPaint = new Paint(1);
        this.eFp = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mMM = 0;
        this.mPadding = 0.0f;
        this.mMG = false;
        this.mPath = new Path();
        this.mMH = new Path();
        this.mMN = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void wz(boolean z) {
        this.eFp = z;
        dBa();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bnX, f);
        dBa();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bnX, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bnX, 0, 8);
        }
        dBa();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.mMM = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dBa();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aH(float f) {
        this.mPadding = f;
        dBa();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void wA(boolean z) {
        this.mMG = z;
        dBa();
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
        dBa();
    }

    private void dBa() {
        this.mPath.reset();
        this.mMH.reset();
        this.mMN.set(getBounds());
        this.mMN.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.mMN, Path.Direction.CW);
        if (this.eFp) {
            this.mPath.addCircle(this.mMN.centerX(), this.mMN.centerY(), Math.min(this.mMN.width(), this.mMN.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mMN, this.bnX, Path.Direction.CW);
        }
        this.mMN.inset(-this.mPadding, -this.mPadding);
        this.mMN.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.eFp) {
            this.mMH.addCircle(this.mMN.centerX(), this.mMN.centerY(), Math.min(this.mMN.width(), this.mMN.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.mME.length; i++) {
                this.mME[i] = (this.bnX[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.mMH.addRoundRect(this.mMN, this.mME, Path.Direction.CW);
        }
        this.mMN.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.mMJ) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.mMG) {
                    if (this.mMK == null) {
                        this.mMK = new RectF(this.mBounds);
                        this.mML = new Matrix();
                    } else {
                        this.mMK.set(this.mBounds);
                    }
                    this.mMK.inset(this.mBorderWidth, this.mBorderWidth);
                    this.mML.setRectToRect(this.mBounds, this.mMK, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.mML);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mMM);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.eFp) {
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
            canvas.drawPath(this.mMH, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
