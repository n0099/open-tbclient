package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
/* loaded from: classes12.dex */
public class l extends z {
    public l(com.facebook.common.memory.g gVar) {
        super(com.facebook.common.b.a.dkA(), gVar);
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.g.e h(ImageRequest imageRequest) throws IOException {
        byte[] Pe = Pe(imageRequest.dsq().toString());
        return e(new ByteArrayInputStream(Pe), Pe.length);
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String drH() {
        return "DataFetchProducer";
    }

    static byte[] Pe(String str) {
        com.facebook.common.internal.g.checkArgument(str.substring(0, 5).equals("data:"));
        int indexOf = str.indexOf(44);
        String substring = str.substring(indexOf + 1, str.length());
        if (isBase64(str.substring(0, indexOf))) {
            return Base64.decode(substring, 0);
        }
        return Uri.decode(substring).getBytes();
    }

    static boolean isBase64(String str) {
        if (!str.contains(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
            return false;
        }
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        return split[split.length - 1].equals("base64");
    }
}
