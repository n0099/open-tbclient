package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class j implements f {
    private static j pxs = null;

    protected j() {
    }

    public static synchronized j ety() {
        j jVar;
        synchronized (j.class) {
            if (pxs == null) {
                pxs = new j();
            }
            jVar = pxs;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(W(imageRequest.exF()).toString(), imageRequest.exH(), imageRequest.exI(), imageRequest.exJ(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        String str;
        com.facebook.cache.common.b bVar;
        com.facebook.imagepipeline.request.b exN = imageRequest.exN();
        if (exN != null) {
            bVar = exN.ewO();
            str = exN.getClass().getName();
        } else {
            str = null;
            bVar = null;
        }
        return new c(W(imageRequest.exF()).toString(), imageRequest.exH(), imageRequest.exI(), imageRequest.exJ(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.exF(), obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(W(uri).toString());
    }

    protected Uri W(Uri uri) {
        return uri;
    }
}
