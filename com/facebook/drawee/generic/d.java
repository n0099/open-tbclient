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
    private static ColorFilter lNv = null;
    @Nullable
    Drawable lKZ;
    private boolean lNw;
    @Nullable
    private t lNx;
    private ColorFilter mColorFilter;

    public d(Drawable drawable) {
        super(drawable);
        this.lKZ = null;
        this.mColorFilter = null;
        this.lNw = true;
    }

    public void vl(boolean z) {
        this.lNw = z;
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
        this.lNx = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.lNx != null) {
            this.lNx.vk(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.lNw && lNv != this.mColorFilter) {
                this.mColorFilter = lNv;
                setColorFilter(this.mColorFilter);
            }
            if (this.lNx != null) {
                this.lNx.onDraw();
            }
            super.draw(canvas);
            if (this.lKZ != null) {
                this.lKZ.setBounds(getBounds());
                this.lKZ.draw(canvas);
            }
        }
    }

    public void n(@Nullable Drawable drawable) {
        this.lKZ = drawable;
        invalidateSelf();
    }
}
