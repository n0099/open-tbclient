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
    private final float[] jCZ = new float[8];
    final float[] jCK = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean jCH = false;
    private float mBorderWidth = 0.0f;
    private float jCV = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path cUM = new Path();
    private int mColor = 0;
    private final RectF jDa = new RectF();
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
            canvas.drawPath(this.cUM, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void rs(boolean z) {
        this.jCH = z;
        cvu();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jCZ, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jCZ, 0, 8);
        }
        cvu();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.jCZ, f);
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
        if (this.jCV != f) {
            this.jCV = f;
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
        this.cUM.reset();
        this.jDa.set(getBounds());
        this.jDa.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jCH) {
            this.cUM.addCircle(this.jDa.centerX(), this.jDa.centerY(), Math.min(this.jDa.width(), this.jDa.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jCK.length; i++) {
                this.jCK[i] = (this.jCZ[i] + this.jCV) - (this.mBorderWidth / 2.0f);
            }
            this.cUM.addRoundRect(this.jDa, this.jCK, Path.Direction.CW);
        }
        this.jDa.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.jDa.inset(this.jCV, this.jCV);
        if (this.jCH) {
            this.mPath.addCircle(this.jDa.centerX(), this.jDa.centerY(), Math.min(this.jDa.width(), this.jDa.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jDa, this.jCZ, Path.Direction.CW);
        }
        this.jDa.inset(-this.jCV, -this.jCV);
    }
}
