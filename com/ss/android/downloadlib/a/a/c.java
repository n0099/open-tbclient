package com.ss.android.downloadlib.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(CharSequence charSequence, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, charSequence, str)) == null) ? a(charSequence.toString().getBytes(), str) : (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) ? a(new ByteArrayInputStream(bArr), str) : (byte[]) invokeLL.objValue;
    }

    public static byte[] a(InputStream inputStream, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, inputStream, str)) != null) {
            return (byte[]) invokeLL.objValue;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return messageDigest.digest();
            }
            messageDigest.update(bArr, 0, read);
        }
    }
}
