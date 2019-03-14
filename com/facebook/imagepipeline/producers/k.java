package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class k extends y {
    public k(com.facebook.common.memory.g gVar) {
        super(com.facebook.common.b.a.ctG(), gVar);
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected com.facebook.imagepipeline.f.d h(ImageRequest imageRequest) throws IOException {
        byte[] FJ = FJ(imageRequest.cAu().toString());
        return d(new ByteArrayInputStream(FJ), FJ.length);
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected String czS() {
        return "DataFetchProducer";
    }

    static byte[] FJ(String str) {
        com.facebook.common.internal.g.checkArgument(str.substring(0, 5).equals(WebGLImageLoader.DATA_URL));
        int indexOf = str.indexOf(44);
        String substring = str.substring(indexOf + 1, str.length());
        if (FK(str.substring(0, indexOf))) {
            return Base64.decode(substring, 0);
        }
        return Uri.decode(substring).getBytes();
    }

    static boolean FK(String str) {
        if (!str.contains(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
            return false;
        }
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        return split[split.length - 1].equals("base64");
    }
}
