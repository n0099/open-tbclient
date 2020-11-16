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
/* loaded from: classes14.dex */
public class l extends Drawable implements j {
    @Nullable
    float[] oQI;
    private final float[] bKU = new float[8];
    final float[] oQH = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean fzm = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean oQJ = false;
    final Path mPath = new Path();
    final Path eHz = new Path();
    private int mColor = 0;
    private final RectF oQK = new RectF();
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
        elU();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.dU(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.dU(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.eHz, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void An(boolean z) {
        this.fzm = z;
        elU();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void B(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bKU, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bKU, 0, 8);
        }
        elU();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bKU, f);
        elU();
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
            elU();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bs(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            elU();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void Ao(boolean z) {
        if (this.oQJ != z) {
            this.oQJ = z;
            elU();
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
        return e.Pg(e.dU(this.mColor, this.mAlpha));
    }

    private void elU() {
        this.mPath.reset();
        this.eHz.reset();
        this.oQK.set(getBounds());
        this.oQK.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.fzm) {
            this.eHz.addCircle(this.oQK.centerX(), this.oQK.centerY(), Math.min(this.oQK.width(), this.oQK.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.oQH.length; i++) {
                this.oQH[i] = (this.bKU[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.eHz.addRoundRect(this.oQK, this.oQH, Path.Direction.CW);
        }
        this.oQK.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.oQJ ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.oQK.inset(f, f);
        if (this.fzm) {
            this.mPath.addCircle(this.oQK.centerX(), this.oQK.centerY(), Math.min(this.oQK.width(), this.oQK.height()) / 2.0f, Path.Direction.CW);
        } else if (this.oQJ) {
            if (this.oQI == null) {
                this.oQI = new float[8];
            }
            for (int i2 = 0; i2 < this.oQI.length; i2++) {
                this.oQI[i2] = this.bKU[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.oQK, this.oQI, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.oQK, this.bKU, Path.Direction.CW);
        }
        this.oQK.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
