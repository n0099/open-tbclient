package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class n {
    public static String ani = "";
    public static String anj = "";
    public static String ank = "";

    public static String a(String str, InputStream inputStream) {
        String dv;
        synchronized (n.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.yB();
            dv = oVar.yA().dv(str);
            oVar.end();
        }
        return dv;
    }

    public static String bA(int i) {
        String str;
        String str2;
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            com.kwad.sdk.core.e.b.e("EncryptUtils", "EncryptUtils getKey context is null");
            return "";
        }
        if (i == 0) {
            str = ani;
            str2 = GrowthConstant.UBC_KEY_AES_KEY;
        } else if (i == 1) {
            str = anj;
            str2 = "rsa_public_key";
        } else if (i != 2) {
            str = "";
            str2 = str;
        } else {
            str = ank;
            str2 = "rsa_private_key";
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                com.kwad.sdk.core.e.b.e("EncryptUtils", "EncryptUtils getKey get id is error ");
            }
            try {
                InputStream open = context.getResources().getAssets().open("ksad_common_encrypt_image.png");
                if (open == null) {
                    open = context.getAssets().open("ksad_common_encrypt_image.png");
                }
                String a = a(str2, open);
                if (TextUtils.isEmpty(a)) {
                    com.kwad.sdk.core.e.b.e("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
                }
                if (i == 0) {
                    ani = a;
                } else if (i == 1) {
                    anj = a;
                } else if (i == 2) {
                    ank = a;
                }
                return a;
            }
        }
        return str;
    }
}
