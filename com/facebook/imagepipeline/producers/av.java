package com.facebook.imagepipeline.producers;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes2.dex */
public final class av {
    public static boolean a(int i, int i2, com.facebook.imagepipeline.common.c cVar) {
        return cVar == null ? ((float) CQ(i)) >= 2048.0f && CQ(i2) >= 2048 : CQ(i) >= cVar.width && CQ(i2) >= cVar.height;
    }

    public static boolean a(com.facebook.imagepipeline.f.d dVar, com.facebook.imagepipeline.common.c cVar) {
        if (dVar == null) {
            return false;
        }
        switch (dVar.cyN()) {
            case 90:
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return a(dVar.getHeight(), dVar.getWidth(), cVar);
            default:
                return a(dVar.getWidth(), dVar.getHeight(), cVar);
        }
    }

    public static int CQ(int i) {
        return (int) (i * 1.3333334f);
    }
}
