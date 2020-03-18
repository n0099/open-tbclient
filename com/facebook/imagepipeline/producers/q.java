package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        int bt;
        if (!com.facebook.imagepipeline.g.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.dqX() == com.facebook.c.b.lRh) {
            bt = bu(b);
        } else {
            bt = bt(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d dsQ = imageRequest.dsQ();
        float f = dsQ != null ? dsQ.lTy : 2048.0f;
        while (max / bt > f) {
            if (eVar.dqX() == com.facebook.c.b.lRh) {
                bt *= 2;
            } else {
                bt++;
            }
        }
        return bt;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.d(eVar));
        com.facebook.imagepipeline.common.d dsQ = imageRequest.dsQ();
        if (dsQ == null || dsQ.height <= 0 || dsQ.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = dsQ.width / height;
        float f2 = dsQ.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.f("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(dsQ.width), Integer.valueOf(dsQ.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.dsO().toString());
        return max;
    }

    static int bt(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int bu(float f) {
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
        if (imageRequest.dsR().doX()) {
            int dqT = eVar.dqT();
            com.facebook.common.internal.g.checkArgument((dqT == 0 || dqT == 90 || dqT == 180 || dqT == 270) ? true : true);
            return dqT;
        }
        return 0;
    }
}
