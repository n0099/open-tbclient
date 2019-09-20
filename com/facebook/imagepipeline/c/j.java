package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j kjc = null;

    protected j() {
    }

    public static synchronized j cIE() {
        j jVar;
        synchronized (j.class) {
            if (kjc == null) {
                kjc = new j();
            }
            jVar = kjc;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(J(imageRequest.cMx()).toString(), imageRequest.cMA(), imageRequest.cMB(), imageRequest.cMC(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cMH = imageRequest.cMH();
        if (cMH != null) {
            bVar = cMH.cMP();
            str = cMH.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(J(imageRequest.cMx()).toString(), imageRequest.cMA(), imageRequest.cMB(), imageRequest.cMC(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cMx(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(J(uri).toString());
    }

    protected Uri J(Uri uri) {
        return uri;
    }
}
