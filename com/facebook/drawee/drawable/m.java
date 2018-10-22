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
    n.b hZC;
    Object iaI;
    PointF iaJ;
    int iag;
    int iah;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.iaJ = null;
        this.iag = 0;
        this.iah = 0;
        this.mTempMatrix = new Matrix();
        this.hZC = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        bTn();
        return j;
    }

    public n.b bTr() {
        return this.hZC;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.hZC, bVar)) {
            this.hZC = bVar;
            this.iaI = null;
            bTn();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.iaJ, pointF)) {
            if (this.iaJ == null) {
                this.iaJ = new PointF();
            }
            this.iaJ.set(pointF);
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
        if (this.hZC instanceof n.k) {
            Object state = ((n.k) this.hZC).getState();
            z = state == null || !state.equals(this.iaI);
            this.iaI = state;
        } else {
            z = false;
        }
        if (this.iag != getCurrent().getIntrinsicWidth() || this.iah != getCurrent().getIntrinsicHeight()) {
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
        this.iag = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.iah = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IG = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.IG = null;
        } else if (this.hZC == n.b.iaK) {
            current.setBounds(bounds);
            this.IG = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.hZC.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.iaJ != null ? this.iaJ.x : 0.5f, this.iaJ != null ? this.iaJ.y : 0.5f);
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
