package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes8.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        int aT;
        if (!com.facebook.imagepipeline.g.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.dUr() == com.facebook.c.b.nrW) {
            aT = aU(b);
        } else {
            aT = aT(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d dWi = imageRequest.dWi();
        float f = dWi != null ? dWi.nur : 2048.0f;
        while (max / aT > f) {
            if (eVar.dUr() == com.facebook.c.b.nrW) {
                aT *= 2;
            } else {
                aT++;
            }
        }
        return aT;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.d(eVar));
        com.facebook.imagepipeline.common.d dWi = imageRequest.dWi();
        if (dWi == null || dWi.height <= 0 || dWi.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = dWi.width / height;
        float f2 = dWi.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.h("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(dWi.width), Integer.valueOf(dWi.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.dWg().toString());
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
        if (imageRequest.dWj().dSs()) {
            int dUn = eVar.dUn();
            com.facebook.common.internal.g.checkArgument((dUn == 0 || dUn == 90 || dUn == 180 || dUn == 270) ? true : true);
            return dUn;
        }
        return 0;
    }
}
