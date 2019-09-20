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
    n.b kfA;
    Object kgE;
    PointF kgF;
    int kgd;
    int kge;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.kgF = null;
        this.kgd = 0;
        this.kge = 0;
        this.mTempMatrix = new Matrix();
        this.kfA = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        cHz();
        return j;
    }

    public n.b cHD() {
        return this.kfA;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.kfA, bVar)) {
            this.kfA = bVar;
            this.kgE = null;
            cHz();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.kgF, pointF)) {
            if (this.kgF == null) {
                this.kgF = new PointF();
            }
            this.kgF.set(pointF);
            cHz();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cHy();
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
        cHz();
    }

    private void cHy() {
        boolean z;
        boolean z2 = false;
        if (this.kfA instanceof n.k) {
            Object state = ((n.k) this.kfA).getState();
            z = state == null || !state.equals(this.kgE);
            this.kgE = state;
        } else {
            z = false;
        }
        if (this.kgd != getCurrent().getIntrinsicWidth() || this.kge != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cHz();
        }
    }

    void cHz() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.kgd = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.kge = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.GH = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.GH = null;
        } else if (this.kfA == n.b.kgG) {
            current.setBounds(bounds);
            this.GH = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.kfA.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.kgF != null ? this.kgF.x : 0.5f, this.kgF != null ? this.kgF.y : 0.5f);
            this.GH = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        cHy();
        if (this.GH != null) {
            matrix.preConcat(this.GH);
        }
    }
}
