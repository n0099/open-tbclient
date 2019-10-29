package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g kgz;

    public static g cFo() {
        if (kgz == null) {
            kgz = new g();
        }
        return kgz;
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
