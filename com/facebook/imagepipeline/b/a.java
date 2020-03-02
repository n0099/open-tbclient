package com.facebook.imagepipeline.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(21)
/* loaded from: classes12.dex */
public class a extends f {
    private final com.facebook.imagepipeline.memory.c lQp;

    public a(com.facebook.imagepipeline.memory.c cVar) {
        this.lQp = cVar;
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.common.references.a<Bitmap> c(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap = this.lQp.get(com.facebook.d.a.e(i, i2, config));
        Bitmaps.a(bitmap, i, i2, config);
        return com.facebook.common.references.a.a(bitmap, this.lQp);
    }
}
