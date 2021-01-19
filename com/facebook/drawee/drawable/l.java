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
/* loaded from: classes3.dex */
public class l extends Drawable implements j {
    @Nullable
    float[] psG;
    private final float[] bPQ = new float[8];
    final float[] psF = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean fLW = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean psH = false;
    final Path mPath = new Path();
    final Path eTX = new Path();
    private int mColor = 0;
    private final RectF psI = new RectF();
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
        esb();
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
            canvas.drawPath(this.eTX, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void AU(boolean z) {
        this.fLW = z;
        esb();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bPQ, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bPQ, 0, 8);
        }
        esb();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bPQ, f);
        esb();
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
            esb();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bF(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            esb();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void AV(boolean z) {
        if (this.psH != z) {
            this.psH = z;
            esb();
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
        return e.OL(e.dZ(this.mColor, this.mAlpha));
    }

    private void esb() {
        this.mPath.reset();
        this.eTX.reset();
        this.psI.set(getBounds());
        this.psI.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.fLW) {
            this.eTX.addCircle(this.psI.centerX(), this.psI.centerY(), Math.min(this.psI.width(), this.psI.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.psF.length; i++) {
                this.psF[i] = (this.bPQ[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.eTX.addRoundRect(this.psI, this.psF, Path.Direction.CW);
        }
        this.psI.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.psH ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.psI.inset(f, f);
        if (this.fLW) {
            this.mPath.addCircle(this.psI.centerX(), this.psI.centerY(), Math.min(this.psI.width(), this.psI.height()) / 2.0f, Path.Direction.CW);
        } else if (this.psH) {
            if (this.psG == null) {
                this.psG = new float[8];
            }
            for (int i2 = 0; i2 < this.psG.length; i2++) {
                this.psG[i2] = this.bPQ[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.psI, this.psG, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.psI, this.bPQ, Path.Direction.CW);
        }
        this.psI.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
