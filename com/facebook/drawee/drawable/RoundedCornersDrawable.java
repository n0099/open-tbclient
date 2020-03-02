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
    private final float[] aFt;
    private final Path ceY;
    private boolean dHB;
    final float[] lMm;
    private boolean lMo;
    Type lMq;
    @Nullable
    private RectF lMr;
    @Nullable
    private Matrix lMs;
    private int lMt;
    private final RectF lMu;
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
        this.lMq = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.aFt = new float[8];
        this.lMm = new float[8];
        this.mPaint = new Paint(1);
        this.dHB = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.lMt = 0;
        this.mPadding = 0.0f;
        this.lMo = false;
        this.mPath = new Path();
        this.ceY = new Path();
        this.lMu = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vi(boolean z) {
        this.dHB = z;
        dmB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.aFt, f);
        dmB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.aFt, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.aFt, 0, 8);
        }
        dmB();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.lMt = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dmB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bm(float f) {
        this.mPadding = f;
        dmB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vj(boolean z) {
        this.lMo = z;
        dmB();
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
        dmB();
    }

    private void dmB() {
        this.mPath.reset();
        this.ceY.reset();
        this.lMu.set(getBounds());
        this.lMu.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.lMu, Path.Direction.CW);
        if (this.dHB) {
            this.mPath.addCircle(this.lMu.centerX(), this.lMu.centerY(), Math.min(this.lMu.width(), this.lMu.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lMu, this.aFt, Path.Direction.CW);
        }
        this.lMu.inset(-this.mPadding, -this.mPadding);
        this.lMu.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.dHB) {
            this.ceY.addCircle(this.lMu.centerX(), this.lMu.centerY(), Math.min(this.lMu.width(), this.lMu.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lMm.length; i++) {
                this.lMm[i] = (this.aFt[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.ceY.addRoundRect(this.lMu, this.lMm, Path.Direction.CW);
        }
        this.lMu.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.lMq) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.lMo) {
                    if (this.lMr == null) {
                        this.lMr = new RectF(this.mBounds);
                        this.lMs = new Matrix();
                    } else {
                        this.lMr.set(this.mBounds);
                    }
                    this.lMr.inset(this.mBorderWidth, this.mBorderWidth);
                    this.lMs.setRectToRect(this.mBounds, this.lMr, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.lMs);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lMt);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.dHB) {
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
            canvas.drawPath(this.ceY, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
