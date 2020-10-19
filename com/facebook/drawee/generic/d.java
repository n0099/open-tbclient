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
    private static ColorFilter nPB = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable nNc;
    private boolean nPC;
    @Nullable
    private t nPD;

    public d(Drawable drawable) {
        super(drawable);
        this.nNc = null;
        this.mColorFilter = null;
        this.nPC = true;
    }

    public void yQ(boolean z) {
        this.nPC = z;
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
        this.nPD = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.nPD != null) {
            this.nPD.yP(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.nPC && nPB != this.mColorFilter) {
                this.mColorFilter = nPB;
                setColorFilter(this.mColorFilter);
            }
            if (this.nPD != null) {
                this.nPD.onDraw();
            }
            super.draw(canvas);
            if (this.nNc != null) {
                this.nNc.setBounds(getBounds());
                this.nNc.draw(canvas);
            }
        }
    }

    public void j(@Nullable Drawable drawable) {
        this.nNc = drawable;
        invalidateSelf();
    }
}
