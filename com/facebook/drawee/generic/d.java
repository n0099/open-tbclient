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
    private static ColorFilter pDY = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable pBw;
    private boolean pDZ;
    @Nullable
    private t pEa;

    public d(Drawable drawable) {
        super(drawable);
        this.pBw = null;
        this.mColorFilter = null;
        this.pDZ = true;
    }

    public void Bq(boolean z) {
        this.pDZ = z;
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
        this.pEa = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.pEa != null) {
            this.pEa.Bp(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.pDZ && pDY != this.mColorFilter) {
                this.mColorFilter = pDY;
                setColorFilter(this.mColorFilter);
            }
            if (this.pEa != null) {
                this.pEa.onDraw();
            }
            super.draw(canvas);
            if (this.pBw != null) {
                this.pBw.setBounds(getBounds());
                this.pBw.draw(canvas);
            }
        }
    }

    public void u(@Nullable Drawable drawable) {
        this.pBw = drawable;
        invalidateSelf();
    }
}
