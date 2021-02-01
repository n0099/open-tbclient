package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.p;
/* loaded from: classes15.dex */
public class o extends g {
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;
    int pCI;
    int pCJ;
    p.b pCc;
    Object pDo;
    PointF pDp;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pDp = null;
        this.pCI = 0;
        this.pCJ = 0;
        this.mTempMatrix = new Matrix();
        this.pCc = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable x(Drawable drawable) {
        Drawable x = super.x(drawable);
        eur();
        return x;
    }

    public p.b euv() {
        return this.pCc;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.pCc, bVar)) {
            this.pCc = bVar;
            this.pDo = null;
            eur();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.pDp, pointF)) {
            if (this.pDp == null) {
                this.pDp = new PointF();
            }
            this.pDp.set(pointF);
            eur();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        euq();
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
        eur();
    }

    private void euq() {
        boolean z;
        boolean z2 = false;
        if (this.pCc instanceof p.l) {
            Object state = ((p.l) this.pCc).getState();
            z = state == null || !state.equals(this.pDo);
            this.pDo = state;
        } else {
            z = false;
        }
        if (this.pCI != getCurrent().getIntrinsicWidth() || this.pCJ != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            eur();
        }
    }

    void eur() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.pCI = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.pCJ = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.pCc == p.b.pDq) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.pCc.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.pDp != null ? this.pDp.x : 0.5f, this.pDp != null ? this.pDp.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        g(matrix);
        euq();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
