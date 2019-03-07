package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.q;
import com.facebook.drawee.drawable.r;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class d extends g implements q {
    @Nullable
    Drawable jBO;
    @Nullable
    private r jEh;

    public d(Drawable drawable) {
        super(drawable);
        this.jBO = null;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.q
    public void a(@Nullable r rVar) {
        this.jEh = rVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.jEh != null) {
            this.jEh.rt(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.jEh != null) {
                this.jEh.onDraw();
            }
            super.draw(canvas);
            if (this.jBO != null) {
                this.jBO.setBounds(getBounds());
                this.jBO.draw(canvas);
            }
        }
    }

    public void h(@Nullable Drawable drawable) {
        this.jBO = drawable;
        invalidateSelf();
    }
}
