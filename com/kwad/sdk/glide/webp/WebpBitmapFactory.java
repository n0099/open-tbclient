package com.kwad.sdk.glide.webp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.Keep;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
@Keep
/* loaded from: classes7.dex */
public class WebpBitmapFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IN_TEMP_BUFFER_SIZE = 8192;
    public static final int MAX_WEBP_HEADER_SIZE = 21;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-498626166, "Lcom/kwad/sdk/glide/webp/WebpBitmapFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-498626166, "Lcom/kwad/sdk/glide/webp/WebpBitmapFactory;");
                return;
            }
        }
        try {
            System.loadLibrary("glide-webp");
        } catch (Throwable unused) {
        }
    }

    public WebpBitmapFactory() {
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

    @Keep
    public static Bitmap createBitmap(int i2, int i3, BitmapFactory.Options options) {
        InterceptResult invokeIIL;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i2, i3, options)) == null) {
            if (options == null || (bitmap = options.inBitmap) == null || !bitmap.isMutable()) {
                Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                createBitmap.setHasAlpha(true);
                createBitmap.eraseColor(0);
                return createBitmap;
            }
            return options.inBitmap;
        }
        return (Bitmap) invokeIIL.objValue;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) ? decodeByteArray(bArr, i2, i3, null) : (Bitmap) invokeLII.objValue;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i2, int i3, BitmapFactory.Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) {
            if ((i2 | i3) < 0 || bArr.length < i2 + i3) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (webpSupportRequired(bArr, i2, i3)) {
                Bitmap nativeDecodeByteArray = nativeDecodeByteArray(bArr, i2, i3, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                setWebpBitmapOptions(nativeDecodeByteArray, options);
                return nativeDecodeByteArray;
            }
            return BitmapFactory.decodeByteArray(bArr, i2, i3, options);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap decodeFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? decodeFile(str, null) : (Bitmap) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0005 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:0x0012 */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        if (r1 == null) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeFile(String str, BitmapFactory.Options options) {
        ?? r1;
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = (r1 = interceptable).invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, options)) != null) {
            return (Bitmap) invokeLL.objValue;
        }
        InputStream inputStream = null;
        r0 = null;
        Bitmap bitmap = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    bitmap = decodeStream(fileInputStream, null, options);
                    r1 = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    Log.e("WebpBitmapFactory", "Unable to decode stream: " + e);
                    r1 = fileInputStream;
                }
            } catch (Throwable th) {
                th = th;
                inputStream = r1;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
            }
            throw th;
        }
        try {
            r1.close();
        } catch (IOException unused2) {
            return bitmap;
        }
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fileDescriptor)) == null) ? decodeFileDescriptor(fileDescriptor, null, null) : (Bitmap) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        InterceptResult invokeLLL;
        Bitmap decodeFileDescriptor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, fileDescriptor, rect, options)) == null) {
            InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(new FileInputStream(fileDescriptor));
            try {
                if (webpSupportRequired(getImageHeader(wrapToMarkSupportedStream), 0, 21)) {
                    decodeFileDescriptor = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                    setWebpBitmapOptions(decodeFileDescriptor, options);
                    setDefaultPadding(rect);
                } else {
                    decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
                }
                return decodeFileDescriptor;
            } finally {
                try {
                    wrapToMarkSupportedStream.close();
                } catch (Throwable unused) {
                }
            }
        }
        return (Bitmap) invokeLLL.objValue;
    }

    public static Bitmap decodeResource(Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, resources, i2)) == null) ? decodeResource(resources, i2, null) : (Bitmap) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
        if (r5 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
        if (r5 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        r5.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeResource(Resources resources, int i2, BitmapFactory.Options options) {
        InterceptResult invokeLIL;
        InputStream inputStream;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIL = interceptable.invokeLIL(65546, null, resources, i2, options)) != null) {
            return (Bitmap) invokeLIL.objValue;
        }
        InputStream inputStream2 = null;
        bitmap = null;
        bitmap = null;
        try {
            TypedValue typedValue = new TypedValue();
            inputStream = resources.openRawResource(i2, typedValue);
            try {
                bitmap = decodeResourceStream(resources, typedValue, inputStream, null, options);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (bitmap != null || options == null || options.inBitmap == null) {
            return bitmap;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r5 != 65535) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65547, null, resources, typedValue, inputStream, rect, options)) == null) {
            if (options == null) {
                options = new BitmapFactory.Options();
            }
            if (options.inDensity == 0 && typedValue != null) {
                int i2 = typedValue.density;
                if (i2 == 0) {
                    i2 = 160;
                }
                options.inDensity = i2;
            }
            if (options.inTargetDensity == 0 && resources != null) {
                options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
            }
            return decodeStream(inputStream, rect, options);
        }
        return (Bitmap) invokeLLLLL.objValue;
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, inputStream)) == null) ? decodeStream(inputStream, null, null) : (Bitmap) invokeL.objValue;
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, inputStream, rect, options)) == null) {
            if (inputStream == null) {
                return null;
            }
            InputStream wrapToMarkSupportedStream = wrapToMarkSupportedStream(inputStream);
            if (webpSupportRequired(getImageHeader(wrapToMarkSupportedStream), 0, 21)) {
                Bitmap nativeDecodeStream = nativeDecodeStream(wrapToMarkSupportedStream, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                setWebpBitmapOptions(nativeDecodeStream, options);
                setDefaultPadding(rect);
                return nativeDecodeStream;
            }
            return BitmapFactory.decodeStream(wrapToMarkSupportedStream, rect, options);
        }
        return (Bitmap) invokeLLL.objValue;
    }

    public static byte[] getImageHeader(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, inputStream)) == null) {
            if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream, 21);
            }
            inputStream.mark(21);
            byte[] bArr = new byte[21];
            try {
                inputStream.read(bArr, 0, 21);
                inputStream.reset();
                return bArr;
            } catch (IOException unused) {
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] getInTempStorageFromOptions(BitmapFactory.Options options) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, options)) == null) ? (options == null || (bArr = options.inTempStorage) == null) ? new byte[8192] : bArr : (byte[]) invokeL.objValue;
    }

    public static float getScaleFromOptions(BitmapFactory.Options options) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, options)) == null) {
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

    public static native Bitmap nativeDecodeByteArray(byte[] bArr, int i2, int i3, BitmapFactory.Options options, float f2, byte[] bArr2);

    public static native Bitmap nativeDecodeStream(InputStream inputStream, BitmapFactory.Options options, float f2, byte[] bArr);

    public static void setDefaultPadding(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, rect) == null) || rect == null) {
            return;
        }
        rect.top = -1;
        rect.left = -1;
        rect.bottom = -1;
        rect.right = -1;
    }

    public static void setDensityFromOptions(Bitmap bitmap, BitmapFactory.Options options) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, null, bitmap, options) == null) || bitmap == null || options == null) {
            return;
        }
        int i2 = options.inDensity;
        if (i2 == 0) {
            if (options.inBitmap != null) {
                bitmap.setDensity(160);
                return;
            }
            return;
        }
        bitmap.setDensity(i2);
        int i3 = options.inTargetDensity;
        if (i3 == 0 || i2 == i3 || i2 == options.inScreenDensity || !options.inScaled) {
            return;
        }
        bitmap.setDensity(i3);
    }

    @Keep
    public static boolean setOutDimensions(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65557, null, options, i2, i3)) == null) {
            if (options != null) {
                options.outWidth = i2;
                options.outHeight = i3;
                return options.inJustDecodeBounds;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public static void setWebpBitmapOptions(Bitmap bitmap, BitmapFactory.Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, bitmap, options) == null) {
            setDensityFromOptions(bitmap, options);
            if (options != null) {
                options.outMimeType = "image/webp";
            }
        }
    }

    public static boolean webpSupportRequired(byte[] bArr, int i2, int i3) {
        WebpHeaderParser.WebpImageType webpImageType;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65559, null, bArr, i2, i3)) == null) {
            try {
                webpImageType = WebpHeaderParser.a(bArr, i2, i3);
            } catch (IOException unused) {
                webpImageType = WebpHeaderParser.WebpImageType.NONE_WEBP;
            }
            return Build.VERSION.SDK_INT <= 17 && WebpHeaderParser.b(webpImageType);
        }
        return invokeLII.booleanValue;
    }

    public static InputStream wrapToMarkSupportedStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, inputStream)) == null) ? !inputStream.markSupported() ? new BufferedInputStream(inputStream, 8192) : inputStream : (InputStream) invokeL.objValue;
    }
}
