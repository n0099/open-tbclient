package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.n;
/* loaded from: classes2.dex */
public class m extends g {
    Matrix GH;
    n.b kbW;
    int kcA;
    int kcz;
    Object kda;
    PointF kdb;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.kdb = null;
        this.kcz = 0;
        this.kcA = 0;
        this.mTempMatrix = new Matrix();
        this.kbW = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        cGq();
        return j;
    }

    public n.b cGu() {
        return this.kbW;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.kbW, bVar)) {
            this.kbW = bVar;
            this.kda = null;
            cGq();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.kdb, pointF)) {
            if (this.kdb == null) {
                this.kdb = new PointF();
            }
            this.kdb.set(pointF);
            cGq();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cGp();
        if (this.GH != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.GH);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        cGq();
    }

    private void cGp() {
        boolean z;
        boolean z2 = false;
        if (this.kbW instanceof n.k) {
            Object state = ((n.k) this.kbW).getState();
            z = state == null || !state.equals(this.kda);
            this.kda = state;
        } else {
            z = false;
        }
        if (this.kcz != getCurrent().getIntrinsicWidth() || this.kcA != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cGq();
        }
    }

    void cGq() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.kcz = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.kcA = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.GH = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.GH = null;
        } else if (this.kbW == n.b.kdc) {
            current.setBounds(bounds);
            this.GH = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.kbW.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.kdb != null ? this.kdb.x : 0.5f, this.kdb != null ? this.kdb.y : 0.5f);
            this.GH = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        cGp();
        if (this.GH != null) {
            matrix.preConcat(this.GH);
        }
    }
}
