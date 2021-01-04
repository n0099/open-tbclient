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
/* loaded from: classes15.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    private r pwx;
    @Nullable
    float[] pxa;
    @Nullable
    RectF pxe;
    @Nullable
    Matrix pxf;
    private final Drawable pxj;
    @Nullable
    Matrix pxw;
    protected boolean fQD = false;
    protected boolean pxk = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean pxl = true;
    protected int mBorderColor = 0;
    protected final Path eYI = new Path();
    private final float[] pxm = new float[8];
    final float[] pwZ = new float[8];
    final RectF pxn = new RectF();
    final RectF pxo = new RectF();
    final RectF pxp = new RectF();
    final RectF pxq = new RectF();
    final Matrix pxr = new Matrix();
    final Matrix pxs = new Matrix();
    final Matrix pxt = new Matrix();
    final Matrix pxu = new Matrix();
    final Matrix pxv = new Matrix();
    final Matrix pxx = new Matrix();
    private float mPadding = 0.0f;
    private boolean pxb = false;
    private boolean pxy = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.pxj = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void AY(boolean z) {
        this.fQD = z;
        this.pxy = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.pxm, f);
        this.pxk = f != 0.0f;
        this.pxy = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.pxm, 0.0f);
            this.pxk = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.pxm, 0, 8);
            this.pxk = false;
            for (int i = 0; i < 8; i++) {
                this.pxk = (fArr[i] > 0.0f) | this.pxk;
            }
        }
        this.pxy = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.pxy = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bF(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.pxy = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void AZ(boolean z) {
        if (this.pxb != z) {
            this.pxb = z;
            this.pxy = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void a(@Nullable r rVar) {
        this.pwx = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void evO() {
        if (this.pwx != null) {
            this.pwx.f(this.pxt);
            this.pwx.b(this.pxn);
        } else {
            this.pxt.reset();
            this.pxn.set(getBounds());
        }
        this.pxp.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.pxq.set(this.pxj.getBounds());
        this.pxr.setRectToRect(this.pxp, this.pxq, Matrix.ScaleToFit.FILL);
        if (this.pxb) {
            if (this.pxe == null) {
                this.pxe = new RectF(this.pxn);
            } else {
                this.pxe.set(this.pxn);
            }
            this.pxe.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.pxf == null) {
                this.pxf = new Matrix();
            }
            this.pxf.setRectToRect(this.pxn, this.pxe, Matrix.ScaleToFit.FILL);
        } else if (this.pxf != null) {
            this.pxf.reset();
        }
        if (!this.pxt.equals(this.pxu) || !this.pxr.equals(this.pxs) || (this.pxf != null && !this.pxf.equals(this.pxw))) {
            this.pxl = true;
            this.pxt.invert(this.pxv);
            this.pxx.set(this.pxt);
            if (this.pxb) {
                this.pxx.postConcat(this.pxf);
            }
            this.pxx.preConcat(this.pxr);
            this.pxu.set(this.pxt);
            this.pxs.set(this.pxr);
            if (this.pxb) {
                if (this.pxw == null) {
                    this.pxw = new Matrix(this.pxf);
                } else {
                    this.pxw.set(this.pxf);
                }
            } else if (this.pxw != null) {
                this.pxw.reset();
            }
        }
        if (!this.pxn.equals(this.pxo)) {
            this.pxy = true;
            this.pxo.set(this.pxn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void evN() {
        if (this.pxy) {
            this.eYI.reset();
            this.pxn.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fQD) {
                this.eYI.addCircle(this.pxn.centerX(), this.pxn.centerY(), Math.min(this.pxn.width(), this.pxn.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.pwZ.length; i++) {
                    this.pwZ[i] = (this.pxm[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.eYI.addRoundRect(this.pxn, this.pwZ, Path.Direction.CW);
            }
            this.pxn.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.pxb ? this.mBorderWidth : 0.0f);
            this.pxn.inset(f, f);
            if (this.fQD) {
                this.mPath.addCircle(this.pxn.centerX(), this.pxn.centerY(), Math.min(this.pxn.width(), this.pxn.height()) / 2.0f, Path.Direction.CW);
            } else if (this.pxb) {
                if (this.pxa == null) {
                    this.pxa = new float[8];
                }
                for (int i2 = 0; i2 < this.pwZ.length; i2++) {
                    this.pxa[i2] = this.pxm[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.pxn, this.pxa, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.pxn, this.pxm, Path.Direction.CW);
            }
            this.pxn.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.pxy = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean evM() {
        return this.fQD || this.pxk || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.pxj.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pxj.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pxj.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.pxj.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.pxj.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.pxj.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.pxj.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.pxj.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.pxj.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pxj.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.pxj.draw(canvas);
    }
}
