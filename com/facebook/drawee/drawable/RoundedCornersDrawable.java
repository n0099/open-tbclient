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
    private final float[] bTG;
    private final Path eWn;
    private boolean fOk;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    final float[] pDo;
    private boolean pDq;
    Type pDs;
    @Nullable
    private RectF pDt;
    @Nullable
    private Matrix pDu;
    private int pDv;
    private final RectF pDw;

    /* loaded from: classes15.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pDs = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bTG = new float[8];
        this.pDo = new float[8];
        this.mPaint = new Paint(1);
        this.fOk = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.pDv = 0;
        this.mPadding = 0.0f;
        this.pDq = false;
        this.mPath = new Path();
        this.eWn = new Path();
        this.pDw = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void Bn(boolean z) {
        this.fOk = z;
        euB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bTG, f);
        euB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bTG, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bTG, 0, 8);
        }
        euB();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.pDv = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        euB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bI(float f) {
        this.mPadding = f;
        euB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void Bo(boolean z) {
        this.pDq = z;
        euB();
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
        euB();
    }

    private void euB() {
        this.mPath.reset();
        this.eWn.reset();
        this.pDw.set(getBounds());
        this.pDw.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.pDw, Path.Direction.CW);
        if (this.fOk) {
            this.mPath.addCircle(this.pDw.centerX(), this.pDw.centerY(), Math.min(this.pDw.width(), this.pDw.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.pDw, this.bTG, Path.Direction.CW);
        }
        this.pDw.inset(-this.mPadding, -this.mPadding);
        this.pDw.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.fOk) {
            this.eWn.addCircle(this.pDw.centerX(), this.pDw.centerY(), Math.min(this.pDw.width(), this.pDw.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.pDo.length; i++) {
                this.pDo[i] = (this.bTG[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.eWn.addRoundRect(this.pDw, this.pDo, Path.Direction.CW);
        }
        this.pDw.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.pDs) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.pDq) {
                    if (this.pDt == null) {
                        this.pDt = new RectF(this.mBounds);
                        this.pDu = new Matrix();
                    } else {
                        this.pDt.set(this.mBounds);
                    }
                    this.pDt.inset(this.mBorderWidth, this.mBorderWidth);
                    this.pDu.setRectToRect(this.mBounds, this.pDt, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.pDu);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.pDv);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.fOk) {
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
            canvas.drawPath(this.eWn, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
