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
    private static ColorFilter mqG = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable mof;
    private boolean mqH;
    @Nullable
    private t mqI;

    public d(Drawable drawable) {
        super(drawable);
        this.mof = null;
        this.mColorFilter = null;
        this.mqH = true;
    }

    public void we(boolean z) {
        this.mqH = z;
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
        this.mqI = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.mqI != null) {
            this.mqI.wd(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.mqH && mqG != this.mColorFilter) {
                this.mColorFilter = mqG;
                setColorFilter(this.mColorFilter);
            }
            if (this.mqI != null) {
                this.mqI.onDraw();
            }
            super.draw(canvas);
            if (this.mof != null) {
                this.mof.setBounds(getBounds());
                this.mof.draw(canvas);
            }
        }
    }

    public void j(@Nullable Drawable drawable) {
        this.mof = drawable;
        invalidateSelf();
    }
}
