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
/* loaded from: classes12.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] aBc;
    private final Path caR;
    private boolean dDw;
    final float[] lLD;
    private boolean lLF;
    Type lLH;
    @Nullable
    private RectF lLI;
    @Nullable
    private Matrix lLJ;
    private int lLK;
    private final RectF lLL;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;

    /* loaded from: classes12.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lLH = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.aBc = new float[8];
        this.lLD = new float[8];
        this.mPaint = new Paint(1);
        this.dDw = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.lLK = 0;
        this.mPadding = 0.0f;
        this.lLF = false;
        this.mPath = new Path();
        this.caR = new Path();
        this.lLL = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void ve(boolean z) {
        this.dDw = z;
        dlm();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.aBc, f);
        dlm();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.aBc, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.aBc, 0, 8);
        }
        dlm();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.lLK = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dlm();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bn(float f) {
        this.mPadding = f;
        dlm();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vf(boolean z) {
        this.lLF = z;
        dlm();
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
        dlm();
    }

    private void dlm() {
        this.mPath.reset();
        this.caR.reset();
        this.lLL.set(getBounds());
        this.lLL.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.lLL, Path.Direction.CW);
        if (this.dDw) {
            this.mPath.addCircle(this.lLL.centerX(), this.lLL.centerY(), Math.min(this.lLL.width(), this.lLL.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lLL, this.aBc, Path.Direction.CW);
        }
        this.lLL.inset(-this.mPadding, -this.mPadding);
        this.lLL.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.dDw) {
            this.caR.addCircle(this.lLL.centerX(), this.lLL.centerY(), Math.min(this.lLL.width(), this.lLL.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lLD.length; i++) {
                this.lLD[i] = (this.aBc[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.caR.addRoundRect(this.lLL, this.lLD, Path.Direction.CW);
        }
        this.lLL.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.lLH) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.lLF) {
                    if (this.lLI == null) {
                        this.lLI = new RectF(this.mBounds);
                        this.lLJ = new Matrix();
                    } else {
                        this.lLI.set(this.mBounds);
                    }
                    this.lLI.inset(this.mBorderWidth, this.mBorderWidth);
                    this.lLJ.setRectToRect(this.mBounds, this.lLI, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.lLJ);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lLK);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.dDw) {
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
            canvas.drawPath(this.caR, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
