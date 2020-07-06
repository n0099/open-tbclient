package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class j implements f {
    private static j mRU = null;

    protected j() {
    }

    public static synchronized j dCG() {
        j jVar;
        synchronized (j.class) {
            if (mRU == null) {
                mRU = new j();
            }
            jVar = mRU;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(S(imageRequest.dGU()).toString(), imageRequest.dGW(), imageRequest.dGX(), imageRequest.dGY(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b dHc = imageRequest.dHc();
        if (dHc != null) {
            bVar = dHc.dGb();
            str = dHc.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(S(imageRequest.dGU()).toString(), imageRequest.dGW(), imageRequest.dGX(), imageRequest.dGY(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dGU(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(S(uri).toString());
    }

    protected Uri S(Uri uri) {
        return uri;
    }
}
