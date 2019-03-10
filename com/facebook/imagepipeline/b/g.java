package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g jFC;

    public static g cwm() {
        if (jFC == null) {
            jFC = new g();
        }
        return jFC;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    /* renamed from: R */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
