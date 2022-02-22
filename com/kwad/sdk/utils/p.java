package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Loader;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class p {
    public static String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f58167b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f58168c = "";

    public static String a(int i2) {
        String str;
        String str2;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            com.kwad.sdk.core.d.a.e("EncryptUtils", "EncryptUtils getKey context is null");
            return "";
        }
        if (i2 == 0) {
            str = a;
            str2 = GrowthConstant.UBC_KEY_AES_KEY;
        } else if (i2 == 1) {
            str = f58167b;
            str2 = "rsa_public_key";
        } else if (i2 != 2) {
            str = "";
            str2 = str;
        } else {
            str = f58168c;
            str2 = "rsa_private_key";
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                com.kwad.sdk.core.d.a.e("EncryptUtils", "EncryptUtils getKey get id is error ");
            }
            try {
                InputStream open = Loader.get().getExternalResource().getAssets().open("ksad_common_encrypt_image.png");
                if (open == null) {
                    open = context.getAssets().open("ksad_common_encrypt_image.png");
                }
                String a2 = a(str2, open);
                if (TextUtils.isEmpty(a2)) {
                    com.kwad.sdk.core.d.a.e("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
                }
                if (i2 == 0) {
                    a = a2;
                } else if (i2 == 1) {
                    f58167b = a2;
                } else if (i2 == 2) {
                    f58168c = a2;
                }
                return a2;
            }
        }
        return str;
    }

    public static String a(String str, InputStream inputStream) {
        String b2;
        synchronized (p.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.c();
            b2 = oVar.b().b(str);
            oVar.d();
        }
        return b2;
    }
}
