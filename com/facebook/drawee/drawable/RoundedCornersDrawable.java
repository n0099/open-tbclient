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
    private final float[] aFs;
    private final Path ceX;
    private boolean dHA;
    final float[] lMk;
    private boolean lMm;
    Type lMo;
    @Nullable
    private RectF lMp;
    @Nullable
    private Matrix lMq;
    private int lMr;
    private final RectF lMs;
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
        this.lMo = Type.OVERLAY_COLOR;
        this.mBounds = new RectF();
        this.aFs = new float[8];
        this.lMk = new float[8];
        this.mPaint = new Paint(1);
        this.dHA = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.lMr = 0;
        this.mPadding = 0.0f;
        this.lMm = false;
        this.mPath = new Path();
        this.ceX = new Path();
        this.lMs = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vi(boolean z) {
        this.dHA = z;
        dmz();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.aFs, f);
        dmz();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.aFs, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.aFs, 0, 8);
        }
        dmz();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.lMr = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        dmz();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void bm(float f) {
        this.mPadding = f;
        dmz();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void vj(boolean z) {
        this.lMm = z;
        dmz();
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
        dmz();
    }

    private void dmz() {
        this.mPath.reset();
        this.ceX.reset();
        this.lMs.set(getBounds());
        this.lMs.inset(this.mPadding, this.mPadding);
        this.mPath.addRect(this.lMs, Path.Direction.CW);
        if (this.dHA) {
            this.mPath.addCircle(this.lMs.centerX(), this.lMs.centerY(), Math.min(this.lMs.width(), this.lMs.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lMs, this.aFs, Path.Direction.CW);
        }
        this.lMs.inset(-this.mPadding, -this.mPadding);
        this.lMs.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.dHA) {
            this.ceX.addCircle(this.lMs.centerX(), this.lMs.centerY(), Math.min(this.lMs.width(), this.lMs.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lMk.length; i++) {
                this.lMk[i] = (this.aFs[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.ceX.addRoundRect(this.lMs, this.lMk, Path.Direction.CW);
        }
        this.lMs.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        switch (this.lMo) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                if (this.lMm) {
                    if (this.lMp == null) {
                        this.lMp = new RectF(this.mBounds);
                        this.lMq = new Matrix();
                    } else {
                        this.lMp.set(this.mBounds);
                    }
                    this.lMp.inset(this.mBorderWidth, this.mBorderWidth);
                    this.lMq.setRectToRect(this.mBounds, this.lMp, Matrix.ScaleToFit.FILL);
                    int save2 = canvas.save();
                    canvas.clipRect(this.mBounds);
                    canvas.concat(this.lMq);
                    super.draw(canvas);
                    canvas.restoreToCount(save2);
                } else {
                    super.draw(canvas);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lMr);
                this.mPaint.setStrokeWidth(0.0f);
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.dHA) {
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
            canvas.drawPath(this.ceX, this.mPaint);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
