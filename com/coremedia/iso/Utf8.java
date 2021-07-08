package com.coremedia.iso;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
/* loaded from: classes5.dex */
public final class Utf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Utf8() {
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

    public static byte[] convert(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null) {
                try {
                    return str.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    throw new Error(e2);
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static int utf8StringLengthInBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null) {
                try {
                    return str.getBytes("UTF-8").length;
                } catch (UnsupportedEncodingException unused) {
                    throw new RuntimeException();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String convert(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr != null) {
                try {
                    return new String(bArr, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    throw new Error(e2);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
