package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g oTA;

    public static g enn() {
        if (oTA == null) {
            oTA = new g();
        }
        return oTA;
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
