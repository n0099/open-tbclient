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
    private final float[] jDt = new float[8];
    final float[] jDe = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean jDb = false;
    private float mBorderWidth = 0.0f;
    private float jDp = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path cUN = new Path();
    private int mColor = 0;
    private final RectF jDu = new RectF();
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
        cvo();
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
        this.jDb = z;
        cvo();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void f(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.jDt, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.jDt, 0, 8);
        }
        cvo();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.jDt, f);
        cvo();
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
            cvo();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aV(float f) {
        if (this.jDp != f) {
            this.jDp = f;
            cvo();
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
        return e.Cc(e.cA(this.mColor, this.mAlpha));
    }

    private void cvo() {
        this.mPath.reset();
        this.cUN.reset();
        this.jDu.set(getBounds());
        this.jDu.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jDb) {
            this.cUN.addCircle(this.jDu.centerX(), this.jDu.centerY(), Math.min(this.jDu.width(), this.jDu.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jDe.length; i++) {
                this.jDe[i] = (this.jDt[i] + this.jDp) - (this.mBorderWidth / 2.0f);
            }
            this.cUN.addRoundRect(this.jDu, this.jDe, Path.Direction.CW);
        }
        this.jDu.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.jDu.inset(this.jDp, this.jDp);
        if (this.jDb) {
            this.mPath.addCircle(this.jDu.centerX(), this.jDu.centerY(), Math.min(this.jDu.width(), this.jDu.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jDu, this.jDt, Path.Direction.CW);
        }
        this.jDu.inset(-this.jDp, -this.jDp);
    }
}
