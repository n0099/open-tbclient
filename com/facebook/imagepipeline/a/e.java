package com.facebook.imagepipeline.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(11)
/* loaded from: classes15.dex */
public class e extends f {
    private static final String TAG = e.class.getSimpleName();
    private final b pjR;
    private final com.facebook.imagepipeline.h.e pjT;
    private boolean pjU;

    public e(b bVar, com.facebook.imagepipeline.h.e eVar) {
        this.pjR = bVar;
        this.pjT = eVar;
    }

    @Override // com.facebook.imagepipeline.a.f
    @TargetApi(12)
    public com.facebook.common.references.a<Bitmap> c(int i, int i2, Bitmap.Config config) {
        com.facebook.common.references.a<Bitmap> aVar;
        if (this.pjU) {
            return d(i, i2, config);
        }
        com.facebook.common.references.a<PooledByteBuffer> b = this.pjR.b((short) i, (short) i2);
        try {
            com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(b);
            eVar.c(com.facebook.c.b.piU);
            com.facebook.common.references.a<Bitmap> a2 = this.pjT.a(eVar, config, null, b.get().size());
            if (!a2.get().isMutable()) {
                com.facebook.common.references.a.c(a2);
                this.pjU = true;
                com.facebook.common.c.a.wtf(TAG, "Immutable bitmap returned by decoder");
                aVar = d(i, i2, config);
                com.facebook.imagepipeline.f.e.e(eVar);
            } else {
                a2.get().setHasAlpha(true);
                a2.get().eraseColor(0);
                com.facebook.imagepipeline.f.e.e(eVar);
                b.close();
                aVar = a2;
            }
            return aVar;
        } finally {
            b.close();
        }
    }

    private static com.facebook.common.references.a<Bitmap> d(int i, int i2, Bitmap.Config config) {
        return com.facebook.common.references.a.a(Bitmap.createBitmap(i, i2, config), g.esU());
    }
}
