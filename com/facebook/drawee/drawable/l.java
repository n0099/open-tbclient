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
    private final float[] asU = new float[8];
    final float[] kes = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean kep = false;
    private float mBorderWidth = 0.0f;
    private float keE = 0.0f;
    private int mBorderColor = 0;
    final Path mPath = new Path();
    final Path dqa = new Path();
    private int mColor = 0;
    private final RectF keI = new RectF();
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
        cEA();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.cE(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.cE(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.dqa, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void sg(boolean z) {
        this.kep = z;
        cEA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void j(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.asU, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.asU, 0, 8);
        }
        cEA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.asU, f);
        cEA();
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
            cEA();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aE(float f) {
        if (this.keE != f) {
            this.keE = f;
            cEA();
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
        return e.Cg(e.cE(this.mColor, this.mAlpha));
    }

    private void cEA() {
        this.mPath.reset();
        this.dqa.reset();
        this.keI.set(getBounds());
        this.keI.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.kep) {
            this.dqa.addCircle(this.keI.centerX(), this.keI.centerY(), Math.min(this.keI.width(), this.keI.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.kes.length; i++) {
                this.kes[i] = (this.asU[i] + this.keE) - (this.mBorderWidth / 2.0f);
            }
            this.dqa.addRoundRect(this.keI, this.kes, Path.Direction.CW);
        }
        this.keI.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        this.keI.inset(this.keE, this.keE);
        if (this.kep) {
            this.mPath.addCircle(this.keI.centerX(), this.keI.centerY(), Math.min(this.keI.width(), this.keI.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.keI, this.asU, Path.Direction.CW);
        }
        this.keI.inset(-this.keE, -this.keE);
    }
}
