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
    private r pER;
    private final Drawable pFD;
    @Nullable
    Matrix pFQ;
    @Nullable
    float[] pFu;
    @Nullable
    RectF pFy;
    @Nullable
    Matrix pFz;
    protected boolean fPK = false;
    protected boolean pFE = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean pFF = true;
    protected int mBorderColor = 0;
    protected final Path eXM = new Path();
    private final float[] pFG = new float[8];
    final float[] pFt = new float[8];
    final RectF pFH = new RectF();
    final RectF pFI = new RectF();
    final RectF pFJ = new RectF();
    final RectF pFK = new RectF();
    final Matrix pFL = new Matrix();
    final Matrix pFM = new Matrix();
    final Matrix pFN = new Matrix();
    final Matrix pFO = new Matrix();
    final Matrix pFP = new Matrix();
    final Matrix pFR = new Matrix();
    private float mPadding = 0.0f;
    private boolean pFv = false;
    private boolean pFS = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.pFD = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void Bl(boolean z) {
        this.fPK = z;
        this.pFS = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.pFG, f);
        this.pFE = f != 0.0f;
        this.pFS = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.pFG, 0.0f);
            this.pFE = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.pFG, 0, 8);
            this.pFE = false;
            for (int i = 0; i < 8; i++) {
                this.pFE = (fArr[i] > 0.0f) | this.pFE;
            }
        }
        this.pFS = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.pFS = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bM(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.pFS = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void Bm(boolean z) {
        if (this.pFv != z) {
            this.pFv = z;
            this.pFS = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void a(@Nullable r rVar) {
        this.pER = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void euL() {
        if (this.pER != null) {
            this.pER.f(this.pFN);
            this.pER.b(this.pFH);
        } else {
            this.pFN.reset();
            this.pFH.set(getBounds());
        }
        this.pFJ.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.pFK.set(this.pFD.getBounds());
        this.pFL.setRectToRect(this.pFJ, this.pFK, Matrix.ScaleToFit.FILL);
        if (this.pFv) {
            if (this.pFy == null) {
                this.pFy = new RectF(this.pFH);
            } else {
                this.pFy.set(this.pFH);
            }
            this.pFy.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.pFz == null) {
                this.pFz = new Matrix();
            }
            this.pFz.setRectToRect(this.pFH, this.pFy, Matrix.ScaleToFit.FILL);
        } else if (this.pFz != null) {
            this.pFz.reset();
        }
        if (!this.pFN.equals(this.pFO) || !this.pFL.equals(this.pFM) || (this.pFz != null && !this.pFz.equals(this.pFQ))) {
            this.pFF = true;
            this.pFN.invert(this.pFP);
            this.pFR.set(this.pFN);
            if (this.pFv) {
                this.pFR.postConcat(this.pFz);
            }
            this.pFR.preConcat(this.pFL);
            this.pFO.set(this.pFN);
            this.pFM.set(this.pFL);
            if (this.pFv) {
                if (this.pFQ == null) {
                    this.pFQ = new Matrix(this.pFz);
                } else {
                    this.pFQ.set(this.pFz);
                }
            } else if (this.pFQ != null) {
                this.pFQ.reset();
            }
        }
        if (!this.pFH.equals(this.pFI)) {
            this.pFS = true;
            this.pFI.set(this.pFH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void euK() {
        if (this.pFS) {
            this.eXM.reset();
            this.pFH.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fPK) {
                this.eXM.addCircle(this.pFH.centerX(), this.pFH.centerY(), Math.min(this.pFH.width(), this.pFH.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.pFt.length; i++) {
                    this.pFt[i] = (this.pFG[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.eXM.addRoundRect(this.pFH, this.pFt, Path.Direction.CW);
            }
            this.pFH.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.pFv ? this.mBorderWidth : 0.0f);
            this.pFH.inset(f, f);
            if (this.fPK) {
                this.mPath.addCircle(this.pFH.centerX(), this.pFH.centerY(), Math.min(this.pFH.width(), this.pFH.height()) / 2.0f, Path.Direction.CW);
            } else if (this.pFv) {
                if (this.pFu == null) {
                    this.pFu = new float[8];
                }
                for (int i2 = 0; i2 < this.pFt.length; i2++) {
                    this.pFu[i2] = this.pFG[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.pFH, this.pFu, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.pFH, this.pFG, Path.Direction.CW);
            }
            this.pFH.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.pFS = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean euJ() {
        return this.fPK || this.pFE || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.pFD.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pFD.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pFD.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.pFD.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.pFD.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.pFD.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.pFD.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.pFD.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.pFD.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pFD.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.pFD.draw(canvas);
    }
}
