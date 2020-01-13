package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g lPJ;

    public static g dmz() {
        if (lPJ == null) {
            lPJ = new g();
        }
        return lPJ;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
