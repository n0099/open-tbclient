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
    float[] mqG;
    @Nullable
    RectF mqM;
    @Nullable
    Matrix mqN;
    private final Drawable mqR;
    @Nullable
    Matrix mre;
    protected boolean ewj = false;
    protected boolean mqS = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean mqT = true;
    protected int mBorderColor = 0;
    protected final Path mqJ = new Path();
    private final float[] mqU = new float[8];
    final float[] mqF = new float[8];
    final RectF mqV = new RectF();
    final RectF mqW = new RectF();
    final RectF mqX = new RectF();
    final RectF mqY = new RectF();
    final Matrix mqZ = new Matrix();
    final Matrix mra = new Matrix();
    final Matrix mrb = new Matrix();
    final Matrix mrc = new Matrix();
    final Matrix mrd = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mqH = 0.0f;
    private boolean mqI = false;
    private boolean mrf = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.mqR = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void wd(boolean z) {
        this.ewj = z;
        this.mrf = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.mqU, f);
        this.mqS = f != 0.0f;
        this.mrf = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void y(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mqU, 0.0f);
            this.mqS = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mqU, 0, 8);
            this.mqS = false;
            for (int i = 0; i < 8; i++) {
                this.mqS = (fArr[i] > 0.0f) | this.mqS;
            }
        }
        this.mrf = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.mrf = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aB(float f) {
        if (this.mqH != f) {
            this.mqH = f;
            this.mrf = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void we(boolean z) {
        if (this.mqI != z) {
            this.mqI = z;
            this.mrf = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwy() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.mrb);
            this.mTransformCallback.getRootBounds(this.mqV);
        } else {
            this.mrb.reset();
            this.mqV.set(getBounds());
        }
        this.mqX.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.mqY.set(this.mqR.getBounds());
        this.mqZ.setRectToRect(this.mqX, this.mqY, Matrix.ScaleToFit.FILL);
        if (this.mqI) {
            if (this.mqM == null) {
                this.mqM = new RectF(this.mqV);
            } else {
                this.mqM.set(this.mqV);
            }
            this.mqM.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.mqN == null) {
                this.mqN = new Matrix();
            }
            this.mqN.setRectToRect(this.mqV, this.mqM, Matrix.ScaleToFit.FILL);
        } else if (this.mqN != null) {
            this.mqN.reset();
        }
        if (!this.mrb.equals(this.mrc) || !this.mqZ.equals(this.mra) || (this.mqN != null && !this.mqN.equals(this.mre))) {
            this.mqT = true;
            this.mrb.invert(this.mrd);
            this.mTransform.set(this.mrb);
            if (this.mqI) {
                this.mTransform.postConcat(this.mqN);
            }
            this.mTransform.preConcat(this.mqZ);
            this.mrc.set(this.mrb);
            this.mra.set(this.mqZ);
            if (this.mqI) {
                if (this.mre == null) {
                    this.mre = new Matrix(this.mqN);
                } else {
                    this.mre.set(this.mqN);
                }
            } else if (this.mre != null) {
                this.mre.reset();
            }
        }
        if (!this.mqV.equals(this.mqW)) {
            this.mrf = true;
            this.mqW.set(this.mqV);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwx() {
        if (this.mrf) {
            this.mqJ.reset();
            this.mqV.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.ewj) {
                this.mqJ.addCircle(this.mqV.centerX(), this.mqV.centerY(), Math.min(this.mqV.width(), this.mqV.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.mqF.length; i++) {
                    this.mqF[i] = (this.mqU[i] + this.mqH) - (this.mBorderWidth / 2.0f);
                }
                this.mqJ.addRoundRect(this.mqV, this.mqF, Path.Direction.CW);
            }
            this.mqV.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mqH + (this.mqI ? this.mBorderWidth : 0.0f);
            this.mqV.inset(f, f);
            if (this.ewj) {
                this.mPath.addCircle(this.mqV.centerX(), this.mqV.centerY(), Math.min(this.mqV.width(), this.mqV.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mqI) {
                if (this.mqG == null) {
                    this.mqG = new float[8];
                }
                for (int i2 = 0; i2 < this.mqF.length; i2++) {
                    this.mqG[i2] = this.mqU[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.mqV, this.mqG, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mqV, this.mqU, Path.Direction.CW);
            }
            this.mqV.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mrf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dww() {
        return this.ewj || this.mqS || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mqR.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mqR.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mqR.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mqR.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.mqR.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mqR.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.mqR.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.mqR.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.mqR.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mqR.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.mqR.draw(canvas);
    }
}
