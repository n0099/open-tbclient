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
/* loaded from: classes15.dex */
public class l extends Drawable implements j {
    @Nullable
    float[] pCP;
    private final float[] bTG = new float[8];
    final float[] pCO = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean fOk = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean pCQ = false;
    final Path mPath = new Path();
    final Path eWn = new Path();
    private int mColor = 0;
    private final RectF pCR = new RectF();
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
        eut();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.dW(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.dW(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.eWn, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void Bn(boolean z) {
        this.fOk = z;
        eut();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bTG, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bTG, 0, 8);
        }
        eut();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bTG, f);
        eut();
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
            eut();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bI(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            eut();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void Bo(boolean z) {
        if (this.pCQ != z) {
            this.pCQ = z;
            eut();
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
        return e.Pg(e.dW(this.mColor, this.mAlpha));
    }

    private void eut() {
        this.mPath.reset();
        this.eWn.reset();
        this.pCR.set(getBounds());
        this.pCR.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.fOk) {
            this.eWn.addCircle(this.pCR.centerX(), this.pCR.centerY(), Math.min(this.pCR.width(), this.pCR.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.pCO.length; i++) {
                this.pCO[i] = (this.bTG[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.eWn.addRoundRect(this.pCR, this.pCO, Path.Direction.CW);
        }
        this.pCR.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.pCQ ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.pCR.inset(f, f);
        if (this.fOk) {
            this.mPath.addCircle(this.pCR.centerX(), this.pCR.centerY(), Math.min(this.pCR.width(), this.pCR.height()) / 2.0f, Path.Direction.CW);
        } else if (this.pCQ) {
            if (this.pCP == null) {
                this.pCP = new float[8];
            }
            for (int i2 = 0; i2 < this.pCP.length; i2++) {
                this.pCP[i2] = this.bTG[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.pCR, this.pCP, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.pCR, this.bTG, Path.Direction.CW);
        }
        this.pCR.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
