package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        int aJ;
        if (!com.facebook.imagepipeline.g.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.dsT() == com.facebook.c.b.lYQ) {
            aJ = aK(b);
        } else {
            aJ = aJ(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d duL = imageRequest.duL();
        float f = duL != null ? duL.mbp : 2048.0f;
        while (max / aJ > f) {
            if (eVar.dsT() == com.facebook.c.b.lYQ) {
                aJ *= 2;
            } else {
                aJ++;
            }
        }
        return aJ;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.d(eVar));
        com.facebook.imagepipeline.common.d duL = imageRequest.duL();
        if (duL == null || duL.height <= 0 || duL.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = duL.width / height;
        float f2 = duL.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.j("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(duL.width), Integer.valueOf(duL.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.duJ().toString());
        return max;
    }

    static int aJ(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int aK(float f) {
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
        if (imageRequest.duM().dqU()) {
            int dsP = eVar.dsP();
            com.facebook.common.internal.g.checkArgument((dsP == 0 || dsP == 90 || dsP == 180 || dsP == 270) ? true : true);
            return dsP;
        }
        return 0;
    }
}
