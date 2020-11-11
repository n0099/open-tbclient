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
    private static ColorFilter oQn = null;
    private ColorFilter mColorFilter;
    @Nullable
    Drawable oNO;
    private boolean oQo;
    @Nullable
    private t oQp;

    public d(Drawable drawable) {
        super(drawable);
        this.oNO = null;
        this.mColorFilter = null;
        this.oQo = true;
    }

    public void Aj(boolean z) {
        this.oQo = z;
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
        this.oQp = tVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.oQp != null) {
            this.oQp.Ai(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.oQo && oQn != this.mColorFilter) {
                this.mColorFilter = oQn;
                setColorFilter(this.mColorFilter);
            }
            if (this.oQp != null) {
                this.oQp.onDraw();
            }
            super.draw(canvas);
            if (this.oNO != null) {
                this.oNO.setBounds(getBounds());
                this.oNO.draw(canvas);
            }
        }
    }

    public void o(@Nullable Drawable drawable) {
        this.oNO = drawable;
        invalidateSelf();
    }
}
