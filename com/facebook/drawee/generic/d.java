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
    private static ColorFilter ptQ = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable prn;
    private boolean ptR;
    @Nullable
    private t ptS;

    public d(Drawable drawable) {
        super(drawable);
        this.prn = null;
        this.mColorFilter = null;
        this.ptR = true;
    }

    public void AX(boolean z) {
        this.ptR = z;
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
        this.ptS = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.ptS != null) {
            this.ptS.AW(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.ptR && ptQ != this.mColorFilter) {
                this.mColorFilter = ptQ;
                setColorFilter(this.mColorFilter);
            }
            if (this.ptS != null) {
                this.ptS.onDraw();
            }
            super.draw(canvas);
            if (this.prn != null) {
                this.prn.setBounds(getBounds());
                this.prn.draw(canvas);
            }
        }
    }

    public void u(@Nullable Drawable drawable) {
        this.prn = drawable;
        invalidateSelf();
    }
}
