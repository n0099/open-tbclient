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
    private final float[] bEd;
    private boolean fly;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    private final RectF nOA;
    final float[] nOr;
    private boolean nOt;
    private final Path nOu;
    Type nOw;
    @Nullable
    private RectF nOx;
    @Nullable
    private Matrix nOy;
    private int nOz;

    /* loaded from: classes15.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.nOw = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bEd = new float[8];
        this.nOr = new float[8];
        this.mPaint = new Paint(1);
        this.fly = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.nOz = 0;
        this.mPadding = 0.0f;
        this.nOt = false;
        this.mPath = new Path();
        this.nOu = new Path();
        this.nOA = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void yN(boolean z) {
        this.fly = z;
        dYj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bEd, f);
        dYj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bEd, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bEd, 0, 8);
        }
        dYj();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.nOz = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dYj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aS(float f) {
        this.mPadding = f;
        dYj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void yO(boolean z) {
        this.nOt = z;
        dYj();
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
        dYj();
    }

    private void dYj() {
        this.mPath.reset();
        this.nOu.reset();
        this.nOA.set(getBounds());
        this.nOA.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.nOA, Path.Direction.CW);
        if (this.fly) {
            this.mPath.addCircle(this.nOA.centerX(), this.nOA.centerY(), Math.min(this.nOA.width(), this.nOA.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.nOA, this.bEd, Path.Direction.CW);
        }
        this.nOA.inset(-this.mPadding, -this.mPadding);
        this.nOA.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.fly) {
            this.nOu.addCircle(this.nOA.centerX(), this.nOA.centerY(), Math.min(this.nOA.width(), this.nOA.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.nOr.length; i++) {
                this.nOr[i] = (this.bEd[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.nOu.addRoundRect(this.nOA, this.nOr, Path.Direction.CW);
        }
        this.nOA.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.nOw) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.nOt) {
                    if (this.nOx == null) {
                        this.nOx = new RectF(this.mBounds);
                        this.nOy = new Matrix();
                    } else {
                        this.nOx.set(this.mBounds);
                    }
                    this.nOx.inset(this.mBorderWidth, this.mBorderWidth);
                    this.nOy.setRectToRect(this.mBounds, this.nOx, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.nOy);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.nOz);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.fly) {
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
            canvas.drawPath(this.nOu, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
