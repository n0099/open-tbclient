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
    Matrix lOA;
    @Nullable
    float[] lOe;
    @Nullable
    RectF lOi;
    @Nullable
    Matrix lOj;
    private final Drawable lOn;
    @Nullable
    private r mTransformCallback;
    protected boolean dIe = false;
    protected boolean lOo = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean lOp = true;
    protected int mBorderColor = 0;
    protected final Path cfk = new Path();
    private final float[] lOq = new float[8];
    final float[] lOd = new float[8];
    final RectF lOr = new RectF();
    final RectF lOs = new RectF();
    final RectF lOt = new RectF();
    final RectF lOu = new RectF();
    final Matrix lOv = new Matrix();
    final Matrix lOw = new Matrix();
    final Matrix lOx = new Matrix();
    final Matrix lOy = new Matrix();
    final Matrix lOz = new Matrix();
    final Matrix mTransform = new Matrix();
    private float mPadding = 0.0f;
    private boolean lOf = false;
    private boolean lOB = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.lOn = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void vp(boolean z) {
        this.dIe = z;
        this.lOB = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.lOq, f);
        this.lOo = f != 0.0f;
        this.lOB = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.lOq, 0.0f);
            this.lOo = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.lOq, 0, 8);
            this.lOo = false;
            for (int i = 0; i < 8; i++) {
                this.lOo = (fArr[i] > 0.0f) | this.lOo;
            }
        }
        this.lOB = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.lOB = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bm(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.lOB = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void vq(boolean z) {
        if (this.lOf != z) {
            this.lOf = z;
            this.lOB = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dna() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.lOx);
            this.mTransformCallback.getRootBounds(this.lOr);
        } else {
            this.lOx.reset();
            this.lOr.set(getBounds());
        }
        this.lOt.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.lOu.set(this.lOn.getBounds());
        this.lOv.setRectToRect(this.lOt, this.lOu, Matrix.ScaleToFit.FILL);
        if (this.lOf) {
            if (this.lOi == null) {
                this.lOi = new RectF(this.lOr);
            } else {
                this.lOi.set(this.lOr);
            }
            this.lOi.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.lOj == null) {
                this.lOj = new Matrix();
            }
            this.lOj.setRectToRect(this.lOr, this.lOi, Matrix.ScaleToFit.FILL);
        } else if (this.lOj != null) {
            this.lOj.reset();
        }
        if (!this.lOx.equals(this.lOy) || !this.lOv.equals(this.lOw) || (this.lOj != null && !this.lOj.equals(this.lOA))) {
            this.lOp = true;
            this.lOx.invert(this.lOz);
            this.mTransform.set(this.lOx);
            if (this.lOf) {
                this.mTransform.postConcat(this.lOj);
            }
            this.mTransform.preConcat(this.lOv);
            this.lOy.set(this.lOx);
            this.lOw.set(this.lOv);
            if (this.lOf) {
                if (this.lOA == null) {
                    this.lOA = new Matrix(this.lOj);
                } else {
                    this.lOA.set(this.lOj);
                }
            } else if (this.lOA != null) {
                this.lOA.reset();
            }
        }
        if (!this.lOr.equals(this.lOs)) {
            this.lOB = true;
            this.lOs.set(this.lOr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dmZ() {
        if (this.lOB) {
            this.cfk.reset();
            this.lOr.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.dIe) {
                this.cfk.addCircle(this.lOr.centerX(), this.lOr.centerY(), Math.min(this.lOr.width(), this.lOr.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.lOd.length; i++) {
                    this.lOd[i] = (this.lOq[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.cfk.addRoundRect(this.lOr, this.lOd, Path.Direction.CW);
            }
            this.lOr.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.lOf ? this.mBorderWidth : 0.0f);
            this.lOr.inset(f, f);
            if (this.dIe) {
                this.mPath.addCircle(this.lOr.centerX(), this.lOr.centerY(), Math.min(this.lOr.width(), this.lOr.height()) / 2.0f, Path.Direction.CW);
            } else if (this.lOf) {
                if (this.lOe == null) {
                    this.lOe = new float[8];
                }
                for (int i2 = 0; i2 < this.lOd.length; i2++) {
                    this.lOe[i2] = this.lOq[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.lOr, this.lOe, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.lOr, this.lOq, Path.Direction.CW);
            }
            this.lOr.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.lOB = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dmY() {
        return this.dIe || this.lOo || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.lOn.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lOn.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lOn.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.lOn.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.lOn.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.lOn.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.lOn.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.lOn.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.lOn.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.lOn.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.lOn.draw(canvas);
    }
}
