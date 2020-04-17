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
    RectF lVE;
    @Nullable
    Matrix lVF;
    private final Drawable lVJ;
    @Nullable
    Matrix lVW;
    @Nullable
    float[] lVz;
    @Nullable
    private r mTransformCallback;
    protected boolean ehL = false;
    protected boolean lVK = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean lVL = true;
    protected int mBorderColor = 0;
    protected final Path cEi = new Path();
    private final float[] lVM = new float[8];
    final float[] lVy = new float[8];
    final RectF lVN = new RectF();
    final RectF lVO = new RectF();
    final RectF lVP = new RectF();
    final RectF lVQ = new RectF();
    final Matrix lVR = new Matrix();
    final Matrix lVS = new Matrix();
    final Matrix lVT = new Matrix();
    final Matrix lVU = new Matrix();
    final Matrix lVV = new Matrix();
    final Matrix mTransform = new Matrix();
    private float lVA = 0.0f;
    private boolean lVB = false;
    private boolean lVX = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.lVJ = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void vD(boolean z) {
        this.ehL = z;
        this.lVX = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.lVM, f);
        this.lVK = f != 0.0f;
        this.lVX = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void y(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.lVM, 0.0f);
            this.lVK = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.lVM, 0, 8);
            this.lVK = false;
            for (int i = 0; i < 8; i++) {
                this.lVK = (fArr[i] > 0.0f) | this.lVK;
            }
        }
        this.lVX = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.lVX = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aC(float f) {
        if (this.lVA != f) {
            this.lVA = f;
            this.lVX = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vE(boolean z) {
        if (this.lVB != z) {
            this.lVB = z;
            this.lVX = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doU() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.lVT);
            this.mTransformCallback.getRootBounds(this.lVN);
        } else {
            this.lVT.reset();
            this.lVN.set(getBounds());
        }
        this.lVP.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.lVQ.set(this.lVJ.getBounds());
        this.lVR.setRectToRect(this.lVP, this.lVQ, Matrix.ScaleToFit.FILL);
        if (this.lVB) {
            if (this.lVE == null) {
                this.lVE = new RectF(this.lVN);
            } else {
                this.lVE.set(this.lVN);
            }
            this.lVE.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.lVF == null) {
                this.lVF = new Matrix();
            }
            this.lVF.setRectToRect(this.lVN, this.lVE, Matrix.ScaleToFit.FILL);
        } else if (this.lVF != null) {
            this.lVF.reset();
        }
        if (!this.lVT.equals(this.lVU) || !this.lVR.equals(this.lVS) || (this.lVF != null && !this.lVF.equals(this.lVW))) {
            this.lVL = true;
            this.lVT.invert(this.lVV);
            this.mTransform.set(this.lVT);
            if (this.lVB) {
                this.mTransform.postConcat(this.lVF);
            }
            this.mTransform.preConcat(this.lVR);
            this.lVU.set(this.lVT);
            this.lVS.set(this.lVR);
            if (this.lVB) {
                if (this.lVW == null) {
                    this.lVW = new Matrix(this.lVF);
                } else {
                    this.lVW.set(this.lVF);
                }
            } else if (this.lVW != null) {
                this.lVW.reset();
            }
        }
        if (!this.lVN.equals(this.lVO)) {
            this.lVX = true;
            this.lVO.set(this.lVN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doT() {
        if (this.lVX) {
            this.cEi.reset();
            this.lVN.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.ehL) {
                this.cEi.addCircle(this.lVN.centerX(), this.lVN.centerY(), Math.min(this.lVN.width(), this.lVN.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.lVy.length; i++) {
                    this.lVy[i] = (this.lVM[i] + this.lVA) - (this.mBorderWidth / 2.0f);
                }
                this.cEi.addRoundRect(this.lVN, this.lVy, Path.Direction.CW);
            }
            this.lVN.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.lVA + (this.lVB ? this.mBorderWidth : 0.0f);
            this.lVN.inset(f, f);
            if (this.ehL) {
                this.mPath.addCircle(this.lVN.centerX(), this.lVN.centerY(), Math.min(this.lVN.width(), this.lVN.height()) / 2.0f, Path.Direction.CW);
            } else if (this.lVB) {
                if (this.lVz == null) {
                    this.lVz = new float[8];
                }
                for (int i2 = 0; i2 < this.lVy.length; i2++) {
                    this.lVz[i2] = this.lVM[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.lVN, this.lVz, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.lVN, this.lVM, Path.Direction.CW);
            }
            this.lVN.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.lVX = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean doS() {
        return this.ehL || this.lVK || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.lVJ.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lVJ.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lVJ.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.lVJ.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.lVJ.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.lVJ.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.lVJ.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.lVJ.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.lVJ.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.lVJ.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.lVJ.draw(canvas);
    }
}
