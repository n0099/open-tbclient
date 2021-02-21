package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public final class ax {
    public static boolean a(int i, int i2, com.facebook.imagepipeline.common.d dVar) {
        return dVar == null ? ((float) Qp(i)) >= 2048.0f && Qp(i2) >= 2048 : Qp(i) >= dVar.width && Qp(i2) >= dVar.height;
    }

    public static boolean a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.d dVar) {
        if (eVar == null) {
            return false;
        }
        switch (eVar.eys()) {
            case 90:
            case 270:
                return a(eVar.getHeight(), eVar.getWidth(), dVar);
            default:
                return a(eVar.getWidth(), eVar.getHeight(), dVar);
        }
    }

    public static int Qp(int i) {
        return (int) (i * 1.3333334f);
    }
}
