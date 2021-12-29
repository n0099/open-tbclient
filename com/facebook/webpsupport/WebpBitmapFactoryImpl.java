package com.facebook.webpsupport;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
@DoNotStrip
/* loaded from: classes3.dex */
public class WebpBitmapFactoryImpl implements WebpBitmapFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HEADER_SIZE = 20;
    public static final boolean IN_BITMAP_SUPPORTED;
    public static final int IN_TEMP_BUFFER_SIZE = 8192;
    public static BitmapCreator mBitmapCreator;
    public static WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(874427975, "Lcom/facebook/webpsupport/WebpBitmapFactoryImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(874427975, "Lcom/facebook/webpsupport/WebpBitmapFactoryImpl;");
                return;
            }
        }
        IN_BITMAP_SUPPORTED = Build.VERSION.SDK_INT >= 11;
    }

    public WebpBitmapFactoryImpl() {
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

    @DoNotStrip
    public static Bitmap createBitmap(int i2, int i3, BitmapFactory.Options options) {
        InterceptResult invokeIIL;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i2, i3, options)) == null) {
            if (IN_BITMAP_SUPPORTED && options != null && (bitmap = options.inBitmap) != null && bitmap.isMutable()) {
                return options.inBitmap;
            }
            return mBitmapCreator.createNakedBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
        return (Bitmap) invokeIIL.objValue;
    }

    @DoNotStrip
    public static byte[] getInTempStorageFromOptions(@Nullable BitmapFactory.Options options) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, options)) == null) ? (options == null || (bArr = options.inTempStorage) == null) ? new byte[8192] : bArr : (byte[]) invokeL.objValue;
    }

    @DoNotStrip
    public static float getScaleFromOptions(BitmapFactory.Options options) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, options)) == null) {
            if (options != null) {
                int i2 = options.inSampleSize;
                float f2 = i2 > 1 ? 1.0f / i2 : 1.0f;
                if (options.inScaled) {
                    int i3 = options.inDensity;
                    int i4 = options.inTargetDensity;
                    return (i3 == 0 || i4 == 0 || i3 == options.inScreenDensity) ? f2 : i4 / i3;
                }
                return f2;
            }
            return 1.0f;
        }
        return invokeL.floatValue;
    }

    @Nullable
    public static byte[] getWebpHeader(InputStream inputStream, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, inputStream, options)) == null) {
            inputStream.mark(20);
            if (options == null || (bArr = options.inTempStorage) == null || bArr.length < 20) {
                bArr = new byte[20];
            }
            try {
                inputStream.read(bArr, 0, 20);
                inputStream.reset();
                return bArr;
            } catch (IOException unused) {
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    @DoNotStrip
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i2, int i3, BitmapFactory.Options options) {
        InterceptResult invokeCommon;
        Bitmap originalDecodeByteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) {
            StaticWebpNativeLoader.ensure();
            if (WebpSupportStatus.sIsWebpSupportRequired && WebpSupportStatus.isWebpHeader(bArr, i2, i3)) {
                originalDecodeByteArray = nativeDecodeByteArray(bArr, i2, i3, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                if (originalDecodeByteArray == null) {
                    sendWebpErrorLog("webp_direct_decode_array");
                }
                setWebpBitmapOptions(originalDecodeByteArray, options);
            } else {
                originalDecodeByteArray = originalDecodeByteArray(bArr, i2, i3, options);
                if (originalDecodeByteArray == null) {
                    sendWebpErrorLog("webp_direct_decode_array_failed_on_no_webp");
                }
            }
            return originalDecodeByteArray;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeFile(String str, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, options)) == null) {
            Bitmap bitmap = null;
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                bitmap = hookDecodeStream(fileInputStream, null, options);
                fileInputStream.close();
            } catch (Exception unused) {
            }
            return bitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }

    @DoNotStrip
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        InterceptResult invokeLLL;
        Bitmap originalDecodeFileDescriptor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65547, null, fileDescriptor, rect, options)) != null) {
            return (Bitmap) invokeLLL.objValue;
        }
        StaticWebpNativeLoader.ensure();
        long nativeSeek = nativeSeek(fileDescriptor, 0L, false);
        if (nativeSeek != -1) {
            InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(new FileInputStream(fileDescriptor));
            try {
                byte[] webpHeader = getWebpHeader(wrapToMarkSupportedStream, options);
                if (WebpSupportStatus.sIsWebpSupportRequired && WebpSupportStatus.isWebpHeader(webpHeader, 0, 20)) {
                    originalDecodeFileDescriptor = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                    if (originalDecodeFileDescriptor == null) {
                        sendWebpErrorLog("webp_direct_decode_fd");
                    }
                    setPaddingDefaultValues(rect);
                    setWebpBitmapOptions(originalDecodeFileDescriptor, options);
                } else {
                    nativeSeek(fileDescriptor, nativeSeek, true);
                    originalDecodeFileDescriptor = originalDecodeFileDescriptor(fileDescriptor, rect, options);
                    if (originalDecodeFileDescriptor == null) {
                        sendWebpErrorLog("webp_direct_decode_fd_failed_on_no_webp");
                    }
                }
                try {
                } catch (Throwable unused) {
                    return originalDecodeFileDescriptor;
                }
            } finally {
                try {
                    wrapToMarkSupportedStream.close();
                } catch (Throwable unused2) {
                }
            }
        } else {
            Bitmap hookDecodeStream = hookDecodeStream(new FileInputStream(fileDescriptor), rect, options);
            setPaddingDefaultValues(rect);
            return hookDecodeStream;
        }
    }

    @DoNotStrip
    @Nullable
    public static Bitmap hookDecodeResource(Resources resources, int i2, BitmapFactory.Options options) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, resources, i2, options)) == null) {
            TypedValue typedValue = new TypedValue();
            Bitmap bitmap = null;
            try {
                InputStream openRawResource = resources.openRawResource(i2, typedValue);
                bitmap = hookDecodeResourceStream(resources, typedValue, openRawResource, null, options);
                if (openRawResource != null) {
                    openRawResource.close();
                }
            } catch (Exception unused) {
            }
            if (!IN_BITMAP_SUPPORTED || bitmap != null || options == null || options.inBitmap == null) {
                return bitmap;
            }
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        }
        return (Bitmap) invokeLIL.objValue;
    }

    @DoNotStrip
    public static Bitmap hookDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65550, null, resources, typedValue, inputStream, rect, options)) == null) {
            if (options == null) {
                options = new BitmapFactory.Options();
            }
            if (options.inDensity == 0 && typedValue != null) {
                int i2 = typedValue.density;
                if (i2 == 0) {
                    options.inDensity = 160;
                } else if (i2 != 65535) {
                    options.inDensity = i2;
                }
            }
            if (options.inTargetDensity == 0 && resources != null) {
                options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
            }
            return hookDecodeStream(inputStream, rect, options);
        }
        return (Bitmap) invokeLLLLL.objValue;
    }

    @DoNotStrip
    public static Bitmap hookDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        InterceptResult invokeLLL;
        Bitmap originalDecodeStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, inputStream, rect, options)) == null) {
            StaticWebpNativeLoader.ensure();
            InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(inputStream);
            byte[] webpHeader = getWebpHeader(wrapToMarkSupportedStream, options);
            if (WebpSupportStatus.sIsWebpSupportRequired && WebpSupportStatus.isWebpHeader(webpHeader, 0, 20)) {
                originalDecodeStream = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                if (originalDecodeStream == null) {
                    sendWebpErrorLog("webp_direct_decode_stream");
                }
                setWebpBitmapOptions(originalDecodeStream, options);
                setPaddingDefaultValues(rect);
            } else {
                originalDecodeStream = originalDecodeStream(wrapToMarkSupportedStream, rect, options);
                if (originalDecodeStream == null) {
                    sendWebpErrorLog("webp_direct_decode_stream_failed_on_no_webp");
                }
            }
            return originalDecodeStream;
        }
        return (Bitmap) invokeLLL.objValue;
    }

    @DoNotStrip
    public static native Bitmap nativeDecodeByteArray(byte[] bArr, int i2, int i3, BitmapFactory.Options options, float f2, byte[] bArr2);

    @DoNotStrip
    public static native Bitmap nativeDecodeStream(InputStream inputStream, BitmapFactory.Options options, float f2, byte[] bArr);

    @DoNotStrip
    public static native long nativeSeek(FileDescriptor fileDescriptor, long j2, boolean z);

    @DoNotStrip
    public static Bitmap originalDecodeByteArray(byte[] bArr, int i2, int i3, BitmapFactory.Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) ? BitmapFactory.decodeByteArray(bArr, i2, i3, options) : (Bitmap) invokeCommon.objValue;
    }

    @DoNotStrip
    public static Bitmap originalDecodeFile(String str, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, str, options)) == null) ? BitmapFactory.decodeFile(str, options) : (Bitmap) invokeLL.objValue;
    }

    @DoNotStrip
    public static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, null, fileDescriptor, rect, options)) == null) ? BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options) : (Bitmap) invokeLLL.objValue;
    }

    @DoNotStrip
    public static Bitmap originalDecodeResource(Resources resources, int i2, BitmapFactory.Options options) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65563, null, resources, i2, options)) == null) ? BitmapFactory.decodeResource(resources, i2, options) : (Bitmap) invokeLIL.objValue;
    }

    @DoNotStrip
    public static Bitmap originalDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65564, null, resources, typedValue, inputStream, rect, options)) == null) ? BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options) : (Bitmap) invokeLLLLL.objValue;
    }

    @DoNotStrip
    public static Bitmap originalDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65566, null, inputStream, rect, options)) == null) ? BitmapFactory.decodeStream(inputStream, rect, options) : (Bitmap) invokeLLL.objValue;
    }

    public static void sendWebpErrorLog(String str) {
        WebpBitmapFactory.WebpErrorLogger webpErrorLogger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, null, str) == null) || (webpErrorLogger = mWebpErrorLogger) == null) {
            return;
        }
        webpErrorLogger.onWebpErrorLog(str, "decoding_failure");
    }

    @DoNotStrip
    public static void setBitmapSize(@Nullable BitmapFactory.Options options, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65568, null, options, i2, i3) == null) || options == null) {
            return;
        }
        options.outWidth = i2;
        options.outHeight = i3;
    }

    public static void setDensityFromOptions(Bitmap bitmap, BitmapFactory.Options options) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65569, null, bitmap, options) == null) || bitmap == null || options == null) {
            return;
        }
        int i2 = options.inDensity;
        if (i2 != 0) {
            bitmap.setDensity(i2);
            int i3 = options.inTargetDensity;
            if (i3 == 0 || i2 == i3 || i2 == options.inScreenDensity || !options.inScaled) {
                return;
            }
            bitmap.setDensity(i3);
        } else if (!IN_BITMAP_SUPPORTED || options.inBitmap == null) {
        } else {
            bitmap.setDensity(160);
        }
    }

    @DoNotStrip
    public static boolean setOutDimensions(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65570, null, options, i2, i3)) == null) {
            if (options == null || !options.inJustDecodeBounds) {
                return false;
            }
            options.outWidth = i2;
            options.outHeight = i3;
            return true;
        }
        return invokeLII.booleanValue;
    }

    @DoNotStrip
    public static void setPaddingDefaultValues(@Nullable Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65571, null, rect) == null) || rect == null) {
            return;
        }
        rect.top = -1;
        rect.left = -1;
        rect.bottom = -1;
        rect.right = -1;
    }

    public static void setWebpBitmapOptions(Bitmap bitmap, BitmapFactory.Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65572, null, bitmap, options) == null) {
            setDensityFromOptions(bitmap, options);
            if (options != null) {
                options.outMimeType = "image/webp";
            }
        }
    }

    @DoNotStrip
    @SuppressLint({"NewApi"})
    public static boolean shouldPremultiply(BitmapFactory.Options options) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, options)) == null) {
            if (Build.VERSION.SDK_INT < 19 || options == null) {
                return true;
            }
            return options.inPremultiplied;
        }
        return invokeL.booleanValue;
    }

    public static InputStream wrapToMarkSupportedStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, null, inputStream)) == null) ? !inputStream.markSupported() ? new BufferedInputStream(inputStream, 20) : inputStream : (InputStream) invokeL.objValue;
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public Bitmap decodeByteArray(byte[] bArr, int i2, int i3, BitmapFactory.Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) ? hookDecodeByteArray(bArr, i2, i3, options) : (Bitmap) invokeCommon.objValue;
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public Bitmap decodeFile(String str, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, options)) == null) ? hookDecodeFile(str, options) : (Bitmap) invokeLL.objValue;
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, fileDescriptor, rect, options)) == null) ? hookDecodeFileDescriptor(fileDescriptor, rect, options) : (Bitmap) invokeLLL.objValue;
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, inputStream, rect, options)) == null) ? hookDecodeStream(inputStream, rect, options) : (Bitmap) invokeLLL.objValue;
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public void setBitmapCreator(BitmapCreator bitmapCreator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bitmapCreator) == null) {
            mBitmapCreator = bitmapCreator;
        }
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public void setWebpErrorLogger(WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, webpErrorLogger) == null) {
            mWebpErrorLogger = webpErrorLogger;
        }
    }

    @DoNotStrip
    public static Bitmap originalDecodeByteArray(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65556, null, bArr, i2, i3)) == null) ? BitmapFactory.decodeByteArray(bArr, i2, i3) : (Bitmap) invokeLII.objValue;
    }

    @DoNotStrip
    public static Bitmap originalDecodeFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) ? BitmapFactory.decodeFile(str) : (Bitmap) invokeL.objValue;
    }

    @DoNotStrip
    public static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, fileDescriptor)) == null) ? BitmapFactory.decodeFileDescriptor(fileDescriptor) : (Bitmap) invokeL.objValue;
    }

    @DoNotStrip
    public static Bitmap originalDecodeResource(Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65562, null, resources, i2)) == null) ? BitmapFactory.decodeResource(resources, i2) : (Bitmap) invokeLI.objValue;
    }

    @DoNotStrip
    public static Bitmap originalDecodeStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, inputStream)) == null) ? BitmapFactory.decodeStream(inputStream) : (Bitmap) invokeL.objValue;
    }

    @DoNotStrip
    public static Bitmap hookDecodeFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? hookDecodeFile(str, null) : (Bitmap) invokeL.objValue;
    }

    @DoNotStrip
    public static Bitmap hookDecodeResource(Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, resources, i2)) == null) ? hookDecodeResource(resources, i2, null) : (Bitmap) invokeLI.objValue;
    }

    @DoNotStrip
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, bArr, i2, i3)) == null) ? hookDecodeByteArray(bArr, i2, i3, null) : (Bitmap) invokeLII.objValue;
    }

    @DoNotStrip
    public static Bitmap hookDecodeStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, inputStream)) == null) ? hookDecodeStream(inputStream, null, null) : (Bitmap) invokeL.objValue;
    }

    @DoNotStrip
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, fileDescriptor)) == null) ? hookDecodeFileDescriptor(fileDescriptor, null, null) : (Bitmap) invokeL.objValue;
    }
}
