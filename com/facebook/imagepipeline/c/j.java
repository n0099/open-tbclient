package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class j implements f {
    private static j lQB = null;

    protected j() {
    }

    public static synchronized j dmK() {
        j jVar;
        synchronized (j.class) {
            if (lQB == null) {
                lQB = new j();
            }
            jVar = lQB;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(K(imageRequest.drc()).toString(), imageRequest.dre(), imageRequest.drf(), imageRequest.drg(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b drl = imageRequest.drl();
        if (drl != null) {
            bVar = drl.dqi();
            str = drl.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(K(imageRequest.drc()).toString(), imageRequest.dre(), imageRequest.drf(), imageRequest.drg(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.drc(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(K(uri).toString());
    }

    protected Uri K(Uri uri) {
        return uri;
    }
}
