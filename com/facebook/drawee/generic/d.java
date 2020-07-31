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
    private static ColorFilter mWa = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable mTA;
    private boolean mWb;
    @Nullable
    private t mWc;

    public d(Drawable drawable) {
        super(drawable);
        this.mTA = null;
        this.mColorFilter = null;
        this.mWb = true;
    }

    public void xh(boolean z) {
        this.mWb = z;
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
        this.mWc = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.mWc != null) {
            this.mWc.xg(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.mWb && mWa != this.mColorFilter) {
                this.mColorFilter = mWa;
                setColorFilter(this.mColorFilter);
            }
            if (this.mWc != null) {
                this.mWc.onDraw();
            }
            super.draw(canvas);
            if (this.mTA != null) {
                this.mTA.setBounds(getBounds());
                this.mTA.draw(canvas);
            }
        }
    }

    public void j(@Nullable Drawable drawable) {
        this.mTA = drawable;
        invalidateSelf();
    }
}
