package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g kfI;

    public static g cFm() {
        if (kfI == null) {
            kfI = new g();
        }
        return kfI;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    /* renamed from: Q */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
