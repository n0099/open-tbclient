package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class j implements f {
    private static j pBS = null;

    protected j() {
    }

    public static synchronized j exq() {
        j jVar;
        synchronized (j.class) {
            if (pBS == null) {
                pBS = new j();
            }
            jVar = pBS;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(Z(imageRequest.eBx()).toString(), imageRequest.eBz(), imageRequest.eBA(), imageRequest.eBB(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        String str;
        com.facebook.cache.common.b bVar;
        com.facebook.imagepipeline.request.b eBF = imageRequest.eBF();
        if (eBF != null) {
            bVar = eBF.eAG();
            str = eBF.getClass().getName();
        } else {
            str = null;
            bVar = null;
        }
        return new c(Z(imageRequest.eBx()).toString(), imageRequest.eBz(), imageRequest.eBA(), imageRequest.eBB(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.eBx(), obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(Z(uri).toString());
    }

    protected Uri Z(Uri uri) {
        return uri;
    }
}
