package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j jFV = null;

    protected j() {
    }

    public static synchronized j cwp() {
        j jVar;
        synchronized (j.class) {
            if (jFV == null) {
                jFV = new j();
            }
            jVar = jFV;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(D(imageRequest.cAh()).toString(), imageRequest.cAk(), imageRequest.cAl(), imageRequest.cAm(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cAr = imageRequest.cAr();
        if (cAr != null) {
            bVar = cAr.cAz();
            str = cAr.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(D(imageRequest.cAh()).toString(), imageRequest.cAk(), imageRequest.cAl(), imageRequest.cAm(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cAh(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(D(uri).toString());
    }

    protected Uri D(Uri uri) {
        return uri;
    }
}
