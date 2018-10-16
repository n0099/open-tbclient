package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g icl;

    public static g bUc() {
        if (icl == null) {
            icl = new g();
        }
        return icl;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    /* renamed from: J */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
