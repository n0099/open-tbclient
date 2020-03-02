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
    Matrix lMJ;
    @Nullable
    float[] lMn;
    @Nullable
    RectF lMr;
    @Nullable
    Matrix lMs;
    private final Drawable lMw;
    @Nullable
    private r mTransformCallback;
    protected boolean dHB = false;
    protected boolean lMx = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean lMy = true;
    protected int mBorderColor = 0;
    protected final Path ceY = new Path();
    private final float[] lMz = new float[8];
    final float[] lMm = new float[8];
    final RectF lMA = new RectF();
    final RectF lMB = new RectF();
    final RectF lMC = new RectF();
    final RectF lMD = new RectF();
    final Matrix lME = new Matrix();
    final Matrix lMF = new Matrix();
    final Matrix lMG = new Matrix();
    final Matrix lMH = new Matrix();
    final Matrix lMI = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean lMo = false;
    private boolean lMK = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.lMw = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void vi(boolean z) {
        this.dHB = z;
        this.lMK = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.lMz, f);
        this.lMx = f != 0.0f;
        this.lMK = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.lMz, 0.0f);
            this.lMx = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.lMz, 0, 8);
            this.lMx = false;
            for (int i = 0; i < 8; i++) {
                this.lMx = (fArr[i] > 0.0f) | this.lMx;
            }
        }
        this.lMK = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.lMK = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bm(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.lMK = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vj(boolean z) {
        if (this.lMo != z) {
            this.lMo = z;
            this.lMK = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dmC() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.lMG);
            this.mTransformCallback.getRootBounds(this.lMA);
        } else {
            this.lMG.reset();
            this.lMA.set(getBounds());
        }
        this.lMC.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.lMD.set(this.lMw.getBounds());
        this.lME.setRectToRect(this.lMC, this.lMD, Matrix.ScaleToFit.FILL);
        if (this.lMo) {
            if (this.lMr == null) {
                this.lMr = new RectF(this.lMA);
            } else {
                this.lMr.set(this.lMA);
            }
            this.lMr.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.lMs == null) {
                this.lMs = new Matrix();
            }
            this.lMs.setRectToRect(this.lMA, this.lMr, Matrix.ScaleToFit.FILL);
        } else if (this.lMs != null) {
            this.lMs.reset();
        }
        if (!this.lMG.equals(this.lMH) || !this.lME.equals(this.lMF) || (this.lMs != null && !this.lMs.equals(this.lMJ))) {
            this.lMy = true;
            this.lMG.invert(this.lMI);
            this.mTransform.set(this.lMG);
            if (this.lMo) {
                this.mTransform.postConcat(this.lMs);
            }
            this.mTransform.preConcat(this.lME);
            this.lMH.set(this.lMG);
            this.lMF.set(this.lME);
            if (this.lMo) {
                if (this.lMJ == null) {
                    this.lMJ = new Matrix(this.lMs);
                } else {
                    this.lMJ.set(this.lMs);
                }
            } else if (this.lMJ != null) {
                this.lMJ.reset();
            }
        }
        if (!this.lMA.equals(this.lMB)) {
            this.lMK = true;
            this.lMB.set(this.lMA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dmB() {
        if (this.lMK) {
            this.ceY.reset();
            this.lMA.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.dHB) {
                this.ceY.addCircle(this.lMA.centerX(), this.lMA.centerY(), Math.min(this.lMA.width(), this.lMA.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.lMm.length; i++) {
                    this.lMm[i] = (this.lMz[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.ceY.addRoundRect(this.lMA, this.lMm, Path.Direction.CW);
            }
            this.lMA.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.lMo ? this.mBorderWidth : 0.0f);
            this.lMA.inset(f, f);
            if (this.dHB) {
                this.mPath.addCircle(this.lMA.centerX(), this.lMA.centerY(), Math.min(this.lMA.width(), this.lMA.height()) / 2.0f, Path.Direction.CW);
            } else if (this.lMo) {
                if (this.lMn == null) {
                    this.lMn = new float[8];
                }
                for (int i2 = 0; i2 < this.lMm.length; i2++) {
                    this.lMn[i2] = this.lMz[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.lMA, this.lMn, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.lMA, this.lMz, Path.Direction.CW);
            }
            this.lMA.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.lMK = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dmA() {
        return this.dHB || this.lMx || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.lMw.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lMw.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lMw.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.lMw.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.lMw.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.lMw.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.lMw.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.lMw.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.lMw.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.lMw.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.lMw.draw(canvas);
    }
}
