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
    private final float[] bcx = new float[8];
    final float[] kgk = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean kgh = false;
    private float mBorderWidth = 0.0f;
    private float kgv = 0.0f;
    private int GW = 0;
    final Path mPath = new Path();
    final Path dgE = new Path();
    private int mColor = 0;
    private final RectF kgz = new RectF();
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
        cHC();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.cL(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.cL(this.GW, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.dgE, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void sB(boolean z) {
        this.kgh = z;
        cHC();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bcx, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bcx, 0, 8);
        }
        cHC();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bcx, f);
        cHC();
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
            cHC();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bb(float f) {
        if (this.kgv != f) {
            this.kgv = f;
            cHC();
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
        return e.DK(e.cL(this.mColor, this.mAlpha));
    }

    private void cHC() {
        this.mPath.reset();
        this.dgE.reset();
        this.kgz.set(getBounds());
        this.kgz.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.kgh) {
            this.dgE.addCircle(this.kgz.centerX(), this.kgz.centerY(), Math.min(this.kgz.width(), this.kgz.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.kgk.length; i++) {
                this.kgk[i] = (this.bcx[i] + this.kgv) - (this.mBorderWidth / 2.0f);
            }
            this.dgE.addRoundRect(this.kgz, this.kgk, Path.Direction.CW);
        }
        this.kgz.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.kgz.inset(this.kgv, this.kgv);
        if (this.kgh) {
            this.mPath.addCircle(this.kgz.centerX(), this.kgz.centerY(), Math.min(this.kgz.width(), this.kgz.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.kgz, this.bcx, Path.Direction.CW);
        }
        this.kgz.inset(-this.kgv, -this.kgv);
    }
}
