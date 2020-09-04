package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class j implements f {
    private static j nuk = null;

    protected j() {
    }

    public static synchronized j dSb() {
        j jVar;
        synchronized (j.class) {
            if (nuk == null) {
                nuk = new j();
            }
            jVar = nuk;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(R(imageRequest.dWp()).toString(), imageRequest.dWr(), imageRequest.dWs(), imageRequest.dWt(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b dWx = imageRequest.dWx();
        if (dWx != null) {
            bVar = dWx.dVw();
            str = dWx.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(R(imageRequest.dWp()).toString(), imageRequest.dWr(), imageRequest.dWs(), imageRequest.dWt(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dWp(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(R(uri).toString());
    }

    protected Uri R(Uri uri) {
        return uri;
    }
}
