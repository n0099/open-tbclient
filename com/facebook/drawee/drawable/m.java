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
    float[] mMF;
    @Nullable
    RectF mMK;
    @Nullable
    Matrix mML;
    private final Drawable mMP;
    @Nullable
    Matrix mNc;
    @Nullable
    private r mTransformCallback;
    protected boolean eFp = false;
    protected boolean mMQ = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean mMR = true;
    protected int mBorderColor = 0;
    protected final Path mMH = new Path();
    private final float[] mMS = new float[8];
    final float[] mME = new float[8];
    final RectF mMT = new RectF();
    final RectF mMU = new RectF();
    final RectF mMV = new RectF();
    final RectF mMW = new RectF();
    final Matrix mMX = new Matrix();
    final Matrix mMY = new Matrix();
    final Matrix mMZ = new Matrix();
    final Matrix mNa = new Matrix();
    final Matrix mNb = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean mMG = false;
    private boolean mNd = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.mMP = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void wz(boolean z) {
        this.eFp = z;
        this.mNd = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.mMS, f);
        this.mMQ = f != 0.0f;
        this.mNd = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mMS, 0.0f);
            this.mMQ = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mMS, 0, 8);
            this.mMQ = false;
            for (int i = 0; i < 8; i++) {
                this.mMQ = (fArr[i] > 0.0f) | this.mMQ;
            }
        }
        this.mNd = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.mNd = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aH(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.mNd = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void wA(boolean z) {
        if (this.mMG != z) {
            this.mMG = z;
            this.mNd = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dBb() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.mMZ);
            this.mTransformCallback.getRootBounds(this.mMT);
        } else {
            this.mMZ.reset();
            this.mMT.set(getBounds());
        }
        this.mMV.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.mMW.set(this.mMP.getBounds());
        this.mMX.setRectToRect(this.mMV, this.mMW, Matrix.ScaleToFit.FILL);
        if (this.mMG) {
            if (this.mMK == null) {
                this.mMK = new RectF(this.mMT);
            } else {
                this.mMK.set(this.mMT);
            }
            this.mMK.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.mML == null) {
                this.mML = new Matrix();
            }
            this.mML.setRectToRect(this.mMT, this.mMK, Matrix.ScaleToFit.FILL);
        } else if (this.mML != null) {
            this.mML.reset();
        }
        if (!this.mMZ.equals(this.mNa) || !this.mMX.equals(this.mMY) || (this.mML != null && !this.mML.equals(this.mNc))) {
            this.mMR = true;
            this.mMZ.invert(this.mNb);
            this.mTransform.set(this.mMZ);
            if (this.mMG) {
                this.mTransform.postConcat(this.mML);
            }
            this.mTransform.preConcat(this.mMX);
            this.mNa.set(this.mMZ);
            this.mMY.set(this.mMX);
            if (this.mMG) {
                if (this.mNc == null) {
                    this.mNc = new Matrix(this.mML);
                } else {
                    this.mNc.set(this.mML);
                }
            } else if (this.mNc != null) {
                this.mNc.reset();
            }
        }
        if (!this.mMT.equals(this.mMU)) {
            this.mNd = true;
            this.mMU.set(this.mMT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dBa() {
        if (this.mNd) {
            this.mMH.reset();
            this.mMT.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.eFp) {
                this.mMH.addCircle(this.mMT.centerX(), this.mMT.centerY(), Math.min(this.mMT.width(), this.mMT.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.mME.length; i++) {
                    this.mME[i] = (this.mMS[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.mMH.addRoundRect(this.mMT, this.mME, Path.Direction.CW);
            }
            this.mMT.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.mMG ? this.mBorderWidth : 0.0f);
            this.mMT.inset(f, f);
            if (this.eFp) {
                this.mPath.addCircle(this.mMT.centerX(), this.mMT.centerY(), Math.min(this.mMT.width(), this.mMT.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mMG) {
                if (this.mMF == null) {
                    this.mMF = new float[8];
                }
                for (int i2 = 0; i2 < this.mME.length; i2++) {
                    this.mMF[i2] = this.mMS[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.mMT, this.mMF, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mMT, this.mMS, Path.Direction.CW);
            }
            this.mMT.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mNd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dAZ() {
        return this.eFp || this.mMQ || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mMP.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mMP.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mMP.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mMP.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.mMP.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mMP.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.mMP.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.mMP.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.mMP.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mMP.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.mMP.draw(canvas);
    }
}
