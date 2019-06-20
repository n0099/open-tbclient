package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.n;
/* loaded from: classes2.dex */
public class m extends g {
    Matrix Gz;
    n.b jUS;
    Object jVW;
    PointF jVX;
    int jVv;
    int jVw;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jVX = null;
        this.jVv = 0;
        this.jVw = 0;
        this.mTempMatrix = new Matrix();
        this.jUS = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        cDo();
        return j;
    }

    public n.b cDs() {
        return this.jUS;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.jUS, bVar)) {
            this.jUS = bVar;
            this.jVW = null;
            cDo();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.jVX, pointF)) {
            if (this.jVX == null) {
                this.jVX = new PointF();
            }
            this.jVX.set(pointF);
            cDo();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cDn();
        if (this.Gz != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.Gz);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        cDo();
    }

    private void cDn() {
        boolean z;
        boolean z2 = false;
        if (this.jUS instanceof n.k) {
            Object state = ((n.k) this.jUS).getState();
            z = state == null || !state.equals(this.jVW);
            this.jVW = state;
        } else {
            z = false;
        }
        if (this.jVv != getCurrent().getIntrinsicWidth() || this.jVw != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cDo();
        }
    }

    void cDo() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.jVv = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.jVw = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.Gz = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.Gz = null;
        } else if (this.jUS == n.b.jVY) {
            current.setBounds(bounds);
            this.Gz = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.jUS.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.jVX != null ? this.jVX.x : 0.5f, this.jVX != null ? this.jVX.y : 0.5f);
            this.Gz = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        cDn();
        if (this.Gz != null) {
            matrix.preConcat(this.Gz);
        }
    }
}
