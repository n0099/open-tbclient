package com.repackage;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public class xm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    int i = b & 255;
                    if (i < 16) {
                        sb.append(0);
                    }
                    sb.append(Integer.toHexString(i));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String b(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, str, j)) == null) ? a(String.format("%d%s%d", 1, str.toLowerCase(), Long.valueOf(j))) : (String) invokeLJ.objValue;
    }
}
