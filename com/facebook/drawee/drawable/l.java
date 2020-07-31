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
    float[] mUR;
    private final float[] bos = new float[8];
    final float[] mUQ = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean eLL = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean mUS = false;
    final Path mPath = new Path();
    final Path mUT = new Path();
    private int mColor = 0;
    private final RectF mUU = new RectF();
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
        dEq();
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
            canvas.drawPath(this.mUT, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void xe(boolean z) {
        this.eLL = z;
        dEq();
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
        dEq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bos, f);
        dEq();
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
            dEq();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aG(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            dEq();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void xf(boolean z) {
        if (this.mUS != z) {
            this.mUS = z;
            dEq();
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

    private void dEq() {
        this.mPath.reset();
        this.mUT.reset();
        this.mUU.set(getBounds());
        this.mUU.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.eLL) {
            this.mUT.addCircle(this.mUU.centerX(), this.mUU.centerY(), Math.min(this.mUU.width(), this.mUU.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.mUQ.length; i++) {
                this.mUQ[i] = (this.bos[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.mUT.addRoundRect(this.mUU, this.mUQ, Path.Direction.CW);
        }
        this.mUU.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.mUS ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.mUU.inset(f, f);
        if (this.eLL) {
            this.mPath.addCircle(this.mUU.centerX(), this.mUU.centerY(), Math.min(this.mUU.width(), this.mUU.height()) / 2.0f, Path.Direction.CW);
        } else if (this.mUS) {
            if (this.mUR == null) {
                this.mUR = new float[8];
            }
            for (int i2 = 0; i2 < this.mUR.length; i2++) {
                this.mUR[i2] = this.bos[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.mUU, this.mUR, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mUU, this.bos, Path.Direction.CW);
        }
        this.mUU.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
