package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
/* loaded from: classes3.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    float[] psG;
    @Nullable
    RectF psK;
    @Nullable
    Matrix psL;
    private final Drawable psP;
    @Nullable
    private r psd;
    @Nullable
    Matrix ptc;
    protected boolean fLW = false;
    protected boolean psQ = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean psR = true;
    protected int mBorderColor = 0;
    protected final Path eTX = new Path();
    private final float[] psS = new float[8];
    final float[] psF = new float[8];
    final RectF psT = new RectF();
    final RectF psU = new RectF();
    final RectF psV = new RectF();
    final RectF psW = new RectF();
    final Matrix psX = new Matrix();
    final Matrix psY = new Matrix();
    final Matrix psZ = new Matrix();
    final Matrix pta = new Matrix();
    final Matrix ptb = new Matrix();
    final Matrix ptd = new Matrix();
    private float mPadding = 0.0f;
    private boolean psH = false;
    private boolean pte = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.psP = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void AU(boolean z) {
        this.fLW = z;
        this.pte = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.psS, f);
        this.psQ = f != 0.0f;
        this.pte = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.psS, 0.0f);
            this.psQ = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.psS, 0, 8);
            this.psQ = false;
            for (int i = 0; i < 8; i++) {
                this.psQ = (fArr[i] > 0.0f) | this.psQ;
            }
        }
        this.pte = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.pte = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bF(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.pte = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void AV(boolean z) {
        if (this.psH != z) {
            this.psH = z;
            this.pte = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void a(@Nullable r rVar) {
        this.psd = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void esc() {
        if (this.psd != null) {
            this.psd.f(this.psZ);
            this.psd.b(this.psT);
        } else {
            this.psZ.reset();
            this.psT.set(getBounds());
        }
        this.psV.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.psW.set(this.psP.getBounds());
        this.psX.setRectToRect(this.psV, this.psW, Matrix.ScaleToFit.FILL);
        if (this.psH) {
            if (this.psK == null) {
                this.psK = new RectF(this.psT);
            } else {
                this.psK.set(this.psT);
            }
            this.psK.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.psL == null) {
                this.psL = new Matrix();
            }
            this.psL.setRectToRect(this.psT, this.psK, Matrix.ScaleToFit.FILL);
        } else if (this.psL != null) {
            this.psL.reset();
        }
        if (!this.psZ.equals(this.pta) || !this.psX.equals(this.psY) || (this.psL != null && !this.psL.equals(this.ptc))) {
            this.psR = true;
            this.psZ.invert(this.ptb);
            this.ptd.set(this.psZ);
            if (this.psH) {
                this.ptd.postConcat(this.psL);
            }
            this.ptd.preConcat(this.psX);
            this.pta.set(this.psZ);
            this.psY.set(this.psX);
            if (this.psH) {
                if (this.ptc == null) {
                    this.ptc = new Matrix(this.psL);
                } else {
                    this.ptc.set(this.psL);
                }
            } else if (this.ptc != null) {
                this.ptc.reset();
            }
        }
        if (!this.psT.equals(this.psU)) {
            this.pte = true;
            this.psU.set(this.psT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void esb() {
        if (this.pte) {
            this.eTX.reset();
            this.psT.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fLW) {
                this.eTX.addCircle(this.psT.centerX(), this.psT.centerY(), Math.min(this.psT.width(), this.psT.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.psF.length; i++) {
                    this.psF[i] = (this.psS[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.eTX.addRoundRect(this.psT, this.psF, Path.Direction.CW);
            }
            this.psT.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.psH ? this.mBorderWidth : 0.0f);
            this.psT.inset(f, f);
            if (this.fLW) {
                this.mPath.addCircle(this.psT.centerX(), this.psT.centerY(), Math.min(this.psT.width(), this.psT.height()) / 2.0f, Path.Direction.CW);
            } else if (this.psH) {
                if (this.psG == null) {
                    this.psG = new float[8];
                }
                for (int i2 = 0; i2 < this.psF.length; i2++) {
                    this.psG[i2] = this.psS[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.psT, this.psG, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.psT, this.psS, Path.Direction.CW);
            }
            this.psT.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.pte = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean esa() {
        return this.fLW || this.psQ || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.psP.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.psP.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.psP.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.psP.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.psP.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.psP.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.psP.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.psP.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.psP.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.psP.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.psP.draw(canvas);
    }
}
