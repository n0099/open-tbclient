package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class d extends g implements s {
    private static ColorFilter nqk = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable nnJ;
    private boolean nql;
    @Nullable
    private t nqm;

    public d(Drawable drawable) {
        super(drawable);
        this.nnJ = null;
        this.mColorFilter = null;
        this.nql = true;
    }

    public void ya(boolean z) {
        this.nql = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.s
    public void a(@Nullable t tVar) {
        this.nqm = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.nqm != null) {
            this.nqm.xZ(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.nql && nqk != this.mColorFilter) {
                this.mColorFilter = nqk;
                setColorFilter(this.mColorFilter);
            }
            if (this.nqm != null) {
                this.nqm.onDraw();
            }
            super.draw(canvas);
            if (this.nnJ != null) {
                this.nnJ.setBounds(getBounds());
                this.nnJ.draw(canvas);
            }
        }
    }

    public void j(@Nullable Drawable drawable) {
        this.nnJ = drawable;
        invalidateSelf();
    }
}
