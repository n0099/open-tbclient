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
    RectF lMC;
    @Nullable
    Matrix lMD;
    private final Drawable lMH;
    @Nullable
    Matrix lMU;
    @Nullable
    float[] lMy;
    @Nullable
    private r mTransformCallback;
    protected boolean dHO = false;
    protected boolean lMI = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean lMJ = true;
    protected int mBorderColor = 0;
    protected final Path ceZ = new Path();
    private final float[] lMK = new float[8];
    final float[] lMx = new float[8];
    final RectF lML = new RectF();
    final RectF lMM = new RectF();
    final RectF lMN = new RectF();
    final RectF lMO = new RectF();
    final Matrix lMP = new Matrix();
    final Matrix lMQ = new Matrix();
    final Matrix lMR = new Matrix();
    final Matrix lMS = new Matrix();
    final Matrix lMT = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean lMz = false;
    private boolean lMV = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.lMH = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void vi(boolean z) {
        this.dHO = z;
        this.lMV = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.lMK, f);
        this.lMI = f != 0.0f;
        this.lMV = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.lMK, 0.0f);
            this.lMI = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.lMK, 0, 8);
            this.lMI = false;
            for (int i = 0; i < 8; i++) {
                this.lMI = (fArr[i] > 0.0f) | this.lMI;
            }
        }
        this.lMV = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.lMV = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bm(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.lMV = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vj(boolean z) {
        if (this.lMz != z) {
            this.lMz = z;
            this.lMV = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dmD() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.lMR);
            this.mTransformCallback.getRootBounds(this.lML);
        } else {
            this.lMR.reset();
            this.lML.set(getBounds());
        }
        this.lMN.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.lMO.set(this.lMH.getBounds());
        this.lMP.setRectToRect(this.lMN, this.lMO, Matrix.ScaleToFit.FILL);
        if (this.lMz) {
            if (this.lMC == null) {
                this.lMC = new RectF(this.lML);
            } else {
                this.lMC.set(this.lML);
            }
            this.lMC.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.lMD == null) {
                this.lMD = new Matrix();
            }
            this.lMD.setRectToRect(this.lML, this.lMC, Matrix.ScaleToFit.FILL);
        } else if (this.lMD != null) {
            this.lMD.reset();
        }
        if (!this.lMR.equals(this.lMS) || !this.lMP.equals(this.lMQ) || (this.lMD != null && !this.lMD.equals(this.lMU))) {
            this.lMJ = true;
            this.lMR.invert(this.lMT);
            this.mTransform.set(this.lMR);
            if (this.lMz) {
                this.mTransform.postConcat(this.lMD);
            }
            this.mTransform.preConcat(this.lMP);
            this.lMS.set(this.lMR);
            this.lMQ.set(this.lMP);
            if (this.lMz) {
                if (this.lMU == null) {
                    this.lMU = new Matrix(this.lMD);
                } else {
                    this.lMU.set(this.lMD);
                }
            } else if (this.lMU != null) {
                this.lMU.reset();
            }
        }
        if (!this.lML.equals(this.lMM)) {
            this.lMV = true;
            this.lMM.set(this.lML);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dmC() {
        if (this.lMV) {
            this.ceZ.reset();
            this.lML.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.dHO) {
                this.ceZ.addCircle(this.lML.centerX(), this.lML.centerY(), Math.min(this.lML.width(), this.lML.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.lMx.length; i++) {
                    this.lMx[i] = (this.lMK[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.ceZ.addRoundRect(this.lML, this.lMx, Path.Direction.CW);
            }
            this.lML.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.lMz ? this.mBorderWidth : 0.0f);
            this.lML.inset(f, f);
            if (this.dHO) {
                this.mPath.addCircle(this.lML.centerX(), this.lML.centerY(), Math.min(this.lML.width(), this.lML.height()) / 2.0f, Path.Direction.CW);
            } else if (this.lMz) {
                if (this.lMy == null) {
                    this.lMy = new float[8];
                }
                for (int i2 = 0; i2 < this.lMx.length; i2++) {
                    this.lMy[i2] = this.lMK[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.lML, this.lMy, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.lML, this.lMK, Path.Direction.CW);
            }
            this.lML.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.lMV = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dmB() {
        return this.dHO || this.lMI || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.lMH.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lMH.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lMH.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.lMH.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.lMH.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.lMH.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.lMH.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.lMH.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.lMH.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.lMH.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.lMH.draw(canvas);
    }
}
