package com.facebook.imageutils;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.audio.b;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class WebpUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String VP8L_HEADER = "VP8L";
    public static final String VP8X_HEADER = "VP8X";
    public static final String VP8_HEADER = "VP8 ";
    public transient /* synthetic */ FieldHolder $fh;

    public WebpUtil() {
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

    public static boolean compare(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, str)) == null) {
            if (bArr.length != str.length()) {
                return false;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (str.charAt(i2) != bArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static int get2BytesAsInt(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) ? ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255) : invokeL.intValue;
    }

    public static byte getByte(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) ? (byte) (inputStream.read() & 255) : invokeL.byteValue;
    }

    public static String getHeader(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                sb.append((char) b2);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int getInt(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, inputStream)) == null) ? ((((byte) inputStream.read()) << 24) & (-16777216)) | ((((byte) inputStream.read()) << 16) & 16711680) | ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255) : invokeL.intValue;
    }

    public static short getShort(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, inputStream)) == null) ? (short) (inputStream.read() & 255) : invokeL.shortValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Nullable
    public static Pair<Integer, Integer> getSize(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, inputStream)) == null) {
            byte[] bArr = new byte[4];
            try {
                try {
                    try {
                        inputStream.read(bArr);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                if (compare(bArr, b.f60055e)) {
                    getInt(inputStream);
                    inputStream.read(bArr);
                    if (!compare(bArr, "WEBP")) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return null;
                    }
                    inputStream.read(bArr);
                    String header = getHeader(bArr);
                    if (VP8_HEADER.equals(header)) {
                        Pair<Integer, Integer> vP8Dimension = getVP8Dimension(inputStream);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return vP8Dimension;
                    } else if (VP8L_HEADER.equals(header)) {
                        Pair<Integer, Integer> vP8LDimension = getVP8LDimension(inputStream);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        return vP8LDimension;
                    } else if (!VP8X_HEADER.equals(header)) {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return null;
                    } else {
                        Pair<Integer, Integer> vP8XDimension = getVP8XDimension(inputStream);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        return vP8XDimension;
                    }
                }
                return null;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
            }
        }
        return (Pair) invokeL.objValue;
    }

    @Nullable
    public static Pair<Integer, Integer> getVP8Dimension(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, inputStream)) == null) {
            inputStream.skip(7L);
            short s = getShort(inputStream);
            short s2 = getShort(inputStream);
            short s3 = getShort(inputStream);
            if (s == 157 && s2 == 1 && s3 == 42) {
                return new Pair<>(Integer.valueOf(get2BytesAsInt(inputStream)), Integer.valueOf(get2BytesAsInt(inputStream)));
            }
            return null;
        }
        return (Pair) invokeL.objValue;
    }

    @Nullable
    public static Pair<Integer, Integer> getVP8LDimension(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, inputStream)) == null) {
            getInt(inputStream);
            if (getByte(inputStream) != 47) {
                return null;
            }
            int read = ((byte) inputStream.read()) & 255;
            return new Pair<>(Integer.valueOf(((((byte) inputStream.read()) & 255) | ((read & 63) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & 255) & 15) << 10) | ((((byte) inputStream.read()) & 255) << 2) | ((read & 192) >> 6)) + 1));
        }
        return (Pair) invokeL.objValue;
    }

    public static Pair<Integer, Integer> getVP8XDimension(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, inputStream)) == null) {
            inputStream.skip(8L);
            return new Pair<>(Integer.valueOf(read3Bytes(inputStream) + 1), Integer.valueOf(read3Bytes(inputStream) + 1));
        }
        return (Pair) invokeL.objValue;
    }

    public static boolean isBitOne(byte b2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Byte.valueOf(b2), Integer.valueOf(i2)})) == null) ? ((b2 >> (i2 % 8)) & 1) == 1 : invokeCommon.booleanValue;
    }

    public static int read3Bytes(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, inputStream)) == null) {
            return ((getByte(inputStream) << 16) & 16711680) | ((getByte(inputStream) << 8) & 65280) | (getByte(inputStream) & 255);
        }
        return invokeL.intValue;
    }
}
