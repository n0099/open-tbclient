package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes25.dex */
public class j implements f {
    private static j nEi = null;

    protected j() {
    }

    public static synchronized j dVZ() {
        j jVar;
        synchronized (j.class) {
            if (nEi == null) {
                nEi = new j();
            }
            jVar = nEi;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(T(imageRequest.ean()).toString(), imageRequest.eap(), imageRequest.eaq(), imageRequest.ear(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b eav = imageRequest.eav();
        if (eav != null) {
            bVar = eav.dZu();
            str = eav.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(T(imageRequest.ean()).toString(), imageRequest.eap(), imageRequest.eaq(), imageRequest.ear(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.ean(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(T(uri).toString());
    }

    protected Uri T(Uri uri) {
        return uri;
    }
}
