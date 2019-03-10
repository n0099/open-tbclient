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
    private final float[] jDM = new float[8];
    final float[] jDx = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean jDu = false;
    private float mBorderWidth = 0.0f;
    private float jDI = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path cUN = new Path();
    private int mColor = 0;
    private final RectF jDN = new RectF();
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
        cvy();
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
            canvas.drawPath(this.cUN, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jDu = z;
        cvy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jDM, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jDM, 0, 8);
        }
        cvy();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.jDM, f);
        cvy();
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
            cvy();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        if (this.jDI != f) {
            this.jDI = f;
            cvy();
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

    private void cvy() {
        this.mPath.reset();
        this.cUN.reset();
        this.jDN.set(getBounds());
        this.jDN.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jDu) {
            this.cUN.addCircle(this.jDN.centerX(), this.jDN.centerY(), Math.min(this.jDN.width(), this.jDN.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jDx.length; i++) {
                this.jDx[i] = (this.jDM[i] + this.jDI) - (this.mBorderWidth / 2.0f);
            }
            this.cUN.addRoundRect(this.jDN, this.jDx, Path.Direction.CW);
        }
        this.jDN.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.jDN.inset(this.jDI, this.jDI);
        if (this.jDu) {
            this.mPath.addCircle(this.jDN.centerX(), this.jDN.centerY(), Math.min(this.jDN.width(), this.jDN.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jDN, this.jDM, Path.Direction.CW);
        }
        this.jDN.inset(-this.jDI, -this.jDI);
    }
}
