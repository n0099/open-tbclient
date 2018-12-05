package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class p {
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        int aN;
        if (!com.facebook.imagepipeline.f.d.d(dVar)) {
            return 1;
        }
        float c = c(imageRequest, dVar);
        if (dVar.bYa() == com.facebook.c.b.ikK) {
            aN = aO(c);
        } else {
            aN = aN(c);
        }
        int max = Math.max(dVar.getHeight(), dVar.getWidth());
        com.facebook.imagepipeline.common.c bZH = imageRequest.bZH();
        float f = bZH != null ? bZH.imG : 2048.0f;
        while (max / aN > f) {
            if (dVar.bYa() == com.facebook.c.b.ikK) {
                aN *= 2;
            } else {
                aN++;
            }
        }
        return aN;
    }

    static float c(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.d(dVar));
        com.facebook.imagepipeline.common.c bZH = imageRequest.bZH();
        if (bZH == null || bZH.height <= 0 || bZH.width <= 0 || dVar.getWidth() == 0 || dVar.getHeight() == 0) {
            return 1.0f;
        }
        int d = d(imageRequest, dVar);
        boolean z = d == 90 || d == 270;
        int height = z ? dVar.getHeight() : dVar.getWidth();
        int width = z ? dVar.getWidth() : dVar.getHeight();
        float f = bZH.width / height;
        float f2 = bZH.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(bZH.width), Integer.valueOf(bZH.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.bZE().toString());
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

    private static int d(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        boolean z = false;
        if (imageRequest.bZI().bWp()) {
            int bXX = dVar.bXX();
            com.facebook.common.internal.g.checkArgument((bXX == 0 || bXX == 90 || bXX == 180 || bXX == 270) ? true : true);
            return bXX;
        }
        return 0;
    }
}
