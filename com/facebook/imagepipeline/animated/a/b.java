package com.facebook.imagepipeline.animated.a;

import com.facebook.imagepipeline.b.f;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes13.dex */
public class b {
    private static boolean mtj;
    private static a mtk = null;

    public static a a(f fVar, com.facebook.imagepipeline.d.e eVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        if (!mtj) {
            try {
                mtk = (a) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(f.class, com.facebook.imagepipeline.d.e.class, h.class).newInstance(fVar, eVar, hVar);
            } catch (Throwable th) {
            }
            if (mtk != null) {
                mtj = true;
            }
        }
        return mtk;
    }
}
