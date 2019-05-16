package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j jYo = null;

    protected j() {
    }

    public static synchronized j cEr() {
        j jVar;
        synchronized (j.class) {
            if (jYo == null) {
                jYo = new j();
            }
            jVar = jYo;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(J(imageRequest.cIj()).toString(), imageRequest.cIm(), imageRequest.cIn(), imageRequest.cIo(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cIt = imageRequest.cIt();
        if (cIt != null) {
            bVar = cIt.cIB();
            str = cIt.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(J(imageRequest.cIj()).toString(), imageRequest.cIm(), imageRequest.cIn(), imageRequest.cIo(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cIj(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(J(uri).toString());
    }

    protected Uri J(Uri uri) {
        return uri;
    }
}
