package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class n {
    public static String a = "";
    public static String b = "";
    public static String c = "";

    public static String a(int i) {
        String str;
        String str2;
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        if (a2 == null) {
            com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey context is null");
            return "";
        }
        if (i == 0) {
            str = a;
            str2 = GrowthConstant.UBC_KEY_AES_KEY;
        } else if (i == 1) {
            str = b;
            str2 = "rsa_public_key";
        } else if (i != 2) {
            str = "";
            str2 = str;
        } else {
            str = c;
            str2 = "rsa_private_key";
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey get id is error ");
            }
            try {
                InputStream open = a2.getResources().getAssets().open("ksad_common_encrypt_image.png");
                if (open == null) {
                    open = a2.getAssets().open("ksad_common_encrypt_image.png");
                }
                String a3 = a(str2, open);
                if (TextUtils.isEmpty(a3)) {
                    com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
                }
                if (i == 0) {
                    a = a3;
                } else if (i == 1) {
                    b = a3;
                } else if (i == 2) {
                    c = a3;
                }
                return a3;
            }
        }
        return str;
    }

    public static String a(String str, InputStream inputStream) {
        String a2;
        synchronized (n.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.b();
            a2 = oVar.a().a(str);
            oVar.c();
        }
        return a2;
    }
}
