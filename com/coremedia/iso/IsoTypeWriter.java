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
/* loaded from: classes2.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void writeFixedPoint0230(ByteBuffer byteBuffer, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{byteBuffer, Double.valueOf(d2)}) == null) {
            int i2 = (int) (d2 * 1.073741824E9d);
            byteBuffer.put((byte) (((-16777216) & i2) >> 24));
            byteBuffer.put((byte) ((16711680 & i2) >> 16));
            byteBuffer.put((byte) ((65280 & i2) >> 8));
            byteBuffer.put((byte) (i2 & 255));
        }
    }

    public static void writeFixedPoint1616(ByteBuffer byteBuffer, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{byteBuffer, Double.valueOf(d2)}) == null) {
            int i2 = (int) (d2 * 65536.0d);
            byteBuffer.put((byte) (((-16777216) & i2) >> 24));
            byteBuffer.put((byte) ((16711680 & i2) >> 16));
            byteBuffer.put((byte) ((65280 & i2) >> 8));
            byteBuffer.put((byte) (i2 & 255));
        }
    }

    public static void writeFixedPoint88(ByteBuffer byteBuffer, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{byteBuffer, Double.valueOf(d2)}) == null) {
            short s = (short) (d2 * 256.0d);
            byteBuffer.put((byte) ((65280 & s) >> 8));
            byteBuffer.put((byte) (s & 255));
        }
    }

    public static void writeIso639(ByteBuffer byteBuffer, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, byteBuffer, str) == null) {
            if (str.getBytes().length == 3) {
                int i2 = 0;
                for (int i3 = 0; i3 < 3; i3++) {
                    i2 += (str.getBytes()[i3] - 96) << ((2 - i3) * 5);
                }
                writeUInt16(byteBuffer, i2);
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

    public static void writeUInt16(ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, byteBuffer, i2) == null) {
            int i3 = i2 & 65535;
            writeUInt8(byteBuffer, i3 >> 8);
            writeUInt8(byteBuffer, i3 & 255);
        }
    }

    public static void writeUInt16BE(ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, byteBuffer, i2) == null) {
            int i3 = i2 & 65535;
            writeUInt8(byteBuffer, i3 & 255);
            writeUInt8(byteBuffer, i3 >> 8);
        }
    }

    public static void writeUInt24(ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, byteBuffer, i2) == null) {
            int i3 = i2 & 16777215;
            writeUInt16(byteBuffer, i3 >> 8);
            writeUInt8(byteBuffer, i3);
        }
    }

    public static void writeUInt32(ByteBuffer byteBuffer, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65546, null, byteBuffer, j2) == null) {
            byteBuffer.putInt((int) j2);
        }
    }

    public static void writeUInt32BE(ByteBuffer byteBuffer, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65547, null, byteBuffer, j2) == null) {
            writeUInt16BE(byteBuffer, ((int) j2) & 65535);
            writeUInt16BE(byteBuffer, (int) ((j2 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
    }

    public static void writeUInt64(ByteBuffer byteBuffer, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65548, null, byteBuffer, j2) == null) {
            byteBuffer.putLong(j2);
        }
    }

    public static void writeUInt8(ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, byteBuffer, i2) == null) {
            byteBuffer.put((byte) (i2 & 255));
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
