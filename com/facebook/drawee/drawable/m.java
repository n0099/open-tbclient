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
/* loaded from: classes11.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    private r mTransformCallback;
    @Nullable
    float[] nyZ;
    @Nullable
    RectF nze;
    @Nullable
    Matrix nzf;
    private final Drawable nzj;
    @Nullable
    Matrix nzw;
    protected boolean eZm = false;
    protected boolean nzk = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean nzl = true;
    protected int mBorderColor = 0;
    protected final Path nzb = new Path();
    private final float[] nzm = new float[8];
    final float[] nyY = new float[8];
    final RectF nzn = new RectF();
    final RectF nzo = new RectF();
    final RectF nzp = new RectF();
    final RectF nzq = new RectF();
    final Matrix nzr = new Matrix();
    final Matrix nzs = new Matrix();
    final Matrix nzt = new Matrix();
    final Matrix nzu = new Matrix();
    final Matrix nzv = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean nza = false;
    private boolean nzx = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.nzj = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void yg(boolean z) {
        this.eZm = z;
        this.nzx = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.nzm, f);
        this.nzk = f != 0.0f;
        this.nzx = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.nzm, 0.0f);
            this.nzk = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.nzm, 0, 8);
            this.nzk = false;
            for (int i = 0; i < 8; i++) {
                this.nzk = (fArr[i] > 0.0f) | this.nzk;
            }
        }
        this.nzx = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.nzx = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void aM(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.nzx = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void yh(boolean z) {
        if (this.nza != z) {
            this.nza = z;
            this.nzx = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dUz() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.nzt);
            this.mTransformCallback.getRootBounds(this.nzn);
        } else {
            this.nzt.reset();
            this.nzn.set(getBounds());
        }
        this.nzp.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.nzq.set(this.nzj.getBounds());
        this.nzr.setRectToRect(this.nzp, this.nzq, Matrix.ScaleToFit.FILL);
        if (this.nza) {
            if (this.nze == null) {
                this.nze = new RectF(this.nzn);
            } else {
                this.nze.set(this.nzn);
            }
            this.nze.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.nzf == null) {
                this.nzf = new Matrix();
            }
            this.nzf.setRectToRect(this.nzn, this.nze, Matrix.ScaleToFit.FILL);
        } else if (this.nzf != null) {
            this.nzf.reset();
        }
        if (!this.nzt.equals(this.nzu) || !this.nzr.equals(this.nzs) || (this.nzf != null && !this.nzf.equals(this.nzw))) {
            this.nzl = true;
            this.nzt.invert(this.nzv);
            this.mTransform.set(this.nzt);
            if (this.nza) {
                this.mTransform.postConcat(this.nzf);
            }
            this.mTransform.preConcat(this.nzr);
            this.nzu.set(this.nzt);
            this.nzs.set(this.nzr);
            if (this.nza) {
                if (this.nzw == null) {
                    this.nzw = new Matrix(this.nzf);
                } else {
                    this.nzw.set(this.nzf);
                }
            } else if (this.nzw != null) {
                this.nzw.reset();
            }
        }
        if (!this.nzn.equals(this.nzo)) {
            this.nzx = true;
            this.nzo.set(this.nzn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dUy() {
        if (this.nzx) {
            this.nzb.reset();
            this.nzn.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.eZm) {
                this.nzb.addCircle(this.nzn.centerX(), this.nzn.centerY(), Math.min(this.nzn.width(), this.nzn.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.nyY.length; i++) {
                    this.nyY[i] = (this.nzm[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.nzb.addRoundRect(this.nzn, this.nyY, Path.Direction.CW);
            }
            this.nzn.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.nza ? this.mBorderWidth : 0.0f);
            this.nzn.inset(f, f);
            if (this.eZm) {
                this.mPath.addCircle(this.nzn.centerX(), this.nzn.centerY(), Math.min(this.nzn.width(), this.nzn.height()) / 2.0f, Path.Direction.CW);
            } else if (this.nza) {
                if (this.nyZ == null) {
                    this.nyZ = new float[8];
                }
                for (int i2 = 0; i2 < this.nyY.length; i2++) {
                    this.nyZ[i2] = this.nzm[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.nzn, this.nyZ, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.nzn, this.nzm, Path.Direction.CW);
            }
            this.nzn.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.nzx = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dUx() {
        return this.eZm || this.nzk || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.nzj.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.nzj.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.nzj.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.nzj.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.nzj.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.nzj.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.nzj.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.nzj.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.nzj.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.nzj.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.nzj.draw(canvas);
    }
}
