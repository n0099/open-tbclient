package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g nSP;

    public static g dZz() {
        if (nSP == null) {
            nSP = new g();
        }
        return nSP;
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
