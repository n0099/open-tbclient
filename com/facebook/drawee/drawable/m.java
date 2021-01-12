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
    float[] psF;
    @Nullable
    RectF psJ;
    @Nullable
    Matrix psK;
    private final Drawable psO;
    @Nullable
    private r psc;
    @Nullable
    Matrix ptb;
    protected boolean fLW = false;
    protected boolean psP = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean psQ = true;
    protected int mBorderColor = 0;
    protected final Path eTX = new Path();
    private final float[] psR = new float[8];
    final float[] psE = new float[8];
    final RectF psS = new RectF();
    final RectF psT = new RectF();
    final RectF psU = new RectF();
    final RectF psV = new RectF();
    final Matrix psW = new Matrix();
    final Matrix psX = new Matrix();
    final Matrix psY = new Matrix();
    final Matrix psZ = new Matrix();
    final Matrix pta = new Matrix();
    final Matrix ptc = new Matrix();
    private float mPadding = 0.0f;
    private boolean psG = false;
    private boolean ptd = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.psO = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void AU(boolean z) {
        this.fLW = z;
        this.ptd = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.psR, f);
        this.psP = f != 0.0f;
        this.ptd = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.psR, 0.0f);
            this.psP = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.psR, 0, 8);
            this.psP = false;
            for (int i = 0; i < 8; i++) {
                this.psP = (fArr[i] > 0.0f) | this.psP;
            }
        }
        this.ptd = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.ptd = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bF(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.ptd = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void AV(boolean z) {
        if (this.psG != z) {
            this.psG = z;
            this.ptd = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void a(@Nullable r rVar) {
        this.psc = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void esc() {
        if (this.psc != null) {
            this.psc.f(this.psY);
            this.psc.b(this.psS);
        } else {
            this.psY.reset();
            this.psS.set(getBounds());
        }
        this.psU.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.psV.set(this.psO.getBounds());
        this.psW.setRectToRect(this.psU, this.psV, Matrix.ScaleToFit.FILL);
        if (this.psG) {
            if (this.psJ == null) {
                this.psJ = new RectF(this.psS);
            } else {
                this.psJ.set(this.psS);
            }
            this.psJ.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.psK == null) {
                this.psK = new Matrix();
            }
            this.psK.setRectToRect(this.psS, this.psJ, Matrix.ScaleToFit.FILL);
        } else if (this.psK != null) {
            this.psK.reset();
        }
        if (!this.psY.equals(this.psZ) || !this.psW.equals(this.psX) || (this.psK != null && !this.psK.equals(this.ptb))) {
            this.psQ = true;
            this.psY.invert(this.pta);
            this.ptc.set(this.psY);
            if (this.psG) {
                this.ptc.postConcat(this.psK);
            }
            this.ptc.preConcat(this.psW);
            this.psZ.set(this.psY);
            this.psX.set(this.psW);
            if (this.psG) {
                if (this.ptb == null) {
                    this.ptb = new Matrix(this.psK);
                } else {
                    this.ptb.set(this.psK);
                }
            } else if (this.ptb != null) {
                this.ptb.reset();
            }
        }
        if (!this.psS.equals(this.psT)) {
            this.ptd = true;
            this.psT.set(this.psS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void esb() {
        if (this.ptd) {
            this.eTX.reset();
            this.psS.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fLW) {
                this.eTX.addCircle(this.psS.centerX(), this.psS.centerY(), Math.min(this.psS.width(), this.psS.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.psE.length; i++) {
                    this.psE[i] = (this.psR[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.eTX.addRoundRect(this.psS, this.psE, Path.Direction.CW);
            }
            this.psS.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.psG ? this.mBorderWidth : 0.0f);
            this.psS.inset(f, f);
            if (this.fLW) {
                this.mPath.addCircle(this.psS.centerX(), this.psS.centerY(), Math.min(this.psS.width(), this.psS.height()) / 2.0f, Path.Direction.CW);
            } else if (this.psG) {
                if (this.psF == null) {
                    this.psF = new float[8];
                }
                for (int i2 = 0; i2 < this.psE.length; i2++) {
                    this.psF[i2] = this.psR[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.psS, this.psF, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.psS, this.psR, Path.Direction.CW);
            }
            this.psS.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.ptd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean esa() {
        return this.fLW || this.psP || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.psO.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.psO.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.psO.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.psO.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.psO.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.psO.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.psO.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.psO.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.psO.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.psO.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.psO.draw(canvas);
    }
}
