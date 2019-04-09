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
        if (dVar.cyJ() == com.facebook.c.b.jEq) {
            bb = bc(c);
        } else {
            bb = bb(c);
        }
        int max = Math.max(dVar.getHeight(), dVar.getWidth());
        com.facebook.imagepipeline.common.c cAq = imageRequest.cAq();
        float f = cAq != null ? cAq.jGl : 2048.0f;
        while (max / bb > f) {
            if (dVar.cyJ() == com.facebook.c.b.jEq) {
                bb *= 2;
            } else {
                bb++;
            }
        }
        return bb;
    }

    static float c(ImageRequest imageRequest, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.d(dVar));
        com.facebook.imagepipeline.common.c cAq = imageRequest.cAq();
        if (cAq == null || cAq.height <= 0 || cAq.width <= 0 || dVar.getWidth() == 0 || dVar.getHeight() == 0) {
            return 1.0f;
        }
        int d = d(imageRequest, dVar);
        boolean z = d == 90 || d == 270;
        int height = z ? dVar.getHeight() : dVar.getWidth();
        int width = z ? dVar.getWidth() : dVar.getHeight();
        float f = cAq.width / height;
        float f2 = cAq.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(cAq.width), Integer.valueOf(cAq.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.cAn().toString());
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
        if (imageRequest.cAr().cwU()) {
            int cyG = dVar.cyG();
            com.facebook.common.internal.g.checkArgument((cyG == 0 || cyG == 90 || cyG == 180 || cyG == 270) ? true : true);
            return cyG;
        }
        return 0;
    }
}
