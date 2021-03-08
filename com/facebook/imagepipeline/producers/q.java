package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar) {
        int bS;
        if (!com.facebook.imagepipeline.f.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.eyF() == com.facebook.c.b.pIt) {
            bS = bT(b);
        } else {
            bS = bS(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d eAq = imageRequest.eAq();
        float f = eAq != null ? eAq.pKB : 2048.0f;
        while (max / bS > f) {
            if (eVar.eyF() == com.facebook.c.b.pIt) {
                bS *= 2;
            } else {
                bS++;
            }
        }
        return bS;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.d(eVar));
        com.facebook.imagepipeline.common.d eAq = imageRequest.eAq();
        if (eAq == null || eAq.height <= 0 || eAq.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = eAq.width / height;
        float f2 = eAq.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.f("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(eAq.width), Integer.valueOf(eAq.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.eAo().toString());
        return max;
    }

    static int bS(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int bT(float f) {
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
        if (imageRequest.eAr().ewF()) {
            int eyB = eVar.eyB();
            com.facebook.common.internal.g.checkArgument((eyB == 0 || eyB == 90 || eyB == 180 || eyB == 270) ? true : true);
            return eyB;
        }
        return 0;
    }
}
