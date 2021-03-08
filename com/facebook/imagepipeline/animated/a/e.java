package com.facebook.imagepipeline.animated.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.common.internal.g;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.a.f;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class e implements d {
    static c pIU;
    static c pIV;
    private final com.facebook.imagepipeline.animated.impl.b pHZ;
    private final f pIT;

    static {
        pIU = null;
        pIV = null;
        pIU = ZL("com.facebook.animated.gif.GifImage");
        pIV = ZL("com.facebook.animated.webp.WebPImage");
    }

    private static c ZL(String str) {
        try {
            return (c) Class.forName(str).newInstance();
        } catch (Throwable th) {
            return null;
        }
    }

    public e(com.facebook.imagepipeline.animated.impl.b bVar, f fVar) {
        this.pHZ = bVar;
        this.pIT = fVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        if (pIU == null) {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
        com.facebook.common.references.a<PooledByteBuffer> eyE = eVar.eyE();
        g.checkNotNull(eyE);
        try {
            PooledByteBuffer pooledByteBuffer = eyE.get();
            return a(bVar, pIU.M(pooledByteBuffer.esX(), pooledByteBuffer.size()), config);
        } finally {
            com.facebook.common.references.a.c(eyE);
        }
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        if (pIV == null) {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
        com.facebook.common.references.a<PooledByteBuffer> eyE = eVar.eyE();
        g.checkNotNull(eyE);
        try {
            PooledByteBuffer pooledByteBuffer = eyE.get();
            return a(bVar, pIV.M(pooledByteBuffer.esX(), pooledByteBuffer.size()), config);
        } finally {
            com.facebook.common.references.a.c(eyE);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=4] */
    private com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.common.b bVar, com.facebook.imagepipeline.animated.base.b bVar2, Bitmap.Config config) {
        com.facebook.common.references.a<Bitmap> aVar;
        List<com.facebook.common.references.a<Bitmap>> list;
        com.facebook.imagepipeline.f.c aVar2;
        try {
            int frameCount = bVar.pKr ? bVar2.getFrameCount() - 1 : 0;
            if (bVar.pKt) {
                aVar2 = new com.facebook.imagepipeline.f.d(a(bVar2, config, frameCount), com.facebook.imagepipeline.f.g.pMO, 0);
                com.facebook.common.references.a.c(null);
                com.facebook.common.references.a.b((Iterable<? extends com.facebook.common.references.a<?>>) null);
            } else {
                if (bVar.pKs) {
                    list = a(bVar2, config);
                    try {
                        aVar = com.facebook.common.references.a.b(list.get(frameCount));
                    } catch (Throwable th) {
                        th = th;
                        aVar = null;
                        com.facebook.common.references.a.c(aVar);
                        com.facebook.common.references.a.b(list);
                        throw th;
                    }
                } else {
                    aVar = null;
                    list = null;
                }
                try {
                    if (bVar.pKq && aVar == null) {
                        aVar = a(bVar2, config, frameCount);
                    }
                    aVar2 = new com.facebook.imagepipeline.f.a(com.facebook.imagepipeline.animated.base.d.b(bVar2).j(aVar).PE(frameCount).gK(list).evS());
                    com.facebook.common.references.a.c(aVar);
                    com.facebook.common.references.a.b(list);
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.references.a.c(aVar);
                    com.facebook.common.references.a.b(list);
                    throw th;
                }
            }
            return aVar2;
        } catch (Throwable th3) {
            th = th3;
            aVar = null;
            list = null;
        }
    }

    private com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.animated.base.b bVar, Bitmap.Config config, int i) {
        com.facebook.common.references.a<Bitmap> f = f(bVar.getWidth(), bVar.getHeight(), config);
        new AnimatedImageCompositor(this.pHZ.a(com.facebook.imagepipeline.animated.base.d.a(bVar), null), new AnimatedImageCompositor.a() { // from class: com.facebook.imagepipeline.animated.a.e.1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public void d(int i2, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public com.facebook.common.references.a<Bitmap> PC(int i2) {
                return null;
            }
        }).e(i, f.get());
        return f;
    }

    private List<com.facebook.common.references.a<Bitmap>> a(com.facebook.imagepipeline.animated.base.b bVar, Bitmap.Config config) {
        com.facebook.imagepipeline.animated.base.a a2 = this.pHZ.a(com.facebook.imagepipeline.animated.base.d.a(bVar), null);
        final ArrayList arrayList = new ArrayList(a2.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(a2, new AnimatedImageCompositor.a() { // from class: com.facebook.imagepipeline.animated.a.e.2
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public void d(int i, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public com.facebook.common.references.a<Bitmap> PC(int i) {
                return com.facebook.common.references.a.b((com.facebook.common.references.a) arrayList.get(i));
            }
        });
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < a2.getFrameCount()) {
                com.facebook.common.references.a<Bitmap> f = f(a2.getWidth(), a2.getHeight(), config);
                animatedImageCompositor.e(i2, f.get());
                arrayList.add(f);
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private com.facebook.common.references.a<Bitmap> f(int i, int i2, Bitmap.Config config) {
        com.facebook.common.references.a<Bitmap> g = this.pIT.g(i, i2, config);
        g.get().eraseColor(0);
        if (Build.VERSION.SDK_INT >= 12) {
            g.get().setHasAlpha(true);
        }
        return g;
    }
}
