package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public abstract class PlatformBitmapFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1481703758, "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1481703758, "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory$1;");
                    return;
                }
            }
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 1;
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
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public PlatformBitmapFactory() {
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

    public static void checkFinalImageBounds(Bitmap bitmap, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            Preconditions.checkArgument(i + i3 <= bitmap.getWidth(), "x + width must be <= bitmap.width()");
            Preconditions.checkArgument(i2 + i4 <= bitmap.getHeight(), "y + height must be <= bitmap.height()");
        }
    }

    public static void checkWidthHeight(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, null, i, i2) == null) {
            Preconditions.checkArgument(i > 0, "width must be > 0");
            Preconditions.checkArgument(i2 > 0, "height must be > 0");
        }
    }

    public static void checkXYSign(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, null, i, i2) == null) {
            Preconditions.checkArgument(i >= 0, "x must be >= 0");
            Preconditions.checkArgument(i2 >= 0, "y must be >= 0");
        }
    }

    public static Bitmap.Config getSuitableBitmapConfig(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bitmap)) == null) {
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            Bitmap.Config config2 = bitmap.getConfig();
            if (config2 != null) {
                int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config2.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        return Bitmap.Config.ARGB_8888;
                    }
                    return Bitmap.Config.ALPHA_8;
                }
                return Bitmap.Config.RGB_565;
            }
            return config;
        }
        return (Bitmap.Config) invokeL.objValue;
    }

    public static void setPropertyFromSourceBitmap(Bitmap bitmap, Bitmap bitmap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, bitmap, bitmap2) == null) {
            bitmap2.setDensity(bitmap.getDensity());
            if (Build.VERSION.SDK_INT >= 12) {
                bitmap2.setHasAlpha(bitmap.hasAlpha());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                bitmap2.setPremultiplied(bitmap.isPremultiplied());
            }
        }
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, config)) == null) ? createBitmap(i, i2, config, (Object) null) : (CloseableReference) invokeIIL.objValue;
    }

    public abstract CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Bitmap.Config config);

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? createScaledBitmap(bitmap, i, i2, z, null) : (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) ? createBitmap(i, i2, Bitmap.Config.ARGB_8888) : (CloseableReference) invokeII.objValue;
    }

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap bitmap, int i, int i2, boolean z, @Nullable Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), obj})) == null) {
            checkWidthHeight(i, i2);
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            matrix.setScale(i / width, i2 / height);
            return createBitmap(bitmap, 0, 0, width, height, matrix, z, obj);
        }
        return (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config, @Nullable Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), config, obj})) == null) ? createBitmapInternal(i, i2, config) : (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(int i, int i2, @Nullable Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i, i2, obj)) == null) ? createBitmap(i, i2, Bitmap.Config.ARGB_8888, obj) : (CloseableReference) invokeIIL.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bitmap)) == null) ? createBitmap(bitmap, (Object) null) : (CloseableReference) invokeL.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, @Nullable Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bitmap, obj)) == null) ? createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), obj) : (CloseableReference) invokeLL.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? createBitmap(bitmap, i, i2, i3, i4, (Object) null) : (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, @Nullable Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj})) == null) ? createBitmap(bitmap, i, i2, i3, i4, (Matrix) null, false, obj) : (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, @Nullable Matrix matrix, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), matrix, Boolean.valueOf(z)})) == null) ? createBitmap(bitmap, i, i2, i3, i4, matrix, z, (Object) null) : (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, @Nullable Matrix matrix, boolean z, @Nullable Object obj) {
        InterceptResult invokeCommon;
        CloseableReference<Bitmap> createBitmap;
        Canvas canvas;
        Paint paint;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), matrix, Boolean.valueOf(z), obj})) == null) {
            Preconditions.checkNotNull(bitmap, "Source bitmap cannot be null");
            checkXYSign(i, i2);
            checkWidthHeight(i3, i4);
            checkFinalImageBounds(bitmap, i, i2, i3, i4);
            Rect rect = new Rect(i, i2, i + i3, i2 + i4);
            RectF rectF = new RectF(0.0f, 0.0f, i3, i4);
            Bitmap.Config suitableBitmapConfig = getSuitableBitmapConfig(bitmap);
            if (matrix != null && !matrix.isIdentity()) {
                boolean z2 = !matrix.rectStaysRect();
                RectF rectF2 = new RectF();
                matrix.mapRect(rectF2, rectF);
                int round = Math.round(rectF2.width());
                int round2 = Math.round(rectF2.height());
                if (z2) {
                    suitableBitmapConfig = Bitmap.Config.ARGB_8888;
                }
                createBitmap = createBitmap(round, round2, suitableBitmapConfig, z2 || bitmap.hasAlpha(), obj);
                setPropertyFromSourceBitmap(bitmap, createBitmap.get());
                canvas = new Canvas(createBitmap.get());
                canvas.translate(-rectF2.left, -rectF2.top);
                canvas.concat(matrix);
                paint = new Paint();
                paint.setFilterBitmap(z);
                if (z2) {
                    paint.setAntiAlias(true);
                }
            } else {
                createBitmap = createBitmap(i3, i4, suitableBitmapConfig, bitmap.hasAlpha(), obj);
                setPropertyFromSourceBitmap(bitmap, createBitmap.get());
                canvas = new Canvas(createBitmap.get());
                paint = null;
            }
            canvas.drawBitmap(bitmap, rect, rectF, paint);
            canvas.setBitmap(null);
            return createBitmap;
        }
        return (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Bitmap.Config config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{displayMetrics, Integer.valueOf(i), Integer.valueOf(i2), config})) == null) ? createBitmap(displayMetrics, i, i2, config, (Object) null) : (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Bitmap.Config config, @Nullable Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{displayMetrics, Integer.valueOf(i), Integer.valueOf(i2), config, obj})) == null) ? createBitmap(displayMetrics, i, i2, config, true, obj) : (CloseableReference) invokeCommon.objValue;
    }

    private CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), config, Boolean.valueOf(z)})) == null) ? createBitmap(i, i2, config, z, (Object) null) : (CloseableReference) invokeCommon.objValue;
    }

    private CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config, boolean z, @Nullable Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), config, Boolean.valueOf(z), obj})) == null) ? createBitmap((DisplayMetrics) null, i, i2, config, z, obj) : (CloseableReference) invokeCommon.objValue;
    }

    private CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Bitmap.Config config, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{displayMetrics, Integer.valueOf(i), Integer.valueOf(i2), config, Boolean.valueOf(z)})) == null) ? createBitmap(displayMetrics, i, i2, config, z, (Object) null) : (CloseableReference) invokeCommon.objValue;
    }

    private CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int i, int i2, Bitmap.Config config, boolean z, @Nullable Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{displayMetrics, Integer.valueOf(i), Integer.valueOf(i2), config, Boolean.valueOf(z), obj})) == null) {
            checkWidthHeight(i, i2);
            CloseableReference<Bitmap> createBitmapInternal = createBitmapInternal(i, i2, config);
            Bitmap bitmap = createBitmapInternal.get();
            if (displayMetrics != null) {
                bitmap.setDensity(displayMetrics.densityDpi);
            }
            if (Build.VERSION.SDK_INT >= 12) {
                bitmap.setHasAlpha(z);
            }
            if (config == Bitmap.Config.ARGB_8888 && !z) {
                bitmap.eraseColor(-16777216);
            }
            return createBitmapInternal;
        }
        return (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(int[] iArr, int i, int i2, Bitmap.Config config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{iArr, Integer.valueOf(i), Integer.valueOf(i2), config})) == null) ? createBitmap(iArr, i, i2, config, (Object) null) : (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(int[] iArr, int i, int i2, Bitmap.Config config, @Nullable Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{iArr, Integer.valueOf(i), Integer.valueOf(i2), config, obj})) == null) {
            CloseableReference<Bitmap> createBitmapInternal = createBitmapInternal(i, i2, config);
            createBitmapInternal.get().setPixels(iArr, 0, i, 0, 0, i, i2);
            return createBitmapInternal;
        }
        return (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, Bitmap.Config config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{displayMetrics, iArr, Integer.valueOf(i), Integer.valueOf(i2), config})) == null) ? createBitmap(displayMetrics, iArr, i, i2, config, (Object) null) : (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, Bitmap.Config config, @Nullable Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{displayMetrics, iArr, Integer.valueOf(i), Integer.valueOf(i2), config, obj})) == null) ? createBitmap(displayMetrics, iArr, 0, i, i, i2, config, obj) : (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, int i3, int i4, Bitmap.Config config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{displayMetrics, iArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), config})) == null) ? createBitmap(displayMetrics, iArr, i, i2, i3, i4, config, (Object) null) : (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, int i3, int i4, Bitmap.Config config, @Nullable Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{displayMetrics, iArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), config, obj})) == null) {
            CloseableReference<Bitmap> createBitmap = createBitmap(displayMetrics, i3, i4, config, obj);
            createBitmap.get().setPixels(iArr, i, i2, 0, 0, i3, i4);
            return createBitmap;
        }
        return (CloseableReference) invokeCommon.objValue;
    }
}
