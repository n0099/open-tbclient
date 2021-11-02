package com.ss.android.socialbase.appdownloader.f;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.downloader.i.f;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            byte[] decode = Base64.decode(f.a(str), 0);
            int length = str2.length();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (byte b2 : decode) {
                if (i2 >= length) {
                    i2 %= length;
                }
                sb.append((char) (b2 ^ str2.charAt(i2)));
                i2++;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new String(Base64.decode(f.a(str), 0));
        }
        return (String) invokeL.objValue;
    }
}
