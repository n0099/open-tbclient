package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes13.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g mtW;

    public static g dxB() {
        if (mtW == null) {
            mtW = new g();
        }
        return mtW;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    /* renamed from: V */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
