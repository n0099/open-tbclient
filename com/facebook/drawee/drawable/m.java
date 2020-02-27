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
    Matrix lMH;
    @Nullable
    float[] lMl;
    @Nullable
    RectF lMp;
    @Nullable
    Matrix lMq;
    private final Drawable lMu;
    @Nullable
    private r mTransformCallback;
    protected boolean dHA = false;
    protected boolean lMv = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean lMw = true;
    protected int mBorderColor = 0;
    protected final Path ceX = new Path();
    private final float[] lMx = new float[8];
    final float[] lMk = new float[8];
    final RectF lMy = new RectF();
    final RectF lMz = new RectF();
    final RectF lMA = new RectF();
    final RectF lMB = new RectF();
    final Matrix lMC = new Matrix();
    final Matrix lMD = new Matrix();
    final Matrix lME = new Matrix();
    final Matrix lMF = new Matrix();
    final Matrix lMG = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean lMm = false;
    private boolean lMI = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.lMu = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void vi(boolean z) {
        this.dHA = z;
        this.lMI = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.lMx, f);
        this.lMv = f != 0.0f;
        this.lMI = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.lMx, 0.0f);
            this.lMv = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.lMx, 0, 8);
            this.lMv = false;
            for (int i = 0; i < 8; i++) {
                this.lMv = (fArr[i] > 0.0f) | this.lMv;
            }
        }
        this.lMI = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.lMI = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bm(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.lMI = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vj(boolean z) {
        if (this.lMm != z) {
            this.lMm = z;
            this.lMI = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dmA() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.lME);
            this.mTransformCallback.getRootBounds(this.lMy);
        } else {
            this.lME.reset();
            this.lMy.set(getBounds());
        }
        this.lMA.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.lMB.set(this.lMu.getBounds());
        this.lMC.setRectToRect(this.lMA, this.lMB, Matrix.ScaleToFit.FILL);
        if (this.lMm) {
            if (this.lMp == null) {
                this.lMp = new RectF(this.lMy);
            } else {
                this.lMp.set(this.lMy);
            }
            this.lMp.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.lMq == null) {
                this.lMq = new Matrix();
            }
            this.lMq.setRectToRect(this.lMy, this.lMp, Matrix.ScaleToFit.FILL);
        } else if (this.lMq != null) {
            this.lMq.reset();
        }
        if (!this.lME.equals(this.lMF) || !this.lMC.equals(this.lMD) || (this.lMq != null && !this.lMq.equals(this.lMH))) {
            this.lMw = true;
            this.lME.invert(this.lMG);
            this.mTransform.set(this.lME);
            if (this.lMm) {
                this.mTransform.postConcat(this.lMq);
            }
            this.mTransform.preConcat(this.lMC);
            this.lMF.set(this.lME);
            this.lMD.set(this.lMC);
            if (this.lMm) {
                if (this.lMH == null) {
                    this.lMH = new Matrix(this.lMq);
                } else {
                    this.lMH.set(this.lMq);
                }
            } else if (this.lMH != null) {
                this.lMH.reset();
            }
        }
        if (!this.lMy.equals(this.lMz)) {
            this.lMI = true;
            this.lMz.set(this.lMy);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dmz() {
        if (this.lMI) {
            this.ceX.reset();
            this.lMy.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.dHA) {
                this.ceX.addCircle(this.lMy.centerX(), this.lMy.centerY(), Math.min(this.lMy.width(), this.lMy.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.lMk.length; i++) {
                    this.lMk[i] = (this.lMx[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.ceX.addRoundRect(this.lMy, this.lMk, Path.Direction.CW);
            }
            this.lMy.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.lMm ? this.mBorderWidth : 0.0f);
            this.lMy.inset(f, f);
            if (this.dHA) {
                this.mPath.addCircle(this.lMy.centerX(), this.lMy.centerY(), Math.min(this.lMy.width(), this.lMy.height()) / 2.0f, Path.Direction.CW);
            } else if (this.lMm) {
                if (this.lMl == null) {
                    this.lMl = new float[8];
                }
                for (int i2 = 0; i2 < this.lMk.length; i2++) {
                    this.lMl[i2] = this.lMx[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.lMy, this.lMl, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.lMy, this.lMx, Path.Direction.CW);
            }
            this.lMy.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.lMI = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dmy() {
        return this.dHA || this.lMv || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.lMu.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lMu.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lMu.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.lMu.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.lMu.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.lMu.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.lMu.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.lMu.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.lMu.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.lMu.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.lMu.draw(canvas);
    }
}
