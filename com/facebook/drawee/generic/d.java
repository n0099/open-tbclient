package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class d extends g implements s {
    private static ColorFilter ptP = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable prm;
    private boolean ptQ;
    @Nullable
    private t ptR;

    public d(Drawable drawable) {
        super(drawable);
        this.prm = null;
        this.mColorFilter = null;
        this.ptQ = true;
    }

    public void AX(boolean z) {
        this.ptQ = z;
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
        this.ptR = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.ptR != null) {
            this.ptR.AW(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.ptQ && ptP != this.mColorFilter) {
                this.mColorFilter = ptP;
                setColorFilter(this.mColorFilter);
            }
            if (this.ptR != null) {
                this.ptR.onDraw();
            }
            super.draw(canvas);
            if (this.prm != null) {
                this.prm.setBounds(getBounds());
                this.prm.draw(canvas);
            }
        }
    }

    public void u(@Nullable Drawable drawable) {
        this.prm = drawable;
        invalidateSelf();
    }
}
