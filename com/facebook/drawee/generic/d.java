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
    private static ColorFilter lNG = null;
    @Nullable
    Drawable lLk;
    private boolean lNH;
    @Nullable
    private t lNI;
    private ColorFilter mColorFilter;

    public d(Drawable drawable) {
        super(drawable);
        this.lLk = null;
        this.mColorFilter = null;
        this.lNH = true;
    }

    public void vl(boolean z) {
        this.lNH = z;
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
        this.lNI = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.lNI != null) {
            this.lNI.vk(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.lNH && lNG != this.mColorFilter) {
                this.mColorFilter = lNG;
                setColorFilter(this.mColorFilter);
            }
            if (this.lNI != null) {
                this.lNI.onDraw();
            }
            super.draw(canvas);
            if (this.lLk != null) {
                this.lLk.setBounds(getBounds());
                this.lLk.draw(canvas);
            }
        }
    }

    public void n(@Nullable Drawable drawable) {
        this.lLk = drawable;
        invalidateSelf();
    }
}
