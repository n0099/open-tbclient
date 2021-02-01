package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar) {
        int bO;
        if (!com.facebook.imagepipeline.f.e.d(eVar)) {
            return 1;
        }
        float b2 = b(imageRequest, eVar);
        if (eVar.eyo() == com.facebook.c.b.pFO) {
            bO = bP(b2);
        } else {
            bO = bO(b2);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d ezZ = imageRequest.ezZ();
        float f = ezZ != null ? ezZ.pHW : 2048.0f;
        while (max / bO > f) {
            if (eVar.eyo() == com.facebook.c.b.pFO) {
                bO *= 2;
            } else {
                bO++;
            }
        }
        return bO;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.d(eVar));
        com.facebook.imagepipeline.common.d ezZ = imageRequest.ezZ();
        if (ezZ == null || ezZ.height <= 0 || ezZ.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = ezZ.width / height;
        float f2 = ezZ.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.f("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(ezZ.width), Integer.valueOf(ezZ.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.ezX().toString());
        return max;
    }

    static int bO(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int bP(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (i * 2)) * 0.3333333432674408d) + (1.0d / (i * 2)) > f) {
            i *= 2;
        }
        return i;
    }

    private static int c(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar) {
        boolean z = false;
        if (imageRequest.eAa().ewo()) {
            int eyk = eVar.eyk();
            com.facebook.common.internal.g.checkArgument((eyk == 0 || eyk == 90 || eyk == 180 || eyk == 270) ? true : true);
            return eyk;
        }
        return 0;
    }
}
