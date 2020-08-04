package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class l extends Drawable implements j {
    @Nullable
    float[] mUT;
    private final float[] bos = new float[8];
    final float[] mUS = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean eLL = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean mUU = false;
    final Path mPath = new Path();
    final Path mUV = new Path();
    private int mColor = 0;
    private final RectF mUW = new RectF();
    private int mAlpha = 255;

    public l(int i) {
        setColor(i);
    }

    @TargetApi(11)
    public static l a(ColorDrawable colorDrawable) {
        return new l(colorDrawable.getColor());
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        dEr();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.dv(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.dv(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.mUV, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void xe(boolean z) {
        this.eLL = z;
        dEr();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bos, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bos, 0, 8);
        }
        dEr();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bos, f);
        dEr();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            dEr();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aG(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            dEr();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void xf(boolean z) {
        if (this.mUU != z) {
            this.mUU = z;
            dEr();
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
        a(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return e.IC(e.dv(this.mColor, this.mAlpha));
    }

    private void dEr() {
        this.mPath.reset();
        this.mUV.reset();
        this.mUW.set(getBounds());
        this.mUW.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.eLL) {
            this.mUV.addCircle(this.mUW.centerX(), this.mUW.centerY(), Math.min(this.mUW.width(), this.mUW.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.mUS.length; i++) {
                this.mUS[i] = (this.bos[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.mUV.addRoundRect(this.mUW, this.mUS, Path.Direction.CW);
        }
        this.mUW.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.mUU ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.mUW.inset(f, f);
        if (this.eLL) {
            this.mPath.addCircle(this.mUW.centerX(), this.mUW.centerY(), Math.min(this.mUW.width(), this.mUW.height()) / 2.0f, Path.Direction.CW);
        } else if (this.mUU) {
            if (this.mUT == null) {
                this.mUT = new float[8];
            }
            for (int i2 = 0; i2 < this.mUT.length; i2++) {
                this.mUT[i2] = this.bos[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.mUW, this.mUT, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mUW, this.bos, Path.Direction.CW);
        }
        this.mUW.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
