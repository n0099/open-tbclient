package com.facebook.imagepipeline.a;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g pGP;

    public static g evE() {
        if (pGP == null) {
            pGP = new g();
        }
        return pGP;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
