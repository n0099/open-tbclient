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
    n.b iiz;
    Object ijF;
    PointF ijG;
    int ijd;
    int ije;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.ijG = null;
        this.ijd = 0;
        this.ije = 0;
        this.mTempMatrix = new Matrix();
        this.iiz = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        bUO();
        return j;
    }

    public n.b bUS() {
        return this.iiz;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.iiz, bVar)) {
            this.iiz = bVar;
            this.ijF = null;
            bUO();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.ijG, pointF)) {
            if (this.ijG == null) {
                this.ijG = new PointF();
            }
            this.ijG.set(pointF);
            bUO();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        bUN();
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
        bUO();
    }

    private void bUN() {
        boolean z;
        boolean z2 = false;
        if (this.iiz instanceof n.k) {
            Object state = ((n.k) this.iiz).getState();
            z = state == null || !state.equals(this.ijF);
            this.ijF = state;
        } else {
            z = false;
        }
        if (this.ijd != getCurrent().getIntrinsicWidth() || this.ije != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            bUO();
        }
    }

    void bUO() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.ijd = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.ije = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.IK = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.IK = null;
        } else if (this.iiz == n.b.ijH) {
            current.setBounds(bounds);
            this.IK = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.iiz.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.ijG != null ? this.ijG.x : 0.5f, this.ijG != null ? this.ijG.y : 0.5f);
            this.IK = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        bUN();
        if (this.IK != null) {
            matrix.preConcat(this.IK);
        }
    }
}
