package com.facebook.imagepipeline.animated.a;

import com.facebook.imagepipeline.a.f;
import com.facebook.imagepipeline.b.h;
/* loaded from: classes5.dex */
public class b {
    private static boolean pIR;
    private static a pIS = null;

    public static a a(f fVar, com.facebook.imagepipeline.c.e eVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> hVar) {
        if (!pIR) {
            try {
                pIS = (a) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(f.class, com.facebook.imagepipeline.c.e.class, h.class).newInstance(fVar, eVar, hVar);
            } catch (Throwable th) {
            }
            if (pIS != null) {
                pIR = true;
            }
        }
        return pIS;
    }
}
