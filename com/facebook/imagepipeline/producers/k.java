package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class k extends y {
    public k(com.facebook.common.memory.g gVar) {
        super(com.facebook.common.b.a.bUv(), gVar);
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected com.facebook.imagepipeline.f.d e(ImageRequest imageRequest) throws IOException {
        byte[] zF = zF(imageRequest.cbc().toString());
        return c(new ByteArrayInputStream(zF), zF.length);
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected String caA() {
        return "DataFetchProducer";
    }

    static byte[] zF(String str) {
        com.facebook.common.internal.g.checkArgument(str.substring(0, 5).equals("data:"));
        int indexOf = str.indexOf(44);
        String substring = str.substring(indexOf + 1, str.length());
        if (zG(str.substring(0, indexOf))) {
            return Base64.decode(substring, 0);
        }
        return Uri.decode(substring).getBytes();
    }

    static boolean zG(String str) {
        if (!str.contains(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
            return false;
        }
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        return split[split.length - 1].equals("base64");
    }
}
