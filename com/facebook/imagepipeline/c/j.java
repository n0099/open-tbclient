package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class j implements f {
    private static j mRR = null;

    protected j() {
    }

    public static synchronized j dCC() {
        j jVar;
        synchronized (j.class) {
            if (mRR == null) {
                mRR = new j();
            }
            jVar = mRR;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(S(imageRequest.dGQ()).toString(), imageRequest.dGS(), imageRequest.dGT(), imageRequest.dGU(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b dGY = imageRequest.dGY();
        if (dGY != null) {
            bVar = dGY.dFX();
            str = dGY.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(S(imageRequest.dGQ()).toString(), imageRequest.dGS(), imageRequest.dGT(), imageRequest.dGU(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dGQ(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(S(uri).toString());
    }

    protected Uri S(Uri uri) {
        return uri;
    }
}
