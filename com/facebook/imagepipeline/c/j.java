package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class j implements f {
    private static j nab = null;

    protected j() {
    }

    public static synchronized j dFS() {
        j jVar;
        synchronized (j.class) {
            if (nab == null) {
                nab = new j();
            }
            jVar = nab;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(R(imageRequest.dKg()).toString(), imageRequest.dKi(), imageRequest.dKj(), imageRequest.dKk(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b dKo = imageRequest.dKo();
        if (dKo != null) {
            bVar = dKo.dJn();
            str = dKo.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(R(imageRequest.dKg()).toString(), imageRequest.dKi(), imageRequest.dKj(), imageRequest.dKk(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dKg(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(R(uri).toString());
    }

    protected Uri R(Uri uri) {
        return uri;
    }
}
