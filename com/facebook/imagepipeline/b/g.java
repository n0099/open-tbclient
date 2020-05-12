package com.facebook.imagepipeline.b;

import android.graphics.Bitmap;
/* loaded from: classes13.dex */
public class g implements com.facebook.common.references.c<Bitmap> {
    private static g mab;

    public static g dqj() {
        if (mab == null) {
            mab = new g();
        }
        return mab;
    }

    private g() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.c
    /* renamed from: T */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
