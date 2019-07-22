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
    private final float[] bbZ = new float[8];
    final float[] kcG = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean kcD = false;
    private float mBorderWidth = 0.0f;
    private float kcR = 0.0f;
    private int GW = 0;
    final Path mPath = new Path();
    final Path deM = new Path();
    private int mColor = 0;
    private final RectF kcV = new RectF();
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
        cGt();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.cM(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.cM(this.GW, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.deM, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void sx(boolean z) {
        this.kcD = z;
        cGt();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bbZ, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bbZ, 0, 8);
        }
        cGt();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bbZ, f);
        cGt();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void l(int i, float f) {
        if (this.GW != i) {
            this.GW = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            cGt();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void ba(float f) {
        if (this.kcR != f) {
            this.kcR = f;
            cGt();
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
        return e.DE(e.cM(this.mColor, this.mAlpha));
    }

    private void cGt() {
        this.mPath.reset();
        this.deM.reset();
        this.kcV.set(getBounds());
        this.kcV.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.kcD) {
            this.deM.addCircle(this.kcV.centerX(), this.kcV.centerY(), Math.min(this.kcV.width(), this.kcV.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.kcG.length; i++) {
                this.kcG[i] = (this.bbZ[i] + this.kcR) - (this.mBorderWidth / 2.0f);
            }
            this.deM.addRoundRect(this.kcV, this.kcG, Path.Direction.CW);
        }
        this.kcV.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.kcV.inset(this.kcR, this.kcR);
        if (this.kcD) {
            this.mPath.addCircle(this.kcV.centerX(), this.kcV.centerY(), Math.min(this.kcV.width(), this.kcV.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.kcV, this.bbZ, Path.Direction.CW);
        }
        this.kcV.inset(-this.kcR, -this.kcR);
    }
}
