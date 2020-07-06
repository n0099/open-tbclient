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
    final float[] mMH;
    private boolean mMJ;
    private final Path mMK;
    Type mMM;
    @Nullable
    private RectF mMN;
    @Nullable
    private Matrix mMO;
    private int mMP;
    private final RectF mMQ;
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
        this.mMM = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bnX = new float[8];
        this.mMH = new float[8];
        this.mPaint = new Paint(1);
        this.eFp = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mMP = 0;
        this.mPadding = 0.0f;
        this.mMJ = false;
        this.mPath = new Path();
        this.mMK = new Path();
        this.mMQ = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void wz(boolean z) {
        this.eFp = z;
        dBe();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bnX, f);
        dBe();
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
        dBe();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.mMP = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dBe();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aH(float f) {
        this.mPadding = f;
        dBe();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void wA(boolean z) {
        this.mMJ = z;
        dBe();
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
        dBe();
    }

    private void dBe() {
        this.mPath.reset();
        this.mMK.reset();
        this.mMQ.set(getBounds());
        this.mMQ.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.mMQ, Path.Direction.CW);
        if (this.eFp) {
            this.mPath.addCircle(this.mMQ.centerX(), this.mMQ.centerY(), Math.min(this.mMQ.width(), this.mMQ.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mMQ, this.bnX, Path.Direction.CW);
        }
        this.mMQ.inset(-this.mPadding, -this.mPadding);
        this.mMQ.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.eFp) {
            this.mMK.addCircle(this.mMQ.centerX(), this.mMQ.centerY(), Math.min(this.mMQ.width(), this.mMQ.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.mMH.length; i++) {
                this.mMH[i] = (this.bnX[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.mMK.addRoundRect(this.mMQ, this.mMH, Path.Direction.CW);
        }
        this.mMQ.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.mMM) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.mMJ) {
                    if (this.mMN == null) {
                        this.mMN = new RectF(this.mBounds);
                        this.mMO = new Matrix();
                    } else {
                        this.mMN.set(this.mBounds);
                    }
                    this.mMN.inset(this.mBorderWidth, this.mBorderWidth);
                    this.mMO.setRectToRect(this.mBounds, this.mMN, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.mMO);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mMP);
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
            canvas.drawPath(this.mMK, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
