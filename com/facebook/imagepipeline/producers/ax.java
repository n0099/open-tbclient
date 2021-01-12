package com.facebook.imagepipeline.producers;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes3.dex */
public final class ax {
    public static boolean a(int i, int i2, com.facebook.imagepipeline.common.d dVar) {
        return dVar == null ? ((float) PT(i)) >= 2048.0f && PT(i2) >= 2048 : PT(i) >= dVar.width && PT(i2) >= dVar.height;
    }

    public static boolean a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.d dVar) {
        if (eVar == null) {
            return false;
        }
        switch (eVar.evR()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return a(eVar.getHeight(), eVar.getWidth(), dVar);
            default:
                return a(eVar.getWidth(), eVar.getHeight(), dVar);
        }
    }

    public static int PT(int i) {
        return (int) (i * 1.3333334f);
    }
}
