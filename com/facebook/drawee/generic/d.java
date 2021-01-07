package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class d extends g implements s {
    private static ColorFilter pyq = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable pvO;
    private boolean pyr;
    @Nullable
    private t pys;

    public d(Drawable drawable) {
        super(drawable);
        this.pvO = null;
        this.mColorFilter = null;
        this.pyr = true;
    }

    public void Bb(boolean z) {
        this.pyr = z;
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
        this.pys = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.pys != null) {
            this.pys.Ba(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.pyr && pyq != this.mColorFilter) {
                this.mColorFilter = pyq;
                setColorFilter(this.mColorFilter);
            }
            if (this.pys != null) {
                this.pys.onDraw();
            }
            super.draw(canvas);
            if (this.pvO != null) {
                this.pvO.setBounds(getBounds());
                this.pvO.draw(canvas);
            }
        }
    }

    public void u(@Nullable Drawable drawable) {
        this.pvO = drawable;
        invalidateSelf();
    }
}
