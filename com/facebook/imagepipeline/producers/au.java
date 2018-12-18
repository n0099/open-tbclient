package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public final class au {
    public static boolean a(int i, int i2, com.facebook.imagepipeline.common.c cVar) {
        return cVar == null ? ((float) yO(i)) >= 2048.0f && yO(i2) >= 2048 : yO(i) >= cVar.width && yO(i2) >= cVar.height;
    }

    public static boolean a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.c cVar) {
        if (dVar == null) {
            return false;
        }
        switch (dVar.bXW()) {
            case 90:
            case 270:
                return a(dVar.getHeight(), dVar.getWidth(), cVar);
            default:
                return a(dVar.getWidth(), dVar.getHeight(), cVar);
        }
    }

    public static int yO(int i) {
        return (int) (i * 1.3333334f);
    }
}
