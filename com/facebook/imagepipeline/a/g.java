package com.facebook.imagepipeline.a;

import android.graphics.Bitmap;
/* loaded from: classes6.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g pzA;

    public static g ewB() {
        if (pzA == null) {
            pzA = new g();
        }
        return pzA;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
