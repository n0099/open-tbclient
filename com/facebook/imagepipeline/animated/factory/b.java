package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.a.f;
import com.facebook.imagepipeline.b.h;
import com.facebook.imagepipeline.c.e;
import com.facebook.imagepipeline.f.c;
/* loaded from: classes6.dex */
public class b {
    private static boolean pzq;
    private static a pzr = null;

    public static a a(f fVar, e eVar, h<com.facebook.cache.common.b, c> hVar) {
        if (!pzq) {
            try {
                pzr = (a) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(f.class, e.class, h.class).newInstance(fVar, eVar, hVar);
            } catch (Throwable th) {
            }
            if (pzr != null) {
                pzq = true;
            }
        }
        return pzr;
    }
}
