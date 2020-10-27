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
    float[] oFL;
    private final float[] bGZ = new float[8];
    final float[] oFK = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean ftZ = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean oFM = false;
    final Path mPath = new Path();
    final Path oFN = new Path();
    private int mColor = 0;
    private final RectF oFO = new RectF();
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
        eih();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.dQ(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.dQ(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.oFN, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void zV(boolean z) {
        this.ftZ = z;
        eih();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bGZ, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bGZ, 0, 8);
        }
        eih();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bGZ, f);
        eih();
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
            eih();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bj(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            eih();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void zW(boolean z) {
        if (this.oFM != z) {
            this.oFM = z;
            eih();
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
        return e.Oi(e.dQ(this.mColor, this.mAlpha));
    }

    private void eih() {
        this.mPath.reset();
        this.oFN.reset();
        this.oFO.set(getBounds());
        this.oFO.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ftZ) {
            this.oFN.addCircle(this.oFO.centerX(), this.oFO.centerY(), Math.min(this.oFO.width(), this.oFO.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.oFK.length; i++) {
                this.oFK[i] = (this.bGZ[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.oFN.addRoundRect(this.oFO, this.oFK, Path.Direction.CW);
        }
        this.oFO.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.oFM ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.oFO.inset(f, f);
        if (this.ftZ) {
            this.mPath.addCircle(this.oFO.centerX(), this.oFO.centerY(), Math.min(this.oFO.width(), this.oFO.height()) / 2.0f, Path.Direction.CW);
        } else if (this.oFM) {
            if (this.oFL == null) {
                this.oFL = new float[8];
            }
            for (int i2 = 0; i2 < this.oFL.length; i2++) {
                this.oFL[i2] = this.bGZ[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.oFO, this.oFL, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.oFO, this.bGZ, Path.Direction.CW);
        }
        this.oFO.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
