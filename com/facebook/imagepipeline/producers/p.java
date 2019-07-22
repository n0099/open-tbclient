package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class p {
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        int bg;
        if (!com.facebook.imagepipeline.f.d.d(dVar)) {
            return 1;
        }
        float c = c(imageRequest, dVar);
        if (dVar.cJJ() == com.facebook.c.b.kel) {
            bg = bh(c);
        } else {
            bg = bg(c);
        }
        int max = Math.max(dVar.getHeight(), dVar.getWidth());
        com.facebook.imagepipeline.common.c cLr = imageRequest.cLr();
        float f = cLr != null ? cLr.kgi : 2048.0f;
        while (max / bg > f) {
            if (dVar.cJJ() == com.facebook.c.b.kel) {
                bg *= 2;
            } else {
                bg++;
            }
        }
        return bg;
    }

    static float c(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.d(dVar));
        com.facebook.imagepipeline.common.c cLr = imageRequest.cLr();
        if (cLr == null || cLr.height <= 0 || cLr.width <= 0 || dVar.getWidth() == 0 || dVar.getHeight() == 0) {
            return 1.0f;
        }
        int d = d(imageRequest, dVar);
        boolean z = d == 90 || d == 270;
        int height = z ? dVar.getHeight() : dVar.getWidth();
        int width = z ? dVar.getWidth() : dVar.getHeight();
        float f = cLr.width / height;
        float f2 = cLr.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(cLr.width), Integer.valueOf(cLr.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.cLo().toString());
        return max;
    }

    static int bg(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int bh(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (i * 2)) * 0.3333333432674408d) + (1.0d / (i * 2)) > f) {
            i *= 2;
        }
        return i;
    }

    private static int d(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        boolean z = false;
        if (imageRequest.cLs().cHU()) {
            int cJG = dVar.cJG();
            com.facebook.common.internal.g.checkArgument((cJG == 0 || cJG == 90 || cJG == 180 || cJG == 270) ? true : true);
            return cJG;
        }
        return 0;
    }
}
