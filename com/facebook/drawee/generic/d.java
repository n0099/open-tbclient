package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class d extends g implements s {
    private static ColorFilter mWc = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable mTC;
    private boolean mWd;
    @Nullable
    private t mWe;

    public d(Drawable drawable) {
        super(drawable);
        this.mTC = null;
        this.mColorFilter = null;
        this.mWd = true;
    }

    public void xh(boolean z) {
        this.mWd = z;
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
        this.mWe = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.mWe != null) {
            this.mWe.xg(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.mWd && mWc != this.mColorFilter) {
                this.mColorFilter = mWc;
                setColorFilter(this.mColorFilter);
            }
            if (this.mWe != null) {
                this.mWe.onDraw();
            }
            super.draw(canvas);
            if (this.mTC != null) {
                this.mTC.setBounds(getBounds());
                this.mTC.draw(canvas);
            }
        }
    }

    public void j(@Nullable Drawable drawable) {
        this.mTC = drawable;
        invalidateSelf();
    }
}
