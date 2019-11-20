package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.n;
/* loaded from: classes2.dex */
public class m extends g {
    n.b kcR;
    Object kdV;
    PointF kdW;
    int kdu;
    int kdv;
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.kdW = null;
        this.kdu = 0;
        this.kdv = 0;
        this.mTempMatrix = new Matrix();
        this.kcR = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable i(Drawable drawable) {
        Drawable i = super.i(drawable);
        cEv();
        return i;
    }

    public n.b cEz() {
        return this.kcR;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.kcR, bVar)) {
            this.kcR = bVar;
            this.kdV = null;
            cEv();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.kdW, pointF)) {
            if (this.kdW == null) {
                this.kdW = new PointF();
            }
            this.kdW.set(pointF);
            cEv();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cEu();
        if (this.mDrawMatrix != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        cEv();
    }

    private void cEu() {
        boolean z;
        boolean z2 = false;
        if (this.kcR instanceof n.k) {
            Object state = ((n.k) this.kcR).getState();
            z = state == null || !state.equals(this.kdV);
            this.kdV = state;
        } else {
            z = false;
        }
        if (this.kdu != getCurrent().getIntrinsicWidth() || this.kdv != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cEv();
        }
    }

    void cEv() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.kdu = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.kdv = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.kcR == n.b.kdX) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.kcR.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.kdW != null ? this.kdW.x : 0.5f, this.kdW != null ? this.kdW.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void d(Matrix matrix) {
        e(matrix);
        cEu();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
