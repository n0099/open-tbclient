package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
/* loaded from: classes9.dex */
public class n extends m {
    public n(NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
    }

    @Override // com.facebook.drawee.drawable.m, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!dEq()) {
            super.draw(canvas);
            return;
        }
        dEs();
        dEr();
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }
}
