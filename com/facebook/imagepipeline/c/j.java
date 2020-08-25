package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class j implements f {
    private static j ntS = null;

    protected j() {
    }

    public static synchronized j dRS() {
        j jVar;
        synchronized (j.class) {
            if (ntS == null) {
                ntS = new j();
            }
            jVar = ntS;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(R(imageRequest.dWg()).toString(), imageRequest.dWi(), imageRequest.dWj(), imageRequest.dWk(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b dWo = imageRequest.dWo();
        if (dWo != null) {
            bVar = dWo.dVn();
            str = dWo.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(R(imageRequest.dWg()).toString(), imageRequest.dWi(), imageRequest.dWj(), imageRequest.dWk(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dWg(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(R(uri).toString());
    }

    protected Uri R(Uri uri) {
        return uri;
    }
}
