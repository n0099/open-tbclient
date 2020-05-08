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
    float[] lVD;
    private final float[] bbu = new float[8];
    final float[] lVC = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean ehQ = false;
    private float mBorderWidth = 0.0f;
    private float lVE = 0.0f;
    private int mBorderColor = 0;
    private boolean lVF = false;
    final Path mPath = new Path();
    final Path cEo = new Path();
    private int mColor = 0;
    private final RectF lVG = new RectF();
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
        doQ();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.df(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.df(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.cEo, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vD(boolean z) {
        this.ehQ = z;
        doQ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void y(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bbu, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bbu, 0, 8);
        }
        doQ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bbu, f);
        doQ();
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
            doQ();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aC(float f) {
        if (this.lVE != f) {
            this.lVE = f;
            doQ();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vE(boolean z) {
        if (this.lVF != z) {
            this.lVF = z;
            doQ();
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
        return e.Gm(e.df(this.mColor, this.mAlpha));
    }

    private void doQ() {
        this.mPath.reset();
        this.cEo.reset();
        this.lVG.set(getBounds());
        this.lVG.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ehQ) {
            this.cEo.addCircle(this.lVG.centerX(), this.lVG.centerY(), Math.min(this.lVG.width(), this.lVG.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lVC.length; i++) {
                this.lVC[i] = (this.bbu[i] + this.lVE) - (this.mBorderWidth / 2.0f);
            }
            this.cEo.addRoundRect(this.lVG, this.lVC, Path.Direction.CW);
        }
        this.lVG.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.lVF ? this.mBorderWidth : 0.0f) + this.lVE;
        this.lVG.inset(f, f);
        if (this.ehQ) {
            this.mPath.addCircle(this.lVG.centerX(), this.lVG.centerY(), Math.min(this.lVG.width(), this.lVG.height()) / 2.0f, Path.Direction.CW);
        } else if (this.lVF) {
            if (this.lVD == null) {
                this.lVD = new float[8];
            }
            for (int i2 = 0; i2 < this.lVD.length; i2++) {
                this.lVD[i2] = this.bbu[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.lVG, this.lVD, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lVG, this.bbu, Path.Direction.CW);
        }
        this.lVG.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
