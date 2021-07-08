package com.kwad.sdk.core.imageloader.utils;

import android.opengl.GLES10;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
/* loaded from: classes6.dex */
public final class ImageSizeUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    public static ImageSize maxBitmapSize;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1237657765, "Lcom/kwad/sdk/core/imageloader/utils/ImageSizeUtils$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1237657765, "Lcom/kwad/sdk/core/imageloader/utils/ImageSizeUtils$1;");
                    return;
                }
            }
            int[] iArr = new int[ViewScaleType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType = iArr;
            try {
                iArr[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[ViewScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(135365970, "Lcom/kwad/sdk/core/imageloader/utils/ImageSizeUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(135365970, "Lcom/kwad/sdk/core/imageloader/utils/ImageSizeUtils;");
                return;
            }
        }
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        maxBitmapSize = new ImageSize(max, max);
    }

    public ImageSizeUtils() {
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

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        InterceptResult invokeCommon;
        int max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{imageSize, imageSize2, viewScaleType, Boolean.valueOf(z)})) == null) {
            int width = imageSize.getWidth();
            int height = imageSize.getHeight();
            int width2 = imageSize2.getWidth();
            int height2 = imageSize2.getHeight();
            int i2 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[viewScaleType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    max = 1;
                } else if (z) {
                    int i3 = width / 2;
                    int i4 = height / 2;
                    max = 1;
                    while (i3 / max > width2 && i4 / max > height2) {
                        max *= 2;
                    }
                } else {
                    max = Math.min(width / width2, height / height2);
                }
            } else if (z) {
                int i5 = width / 2;
                int i6 = height / 2;
                max = 1;
                while (true) {
                    if (i5 / max <= width2 && i6 / max <= height2) {
                        break;
                    }
                    max *= 2;
                }
            } else {
                max = Math.max(width / width2, height / height2);
            }
            return considerMaxTextureSize(width, height, max >= 1 ? max : 1, z);
        }
        return invokeCommon.intValue;
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{imageSize, imageSize2, viewScaleType, Boolean.valueOf(z)})) == null) {
            int width = imageSize.getWidth();
            int height = imageSize.getHeight();
            int width2 = imageSize2.getWidth();
            int height2 = imageSize2.getHeight();
            float f2 = width;
            float f3 = f2 / width2;
            float f4 = height;
            float f5 = f4 / height2;
            if ((viewScaleType != ViewScaleType.FIT_INSIDE || f3 < f5) && (viewScaleType != ViewScaleType.CROP || f3 >= f5)) {
                width2 = (int) (f2 / f5);
            } else {
                height2 = (int) (f4 / f3);
            }
            if ((z || width2 >= width || height2 >= height) && (!z || width2 == width || height2 == height)) {
                return 1.0f;
            }
            return width2 / f2;
        }
        return invokeCommon.floatValue;
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, imageSize)) == null) {
            return Math.max((int) Math.ceil(imageSize.getWidth() / maxBitmapSize.getWidth()), (int) Math.ceil(imageSize.getHeight() / maxBitmapSize.getHeight()));
        }
        return invokeL.intValue;
    }

    public static int considerMaxTextureSize(int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) != null) {
            return invokeCommon.intValue;
        }
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i2 / i4 <= width && i3 / i4 <= height) {
                return i4;
            }
            i4 = z ? i4 * 2 : i4 + 1;
        }
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, imageAware, imageSize)) == null) {
            int width = imageAware.getWidth();
            if (width <= 0) {
                width = imageSize.getWidth();
            }
            int height = imageAware.getHeight();
            if (height <= 0) {
                height = imageSize.getHeight();
            }
            return new ImageSize(width, height);
        }
        return (ImageSize) invokeLL.objValue;
    }
}
