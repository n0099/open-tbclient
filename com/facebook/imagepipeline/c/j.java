package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class j implements f {
    private static j mvS = null;

    protected j() {
    }

    public static synchronized j dya() {
        j jVar;
        synchronized (j.class) {
            if (mvS == null) {
                mvS = new j();
            }
            jVar = mvS;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(R(imageRequest.dCo()).toString(), imageRequest.dCq(), imageRequest.dCr(), imageRequest.dCs(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b dCw = imageRequest.dCw();
        if (dCw != null) {
            bVar = dCw.dBv();
            str = dCw.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(R(imageRequest.dCo()).toString(), imageRequest.dCq(), imageRequest.dCr(), imageRequest.dCs(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dCo(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(R(uri).toString());
    }

    protected Uri R(Uri uri) {
        return uri;
    }
}
