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
    float[] lMy;
    private final float[] aFu = new float[8];
    final float[] lMx = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean dHO = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean lMz = false;
    final Path mPath = new Path();
    final Path ceZ = new Path();
    private int mColor = 0;
    private final RectF lMA = new RectF();
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
        dmC();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.du(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.du(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.ceZ, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vi(boolean z) {
        this.dHO = z;
        dmC();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.aFu, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.aFu, 0, 8);
        }
        dmC();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.aFu, f);
        dmC();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            dmC();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bm(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            dmC();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vj(boolean z) {
        if (this.lMz != z) {
            this.lMz = z;
            dmC();
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
        return e.HF(e.du(this.mColor, this.mAlpha));
    }

    private void dmC() {
        this.mPath.reset();
        this.ceZ.reset();
        this.lMA.set(getBounds());
        this.lMA.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.dHO) {
            this.ceZ.addCircle(this.lMA.centerX(), this.lMA.centerY(), Math.min(this.lMA.width(), this.lMA.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lMx.length; i++) {
                this.lMx[i] = (this.aFu[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.ceZ.addRoundRect(this.lMA, this.lMx, Path.Direction.CW);
        }
        this.lMA.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.lMz ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.lMA.inset(f, f);
        if (this.dHO) {
            this.mPath.addCircle(this.lMA.centerX(), this.lMA.centerY(), Math.min(this.lMA.width(), this.lMA.height()) / 2.0f, Path.Direction.CW);
        } else if (this.lMz) {
            if (this.lMy == null) {
                this.lMy = new float[8];
            }
            for (int i2 = 0; i2 < this.lMy.length; i2++) {
                this.lMy[i2] = this.aFu[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.lMA, this.lMy, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lMA, this.aFu, Path.Direction.CW);
        }
        this.lMA.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
