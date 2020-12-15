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
/* loaded from: classes8.dex */
public class l extends Drawable implements j {
    @Nullable
    float[] pfS;
    private final float[] bPx = new float[8];
    final float[] pfR = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean fHb = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean pfT = false;
    final Path mPath = new Path();
    final Path eOJ = new Path();
    private int mColor = 0;
    private final RectF pfU = new RectF();
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
        erK();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.dZ(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.dZ(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.eOJ, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void AQ(boolean z) {
        this.fHb = z;
        erK();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void A(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bPx, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bPx, 0, 8);
        }
        erK();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bPx, f);
        erK();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            erK();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bt(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            erK();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void AR(boolean z) {
        if (this.pfT != z) {
            this.pfT = z;
            erK();
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
        return e.Qe(e.dZ(this.mColor, this.mAlpha));
    }

    private void erK() {
        this.mPath.reset();
        this.eOJ.reset();
        this.pfU.set(getBounds());
        this.pfU.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.fHb) {
            this.eOJ.addCircle(this.pfU.centerX(), this.pfU.centerY(), Math.min(this.pfU.width(), this.pfU.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.pfR.length; i++) {
                this.pfR[i] = (this.bPx[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.eOJ.addRoundRect(this.pfU, this.pfR, Path.Direction.CW);
        }
        this.pfU.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.pfT ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.pfU.inset(f, f);
        if (this.fHb) {
            this.mPath.addCircle(this.pfU.centerX(), this.pfU.centerY(), Math.min(this.pfU.width(), this.pfU.height()) / 2.0f, Path.Direction.CW);
        } else if (this.pfT) {
            if (this.pfS == null) {
                this.pfS = new float[8];
            }
            for (int i2 = 0; i2 < this.pfS.length; i2++) {
                this.pfS[i2] = this.bPx[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.pfU, this.pfS, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.pfU, this.bPx, Path.Direction.CW);
        }
        this.pfU.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
