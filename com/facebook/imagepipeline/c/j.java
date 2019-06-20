package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j jYs = null;

    protected j() {
    }

    public static synchronized j cEs() {
        j jVar;
        synchronized (j.class) {
            if (jYs == null) {
                jYs = new j();
            }
            jVar = jYs;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(J(imageRequest.cIk()).toString(), imageRequest.cIn(), imageRequest.cIo(), imageRequest.cIp(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cIu = imageRequest.cIu();
        if (cIu != null) {
            bVar = cIu.cIC();
            str = cIu.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(J(imageRequest.cIk()).toString(), imageRequest.cIn(), imageRequest.cIo(), imageRequest.cIp(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cIk(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(J(uri).toString());
    }

    protected Uri J(Uri uri) {
        return uri;
    }
}
