package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d extends g implements s {
    private static ColorFilter lWI = null;
    @Nullable
    Drawable lUj;
    private boolean lWJ;
    @Nullable
    private t lWK;
    private ColorFilter mColorFilter;

    public d(Drawable drawable) {
        super(drawable);
        this.lUj = null;
        this.mColorFilter = null;
        this.lWJ = true;
    }

    public void vG(boolean z) {
        this.lWJ = z;
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
        this.lWK = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.lWK != null) {
            this.lWK.vF(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.lWJ && lWI != this.mColorFilter) {
                this.mColorFilter = lWI;
                setColorFilter(this.mColorFilter);
            }
            if (this.lWK != null) {
                this.lWK.onDraw();
            }
            super.draw(canvas);
            if (this.lUj != null) {
                this.lUj.setBounds(getBounds());
                this.lUj.draw(canvas);
            }
        }
    }

    public void j(@Nullable Drawable drawable) {
        this.lUj = drawable;
        invalidateSelf();
    }
}
