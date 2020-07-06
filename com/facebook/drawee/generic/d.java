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
    private static ColorFilter mNR = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable mLs;
    private boolean mNS;
    @Nullable
    private t mNT;

    public d(Drawable drawable) {
        super(drawable);
        this.mLs = null;
        this.mColorFilter = null;
        this.mNS = true;
    }

    public void wC(boolean z) {
        this.mNS = z;
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
        this.mNT = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.mNT != null) {
            this.mNT.wB(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.mNS && mNR != this.mColorFilter) {
                this.mColorFilter = mNR;
                setColorFilter(this.mColorFilter);
            }
            if (this.mNT != null) {
                this.mNT.onDraw();
            }
            super.draw(canvas);
            if (this.mLs != null) {
                this.mLs.setBounds(getBounds());
                this.mLs.draw(canvas);
            }
        }
    }

    public void j(@Nullable Drawable drawable) {
        this.mLs = drawable;
        invalidateSelf();
    }
}
