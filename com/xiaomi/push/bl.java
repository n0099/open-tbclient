package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes8.dex */
public class bl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65536, null, b2)) == null) {
            int i2 = (b2 & ByteCompanionObject.MAX_VALUE) + (b2 < 0 ? 128 : 0);
            StringBuilder sb = new StringBuilder();
            sb.append(i2 < 16 ? "0" : "");
            sb.append(Integer.toHexString(i2).toLowerCase());
            return sb.toString();
        }
        return (String) invokeB.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                StringBuffer stringBuffer = new StringBuffer();
                messageDigest.update(str.getBytes(), 0, str.length());
                for (byte b2 : messageDigest.digest()) {
                    stringBuffer.append(a(b2));
                }
                return stringBuffer.toString();
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? a(str).subSequence(8, 24).toString() : (String) invokeL.objValue;
    }
}
