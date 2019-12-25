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
/* loaded from: classes11.dex */
public class RoundedCornersDrawable extends g implements j {
    private final float[] aAs;
    private final Path caF;
    private boolean dDm;
    final float[] lIa;
    private boolean lIc;
    Type lIe;
    @Nullable
    private RectF lIf;
    @Nullable
    private Matrix lIg;
    private int lIh;
    private final RectF lIi;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;

    /* loaded from: classes11.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lIe = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.aAs = new float[8];
        this.lIa = new float[8];
        this.mPaint = new Paint(1);
        this.dDm = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.lIh = 0;
        this.mPadding = 0.0f;
        this.lIc = false;
        this.mPath = new Path();
        this.caF = new Path();
        this.lIi = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void uS(boolean z) {
        this.dDm = z;
        dkj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.aAs, f);
        dkj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.aAs, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.aAs, 0, 8);
        }
        dkj();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.lIh = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dkj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bo(float f) {
        this.mPadding = f;
        dkj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void uT(boolean z) {
        this.lIc = z;
        dkj();
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
        dkj();
    }

    private void dkj() {
        this.mPath.reset();
        this.caF.reset();
        this.lIi.set(getBounds());
        this.lIi.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.lIi, Path.Direction.CW);
        if (this.dDm) {
            this.mPath.addCircle(this.lIi.centerX(), this.lIi.centerY(), Math.min(this.lIi.width(), this.lIi.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lIi, this.aAs, Path.Direction.CW);
        }
        this.lIi.inset(-this.mPadding, -this.mPadding);
        this.lIi.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.dDm) {
            this.caF.addCircle(this.lIi.centerX(), this.lIi.centerY(), Math.min(this.lIi.width(), this.lIi.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lIa.length; i++) {
                this.lIa[i] = (this.aAs[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.caF.addRoundRect(this.lIi, this.lIa, Path.Direction.CW);
        }
        this.lIi.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.lIe) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.lIc) {
                    if (this.lIf == null) {
                        this.lIf = new RectF(this.mBounds);
                        this.lIg = new Matrix();
                    } else {
                        this.lIf.set(this.mBounds);
                    }
                    this.lIf.inset(this.mBorderWidth, this.mBorderWidth);
                    this.lIg.setRectToRect(this.mBounds, this.lIf, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.lIg);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lIh);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.dDm) {
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
            canvas.drawPath(this.caF, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
