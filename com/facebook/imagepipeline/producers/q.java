package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        int aI;
        if (!com.facebook.imagepipeline.g.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.dAl() == com.facebook.c.b.msL) {
            aI = aJ(b);
        } else {
            aI = aI(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d dCc = imageRequest.dCc();
        float f = dCc != null ? dCc.mvg : 2048.0f;
        while (max / aI > f) {
            if (eVar.dAl() == com.facebook.c.b.msL) {
                aI *= 2;
            } else {
                aI++;
            }
        }
        return aI;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.d(eVar));
        com.facebook.imagepipeline.common.d dCc = imageRequest.dCc();
        if (dCc == null || dCc.height <= 0 || dCc.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = dCc.width / height;
        float f2 = dCc.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.j("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(dCc.width), Integer.valueOf(dCc.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.dCa().toString());
        return max;
    }

    static int aI(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int aJ(float f) {
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
        if (imageRequest.dCd().dym()) {
            int dAh = eVar.dAh();
            com.facebook.common.internal.g.checkArgument((dAh == 0 || dAh == 90 || dAh == 180 || dAh == 270) ? true : true);
            return dAh;
        }
        return 0;
    }
}
