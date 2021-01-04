package com.facebook.imagepipeline.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(21)
/* loaded from: classes5.dex */
public class a extends f {
    private final com.facebook.imagepipeline.memory.c pzs;

    public a(com.facebook.imagepipeline.memory.c cVar) {
        this.pzs = cVar;
    }

    @Override // com.facebook.imagepipeline.a.f
    public com.facebook.common.references.a<Bitmap> e(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap = this.pzs.get(com.facebook.d.a.g(i, i2, config));
        Bitmaps.a(bitmap, i, i2, config);
        return com.facebook.common.references.a.a(bitmap, this.pzs);
    }
}
