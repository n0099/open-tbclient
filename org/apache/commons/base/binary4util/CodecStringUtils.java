package org.apache.commons.base.binary4util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.base.Charsets;
/* loaded from: classes2.dex */
public class CodecStringUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CodecStringUtils() {
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

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, charSequence, charSequence2)) == null) {
            if (charSequence == charSequence2) {
                return true;
            }
            if (charSequence == null || charSequence2 == null) {
                return false;
            }
            if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
                return charSequence.equals(charSequence2);
            }
            return charSequence.length() == charSequence2.length() && CharSequenceUtils.regionMatches(charSequence, false, 0, charSequence2, 0, charSequence.length());
        }
        return invokeLL.booleanValue;
    }

    public static ByteBuffer getByteBuffer(String str, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, charset)) == null) {
            if (str == null) {
                return null;
            }
            return ByteBuffer.wrap(str.getBytes(charset));
        }
        return (ByteBuffer) invokeLL.objValue;
    }

    public static ByteBuffer getByteBufferUtf8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? getByteBuffer(str, Charsets.UTF_8) : (ByteBuffer) invokeL.objValue;
    }

    public static byte[] getBytes(String str, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, charset)) == null) {
            if (str == null) {
                return null;
            }
            return str.getBytes(charset);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] getBytesIso8859_1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? getBytes(str, Charsets.ISO_8859_1) : (byte[]) invokeL.objValue;
    }

    public static byte[] getBytesUnchecked(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return str.getBytes(str2);
            } catch (UnsupportedEncodingException e2) {
                throw newIllegalStateException(str2, e2);
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] getBytesUsAscii(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? getBytes(str, Charsets.US_ASCII) : (byte[]) invokeL.objValue;
    }

    public static byte[] getBytesUtf16(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? getBytes(str, Charsets.UTF_16) : (byte[]) invokeL.objValue;
    }

    public static byte[] getBytesUtf16Be(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? getBytes(str, Charsets.UTF_16BE) : (byte[]) invokeL.objValue;
    }

    public static byte[] getBytesUtf16Le(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? getBytes(str, Charsets.UTF_16LE) : (byte[]) invokeL.objValue;
    }

    public static byte[] getBytesUtf8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? getBytes(str, Charsets.UTF_8) : (byte[]) invokeL.objValue;
    }

    public static IllegalStateException newIllegalStateException(String str, UnsupportedEncodingException unsupportedEncodingException) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, unsupportedEncodingException)) == null) {
            return new IllegalStateException(str + ": " + unsupportedEncodingException);
        }
        return (IllegalStateException) invokeLL.objValue;
    }

    public static String newString(byte[] bArr, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, bArr, charset)) == null) {
            if (bArr == null) {
                return null;
            }
            return new String(bArr, charset);
        }
        return (String) invokeLL.objValue;
    }

    public static String newStringIso8859_1(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bArr)) == null) ? newString(bArr, Charsets.ISO_8859_1) : (String) invokeL.objValue;
    }

    public static String newStringUsAscii(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, bArr)) == null) ? newString(bArr, Charsets.US_ASCII) : (String) invokeL.objValue;
    }

    public static String newStringUtf16(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, bArr)) == null) ? newString(bArr, Charsets.UTF_16) : (String) invokeL.objValue;
    }

    public static String newStringUtf16Be(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, bArr)) == null) ? newString(bArr, Charsets.UTF_16BE) : (String) invokeL.objValue;
    }

    public static String newStringUtf16Le(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, bArr)) == null) ? newString(bArr, Charsets.UTF_16LE) : (String) invokeL.objValue;
    }

    public static String newStringUtf8(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bArr)) == null) ? newString(bArr, Charsets.UTF_8) : (String) invokeL.objValue;
    }

    public static String newString(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, bArr, str)) == null) {
            if (bArr == null) {
                return null;
            }
            try {
                return new String(bArr, str);
            } catch (UnsupportedEncodingException e2) {
                throw newIllegalStateException(str, e2);
            }
        }
        return (String) invokeLL.objValue;
    }
}
