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
    Drawable jCh;
    @Nullable
    private r jEA;

    public d(Drawable drawable) {
        super(drawable);
        this.jCh = null;
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
        this.jEA = rVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.jEA != null) {
            this.jEA.rt(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.jEA != null) {
                this.jEA.onDraw();
            }
            super.draw(canvas);
            if (this.jCh != null) {
                this.jCh.setBounds(getBounds());
                this.jCh.draw(canvas);
            }
        }
    }

    public void h(@Nullable Drawable drawable) {
        this.jCh = drawable;
        invalidateSelf();
    }
}
