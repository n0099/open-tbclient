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
    int jCX;
    int jCY;
    n.b jCt;
    PointF jDA;
    Object jDz;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jDA = null;
        this.jCX = 0;
        this.jCY = 0;
        this.mTempMatrix = new Matrix();
        this.jCt = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable k(Drawable drawable) {
        Drawable k = super.k(drawable);
        cvl();
        return k;
    }

    public n.b cvp() {
        return this.jCt;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.jCt, bVar)) {
            this.jCt = bVar;
            this.jDz = null;
            cvl();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.jDA, pointF)) {
            if (this.jDA == null) {
                this.jDA = new PointF();
            }
            this.jDA.set(pointF);
            cvl();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cvk();
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
        cvl();
    }

    private void cvk() {
        boolean z;
        boolean z2 = false;
        if (this.jCt instanceof n.k) {
            Object state = ((n.k) this.jCt).getState();
            z = state == null || !state.equals(this.jDz);
            this.jDz = state;
        } else {
            z = false;
        }
        if (this.jCX != getCurrent().getIntrinsicWidth() || this.jCY != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cvl();
        }
    }

    void cvl() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.jCX = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.jCY = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IR = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.IR = null;
        } else if (this.jCt == n.b.jDB) {
            current.setBounds(bounds);
            this.IR = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.jCt.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.jDA != null ? this.jDA.x : 0.5f, this.jDA != null ? this.jDA.y : 0.5f);
            this.IR = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        cvk();
        if (this.IR != null) {
            matrix.preConcat(this.IR);
        }
    }
}
