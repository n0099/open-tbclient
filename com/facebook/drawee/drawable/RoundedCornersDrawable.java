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
/* loaded from: classes4.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] bue;
    private boolean eWr;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    final float[] noI;
    private boolean noK;
    private final Path noL;
    Type noN;
    @Nullable
    private RectF noO;
    @Nullable
    private Matrix noP;
    private int noQ;
    private final RectF noR;

    /* loaded from: classes4.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.noN = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bue = new float[8];
        this.noI = new float[8];
        this.mPaint = new Paint(1);
        this.eWr = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.noQ = 0;
        this.mPadding = 0.0f;
        this.noK = false;
        this.mPath = new Path();
        this.noL = new Path();
        this.noR = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void xV(boolean z) {
        this.eWr = z;
        dQr();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bue, f);
        dQr();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bue, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bue, 0, 8);
        }
        dQr();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.noQ = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dQr();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aM(float f) {
        this.mPadding = f;
        dQr();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void xW(boolean z) {
        this.noK = z;
        dQr();
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
        dQr();
    }

    private void dQr() {
        this.mPath.reset();
        this.noL.reset();
        this.noR.set(getBounds());
        this.noR.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.noR, Path.Direction.CW);
        if (this.eWr) {
            this.mPath.addCircle(this.noR.centerX(), this.noR.centerY(), Math.min(this.noR.width(), this.noR.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.noR, this.bue, Path.Direction.CW);
        }
        this.noR.inset(-this.mPadding, -this.mPadding);
        this.noR.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.eWr) {
            this.noL.addCircle(this.noR.centerX(), this.noR.centerY(), Math.min(this.noR.width(), this.noR.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.noI.length; i++) {
                this.noI[i] = (this.bue[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.noL.addRoundRect(this.noR, this.noI, Path.Direction.CW);
        }
        this.noR.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.noN) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.noK) {
                    if (this.noO == null) {
                        this.noO = new RectF(this.mBounds);
                        this.noP = new Matrix();
                    } else {
                        this.noO.set(this.mBounds);
                    }
                    this.noO.inset(this.mBorderWidth, this.mBorderWidth);
                    this.noP.setRectToRect(this.mBounds, this.noO, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.noP);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.noQ);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.eWr) {
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
            canvas.drawPath(this.noL, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
