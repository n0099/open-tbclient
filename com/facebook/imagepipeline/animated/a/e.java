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
/* loaded from: classes12.dex */
public class e implements d {
    static c pjt;
    static c pju;
    private final com.facebook.imagepipeline.animated.impl.b piy;
    private final f pjs;

    static {
        pjt = null;
        pju = null;
        pjt = Zp("com.facebook.animated.gif.GifImage");
        pju = Zp("com.facebook.animated.webp.WebPImage");
    }

    private static c Zp(String str) {
        try {
            return (c) Class.forName(str).newInstance();
        } catch (Throwable th) {
            return null;
        }
    }

    public e(com.facebook.imagepipeline.animated.impl.b bVar, f fVar) {
        this.piy = bVar;
        this.pjs = fVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        if (pjt == null) {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
        com.facebook.common.references.a<PooledByteBuffer> evA = eVar.evA();
        g.checkNotNull(evA);
        try {
            PooledByteBuffer pooledByteBuffer = evA.get();
            return a(bVar, pjt.M(pooledByteBuffer.epX(), pooledByteBuffer.size()), config);
        } finally {
            com.facebook.common.references.a.c(evA);
        }
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        if (pju == null) {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
        com.facebook.common.references.a<PooledByteBuffer> evA = eVar.evA();
        g.checkNotNull(evA);
        try {
            PooledByteBuffer pooledByteBuffer = evA.get();
            return a(bVar, pju.M(pooledByteBuffer.epX(), pooledByteBuffer.size()), config);
        } finally {
            com.facebook.common.references.a.c(evA);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=4] */
    private com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.common.b bVar, com.facebook.imagepipeline.animated.base.b bVar2, Bitmap.Config config) {
        List<com.facebook.common.references.a<Bitmap>> list;
        com.facebook.imagepipeline.f.c aVar;
        com.facebook.common.references.a<Bitmap> aVar2 = null;
        try {
            int frameCount = bVar.pkR ? bVar2.getFrameCount() - 1 : 0;
            if (bVar.pkT) {
                aVar = new com.facebook.imagepipeline.f.d(a(bVar2, config, frameCount), com.facebook.imagepipeline.f.g.pnp, 0);
                com.facebook.common.references.a.c(null);
                com.facebook.common.references.a.b((Iterable<? extends com.facebook.common.references.a<?>>) null);
            } else {
                if (bVar.pkS) {
                    list = a(bVar2, config);
                    try {
                        aVar2 = com.facebook.common.references.a.b(list.get(frameCount));
                    } catch (Throwable th) {
                        th = th;
                        com.facebook.common.references.a.c(aVar2);
                        com.facebook.common.references.a.b(list);
                        throw th;
                    }
                } else {
                    list = null;
                }
                if (bVar.pkQ && aVar2 == null) {
                    aVar2 = a(bVar2, config, frameCount);
                }
                aVar = new com.facebook.imagepipeline.f.a(com.facebook.imagepipeline.animated.base.d.b(bVar2).j(aVar2).Qx(frameCount).gP(list).esQ());
                com.facebook.common.references.a.c(aVar2);
                com.facebook.common.references.a.b(list);
            }
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            list = null;
        }
    }

    private com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.animated.base.b bVar, Bitmap.Config config, int i) {
        com.facebook.common.references.a<Bitmap> b = b(bVar.getWidth(), bVar.getHeight(), config);
        new AnimatedImageCompositor(this.piy.a(com.facebook.imagepipeline.animated.base.d.a(bVar), null), new AnimatedImageCompositor.a() { // from class: com.facebook.imagepipeline.animated.a.e.1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public void c(int i2, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public com.facebook.common.references.a<Bitmap> Qv(int i2) {
                return null;
            }
        }).d(i, b.get());
        return b;
    }

    private List<com.facebook.common.references.a<Bitmap>> a(com.facebook.imagepipeline.animated.base.b bVar, Bitmap.Config config) {
        com.facebook.imagepipeline.animated.base.a a2 = this.piy.a(com.facebook.imagepipeline.animated.base.d.a(bVar), null);
        final ArrayList arrayList = new ArrayList(a2.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(a2, new AnimatedImageCompositor.a() { // from class: com.facebook.imagepipeline.animated.a.e.2
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public void c(int i, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public com.facebook.common.references.a<Bitmap> Qv(int i) {
                return com.facebook.common.references.a.b((com.facebook.common.references.a) arrayList.get(i));
            }
        });
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < a2.getFrameCount()) {
                com.facebook.common.references.a<Bitmap> b = b(a2.getWidth(), a2.getHeight(), config);
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
        com.facebook.common.references.a<Bitmap> c = this.pjs.c(i, i2, config);
        c.get().eraseColor(0);
        if (Build.VERSION.SDK_INT >= 12) {
            c.get().setHasAlpha(true);
        }
        return c;
    }
}
