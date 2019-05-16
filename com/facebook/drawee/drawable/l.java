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
    private final float[] bbo = new float[8];
    final float[] jVy = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean jVv = false;
    private float mBorderWidth = 0.0f;
    private float jVJ = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path ddj = new Path();
    private int mColor = 0;
    private final RectF jVN = new RectF();
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
        cDq();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.cH(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.cH(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.ddj, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void sh(boolean z) {
        this.jVv = z;
        cDq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bbo, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bbo, 0, 8);
        }
        cDq();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bbo, f);
        cDq();
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
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            cDq();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aZ(float f) {
        if (this.jVJ != f) {
            this.jVJ = f;
            cDq();
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
        return e.CX(e.cH(this.mColor, this.mAlpha));
    }

    private void cDq() {
        this.mPath.reset();
        this.ddj.reset();
        this.jVN.set(getBounds());
        this.jVN.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jVv) {
            this.ddj.addCircle(this.jVN.centerX(), this.jVN.centerY(), Math.min(this.jVN.width(), this.jVN.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jVy.length; i++) {
                this.jVy[i] = (this.bbo[i] + this.jVJ) - (this.mBorderWidth / 2.0f);
            }
            this.ddj.addRoundRect(this.jVN, this.jVy, Path.Direction.CW);
        }
        this.jVN.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.jVN.inset(this.jVJ, this.jVJ);
        if (this.jVv) {
            this.mPath.addCircle(this.jVN.centerX(), this.jVN.centerY(), Math.min(this.jVN.width(), this.jVN.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jVN, this.bbo, Path.Direction.CW);
        }
        this.jVN.inset(-this.jVJ, -this.jVJ);
    }
}
