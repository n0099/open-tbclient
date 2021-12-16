package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, ArrayList<String>> a;

    /* renamed from: b  reason: collision with root package name */
    public static String f60225b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1510835539, "Lcom/kwad/sdk/utils/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1510835539, "Lcom/kwad/sdk/utils/g;");
                return;
            }
        }
        a = new HashMap<>();
    }

    @Nullable
    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (TextUtils.isEmpty(f60225b)) {
                ArrayList<String> a2 = a(context, "SHA1");
                if (a2 != null && a2.size() != 0) {
                    f60225b = a2.get(0);
                }
                return f60225b;
            }
            return f60225b;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Signature signature, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, signature, str)) == null) {
            byte[] byteArray = signature.toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : digest) {
                        sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                        sb.append(":");
                    }
                    return sb.substring(0, sb.length() - 1);
                }
                return "error!";
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.e("AppSigningUtil", e2.getMessage());
                return "error!";
            }
        }
        return (String) invokeLL.objValue;
    }

    @Nullable
    public static ArrayList<String> a(Context context, String str) {
        InterceptResult invokeLL;
        Signature[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            ArrayList<String> arrayList = null;
            if (context != null && str != null) {
                String packageName = context.getPackageName();
                if (packageName == null) {
                    return null;
                }
                if (a.get(str) != null) {
                    return a.get(str);
                }
                arrayList = new ArrayList<>();
                try {
                    for (Signature signature : b(context, packageName)) {
                        String str2 = "error!";
                        if ("MD5".equals(str)) {
                            str2 = a(signature, "MD5");
                        } else if ("SHA1".equals(str)) {
                            str2 = a(signature, "SHA1");
                        } else if ("SHA256".equals(str)) {
                            str2 = a(signature, "SHA256");
                        }
                        arrayList.add(str2);
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.e("AppSigningUtil", "签名信息列表获取失败 " + e2.getMessage());
                }
                a.put(str, arrayList);
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static Signature[] b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 64).signatures;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.e("AppSigningUtil", e2.getMessage());
                return null;
            }
        }
        return (Signature[]) invokeLL.objValue;
    }
}
