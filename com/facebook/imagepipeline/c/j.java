package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j icX = null;

    protected j() {
    }

    public static synchronized j bUp() {
        j jVar;
        synchronized (j.class) {
            if (icX == null) {
                icX = new j();
            }
            jVar = icX;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(u(imageRequest.bYd()).toString(), imageRequest.bYg(), imageRequest.bYh(), imageRequest.bYi(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b bYn = imageRequest.bYn();
        if (bYn != null) {
            bVar = bYn.bYv();
            str = bYn.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(u(imageRequest.bYd()).toString(), imageRequest.bYg(), imageRequest.bYh(), imageRequest.bYi(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.bYd(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(u(uri).toString());
    }

    protected Uri u(Uri uri) {
        return uri;
    }
}
