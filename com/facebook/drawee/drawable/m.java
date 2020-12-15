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
    float[] pfS;
    @Nullable
    RectF pfW;
    @Nullable
    Matrix pfX;
    private final Drawable pgb;
    @Nullable
    Matrix pgo;
    protected boolean fHb = false;
    protected boolean pgc = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean pgd = true;
    protected int mBorderColor = 0;
    protected final Path eOJ = new Path();
    private final float[] pge = new float[8];
    final float[] pfR = new float[8];
    final RectF pgf = new RectF();
    final RectF pgg = new RectF();
    final RectF pgh = new RectF();
    final RectF pgi = new RectF();
    final Matrix pgj = new Matrix();
    final Matrix pgk = new Matrix();
    final Matrix pgl = new Matrix();
    final Matrix pgm = new Matrix();
    final Matrix pgn = new Matrix();
    final Matrix pgp = new Matrix();
    private float mPadding = 0.0f;
    private boolean pfT = false;
    private boolean pgq = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.pgb = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void AQ(boolean z) {
        this.fHb = z;
        this.pgq = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.pge, f);
        this.pgc = f != 0.0f;
        this.pgq = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void A(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.pge, 0.0f);
            this.pgc = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.pge, 0, 8);
            this.pgc = false;
            for (int i = 0; i < 8; i++) {
                this.pgc = (fArr[i] > 0.0f) | this.pgc;
            }
        }
        this.pgq = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void o(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.pgq = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bt(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.pgq = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void AR(boolean z) {
        if (this.pfT != z) {
            this.pfT = z;
            this.pgq = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void setTransformCallback(@Nullable r rVar) {
        this.mTransformCallback = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void erL() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.pgl);
            this.mTransformCallback.getRootBounds(this.pgf);
        } else {
            this.pgl.reset();
            this.pgf.set(getBounds());
        }
        this.pgh.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.pgi.set(this.pgb.getBounds());
        this.pgj.setRectToRect(this.pgh, this.pgi, Matrix.ScaleToFit.FILL);
        if (this.pfT) {
            if (this.pfW == null) {
                this.pfW = new RectF(this.pgf);
            } else {
                this.pfW.set(this.pgf);
            }
            this.pfW.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.pfX == null) {
                this.pfX = new Matrix();
            }
            this.pfX.setRectToRect(this.pgf, this.pfW, Matrix.ScaleToFit.FILL);
        } else if (this.pfX != null) {
            this.pfX.reset();
        }
        if (!this.pgl.equals(this.pgm) || !this.pgj.equals(this.pgk) || (this.pfX != null && !this.pfX.equals(this.pgo))) {
            this.pgd = true;
            this.pgl.invert(this.pgn);
            this.pgp.set(this.pgl);
            if (this.pfT) {
                this.pgp.postConcat(this.pfX);
            }
            this.pgp.preConcat(this.pgj);
            this.pgm.set(this.pgl);
            this.pgk.set(this.pgj);
            if (this.pfT) {
                if (this.pgo == null) {
                    this.pgo = new Matrix(this.pfX);
                } else {
                    this.pgo.set(this.pfX);
                }
            } else if (this.pgo != null) {
                this.pgo.reset();
            }
        }
        if (!this.pgf.equals(this.pgg)) {
            this.pgq = true;
            this.pgg.set(this.pgf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void erK() {
        if (this.pgq) {
            this.eOJ.reset();
            this.pgf.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fHb) {
                this.eOJ.addCircle(this.pgf.centerX(), this.pgf.centerY(), Math.min(this.pgf.width(), this.pgf.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.pfR.length; i++) {
                    this.pfR[i] = (this.pge[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.eOJ.addRoundRect(this.pgf, this.pfR, Path.Direction.CW);
            }
            this.pgf.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.pfT ? this.mBorderWidth : 0.0f);
            this.pgf.inset(f, f);
            if (this.fHb) {
                this.mPath.addCircle(this.pgf.centerX(), this.pgf.centerY(), Math.min(this.pgf.width(), this.pgf.height()) / 2.0f, Path.Direction.CW);
            } else if (this.pfT) {
                if (this.pfS == null) {
                    this.pfS = new float[8];
                }
                for (int i2 = 0; i2 < this.pfR.length; i2++) {
                    this.pfS[i2] = this.pge[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.pgf, this.pfS, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.pgf, this.pge, Path.Direction.CW);
            }
            this.pgf.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.pgq = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean erJ() {
        return this.fHb || this.pgc || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.pgb.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pgb.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pgb.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.pgb.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.pgb.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.pgb.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 21)
    @Nullable
    public ColorFilter getColorFilter() {
        return this.pgb.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.pgb.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.pgb.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pgb.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.pgb.draw(canvas);
    }
}
