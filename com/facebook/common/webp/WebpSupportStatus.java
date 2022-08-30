package com.facebook.common.webp;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imageutils.WebpUtil;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class WebpSupportStatus {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    public static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    public static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    public static final byte[] WEBP_NAME_BYTES;
    public static final byte[] WEBP_RIFF_BYTES;
    public static final byte[] WEBP_VP8L_BYTES;
    public static final byte[] WEBP_VP8X_BYTES;
    public static final byte[] WEBP_VP8_BYTES;
    public static final boolean sIsExtendedWebpSupported;
    public static final boolean sIsSimpleWebpSupported;
    public static final boolean sIsWebpSupportRequired;
    @Nullable
    public static WebpBitmapFactory sWebpBitmapFactory;
    public static boolean sWebpLibraryChecked;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1326449196, "Lcom/facebook/common/webp/WebpSupportStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1326449196, "Lcom/facebook/common/webp/WebpSupportStatus;");
                return;
            }
        }
        sIsWebpSupportRequired = Build.VERSION.SDK_INT <= 17;
        sIsSimpleWebpSupported = Build.VERSION.SDK_INT >= 14;
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        sWebpBitmapFactory = null;
        sWebpLibraryChecked = false;
        WEBP_RIFF_BYTES = asciiBytes("RIFF");
        WEBP_NAME_BYTES = asciiBytes("WEBP");
        WEBP_VP8_BYTES = asciiBytes(WebpUtil.VP8_HEADER);
        WEBP_VP8L_BYTES = asciiBytes(WebpUtil.VP8L_HEADER);
        WEBP_VP8X_BYTES = asciiBytes(WebpUtil.VP8X_HEADER);
    }

    public WebpSupportStatus() {
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

    public static byte[] asciiBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return str.getBytes(HTTP.ASCII);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("ASCII not found!", e);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean isAnimatedWebpHeader(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i)) == null) {
            return matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES) && ((bArr[i + 20] & 2) == 2);
        }
        return invokeLI.booleanValue;
    }

    public static boolean isExtendedWebpHeader(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2)) == null) ? i2 >= 21 && matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES) : invokeLII.booleanValue;
    }

    public static boolean isExtendedWebpHeaderWithAlpha(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, bArr, i)) == null) {
            return matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES) && ((bArr[i + 20] & 16) == 16);
        }
        return invokeLI.booleanValue;
    }

    public static boolean isExtendedWebpSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i < 17) {
                return false;
            }
            if (i == 17) {
                byte[] decode = Base64.decode(VP8X_WEBP_BASE64, 0);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                if (options.outHeight != 1 || options.outWidth != 1) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isLosslessWebpHeader(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bArr, i)) == null) ? matchBytePattern(bArr, i + 12, WEBP_VP8L_BYTES) : invokeLI.booleanValue;
    }

    public static boolean isSimpleWebpHeader(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bArr, i)) == null) ? matchBytePattern(bArr, i + 12, WEBP_VP8_BYTES) : invokeLI.booleanValue;
    }

    public static boolean isWebpHeader(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, bArr, i, i2)) == null) ? i2 >= 20 && matchBytePattern(bArr, i, WEBP_RIFF_BYTES) && matchBytePattern(bArr, i + 8, WEBP_NAME_BYTES) : invokeLII.booleanValue;
    }

    public static boolean isWebpSupportedByPlatform(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65546, null, bArr, i, i2)) == null) {
            if (isSimpleWebpHeader(bArr, i)) {
                return sIsSimpleWebpSupported;
            }
            if (isLosslessWebpHeader(bArr, i)) {
                return sIsExtendedWebpSupported;
            }
            if (!isExtendedWebpHeader(bArr, i, i2) || isAnimatedWebpHeader(bArr, i)) {
                return false;
            }
            return sIsExtendedWebpSupported;
        }
        return invokeLII.booleanValue;
    }

    @Nullable
    public static WebpBitmapFactory loadWebpBitmapFactoryIfExists() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (sWebpLibraryChecked) {
                return sWebpBitmapFactory;
            }
            WebpBitmapFactory webpBitmapFactory = null;
            try {
                webpBitmapFactory = (WebpBitmapFactory) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
            } catch (Throwable unused) {
            }
            sWebpLibraryChecked = true;
            return webpBitmapFactory;
        }
        return (WebpBitmapFactory) invokeV.objValue;
    }

    public static boolean matchBytePattern(byte[] bArr, int i, byte[] bArr2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65548, null, bArr, i, bArr2)) == null) {
            if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
                return false;
            }
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i2 + i] != bArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeLIL.booleanValue;
    }
}
