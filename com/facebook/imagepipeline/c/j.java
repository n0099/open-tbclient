package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j kgw = null;

    protected j() {
    }

    public static synchronized j cFz() {
        j jVar;
        synchronized (j.class) {
            if (kgw == null) {
                kgw = new j();
            }
            jVar = kgw;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(G(imageRequest.cJs()).toString(), imageRequest.cJv(), imageRequest.cJw(), imageRequest.cJx(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cJC = imageRequest.cJC();
        if (cJC != null) {
            bVar = cJC.cJK();
            str = cJC.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(G(imageRequest.cJs()).toString(), imageRequest.cJv(), imageRequest.cJw(), imageRequest.cJx(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cJs(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(G(uri).toString());
    }

    protected Uri G(Uri uri) {
        return uri;
    }
}
