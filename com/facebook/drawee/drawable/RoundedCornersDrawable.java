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
    Type mpB;
    @Nullable
    private RectF mpC;
    @Nullable
    private Matrix mpD;
    private int mpE;
    private final RectF mpF;
    final float[] mpv;
    private float mpx;
    private boolean mpy;
    private final Path mpz;

    /* loaded from: classes13.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mpB = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.biU = new float[8];
        this.mpv = new float[8];
        this.mPaint = new Paint(1);
        this.ewj = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mpE = 0;
        this.mpx = 0.0f;
        this.mpy = false;
        this.mPath = new Path();
        this.mpz = new Path();
        this.mpF = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void wb(boolean z) {
        this.ewj = z;
        dwj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.biU, f);
        dwj();
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
        dwj();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.mpE = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dwj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aB(float f) {
        this.mpx = f;
        dwj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void wc(boolean z) {
        this.mpy = z;
        dwj();
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
        dwj();
    }

    private void dwj() {
        this.mPath.reset();
        this.mpz.reset();
        this.mpF.set(getBounds());
        this.mpF.inset(this.mpx, this.mpx);
        this.mPath.addRect(this.mpF, Path.Direction.CW);
        if (this.ewj) {
            this.mPath.addCircle(this.mpF.centerX(), this.mpF.centerY(), Math.min(this.mpF.width(), this.mpF.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mpF, this.biU, Path.Direction.CW);
        }
        this.mpF.inset(-this.mpx, -this.mpx);
        this.mpF.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ewj) {
            this.mpz.addCircle(this.mpF.centerX(), this.mpF.centerY(), Math.min(this.mpF.width(), this.mpF.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.mpv.length; i++) {
                this.mpv[i] = (this.biU[i] + this.mpx) - (this.mBorderWidth / 2.0f);
            }
            this.mpz.addRoundRect(this.mpF, this.mpv, Path.Direction.CW);
        }
        this.mpF.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.mpB) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.mpy) {
                    if (this.mpC == null) {
                        this.mpC = new RectF(this.mBounds);
                        this.mpD = new Matrix();
                    } else {
                        this.mpC.set(this.mBounds);
                    }
                    this.mpC.inset(this.mBorderWidth, this.mBorderWidth);
                    this.mpD.setRectToRect(this.mBounds, this.mpC, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.mpD);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mpE);
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
            canvas.drawPath(this.mpz, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
