package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar) {
        int bz;
        if (!com.facebook.imagepipeline.f.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.evB() == com.facebook.c.b.piS) {
            bz = bA(b);
        } else {
            bz = bz(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d exn = imageRequest.exn();
        float f = exn != null ? exn.plc : 2048.0f;
        while (max / bz > f) {
            if (eVar.evB() == com.facebook.c.b.piS) {
                bz *= 2;
            } else {
                bz++;
            }
        }
        return bz;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.d(eVar));
        com.facebook.imagepipeline.common.d exn = imageRequest.exn();
        if (exn == null || exn.height <= 0 || exn.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = exn.width / height;
        float f2 = exn.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.h("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(exn.width), Integer.valueOf(exn.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.exl().toString());
        return max;
    }

    static int bz(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int bA(float f) {
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
        if (imageRequest.exo().etC()) {
            int evx = eVar.evx();
            com.facebook.common.internal.g.checkArgument((evx == 0 || evx == 90 || evx == 180 || evx == 270) ? true : true);
            return evx;
        }
        return 0;
    }
}
