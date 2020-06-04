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
    private static ColorFilter mrQ = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable mpq;
    private boolean mrR;
    @Nullable
    private t mrS;

    public d(Drawable drawable) {
        super(drawable);
        this.mpq = null;
        this.mColorFilter = null;
        this.mrR = true;
    }

    public void wg(boolean z) {
        this.mrR = z;
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
        this.mrS = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.mrS != null) {
            this.mrS.wf(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.mrR && mrQ != this.mColorFilter) {
                this.mColorFilter = mrQ;
                setColorFilter(this.mColorFilter);
            }
            if (this.mrS != null) {
                this.mrS.onDraw();
            }
            super.draw(canvas);
            if (this.mpq != null) {
                this.mpq.setBounds(getBounds());
                this.mpq.draw(canvas);
            }
        }
    }

    public void j(@Nullable Drawable drawable) {
        this.mpq = drawable;
        invalidateSelf();
    }
}
