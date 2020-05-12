package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class j implements f {
    private static j maR = null;

    protected j() {
    }

    public static synchronized j dqu() {
        j jVar;
        synchronized (j.class) {
            if (maR == null) {
                maR = new j();
            }
            jVar = maR;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(P(imageRequest.duJ()).toString(), imageRequest.duL(), imageRequest.duM(), imageRequest.duN(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b duR = imageRequest.duR();
        if (duR != null) {
            bVar = duR.dtQ();
            str = duR.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(P(imageRequest.duJ()).toString(), imageRequest.duL(), imageRequest.duM(), imageRequest.duN(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.duJ(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(P(uri).toString());
    }

    protected Uri P(Uri uri) {
        return uri;
    }
}
