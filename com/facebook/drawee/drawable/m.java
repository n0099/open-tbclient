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
    n.b jCM;
    Object jDS;
    PointF jDT;
    int jDq;
    int jDr;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jDT = null;
        this.jDq = 0;
        this.jDr = 0;
        this.mTempMatrix = new Matrix();
        this.jCM = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable k(Drawable drawable) {
        Drawable k = super.k(drawable);
        cvv();
        return k;
    }

    public n.b cvz() {
        return this.jCM;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.jCM, bVar)) {
            this.jCM = bVar;
            this.jDS = null;
            cvv();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.jDT, pointF)) {
            if (this.jDT == null) {
                this.jDT = new PointF();
            }
            this.jDT.set(pointF);
            cvv();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cvu();
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
        cvv();
    }

    private void cvu() {
        boolean z;
        boolean z2 = false;
        if (this.jCM instanceof n.k) {
            Object state = ((n.k) this.jCM).getState();
            z = state == null || !state.equals(this.jDS);
            this.jDS = state;
        } else {
            z = false;
        }
        if (this.jDq != getCurrent().getIntrinsicWidth() || this.jDr != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cvv();
        }
    }

    void cvv() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.jDq = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.jDr = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IR = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.IR = null;
        } else if (this.jCM == n.b.jDU) {
            current.setBounds(bounds);
            this.IR = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.jCM.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.jDT != null ? this.jDT.x : 0.5f, this.jDT != null ? this.jDT.y : 0.5f);
            this.IR = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        cvu();
        if (this.IR != null) {
            matrix.preConcat(this.IR);
        }
    }
}
