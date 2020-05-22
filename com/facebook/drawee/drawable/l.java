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
/* loaded from: classes13.dex */
public class l extends Drawable implements j {
    @Nullable
    float[] mpw;
    private final float[] biU = new float[8];
    final float[] mpv = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean ewj = false;
    private float mBorderWidth = 0.0f;
    private float mpx = 0.0f;
    private int mBorderColor = 0;
    private boolean mpy = false;
    final Path mPath = new Path();
    final Path mpz = new Path();
    private int mColor = 0;
    private final RectF mpA = new RectF();
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
        dwj();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.dk(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.dk(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.mpz, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void wb(boolean z) {
        this.ewj = z;
        dwj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void y(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.biU, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.biU, 0, 8);
        }
        dwj();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.biU, f);
        dwj();
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
            dwj();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aB(float f) {
        if (this.mpx != f) {
            this.mpx = f;
            dwj();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void wc(boolean z) {
        if (this.mpy != z) {
            this.mpy = z;
            dwj();
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
        return e.GY(e.dk(this.mColor, this.mAlpha));
    }

    private void dwj() {
        this.mPath.reset();
        this.mpz.reset();
        this.mpA.set(getBounds());
        this.mpA.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ewj) {
            this.mpz.addCircle(this.mpA.centerX(), this.mpA.centerY(), Math.min(this.mpA.width(), this.mpA.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.mpv.length; i++) {
                this.mpv[i] = (this.biU[i] + this.mpx) - (this.mBorderWidth / 2.0f);
            }
            this.mpz.addRoundRect(this.mpA, this.mpv, Path.Direction.CW);
        }
        this.mpA.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.mpy ? this.mBorderWidth : 0.0f) + this.mpx;
        this.mpA.inset(f, f);
        if (this.ewj) {
            this.mPath.addCircle(this.mpA.centerX(), this.mpA.centerY(), Math.min(this.mpA.width(), this.mpA.height()) / 2.0f, Path.Direction.CW);
        } else if (this.mpy) {
            if (this.mpw == null) {
                this.mpw = new float[8];
            }
            for (int i2 = 0; i2 < this.mpw.length; i2++) {
                this.mpw[i2] = this.biU[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.mpA, this.mpw, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mpA, this.biU, Path.Direction.CW);
        }
        this.mpA.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
