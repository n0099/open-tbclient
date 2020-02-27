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
    float[] lMl;
    private final float[] aFs = new float[8];
    final float[] lMk = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean dHA = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean lMm = false;
    final Path mPath = new Path();
    final Path ceX = new Path();
    private int mColor = 0;
    private final RectF lMn = new RectF();
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
        dmz();
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
            canvas.drawPath(this.ceX, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vi(boolean z) {
        this.dHA = z;
        dmz();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.aFs, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.aFs, 0, 8);
        }
        dmz();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.aFs, f);
        dmz();
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
            dmz();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bm(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            dmz();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vj(boolean z) {
        if (this.lMm != z) {
            this.lMm = z;
            dmz();
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

    private void dmz() {
        this.mPath.reset();
        this.ceX.reset();
        this.lMn.set(getBounds());
        this.lMn.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.dHA) {
            this.ceX.addCircle(this.lMn.centerX(), this.lMn.centerY(), Math.min(this.lMn.width(), this.lMn.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lMk.length; i++) {
                this.lMk[i] = (this.aFs[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.ceX.addRoundRect(this.lMn, this.lMk, Path.Direction.CW);
        }
        this.lMn.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.lMm ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.lMn.inset(f, f);
        if (this.dHA) {
            this.mPath.addCircle(this.lMn.centerX(), this.lMn.centerY(), Math.min(this.lMn.width(), this.lMn.height()) / 2.0f, Path.Direction.CW);
        } else if (this.lMm) {
            if (this.lMl == null) {
                this.lMl = new float[8];
            }
            for (int i2 = 0; i2 < this.lMl.length; i2++) {
                this.lMl[i2] = this.aFs[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.lMn, this.lMl, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lMn, this.aFs, Path.Direction.CW);
        }
        this.lMn.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
