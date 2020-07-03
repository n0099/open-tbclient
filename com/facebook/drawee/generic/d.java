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
    private static ColorFilter mNO = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable mLp;
    private boolean mNP;
    @Nullable
    private t mNQ;

    public d(Drawable drawable) {
        super(drawable);
        this.mLp = null;
        this.mColorFilter = null;
        this.mNP = true;
    }

    public void wC(boolean z) {
        this.mNP = z;
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
        this.mNQ = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.mNQ != null) {
            this.mNQ.wB(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.mNP && mNO != this.mColorFilter) {
                this.mColorFilter = mNO;
                setColorFilter(this.mColorFilter);
            }
            if (this.mNQ != null) {
                this.mNQ.onDraw();
            }
            super.draw(canvas);
            if (this.mLp != null) {
                this.mLp.setBounds(getBounds());
                this.mLp.draw(canvas);
            }
        }
    }

    public void j(@Nullable Drawable drawable) {
        this.mLp = drawable;
        invalidateSelf();
    }
}
