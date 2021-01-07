package com.facebook.imagepipeline.a;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g pBh;

    public static g exe() {
        if (pBh == null) {
            pBh = new g();
        }
        return pBh;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
