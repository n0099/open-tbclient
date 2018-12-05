package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundedCornersDrawable extends g implements j {
    private final Path bIx;
    Type ijB;
    private int ijC;
    private final RectF ijD;
    private boolean ijh;
    final float[] ijk;
    private float ijv;
    private final float[] ijz;
    private int mBorderColor;
    private float mBorderWidth;
    final Paint mPaint;
    private final Path mPath;

    /* loaded from: classes2.dex */
    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.ijB = Type.OVERLAY_COLOR;
        this.ijz = new float[8];
        this.ijk = new float[8];
        this.mPaint = new Paint(1);
        this.ijh = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.ijC = 0;
        this.ijv = 0.0f;
        this.mPath = new Path();
        this.bIx = new Path();
        this.ijD = new RectF();
    }

    @Override // com.facebook.drawee.drawable.j
    public void oU(boolean z) {
        this.ijh = z;
        bUR();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        Arrays.fill(this.ijz, f);
        bUR();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void e(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.ijz, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.ijz, 0, 8);
        }
        bUR();
        invalidateSelf();
    }

    public void setOverlayColor(int i) {
        this.ijC = i;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        bUR();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void aI(float f) {
        this.ijv = f;
        bUR();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bUR();
    }

    private void bUR() {
        this.mPath.reset();
        this.bIx.reset();
        this.ijD.set(getBounds());
        this.ijD.inset(this.ijv, this.ijv);
        if (this.ijh) {
            this.mPath.addCircle(this.ijD.centerX(), this.ijD.centerY(), Math.min(this.ijD.width(), this.ijD.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.ijD, this.ijz, Path.Direction.CW);
        }
        this.ijD.inset(-this.ijv, -this.ijv);
        this.ijD.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ijh) {
            this.bIx.addCircle(this.ijD.centerX(), this.ijD.centerY(), Math.min(this.ijD.width(), this.ijD.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.ijk.length; i++) {
                this.ijk[i] = (this.ijz[i] + this.ijv) - (this.mBorderWidth / 2.0f);
            }
            this.bIx.addRoundRect(this.ijD, this.ijk, Path.Direction.CW);
        }
        this.ijD.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        switch (this.ijB) {
            case CLIPPING:
                int save = canvas.save();
                this.mPath.setFillType(Path.FillType.EVEN_ODD);
                canvas.clipPath(this.mPath);
                super.draw(canvas);
                canvas.restoreToCount(save);
                break;
            case OVERLAY_COLOR:
                super.draw(canvas);
                this.mPaint.setColor(this.ijC);
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.ijh) {
                    float width = ((bounds.width() - bounds.height()) + this.mBorderWidth) / 2.0f;
                    float height = ((bounds.height() - bounds.width()) + this.mBorderWidth) / 2.0f;
                    if (width > 0.0f) {
                        canvas.drawRect(bounds.left, bounds.top, bounds.left + width, bounds.bottom, this.mPaint);
                        canvas.drawRect(bounds.right - width, bounds.top, bounds.right, bounds.bottom, this.mPaint);
                    }
                    if (height > 0.0f) {
                        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.top + height, this.mPaint);
                        canvas.drawRect(bounds.left, bounds.bottom - height, bounds.right, bounds.bottom, this.mPaint);
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
            canvas.drawPath(this.bIx, this.mPaint);
        }
    }
}
