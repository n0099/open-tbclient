package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class l extends Drawable implements j {
    private final float[] iaC = new float[8];
    final float[] ian = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean iak = false;
    private float mBorderWidth = 0.0f;
    private float iay = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path bEi = new Path();
    private int mColor = 0;
    private final RectF iaD = new RectF();
    private int mAlpha = 255;

    public l(int i) {
        setColor(i);
    }

    public static l a(ColorDrawable colorDrawable) {
        return new l(colorDrawable.getColor());
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bTq();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.cd(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.cd(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.bEi, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void oE(boolean z) {
        this.iak = z;
        bTq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void e(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.iaC, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.iaC, 0, 8);
        }
        bTq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.iaC, f);
        bTq();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            bTq();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aG(float f) {
        if (this.iay != f) {
            this.iay = f;
            bTq();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return e.xl(e.cd(this.mColor, this.mAlpha));
    }

    private void bTq() {
        this.mPath.reset();
        this.bEi.reset();
        this.iaD.set(getBounds());
        this.iaD.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.iak) {
            this.bEi.addCircle(this.iaD.centerX(), this.iaD.centerY(), Math.min(this.iaD.width(), this.iaD.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.ian.length; i++) {
                this.ian[i] = (this.iaC[i] + this.iay) - (this.mBorderWidth / 2.0f);
            }
            this.bEi.addRoundRect(this.iaD, this.ian, Path.Direction.CW);
        }
        this.iaD.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.iaD.inset(this.iay, this.iay);
        if (this.iak) {
            this.mPath.addCircle(this.iaD.centerX(), this.iaD.centerY(), Math.min(this.iaD.width(), this.iaD.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.iaD, this.iaC, Path.Direction.CW);
        }
        this.iaD.inset(-this.iay, -this.iay);
    }
}
