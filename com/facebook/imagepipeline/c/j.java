package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j jGo = null;

    protected j() {
    }

    public static synchronized j cwz() {
        j jVar;
        synchronized (j.class) {
            if (jGo == null) {
                jGo = new j();
            }
            jVar = jGo;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(D(imageRequest.cAr()).toString(), imageRequest.cAu(), imageRequest.cAv(), imageRequest.cAw(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cAB = imageRequest.cAB();
        if (cAB != null) {
            bVar = cAB.cAJ();
            str = cAB.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(D(imageRequest.cAr()).toString(), imageRequest.cAu(), imageRequest.cAv(), imageRequest.cAw(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cAr(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(D(uri).toString());
    }

    protected Uri D(Uri uri) {
        return uri;
    }
}
