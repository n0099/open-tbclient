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
    float[] mUR;
    @Nullable
    RectF mUW;
    @Nullable
    Matrix mUX;
    private final Drawable mVb;
    @Nullable
    Matrix mVo;
    protected boolean eLL = false;
    protected boolean mVc = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean mVd = true;
    protected int mBorderColor = 0;
    protected final Path mUT = new Path();
    private final float[] mVe = new float[8];
    final float[] mUQ = new float[8];
    final RectF mVf = new RectF();
    final RectF mVg = new RectF();
    final RectF mVh = new RectF();
    final RectF mVi = new RectF();
    final Matrix mVj = new Matrix();
    final Matrix mVk = new Matrix();
    final Matrix mVl = new Matrix();
    final Matrix mVm = new Matrix();
    final Matrix mVn = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean mUS = false;
    private boolean mVp = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.mVb = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void xe(boolean z) {
        this.eLL = z;
        this.mVp = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.mVe, f);
        this.mVc = f != 0.0f;
        this.mVp = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mVe, 0.0f);
            this.mVc = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mVe, 0, 8);
            this.mVc = false;
            for (int i = 0; i < 8; i++) {
                this.mVc = (fArr[i] > 0.0f) | this.mVc;
            }
        }
        this.mVp = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.mVp = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aG(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.mVp = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void xf(boolean z) {
        if (this.mUS != z) {
            this.mUS = z;
            this.mVp = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dEr() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.mVl);
            this.mTransformCallback.getRootBounds(this.mVf);
        } else {
            this.mVl.reset();
            this.mVf.set(getBounds());
        }
        this.mVh.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.mVi.set(this.mVb.getBounds());
        this.mVj.setRectToRect(this.mVh, this.mVi, Matrix.ScaleToFit.FILL);
        if (this.mUS) {
            if (this.mUW == null) {
                this.mUW = new RectF(this.mVf);
            } else {
                this.mUW.set(this.mVf);
            }
            this.mUW.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.mUX == null) {
                this.mUX = new Matrix();
            }
            this.mUX.setRectToRect(this.mVf, this.mUW, Matrix.ScaleToFit.FILL);
        } else if (this.mUX != null) {
            this.mUX.reset();
        }
        if (!this.mVl.equals(this.mVm) || !this.mVj.equals(this.mVk) || (this.mUX != null && !this.mUX.equals(this.mVo))) {
            this.mVd = true;
            this.mVl.invert(this.mVn);
            this.mTransform.set(this.mVl);
            if (this.mUS) {
                this.mTransform.postConcat(this.mUX);
            }
            this.mTransform.preConcat(this.mVj);
            this.mVm.set(this.mVl);
            this.mVk.set(this.mVj);
            if (this.mUS) {
                if (this.mVo == null) {
                    this.mVo = new Matrix(this.mUX);
                } else {
                    this.mVo.set(this.mUX);
                }
            } else if (this.mVo != null) {
                this.mVo.reset();
            }
        }
        if (!this.mVf.equals(this.mVg)) {
            this.mVp = true;
            this.mVg.set(this.mVf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dEq() {
        if (this.mVp) {
            this.mUT.reset();
            this.mVf.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.eLL) {
                this.mUT.addCircle(this.mVf.centerX(), this.mVf.centerY(), Math.min(this.mVf.width(), this.mVf.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.mUQ.length; i++) {
                    this.mUQ[i] = (this.mVe[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.mUT.addRoundRect(this.mVf, this.mUQ, Path.Direction.CW);
            }
            this.mVf.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.mUS ? this.mBorderWidth : 0.0f);
            this.mVf.inset(f, f);
            if (this.eLL) {
                this.mPath.addCircle(this.mVf.centerX(), this.mVf.centerY(), Math.min(this.mVf.width(), this.mVf.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mUS) {
                if (this.mUR == null) {
                    this.mUR = new float[8];
                }
                for (int i2 = 0; i2 < this.mUQ.length; i2++) {
                    this.mUR[i2] = this.mVe[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.mVf, this.mUR, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mVf, this.mVe, Path.Direction.CW);
            }
            this.mVf.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mVp = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dEp() {
        return this.eLL || this.mVc || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mVb.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mVb.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mVb.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mVb.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.mVb.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mVb.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.mVb.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.mVb.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.mVb.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mVb.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.mVb.draw(canvas);
    }
}
