package com.dxmpay.wallet.core.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.armor.SecurePay;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public final class VerSig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public VerSig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if ("MD5".equalsIgnoreCase(str)) {
                return 4;
            }
            if ("SHA-1".equalsIgnoreCase(str)) {
                return 5;
            }
            if ("SHA-256".equalsIgnoreCase(str)) {
                return 11;
            }
            if ("SHA-384".equalsIgnoreCase(str)) {
                return 12;
            }
            return "SHA-512".equalsIgnoreCase(str) ? 13 : 0;
        }
        return invokeL.intValue;
    }

    public static boolean b(byte[] bArr, byte[] bArr2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bArr, bArr2, str)) == null) {
            if (bArr == null || bArr2 == null) {
                return false;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    byte[] digest = MessageDigest.getInstance(str.toUpperCase()).digest(bArr2);
                    if (SecurePay.getInstance().rsaVerify(0, a(str), digest.length, digest, Base64.decode(bArr, 0)) != 0) {
                        return false;
                    }
                } catch (IllegalArgumentException | NoSuchAlgorithmException unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean verify(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return false;
            }
            return b(str.getBytes(), str2.getBytes(), str3);
        }
        return invokeLLL.booleanValue;
    }
}
