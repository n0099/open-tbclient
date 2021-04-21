package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Loader;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static String f37163a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f37164b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f37165c = "";

    public static String a(int i) {
        String str;
        String str2;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            com.kwad.sdk.core.d.a.d(EncryptUtils.TAG, "EncryptUtils getKey context is null");
            return "";
        }
        if (i == 0) {
            str = f37163a;
            str2 = "aes_key";
        } else if (i == 1) {
            str = f37164b;
            str2 = "rsa_public_key";
        } else if (i != 2) {
            str = "";
            str2 = str;
        } else {
            str = f37165c;
            str2 = "rsa_private_key";
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                com.kwad.sdk.core.d.a.d(EncryptUtils.TAG, "EncryptUtils getKey get id is error ");
            }
            try {
                InputStream open = Loader.get().getExternalResource().getAssets().open("ksad_common_encrypt_image.png");
                if (open == null) {
                    open = context.getAssets().open("ksad_common_encrypt_image.png");
                }
                String a2 = a(str2, open);
                if (TextUtils.isEmpty(a2)) {
                    com.kwad.sdk.core.d.a.d(EncryptUtils.TAG, "EncryptUtils getKey get encryptedKey is invalid ");
                }
                if (i == 0) {
                    f37163a = a2;
                } else if (i == 1) {
                    f37164b = a2;
                } else if (i == 2) {
                    f37165c = a2;
                }
                return a2;
            }
        }
        return str;
    }

    public static String a(String str, InputStream inputStream) {
        String b2;
        synchronized (j.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.c();
            b2 = oVar.b().b(str);
            oVar.d();
        }
        return b2;
    }
}
