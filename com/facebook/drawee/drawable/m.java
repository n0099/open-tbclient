package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.n;
/* loaded from: classes2.dex */
public class m extends g {
    Matrix IR;
    n.b jCE;
    Object jDK;
    PointF jDL;
    int jDi;
    int jDj;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jDL = null;
        this.jDi = 0;
        this.jDj = 0;
        this.mTempMatrix = new Matrix();
        this.jCE = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable k(Drawable drawable) {
        Drawable k = super.k(drawable);
        cvy();
        return k;
    }

    public n.b cvC() {
        return this.jCE;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.jCE, bVar)) {
            this.jCE = bVar;
            this.jDK = null;
            cvy();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.jDL, pointF)) {
            if (this.jDL == null) {
                this.jDL = new PointF();
            }
            this.jDL.set(pointF);
            cvy();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cvx();
        if (this.IR != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.IR);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        cvy();
    }

    private void cvx() {
        boolean z;
        boolean z2 = false;
        if (this.jCE instanceof n.k) {
            Object state = ((n.k) this.jCE).getState();
            z = state == null || !state.equals(this.jDK);
            this.jDK = state;
        } else {
            z = false;
        }
        if (this.jDi != getCurrent().getIntrinsicWidth() || this.jDj != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cvy();
        }
    }

    void cvy() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.jDi = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.jDj = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IR = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.IR = null;
        } else if (this.jCE == n.b.jDM) {
            current.setBounds(bounds);
            this.IR = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.jCE.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.jDL != null ? this.jDL.x : 0.5f, this.jDL != null ? this.jDL.y : 0.5f);
            this.IR = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        cvx();
        if (this.IR != null) {
            matrix.preConcat(this.IR);
        }
    }
}
