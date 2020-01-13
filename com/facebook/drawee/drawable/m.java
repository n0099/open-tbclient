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
    RectF lLD;
    @Nullable
    Matrix lLE;
    private final Drawable lLI;
    @Nullable
    Matrix lLV;
    @Nullable
    float[] lLz;
    @Nullable
    private r mTransformCallback;
    protected boolean dDw = false;
    protected boolean lLJ = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean lLK = true;
    protected int mBorderColor = 0;
    protected final Path caR = new Path();
    private final float[] lLL = new float[8];
    final float[] lLy = new float[8];
    final RectF lLM = new RectF();
    final RectF lLN = new RectF();
    final RectF lLO = new RectF();
    final RectF lLP = new RectF();
    final Matrix lLQ = new Matrix();
    final Matrix lLR = new Matrix();
    final Matrix lLS = new Matrix();
    final Matrix lLT = new Matrix();
    final Matrix lLU = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean lLA = false;
    private boolean lLW = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.lLI = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void ve(boolean z) {
        this.dDw = z;
        this.lLW = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.lLL, f);
        this.lLJ = f != 0.0f;
        this.lLW = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.lLL, 0.0f);
            this.lLJ = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.lLL, 0, 8);
            this.lLJ = false;
            for (int i = 0; i < 8; i++) {
                this.lLJ = (fArr[i] > 0.0f) | this.lLJ;
            }
        }
        this.lLW = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.lLW = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bn(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.lLW = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vf(boolean z) {
        if (this.lLA != z) {
            this.lLA = z;
            this.lLW = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dll() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.lLS);
            this.mTransformCallback.getRootBounds(this.lLM);
        } else {
            this.lLS.reset();
            this.lLM.set(getBounds());
        }
        this.lLO.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.lLP.set(this.lLI.getBounds());
        this.lLQ.setRectToRect(this.lLO, this.lLP, Matrix.ScaleToFit.FILL);
        if (this.lLA) {
            if (this.lLD == null) {
                this.lLD = new RectF(this.lLM);
            } else {
                this.lLD.set(this.lLM);
            }
            this.lLD.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.lLE == null) {
                this.lLE = new Matrix();
            }
            this.lLE.setRectToRect(this.lLM, this.lLD, Matrix.ScaleToFit.FILL);
        } else if (this.lLE != null) {
            this.lLE.reset();
        }
        if (!this.lLS.equals(this.lLT) || !this.lLQ.equals(this.lLR) || (this.lLE != null && !this.lLE.equals(this.lLV))) {
            this.lLK = true;
            this.lLS.invert(this.lLU);
            this.mTransform.set(this.lLS);
            if (this.lLA) {
                this.mTransform.postConcat(this.lLE);
            }
            this.mTransform.preConcat(this.lLQ);
            this.lLT.set(this.lLS);
            this.lLR.set(this.lLQ);
            if (this.lLA) {
                if (this.lLV == null) {
                    this.lLV = new Matrix(this.lLE);
                } else {
                    this.lLV.set(this.lLE);
                }
            } else if (this.lLV != null) {
                this.lLV.reset();
            }
        }
        if (!this.lLM.equals(this.lLN)) {
            this.lLW = true;
            this.lLN.set(this.lLM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dlk() {
        if (this.lLW) {
            this.caR.reset();
            this.lLM.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.dDw) {
                this.caR.addCircle(this.lLM.centerX(), this.lLM.centerY(), Math.min(this.lLM.width(), this.lLM.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.lLy.length; i++) {
                    this.lLy[i] = (this.lLL[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.caR.addRoundRect(this.lLM, this.lLy, Path.Direction.CW);
            }
            this.lLM.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.lLA ? this.mBorderWidth : 0.0f);
            this.lLM.inset(f, f);
            if (this.dDw) {
                this.mPath.addCircle(this.lLM.centerX(), this.lLM.centerY(), Math.min(this.lLM.width(), this.lLM.height()) / 2.0f, Path.Direction.CW);
            } else if (this.lLA) {
                if (this.lLz == null) {
                    this.lLz = new float[8];
                }
                for (int i2 = 0; i2 < this.lLy.length; i2++) {
                    this.lLz[i2] = this.lLL[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.lLM, this.lLz, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.lLM, this.lLL, Path.Direction.CW);
            }
            this.lLM.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.lLW = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dlj() {
        return this.dDw || this.lLJ || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.lLI.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lLI.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lLI.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.lLI.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.lLI.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.lLI.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.lLI.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.lLI.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.lLI.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.lLI.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.lLI.draw(canvas);
    }
}
