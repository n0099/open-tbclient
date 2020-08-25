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
/* loaded from: classes4.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    private r mTransformCallback;
    @Nullable
    float[] noJ;
    @Nullable
    RectF noO;
    @Nullable
    Matrix noP;
    private final Drawable noT;
    @Nullable
    Matrix npg;
    protected boolean eWr = false;
    protected boolean noU = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean noV = true;
    protected int mBorderColor = 0;
    protected final Path noL = new Path();
    private final float[] noW = new float[8];
    final float[] noI = new float[8];
    final RectF noX = new RectF();
    final RectF noY = new RectF();
    final RectF noZ = new RectF();
    final RectF npa = new RectF();
    final Matrix npb = new Matrix();
    final Matrix npc = new Matrix();
    final Matrix npd = new Matrix();
    final Matrix npe = new Matrix();
    final Matrix npf = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean noK = false;
    private boolean nph = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.noT = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void xV(boolean z) {
        this.eWr = z;
        this.nph = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.noW, f);
        this.noU = f != 0.0f;
        this.nph = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.noW, 0.0f);
            this.noU = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.noW, 0, 8);
            this.noU = false;
            for (int i = 0; i < 8; i++) {
                this.noU = (fArr[i] > 0.0f) | this.noU;
            }
        }
        this.nph = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.nph = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aM(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.nph = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void xW(boolean z) {
        if (this.noK != z) {
            this.noK = z;
            this.nph = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dQs() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.npd);
            this.mTransformCallback.getRootBounds(this.noX);
        } else {
            this.npd.reset();
            this.noX.set(getBounds());
        }
        this.noZ.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.npa.set(this.noT.getBounds());
        this.npb.setRectToRect(this.noZ, this.npa, Matrix.ScaleToFit.FILL);
        if (this.noK) {
            if (this.noO == null) {
                this.noO = new RectF(this.noX);
            } else {
                this.noO.set(this.noX);
            }
            this.noO.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.noP == null) {
                this.noP = new Matrix();
            }
            this.noP.setRectToRect(this.noX, this.noO, Matrix.ScaleToFit.FILL);
        } else if (this.noP != null) {
            this.noP.reset();
        }
        if (!this.npd.equals(this.npe) || !this.npb.equals(this.npc) || (this.noP != null && !this.noP.equals(this.npg))) {
            this.noV = true;
            this.npd.invert(this.npf);
            this.mTransform.set(this.npd);
            if (this.noK) {
                this.mTransform.postConcat(this.noP);
            }
            this.mTransform.preConcat(this.npb);
            this.npe.set(this.npd);
            this.npc.set(this.npb);
            if (this.noK) {
                if (this.npg == null) {
                    this.npg = new Matrix(this.noP);
                } else {
                    this.npg.set(this.noP);
                }
            } else if (this.npg != null) {
                this.npg.reset();
            }
        }
        if (!this.noX.equals(this.noY)) {
            this.nph = true;
            this.noY.set(this.noX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dQr() {
        if (this.nph) {
            this.noL.reset();
            this.noX.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.eWr) {
                this.noL.addCircle(this.noX.centerX(), this.noX.centerY(), Math.min(this.noX.width(), this.noX.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.noI.length; i++) {
                    this.noI[i] = (this.noW[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.noL.addRoundRect(this.noX, this.noI, Path.Direction.CW);
            }
            this.noX.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.noK ? this.mBorderWidth : 0.0f);
            this.noX.inset(f, f);
            if (this.eWr) {
                this.mPath.addCircle(this.noX.centerX(), this.noX.centerY(), Math.min(this.noX.width(), this.noX.height()) / 2.0f, Path.Direction.CW);
            } else if (this.noK) {
                if (this.noJ == null) {
                    this.noJ = new float[8];
                }
                for (int i2 = 0; i2 < this.noI.length; i2++) {
                    this.noJ[i2] = this.noW[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.noX, this.noJ, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.noX, this.noW, Path.Direction.CW);
            }
            this.noX.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.nph = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dQq() {
        return this.eWr || this.noU || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.noT.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.noT.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.noT.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.noT.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.noT.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.noT.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.noT.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.noT.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.noT.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.noT.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.noT.draw(canvas);
    }
}
