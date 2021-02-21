package com.facebook.imagepipeline.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.memory.PooledByteBuffer;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(11)
/* loaded from: classes5.dex */
public class e extends f {
    private static final String TAG = e.class.getSimpleName();
    private final b pHl;
    private final com.facebook.imagepipeline.h.e pHn;
    private boolean pHo;

    public e(b bVar, com.facebook.imagepipeline.h.e eVar) {
        this.pHl = bVar;
        this.pHn = eVar;
    }

    @Override // com.facebook.imagepipeline.a.f
    @TargetApi(12)
    public com.facebook.common.references.a<Bitmap> g(int i, int i2, Bitmap.Config config) {
        com.facebook.common.references.a<Bitmap> aVar;
        if (this.pHo) {
            return h(i, i2, config);
        }
        com.facebook.common.references.a<PooledByteBuffer> b2 = this.pHl.b((short) i, (short) i2);
        try {
            com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(b2);
            eVar.c(com.facebook.c.b.pGo);
            com.facebook.common.references.a<Bitmap> a2 = this.pHn.a(eVar, config, null, b2.get().size());
            if (!a2.get().isMutable()) {
                com.facebook.common.references.a.c(a2);
                this.pHo = true;
                com.facebook.common.c.a.wtf(TAG, "Immutable bitmap returned by decoder");
                aVar = h(i, i2, config);
                com.facebook.imagepipeline.f.e.e(eVar);
            } else {
                a2.get().setHasAlpha(true);
                a2.get().eraseColor(0);
                com.facebook.imagepipeline.f.e.e(eVar);
                b2.close();
                aVar = a2;
            }
            return aVar;
        } finally {
            b2.close();
        }
    }

    private static com.facebook.common.references.a<Bitmap> h(int i, int i2, Bitmap.Config config) {
        return com.facebook.common.references.a.a(Bitmap.createBitmap(i, i2, config), g.evM());
    }
}
