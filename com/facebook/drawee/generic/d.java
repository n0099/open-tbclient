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
    private static ColorFilter lWM = null;
    @Nullable
    Drawable lUn;
    private boolean lWN;
    @Nullable
    private t lWO;
    private ColorFilter mColorFilter;

    public d(Drawable drawable) {
        super(drawable);
        this.lUn = null;
        this.mColorFilter = null;
        this.lWN = true;
    }

    public void vG(boolean z) {
        this.lWN = z;
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
        this.lWO = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.lWO != null) {
            this.lWO.vF(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.lWN && lWM != this.mColorFilter) {
                this.mColorFilter = lWM;
                setColorFilter(this.mColorFilter);
            }
            if (this.lWO != null) {
                this.lWO.onDraw();
            }
            super.draw(canvas);
            if (this.lUn != null) {
                this.lUn.setBounds(getBounds());
                this.lUn.draw(canvas);
            }
        }
    }

    public void j(@Nullable Drawable drawable) {
        this.lUn = drawable;
        invalidateSelf();
    }
}
