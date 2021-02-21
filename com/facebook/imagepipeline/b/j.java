package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class j implements f {
    private static j pIa = null;

    protected j() {
    }

    public static synchronized j evY() {
        j jVar;
        synchronized (j.class) {
            if (pIa == null) {
                pIa = new j();
            }
            jVar = pIa;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(W(imageRequest.eAf()).toString(), imageRequest.eAh(), imageRequest.eAi(), imageRequest.eAj(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        String str;
        com.facebook.cache.common.b bVar;
        com.facebook.imagepipeline.request.b eAn = imageRequest.eAn();
        if (eAn != null) {
            bVar = eAn.ezo();
            str = eAn.getClass().getName();
        } else {
            str = null;
            bVar = null;
        }
        return new c(W(imageRequest.eAf()).toString(), imageRequest.eAh(), imageRequest.eAi(), imageRequest.eAj(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.eAf(), obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(W(uri).toString());
    }

    protected Uri W(Uri uri) {
        return uri;
    }
}
