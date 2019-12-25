package com.facebook.imagepipeline.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(11)
/* loaded from: classes9.dex */
public class e extends f {
    private static final String TAG = e.class.getSimpleName();
    private final b lLU;
    private final com.facebook.imagepipeline.i.e lLW;
    private boolean lLX;

    public e(b bVar, com.facebook.imagepipeline.i.e eVar) {
        this.lLU = bVar;
        this.lLW = eVar;
    }

    @Override // com.facebook.imagepipeline.b.f
    @TargetApi(12)
    public com.facebook.common.references.a<Bitmap> c(int i, int i2, Bitmap.Config config) {
        com.facebook.common.references.a<Bitmap> aVar;
        if (this.lLX) {
            return d(i, i2, config);
        }
        com.facebook.common.references.a<PooledByteBuffer> b = this.lLU.b((short) i, (short) i2);
        try {
            com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(b);
            eVar.c(com.facebook.c.b.lKR);
            com.facebook.common.references.a<Bitmap> a = this.lLW.a(eVar, config, null, b.get().size());
            if (!a.get().isMutable()) {
                com.facebook.common.references.a.c(a);
                this.lLX = true;
                com.facebook.common.c.a.fa(TAG, "Immutable bitmap returned by decoder");
                aVar = d(i, i2, config);
                com.facebook.imagepipeline.g.e.e(eVar);
            } else {
                a.get().setHasAlpha(true);
                a.get().eraseColor(0);
                com.facebook.imagepipeline.g.e.e(eVar);
                b.close();
                aVar = a;
            }
            return aVar;
        } finally {
            b.close();
        }
    }

    private static com.facebook.common.references.a<Bitmap> d(int i, int i2, Bitmap.Config config) {
        return com.facebook.common.references.a.a(Bitmap.createBitmap(i, i2, config), g.dlu());
    }
}
