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
    int kdF;
    int kdG;
    n.b kdc;
    Object keg;
    PointF keh;
    private Matrix mTempMatrix;

    public m(Drawable drawable, n.b bVar) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.keh = null;
        this.kdF = 0;
        this.kdG = 0;
        this.mTempMatrix = new Matrix();
        this.kdc = bVar;
    }

    @Override // com.facebook.drawee.drawable.g
    public Drawable j(Drawable drawable) {
        Drawable j = super.j(drawable);
        cGL();
        return j;
    }

    public n.b cGP() {
        return this.kdc;
    }

    public void a(n.b bVar) {
        if (!com.facebook.common.internal.f.equal(this.kdc, bVar)) {
            this.kdc = bVar;
            this.keg = null;
            cGL();
            invalidateSelf();
        }
    }

    public void a(PointF pointF) {
        if (!com.facebook.common.internal.f.equal(this.keh, pointF)) {
            if (this.keh == null) {
                this.keh = new PointF();
            }
            this.keh.set(pointF);
            cGL();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        cGK();
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
        cGL();
    }

    private void cGK() {
        boolean z;
        boolean z2 = false;
        if (this.kdc instanceof n.k) {
            Object state = ((n.k) this.kdc).getState();
            z = state == null || !state.equals(this.keg);
            this.keg = state;
        } else {
            z = false;
        }
        if (this.kdF != getCurrent().getIntrinsicWidth() || this.kdG != getCurrent().getIntrinsicHeight()) {
            z2 = true;
        }
        if (z2 || z) {
            cGL();
        }
    }

    void cGL() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.kdF = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.kdG = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.GH = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.GH = null;
        } else if (this.kdc == n.b.kei) {
            current.setBounds(bounds);
            this.GH = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.kdc.a(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.keh != null ? this.keh.x : 0.5f, this.keh != null ? this.keh.y : 0.5f);
            this.GH = this.mTempMatrix;
        }
    }

    @Override // com.facebook.drawee.drawable.g, com.facebook.drawee.drawable.p
    public void e(Matrix matrix) {
        f(matrix);
        cGK();
        if (this.GH != null) {
            matrix.preConcat(this.GH);
        }
    }
}
