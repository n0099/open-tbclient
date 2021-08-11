package com.facebook.imageutils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public final class BitmapUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALPHA_8_BYTES_PER_PIXEL = 1;
    public static final int ARGB_4444_BYTES_PER_PIXEL = 2;
    public static final int ARGB_8888_BYTES_PER_PIXEL = 4;
    public static final Pools.SynchronizedPool<ByteBuffer> DECODE_BUFFERS;
    public static final int DECODE_BUFFER_SIZE = 16384;
    public static final float MAX_BITMAP_SIZE = 2048.0f;
    public static final int POOL_SIZE = 12;
    public static final int RGBA_F16_BYTES_PER_PIXEL = 8;
    public static final int RGB_565_BYTES_PER_PIXEL = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.facebook.imageutils.BitmapUtil$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-989043469, "Lcom/facebook/imageutils/BitmapUtil$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-989043469, "Lcom/facebook/imageutils/BitmapUtil$1;");
                    return;
                }
            }
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGBA_F16.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(620199200, "Lcom/facebook/imageutils/BitmapUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(620199200, "Lcom/facebook/imageutils/BitmapUtil;");
                return;
            }
        }
        DECODE_BUFFERS = new Pools.SynchronizedPool<>(12);
    }

    public BitmapUtil() {
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

    @Nullable
    public static Pair<Integer, Integer> decodeDimensions(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) ? decodeDimensions(new ByteArrayInputStream(bArr)) : (Pair) invokeL.objValue;
    }

    public static ImageMetaData decodeDimensionsAndColorSpace(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, inputStream)) == null) {
            Preconditions.checkNotNull(inputStream);
            ByteBuffer acquire = DECODE_BUFFERS.acquire();
            if (acquire == null) {
                acquire = ByteBuffer.allocate(16384);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                options.inTempStorage = acquire.array();
                BitmapFactory.decodeStream(inputStream, null, options);
                return new ImageMetaData(options.outWidth, options.outHeight, Build.VERSION.SDK_INT >= 26 ? options.outColorSpace : null);
            } finally {
                DECODE_BUFFERS.release(acquire);
            }
        }
        return (ImageMetaData) invokeL.objValue;
    }

    public static int getPixelSizeForBitmapConfig(Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, config)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3 || i2 == 4) {
                        return 2;
                    }
                    if (i2 == 5) {
                        return 8;
                    }
                    throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
                }
                return 1;
            }
            return 4;
        }
        return invokeL.intValue;
    }

    public static int getSizeInByteForBitmap(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65543, null, i2, i3, config)) == null) ? i2 * i3 * getPixelSizeForBitmapConfig(config) : invokeIIL.intValue;
    }

    @SuppressLint({"NewApi"})
    public static int getSizeInBytes(@Nullable Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bitmap)) == null) {
            if (bitmap == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT > 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException unused) {
                }
            }
            if (Build.VERSION.SDK_INT >= 12) {
                return bitmap.getByteCount();
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return invokeL.intValue;
    }

    @Nullable
    public static Pair<Integer, Integer> decodeDimensions(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) {
            Preconditions.checkNotNull(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(uri.getPath(), options);
            if (options.outWidth == -1 || options.outHeight == -1) {
                return null;
            }
            return new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
        }
        return (Pair) invokeL.objValue;
    }

    @Nullable
    public static Pair<Integer, Integer> decodeDimensions(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) {
            Preconditions.checkNotNull(inputStream);
            ByteBuffer acquire = DECODE_BUFFERS.acquire();
            if (acquire == null) {
                acquire = ByteBuffer.allocate(16384);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                options.inTempStorage = acquire.array();
                Pair<Integer, Integer> pair = null;
                BitmapFactory.decodeStream(inputStream, null, options);
                if (options.outWidth != -1 && options.outHeight != -1) {
                    pair = new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                }
                return pair;
            } finally {
                DECODE_BUFFERS.release(acquire);
            }
        }
        return (Pair) invokeL.objValue;
    }
}
