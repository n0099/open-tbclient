package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        int aN;
        if (!com.facebook.imagepipeline.g.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.dIs() == com.facebook.c.b.mYh) {
            aN = aO(b);
        } else {
            aN = aN(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d dKj = imageRequest.dKj();
        float f = dKj != null ? dKj.naB : 2048.0f;
        while (max / aN > f) {
            if (eVar.dIs() == com.facebook.c.b.mYh) {
                aN *= 2;
            } else {
                aN++;
            }
        }
        return aN;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.d(eVar));
        com.facebook.imagepipeline.common.d dKj = imageRequest.dKj();
        if (dKj == null || dKj.height <= 0 || dKj.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = dKj.width / height;
        float f2 = dKj.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.j("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(dKj.width), Integer.valueOf(dKj.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.dKh().toString());
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

    private static int c(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        boolean z = false;
        if (imageRequest.dKk().dGt()) {
            int dIo = eVar.dIo();
            com.facebook.common.internal.g.checkArgument((dIo == 0 || dIo == 90 || dIo == 180 || dIo == 270) ? true : true);
            return dIo;
        }
        return 0;
    }
}
