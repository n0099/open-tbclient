package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class p {
    public static int b(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        int bb;
        if (!com.facebook.imagepipeline.f.d.d(dVar)) {
            return 1;
        }
        float c = c(imageRequest, dVar);
        if (dVar.cyQ() == com.facebook.c.b.jEV) {
            bb = bc(c);
        } else {
            bb = bb(c);
        }
        int max = Math.max(dVar.getHeight(), dVar.getWidth());
        com.facebook.imagepipeline.common.c cAx = imageRequest.cAx();
        float f = cAx != null ? cAx.jGQ : 2048.0f;
        while (max / bb > f) {
            if (dVar.cyQ() == com.facebook.c.b.jEV) {
                bb *= 2;
            } else {
                bb++;
            }
        }
        return bb;
    }

    static float c(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.d(dVar));
        com.facebook.imagepipeline.common.c cAx = imageRequest.cAx();
        if (cAx == null || cAx.height <= 0 || cAx.width <= 0 || dVar.getWidth() == 0 || dVar.getHeight() == 0) {
            return 1.0f;
        }
        int d = d(imageRequest, dVar);
        boolean z = d == 90 || d == 270;
        int height = z ? dVar.getHeight() : dVar.getWidth();
        int width = z ? dVar.getWidth() : dVar.getHeight();
        float f = cAx.width / height;
        float f2 = cAx.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(cAx.width), Integer.valueOf(cAx.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.cAu().toString());
        return max;
    }

    static int bb(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int bc(float f) {
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
        if (imageRequest.cAy().cxb()) {
            int cyN = dVar.cyN();
            com.facebook.common.internal.g.checkArgument((cyN == 0 || cyN == 90 || cyN == 180 || cyN == 270) ? true : true);
            return cyN;
        }
        return 0;
    }
}
