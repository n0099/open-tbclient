package com.facebook.imagepipeline.b;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class j implements f {
    private static j pKf = null;

    protected j() {
    }

    public static synchronized j ewh() {
        j jVar;
        synchronized (j.class) {
            if (pKf == null) {
                pKf = new j();
            }
            jVar = pKf;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(W(imageRequest.eAo()).toString(), imageRequest.eAq(), imageRequest.eAr(), imageRequest.eAs(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        String str;
        com.facebook.cache.common.b bVar;
        com.facebook.imagepipeline.request.b eAw = imageRequest.eAw();
        if (eAw != null) {
            bVar = eAw.ezx();
            str = eAw.getClass().getName();
        } else {
            str = null;
            bVar = null;
        }
        return new c(W(imageRequest.eAo()).toString(), imageRequest.eAq(), imageRequest.eAr(), imageRequest.eAs(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.eAo(), obj);
    }

    @Override // com.facebook.imagepipeline.b.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(W(uri).toString());
    }

    protected Uri W(Uri uri) {
        return uri;
    }
}
