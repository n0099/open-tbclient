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
    n.b imR;
    Object inY;
    PointF inZ;
    int inw;
    int inx;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.inZ = null;
        this.inw = 0;
        this.inx = 0;
        this.mTempMatrix = new Matrix();
        this.imR = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        bWm();
        return j;
    }

    public n.b bWq() {
        return this.imR;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.imR, bVar)) {
            this.imR = bVar;
            this.inY = null;
            bWm();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.inZ, pointF)) {
            if (this.inZ == null) {
                this.inZ = new PointF();
            }
            this.inZ.set(pointF);
            bWm();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        bWl();
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
        bWm();
    }

    private void bWl() {
        boolean z;
        boolean z2 = false;
        if (this.imR instanceof n.k) {
            Object state = ((n.k) this.imR).getState();
            z = state == null || !state.equals(this.inY);
            this.inY = state;
        } else {
            z = false;
        }
        if (this.inw != getCurrent().getIntrinsicWidth() || this.inx != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            bWm();
        }
    }

    void bWm() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.inw = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.inx = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IK = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.IK = null;
        } else if (this.imR == n.b.ioa) {
            current.setBounds(bounds);
            this.IK = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.imR.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.inZ != null ? this.inZ.x : 0.5f, this.inZ != null ? this.inZ.y : 0.5f);
            this.IK = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        bWl();
        if (this.IK != null) {
            matrix.preConcat(this.IK);
        }
    }
}
