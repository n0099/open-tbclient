package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class d extends g implements s {
    private static ColorFilter oRQ = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable oPs;
    private boolean oRR;
    @Nullable
    private t oRS;

    public d(Drawable drawable) {
        super(drawable);
        this.oPs = null;
        this.mColorFilter = null;
        this.oRR = true;
    }

    public void Aq(boolean z) {
        this.oRR = z;
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
        this.oRS = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.oRS != null) {
            this.oRS.Ap(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.oRR && oRQ != this.mColorFilter) {
                this.mColorFilter = oRQ;
                setColorFilter(this.mColorFilter);
            }
            if (this.oRS != null) {
                this.oRS.onDraw();
            }
            super.draw(canvas);
            if (this.oPs != null) {
                this.oPs.setBounds(getBounds());
                this.oPs.draw(canvas);
            }
        }
    }

    public void p(@Nullable Drawable drawable) {
        this.oPs = drawable;
        invalidateSelf();
    }
}
