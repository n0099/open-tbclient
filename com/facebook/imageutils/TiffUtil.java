package com.facebook.imageutils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class TiffUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Class<?> TAG;
    public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
    public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
    public static final int TIFF_TAG_ORIENTATION = 274;
    public static final int TIFF_TYPE_SHORT = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.facebook.imageutils.TiffUtil$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class TiffHeader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int byteOrder;
        public int firstIfdOffset;
        public boolean isLittleEndian;

        public TiffHeader() {
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

        public /* synthetic */ TiffHeader(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-727525990, "Lcom/facebook/imageutils/TiffUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-727525990, "Lcom/facebook/imageutils/TiffUtil;");
                return;
            }
        }
        TAG = TiffUtil.class;
    }

    public TiffUtil() {
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

    public static int getAutoRotateAngleFromOrientation(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 3) {
                if (i != 6) {
                    return i != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        }
        return invokeI.intValue;
    }

    public static int getOrientationFromTiffEntry(InputStream inputStream, int i, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{inputStream, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i >= 10 && StreamProcessor.readPackedInt(inputStream, 2, z) == 3 && StreamProcessor.readPackedInt(inputStream, 4, z) == 1) {
                int readPackedInt = StreamProcessor.readPackedInt(inputStream, 2, z);
                StreamProcessor.readPackedInt(inputStream, 2, z);
                return readPackedInt;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int moveToTiffEntryWithTag(InputStream inputStream, int i, boolean z, int i2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{inputStream, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) != null) {
            return invokeCommon.intValue;
        }
        if (i < 14) {
            return 0;
        }
        int readPackedInt = StreamProcessor.readPackedInt(inputStream, 2, z);
        int i3 = i - 2;
        while (true) {
            int i4 = readPackedInt - 1;
            if (readPackedInt <= 0 || i3 < 12) {
                break;
            }
            int i5 = i3 - 2;
            if (StreamProcessor.readPackedInt(inputStream, 2, z) == i2) {
                return i5;
            }
            inputStream.skip(10L);
            i3 = i5 - 10;
            readPackedInt = i4;
        }
    }

    public static int readOrientationFromTIFF(InputStream inputStream, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, inputStream, i)) == null) {
            TiffHeader tiffHeader = new TiffHeader(null);
            int readTiffHeader = readTiffHeader(inputStream, i, tiffHeader);
            int i2 = tiffHeader.firstIfdOffset - 8;
            if (readTiffHeader == 0 || i2 > readTiffHeader) {
                return 0;
            }
            inputStream.skip(i2);
            return getOrientationFromTiffEntry(inputStream, moveToTiffEntryWithTag(inputStream, readTiffHeader - i2, tiffHeader.isLittleEndian, 274), tiffHeader.isLittleEndian);
        }
        return invokeLI.intValue;
    }

    public static int readTiffHeader(InputStream inputStream, int i, TiffHeader tiffHeader) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, inputStream, i, tiffHeader)) == null) {
            if (i <= 8) {
                return 0;
            }
            int readPackedInt = StreamProcessor.readPackedInt(inputStream, 4, false);
            tiffHeader.byteOrder = readPackedInt;
            int i2 = i - 4;
            if (readPackedInt != 1229531648 && readPackedInt != 1296891946) {
                FLog.e(TAG, "Invalid TIFF header");
                return 0;
            }
            boolean z = tiffHeader.byteOrder == 1229531648;
            tiffHeader.isLittleEndian = z;
            int readPackedInt2 = StreamProcessor.readPackedInt(inputStream, 4, z);
            tiffHeader.firstIfdOffset = readPackedInt2;
            int i3 = i2 - 4;
            if (readPackedInt2 < 8 || readPackedInt2 - 8 > i3) {
                FLog.e(TAG, "Invalid offset");
                return 0;
            }
            return i3;
        }
        return invokeLIL.intValue;
    }
}
