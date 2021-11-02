package com.tencent.mm.opensdk.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                char[] cArr2 = new char[digest.length * 2];
                int i2 = 0;
                for (byte b2 : digest) {
                    int i3 = i2 + 1;
                    cArr2[i2] = cArr[(b2 >>> 4) & 15];
                    i2 = i3 + 1;
                    cArr2[i3] = cArr[b2 & 15];
                }
                return new String(cArr2);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
