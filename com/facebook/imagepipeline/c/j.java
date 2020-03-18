package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class j implements f {
    private static j lTb = null;

    protected j() {
    }

    public static synchronized j dox() {
        j jVar;
        synchronized (j.class) {
            if (lTb == null) {
                lTb = new j();
            }
            jVar = lTb;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(L(imageRequest.dsO()).toString(), imageRequest.dsQ(), imageRequest.dsR(), imageRequest.dsS(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b dsX = imageRequest.dsX();
        if (dsX != null) {
            bVar = dsX.drU();
            str = dsX.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(L(imageRequest.dsO()).toString(), imageRequest.dsQ(), imageRequest.dsR(), imageRequest.dsS(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dsO(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(L(uri).toString());
    }

    protected Uri L(Uri uri) {
        return uri;
    }
}
