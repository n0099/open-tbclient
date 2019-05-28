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
    final float[] jVz = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean jVw = false;
    private float mBorderWidth = 0.0f;
    private float jVK = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path ddk = new Path();
    private int mColor = 0;
    private final RectF jVO = new RectF();
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
        cDs();
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
            canvas.drawPath(this.ddk, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void sh(boolean z) {
        this.jVw = z;
        cDs();
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
        cDs();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bbo, f);
        cDs();
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
            cDs();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aZ(float f) {
        if (this.jVK != f) {
            this.jVK = f;
            cDs();
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

    private void cDs() {
        this.mPath.reset();
        this.ddk.reset();
        this.jVO.set(getBounds());
        this.jVO.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.jVw) {
            this.ddk.addCircle(this.jVO.centerX(), this.jVO.centerY(), Math.min(this.jVO.width(), this.jVO.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.jVz.length; i++) {
                this.jVz[i] = (this.bbo[i] + this.jVK) - (this.mBorderWidth / 2.0f);
            }
            this.ddk.addRoundRect(this.jVO, this.jVz, Path.Direction.CW);
        }
        this.jVO.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.jVO.inset(this.jVK, this.jVK);
        if (this.jVw) {
            this.mPath.addCircle(this.jVO.centerX(), this.jVO.centerY(), Math.min(this.jVO.width(), this.jVO.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.jVO, this.bbo, Path.Direction.CW);
        }
        this.jVO.inset(-this.jVK, -this.jVK);
    }
}
