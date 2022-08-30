package com.coremedia.iso;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes7.dex */
public final class IsoTypeWriter {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1232198793, "Lcom/coremedia/iso/IsoTypeWriter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1232198793, "Lcom/coremedia/iso/IsoTypeWriter;");
        }
    }

    public IsoTypeWriter() {
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

    public static void writeFixedPoint0230(ByteBuffer byteBuffer, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{byteBuffer, Double.valueOf(d)}) == null) {
            int i = (int) (d * 1.073741824E9d);
            byteBuffer.put((byte) (((-16777216) & i) >> 24));
            byteBuffer.put((byte) ((16711680 & i) >> 16));
            byteBuffer.put((byte) ((65280 & i) >> 8));
            byteBuffer.put((byte) (i & 255));
        }
    }

    public static void writeFixedPoint1616(ByteBuffer byteBuffer, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{byteBuffer, Double.valueOf(d)}) == null) {
            int i = (int) (d * 65536.0d);
            byteBuffer.put((byte) (((-16777216) & i) >> 24));
            byteBuffer.put((byte) ((16711680 & i) >> 16));
            byteBuffer.put((byte) ((65280 & i) >> 8));
            byteBuffer.put((byte) (i & 255));
        }
    }

    public static void writeFixedPoint88(ByteBuffer byteBuffer, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{byteBuffer, Double.valueOf(d)}) == null) {
            short s = (short) (d * 256.0d);
            byteBuffer.put((byte) ((65280 & s) >> 8));
            byteBuffer.put((byte) (s & 255));
        }
    }

    public static void writeIso639(ByteBuffer byteBuffer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, byteBuffer, str) == null) {
            if (str.getBytes().length == 3) {
                int i = 0;
                for (int i2 = 0; i2 < 3; i2++) {
                    i += (str.getBytes()[i2] - 96) << ((2 - i2) * 5);
                }
                writeUInt16(byteBuffer, i);
                return;
            }
            throw new IllegalArgumentException("\"" + str + "\" language string isn't exactly 3 characters long!");
        }
    }

    public static void writePascalUtfString(ByteBuffer byteBuffer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, byteBuffer, str) == null) {
            byte[] convert = Utf8.convert(str);
            writeUInt8(byteBuffer, convert.length);
            byteBuffer.put(convert);
        }
    }

    public static void writeUInt16(ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, byteBuffer, i) == null) {
            int i2 = i & 65535;
            writeUInt8(byteBuffer, i2 >> 8);
            writeUInt8(byteBuffer, i2 & 255);
        }
    }

    public static void writeUInt16BE(ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, byteBuffer, i) == null) {
            int i2 = i & 65535;
            writeUInt8(byteBuffer, i2 & 255);
            writeUInt8(byteBuffer, i2 >> 8);
        }
    }

    public static void writeUInt24(ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, byteBuffer, i) == null) {
            int i2 = i & 16777215;
            writeUInt16(byteBuffer, i2 >> 8);
            writeUInt8(byteBuffer, i2);
        }
    }

    public static void writeUInt32(ByteBuffer byteBuffer, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65546, null, byteBuffer, j) == null) {
            byteBuffer.putInt((int) j);
        }
    }

    public static void writeUInt32BE(ByteBuffer byteBuffer, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65547, null, byteBuffer, j) == null) {
            writeUInt16BE(byteBuffer, ((int) j) & 65535);
            writeUInt16BE(byteBuffer, (int) ((j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
    }

    public static void writeUInt64(ByteBuffer byteBuffer, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65548, null, byteBuffer, j) == null) {
            byteBuffer.putLong(j);
        }
    }

    public static void writeUInt8(ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, byteBuffer, i) == null) {
            byteBuffer.put((byte) (i & 255));
        }
    }

    public static void writeUtf8String(ByteBuffer byteBuffer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, byteBuffer, str) == null) {
            byteBuffer.put(Utf8.convert(str));
            writeUInt8(byteBuffer, 0);
        }
    }

    public static void writeZeroTermUtf8String(ByteBuffer byteBuffer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, byteBuffer, str) == null) {
            byteBuffer.put(Utf8.convert(str));
            writeUInt8(byteBuffer, 0);
        }
    }
}
