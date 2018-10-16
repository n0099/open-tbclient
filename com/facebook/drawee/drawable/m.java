package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.n;
/* loaded from: classes2.dex */
public class m extends g {
    Matrix IG;
    n.b hZB;
    Object iaH;
    PointF iaI;
    int iaf;
    int iag;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.iaI = null;
        this.iaf = 0;
        this.iag = 0;
        this.mTempMatrix = new Matrix();
        this.hZB = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        bTn();
        return j;
    }

    public n.b bTr() {
        return this.hZB;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.hZB, bVar)) {
            this.hZB = bVar;
            this.iaH = null;
            bTn();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.iaI, pointF)) {
            if (this.iaI == null) {
                this.iaI = new PointF();
            }
            this.iaI.set(pointF);
            bTn();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        bTm();
        if (this.IG != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.IG);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        bTn();
    }

    private void bTm() {
        boolean z;
        boolean z2 = false;
        if (this.hZB instanceof n.k) {
            Object state = ((n.k) this.hZB).getState();
            z = state == null || !state.equals(this.iaH);
            this.iaH = state;
        } else {
            z = false;
        }
        if (this.iaf != getCurrent().getIntrinsicWidth() || this.iag != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            bTn();
        }
    }

    void bTn() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.iaf = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.iag = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IG = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.IG = null;
        } else if (this.hZB == n.b.iaJ) {
            current.setBounds(bounds);
            this.IG = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.hZB.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.iaI != null ? this.iaI.x : 0.5f, this.iaI != null ? this.iaI.y : 0.5f);
            this.IG = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        bTm();
        if (this.IG != null) {
            matrix.preConcat(this.IG);
        }
    }
}
