package com.facebook.imagepipeline.a.a;

import com.facebook.imagepipeline.b.f;
import com.facebook.imagepipeline.d.e;
/* loaded from: classes2.dex */
public class c {
    private static boolean idP;
    private static b idQ = null;

    public static b a(f fVar, e eVar) {
        if (!idP) {
            try {
                idQ = (b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport").getConstructor(f.class, e.class).newInstance(fVar, eVar);
            } catch (Throwable th) {
            }
            if (idQ != null) {
                idP = true;
                return idQ;
            }
            try {
                idQ = (b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl").getConstructor(f.class, e.class).newInstance(fVar, eVar);
            } catch (Throwable th2) {
            }
            idP = true;
        }
        return idQ;
    }
}
