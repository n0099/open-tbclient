package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        int aO;
        if (!com.facebook.imagepipeline.g.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.dFf() == com.facebook.c.b.mPX) {
            aO = aP(b);
        } else {
            aO = aO(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d dGW = imageRequest.dGW();
        float f = dGW != null ? dGW.mSt : 2048.0f;
        while (max / aO > f) {
            if (eVar.dFf() == com.facebook.c.b.mPX) {
                aO *= 2;
            } else {
                aO++;
            }
        }
        return aO;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.d(eVar));
        com.facebook.imagepipeline.common.d dGW = imageRequest.dGW();
        if (dGW == null || dGW.height <= 0 || dGW.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = dGW.width / height;
        float f2 = dGW.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.j("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(dGW.width), Integer.valueOf(dGW.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.dGU().toString());
        return max;
    }

    static int aO(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int aP(float f) {
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
        if (imageRequest.dGX().dDg()) {
            int dFb = eVar.dFb();
            com.facebook.common.internal.g.checkArgument((dFb == 0 || dFb == 90 || dFb == 180 || dFb == 270) ? true : true);
            return dFb;
        }
        return 0;
    }
}
