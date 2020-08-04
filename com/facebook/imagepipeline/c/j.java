package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class j implements f {
    private static j nad = null;

    protected j() {
    }

    public static synchronized j dFT() {
        j jVar;
        synchronized (j.class) {
            if (nad == null) {
                nad = new j();
            }
            jVar = nad;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(R(imageRequest.dKh()).toString(), imageRequest.dKj(), imageRequest.dKk(), imageRequest.dKl(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b dKp = imageRequest.dKp();
        if (dKp != null) {
            bVar = dKp.dJo();
            str = dKp.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(R(imageRequest.dKh()).toString(), imageRequest.dKj(), imageRequest.dKk(), imageRequest.dKl(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dKh(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(R(uri).toString());
    }

    protected Uri R(Uri uri) {
        return uri;
    }
}
