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
    private final float[] jDE = new float[8];
    final float[] jDp = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean jDm = false;
    private float mBorderWidth = 0.0f;
    private float jDA = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path cUJ = new Path();
    private int mColor = 0;
    private final RectF jDF = new RectF();
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
        cvB();
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
            canvas.drawPath(this.cUJ, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jDm = z;
        cvB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jDE, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jDE, 0, 8);
        }
        cvB();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.jDE, f);
        cvB();
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
            cvB();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        if (this.jDA != f) {
            this.jDA = f;
            cvB();
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
        return e.Cd(e.cA(this.mColor, this.mAlpha));
    }

    private void cvB() {
        this.mPath.reset();
        this.cUJ.reset();
        this.jDF.set(getBounds());
        this.jDF.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jDm) {
            this.cUJ.addCircle(this.jDF.centerX(), this.jDF.centerY(), Math.min(this.jDF.width(), this.jDF.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jDp.length; i++) {
                this.jDp[i] = (this.jDE[i] + this.jDA) - (this.mBorderWidth / 2.0f);
            }
            this.cUJ.addRoundRect(this.jDF, this.jDp, Path.Direction.CW);
        }
        this.jDF.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.jDF.inset(this.jDA, this.jDA);
        if (this.jDm) {
            this.mPath.addCircle(this.jDF.centerX(), this.jDF.centerY(), Math.min(this.jDF.width(), this.jDF.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jDF, this.jDE, Path.Direction.CW);
        }
        this.jDF.inset(-this.jDA, -this.jDA);
    }
}
