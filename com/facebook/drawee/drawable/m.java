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
/* loaded from: classes14.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    private r mTransformCallback;
    @Nullable
    float[] oQI;
    @Nullable
    RectF oQM;
    @Nullable
    Matrix oQN;
    private final Drawable oQR;
    @Nullable
    Matrix oRe;
    protected boolean fzm = false;
    protected boolean oQS = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean oQT = true;
    protected int mBorderColor = 0;
    protected final Path eHz = new Path();
    private final float[] oQU = new float[8];
    final float[] oQH = new float[8];
    final RectF oQV = new RectF();
    final RectF oQW = new RectF();
    final RectF oQX = new RectF();
    final RectF oQY = new RectF();
    final Matrix oQZ = new Matrix();
    final Matrix oRa = new Matrix();
    final Matrix oRb = new Matrix();
    final Matrix oRc = new Matrix();
    final Matrix oRd = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean oQJ = false;
    private boolean oRf = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.oQR = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void An(boolean z) {
        this.fzm = z;
        this.oRf = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.oQU, f);
        this.oQS = f != 0.0f;
        this.oRf = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void B(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.oQU, 0.0f);
            this.oQS = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.oQU, 0, 8);
            this.oQS = false;
            for (int i = 0; i < 8; i++) {
                this.oQS = (fArr[i] > 0.0f) | this.oQS;
            }
        }
        this.oRf = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.oRf = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bs(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.oRf = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void Ao(boolean z) {
        if (this.oQJ != z) {
            this.oQJ = z;
            this.oRf = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void elV() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.oRb);
            this.mTransformCallback.getRootBounds(this.oQV);
        } else {
            this.oRb.reset();
            this.oQV.set(getBounds());
        }
        this.oQX.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.oQY.set(this.oQR.getBounds());
        this.oQZ.setRectToRect(this.oQX, this.oQY, Matrix.ScaleToFit.FILL);
        if (this.oQJ) {
            if (this.oQM == null) {
                this.oQM = new RectF(this.oQV);
            } else {
                this.oQM.set(this.oQV);
            }
            this.oQM.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.oQN == null) {
                this.oQN = new Matrix();
            }
            this.oQN.setRectToRect(this.oQV, this.oQM, Matrix.ScaleToFit.FILL);
        } else if (this.oQN != null) {
            this.oQN.reset();
        }
        if (!this.oRb.equals(this.oRc) || !this.oQZ.equals(this.oRa) || (this.oQN != null && !this.oQN.equals(this.oRe))) {
            this.oQT = true;
            this.oRb.invert(this.oRd);
            this.mTransform.set(this.oRb);
            if (this.oQJ) {
                this.mTransform.postConcat(this.oQN);
            }
            this.mTransform.preConcat(this.oQZ);
            this.oRc.set(this.oRb);
            this.oRa.set(this.oQZ);
            if (this.oQJ) {
                if (this.oRe == null) {
                    this.oRe = new Matrix(this.oQN);
                } else {
                    this.oRe.set(this.oQN);
                }
            } else if (this.oRe != null) {
                this.oRe.reset();
            }
        }
        if (!this.oQV.equals(this.oQW)) {
            this.oRf = true;
            this.oQW.set(this.oQV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void elU() {
        if (this.oRf) {
            this.eHz.reset();
            this.oQV.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fzm) {
                this.eHz.addCircle(this.oQV.centerX(), this.oQV.centerY(), Math.min(this.oQV.width(), this.oQV.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.oQH.length; i++) {
                    this.oQH[i] = (this.oQU[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.eHz.addRoundRect(this.oQV, this.oQH, Path.Direction.CW);
            }
            this.oQV.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.oQJ ? this.mBorderWidth : 0.0f);
            this.oQV.inset(f, f);
            if (this.fzm) {
                this.mPath.addCircle(this.oQV.centerX(), this.oQV.centerY(), Math.min(this.oQV.width(), this.oQV.height()) / 2.0f, Path.Direction.CW);
            } else if (this.oQJ) {
                if (this.oQI == null) {
                    this.oQI = new float[8];
                }
                for (int i2 = 0; i2 < this.oQH.length; i2++) {
                    this.oQI[i2] = this.oQU[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.oQV, this.oQI, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.oQV, this.oQU, Path.Direction.CW);
            }
            this.oQV.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.oRf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean elT() {
        return this.fzm || this.oQS || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.oQR.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.oQR.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.oQR.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.oQR.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.oQR.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.oQR.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.oQR.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.oQR.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.oQR.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.oQR.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.oQR.draw(canvas);
    }
}
