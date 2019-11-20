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
    private final float[] asC = new float[8];
    final float[] kdB = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean kdy = false;
    private float mBorderWidth = 0.0f;
    private float kdM = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path dpj = new Path();
    private int mColor = 0;
    private final RectF kdQ = new RectF();
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
        cEy();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.cC(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.cC(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.dpj, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void sg(boolean z) {
        this.kdy = z;
        cEy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.asC, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.asC, 0, 8);
        }
        cEy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.asC, f);
        cEy();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void m(int i, float f) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            cEy();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aE(float f) {
        if (this.kdM != f) {
            this.kdM = f;
            cEy();
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
        return e.Cf(e.cC(this.mColor, this.mAlpha));
    }

    private void cEy() {
        this.mPath.reset();
        this.dpj.reset();
        this.kdQ.set(getBounds());
        this.kdQ.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.kdy) {
            this.dpj.addCircle(this.kdQ.centerX(), this.kdQ.centerY(), Math.min(this.kdQ.width(), this.kdQ.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.kdB.length; i++) {
                this.kdB[i] = (this.asC[i] + this.kdM) - (this.mBorderWidth / 2.0f);
            }
            this.dpj.addRoundRect(this.kdQ, this.kdB, Path.Direction.CW);
        }
        this.kdQ.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.kdQ.inset(this.kdM, this.kdM);
        if (this.kdy) {
            this.mPath.addCircle(this.kdQ.centerX(), this.kdQ.centerY(), Math.min(this.kdQ.width(), this.kdQ.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.kdQ, this.asC, Path.Direction.CW);
        }
        this.kdQ.inset(-this.kdM, -this.kdM);
    }
}
