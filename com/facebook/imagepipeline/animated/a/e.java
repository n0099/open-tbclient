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
/* loaded from: classes3.dex */
public class e implements d {
    static c pGP;
    static c pGQ;
    private final com.facebook.imagepipeline.animated.impl.b pFU;
    private final f pGO;

    static {
        pGP = null;
        pGQ = null;
        pGP = ZF("com.facebook.animated.gif.GifImage");
        pGQ = ZF("com.facebook.animated.webp.WebPImage");
    }

    private static c ZF(String str) {
        try {
            return (c) Class.forName(str).newInstance();
        } catch (Throwable th) {
            return null;
        }
    }

    public e(com.facebook.imagepipeline.animated.impl.b bVar, f fVar) {
        this.pFU = bVar;
        this.pGO = fVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        if (pGP == null) {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
        com.facebook.common.references.a<PooledByteBuffer> eyv = eVar.eyv();
        g.checkNotNull(eyv);
        try {
            PooledByteBuffer pooledByteBuffer = eyv.get();
            return a(bVar, pGP.M(pooledByteBuffer.esO(), pooledByteBuffer.size()), config);
        } finally {
            com.facebook.common.references.a.c(eyv);
        }
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        if (pGQ == null) {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
        com.facebook.common.references.a<PooledByteBuffer> eyv = eVar.eyv();
        g.checkNotNull(eyv);
        try {
            PooledByteBuffer pooledByteBuffer = eyv.get();
            return a(bVar, pGQ.M(pooledByteBuffer.esO(), pooledByteBuffer.size()), config);
        } finally {
            com.facebook.common.references.a.c(eyv);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=4] */
    private com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.common.b bVar, com.facebook.imagepipeline.animated.base.b bVar2, Bitmap.Config config) {
        com.facebook.common.references.a<Bitmap> aVar;
        List<com.facebook.common.references.a<Bitmap>> list;
        com.facebook.imagepipeline.f.c aVar2;
        try {
            int frameCount = bVar.pIm ? bVar2.getFrameCount() - 1 : 0;
            if (bVar.pIo) {
                aVar2 = new com.facebook.imagepipeline.f.d(a(bVar2, config, frameCount), com.facebook.imagepipeline.f.g.pKJ, 0);
                com.facebook.common.references.a.c(null);
                com.facebook.common.references.a.b((Iterable<? extends com.facebook.common.references.a<?>>) null);
            } else {
                if (bVar.pIn) {
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
                    if (bVar.pIl && aVar == null) {
                        aVar = a(bVar2, config, frameCount);
                    }
                    aVar2 = new com.facebook.imagepipeline.f.a(com.facebook.imagepipeline.animated.base.d.b(bVar2).j(aVar).PA(frameCount).gK(list).evJ());
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
        new AnimatedImageCompositor(this.pFU.a(com.facebook.imagepipeline.animated.base.d.a(bVar), null), new AnimatedImageCompositor.a() { // from class: com.facebook.imagepipeline.animated.a.e.1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public void d(int i2, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public com.facebook.common.references.a<Bitmap> Py(int i2) {
                return null;
            }
        }).e(i, f.get());
        return f;
    }

    private List<com.facebook.common.references.a<Bitmap>> a(com.facebook.imagepipeline.animated.base.b bVar, Bitmap.Config config) {
        com.facebook.imagepipeline.animated.base.a a2 = this.pFU.a(com.facebook.imagepipeline.animated.base.d.a(bVar), null);
        final ArrayList arrayList = new ArrayList(a2.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(a2, new AnimatedImageCompositor.a() { // from class: com.facebook.imagepipeline.animated.a.e.2
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public void d(int i, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public com.facebook.common.references.a<Bitmap> Py(int i) {
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
        com.facebook.common.references.a<Bitmap> g = this.pGO.g(i, i2, config);
        g.get().eraseColor(0);
        if (Build.VERSION.SDK_INT >= 12) {
            g.get().setHasAlpha(true);
        }
        return g;
    }
}
