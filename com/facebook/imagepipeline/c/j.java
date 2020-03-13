package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class j implements f {
    private static j lRv = null;

    protected j() {
    }

    public static synchronized j doa() {
        j jVar;
        synchronized (j.class) {
            if (lRv == null) {
                lRv = new j();
            }
            jVar = lRv;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(L(imageRequest.dsr()).toString(), imageRequest.dst(), imageRequest.dsu(), imageRequest.dsv(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b dsA = imageRequest.dsA();
        if (dsA != null) {
            bVar = dsA.drx();
            str = dsA.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(L(imageRequest.dsr()).toString(), imageRequest.dst(), imageRequest.dsu(), imageRequest.dsv(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dsr(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(L(uri).toString());
    }

    protected Uri L(Uri uri) {
        return uri;
    }
}
