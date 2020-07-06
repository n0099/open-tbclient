package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import java.util.Arrays;
/* loaded from: classes13.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    float[] mMI;
    @Nullable
    RectF mMN;
    @Nullable
    Matrix mMO;
    private final Drawable mMS;
    @Nullable
    Matrix mNf;
    @Nullable
    private r mTransformCallback;
    protected boolean eFp = false;
    protected boolean mMT = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean mMU = true;
    protected int mBorderColor = 0;
    protected final Path mMK = new Path();
    private final float[] mMV = new float[8];
    final float[] mMH = new float[8];
    final RectF mMW = new RectF();
    final RectF mMX = new RectF();
    final RectF mMY = new RectF();
    final RectF mMZ = new RectF();
    final Matrix mNa = new Matrix();
    final Matrix mNb = new Matrix();
    final Matrix mNc = new Matrix();
    final Matrix mNd = new Matrix();
    final Matrix mNe = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean mMJ = false;
    private boolean mNg = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.mMS = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void wz(boolean z) {
        this.eFp = z;
        this.mNg = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.mMV, f);
        this.mMT = f != 0.0f;
        this.mNg = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mMV, 0.0f);
            this.mMT = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mMV, 0, 8);
            this.mMT = false;
            for (int i = 0; i < 8; i++) {
                this.mMT = (fArr[i] > 0.0f) | this.mMT;
            }
        }
        this.mNg = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.mNg = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aH(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.mNg = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void wA(boolean z) {
        if (this.mMJ != z) {
            this.mMJ = z;
            this.mNg = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dBf() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.mNc);
            this.mTransformCallback.getRootBounds(this.mMW);
        } else {
            this.mNc.reset();
            this.mMW.set(getBounds());
        }
        this.mMY.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.mMZ.set(this.mMS.getBounds());
        this.mNa.setRectToRect(this.mMY, this.mMZ, Matrix.ScaleToFit.FILL);
        if (this.mMJ) {
            if (this.mMN == null) {
                this.mMN = new RectF(this.mMW);
            } else {
                this.mMN.set(this.mMW);
            }
            this.mMN.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.mMO == null) {
                this.mMO = new Matrix();
            }
            this.mMO.setRectToRect(this.mMW, this.mMN, Matrix.ScaleToFit.FILL);
        } else if (this.mMO != null) {
            this.mMO.reset();
        }
        if (!this.mNc.equals(this.mNd) || !this.mNa.equals(this.mNb) || (this.mMO != null && !this.mMO.equals(this.mNf))) {
            this.mMU = true;
            this.mNc.invert(this.mNe);
            this.mTransform.set(this.mNc);
            if (this.mMJ) {
                this.mTransform.postConcat(this.mMO);
            }
            this.mTransform.preConcat(this.mNa);
            this.mNd.set(this.mNc);
            this.mNb.set(this.mNa);
            if (this.mMJ) {
                if (this.mNf == null) {
                    this.mNf = new Matrix(this.mMO);
                } else {
                    this.mNf.set(this.mMO);
                }
            } else if (this.mNf != null) {
                this.mNf.reset();
            }
        }
        if (!this.mMW.equals(this.mMX)) {
            this.mNg = true;
            this.mMX.set(this.mMW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dBe() {
        if (this.mNg) {
            this.mMK.reset();
            this.mMW.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.eFp) {
                this.mMK.addCircle(this.mMW.centerX(), this.mMW.centerY(), Math.min(this.mMW.width(), this.mMW.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.mMH.length; i++) {
                    this.mMH[i] = (this.mMV[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.mMK.addRoundRect(this.mMW, this.mMH, Path.Direction.CW);
            }
            this.mMW.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.mMJ ? this.mBorderWidth : 0.0f);
            this.mMW.inset(f, f);
            if (this.eFp) {
                this.mPath.addCircle(this.mMW.centerX(), this.mMW.centerY(), Math.min(this.mMW.width(), this.mMW.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mMJ) {
                if (this.mMI == null) {
                    this.mMI = new float[8];
                }
                for (int i2 = 0; i2 < this.mMH.length; i2++) {
                    this.mMI[i2] = this.mMV[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.mMW, this.mMI, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mMW, this.mMV, Path.Direction.CW);
            }
            this.mMW.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mNg = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dBd() {
        return this.eFp || this.mMT || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mMS.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mMS.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mMS.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mMS.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.mMS.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mMS.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.mMS.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.mMS.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.mMS.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mMS.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.mMS.draw(canvas);
    }
}
