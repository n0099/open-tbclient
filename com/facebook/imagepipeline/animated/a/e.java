package com.facebook.imagepipeline.animated.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.common.internal.g;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.b.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class e implements d {
    static c lPg;
    static c lPh;
    private final com.facebook.imagepipeline.animated.impl.b lOn;
    private final f lPf;

    static {
        lPg = null;
        lPh = null;
        lPg = OO("com.facebook.animated.gif.GifImage");
        lPh = OO("com.facebook.animated.webp.WebPImage");
    }

    private static c OO(String str) {
        try {
            return (c) Class.forName(str).newInstance();
        } catch (Throwable th) {
            return null;
        }
    }

    public e(com.facebook.imagepipeline.animated.impl.b bVar, f fVar) {
        this.lOn = bVar;
        this.lPf = fVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        if (lPg == null) {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
        com.facebook.common.references.a<PooledByteBuffer> dpk = eVar.dpk();
        g.checkNotNull(dpk);
        try {
            PooledByteBuffer pooledByteBuffer = dpk.get();
            return a(bVar, lPg.z(pooledByteBuffer.djA(), pooledByteBuffer.size()), config);
        } finally {
            com.facebook.common.references.a.c(dpk);
        }
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        if (lPh == null) {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
        com.facebook.common.references.a<PooledByteBuffer> dpk = eVar.dpk();
        g.checkNotNull(dpk);
        try {
            PooledByteBuffer pooledByteBuffer = dpk.get();
            return a(bVar, lPh.z(pooledByteBuffer.djA(), pooledByteBuffer.size()), config);
        } finally {
            com.facebook.common.references.a.c(dpk);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=4] */
    private com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.common.b bVar, com.facebook.imagepipeline.animated.base.b bVar2, Bitmap.Config config) {
        List<com.facebook.common.references.a<Bitmap>> list;
        com.facebook.imagepipeline.g.c aVar;
        com.facebook.common.references.a<Bitmap> aVar2 = null;
        try {
            int frameCount = bVar.lQO ? bVar2.getFrameCount() - 1 : 0;
            if (bVar.lQQ) {
                aVar = new com.facebook.imagepipeline.g.d(a(bVar2, config, frameCount), com.facebook.imagepipeline.g.g.lTn, 0);
                com.facebook.common.references.a.c(null);
                com.facebook.common.references.a.a((Iterable<? extends com.facebook.common.references.a<?>>) null);
            } else {
                if (bVar.lQP) {
                    list = a(bVar2, config);
                    try {
                        aVar2 = com.facebook.common.references.a.b((com.facebook.common.references.a) list.get(frameCount));
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.references.a.c(aVar2);
                        com.facebook.common.references.a.a(list);
                        throw th;
                    }
                } else {
                    list = null;
                }
                if (bVar.lQN && aVar2 == null) {
                    aVar2 = a(bVar2, config, frameCount);
                }
                aVar = new com.facebook.imagepipeline.g.a(com.facebook.imagepipeline.animated.base.d.b(bVar2).j(aVar2).HV(frameCount).eZ(list).dmw());
                com.facebook.common.references.a.c(aVar2);
                com.facebook.common.references.a.a(list);
            }
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            list = null;
        }
    }

    private com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.animated.base.b bVar, Bitmap.Config config, int i) {
        com.facebook.common.references.a<Bitmap> b = b(bVar.getWidth(), bVar.getHeight(), config);
        new AnimatedImageCompositor(this.lOn.a(com.facebook.imagepipeline.animated.base.d.a(bVar), null), new AnimatedImageCompositor.a() { // from class: com.facebook.imagepipeline.animated.a.e.1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public void c(int i2, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public com.facebook.common.references.a<Bitmap> HT(int i2) {
                return null;
            }
        }).d(i, b.get());
        return b;
    }

    private List<com.facebook.common.references.a<Bitmap>> a(com.facebook.imagepipeline.animated.base.b bVar, Bitmap.Config config) {
        com.facebook.imagepipeline.animated.base.a a = this.lOn.a(com.facebook.imagepipeline.animated.base.d.a(bVar), null);
        final ArrayList arrayList = new ArrayList(a.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(a, new AnimatedImageCompositor.a() { // from class: com.facebook.imagepipeline.animated.a.e.2
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public void c(int i, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public com.facebook.common.references.a<Bitmap> HT(int i) {
                return com.facebook.common.references.a.b((com.facebook.common.references.a) arrayList.get(i));
            }
        });
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < a.getFrameCount()) {
                com.facebook.common.references.a<Bitmap> b = b(a.getWidth(), a.getHeight(), config);
                animatedImageCompositor.d(i2, b.get());
                arrayList.add(b);
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private com.facebook.common.references.a<Bitmap> b(int i, int i2, Bitmap.Config config) {
        com.facebook.common.references.a<Bitmap> c = this.lPf.c(i, i2, config);
        c.get().eraseColor(0);
        if (Build.VERSION.SDK_INT >= 12) {
            c.get().setHasAlpha(true);
        }
        return c;
    }
}
