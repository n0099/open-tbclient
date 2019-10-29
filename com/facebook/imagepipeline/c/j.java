package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j khn = null;

    protected j() {
    }

    public static synchronized j cFB() {
        j jVar;
        synchronized (j.class) {
            if (khn == null) {
                khn = new j();
            }
            jVar = khn;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(G(imageRequest.cJu()).toString(), imageRequest.cJx(), imageRequest.cJy(), imageRequest.cJz(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cJE = imageRequest.cJE();
        if (cJE != null) {
            bVar = cJE.cJM();
            str = cJE.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(G(imageRequest.cJu()).toString(), imageRequest.cJx(), imageRequest.cJy(), imageRequest.cJz(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cJu(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(G(uri).toString());
    }

    protected Uri G(Uri uri) {
        return uri;
    }
}
