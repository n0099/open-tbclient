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
    n.b jUP;
    Object jVT;
    PointF jVU;
    int jVs;
    int jVt;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jVU = null;
        this.jVs = 0;
        this.jVt = 0;
        this.mTempMatrix = new Matrix();
        this.jUP = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        cDp();
        return j;
    }

    public n.b cDt() {
        return this.jUP;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.jUP, bVar)) {
            this.jUP = bVar;
            this.jVT = null;
            cDp();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.jVU, pointF)) {
            if (this.jVU == null) {
                this.jVU = new PointF();
            }
            this.jVU.set(pointF);
            cDp();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cDo();
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
        cDp();
    }

    private void cDo() {
        boolean z;
        boolean z2 = false;
        if (this.jUP instanceof n.k) {
            Object state = ((n.k) this.jUP).getState();
            z = state == null || !state.equals(this.jVT);
            this.jVT = state;
        } else {
            z = false;
        }
        if (this.jVs != getCurrent().getIntrinsicWidth() || this.jVt != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cDp();
        }
    }

    void cDp() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.jVs = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.jVt = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.GA = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.GA = null;
        } else if (this.jUP == n.b.jVV) {
            current.setBounds(bounds);
            this.GA = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.jUP.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.jVU != null ? this.jVU.x : 0.5f, this.jVU != null ? this.jVU.y : 0.5f);
            this.GA = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        cDo();
        if (this.GA != null) {
            matrix.preConcat(this.GA);
        }
    }
}
