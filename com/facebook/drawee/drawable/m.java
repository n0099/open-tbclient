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
/* loaded from: classes9.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    private r mTransformCallback;
    @Nullable
    float[] mUT;
    @Nullable
    RectF mUY;
    @Nullable
    Matrix mUZ;
    private final Drawable mVd;
    @Nullable
    Matrix mVq;
    protected boolean eLL = false;
    protected boolean mVe = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean mVf = true;
    protected int mBorderColor = 0;
    protected final Path mUV = new Path();
    private final float[] mVg = new float[8];
    final float[] mUS = new float[8];
    final RectF mVh = new RectF();
    final RectF mVi = new RectF();
    final RectF mVj = new RectF();
    final RectF mVk = new RectF();
    final Matrix mVl = new Matrix();
    final Matrix mVm = new Matrix();
    final Matrix mVn = new Matrix();
    final Matrix mVo = new Matrix();
    final Matrix mVp = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean mUU = false;
    private boolean mVr = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.mVd = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void xe(boolean z) {
        this.eLL = z;
        this.mVr = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.mVg, f);
        this.mVe = f != 0.0f;
        this.mVr = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mVg, 0.0f);
            this.mVe = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mVg, 0, 8);
            this.mVe = false;
            for (int i = 0; i < 8; i++) {
                this.mVe = (fArr[i] > 0.0f) | this.mVe;
            }
        }
        this.mVr = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.mVr = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aG(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.mVr = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void xf(boolean z) {
        if (this.mUU != z) {
            this.mUU = z;
            this.mVr = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dEs() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.mVn);
            this.mTransformCallback.getRootBounds(this.mVh);
        } else {
            this.mVn.reset();
            this.mVh.set(getBounds());
        }
        this.mVj.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.mVk.set(this.mVd.getBounds());
        this.mVl.setRectToRect(this.mVj, this.mVk, Matrix.ScaleToFit.FILL);
        if (this.mUU) {
            if (this.mUY == null) {
                this.mUY = new RectF(this.mVh);
            } else {
                this.mUY.set(this.mVh);
            }
            this.mUY.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.mUZ == null) {
                this.mUZ = new Matrix();
            }
            this.mUZ.setRectToRect(this.mVh, this.mUY, Matrix.ScaleToFit.FILL);
        } else if (this.mUZ != null) {
            this.mUZ.reset();
        }
        if (!this.mVn.equals(this.mVo) || !this.mVl.equals(this.mVm) || (this.mUZ != null && !this.mUZ.equals(this.mVq))) {
            this.mVf = true;
            this.mVn.invert(this.mVp);
            this.mTransform.set(this.mVn);
            if (this.mUU) {
                this.mTransform.postConcat(this.mUZ);
            }
            this.mTransform.preConcat(this.mVl);
            this.mVo.set(this.mVn);
            this.mVm.set(this.mVl);
            if (this.mUU) {
                if (this.mVq == null) {
                    this.mVq = new Matrix(this.mUZ);
                } else {
                    this.mVq.set(this.mUZ);
                }
            } else if (this.mVq != null) {
                this.mVq.reset();
            }
        }
        if (!this.mVh.equals(this.mVi)) {
            this.mVr = true;
            this.mVi.set(this.mVh);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dEr() {
        if (this.mVr) {
            this.mUV.reset();
            this.mVh.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.eLL) {
                this.mUV.addCircle(this.mVh.centerX(), this.mVh.centerY(), Math.min(this.mVh.width(), this.mVh.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.mUS.length; i++) {
                    this.mUS[i] = (this.mVg[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.mUV.addRoundRect(this.mVh, this.mUS, Path.Direction.CW);
            }
            this.mVh.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.mUU ? this.mBorderWidth : 0.0f);
            this.mVh.inset(f, f);
            if (this.eLL) {
                this.mPath.addCircle(this.mVh.centerX(), this.mVh.centerY(), Math.min(this.mVh.width(), this.mVh.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mUU) {
                if (this.mUT == null) {
                    this.mUT = new float[8];
                }
                for (int i2 = 0; i2 < this.mUS.length; i2++) {
                    this.mUT[i2] = this.mVg[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.mVh, this.mUT, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mVh, this.mVg, Path.Direction.CW);
            }
            this.mVh.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mVr = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dEq() {
        return this.eLL || this.mVe || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mVd.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mVd.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mVd.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mVd.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.mVd.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mVd.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.mVd.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.mVd.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.mVd.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mVd.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.mVd.draw(canvas);
    }
}
