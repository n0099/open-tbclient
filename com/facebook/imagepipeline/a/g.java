package com.facebook.imagepipeline.a;

import android.graphics.Bitmap;
/* loaded from: classes7.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g pjT;

    public static g esT() {
        if (pjT == null) {
            pjT = new g();
        }
        return pjT;
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
