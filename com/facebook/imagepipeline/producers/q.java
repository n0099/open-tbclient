package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes25.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        int aT;
        if (!com.facebook.imagepipeline.g.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.dYy() == com.facebook.c.b.nCm) {
            aT = aU(b);
        } else {
            aT = aT(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d eap = imageRequest.eap();
        float f = eap != null ? eap.nEG : 2048.0f;
        while (max / aT > f) {
            if (eVar.dYy() == com.facebook.c.b.nCm) {
                aT *= 2;
            } else {
                aT++;
            }
        }
        return aT;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.d(eVar));
        com.facebook.imagepipeline.common.d eap = imageRequest.eap();
        if (eap == null || eap.height <= 0 || eap.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = eap.width / height;
        float f2 = eap.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.h("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(eap.width), Integer.valueOf(eap.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.ean().toString());
        return max;
    }

    static int aT(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int aU(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (i * 2)) * 0.3333333432674408d) + (1.0d / (i * 2)) > f) {
            i *= 2;
        }
        return i;
    }

    private static int c(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        boolean z = false;
        if (imageRequest.eaq().dWz()) {
            int dYu = eVar.dYu();
            com.facebook.common.internal.g.checkArgument((dYu == 0 || dYu == 90 || dYu == 180 || dYu == 270) ? true : true);
            return dYu;
        }
        return 0;
    }
}
