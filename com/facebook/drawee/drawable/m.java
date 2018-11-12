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
    int ibQ;
    int ibR;
    n.b ibm;
    Object ics;
    PointF ict;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.ict = null;
        this.ibQ = 0;
        this.ibR = 0;
        this.mTempMatrix = new Matrix();
        this.ibm = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        bSI();
        return j;
    }

    public n.b bSM() {
        return this.ibm;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.ibm, bVar)) {
            this.ibm = bVar;
            this.ics = null;
            bSI();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.ict, pointF)) {
            if (this.ict == null) {
                this.ict = new PointF();
            }
            this.ict.set(pointF);
            bSI();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        bSH();
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
        bSI();
    }

    private void bSH() {
        boolean z;
        boolean z2 = false;
        if (this.ibm instanceof n.k) {
            Object state = ((n.k) this.ibm).getState();
            z = state == null || !state.equals(this.ics);
            this.ics = state;
        } else {
            z = false;
        }
        if (this.ibQ != getCurrent().getIntrinsicWidth() || this.ibR != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            bSI();
        }
    }

    void bSI() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.ibQ = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.ibR = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IK = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.IK = null;
        } else if (this.ibm == n.b.icu) {
            current.setBounds(bounds);
            this.IK = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.ibm.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.ict != null ? this.ict.x : 0.5f, this.ict != null ? this.ict.y : 0.5f);
            this.IK = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        bSH();
        if (this.IK != null) {
            matrix.preConcat(this.IK);
        }
    }
}
