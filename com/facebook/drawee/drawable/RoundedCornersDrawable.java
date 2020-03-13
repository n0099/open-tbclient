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
    private final float[] aFu;
    private final Path ceZ;
    private boolean dHO;
    Type lMB;
    @Nullable
    private RectF lMC;
    @Nullable
    private Matrix lMD;
    private int lME;
    private final RectF lMF;
    final float[] lMx;
    private boolean lMz;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
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
        this.lMB = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.aFu = new float[8];
        this.lMx = new float[8];
        this.mPaint = new Paint(1);
        this.dHO = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.lME = 0;
        this.mPadding = 0.0f;
        this.lMz = false;
        this.mPath = new Path();
        this.ceZ = new Path();
        this.lMF = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vi(boolean z) {
        this.dHO = z;
        dmC();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.aFu, f);
        dmC();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.aFu, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.aFu, 0, 8);
        }
        dmC();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.lME = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dmC();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bm(float f) {
        this.mPadding = f;
        dmC();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vj(boolean z) {
        this.lMz = z;
        dmC();
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
        dmC();
    }

    private void dmC() {
        this.mPath.reset();
        this.ceZ.reset();
        this.lMF.set(getBounds());
        this.lMF.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.lMF, Path.Direction.CW);
        if (this.dHO) {
            this.mPath.addCircle(this.lMF.centerX(), this.lMF.centerY(), Math.min(this.lMF.width(), this.lMF.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lMF, this.aFu, Path.Direction.CW);
        }
        this.lMF.inset(-this.mPadding, -this.mPadding);
        this.lMF.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.dHO) {
            this.ceZ.addCircle(this.lMF.centerX(), this.lMF.centerY(), Math.min(this.lMF.width(), this.lMF.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lMx.length; i++) {
                this.lMx[i] = (this.aFu[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.ceZ.addRoundRect(this.lMF, this.lMx, Path.Direction.CW);
        }
        this.lMF.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.lMB) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.lMz) {
                    if (this.lMC == null) {
                        this.lMC = new RectF(this.mBounds);
                        this.lMD = new Matrix();
                    } else {
                        this.lMC.set(this.mBounds);
                    }
                    this.lMC.inset(this.mBorderWidth, this.mBorderWidth);
                    this.lMD.setRectToRect(this.mBounds, this.lMC, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.lMD);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lME);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.dHO) {
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
            canvas.drawPath(this.ceZ, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
