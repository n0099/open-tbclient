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
    private final float[] biU;
    private boolean ewj;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    final Paint mPaint;
    private final Path mPath;
    final float[] mqF;
    private float mqH;
    private boolean mqI;
    private final Path mqJ;
    Type mqL;
    @Nullable
    private RectF mqM;
    @Nullable
    private Matrix mqN;
    private int mqO;
    private final RectF mqP;

    /* loaded from: classes13.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mqL = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.biU = new float[8];
        this.mqF = new float[8];
        this.mPaint = new Paint(1);
        this.ewj = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mqO = 0;
        this.mqH = 0.0f;
        this.mqI = false;
        this.mPath = new Path();
        this.mqJ = new Path();
        this.mqP = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void wd(boolean z) {
        this.ewj = z;
        dwx();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.biU, f);
        dwx();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void y(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.biU, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.biU, 0, 8);
        }
        dwx();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.mqO = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dwx();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aB(float f) {
        this.mqH = f;
        dwx();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void we(boolean z) {
        this.mqI = z;
        dwx();
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
        dwx();
    }

    private void dwx() {
        this.mPath.reset();
        this.mqJ.reset();
        this.mqP.set(getBounds());
        this.mqP.inset(this.mqH, this.mqH);
        this.mPath.addRect(this.mqP, Path.Direction.CW);
        if (this.ewj) {
            this.mPath.addCircle(this.mqP.centerX(), this.mqP.centerY(), Math.min(this.mqP.width(), this.mqP.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mqP, this.biU, Path.Direction.CW);
        }
        this.mqP.inset(-this.mqH, -this.mqH);
        this.mqP.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ewj) {
            this.mqJ.addCircle(this.mqP.centerX(), this.mqP.centerY(), Math.min(this.mqP.width(), this.mqP.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.mqF.length; i++) {
                this.mqF[i] = (this.biU[i] + this.mqH) - (this.mBorderWidth / 2.0f);
            }
            this.mqJ.addRoundRect(this.mqP, this.mqF, Path.Direction.CW);
        }
        this.mqP.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.mqL) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.mqI) {
                    if (this.mqM == null) {
                        this.mqM = new RectF(this.mBounds);
                        this.mqN = new Matrix();
                    } else {
                        this.mqM.set(this.mBounds);
                    }
                    this.mqM.inset(this.mBorderWidth, this.mBorderWidth);
                    this.mqN.setRectToRect(this.mBounds, this.mqM, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.mqN);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mqO);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.ewj) {
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
            canvas.drawPath(this.mqJ, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
