package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g jXG;

    public static g cEf() {
        if (jXG == null) {
            jXG = new g();
        }
        return jXG;
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
