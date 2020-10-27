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
/* loaded from: classes15.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] bGZ;
    private boolean ftZ;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    final float[] oFK;
    private boolean oFM;
    private final Path oFN;
    Type oFP;
    @Nullable
    private RectF oFQ;
    @Nullable
    private Matrix oFR;
    private int oFS;
    private final RectF oFT;

    /* loaded from: classes15.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.oFP = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bGZ = new float[8];
        this.oFK = new float[8];
        this.mPaint = new Paint(1);
        this.ftZ = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.oFS = 0;
        this.mPadding = 0.0f;
        this.oFM = false;
        this.mPath = new Path();
        this.oFN = new Path();
        this.oFT = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void zV(boolean z) {
        this.ftZ = z;
        eih();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bGZ, f);
        eih();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bGZ, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bGZ, 0, 8);
        }
        eih();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.oFS = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        eih();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bj(float f) {
        this.mPadding = f;
        eih();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void zW(boolean z) {
        this.oFM = z;
        eih();
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
        eih();
    }

    private void eih() {
        this.mPath.reset();
        this.oFN.reset();
        this.oFT.set(getBounds());
        this.oFT.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.oFT, Path.Direction.CW);
        if (this.ftZ) {
            this.mPath.addCircle(this.oFT.centerX(), this.oFT.centerY(), Math.min(this.oFT.width(), this.oFT.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.oFT, this.bGZ, Path.Direction.CW);
        }
        this.oFT.inset(-this.mPadding, -this.mPadding);
        this.oFT.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ftZ) {
            this.oFN.addCircle(this.oFT.centerX(), this.oFT.centerY(), Math.min(this.oFT.width(), this.oFT.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.oFK.length; i++) {
                this.oFK[i] = (this.bGZ[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.oFN.addRoundRect(this.oFT, this.oFK, Path.Direction.CW);
        }
        this.oFT.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.oFP) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.oFM) {
                    if (this.oFQ == null) {
                        this.oFQ = new RectF(this.mBounds);
                        this.oFR = new Matrix();
                    } else {
                        this.oFQ.set(this.mBounds);
                    }
                    this.oFQ.inset(this.mBorderWidth, this.mBorderWidth);
                    this.oFR.setRectToRect(this.mBounds, this.oFQ, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.oFR);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.oFS);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.ftZ) {
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
            canvas.drawPath(this.oFN, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
