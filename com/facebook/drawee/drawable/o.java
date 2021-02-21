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
    p.b pCC;
    Object pDO;
    PointF pDP;
    int pDi;
    int pDj;

    public o(Drawable drawable, p.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pDP = null;
        this.pDi = 0;
        this.pDj = 0;
        this.mTempMatrix = new Matrix();
        this.pCC = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable x(Drawable drawable) {
        Drawable x = super.x(drawable);
        euz();
        return x;
    }

    public p.b euD() {
        return this.pCC;
    }

    public void a(p.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.pCC, bVar)) {
            this.pCC = bVar;
            this.pDO = null;
            euz();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.pDP, pointF)) {
            if (this.pDP == null) {
                this.pDP = new PointF();
            }
            this.pDP.set(pointF);
            euz();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        euy();
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
        euz();
    }

    private void euy() {
        boolean z;
        boolean z2 = false;
        if (this.pCC instanceof p.l) {
            Object state = ((p.l) this.pCC).getState();
            z = state == null || !state.equals(this.pDO);
            this.pDO = state;
        } else {
            z = false;
        }
        if (this.pDi != getCurrent().getIntrinsicWidth() || this.pDj != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            euz();
        }
    }

    void euz() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.pDi = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.pDj = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.pCC == p.b.pDQ) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.pCC.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.pDP != null ? this.pDP.x : 0.5f, this.pDP != null ? this.pDP.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.r
    public void f(Matrix matrix) {
        g(matrix);
        euy();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
