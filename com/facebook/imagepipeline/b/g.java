package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g nDw;

    public static g dVO() {
        if (nDw == null) {
            nDw = new g();
        }
        return nDw;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    /* renamed from: X */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
