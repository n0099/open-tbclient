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
    private static ColorFilter pGD = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable pEb;
    private boolean pGE;
    @Nullable
    private t pGF;

    public d(Drawable drawable) {
        super(drawable);
        this.pEb = null;
        this.mColorFilter = null;
        this.pGE = true;
    }

    public void Bo(boolean z) {
        this.pGE = z;
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
        this.pGF = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.pGF != null) {
            this.pGF.Bn(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.pGE && pGD != this.mColorFilter) {
                this.mColorFilter = pGD;
                setColorFilter(this.mColorFilter);
            }
            if (this.pGF != null) {
                this.pGF.onDraw();
            }
            super.draw(canvas);
            if (this.pEb != null) {
                this.pEb.setBounds(getBounds());
                this.pEb.draw(canvas);
            }
        }
    }

    public void u(@Nullable Drawable drawable) {
        this.pEb = drawable;
        invalidateSelf();
    }
}
