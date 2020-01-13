package com.facebook.imagepipeline.producers;
/* loaded from: classes10.dex */
public final class ax {
    public static boolean a(int i, int i2, com.facebook.imagepipeline.common.d dVar) {
        return dVar == null ? ((float) IK(i)) >= 2048.0f && IK(i2) >= 2048 : IK(i) >= dVar.width && IK(i2) >= dVar.height;
    }

    public static boolean a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.d dVar) {
        if (eVar == null) {
            return false;
        }
        switch (eVar.dpf()) {
            case 90:
            case 270:
                return a(eVar.getHeight(), eVar.getWidth(), dVar);
            default:
                return a(eVar.getWidth(), eVar.getHeight(), dVar);
        }
    }

    public static int IK(int i) {
        return (int) (i * 1.3333334f);
    }
}
