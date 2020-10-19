package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        int aZ;
        if (!com.facebook.imagepipeline.g.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.ecj() == com.facebook.c.b.nRF) {
            aZ = ba(b);
        } else {
            aZ = aZ(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d eea = imageRequest.eea();
        float f = eea != null ? eea.nTZ : 2048.0f;
        while (max / aZ > f) {
            if (eVar.ecj() == com.facebook.c.b.nRF) {
                aZ *= 2;
            } else {
                aZ++;
            }
        }
        return aZ;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.d(eVar));
        com.facebook.imagepipeline.common.d eea = imageRequest.eea();
        if (eea == null || eea.height <= 0 || eea.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = eea.width / height;
        float f2 = eea.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.h("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(eea.width), Integer.valueOf(eea.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.edY().toString());
        return max;
    }

    static int aZ(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int ba(float f) {
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
        if (imageRequest.eeb().eak()) {
            int ecf = eVar.ecf();
            com.facebook.common.internal.g.checkArgument((ecf == 0 || ecf == 90 || ecf == 180 || ecf == 270) ? true : true);
            return ecf;
        }
        return 0;
    }
}
