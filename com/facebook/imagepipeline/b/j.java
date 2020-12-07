package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class j implements f {
    private static j pkF = null;

    protected j() {
    }

    public static synchronized j ete() {
        j jVar;
        synchronized (j.class) {
            if (pkF == null) {
                pkF = new j();
            }
            jVar = pkF;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(V(imageRequest.exl()).toString(), imageRequest.exn(), imageRequest.exo(), imageRequest.exp(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b ext = imageRequest.ext();
        if (ext != null) {
            bVar = ext.ewu();
            str = ext.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(V(imageRequest.exl()).toString(), imageRequest.exn(), imageRequest.exo(), imageRequest.exp(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.exl(), obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(V(uri).toString());
    }

    protected Uri V(Uri uri) {
        return uri;
    }
}
