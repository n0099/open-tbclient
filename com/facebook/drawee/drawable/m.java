package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.n;
/* loaded from: classes2.dex */
public class m extends g {
    n.b kdI;
    Object keN;
    PointF keO;
    int kel;
    int kem;
    Matrix mDrawMatrix;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.keO = null;
        this.kel = 0;
        this.kem = 0;
        this.mTempMatrix = new Matrix();
        this.kdI = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable h(Drawable drawable) {
        Drawable h = super.h(drawable);
        cEx();
        return h;
    }

    public n.b cEB() {
        return this.kdI;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.kdI, bVar)) {
            this.kdI = bVar;
            this.keN = null;
            cEx();
            invalidateSelf();
        }
    }

    public void d(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.keO, pointF)) {
            if (this.keO == null) {
                this.keO = new PointF();
            }
            this.keO.set(pointF);
            cEx();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cEw();
        if (this.mDrawMatrix != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        cEx();
    }

    private void cEw() {
        boolean z;
        boolean z2 = false;
        if (this.kdI instanceof n.k) {
            Object state = ((n.k) this.kdI).getState();
            z = state == null || !state.equals(this.keN);
            this.keN = state;
        } else {
            z = false;
        }
        if (this.kel != getCurrent().getIntrinsicWidth() || this.kem != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cEx();
        }
    }

    void cEx() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.kel = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.kem = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.kdI == n.b.keP) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.kdI.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.keO != null ? this.keO.x : 0.5f, this.keO != null ? this.keO.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void d(Matrix matrix) {
        e(matrix);
        cEw();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
