package org.apache.commons.codec.binary4util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.base.BinaryDecoder;
import org.apache.commons.base.BinaryEncoder;
import org.apache.commons.base.Charsets;
import org.apache.commons.base.DecoderException;
import org.apache.commons.base.EncoderException;
/* loaded from: classes8.dex */
public class Hex implements BinaryEncoder, BinaryDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Charset DEFAULT_CHARSET;
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";
    public static final char[] DIGITS_LOWER;
    public static final char[] DIGITS_UPPER;
    public transient /* synthetic */ FieldHolder $fh;
    public final Charset charset;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(434825636, "Lorg/apache/commons/codec/binary4util/Hex;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(434825636, "Lorg/apache/commons/codec/binary4util/Hex;");
                return;
            }
        }
        DEFAULT_CHARSET = Charsets.UTF_8;
        DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public Hex() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.charset = DEFAULT_CHARSET;
    }

    public Charset getCharset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.charset;
        }
        return (Charset) invokeV.objValue;
    }

    public String getCharsetName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.charset.name();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Hex(String str) {
        this(Charset.forName(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Charset) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static byte[] decodeHex(char[] cArr) throws DecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cArr)) == null) {
            int length = cArr.length;
            if ((length & 1) == 0) {
                byte[] bArr = new byte[length >> 1];
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i + 1;
                    i = i3 + 1;
                    bArr[i2] = (byte) (((toDigit(cArr[i], i) << 4) | toDigit(cArr[i3], i3)) & 255);
                    i2++;
                }
                return bArr;
            }
            throw new DecoderException("Odd number of characters.");
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // org.apache.commons.base.Encoder
    public Object encode(Object obj) throws EncoderException {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj instanceof String) {
                bArr = ((String) obj).getBytes(getCharset());
            } else if (obj instanceof ByteBuffer) {
                bArr = ((ByteBuffer) obj).array();
            } else {
                try {
                    bArr = (byte[]) obj;
                } catch (ClassCastException e) {
                    throw new EncoderException(e.getMessage(), e);
                }
            }
            return encodeHex(bArr);
        }
        return invokeL.objValue;
    }

    public Hex(Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {charset};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.charset = charset;
    }

    public static byte[] decodeHex(String str) throws DecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return decodeHex(str.toCharArray());
        }
        return (byte[]) invokeL.objValue;
    }

    public static char[] encodeHex(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, byteBuffer)) == null) {
            return encodeHex(byteBuffer, true);
        }
        return (char[]) invokeL.objValue;
    }

    public static String encodeHexString(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, byteBuffer)) == null) {
            return new String(encodeHex(byteBuffer));
        }
        return (String) invokeL.objValue;
    }

    public byte[] decode(ByteBuffer byteBuffer) throws DecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer)) == null) {
            return decodeHex(new String(byteBuffer.array(), getCharset()).toCharArray());
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] encode(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteBuffer)) == null) {
            return encodeHexString(byteBuffer).getBytes(getCharset());
        }
        return (byte[]) invokeL.objValue;
    }

    public static char[] encodeHex(ByteBuffer byteBuffer, boolean z) {
        InterceptResult invokeLZ;
        char[] cArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, byteBuffer, z)) == null) {
            if (z) {
                cArr = DIGITS_LOWER;
            } else {
                cArr = DIGITS_UPPER;
            }
            return encodeHex(byteBuffer, cArr);
        }
        return (char[]) invokeLZ.objValue;
    }

    public static String encodeHexString(ByteBuffer byteBuffer, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, byteBuffer, z)) == null) {
            return new String(encodeHex(byteBuffer, z));
        }
        return (String) invokeLZ.objValue;
    }

    public static char[] encodeHex(ByteBuffer byteBuffer, char[] cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, byteBuffer, cArr)) == null) {
            return encodeHex(byteBuffer.array(), cArr);
        }
        return (char[]) invokeLL.objValue;
    }

    public static String encodeHexString(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65551, null, bArr, z)) == null) {
            return new String(encodeHex(bArr, z));
        }
        return (String) invokeLZ.objValue;
    }

    public static char[] encodeHex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) {
            return encodeHex(bArr, true);
        }
        return (char[]) invokeL.objValue;
    }

    public static String encodeHexString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bArr)) == null) {
            return new String(encodeHex(bArr));
        }
        return (String) invokeL.objValue;
    }

    @Override // org.apache.commons.base.BinaryDecoder
    public byte[] decode(byte[] bArr) throws DecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            return decodeHex(new String(bArr, getCharset()).toCharArray());
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // org.apache.commons.base.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) {
            return encodeHexString(bArr).getBytes(getCharset());
        }
        return (byte[]) invokeL.objValue;
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        char[] cArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, bArr, z)) == null) {
            if (z) {
                cArr = DIGITS_LOWER;
            } else {
                cArr = DIGITS_UPPER;
            }
            return encodeHex(bArr, cArr);
        }
        return (char[]) invokeLZ.objValue;
    }

    public static char[] encodeHex(byte[] bArr, char[] cArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, bArr, cArr)) == null) {
            int length = bArr.length;
            char[] cArr2 = new char[length << 1];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i + 1;
                cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
                i = i3 + 1;
                cArr2[i3] = cArr[bArr[i2] & 15];
            }
            return cArr2;
        }
        return (char[]) invokeLL.objValue;
    }

    public static int toDigit(char c, int i) throws DecoderException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Character.valueOf(c), Integer.valueOf(i)})) == null) {
            int digit = Character.digit(c, 16);
            if (digit != -1) {
                return digit;
            }
            throw new DecoderException("Illegal hexadecimal character " + c + " at index " + i);
        }
        return invokeCommon.intValue;
    }

    @Override // org.apache.commons.base.Decoder
    public Object decode(Object obj) throws DecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof String) {
                return decode(((String) obj).toCharArray());
            }
            if (obj instanceof byte[]) {
                return decode((byte[]) obj);
            }
            if (obj instanceof ByteBuffer) {
                return decode((ByteBuffer) obj);
            }
            try {
                return decodeHex((char[]) obj);
            } catch (ClassCastException e) {
                throw new DecoderException(e.getMessage(), e);
            }
        }
        return invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return super.toString() + "[charsetName=" + this.charset + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
