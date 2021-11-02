package okhttp3.internal.ws;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okio.Buffer;
import okio.ByteString;
/* loaded from: classes3.dex */
public final class WebSocketProtocol {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;
    public transient /* synthetic */ FieldHolder $fh;

    public WebSocketProtocol() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new AssertionError("No instances.");
    }

    public static String acceptHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return ByteString.encodeUtf8(str + ACCEPT_MAGIC).sha1().base64();
        }
        return (String) invokeL.objValue;
    }

    public static String closeCodeExceptionMessage(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 < 1000 || i2 >= 5000) {
                return "Code must be in range [1000,5000): " + i2;
            } else if ((i2 < 1004 || i2 > 1006) && (i2 < 1012 || i2 > 2999)) {
                return null;
            } else {
                return "Code " + i2 + " is reserved and may not be used.";
            }
        }
        return (String) invokeI.objValue;
    }

    public static void toggleMask(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, unsafeCursor, bArr) == null) {
            int length = bArr.length;
            int i2 = 0;
            do {
                byte[] bArr2 = unsafeCursor.data;
                int i3 = unsafeCursor.start;
                int i4 = unsafeCursor.end;
                while (i3 < i4) {
                    int i5 = i2 % length;
                    bArr2[i3] = (byte) (bArr2[i3] ^ bArr[i5]);
                    i3++;
                    i2 = i5 + 1;
                }
            } while (unsafeCursor.next() != -1);
        }
    }

    public static void validateCloseCode(int i2) {
        String closeCodeExceptionMessage;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2) == null) && (closeCodeExceptionMessage = closeCodeExceptionMessage(i2)) != null) {
            throw new IllegalArgumentException(closeCodeExceptionMessage);
        }
    }
}
