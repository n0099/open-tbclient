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
    private final float[] bUC;
    private final Path eYI;
    private boolean fQD;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    final float[] pwZ;
    private boolean pxb;
    Type pxd;
    @Nullable
    private RectF pxe;
    @Nullable
    private Matrix pxf;
    private int pxg;
    private final RectF pxh;

    /* loaded from: classes15.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pxd = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bUC = new float[8];
        this.pwZ = new float[8];
        this.mPaint = new Paint(1);
        this.fQD = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.pxg = 0;
        this.mPadding = 0.0f;
        this.pxb = false;
        this.mPath = new Path();
        this.eYI = new Path();
        this.pxh = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void AY(boolean z) {
        this.fQD = z;
        evN();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bUC, f);
        evN();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bUC, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bUC, 0, 8);
        }
        evN();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.pxg = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        evN();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bF(float f) {
        this.mPadding = f;
        evN();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void AZ(boolean z) {
        this.pxb = z;
        evN();
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
        evN();
    }

    private void evN() {
        this.mPath.reset();
        this.eYI.reset();
        this.pxh.set(getBounds());
        this.pxh.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.pxh, Path.Direction.CW);
        if (this.fQD) {
            this.mPath.addCircle(this.pxh.centerX(), this.pxh.centerY(), Math.min(this.pxh.width(), this.pxh.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.pxh, this.bUC, Path.Direction.CW);
        }
        this.pxh.inset(-this.mPadding, -this.mPadding);
        this.pxh.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.fQD) {
            this.eYI.addCircle(this.pxh.centerX(), this.pxh.centerY(), Math.min(this.pxh.width(), this.pxh.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.pwZ.length; i++) {
                this.pwZ[i] = (this.bUC[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.eYI.addRoundRect(this.pxh, this.pwZ, Path.Direction.CW);
        }
        this.pxh.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.pxd) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.pxb) {
                    if (this.pxe == null) {
                        this.pxe = new RectF(this.mBounds);
                        this.pxf = new Matrix();
                    } else {
                        this.pxe.set(this.mBounds);
                    }
                    this.pxe.inset(this.mBorderWidth, this.mBorderWidth);
                    this.pxf.setRectToRect(this.mBounds, this.pxe, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.pxf);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.pxg);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.fQD) {
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
            canvas.drawPath(this.eYI, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
