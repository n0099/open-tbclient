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
/* loaded from: classes12.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    float[] lLE;
    @Nullable
    RectF lLI;
    @Nullable
    Matrix lLJ;
    private final Drawable lLN;
    @Nullable
    Matrix lMa;
    @Nullable
    private r mTransformCallback;
    protected boolean dDw = false;
    protected boolean lLO = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean lLP = true;
    protected int mBorderColor = 0;
    protected final Path caR = new Path();
    private final float[] lLQ = new float[8];
    final float[] lLD = new float[8];
    final RectF lLR = new RectF();
    final RectF lLS = new RectF();
    final RectF lLT = new RectF();
    final RectF lLU = new RectF();
    final Matrix lLV = new Matrix();
    final Matrix lLW = new Matrix();
    final Matrix lLX = new Matrix();
    final Matrix lLY = new Matrix();
    final Matrix lLZ = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean lLF = false;
    private boolean lMb = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.lLN = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void ve(boolean z) {
        this.dDw = z;
        this.lMb = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.lLQ, f);
        this.lLO = f != 0.0f;
        this.lMb = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.lLQ, 0.0f);
            this.lLO = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.lLQ, 0, 8);
            this.lLO = false;
            for (int i = 0; i < 8; i++) {
                this.lLO = (fArr[i] > 0.0f) | this.lLO;
            }
        }
        this.lMb = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.lMb = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bn(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.lMb = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vf(boolean z) {
        if (this.lLF != z) {
            this.lLF = z;
            this.lMb = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dln() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.lLX);
            this.mTransformCallback.getRootBounds(this.lLR);
        } else {
            this.lLX.reset();
            this.lLR.set(getBounds());
        }
        this.lLT.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.lLU.set(this.lLN.getBounds());
        this.lLV.setRectToRect(this.lLT, this.lLU, Matrix.ScaleToFit.FILL);
        if (this.lLF) {
            if (this.lLI == null) {
                this.lLI = new RectF(this.lLR);
            } else {
                this.lLI.set(this.lLR);
            }
            this.lLI.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.lLJ == null) {
                this.lLJ = new Matrix();
            }
            this.lLJ.setRectToRect(this.lLR, this.lLI, Matrix.ScaleToFit.FILL);
        } else if (this.lLJ != null) {
            this.lLJ.reset();
        }
        if (!this.lLX.equals(this.lLY) || !this.lLV.equals(this.lLW) || (this.lLJ != null && !this.lLJ.equals(this.lMa))) {
            this.lLP = true;
            this.lLX.invert(this.lLZ);
            this.mTransform.set(this.lLX);
            if (this.lLF) {
                this.mTransform.postConcat(this.lLJ);
            }
            this.mTransform.preConcat(this.lLV);
            this.lLY.set(this.lLX);
            this.lLW.set(this.lLV);
            if (this.lLF) {
                if (this.lMa == null) {
                    this.lMa = new Matrix(this.lLJ);
                } else {
                    this.lMa.set(this.lLJ);
                }
            } else if (this.lMa != null) {
                this.lMa.reset();
            }
        }
        if (!this.lLR.equals(this.lLS)) {
            this.lMb = true;
            this.lLS.set(this.lLR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dlm() {
        if (this.lMb) {
            this.caR.reset();
            this.lLR.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.dDw) {
                this.caR.addCircle(this.lLR.centerX(), this.lLR.centerY(), Math.min(this.lLR.width(), this.lLR.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.lLD.length; i++) {
                    this.lLD[i] = (this.lLQ[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.caR.addRoundRect(this.lLR, this.lLD, Path.Direction.CW);
            }
            this.lLR.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.lLF ? this.mBorderWidth : 0.0f);
            this.lLR.inset(f, f);
            if (this.dDw) {
                this.mPath.addCircle(this.lLR.centerX(), this.lLR.centerY(), Math.min(this.lLR.width(), this.lLR.height()) / 2.0f, Path.Direction.CW);
            } else if (this.lLF) {
                if (this.lLE == null) {
                    this.lLE = new float[8];
                }
                for (int i2 = 0; i2 < this.lLD.length; i2++) {
                    this.lLE[i2] = this.lLQ[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.lLR, this.lLE, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.lLR, this.lLQ, Path.Direction.CW);
            }
            this.lLR.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.lMb = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dll() {
        return this.dDw || this.lLO || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.lLN.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lLN.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lLN.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.lLN.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.lLN.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.lLN.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.lLN.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.lLN.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.lLN.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.lLN.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.lLN.draw(canvas);
    }
}
