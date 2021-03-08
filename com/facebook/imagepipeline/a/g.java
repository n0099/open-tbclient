package com.facebook.imagepipeline.a;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g pJu;

    public static g evV() {
        if (pJu == null) {
            pJu = new g();
        }
        return pJu;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
