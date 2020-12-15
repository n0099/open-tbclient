package com.facebook.imagepipeline.a;

import android.graphics.Bitmap;
/* loaded from: classes7.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g pjV;

    public static g esU() {
        if (pjV == null) {
            pjV = new g();
        }
        return pjV;
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
