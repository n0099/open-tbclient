package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class d extends g implements s {
    private static ColorFilter pgZ = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable pez;
    private boolean pha;
    @Nullable
    private t phb;

    public d(Drawable drawable) {
        super(drawable);
        this.pez = null;
        this.mColorFilter = null;
        this.pha = true;
    }

    public void AT(boolean z) {
        this.pha = z;
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
        this.phb = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.phb != null) {
            this.phb.AS(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.pha && pgZ != this.mColorFilter) {
                this.mColorFilter = pgZ;
                setColorFilter(this.mColorFilter);
            }
            if (this.phb != null) {
                this.phb.onDraw();
            }
            super.draw(canvas);
            if (this.pez != null) {
                this.pez.setBounds(getBounds());
                this.pez.draw(canvas);
            }
        }
    }

    public void p(@Nullable Drawable drawable) {
        this.pez = drawable;
        invalidateSelf();
    }
}
