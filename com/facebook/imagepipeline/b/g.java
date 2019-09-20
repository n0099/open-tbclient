package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g kip;

    public static g cIr() {
        if (kip == null) {
            kip = new g();
        }
        return kip;
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
