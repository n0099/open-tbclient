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
    private final float[] bbp;
    private final Path cEi;
    private boolean ehL;
    private float lVA;
    private boolean lVB;
    Type lVD;
    @Nullable
    private RectF lVE;
    @Nullable
    private Matrix lVF;
    private int lVG;
    private final RectF lVH;
    final float[] lVy;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    final Paint mPaint;
    private final Path mPath;

    /* loaded from: classes13.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lVD = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bbp = new float[8];
        this.lVy = new float[8];
        this.mPaint = new Paint(1);
        this.ehL = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.lVG = 0;
        this.lVA = 0.0f;
        this.lVB = false;
        this.mPath = new Path();
        this.cEi = new Path();
        this.lVH = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vD(boolean z) {
        this.ehL = z;
        doT();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bbp, f);
        doT();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void y(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bbp, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bbp, 0, 8);
        }
        doT();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.lVG = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        doT();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aC(float f) {
        this.lVA = f;
        doT();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vE(boolean z) {
        this.lVB = z;
        doT();
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
        doT();
    }

    private void doT() {
        this.mPath.reset();
        this.cEi.reset();
        this.lVH.set(getBounds());
        this.lVH.inset(this.lVA, this.lVA);
        this.mPath.addRect(this.lVH, Path.Direction.CW);
        if (this.ehL) {
            this.mPath.addCircle(this.lVH.centerX(), this.lVH.centerY(), Math.min(this.lVH.width(), this.lVH.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lVH, this.bbp, Path.Direction.CW);
        }
        this.lVH.inset(-this.lVA, -this.lVA);
        this.lVH.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ehL) {
            this.cEi.addCircle(this.lVH.centerX(), this.lVH.centerY(), Math.min(this.lVH.width(), this.lVH.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lVy.length; i++) {
                this.lVy[i] = (this.bbp[i] + this.lVA) - (this.mBorderWidth / 2.0f);
            }
            this.cEi.addRoundRect(this.lVH, this.lVy, Path.Direction.CW);
        }
        this.lVH.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.lVD) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.lVB) {
                    if (this.lVE == null) {
                        this.lVE = new RectF(this.mBounds);
                        this.lVF = new Matrix();
                    } else {
                        this.lVE.set(this.mBounds);
                    }
                    this.lVE.inset(this.mBorderWidth, this.mBorderWidth);
                    this.lVF.setRectToRect(this.mBounds, this.lVE, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.lVF);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lVG);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.ehL) {
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
            canvas.drawPath(this.cEi, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
