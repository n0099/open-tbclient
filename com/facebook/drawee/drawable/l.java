package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class l extends Drawable implements j {
    private final float[] inT = new float[8];
    final float[] inE = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean inB = false;
    private float mBorderWidth = 0.0f;
    private float inP = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path bJo = new Path();
    private int mColor = 0;
    private final RectF inU = new RectF();
    private int mAlpha = 255;

    public l(int i) {
        setColor(i);
    }

    public static l a(ColorDrawable colorDrawable) {
        return new l(colorDrawable.getColor());
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bWp();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.cf(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.cf(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.bJo, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void oY(boolean z) {
        this.inB = z;
        bWp();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.inT, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.inT, 0, 8);
        }
        bWp();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.inT, f);
        bWp();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(int i, float f) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            bWp();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aI(float f) {
        if (this.inP != f) {
            this.inP = f;
            bWp();
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
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return e.yq(e.cf(this.mColor, this.mAlpha));
    }

    private void bWp() {
        this.mPath.reset();
        this.bJo.reset();
        this.inU.set(getBounds());
        this.inU.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.inB) {
            this.bJo.addCircle(this.inU.centerX(), this.inU.centerY(), Math.min(this.inU.width(), this.inU.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.inE.length; i++) {
                this.inE[i] = (this.inT[i] + this.inP) - (this.mBorderWidth / 2.0f);
            }
            this.bJo.addRoundRect(this.inU, this.inE, Path.Direction.CW);
        }
        this.inU.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.inU.inset(this.inP, this.inP);
        if (this.inB) {
            this.mPath.addCircle(this.inU.centerX(), this.inU.centerY(), Math.min(this.inU.width(), this.inU.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.inU, this.inT, Path.Direction.CW);
        }
        this.inU.inset(-this.inP, -this.inP);
    }
}
