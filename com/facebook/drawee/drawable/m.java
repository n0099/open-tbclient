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
/* loaded from: classes4.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    private r pwE;
    @Nullable
    Matrix pxD;
    @Nullable
    float[] pxh;
    @Nullable
    RectF pxl;
    @Nullable
    Matrix pxm;
    private final Drawable pxq;
    protected boolean fQD = false;
    protected boolean pxr = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean pxs = true;
    protected int mBorderColor = 0;
    protected final Path eYI = new Path();
    private final float[] pxt = new float[8];
    final float[] pxg = new float[8];
    final RectF pxu = new RectF();
    final RectF pxv = new RectF();
    final RectF pxw = new RectF();
    final RectF pxx = new RectF();
    final Matrix pxy = new Matrix();
    final Matrix pxz = new Matrix();
    final Matrix pxA = new Matrix();
    final Matrix pxB = new Matrix();
    final Matrix pxC = new Matrix();
    final Matrix pxE = new Matrix();
    private float mPadding = 0.0f;
    private boolean pxi = false;
    private boolean pxF = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.pxq = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void AY(boolean z) {
        this.fQD = z;
        this.pxF = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.pxt, f);
        this.pxr = f != 0.0f;
        this.pxF = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.pxt, 0.0f);
            this.pxr = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.pxt, 0, 8);
            this.pxr = false;
            for (int i = 0; i < 8; i++) {
                this.pxr = (fArr[i] > 0.0f) | this.pxr;
            }
        }
        this.pxF = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.pxF = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bF(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.pxF = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void AZ(boolean z) {
        if (this.pxi != z) {
            this.pxi = z;
            this.pxF = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void a(@Nullable r rVar) {
        this.pwE = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void evV() {
        if (this.pwE != null) {
            this.pwE.f(this.pxA);
            this.pwE.b(this.pxu);
        } else {
            this.pxA.reset();
            this.pxu.set(getBounds());
        }
        this.pxw.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.pxx.set(this.pxq.getBounds());
        this.pxy.setRectToRect(this.pxw, this.pxx, Matrix.ScaleToFit.FILL);
        if (this.pxi) {
            if (this.pxl == null) {
                this.pxl = new RectF(this.pxu);
            } else {
                this.pxl.set(this.pxu);
            }
            this.pxl.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.pxm == null) {
                this.pxm = new Matrix();
            }
            this.pxm.setRectToRect(this.pxu, this.pxl, Matrix.ScaleToFit.FILL);
        } else if (this.pxm != null) {
            this.pxm.reset();
        }
        if (!this.pxA.equals(this.pxB) || !this.pxy.equals(this.pxz) || (this.pxm != null && !this.pxm.equals(this.pxD))) {
            this.pxs = true;
            this.pxA.invert(this.pxC);
            this.pxE.set(this.pxA);
            if (this.pxi) {
                this.pxE.postConcat(this.pxm);
            }
            this.pxE.preConcat(this.pxy);
            this.pxB.set(this.pxA);
            this.pxz.set(this.pxy);
            if (this.pxi) {
                if (this.pxD == null) {
                    this.pxD = new Matrix(this.pxm);
                } else {
                    this.pxD.set(this.pxm);
                }
            } else if (this.pxD != null) {
                this.pxD.reset();
            }
        }
        if (!this.pxu.equals(this.pxv)) {
            this.pxF = true;
            this.pxv.set(this.pxu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void evU() {
        if (this.pxF) {
            this.eYI.reset();
            this.pxu.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fQD) {
                this.eYI.addCircle(this.pxu.centerX(), this.pxu.centerY(), Math.min(this.pxu.width(), this.pxu.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.pxg.length; i++) {
                    this.pxg[i] = (this.pxt[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.eYI.addRoundRect(this.pxu, this.pxg, Path.Direction.CW);
            }
            this.pxu.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.pxi ? this.mBorderWidth : 0.0f);
            this.pxu.inset(f, f);
            if (this.fQD) {
                this.mPath.addCircle(this.pxu.centerX(), this.pxu.centerY(), Math.min(this.pxu.width(), this.pxu.height()) / 2.0f, Path.Direction.CW);
            } else if (this.pxi) {
                if (this.pxh == null) {
                    this.pxh = new float[8];
                }
                for (int i2 = 0; i2 < this.pxg.length; i2++) {
                    this.pxh[i2] = this.pxt[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.pxu, this.pxh, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.pxu, this.pxt, Path.Direction.CW);
            }
            this.pxu.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.pxF = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean evT() {
        return this.fQD || this.pxr || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.pxq.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pxq.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pxq.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.pxq.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.pxq.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.pxq.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.pxq.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.pxq.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.pxq.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pxq.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.pxq.draw(canvas);
    }
}
