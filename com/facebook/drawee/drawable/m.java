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
    float[] lVD;
    @Nullable
    RectF lVI;
    @Nullable
    Matrix lVJ;
    private final Drawable lVN;
    @Nullable
    Matrix lWa;
    @Nullable
    private r mTransformCallback;
    protected boolean ehQ = false;
    protected boolean lVO = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean lVP = true;
    protected int mBorderColor = 0;
    protected final Path cEo = new Path();
    private final float[] lVQ = new float[8];
    final float[] lVC = new float[8];
    final RectF lVR = new RectF();
    final RectF lVS = new RectF();
    final RectF lVT = new RectF();
    final RectF lVU = new RectF();
    final Matrix lVV = new Matrix();
    final Matrix lVW = new Matrix();
    final Matrix lVX = new Matrix();
    final Matrix lVY = new Matrix();
    final Matrix lVZ = new Matrix();
    final Matrix mTransform = new Matrix();
    private float lVE = 0.0f;
    private boolean lVF = false;
    private boolean lWb = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.lVN = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void vD(boolean z) {
        this.ehQ = z;
        this.lWb = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.lVQ, f);
        this.lVO = f != 0.0f;
        this.lWb = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void y(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.lVQ, 0.0f);
            this.lVO = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.lVQ, 0, 8);
            this.lVO = false;
            for (int i = 0; i < 8; i++) {
                this.lVO = (fArr[i] > 0.0f) | this.lVO;
            }
        }
        this.lWb = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.lWb = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aC(float f) {
        if (this.lVE != f) {
            this.lVE = f;
            this.lWb = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vE(boolean z) {
        if (this.lVF != z) {
            this.lVF = z;
            this.lWb = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doS() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.lVX);
            this.mTransformCallback.getRootBounds(this.lVR);
        } else {
            this.lVX.reset();
            this.lVR.set(getBounds());
        }
        this.lVT.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.lVU.set(this.lVN.getBounds());
        this.lVV.setRectToRect(this.lVT, this.lVU, Matrix.ScaleToFit.FILL);
        if (this.lVF) {
            if (this.lVI == null) {
                this.lVI = new RectF(this.lVR);
            } else {
                this.lVI.set(this.lVR);
            }
            this.lVI.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.lVJ == null) {
                this.lVJ = new Matrix();
            }
            this.lVJ.setRectToRect(this.lVR, this.lVI, Matrix.ScaleToFit.FILL);
        } else if (this.lVJ != null) {
            this.lVJ.reset();
        }
        if (!this.lVX.equals(this.lVY) || !this.lVV.equals(this.lVW) || (this.lVJ != null && !this.lVJ.equals(this.lWa))) {
            this.lVP = true;
            this.lVX.invert(this.lVZ);
            this.mTransform.set(this.lVX);
            if (this.lVF) {
                this.mTransform.postConcat(this.lVJ);
            }
            this.mTransform.preConcat(this.lVV);
            this.lVY.set(this.lVX);
            this.lVW.set(this.lVV);
            if (this.lVF) {
                if (this.lWa == null) {
                    this.lWa = new Matrix(this.lVJ);
                } else {
                    this.lWa.set(this.lVJ);
                }
            } else if (this.lWa != null) {
                this.lWa.reset();
            }
        }
        if (!this.lVR.equals(this.lVS)) {
            this.lWb = true;
            this.lVS.set(this.lVR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doR() {
        if (this.lWb) {
            this.cEo.reset();
            this.lVR.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.ehQ) {
                this.cEo.addCircle(this.lVR.centerX(), this.lVR.centerY(), Math.min(this.lVR.width(), this.lVR.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.lVC.length; i++) {
                    this.lVC[i] = (this.lVQ[i] + this.lVE) - (this.mBorderWidth / 2.0f);
                }
                this.cEo.addRoundRect(this.lVR, this.lVC, Path.Direction.CW);
            }
            this.lVR.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.lVE + (this.lVF ? this.mBorderWidth : 0.0f);
            this.lVR.inset(f, f);
            if (this.ehQ) {
                this.mPath.addCircle(this.lVR.centerX(), this.lVR.centerY(), Math.min(this.lVR.width(), this.lVR.height()) / 2.0f, Path.Direction.CW);
            } else if (this.lVF) {
                if (this.lVD == null) {
                    this.lVD = new float[8];
                }
                for (int i2 = 0; i2 < this.lVC.length; i2++) {
                    this.lVD[i2] = this.lVQ[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.lVR, this.lVD, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.lVR, this.lVQ, Path.Direction.CW);
            }
            this.lVR.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.lWb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean doQ() {
        return this.ehQ || this.lVO || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.lVN.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lVN.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lVN.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.lVN.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.lVN.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.lVN.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.lVN.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.lVN.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.lVN.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.lVN.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.lVN.draw(canvas);
    }
}
