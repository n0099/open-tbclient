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
/* loaded from: classes13.dex */
public class e implements d {
    static c mQy;
    static c mQz;
    private final com.facebook.imagepipeline.animated.impl.b mPD;
    private final f mQx;

    static {
        mQy = null;
        mQz = null;
        mQy = QO("com.facebook.animated.gif.GifImage");
        mQz = QO("com.facebook.animated.webp.WebPImage");
    }

    private static c QO(String str) {
        try {
            return (c) Class.forName(str).newInstance();
        } catch (Throwable th) {
            return null;
        }
    }

    public e(com.facebook.imagepipeline.animated.impl.b bVar, f fVar) {
        this.mPD = bVar;
        this.mQx = fVar;
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        if (mQy == null) {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
        com.facebook.common.references.a<PooledByteBuffer> dFe = eVar.dFe();
        g.checkNotNull(dFe);
        try {
            PooledByteBuffer pooledByteBuffer = dFe.get();
            return a(bVar, mQy.y(pooledByteBuffer.dzs(), pooledByteBuffer.size()), config);
        } finally {
            com.facebook.common.references.a.c(dFe);
        }
    }

    @Override // com.facebook.imagepipeline.animated.a.d
    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar, Bitmap.Config config) {
        if (mQz == null) {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
        com.facebook.common.references.a<PooledByteBuffer> dFe = eVar.dFe();
        g.checkNotNull(dFe);
        try {
            PooledByteBuffer pooledByteBuffer = dFe.get();
            return a(bVar, mQz.y(pooledByteBuffer.dzs(), pooledByteBuffer.size()), config);
        } finally {
            com.facebook.common.references.a.c(dFe);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=4] */
    private com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.common.b bVar, com.facebook.imagepipeline.animated.base.b bVar2, Bitmap.Config config) {
        List<com.facebook.common.references.a<Bitmap>> list;
        com.facebook.imagepipeline.g.c aVar;
        com.facebook.common.references.a<Bitmap> aVar2 = null;
        try {
            int frameCount = bVar.mSh ? bVar2.getFrameCount() - 1 : 0;
            if (bVar.mSj) {
                aVar = new com.facebook.imagepipeline.g.d(a(bVar2, config, frameCount), com.facebook.imagepipeline.g.g.mUN, 0);
                com.facebook.common.references.a.c(null);
                com.facebook.common.references.a.b((Iterable<? extends com.facebook.common.references.a<?>>) null);
            } else {
                if (bVar.mSi) {
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
                if (bVar.mSg && aVar2 == null) {
                    aVar2 = a(bVar2, config, frameCount);
                }
                aVar = new com.facebook.imagepipeline.g.a(com.facebook.imagepipeline.animated.base.d.b(bVar2).j(aVar2).IC(frameCount).fq(list).dCq());
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
        new AnimatedImageCompositor(this.mPD.a(com.facebook.imagepipeline.animated.base.d.a(bVar), null), new AnimatedImageCompositor.a() { // from class: com.facebook.imagepipeline.animated.a.e.1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public void b(int i2, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public com.facebook.common.references.a<Bitmap> IA(int i2) {
                return null;
            }
        }).c(i, b.get());
        return b;
    }

    private List<com.facebook.common.references.a<Bitmap>> a(com.facebook.imagepipeline.animated.base.b bVar, Bitmap.Config config) {
        com.facebook.imagepipeline.animated.base.a a = this.mPD.a(com.facebook.imagepipeline.animated.base.d.a(bVar), null);
        final ArrayList arrayList = new ArrayList(a.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(a, new AnimatedImageCompositor.a() { // from class: com.facebook.imagepipeline.animated.a.e.2
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public void b(int i, Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.a
            public com.facebook.common.references.a<Bitmap> IA(int i) {
                return com.facebook.common.references.a.b((com.facebook.common.references.a) arrayList.get(i));
            }
        });
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < a.getFrameCount()) {
                com.facebook.common.references.a<Bitmap> b = b(a.getWidth(), a.getHeight(), config);
                animatedImageCompositor.c(i2, b.get());
                arrayList.add(b);
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private com.facebook.common.references.a<Bitmap> b(int i, int i2, Bitmap.Config config) {
        com.facebook.common.references.a<Bitmap> c = this.mQx.c(i, i2, config);
        c.get().eraseColor(0);
        if (Build.VERSION.SDK_INT >= 12) {
            c.get().setHasAlpha(true);
        }
        return c;
    }
}
