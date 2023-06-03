package com.coremedia.iso;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.util.IntHashMap;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public final class IsoTypeReader {
    public static /* synthetic */ Interceptable $ic;
    public static byte[] codeBytes;
    public static IntHashMap codeCache;
    public transient /* synthetic */ FieldHolder $fh;

    public static int byte2int(byte b) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b)) == null) ? b < 0 ? b + 256 : b : invokeB.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1754793689, "Lcom/coremedia/iso/IsoTypeReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1754793689, "Lcom/coremedia/iso/IsoTypeReader;");
                return;
            }
        }
        codeCache = new IntHashMap();
        codeBytes = new byte[4];
    }

    public IsoTypeReader() {
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

    public static String read4cc(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteBuffer)) == null) {
            byteBuffer.get(codeBytes);
            byte[] bArr = codeBytes;
            int i = (bArr[3] & 255) | ((bArr[0] << 24) & (-16777216)) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280);
            String str = (String) codeCache.get(i);
            if (str != null) {
                return str;
            }
            try {
                String str2 = new String(codeBytes, "ISO-8859-1");
                codeCache.put(i, str2);
                return str2;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return (String) invokeL.objValue;
    }

    public static double readFixedPoint0230(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer)) == null) {
            byte[] bArr = new byte[4];
            byteBuffer.get(bArr);
            return ((((0 | ((bArr[0] << 24) & (-16777216))) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & 65280)) | (bArr[3] & 255)) / 1.073741824E9d;
        }
        return invokeL.doubleValue;
    }

    public static double readFixedPoint1616(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, byteBuffer)) == null) {
            byte[] bArr = new byte[4];
            byteBuffer.get(bArr);
            return ((((0 | ((bArr[0] << 24) & (-16777216))) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & 65280)) | (bArr[3] & 255)) / 65536.0d;
        }
        return invokeL.doubleValue;
    }

    public static String readIso639(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, byteBuffer)) == null) {
            int readUInt16 = readUInt16(byteBuffer);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append((char) (((readUInt16 >> ((2 - i) * 5)) & 31) + 96));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static long readUInt32BE(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, byteBuffer)) == null) {
            return (readUInt8(byteBuffer) << 24) + (readUInt8(byteBuffer) << 16) + (readUInt8(byteBuffer) << 8) + (readUInt8(byteBuffer) << 0);
        }
        return invokeL.longValue;
    }

    public static float readFixedPoint88(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, byteBuffer)) == null) {
            byte[] bArr = new byte[2];
            byteBuffer.get(bArr);
            return ((short) (((short) (0 | ((bArr[0] << 8) & 65280))) | (bArr[1] & 255))) / 256.0f;
        }
        return invokeL.floatValue;
    }

    public static String readString(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, byteBuffer)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                byte b = byteBuffer.get();
                if (b == 0) {
                    return Utf8.convert(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(b);
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static int readUInt16(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, byteBuffer)) == null) {
            return (byte2int(byteBuffer.get()) << 8) + 0 + byte2int(byteBuffer.get());
        }
        return invokeL.intValue;
    }

    public static int readUInt16BE(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, byteBuffer)) == null) {
            return byte2int(byteBuffer.get()) + 0 + (byte2int(byteBuffer.get()) << 8);
        }
        return invokeL.intValue;
    }

    public static int readUInt24(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, byteBuffer)) == null) {
            return (readUInt16(byteBuffer) << 8) + 0 + byte2int(byteBuffer.get());
        }
        return invokeL.intValue;
    }

    public static long readUInt32(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, byteBuffer)) == null) {
            long j = byteBuffer.getInt();
            if (j < 0) {
                return j + 4294967296L;
            }
            return j;
        }
        return invokeL.longValue;
    }

    public static long readUInt64(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, byteBuffer)) == null) {
            long readUInt32 = (readUInt32(byteBuffer) << 32) + 0;
            if (readUInt32 >= 0) {
                return readUInt32 + readUInt32(byteBuffer);
            }
            throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        }
        return invokeL.longValue;
    }

    public static int readUInt8(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, byteBuffer)) == null) {
            return byte2int(byteBuffer.get());
        }
        return invokeL.intValue;
    }

    public static String readString(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, byteBuffer, i)) == null) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return Utf8.convert(bArr);
        }
        return (String) invokeLI.objValue;
    }
}
