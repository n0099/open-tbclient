package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d extends g implements s {
    private static ColorFilter lMM = null;
    @Nullable
    Drawable lKq;
    private boolean lMN;
    @Nullable
    private t lMO;
    private ColorFilter mColorFilter;

    public d(Drawable drawable) {
        super(drawable);
        this.lKq = null;
        this.mColorFilter = null;
        this.lMN = true;
    }

    public void vh(boolean z) {
        this.lMN = z;
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
        this.lMO = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.lMO != null) {
            this.lMO.vg(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.lMN && lMM != this.mColorFilter) {
                this.mColorFilter = lMM;
                setColorFilter(this.mColorFilter);
            }
            if (this.lMO != null) {
                this.lMO.dlp();
            }
            super.draw(canvas);
            if (this.lKq != null) {
                this.lKq.setBounds(getBounds());
                this.lKq.draw(canvas);
            }
        }
    }

    public void n(@Nullable Drawable drawable) {
        this.lKq = drawable;
        invalidateSelf();
    }
}
