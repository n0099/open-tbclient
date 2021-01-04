package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class j implements f {
    private static j pAl = null;

    protected j() {
    }

    public static synchronized j ewO() {
        j jVar;
        synchronized (j.class) {
            if (pAl == null) {
                pAl = new j();
            }
            jVar = pAl;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(Z(imageRequest.eAT()).toString(), imageRequest.eAV(), imageRequest.eAW(), imageRequest.eAX(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        String str;
        com.facebook.cache.common.b bVar;
        com.facebook.imagepipeline.request.b eBb = imageRequest.eBb();
        if (eBb != null) {
            bVar = eBb.eAc();
            str = eBb.getClass().getName();
        } else {
            str = null;
            bVar = null;
        }
        return new c(Z(imageRequest.eAT()).toString(), imageRequest.eAV(), imageRequest.eAW(), imageRequest.eAX(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.eAT(), obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(Z(uri).toString());
    }

    protected Uri Z(Uri uri) {
        return uri;
    }
}
