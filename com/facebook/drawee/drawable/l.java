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
    private final float[] ijz = new float[8];
    final float[] ijk = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean ijh = false;
    private float mBorderWidth = 0.0f;
    private float ijv = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path bIx = new Path();
    private int mColor = 0;
    private final RectF ijA = new RectF();
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
        bUQ();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.ce(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.ce(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.bIx, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void oU(boolean z) {
        this.ijh = z;
        bUQ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void e(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.ijz, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.ijz, 0, 8);
        }
        bUQ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.ijz, f);
        bUQ();
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
            bUQ();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aI(float f) {
        if (this.ijv != f) {
            this.ijv = f;
            bUQ();
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
        return e.yb(e.ce(this.mColor, this.mAlpha));
    }

    private void bUQ() {
        this.mPath.reset();
        this.bIx.reset();
        this.ijA.set(getBounds());
        this.ijA.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.ijh) {
            this.bIx.addCircle(this.ijA.centerX(), this.ijA.centerY(), Math.min(this.ijA.width(), this.ijA.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.ijk.length; i++) {
                this.ijk[i] = (this.ijz[i] + this.ijv) - (this.mBorderWidth / 2.0f);
            }
            this.bIx.addRoundRect(this.ijA, this.ijk, Path.Direction.CW);
        }
        this.ijA.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.ijA.inset(this.ijv, this.ijv);
        if (this.ijh) {
            this.mPath.addCircle(this.ijA.centerX(), this.ijA.centerY(), Math.min(this.ijA.width(), this.ijA.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.ijA, this.ijz, Path.Direction.CW);
        }
        this.ijA.inset(-this.ijv, -this.ijv);
    }
}
