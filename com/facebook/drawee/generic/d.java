package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class d extends g implements s {
    private static ColorFilter oGU = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable oEv;
    private boolean oGV;
    @Nullable
    private t oGW;

    public d(Drawable drawable) {
        super(drawable);
        this.oEv = null;
        this.mColorFilter = null;
        this.oGV = true;
    }

    public void zY(boolean z) {
        this.oGV = z;
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
        this.oGW = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.oGW != null) {
            this.oGW.zX(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.oGV && oGU != this.mColorFilter) {
                this.mColorFilter = oGU;
                setColorFilter(this.mColorFilter);
            }
            if (this.oGW != null) {
                this.oGW.onDraw();
            }
            super.draw(canvas);
            if (this.oEv != null) {
                this.oEv.setBounds(getBounds());
                this.oEv.draw(canvas);
            }
        }
    }

    public void o(@Nullable Drawable drawable) {
        this.oEv = drawable;
        invalidateSelf();
    }
}
