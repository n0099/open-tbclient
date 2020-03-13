package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes13.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g lQI;

    public static g dnR() {
        if (lQI == null) {
            lQI = new g();
        }
        return lQI;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
