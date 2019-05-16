package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g jXC;

    public static g cEe() {
        if (jXC == null) {
            jXC = new g();
        }
        return jXC;
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
