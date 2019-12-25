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
    float[] lIb;
    @Nullable
    RectF lIf;
    @Nullable
    Matrix lIg;
    private final Drawable lIk;
    @Nullable
    Matrix lIx;
    @Nullable
    private r mTransformCallback;
    protected boolean dDm = false;
    protected boolean lIl = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean lIm = true;
    protected int mBorderColor = 0;
    protected final Path caF = new Path();
    private final float[] lIn = new float[8];
    final float[] lIa = new float[8];
    final RectF lIo = new RectF();
    final RectF lIp = new RectF();
    final RectF lIq = new RectF();
    final RectF lIr = new RectF();
    final Matrix lIs = new Matrix();
    final Matrix lIt = new Matrix();
    final Matrix lIu = new Matrix();
    final Matrix lIv = new Matrix();
    final Matrix lIw = new Matrix();
    final Matrix lIy = new Matrix();
    private float mPadding = 0.0f;
    private boolean lIc = false;
    private boolean lIz = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.lIk = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void uS(boolean z) {
        this.dDm = z;
        this.lIz = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.lIn, f);
        this.lIl = f != 0.0f;
        this.lIz = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void k(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.lIn, 0.0f);
            this.lIl = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.lIn, 0, 8);
            this.lIl = false;
            for (int i = 0; i < 8; i++) {
                this.lIl = (fArr[i] > 0.0f) | this.lIl;
            }
        }
        this.lIz = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void p(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.lIz = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bo(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.lIz = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void uT(boolean z) {
        if (this.lIc != z) {
            this.lIc = z;
            this.lIz = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dkk() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.lIu);
            this.mTransformCallback.getRootBounds(this.lIo);
        } else {
            this.lIu.reset();
            this.lIo.set(getBounds());
        }
        this.lIq.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.lIr.set(this.lIk.getBounds());
        this.lIs.setRectToRect(this.lIq, this.lIr, Matrix.ScaleToFit.FILL);
        if (this.lIc) {
            if (this.lIf == null) {
                this.lIf = new RectF(this.lIo);
            } else {
                this.lIf.set(this.lIo);
            }
            this.lIf.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.lIg == null) {
                this.lIg = new Matrix();
            }
            this.lIg.setRectToRect(this.lIo, this.lIf, Matrix.ScaleToFit.FILL);
        } else if (this.lIg != null) {
            this.lIg.reset();
        }
        if (!this.lIu.equals(this.lIv) || !this.lIs.equals(this.lIt) || (this.lIg != null && !this.lIg.equals(this.lIx))) {
            this.lIm = true;
            this.lIu.invert(this.lIw);
            this.lIy.set(this.lIu);
            if (this.lIc) {
                this.lIy.postConcat(this.lIg);
            }
            this.lIy.preConcat(this.lIs);
            this.lIv.set(this.lIu);
            this.lIt.set(this.lIs);
            if (this.lIc) {
                if (this.lIx == null) {
                    this.lIx = new Matrix(this.lIg);
                } else {
                    this.lIx.set(this.lIg);
                }
            } else if (this.lIx != null) {
                this.lIx.reset();
            }
        }
        if (!this.lIo.equals(this.lIp)) {
            this.lIz = true;
            this.lIp.set(this.lIo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dkj() {
        if (this.lIz) {
            this.caF.reset();
            this.lIo.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.dDm) {
                this.caF.addCircle(this.lIo.centerX(), this.lIo.centerY(), Math.min(this.lIo.width(), this.lIo.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.lIa.length; i++) {
                    this.lIa[i] = (this.lIn[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.caF.addRoundRect(this.lIo, this.lIa, Path.Direction.CW);
            }
            this.lIo.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.lIc ? this.mBorderWidth : 0.0f);
            this.lIo.inset(f, f);
            if (this.dDm) {
                this.mPath.addCircle(this.lIo.centerX(), this.lIo.centerY(), Math.min(this.lIo.width(), this.lIo.height()) / 2.0f, Path.Direction.CW);
            } else if (this.lIc) {
                if (this.lIb == null) {
                    this.lIb = new float[8];
                }
                for (int i2 = 0; i2 < this.lIa.length; i2++) {
                    this.lIb[i2] = this.lIn[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.lIo, this.lIb, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.lIo, this.lIn, Path.Direction.CW);
            }
            this.lIo.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.lIz = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dki() {
        return this.dDm || this.lIl || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.lIk.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lIk.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.lIk.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.lIk.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.lIk.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.lIk.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.lIk.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.lIk.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.lIk.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.lIk.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.lIk.draw(canvas);
    }
}
