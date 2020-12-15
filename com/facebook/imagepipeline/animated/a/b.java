package com.facebook.imagepipeline.animated.a;

import com.facebook.imagepipeline.a.f;
import com.facebook.imagepipeline.b.h;
/* loaded from: classes7.dex */
public class b {
    private static boolean pjs;
    private static a pjt = null;

    public static a a(f fVar, com.facebook.imagepipeline.c.e eVar, h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> hVar) {
        if (!pjs) {
            try {
                pjt = (a) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(f.class, com.facebook.imagepipeline.c.e.class, h.class).newInstance(fVar, eVar, hVar);
            } catch (Throwable th) {
            }
            if (pjt != null) {
                pjs = true;
            }
        }
        return pjt;
    }
}
