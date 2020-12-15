package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class j implements f {
    private static j pkH = null;

    protected j() {
    }

    public static synchronized j etf() {
        j jVar;
        synchronized (j.class) {
            if (pkH == null) {
                pkH = new j();
            }
            jVar = pkH;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(V(imageRequest.exm()).toString(), imageRequest.exo(), imageRequest.exp(), imageRequest.exq(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b exu = imageRequest.exu();
        if (exu != null) {
            bVar = exu.ewv();
            str = exu.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(V(imageRequest.exm()).toString(), imageRequest.exo(), imageRequest.exp(), imageRequest.exq(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.exm(), obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(V(uri).toString());
    }

    protected Uri V(Uri uri) {
        return uri;
    }
}
