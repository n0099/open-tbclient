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
    private final float[] jCY = new float[8];
    final float[] jCJ = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean jCG = false;
    private float mBorderWidth = 0.0f;
    private float jCU = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path cUL = new Path();
    private int mColor = 0;
    private final RectF jCZ = new RectF();
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
        cvu();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.cA(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.cA(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.cUL, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jCG = z;
        cvu();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jCY, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jCY, 0, 8);
        }
        cvu();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.jCY, f);
        cvu();
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
            cvu();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        if (this.jCU != f) {
            this.jCU = f;
            cvu();
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
        return e.BT(e.cA(this.mColor, this.mAlpha));
    }

    private void cvu() {
        this.mPath.reset();
        this.cUL.reset();
        this.jCZ.set(getBounds());
        this.jCZ.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jCG) {
            this.cUL.addCircle(this.jCZ.centerX(), this.jCZ.centerY(), Math.min(this.jCZ.width(), this.jCZ.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jCJ.length; i++) {
                this.jCJ[i] = (this.jCY[i] + this.jCU) - (this.mBorderWidth / 2.0f);
            }
            this.cUL.addRoundRect(this.jCZ, this.jCJ, Path.Direction.CW);
        }
        this.jCZ.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.jCZ.inset(this.jCU, this.jCU);
        if (this.jCG) {
            this.mPath.addCircle(this.jCZ.centerX(), this.jCZ.centerY(), Math.min(this.jCZ.width(), this.jCZ.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jCZ, this.jCY, Path.Direction.CW);
        }
        this.jCZ.inset(-this.jCU, -this.jCU);
    }
}
