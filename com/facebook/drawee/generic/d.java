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
    Drawable kcm;
    @Nullable
    private r keE;

    public d(Drawable drawable) {
        super(drawable);
        this.kcm = null;
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
        this.keE = rVar;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.keE != null) {
            this.keE.sh(z);
        }
        return super.setVisible(z, z2);
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.keE != null) {
                this.keE.cEA();
            }
            super.draw(canvas);
            if (this.kcm != null) {
                this.kcm.setBounds(getBounds());
                this.kcm.draw(canvas);
            }
        }
    }

    public void f(@Nullable Drawable drawable) {
        this.kcm = drawable;
        invalidateSelf();
    }
}
