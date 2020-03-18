package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class l extends Drawable implements j {
    @Nullable
    float[] lOe;
    private final float[] aFI = new float[8];
    final float[] lOd = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean dIe = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean lOf = false;
    final Path mPath = new Path();
    final Path cfk = new Path();
    private int mColor = 0;
    private final RectF lOg = new RectF();
    private int mAlpha = 255;

    public l(int i) {
        setColor(i);
    }

    @TargetApi(11)
    public static l a(ColorDrawable colorDrawable) {
        return new l(colorDrawable.getColor());
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        dmZ();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.dv(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.dv(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.cfk, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vp(boolean z) {
        this.dIe = z;
        dmZ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.aFI, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.aFI, 0, 8);
        }
        dmZ();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.aFI, f);
        dmZ();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            dmZ();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bm(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            dmZ();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vq(boolean z) {
        if (this.lOf != z) {
            this.lOf = z;
            dmZ();
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
        a(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return e.HL(e.dv(this.mColor, this.mAlpha));
    }

    private void dmZ() {
        this.mPath.reset();
        this.cfk.reset();
        this.lOg.set(getBounds());
        this.lOg.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.dIe) {
            this.cfk.addCircle(this.lOg.centerX(), this.lOg.centerY(), Math.min(this.lOg.width(), this.lOg.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.lOd.length; i++) {
                this.lOd[i] = (this.aFI[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.cfk.addRoundRect(this.lOg, this.lOd, Path.Direction.CW);
        }
        this.lOg.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.lOf ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.lOg.inset(f, f);
        if (this.dIe) {
            this.mPath.addCircle(this.lOg.centerX(), this.lOg.centerY(), Math.min(this.lOg.width(), this.lOg.height()) / 2.0f, Path.Direction.CW);
        } else if (this.lOf) {
            if (this.lOe == null) {
                this.lOe = new float[8];
            }
            for (int i2 = 0; i2 < this.lOe.length; i2++) {
                this.lOe[i2] = this.aFI[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.lOg, this.lOe, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.lOg, this.aFI, Path.Direction.CW);
        }
        this.lOg.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
