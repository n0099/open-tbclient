package com.facebook.imagepipeline.producers;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes2.dex */
public final class av {
    public static boolean a(int i, int i2, com.facebook.imagepipeline.common.c cVar) {
        return cVar == null ? ((float) Er(i)) >= 2048.0f && Er(i2) >= 2048 : Er(i) >= cVar.width && Er(i2) >= cVar.height;
    }

    public static boolean a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.c cVar) {
        if (dVar == null) {
            return false;
        }
        switch (dVar.cJG()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return a(dVar.getHeight(), dVar.getWidth(), cVar);
            default:
                return a(dVar.getWidth(), dVar.getHeight(), cVar);
        }
    }

    public static int Er(int i) {
        return (int) (i * 1.3333334f);
    }
}
