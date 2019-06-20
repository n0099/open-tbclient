package com.facebook.imagepipeline.a.a;

import com.facebook.imagepipeline.b.f;
import com.facebook.imagepipeline.d.e;
/* loaded from: classes2.dex */
public class c {
    private static boolean jXw;
    private static b jXx = null;

    public static b a(f fVar, e eVar) {
        if (!jXw) {
            try {
                jXx = (b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport").getConstructor(f.class, e.class).newInstance(fVar, eVar);
            } catch (Throwable th) {
            }
            if (jXx != null) {
                jXw = true;
                return jXx;
            }
            try {
                jXx = (b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl").getConstructor(f.class, e.class).newInstance(fVar, eVar);
            } catch (Throwable th2) {
            }
            jXw = true;
        }
        return jXx;
    }
}
