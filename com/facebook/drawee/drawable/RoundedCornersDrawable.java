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
    private final float[] bxA;
    private boolean eZm;
    private int mBorderColor;
    private float mBorderWidth;
    private final RectF mBounds;
    private float mPadding;
    final Paint mPaint;
    private final Path mPath;
    final float[] nyY;
    private boolean nza;
    private final Path nzb;
    Type nzd;
    @Nullable
    private RectF nze;
    @Nullable
    private Matrix nzf;
    private int nzg;
    private final RectF nzh;

    /* loaded from: classes11.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.nzd = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.bxA = new float[8];
        this.nyY = new float[8];
        this.mPaint = new Paint(1);
        this.eZm = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.nzg = 0;
        this.mPadding = 0.0f;
        this.nza = false;
        this.mPath = new Path();
        this.nzb = new Path();
        this.nzh = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void yg(boolean z) {
        this.eZm = z;
        dUy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.bxA, f);
        dUy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bxA, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bxA, 0, 8);
        }
        dUy();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.nzg = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dUy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aM(float f) {
        this.mPadding = f;
        dUy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void yh(boolean z) {
        this.nza = z;
        dUy();
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
        dUy();
    }

    private void dUy() {
        this.mPath.reset();
        this.nzb.reset();
        this.nzh.set(getBounds());
        this.nzh.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.nzh, Path.Direction.CW);
        if (this.eZm) {
            this.mPath.addCircle(this.nzh.centerX(), this.nzh.centerY(), Math.min(this.nzh.width(), this.nzh.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.nzh, this.bxA, Path.Direction.CW);
        }
        this.nzh.inset(-this.mPadding, -this.mPadding);
        this.nzh.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.eZm) {
            this.nzb.addCircle(this.nzh.centerX(), this.nzh.centerY(), Math.min(this.nzh.width(), this.nzh.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.nyY.length; i++) {
                this.nyY[i] = (this.bxA[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.nzb.addRoundRect(this.nzh, this.nyY, Path.Direction.CW);
        }
        this.nzh.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.nzd) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.nza) {
                    if (this.nze == null) {
                        this.nze = new RectF(this.mBounds);
                        this.nzf = new Matrix();
                    } else {
                        this.nze.set(this.mBounds);
                    }
                    this.nze.inset(this.mBorderWidth, this.mBorderWidth);
                    this.nzf.setRectToRect(this.mBounds, this.nze, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.nzf);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.nzg);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.eZm) {
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
            canvas.drawPath(this.nzb, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
