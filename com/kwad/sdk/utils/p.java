package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;
/* loaded from: classes10.dex */
public class p {
    public static String aNj = "";
    public static String aNk = "";
    public static String aNl = "";

    public static String a(String str, InputStream inputStream) {
        String fF;
        synchronized (p.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.IE();
            fF = oVar.ID().fF(str);
            oVar.end();
        }
        return fF;
    }

    public static String dA(int i) {
        Context Jn = ServiceProvider.Jn();
        String str = aNj;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(GrowthConstant.UBC_KEY_AES_KEY)) {
            com.kwad.sdk.core.e.c.e("EncryptUtils", "EncryptUtils getKey get id is error ");
        }
        try {
            InputStream open = Jn.getResources().getAssets().open("ksad_common_encrypt_image.png");
            if (open == null) {
                open = Jn.getAssets().open("ksad_common_encrypt_image.png");
            }
            String a = a(GrowthConstant.UBC_KEY_AES_KEY, open);
            if (TextUtils.isEmpty(a)) {
                com.kwad.sdk.core.e.c.e("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
            }
            aNj = a;
            return a;
        }
    }
}
