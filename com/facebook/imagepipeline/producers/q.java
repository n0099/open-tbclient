package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class q {
    public static int a(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        int bq;
        if (!com.facebook.imagepipeline.g.e.d(eVar)) {
            return 1;
        }
        float b = b(imageRequest, eVar);
        if (eVar.emh() == com.facebook.c.b.oIX) {
            bq = br(b);
        } else {
            bq = bq(b);
        }
        int max = Math.max(eVar.getHeight(), eVar.getWidth());
        com.facebook.imagepipeline.common.d enZ = imageRequest.enZ();
        float f = enZ != null ? enZ.oLr : 2048.0f;
        while (max / bq > f) {
            if (eVar.emh() == com.facebook.c.b.oIX) {
                bq *= 2;
            } else {
                bq++;
            }
        }
        return bq;
    }

    static float b(ImageRequest imageRequest, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.d(eVar));
        com.facebook.imagepipeline.common.d enZ = imageRequest.enZ();
        if (enZ == null || enZ.height <= 0 || enZ.width <= 0 || eVar.getWidth() == 0 || eVar.getHeight() == 0) {
            return 1.0f;
        }
        int c = c(imageRequest, eVar);
        boolean z = c == 90 || c == 270;
        int height = z ? eVar.getHeight() : eVar.getWidth();
        int width = z ? eVar.getWidth() : eVar.getHeight();
        float f = enZ.width / height;
        float f2 = enZ.height / width;
        float max = Math.max(f, f2);
        com.facebook.common.c.a.h("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(enZ.width), Integer.valueOf(enZ.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max), imageRequest.enX().toString());
        return max;
    }

    static int bq(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (((1.0d / (Math.pow(i, 2.0d) - i)) * 0.3333333432674408d) + (1.0d / i) > f) {
            i++;
        }
        return i - 1;
    }

    static int br(float f) {
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
        if (imageRequest.eoa().eki()) {
            int emd = eVar.emd();
            com.facebook.common.internal.g.checkArgument((emd == 0 || emd == 90 || emd == 180 || emd == 270) ? true : true);
            return emd;
        }
        return 0;
    }
}
