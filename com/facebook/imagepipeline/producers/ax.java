package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public final class ax {
    public static boolean a(int i, int i2, com.facebook.imagepipeline.common.d dVar) {
        return dVar == null ? ((float) PP(i)) >= 2048.0f && PP(i2) >= 2048 : PP(i) >= dVar.width && PP(i2) >= dVar.height;
    }

    public static boolean a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.d dVar) {
        if (eVar == null) {
            return false;
        }
        switch (eVar.epU()) {
            case 90:
            case 270:
                return a(eVar.getHeight(), eVar.getWidth(), dVar);
            default:
                return a(eVar.getWidth(), eVar.getHeight(), dVar);
        }
    }

    public static int PP(int i) {
        return (int) (i * 1.3333334f);
    }
}
