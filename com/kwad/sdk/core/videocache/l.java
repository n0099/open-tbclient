package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
            if (TextUtils.isEmpty(fileExtensionFromUrl)) {
                return null;
            }
            return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i2])));
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public static void a(byte[] bArr, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bArr, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            j.a(bArr, "Buffer must be not null!");
            boolean z = true;
            j.a(j >= 0, "Data offset must be positive!");
            j.a((i2 < 0 || i2 > bArr.length) ? false : false, "Length must be in range [0..buffer.length]");
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("Error encoding url", e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("Error decoding url", e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            try {
                return a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
            } catch (NoSuchAlgorithmException e2) {
                throw new IllegalStateException(e2);
            }
        }
        return (String) invokeL.objValue;
    }
}
