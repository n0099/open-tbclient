package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
/* loaded from: classes12.dex */
public class n extends m {
    public n(NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
    }

    @Override // com.facebook.drawee.drawable.m, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!dll()) {
            super.draw(canvas);
            return;
        }
        dln();
        dlm();
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }
}
