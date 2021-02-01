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
    float[] pCP;
    @Nullable
    RectF pCT;
    @Nullable
    Matrix pCU;
    private final Drawable pCY;
    @Nullable
    private r pCm;
    @Nullable
    Matrix pDl;
    protected boolean fOk = false;
    protected boolean pCZ = false;
    protected float mBorderWidth = 0.0f;
    protected final Path mPath = new Path();
    protected boolean pDa = true;
    protected int mBorderColor = 0;
    protected final Path eWn = new Path();
    private final float[] pDb = new float[8];
    final float[] pCO = new float[8];
    final RectF pDc = new RectF();
    final RectF pDd = new RectF();
    final RectF pDe = new RectF();
    final RectF pDf = new RectF();
    final Matrix pDg = new Matrix();
    final Matrix pDh = new Matrix();
    final Matrix pDi = new Matrix();
    final Matrix pDj = new Matrix();
    final Matrix pDk = new Matrix();
    final Matrix pDm = new Matrix();
    private float mPadding = 0.0f;
    private boolean pCQ = false;
    private boolean pDn = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Drawable drawable) {
        this.pCY = drawable;
    }

    @Override // com.facebook.drawee.drawable.j
    public void Bn(boolean z) {
        this.fOk = z;
        this.pDn = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void setRadius(float f) {
        com.facebook.common.internal.g.checkState(f >= 0.0f);
        Arrays.fill(this.pDb, f);
        this.pCZ = f != 0.0f;
        this.pDn = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void z(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.pDb, 0.0f);
            this.pCZ = false;
        } else {
            com.facebook.common.internal.g.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.pDb, 0, 8);
            this.pCZ = false;
            for (int i = 0; i < 8; i++) {
                this.pCZ = (fArr[i] > 0.0f) | this.pCZ;
            }
        }
        this.pDn = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.j
    public void n(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.pDn = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void bI(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.pDn = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.j
    public void Bo(boolean z) {
        if (this.pCQ != z) {
            this.pCQ = z;
            this.pDn = true;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.q
    public void a(@Nullable r rVar) {
        this.pCm = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void euu() {
        if (this.pCm != null) {
            this.pCm.f(this.pDi);
            this.pCm.b(this.pDc);
        } else {
            this.pDi.reset();
            this.pDc.set(getBounds());
        }
        this.pDe.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.pDf.set(this.pCY.getBounds());
        this.pDg.setRectToRect(this.pDe, this.pDf, Matrix.ScaleToFit.FILL);
        if (this.pCQ) {
            if (this.pCT == null) {
                this.pCT = new RectF(this.pDc);
            } else {
                this.pCT.set(this.pDc);
            }
            this.pCT.inset(this.mBorderWidth, this.mBorderWidth);
            if (this.pCU == null) {
                this.pCU = new Matrix();
            }
            this.pCU.setRectToRect(this.pDc, this.pCT, Matrix.ScaleToFit.FILL);
        } else if (this.pCU != null) {
            this.pCU.reset();
        }
        if (!this.pDi.equals(this.pDj) || !this.pDg.equals(this.pDh) || (this.pCU != null && !this.pCU.equals(this.pDl))) {
            this.pDa = true;
            this.pDi.invert(this.pDk);
            this.pDm.set(this.pDi);
            if (this.pCQ) {
                this.pDm.postConcat(this.pCU);
            }
            this.pDm.preConcat(this.pDg);
            this.pDj.set(this.pDi);
            this.pDh.set(this.pDg);
            if (this.pCQ) {
                if (this.pDl == null) {
                    this.pDl = new Matrix(this.pCU);
                } else {
                    this.pDl.set(this.pCU);
                }
            } else if (this.pDl != null) {
                this.pDl.reset();
            }
        }
        if (!this.pDc.equals(this.pDd)) {
            this.pDn = true;
            this.pDd.set(this.pDc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eut() {
        if (this.pDn) {
            this.eWn.reset();
            this.pDc.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.fOk) {
                this.eWn.addCircle(this.pDc.centerX(), this.pDc.centerY(), Math.min(this.pDc.width(), this.pDc.height()) / 2.0f, Path.Direction.CW);
            } else {
                for (int i = 0; i < this.pCO.length; i++) {
                    this.pCO[i] = (this.pDb[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                }
                this.eWn.addRoundRect(this.pDc, this.pCO, Path.Direction.CW);
            }
            this.pDc.inset((-this.mBorderWidth) / 2.0f, (-this.mBorderWidth) / 2.0f);
            this.mPath.reset();
            float f = this.mPadding + (this.pCQ ? this.mBorderWidth : 0.0f);
            this.pDc.inset(f, f);
            if (this.fOk) {
                this.mPath.addCircle(this.pDc.centerX(), this.pDc.centerY(), Math.min(this.pDc.width(), this.pDc.height()) / 2.0f, Path.Direction.CW);
            } else if (this.pCQ) {
                if (this.pCP == null) {
                    this.pCP = new float[8];
                }
                for (int i2 = 0; i2 < this.pCO.length; i2++) {
                    this.pCP[i2] = this.pDb[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.pDc, this.pCP, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.pDc, this.pDb, Path.Direction.CW);
            }
            this.pDc.inset(-f, -f);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.pDn = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eus() {
        return this.fOk || this.pCZ || this.mBorderWidth > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.pCY.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.pCY.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.pCY.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.pCY.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, @NonNull PorterDuff.Mode mode) {
        this.pCY.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.pCY.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    @RequiresApi(api = 21)
    public ColorFilter getColorFilter() {
        return this.pCY.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.pCY.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(api = 19)
    public int getAlpha() {
        return this.pCY.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pCY.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.pCY.draw(canvas);
    }
}
