package com.facebook.imagepipeline.animated.a;

import com.facebook.imagepipeline.b.f;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes12.dex */
public class b {
    private static boolean lPd;
    private static a lPe = null;

    public static a a(f fVar, com.facebook.imagepipeline.d.e eVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar) {
        if (!lPd) {
            try {
                lPe = (a) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(f.class, com.facebook.imagepipeline.d.e.class, h.class).newInstance(fVar, eVar, hVar);
            } catch (Throwable th) {
            }
            if (lPe != null) {
                lPd = true;
            }
        }
        return lPe;
    }
}
