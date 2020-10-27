package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g oKh;

    public static g ejx() {
        if (oKh == null) {
            oKh = new g();
        }
        return oKh;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    /* renamed from: ab */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
