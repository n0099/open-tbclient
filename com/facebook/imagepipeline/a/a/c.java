package com.facebook.imagepipeline.a.a;

import com.facebook.imagepipeline.b.f;
import com.facebook.imagepipeline.d.e;
/* loaded from: classes2.dex */
public class c {
    private static boolean icb;
    private static b icc = null;

    public static b a(f fVar, e eVar) {
        if (!icb) {
            try {
                icc = (b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport").getConstructor(f.class, e.class).newInstance(fVar, eVar);
            } catch (Throwable th) {
            }
            if (icc != null) {
                icb = true;
                return icc;
            }
            try {
                icc = (b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl").getConstructor(f.class, e.class).newInstance(fVar, eVar);
            } catch (Throwable th2) {
            }
            icb = true;
        }
        return icc;
    }
}
