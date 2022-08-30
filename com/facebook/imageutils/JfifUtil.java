package com.facebook.imageutils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class JfifUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP1_EXIF_MAGIC = 1165519206;
    public static final int MARKER_APP1 = 225;
    public static final int MARKER_EOI = 217;
    public static final int MARKER_ESCAPE_BYTE = 0;
    public static final int MARKER_FIRST_BYTE = 255;
    public static final int MARKER_RST0 = 208;
    public static final int MARKER_RST7 = 215;
    public static final int MARKER_SOFn = 192;
    public static final int MARKER_SOI = 216;
    public static final int MARKER_SOS = 218;
    public static final int MARKER_TEM = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public JfifUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int getAutoRotateAngleFromOrientation(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? TiffUtil.getAutoRotateAngleFromOrientation(i) : invokeI.intValue;
    }

    public static int getOrientation(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? getOrientation(new ByteArrayInputStream(bArr)) : invokeL.intValue;
    }

    public static boolean isSOFn(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            switch (i) {
                case 192:
                case 193:
                case 194:
                case DownloadConstants.STATUS_WAITING_FOR_NETWORK /* 195 */:
                case Constants.METHOD_IM_DELIVER_CONFIG_MSG /* 197 */:
                case 198:
                case 199:
                case 201:
                case 202:
                case 203:
                case 205:
                case 206:
                case 207:
                    return true;
                case 196:
                case 200:
                case 204:
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static int moveToAPP1EXIF(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        int readPackedInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, inputStream)) == null) {
            if (moveToMarker(inputStream, 225) && (readPackedInt = StreamProcessor.readPackedInt(inputStream, 2, false) - 2) > 6) {
                int readPackedInt2 = StreamProcessor.readPackedInt(inputStream, 4, false);
                int readPackedInt3 = StreamProcessor.readPackedInt(inputStream, 2, false);
                int i = (readPackedInt - 4) - 2;
                if (readPackedInt2 == 1165519206 && readPackedInt3 == 0) {
                    return i;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean moveToMarker(InputStream inputStream, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, inputStream, i)) == null) {
            Preconditions.checkNotNull(inputStream);
            while (StreamProcessor.readPackedInt(inputStream, 1, false) == 255) {
                int i2 = 255;
                while (i2 == 255) {
                    i2 = StreamProcessor.readPackedInt(inputStream, 1, false);
                }
                if ((i != 192 || !isSOFn(i2)) && i2 != i) {
                    if (i2 != 216 && i2 != 1) {
                        if (i2 == 217 || i2 == 218) {
                            break;
                        }
                        inputStream.skip(StreamProcessor.readPackedInt(inputStream, 2, false) - 2);
                    }
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static int getOrientation(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            try {
                int moveToAPP1EXIF = moveToAPP1EXIF(inputStream);
                if (moveToAPP1EXIF == 0) {
                    return 0;
                }
                return TiffUtil.readOrientationFromTIFF(inputStream, moveToAPP1EXIF);
            } catch (IOException unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
