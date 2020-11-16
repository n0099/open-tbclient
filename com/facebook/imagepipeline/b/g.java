package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes17.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g oVd;

    public static g enl() {
        if (oVd == null) {
            oVd = new g();
        }
        return oVd;
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
