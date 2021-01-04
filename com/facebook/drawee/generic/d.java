package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class d extends g implements s {
    private static ColorFilter pyj = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable pvH;
    private boolean pyk;
    @Nullable
    private t pyl;

    public d(Drawable drawable) {
        super(drawable);
        this.pvH = null;
        this.mColorFilter = null;
        this.pyk = true;
    }

    public void Bb(boolean z) {
        this.pyk = z;
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
        this.pyl = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.pyl != null) {
            this.pyl.Ba(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.pyk && pyj != this.mColorFilter) {
                this.mColorFilter = pyj;
                setColorFilter(this.mColorFilter);
            }
            if (this.pyl != null) {
                this.pyl.onDraw();
            }
            super.draw(canvas);
            if (this.pvH != null) {
                this.pvH.setBounds(getBounds());
                this.pvH.draw(canvas);
            }
        }
    }

    public void u(@Nullable Drawable drawable) {
        this.pvH = drawable;
        invalidateSelf();
    }
}
