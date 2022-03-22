package org.apache.commons.codec.binary4util;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.base.BinaryDecoder;
import org.apache.commons.base.BinaryEncoder;
import org.apache.commons.base.DecoderException;
import org.apache.commons.base.EncoderException;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes8.dex */
public class BinaryCodec implements BinaryDecoder, BinaryEncoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] BITS;
    public static final int BIT_0 = 1;
    public static final int BIT_1 = 2;
    public static final int BIT_2 = 4;
    public static final int BIT_3 = 8;
    public static final int BIT_4 = 16;
    public static final int BIT_5 = 32;
    public static final int BIT_6 = 64;
    public static final int BIT_7 = 128;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final char[] EMPTY_CHAR_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(758373226, "Lorg/apache/commons/codec/binary4util/BinaryCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(758373226, "Lorg/apache/commons/codec/binary4util/BinaryCodec;");
                return;
            }
        }
        EMPTY_CHAR_ARRAY = new char[0];
        EMPTY_BYTE_ARRAY = new byte[0];
        BITS = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
    }

    public BinaryCodec() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static byte[] fromAscii(char[] cArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cArr)) == null) {
            if (cArr != null && cArr.length != 0) {
                int length = cArr.length >> 3;
                byte[] bArr = new byte[length];
                int length2 = cArr.length - 1;
                int i = 0;
                while (i < length) {
                    int i2 = 0;
                    while (true) {
                        int[] iArr = BITS;
                        if (i2 < iArr.length) {
                            if (cArr[length2 - i2] == '1') {
                                bArr[i] = (byte) (iArr[i2] | bArr[i]);
                            }
                            i2++;
                        }
                    }
                    i++;
                    length2 -= 8;
                }
                return bArr;
            }
            return EMPTY_BYTE_ARRAY;
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean isEmpty(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) ? bArr == null || bArr.length == 0 : invokeL.booleanValue;
    }

    public static byte[] toAsciiBytes(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            if (isEmpty(bArr)) {
                return EMPTY_BYTE_ARRAY;
            }
            int length = bArr.length << 3;
            byte[] bArr2 = new byte[length];
            int i = length - 1;
            int i2 = 0;
            while (i2 < bArr.length) {
                int i3 = 0;
                while (true) {
                    int[] iArr = BITS;
                    if (i3 < iArr.length) {
                        if ((iArr[i3] & bArr[i2]) == 0) {
                            bArr2[i - i3] = 48;
                        } else {
                            bArr2[i - i3] = 49;
                        }
                        i3++;
                    }
                }
                i2++;
                i -= 8;
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public static char[] toAsciiChars(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            if (isEmpty(bArr)) {
                return EMPTY_CHAR_ARRAY;
            }
            int length = bArr.length << 3;
            char[] cArr = new char[length];
            int i = length - 1;
            int i2 = 0;
            while (i2 < bArr.length) {
                int i3 = 0;
                while (true) {
                    int[] iArr = BITS;
                    if (i3 < iArr.length) {
                        if ((iArr[i3] & bArr[i2]) == 0) {
                            cArr[i - i3] = '0';
                        } else {
                            cArr[i - i3] = '1';
                        }
                        i3++;
                    }
                }
                i2++;
                i -= 8;
            }
            return cArr;
        }
        return (char[]) invokeL.objValue;
    }

    public static String toAsciiString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) ? new String(toAsciiChars(bArr)) : (String) invokeL.objValue;
    }

    @Override // org.apache.commons.base.Decoder
    public Object decode(Object obj) throws DecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                return EMPTY_BYTE_ARRAY;
            }
            if (obj instanceof byte[]) {
                return fromAscii((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return fromAscii((char[]) obj);
            }
            if (obj instanceof String) {
                return fromAscii(((String) obj).toCharArray());
            }
            throw new DecoderException("argument not a byte array");
        }
        return invokeL.objValue;
    }

    @Override // org.apache.commons.base.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) ? toAsciiBytes(bArr) : (byte[]) invokeL.objValue;
    }

    public byte[] toByteArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return EMPTY_BYTE_ARRAY;
            }
            return fromAscii(str.toCharArray());
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // org.apache.commons.base.Encoder
    public Object encode(Object obj) throws EncoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof byte[]) {
                return toAsciiChars((byte[]) obj);
            }
            throw new EncoderException("argument not a byte array");
        }
        return invokeL.objValue;
    }

    public static byte[] fromAscii(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (isEmpty(bArr)) {
                return EMPTY_BYTE_ARRAY;
            }
            int length = bArr.length >> 3;
            byte[] bArr2 = new byte[length];
            int length2 = bArr.length - 1;
            int i = 0;
            while (i < length) {
                int i2 = 0;
                while (true) {
                    int[] iArr = BITS;
                    if (i2 < iArr.length) {
                        if (bArr[length2 - i2] == 49) {
                            bArr2[i] = (byte) (iArr[i2] | bArr2[i]);
                        }
                        i2++;
                    }
                }
                i++;
                length2 -= 8;
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // org.apache.commons.base.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) ? fromAscii(bArr) : (byte[]) invokeL.objValue;
    }
}
