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
    float[] mqG;
    private final float[] biU = new float[8];
    final float[] mqF = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean ewj = false;
    private float mBorderWidth = 0.0f;
    private float mqH = 0.0f;
    private int mBorderColor = 0;
    private boolean mqI = false;
    final Path mPath = new Path();
    final Path mqJ = new Path();
    private int mColor = 0;
    private final RectF mqK = new RectF();
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
        dwx();
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
            canvas.drawPath(this.mqJ, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void wd(boolean z) {
        this.ewj = z;
        dwx();
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
        dwx();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.biU, f);
        dwx();
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
            dwx();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aB(float f) {
        if (this.mqH != f) {
            this.mqH = f;
            dwx();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void we(boolean z) {
        if (this.mqI != z) {
            this.mqI = z;
            dwx();
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
        return e.Ha(e.dk(this.mColor, this.mAlpha));
    }

    private void dwx() {
        this.mPath.reset();
        this.mqJ.reset();
        this.mqK.set(getBounds());
        this.mqK.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ewj) {
            this.mqJ.addCircle(this.mqK.centerX(), this.mqK.centerY(), Math.min(this.mqK.width(), this.mqK.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.mqF.length; i++) {
                this.mqF[i] = (this.biU[i] + this.mqH) - (this.mBorderWidth / 2.0f);
            }
            this.mqJ.addRoundRect(this.mqK, this.mqF, Path.Direction.CW);
        }
        this.mqK.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.mqI ? this.mBorderWidth : 0.0f) + this.mqH;
        this.mqK.inset(f, f);
        if (this.ewj) {
            this.mPath.addCircle(this.mqK.centerX(), this.mqK.centerY(), Math.min(this.mqK.width(), this.mqK.height()) / 2.0f, Path.Direction.CW);
        } else if (this.mqI) {
            if (this.mqG == null) {
                this.mqG = new float[8];
            }
            for (int i2 = 0; i2 < this.mqG.length; i2++) {
                this.mqG[i2] = this.biU[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.mqK, this.mqG, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mqK, this.biU, Path.Direction.CW);
        }
        this.mqK.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
