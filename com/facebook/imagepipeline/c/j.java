package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j jYp = null;

    protected j() {
    }

    public static synchronized j cEt() {
        j jVar;
        synchronized (j.class) {
            if (jYp == null) {
                jYp = new j();
            }
            jVar = jYp;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(J(imageRequest.cIl()).toString(), imageRequest.cIo(), imageRequest.cIp(), imageRequest.cIq(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cIv = imageRequest.cIv();
        if (cIv != null) {
            bVar = cIv.cID();
            str = cIv.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(J(imageRequest.cIl()).toString(), imageRequest.cIo(), imageRequest.cIp(), imageRequest.cIq(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cIl(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(J(uri).toString());
    }

    protected Uri J(Uri uri) {
        return uri;
    }
}
