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
    private final float[] aFI;
    private final Path cfk;
    private boolean dIe;
    final float[] lOd;
    private boolean lOf;
    Type lOh;
    @Nullable
    private RectF lOi;
    @Nullable
    private Matrix lOj;
    private int lOk;
    private final RectF lOl;
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
        this.lOh = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.aFI = new float[8];
        this.lOd = new float[8];
        this.mPaint = new Paint(1);
        this.dIe = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.lOk = 0;
        this.mPadding = 0.0f;
        this.lOf = false;
        this.mPath = new Path();
        this.cfk = new Path();
        this.lOl = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vp(boolean z) {
        this.dIe = z;
        dmZ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.aFI, f);
        dmZ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.aFI, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.aFI, 0, 8);
        }
        dmZ();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.lOk = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dmZ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bm(float f) {
        this.mPadding = f;
        dmZ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vq(boolean z) {
        this.lOf = z;
        dmZ();
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
        dmZ();
    }

    private void dmZ() {
        this.mPath.reset();
        this.cfk.reset();
        this.lOl.set(getBounds());
        this.lOl.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.lOl, Path.Direction.CW);
        if (this.dIe) {
            this.mPath.addCircle(this.lOl.centerX(), this.lOl.centerY(), Math.min(this.lOl.width(), this.lOl.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lOl, this.aFI, Path.Direction.CW);
        }
        this.lOl.inset(-this.mPadding, -this.mPadding);
        this.lOl.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.dIe) {
            this.cfk.addCircle(this.lOl.centerX(), this.lOl.centerY(), Math.min(this.lOl.width(), this.lOl.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lOd.length; i++) {
                this.lOd[i] = (this.aFI[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.cfk.addRoundRect(this.lOl, this.lOd, Path.Direction.CW);
        }
        this.lOl.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.lOh) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.lOf) {
                    if (this.lOi == null) {
                        this.lOi = new RectF(this.mBounds);
                        this.lOj = new Matrix();
                    } else {
                        this.lOi.set(this.mBounds);
                    }
                    this.lOi.inset(this.mBorderWidth, this.mBorderWidth);
                    this.lOj.setRectToRect(this.mBounds, this.lOi, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.lOj);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lOk);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.dIe) {
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
            canvas.drawPath(this.cfk, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
