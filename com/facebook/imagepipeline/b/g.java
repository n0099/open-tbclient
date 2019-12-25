package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes11.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g lLY;

    public static g dlu() {
        if (lLY == null) {
            lLY = new g();
        }
        return lLY;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
