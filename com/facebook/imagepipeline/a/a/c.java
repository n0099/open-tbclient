package com.facebook.imagepipeline.a.a;

import com.facebook.imagepipeline.b.f;
import com.facebook.imagepipeline.d.e;
/* loaded from: classes2.dex */
public class c {
    private static boolean kif;
    private static b kig = null;

    public static b a(f fVar, e eVar) {
        if (!kif) {
            try {
                kig = (b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport").getConstructor(f.class, e.class).newInstance(fVar, eVar);
            } catch (Throwable th) {
            }
            if (kig != null) {
                kif = true;
                return kig;
            }
            try {
                kig = (b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl").getConstructor(f.class, e.class).newInstance(fVar, eVar);
            } catch (Throwable th2) {
            }
            kif = true;
        }
        return kig;
    }
}
