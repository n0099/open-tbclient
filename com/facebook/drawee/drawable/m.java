package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.n;
/* loaded from: classes2.dex */
public class m extends g {
    Matrix GA;
    n.b jUO;
    Object jVS;
    PointF jVT;
    int jVr;
    int jVs;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jVT = null;
        this.jVr = 0;
        this.jVs = 0;
        this.mTempMatrix = new Matrix();
        this.jUO = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        cDn();
        return j;
    }

    public n.b cDr() {
        return this.jUO;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.jUO, bVar)) {
            this.jUO = bVar;
            this.jVS = null;
            cDn();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.jVT, pointF)) {
            if (this.jVT == null) {
                this.jVT = new PointF();
            }
            this.jVT.set(pointF);
            cDn();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cDm();
        if (this.GA != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.GA);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        cDn();
    }

    private void cDm() {
        boolean z;
        boolean z2 = false;
        if (this.jUO instanceof n.k) {
            Object state = ((n.k) this.jUO).getState();
            z = state == null || !state.equals(this.jVS);
            this.jVS = state;
        } else {
            z = false;
        }
        if (this.jVr != getCurrent().getIntrinsicWidth() || this.jVs != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cDn();
        }
    }

    void cDn() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.jVr = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.jVs = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.GA = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.GA = null;
        } else if (this.jUO == n.b.jVU) {
            current.setBounds(bounds);
            this.GA = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.jUO.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.jVT != null ? this.jVT.x : 0.5f, this.jVT != null ? this.jVT.y : 0.5f);
            this.GA = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        cDm();
        if (this.GA != null) {
            matrix.preConcat(this.GA);
        }
    }
}
