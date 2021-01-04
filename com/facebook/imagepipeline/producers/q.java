package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar) {
        int bL;
        if (!com.facebook.imagepipeline.f.e.d(eVar)) {
            return 1;
        }
        float b2 = b(imageRequest, eVar);
        if (eVar.ezj() == com.facebook.c.b.pyV) {
            bL = bM(b2);
        } else {
            bL = bL(b2);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d eAV = imageRequest.eAV();
        float f = eAV != null ? eAV.pAH : 2048.0f;
        while (max / bL > f) {
            if (eVar.ezj() == com.facebook.c.b.pyV) {
                bL *= 2;
            } else {
                bL++;
            }
        }
        return bL;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.d(eVar));
        com.facebook.imagepipeline.common.d eAV = imageRequest.eAV();
        if (eAV == null || eAV.height <= 0 || eAV.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = eAV.width / height;
        float f2 = eAV.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.f("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(eAV.width), Integer.valueOf(eAV.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.eAT().toString());
        return max;
    }

    static int bL(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int bM(float f) {
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
        if (imageRequest.eAW().exm()) {
            int ezf = eVar.ezf();
            com.facebook.common.internal.g.checkArgument((ezf == 0 || ezf == 90 || ezf == 180 || ezf == 270) ? true : true);
            return ezf;
        }
        return 0;
    }
}
