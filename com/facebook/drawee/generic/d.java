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
    private static ColorFilter lPm = null;
    @Nullable
    Drawable lMQ;
    private boolean lPn;
    @Nullable
    private t lPo;
    private ColorFilter mColorFilter;

    public d(Drawable drawable) {
        super(drawable);
        this.lMQ = null;
        this.mColorFilter = null;
        this.lPn = true;
    }

    public void vs(boolean z) {
        this.lPn = z;
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
        this.lPo = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.lPo != null) {
            this.lPo.vr(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.lPn && lPm != this.mColorFilter) {
                this.mColorFilter = lPm;
                setColorFilter(this.mColorFilter);
            }
            if (this.lPo != null) {
                this.lPo.onDraw();
            }
            super.draw(canvas);
            if (this.lMQ != null) {
                this.lMQ.setBounds(getBounds());
                this.lMQ.draw(canvas);
            }
        }
    }

    public void n(@Nullable Drawable drawable) {
        this.lMQ = drawable;
        invalidateSelf();
    }
}
