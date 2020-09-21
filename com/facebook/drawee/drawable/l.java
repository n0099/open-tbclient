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
/* loaded from: classes11.dex */
public class l extends Drawable implements j {
    @Nullable
    float[] nyZ;
    private final float[] bxA = new float[8];
    final float[] nyY = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean eZm = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean nza = false;
    final Path mPath = new Path();
    final Path nzb = new Path();
    private int mColor = 0;
    private final RectF nzc = new RectF();
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
        dUy();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.dH(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.dH(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.nzb, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void yg(boolean z) {
        this.eZm = z;
        dUy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bxA, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bxA, 0, 8);
        }
        dUy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bxA, f);
        dUy();
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
            dUy();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aM(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            dUy();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void yh(boolean z) {
        if (this.nza != z) {
            this.nza = z;
            dUy();
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
        return e.LL(e.dH(this.mColor, this.mAlpha));
    }

    private void dUy() {
        this.mPath.reset();
        this.nzb.reset();
        this.nzc.set(getBounds());
        this.nzc.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.eZm) {
            this.nzb.addCircle(this.nzc.centerX(), this.nzc.centerY(), Math.min(this.nzc.width(), this.nzc.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.nyY.length; i++) {
                this.nyY[i] = (this.bxA[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.nzb.addRoundRect(this.nzc, this.nyY, Path.Direction.CW);
        }
        this.nzc.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.nza ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.nzc.inset(f, f);
        if (this.eZm) {
            this.mPath.addCircle(this.nzc.centerX(), this.nzc.centerY(), Math.min(this.nzc.width(), this.nzc.height()) / 2.0f, Path.Direction.CW);
        } else if (this.nza) {
            if (this.nyZ == null) {
                this.nyZ = new float[8];
            }
            for (int i2 = 0; i2 < this.nyZ.length; i2++) {
                this.nyZ[i2] = this.bxA[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.nzc, this.nyZ, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.nzc, this.bxA, Path.Direction.CW);
        }
        this.nzc.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
