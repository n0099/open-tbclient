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
    private r pCM;
    @Nullable
    Matrix pDL;
    @Nullable
    float[] pDp;
    @Nullable
    RectF pDt;
    @Nullable
    Matrix pDu;
    private final Drawable pDy;
    protected boolean fOk = false;
    protected boolean pDz = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean pDA = true;
    protected int mBorderColor = 0;
    protected final Path eWn = new Path();
    private final float[] pDB = new float[8];
    final float[] pDo = new float[8];
    final RectF pDC = new RectF();
    final RectF pDD = new RectF();
    final RectF pDE = new RectF();
    final RectF pDF = new RectF();
    final Matrix pDG = new Matrix();
    final Matrix pDH = new Matrix();
    final Matrix pDI = new Matrix();
    final Matrix pDJ = new Matrix();
    final Matrix pDK = new Matrix();
    final Matrix pDM = new Matrix();
    private float mPadding = 0.0f;
    private boolean pDq = false;
    private boolean pDN = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.pDy = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void Bn(boolean z) {
        this.fOk = z;
        this.pDN = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.pDB, f);
        this.pDz = f != 0.0f;
        this.pDN = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.pDB, 0.0f);
            this.pDz = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.pDB, 0, 8);
            this.pDz = false;
            for (int i = 0; i < 8; i++) {
                this.pDz = (fArr[i] > 0.0f) | this.pDz;
            }
        }
        this.pDN = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.pDN = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bI(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.pDN = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void Bo(boolean z) {
        if (this.pDq != z) {
            this.pDq = z;
            this.pDN = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void a(@Nullable r rVar) {
        this.pCM = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void euC() {
        if (this.pCM != null) {
            this.pCM.f(this.pDI);
            this.pCM.b(this.pDC);
        } else {
            this.pDI.reset();
            this.pDC.set(getBounds());
        }
        this.pDE.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.pDF.set(this.pDy.getBounds());
        this.pDG.setRectToRect(this.pDE, this.pDF, Matrix.ScaleToFit.FILL);
        if (this.pDq) {
            if (this.pDt == null) {
                this.pDt = new RectF(this.pDC);
            } else {
                this.pDt.set(this.pDC);
            }
            this.pDt.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.pDu == null) {
                this.pDu = new Matrix();
            }
            this.pDu.setRectToRect(this.pDC, this.pDt, Matrix.ScaleToFit.FILL);
        } else if (this.pDu != null) {
            this.pDu.reset();
        }
        if (!this.pDI.equals(this.pDJ) || !this.pDG.equals(this.pDH) || (this.pDu != null && !this.pDu.equals(this.pDL))) {
            this.pDA = true;
            this.pDI.invert(this.pDK);
            this.pDM.set(this.pDI);
            if (this.pDq) {
                this.pDM.postConcat(this.pDu);
            }
            this.pDM.preConcat(this.pDG);
            this.pDJ.set(this.pDI);
            this.pDH.set(this.pDG);
            if (this.pDq) {
                if (this.pDL == null) {
                    this.pDL = new Matrix(this.pDu);
                } else {
                    this.pDL.set(this.pDu);
                }
            } else if (this.pDL != null) {
                this.pDL.reset();
            }
        }
        if (!this.pDC.equals(this.pDD)) {
            this.pDN = true;
            this.pDD.set(this.pDC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void euB() {
        if (this.pDN) {
            this.eWn.reset();
            this.pDC.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fOk) {
                this.eWn.addCircle(this.pDC.centerX(), this.pDC.centerY(), Math.min(this.pDC.width(), this.pDC.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.pDo.length; i++) {
                    this.pDo[i] = (this.pDB[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.eWn.addRoundRect(this.pDC, this.pDo, Path.Direction.CW);
            }
            this.pDC.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.pDq ? this.mBorderWidth : 0.0f);
            this.pDC.inset(f, f);
            if (this.fOk) {
                this.mPath.addCircle(this.pDC.centerX(), this.pDC.centerY(), Math.min(this.pDC.width(), this.pDC.height()) / 2.0f, Path.Direction.CW);
            } else if (this.pDq) {
                if (this.pDp == null) {
                    this.pDp = new float[8];
                }
                for (int i2 = 0; i2 < this.pDo.length; i2++) {
                    this.pDp[i2] = this.pDB[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.pDC, this.pDp, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.pDC, this.pDB, Path.Direction.CW);
            }
            this.pDC.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.pDN = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean euA() {
        return this.fOk || this.pDz || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.pDy.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pDy.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pDy.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.pDy.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.pDy.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.pDy.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.pDy.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.pDy.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.pDy.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pDy.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.pDy.draw(canvas);
    }
}
