package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g kfR;

    public static g cHD() {
        if (kfR == null) {
            kfR = new g();
        }
        return kfR;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    /* renamed from: S */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
