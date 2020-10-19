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
/* loaded from: classes15.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    private r mTransformCallback;
    private final Drawable nOC;
    @Nullable
    Matrix nOP;
    @Nullable
    float[] nOs;
    @Nullable
    RectF nOx;
    @Nullable
    Matrix nOy;
    protected boolean fly = false;
    protected boolean nOD = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean nOE = true;
    protected int mBorderColor = 0;
    protected final Path nOu = new Path();
    private final float[] nOF = new float[8];
    final float[] nOr = new float[8];
    final RectF nOG = new RectF();
    final RectF nOH = new RectF();
    final RectF nOI = new RectF();
    final RectF nOJ = new RectF();
    final Matrix nOK = new Matrix();
    final Matrix nOL = new Matrix();
    final Matrix nOM = new Matrix();
    final Matrix nON = new Matrix();
    final Matrix nOO = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean nOt = false;
    private boolean nOQ = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.nOC = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void yN(boolean z) {
        this.fly = z;
        this.nOQ = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.nOF, f);
        this.nOD = f != 0.0f;
        this.nOQ = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.nOF, 0.0f);
            this.nOD = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.nOF, 0, 8);
            this.nOD = false;
            for (int i = 0; i < 8; i++) {
                this.nOD = (fArr[i] > 0.0f) | this.nOD;
            }
        }
        this.nOQ = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.nOQ = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aS(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.nOQ = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void yO(boolean z) {
        if (this.nOt != z) {
            this.nOt = z;
            this.nOQ = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dYk() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.nOM);
            this.mTransformCallback.getRootBounds(this.nOG);
        } else {
            this.nOM.reset();
            this.nOG.set(getBounds());
        }
        this.nOI.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.nOJ.set(this.nOC.getBounds());
        this.nOK.setRectToRect(this.nOI, this.nOJ, Matrix.ScaleToFit.FILL);
        if (this.nOt) {
            if (this.nOx == null) {
                this.nOx = new RectF(this.nOG);
            } else {
                this.nOx.set(this.nOG);
            }
            this.nOx.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.nOy == null) {
                this.nOy = new Matrix();
            }
            this.nOy.setRectToRect(this.nOG, this.nOx, Matrix.ScaleToFit.FILL);
        } else if (this.nOy != null) {
            this.nOy.reset();
        }
        if (!this.nOM.equals(this.nON) || !this.nOK.equals(this.nOL) || (this.nOy != null && !this.nOy.equals(this.nOP))) {
            this.nOE = true;
            this.nOM.invert(this.nOO);
            this.mTransform.set(this.nOM);
            if (this.nOt) {
                this.mTransform.postConcat(this.nOy);
            }
            this.mTransform.preConcat(this.nOK);
            this.nON.set(this.nOM);
            this.nOL.set(this.nOK);
            if (this.nOt) {
                if (this.nOP == null) {
                    this.nOP = new Matrix(this.nOy);
                } else {
                    this.nOP.set(this.nOy);
                }
            } else if (this.nOP != null) {
                this.nOP.reset();
            }
        }
        if (!this.nOG.equals(this.nOH)) {
            this.nOQ = true;
            this.nOH.set(this.nOG);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dYj() {
        if (this.nOQ) {
            this.nOu.reset();
            this.nOG.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fly) {
                this.nOu.addCircle(this.nOG.centerX(), this.nOG.centerY(), Math.min(this.nOG.width(), this.nOG.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.nOr.length; i++) {
                    this.nOr[i] = (this.nOF[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.nOu.addRoundRect(this.nOG, this.nOr, Path.Direction.CW);
            }
            this.nOG.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.nOt ? this.mBorderWidth : 0.0f);
            this.nOG.inset(f, f);
            if (this.fly) {
                this.mPath.addCircle(this.nOG.centerX(), this.nOG.centerY(), Math.min(this.nOG.width(), this.nOG.height()) / 2.0f, Path.Direction.CW);
            } else if (this.nOt) {
                if (this.nOs == null) {
                    this.nOs = new float[8];
                }
                for (int i2 = 0; i2 < this.nOr.length; i2++) {
                    this.nOs[i2] = this.nOF[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.nOG, this.nOs, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.nOG, this.nOF, Path.Direction.CW);
            }
            this.nOG.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.nOQ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dYi() {
        return this.fly || this.nOD || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.nOC.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.nOC.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.nOC.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.nOC.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.nOC.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.nOC.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.nOC.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.nOC.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.nOC.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.nOC.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.nOC.draw(canvas);
    }
}
