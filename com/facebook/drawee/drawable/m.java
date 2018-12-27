package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.n;
/* loaded from: classes2.dex */
public class m extends g {
    Matrix IK;
    n.b ilJ;
    Object imQ;
    PointF imR;
    int imo;
    int imp;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.imR = null;
        this.imo = 0;
        this.imp = 0;
        this.mTempMatrix = new Matrix();
        this.ilJ = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        bVE();
        return j;
    }

    public n.b bVI() {
        return this.ilJ;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.ilJ, bVar)) {
            this.ilJ = bVar;
            this.imQ = null;
            bVE();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.imR, pointF)) {
            if (this.imR == null) {
                this.imR = new PointF();
            }
            this.imR.set(pointF);
            bVE();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        bVD();
        if (this.IK != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.IK);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        bVE();
    }

    private void bVD() {
        boolean z;
        boolean z2 = false;
        if (this.ilJ instanceof n.k) {
            Object state = ((n.k) this.ilJ).getState();
            z = state == null || !state.equals(this.imQ);
            this.imQ = state;
        } else {
            z = false;
        }
        if (this.imo != getCurrent().getIntrinsicWidth() || this.imp != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            bVE();
        }
    }

    void bVE() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.imo = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.imp = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IK = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.IK = null;
        } else if (this.ilJ == n.b.imS) {
            current.setBounds(bounds);
            this.IK = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.ilJ.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.imR != null ? this.imR.x : 0.5f, this.imR != null ? this.imR.y : 0.5f);
            this.IK = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        bVD();
        if (this.IK != null) {
            matrix.preConcat(this.IK);
        }
    }
}
