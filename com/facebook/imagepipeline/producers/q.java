package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        int aN;
        if (!com.facebook.imagepipeline.g.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.dIr() == com.facebook.c.b.mYf) {
            aN = aO(b);
        } else {
            aN = aN(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d dKi = imageRequest.dKi();
        float f = dKi != null ? dKi.naz : 2048.0f;
        while (max / aN > f) {
            if (eVar.dIr() == com.facebook.c.b.mYf) {
                aN *= 2;
            } else {
                aN++;
            }
        }
        return aN;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.d(eVar));
        com.facebook.imagepipeline.common.d dKi = imageRequest.dKi();
        if (dKi == null || dKi.height <= 0 || dKi.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = dKi.width / height;
        float f2 = dKi.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.j("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(dKi.width), Integer.valueOf(dKi.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.dKg().toString());
        return max;
    }

    static int aN(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int aO(float f) {
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
        if (imageRequest.dKj().dGs()) {
            int dIn = eVar.dIn();
            com.facebook.common.internal.g.checkArgument((dIn == 0 || dIn == 90 || dIn == 180 || dIn == 270) ? true : true);
            return dIn;
        }
        return 0;
    }
}
