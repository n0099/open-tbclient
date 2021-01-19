package com.facebook.imagepipeline.a;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g pwH;

    public static g etm() {
        if (pwH == null) {
            pwH = new g();
        }
        return pwH;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
