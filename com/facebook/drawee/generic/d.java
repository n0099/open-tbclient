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
    private static ColorFilter pEy = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable pBW;
    @Nullable
    private t pEA;
    private boolean pEz;

    public d(Drawable drawable) {
        super(drawable);
        this.pBW = null;
        this.mColorFilter = null;
        this.pEz = true;
    }

    public void Bq(boolean z) {
        this.pEz = z;
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
        this.pEA = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.pEA != null) {
            this.pEA.Bp(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.pEz && pEy != this.mColorFilter) {
                this.mColorFilter = pEy;
                setColorFilter(this.mColorFilter);
            }
            if (this.pEA != null) {
                this.pEA.onDraw();
            }
            super.draw(canvas);
            if (this.pBW != null) {
                this.pBW.setBounds(getBounds());
                this.pBW.draw(canvas);
            }
        }
    }

    public void u(@Nullable Drawable drawable) {
        this.pBW = drawable;
        invalidateSelf();
    }
}
