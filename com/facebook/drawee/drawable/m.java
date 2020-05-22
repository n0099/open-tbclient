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
    private r mTransformCallback;
    @Nullable
    RectF mpC;
    @Nullable
    Matrix mpD;
    private final Drawable mpH;
    @Nullable
    Matrix mpU;
    @Nullable
    float[] mpw;
    protected boolean ewj = false;
    protected boolean mpI = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean mpJ = true;
    protected int mBorderColor = 0;
    protected final Path mpz = new Path();
    private final float[] mpK = new float[8];
    final float[] mpv = new float[8];
    final RectF mpL = new RectF();
    final RectF mpM = new RectF();
    final RectF mpN = new RectF();
    final RectF mpO = new RectF();
    final Matrix mpP = new Matrix();
    final Matrix mpQ = new Matrix();
    final Matrix mpR = new Matrix();
    final Matrix mpS = new Matrix();
    final Matrix mpT = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mpx = 0.0f;
    private boolean mpy = false;
    private boolean mpV = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.mpH = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void wb(boolean z) {
        this.ewj = z;
        this.mpV = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.mpK, f);
        this.mpI = f != 0.0f;
        this.mpV = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void y(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mpK, 0.0f);
            this.mpI = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mpK, 0, 8);
            this.mpI = false;
            for (int i = 0; i < 8; i++) {
                this.mpI = (fArr[i] > 0.0f) | this.mpI;
            }
        }
        this.mpV = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.mpV = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aB(float f) {
        if (this.mpx != f) {
            this.mpx = f;
            this.mpV = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void wc(boolean z) {
        if (this.mpy != z) {
            this.mpy = z;
            this.mpV = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwk() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.mpR);
            this.mTransformCallback.getRootBounds(this.mpL);
        } else {
            this.mpR.reset();
            this.mpL.set(getBounds());
        }
        this.mpN.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.mpO.set(this.mpH.getBounds());
        this.mpP.setRectToRect(this.mpN, this.mpO, Matrix.ScaleToFit.FILL);
        if (this.mpy) {
            if (this.mpC == null) {
                this.mpC = new RectF(this.mpL);
            } else {
                this.mpC.set(this.mpL);
            }
            this.mpC.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.mpD == null) {
                this.mpD = new Matrix();
            }
            this.mpD.setRectToRect(this.mpL, this.mpC, Matrix.ScaleToFit.FILL);
        } else if (this.mpD != null) {
            this.mpD.reset();
        }
        if (!this.mpR.equals(this.mpS) || !this.mpP.equals(this.mpQ) || (this.mpD != null && !this.mpD.equals(this.mpU))) {
            this.mpJ = true;
            this.mpR.invert(this.mpT);
            this.mTransform.set(this.mpR);
            if (this.mpy) {
                this.mTransform.postConcat(this.mpD);
            }
            this.mTransform.preConcat(this.mpP);
            this.mpS.set(this.mpR);
            this.mpQ.set(this.mpP);
            if (this.mpy) {
                if (this.mpU == null) {
                    this.mpU = new Matrix(this.mpD);
                } else {
                    this.mpU.set(this.mpD);
                }
            } else if (this.mpU != null) {
                this.mpU.reset();
            }
        }
        if (!this.mpL.equals(this.mpM)) {
            this.mpV = true;
            this.mpM.set(this.mpL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwj() {
        if (this.mpV) {
            this.mpz.reset();
            this.mpL.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.ewj) {
                this.mpz.addCircle(this.mpL.centerX(), this.mpL.centerY(), Math.min(this.mpL.width(), this.mpL.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.mpv.length; i++) {
                    this.mpv[i] = (this.mpK[i] + this.mpx) - (this.mBorderWidth / 2.0f);
                }
                this.mpz.addRoundRect(this.mpL, this.mpv, Path.Direction.CW);
            }
            this.mpL.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mpx + (this.mpy ? this.mBorderWidth : 0.0f);
            this.mpL.inset(f, f);
            if (this.ewj) {
                this.mPath.addCircle(this.mpL.centerX(), this.mpL.centerY(), Math.min(this.mpL.width(), this.mpL.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mpy) {
                if (this.mpw == null) {
                    this.mpw = new float[8];
                }
                for (int i2 = 0; i2 < this.mpv.length; i2++) {
                    this.mpw[i2] = this.mpK[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.mpL, this.mpw, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mpL, this.mpK, Path.Direction.CW);
            }
            this.mpL.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mpV = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dwi() {
        return this.ewj || this.mpI || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mpH.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mpH.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mpH.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mpH.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.mpH.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mpH.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.mpH.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.mpH.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.mpH.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mpH.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.mpH.draw(canvas);
    }
}
