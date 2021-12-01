package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Loader;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class p {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f59660b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f59661c = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1510835260, "Lcom/kwad/sdk/utils/p;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1510835260, "Lcom/kwad/sdk/utils/p;");
        }
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                com.kwad.sdk.core.d.a.e("EncryptUtils", "EncryptUtils getKey context is null");
                return "";
            }
            if (i2 == 0) {
                str = a;
                str2 = GrowthConstant.UBC_KEY_AES_KEY;
            } else if (i2 == 1) {
                str = f59660b;
                str2 = "rsa_public_key";
            } else if (i2 != 2) {
                str = "";
                str2 = str;
            } else {
                str = f59661c;
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
                        f59660b = a2;
                    } else if (i2 == 2) {
                        f59661c = a2;
                    }
                    return a2;
                }
            }
            return str;
        }
        return (String) invokeI.objValue;
    }

    public static String a(String str, InputStream inputStream) {
        InterceptResult invokeLL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, inputStream)) == null) {
            synchronized (p.class) {
                com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
                oVar.c();
                b2 = oVar.b().b(str);
                oVar.d();
            }
            return b2;
        }
        return (String) invokeLL.objValue;
    }
}
