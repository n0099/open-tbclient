package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes8.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g nty;

    public static g dRQ() {
        if (nty == null) {
            nty = new g();
        }
        return nty;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    /* renamed from: Y */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
