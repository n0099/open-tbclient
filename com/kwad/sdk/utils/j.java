package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Loader;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static String f11123a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f11124b = "";
    private static String c = "";

    public static String a(int i) {
        String str;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            com.kwad.sdk.core.d.a.d("EncryptUtils", "EncryptUtils getKey context is null");
            return "";
        }
        String str2 = "";
        switch (i) {
            case 0:
                str = "aes_key";
                str2 = f11123a;
                break;
            case 1:
                str = "rsa_public_key";
                str2 = f11124b;
                break;
            case 2:
                str = "rsa_private_key";
                str2 = c;
                break;
            default:
                str = "";
                break;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.d.a.d("EncryptUtils", "EncryptUtils getKey get id is error ");
            }
            try {
                InputStream open = Loader.get().getExternalResource().getAssets().open("ksad_common_encrypt_image.png");
                if (open == null) {
                    open = context.getAssets().open("ksad_common_encrypt_image.png");
                }
                String a2 = a(str, open);
                if (TextUtils.isEmpty(a2)) {
                    com.kwad.sdk.core.d.a.d("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
                }
                switch (i) {
                    case 0:
                        f11123a = a2;
                        return a2;
                    case 1:
                        f11124b = a2;
                        return a2;
                    case 2:
                        c = a2;
                        return a2;
                    default:
                        return a2;
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.b(th);
                return "";
            }
        }
        return str2;
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
