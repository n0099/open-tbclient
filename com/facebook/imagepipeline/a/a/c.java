package com.facebook.imagepipeline.a.a;

import com.facebook.imagepipeline.b.f;
import com.facebook.imagepipeline.d.e;
/* loaded from: classes2.dex */
public class c {
    private static boolean iol;
    private static b iom = null;

    public static b a(f fVar, e eVar) {
        if (!iol) {
            try {
                iom = (b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImplSupport").getConstructor(f.class, e.class).newInstance(fVar, eVar);
            } catch (Throwable th) {
            }
            if (iom != null) {
                iol = true;
                return iom;
            }
            try {
                iom = (b) Class.forName("com.facebook.imagepipeline.animated.factory.AnimatedFactoryImpl").getConstructor(f.class, e.class).newInstance(fVar, eVar);
            } catch (Throwable th2) {
            }
            iol = true;
        }
        return iom;
    }
}
