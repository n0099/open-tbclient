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
    private static ColorFilter phb = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable peB;
    private boolean phc;
    @Nullable
    private t phd;

    public d(Drawable drawable) {
        super(drawable);
        this.peB = null;
        this.mColorFilter = null;
        this.phc = true;
    }

    public void AT(boolean z) {
        this.phc = z;
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
        this.phd = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.phd != null) {
            this.phd.AS(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.phc && phb != this.mColorFilter) {
                this.mColorFilter = phb;
                setColorFilter(this.mColorFilter);
            }
            if (this.phd != null) {
                this.phd.onDraw();
            }
            super.draw(canvas);
            if (this.peB != null) {
                this.peB.setBounds(getBounds());
                this.peB.draw(canvas);
            }
        }
    }

    public void p(@Nullable Drawable drawable) {
        this.peB = drawable;
        invalidateSelf();
    }
}
