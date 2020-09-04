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
/* loaded from: classes4.dex */
public class l extends Drawable implements j {
    @Nullable
    float[] npb;
    private final float[] bui = new float[8];
    final float[] npa = new float[8];
    final Paint mPaint = new Paint(1);
    private boolean eWv = false;
    private float mBorderWidth = 0.0f;
    private float mPadding = 0.0f;
    private int mBorderColor = 0;
    private boolean npc = false;
    final Path mPath = new Path();
    final Path npd = new Path();
    private int mColor = 0;
    private final RectF npe = new RectF();
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
        dQA();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(e.dD(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(e.dD(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.npd, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void xX(boolean z) {
        this.eWv = z;
        dQA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.bui, 0.0f);
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.bui, 0, 8);
        }
        dQA();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkArgument(f >= 0.0f, "radius should be non negative");
        Arrays.fill(this.bui, f);
        dQA();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            dQA();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aM(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            dQA();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void xY(boolean z) {
        if (this.npc != z) {
            this.npc = z;
            dQA();
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
        return e.Lg(e.dD(this.mColor, this.mAlpha));
    }

    private void dQA() {
        this.mPath.reset();
        this.npd.reset();
        this.npe.set(getBounds());
        this.npe.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
        if (this.eWv) {
            this.npd.addCircle(this.npe.centerX(), this.npe.centerY(), Math.min(this.npe.width(), this.npe.height()) / 2.0f, Path.Direction.CW);
        } else {
            for (int i = 0; i < this.npa.length; i++) {
                this.npa[i] = (this.bui[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
            }
            this.npd.addRoundRect(this.npe, this.npa, Path.Direction.CW);
        }
        this.npe.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
        float f = (this.npc ? this.mBorderWidth : 0.0f) + this.mPadding;
        this.npe.inset(f, f);
        if (this.eWv) {
            this.mPath.addCircle(this.npe.centerX(), this.npe.centerY(), Math.min(this.npe.width(), this.npe.height()) / 2.0f, Path.Direction.CW);
        } else if (this.npc) {
            if (this.npb == null) {
                this.npb = new float[8];
            }
            for (int i2 = 0; i2 < this.npb.length; i2++) {
                this.npb[i2] = this.bui[i2] - this.mBorderWidth;
            }
            this.mPath.addRoundRect(this.npe, this.npb, Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.npe, this.bui, Path.Direction.CW);
        }
        this.npe.inset(-f, -f);
    }

    public void a(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
