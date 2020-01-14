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
/* loaded from: classes12.dex */
public class l extends Drawable implements j {
    @Nullable
    float[] lLE;
    private final float[] aBc = new float[8];
    final float[] lLD = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean dDw = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean lLF = false;
    final Path mPath = new Path();
    final Path caR = new Path();
    private int mColor = 0;
    private final RectF lLG = new RectF();
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
        dlm();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.dr(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.dr(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.caR, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void ve(boolean z) {
        this.dDw = z;
        dlm();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.aBc, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.aBc, 0, 8);
        }
        dlm();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.aBc, f);
        dlm();
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
            dlm();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bn(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            dlm();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vf(boolean z) {
        if (this.lLF != z) {
            this.lLF = z;
            dlm();
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
        return e.HA(e.dr(this.mColor, this.mAlpha));
    }

    private void dlm() {
        this.mPath.reset();
        this.caR.reset();
        this.lLG.set(getBounds());
        this.lLG.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.dDw) {
            this.caR.addCircle(this.lLG.centerX(), this.lLG.centerY(), Math.min(this.lLG.width(), this.lLG.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lLD.length; i++) {
                this.lLD[i] = (this.aBc[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.caR.addRoundRect(this.lLG, this.lLD, Path.Direction.CW);
        }
        this.lLG.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.lLF ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.lLG.inset(f, f);
        if (this.dDw) {
            this.mPath.addCircle(this.lLG.centerX(), this.lLG.centerY(), Math.min(this.lLG.width(), this.lLG.height()) / 2.0f, Path.Direction.CW);
        } else if (this.lLF) {
            if (this.lLE == null) {
                this.lLE = new float[8];
            }
            for (int i2 = 0; i2 < this.lLE.length; i2++) {
                this.lLE[i2] = this.aBc[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.lLG, this.lLE, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lLG, this.aBc, Path.Direction.CW);
        }
        this.lLG.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
