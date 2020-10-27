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
    @Nullable
    float[] oFL;
    @Nullable
    RectF oFQ;
    @Nullable
    Matrix oFR;
    private final Drawable oFV;
    @Nullable
    Matrix oGi;
    protected boolean ftZ = false;
    protected boolean oFW = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean oFX = true;
    protected int mBorderColor = 0;
    protected final Path oFN = new Path();
    private final float[] oFY = new float[8];
    final float[] oFK = new float[8];
    final RectF oFZ = new RectF();
    final RectF oGa = new RectF();
    final RectF oGb = new RectF();
    final RectF oGc = new RectF();
    final Matrix oGd = new Matrix();
    final Matrix oGe = new Matrix();
    final Matrix oGf = new Matrix();
    final Matrix oGg = new Matrix();
    final Matrix oGh = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean oFM = false;
    private boolean oGj = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.oFV = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void zV(boolean z) {
        this.ftZ = z;
        this.oGj = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.oFY, f);
        this.oFW = f != 0.0f;
        this.oGj = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.oFY, 0.0f);
            this.oFW = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.oFY, 0, 8);
            this.oFW = false;
            for (int i = 0; i < 8; i++) {
                this.oFW = (fArr[i] > 0.0f) | this.oFW;
            }
        }
        this.oGj = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.oGj = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bj(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.oGj = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void zW(boolean z) {
        if (this.oFM != z) {
            this.oFM = z;
            this.oGj = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eii() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.oGf);
            this.mTransformCallback.getRootBounds(this.oFZ);
        } else {
            this.oGf.reset();
            this.oFZ.set(getBounds());
        }
        this.oGb.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.oGc.set(this.oFV.getBounds());
        this.oGd.setRectToRect(this.oGb, this.oGc, Matrix.ScaleToFit.FILL);
        if (this.oFM) {
            if (this.oFQ == null) {
                this.oFQ = new RectF(this.oFZ);
            } else {
                this.oFQ.set(this.oFZ);
            }
            this.oFQ.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.oFR == null) {
                this.oFR = new Matrix();
            }
            this.oFR.setRectToRect(this.oFZ, this.oFQ, Matrix.ScaleToFit.FILL);
        } else if (this.oFR != null) {
            this.oFR.reset();
        }
        if (!this.oGf.equals(this.oGg) || !this.oGd.equals(this.oGe) || (this.oFR != null && !this.oFR.equals(this.oGi))) {
            this.oFX = true;
            this.oGf.invert(this.oGh);
            this.mTransform.set(this.oGf);
            if (this.oFM) {
                this.mTransform.postConcat(this.oFR);
            }
            this.mTransform.preConcat(this.oGd);
            this.oGg.set(this.oGf);
            this.oGe.set(this.oGd);
            if (this.oFM) {
                if (this.oGi == null) {
                    this.oGi = new Matrix(this.oFR);
                } else {
                    this.oGi.set(this.oFR);
                }
            } else if (this.oGi != null) {
                this.oGi.reset();
            }
        }
        if (!this.oFZ.equals(this.oGa)) {
            this.oGj = true;
            this.oGa.set(this.oFZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eih() {
        if (this.oGj) {
            this.oFN.reset();
            this.oFZ.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.ftZ) {
                this.oFN.addCircle(this.oFZ.centerX(), this.oFZ.centerY(), Math.min(this.oFZ.width(), this.oFZ.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.oFK.length; i++) {
                    this.oFK[i] = (this.oFY[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.oFN.addRoundRect(this.oFZ, this.oFK, Path.Direction.CW);
            }
            this.oFZ.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.oFM ? this.mBorderWidth : 0.0f);
            this.oFZ.inset(f, f);
            if (this.ftZ) {
                this.mPath.addCircle(this.oFZ.centerX(), this.oFZ.centerY(), Math.min(this.oFZ.width(), this.oFZ.height()) / 2.0f, Path.Direction.CW);
            } else if (this.oFM) {
                if (this.oFL == null) {
                    this.oFL = new float[8];
                }
                for (int i2 = 0; i2 < this.oFK.length; i2++) {
                    this.oFL[i2] = this.oFY[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.oFZ, this.oFL, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.oFZ, this.oFY, Path.Direction.CW);
            }
            this.oFZ.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.oGj = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eig() {
        return this.ftZ || this.oFW || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.oFV.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.oFV.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.oFV.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.oFV.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.oFV.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.oFV.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.oFV.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.oFV.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.oFV.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.oFV.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.oFV.draw(canvas);
    }
}
