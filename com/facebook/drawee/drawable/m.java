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
    n.b jBZ;
    int jCD;
    int jCE;
    Object jDf;
    PointF jDg;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jDg = null;
        this.jCD = 0;
        this.jCE = 0;
        this.mTempMatrix = new Matrix();
        this.jBZ = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable k(Drawable drawable) {
        Drawable k = super.k(drawable);
        cvr();
        return k;
    }

    public n.b cvv() {
        return this.jBZ;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.jBZ, bVar)) {
            this.jBZ = bVar;
            this.jDf = null;
            cvr();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.jDg, pointF)) {
            if (this.jDg == null) {
                this.jDg = new PointF();
            }
            this.jDg.set(pointF);
            cvr();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cvq();
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
        cvr();
    }

    private void cvq() {
        boolean z;
        boolean z2 = false;
        if (this.jBZ instanceof n.k) {
            Object state = ((n.k) this.jBZ).getState();
            z = state == null || !state.equals(this.jDf);
            this.jDf = state;
        } else {
            z = false;
        }
        if (this.jCD != getCurrent().getIntrinsicWidth() || this.jCE != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cvr();
        }
    }

    void cvr() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.jCD = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.jCE = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IR = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.IR = null;
        } else if (this.jBZ == n.b.jDh) {
            current.setBounds(bounds);
            this.IR = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.jBZ.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.jDg != null ? this.jDg.x : 0.5f, this.jDg != null ? this.jDg.y : 0.5f);
            this.IR = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        cvq();
        if (this.IR != null) {
            matrix.preConcat(this.IR);
        }
    }
}
