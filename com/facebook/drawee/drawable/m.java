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
/* loaded from: classes8.dex */
public abstract class m extends Drawable implements j, q {
    @Nullable
    private r mTransformCallback;
    @Nullable
    float[] pfQ;
    @Nullable
    RectF pfU;
    @Nullable
    Matrix pfV;
    private final Drawable pfZ;
    @Nullable
    Matrix pgm;
    protected boolean fHb = false;
    protected boolean pga = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean pgb = true;
    protected int mBorderColor = 0;
    protected final Path eOJ = new Path();
    private final float[] pgc = new float[8];
    final float[] pfP = new float[8];
    final RectF pgd = new RectF();
    final RectF pge = new RectF();
    final RectF pgf = new RectF();
    final RectF pgg = new RectF();
    final Matrix pgh = new Matrix();
    final Matrix pgi = new Matrix();
    final Matrix pgj = new Matrix();
    final Matrix pgk = new Matrix();
    final Matrix pgl = new Matrix();
    final Matrix pgn = new Matrix();
    private float mPadding = 0.0f;
    private boolean pfR = false;
    private boolean pgo = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.pfZ = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void AQ(boolean z) {
        this.fHb = z;
        this.pgo = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.pgc, f);
        this.pga = f != 0.0f;
        this.pgo = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void A(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.pgc, 0.0f);
            this.pga = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.pgc, 0, 8);
            this.pga = false;
            for (int i = 0; i < 8; i++) {
                this.pga = (fArr[i] > 0.0f) | this.pga;
            }
        }
        this.pgo = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.pgo = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bt(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.pgo = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void AR(boolean z) {
        if (this.pfR != z) {
            this.pfR = z;
            this.pgo = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void erK() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.pgj);
            this.mTransformCallback.getRootBounds(this.pgd);
        } else {
            this.pgj.reset();
            this.pgd.set(getBounds());
        }
        this.pgf.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.pgg.set(this.pfZ.getBounds());
        this.pgh.setRectToRect(this.pgf, this.pgg, Matrix.ScaleToFit.FILL);
        if (this.pfR) {
            if (this.pfU == null) {
                this.pfU = new RectF(this.pgd);
            } else {
                this.pfU.set(this.pgd);
            }
            this.pfU.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.pfV == null) {
                this.pfV = new Matrix();
            }
            this.pfV.setRectToRect(this.pgd, this.pfU, Matrix.ScaleToFit.FILL);
        } else if (this.pfV != null) {
            this.pfV.reset();
        }
        if (!this.pgj.equals(this.pgk) || !this.pgh.equals(this.pgi) || (this.pfV != null && !this.pfV.equals(this.pgm))) {
            this.pgb = true;
            this.pgj.invert(this.pgl);
            this.pgn.set(this.pgj);
            if (this.pfR) {
                this.pgn.postConcat(this.pfV);
            }
            this.pgn.preConcat(this.pgh);
            this.pgk.set(this.pgj);
            this.pgi.set(this.pgh);
            if (this.pfR) {
                if (this.pgm == null) {
                    this.pgm = new Matrix(this.pfV);
                } else {
                    this.pgm.set(this.pfV);
                }
            } else if (this.pgm != null) {
                this.pgm.reset();
            }
        }
        if (!this.pgd.equals(this.pge)) {
            this.pgo = true;
            this.pge.set(this.pgd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void erJ() {
        if (this.pgo) {
            this.eOJ.reset();
            this.pgd.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fHb) {
                this.eOJ.addCircle(this.pgd.centerX(), this.pgd.centerY(), Math.min(this.pgd.width(), this.pgd.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.pfP.length; i++) {
                    this.pfP[i] = (this.pgc[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.eOJ.addRoundRect(this.pgd, this.pfP, Path.Direction.CW);
            }
            this.pgd.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.pfR ? this.mBorderWidth : 0.0f);
            this.pgd.inset(f, f);
            if (this.fHb) {
                this.mPath.addCircle(this.pgd.centerX(), this.pgd.centerY(), Math.min(this.pgd.width(), this.pgd.height()) / 2.0f, Path.Direction.CW);
            } else if (this.pfR) {
                if (this.pfQ == null) {
                    this.pfQ = new float[8];
                }
                for (int i2 = 0; i2 < this.pfP.length; i2++) {
                    this.pfQ[i2] = this.pgc[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.pgd, this.pfQ, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.pgd, this.pgc, Path.Direction.CW);
            }
            this.pgd.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.pgo = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean erI() {
        return this.fHb || this.pga || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.pfZ.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pfZ.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pfZ.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.pfZ.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.pfZ.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.pfZ.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.pfZ.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.pfZ.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.pfZ.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pfZ.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.pfZ.draw(canvas);
    }
}
