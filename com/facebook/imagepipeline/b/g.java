package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g mZr;

    public static g dFI() {
        if (mZr == null) {
            mZr = new g();
        }
        return mZr;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    /* renamed from: Y */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
