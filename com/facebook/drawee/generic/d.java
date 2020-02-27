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
    private static ColorFilter lNt = null;
    @Nullable
    Drawable lKX;
    private boolean lNu;
    @Nullable
    private t lNv;
    private ColorFilter mColorFilter;

    public d(Drawable drawable) {
        super(drawable);
        this.lKX = null;
        this.mColorFilter = null;
        this.lNu = true;
    }

    public void vl(boolean z) {
        this.lNu = z;
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
        this.lNv = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.lNv != null) {
            this.lNv.vk(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.lNu && lNt != this.mColorFilter) {
                this.mColorFilter = lNt;
                setColorFilter(this.mColorFilter);
            }
            if (this.lNv != null) {
                this.lNv.onDraw();
            }
            super.draw(canvas);
            if (this.lKX != null) {
                this.lKX.setBounds(getBounds());
                this.lKX.draw(canvas);
            }
        }
    }

    public void n(@Nullable Drawable drawable) {
        this.lKX = drawable;
        invalidateSelf();
    }
}
