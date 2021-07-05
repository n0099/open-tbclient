package com.facebook.imagepipeline.transcoder;

import android.graphics.Matrix;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class JpegTranscoderUtils {
    public static /* synthetic */ Interceptable $ic = null;
    @VisibleForTesting
    public static final int DEFAULT_JPEG_QUALITY = 85;
    public static final int FULL_ROUND = 360;
    public static final ImmutableList<Integer> INVERTED_EXIF_ORIENTATIONS;
    public static final int MAX_QUALITY = 100;
    public static final int MAX_SCALE_NUMERATOR = 16;
    public static final int MIN_QUALITY = 0;
    public static final int MIN_SCALE_NUMERATOR = 1;
    public static final int SCALE_DENOMINATOR = 8;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431713408, "Lcom/facebook/imagepipeline/transcoder/JpegTranscoderUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431713408, "Lcom/facebook/imagepipeline/transcoder/JpegTranscoderUtils;");
                return;
            }
        }
        INVERTED_EXIF_ORIENTATIONS = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    }

    public JpegTranscoderUtils() {
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

    @VisibleForTesting
    public static int calculateDownsampleNumerator(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? Math.max(1, 8 / i2) : invokeI.intValue;
    }

    @VisibleForTesting
    public static float determineResizeRatio(ResizeOptions resizeOptions, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, resizeOptions, i2, i3)) == null) {
            if (resizeOptions == null) {
                return 1.0f;
            }
            float f2 = i2;
            float f3 = i3;
            float max = Math.max(resizeOptions.width / f2, resizeOptions.height / f3);
            float f4 = resizeOptions.maxBitmapSize;
            if (f2 * max > f4) {
                max = f4 / f2;
            }
            float f5 = resizeOptions.maxBitmapSize;
            return f3 * max > f5 ? f5 / f3 : max;
        }
        return invokeLII.floatValue;
    }

    public static int extractOrientationFromMetadata(EncodedImage encodedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, encodedImage)) == null) {
            int rotationAngle = encodedImage.getRotationAngle();
            if (rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) {
                return encodedImage.getRotationAngle();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getForceRotatedInvertedExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, rotationOptions, encodedImage)) == null) {
            int indexOf = INVERTED_EXIF_ORIENTATIONS.indexOf(Integer.valueOf(encodedImage.getExifOrientation()));
            if (indexOf >= 0) {
                int forcedAngle = rotationOptions.useImageMetadata() ? 0 : rotationOptions.getForcedAngle();
                ImmutableList<Integer> immutableList = INVERTED_EXIF_ORIENTATIONS;
                return immutableList.get((indexOf + (forcedAngle / 90)) % immutableList.size()).intValue();
            }
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        return invokeLL.intValue;
    }

    public static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, rotationOptions, encodedImage)) == null) {
            if (rotationOptions.rotationEnabled()) {
                int extractOrientationFromMetadata = extractOrientationFromMetadata(encodedImage);
                return rotationOptions.useImageMetadata() ? extractOrientationFromMetadata : (extractOrientationFromMetadata + rotationOptions.getForcedAngle()) % 360;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static int getSoftwareNumerator(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{rotationOptions, resizeOptions, encodedImage, Boolean.valueOf(z)})) == null) {
            if (z && resizeOptions != null) {
                int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
                boolean z2 = false;
                int forceRotatedInvertedExifOrientation = INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation())) ? getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage) : 0;
                z2 = (rotationAngle == 90 || rotationAngle == 270 || forceRotatedInvertedExifOrientation == 5 || forceRotatedInvertedExifOrientation == 7) ? true : true;
                int roundNumerator = roundNumerator(determineResizeRatio(resizeOptions, z2 ? encodedImage.getHeight() : encodedImage.getWidth(), z2 ? encodedImage.getWidth() : encodedImage.getHeight()), resizeOptions.roundUpFraction);
                if (roundNumerator > 8) {
                    return 8;
                }
                if (roundNumerator < 1) {
                    return 1;
                }
                return roundNumerator;
            }
            return 8;
        }
        return invokeCommon.intValue;
    }

    @Nullable
    public static Matrix getTransformationMatrix(EncodedImage encodedImage, RotationOptions rotationOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, encodedImage, rotationOptions)) == null) {
            if (INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
                return getTransformationMatrixFromInvertedExif(getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage));
            }
            int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
            if (rotationAngle != 0) {
                Matrix matrix = new Matrix();
                matrix.setRotate(rotationAngle);
                return matrix;
            }
            return null;
        }
        return (Matrix) invokeLL.objValue;
    }

    @Nullable
    public static Matrix getTransformationMatrixFromInvertedExif(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            Matrix matrix = new Matrix();
            if (i2 == 2) {
                matrix.setScale(-1.0f, 1.0f);
            } else if (i2 == 7) {
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
            } else if (i2 == 4) {
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
            } else if (i2 != 5) {
                return null;
            } else {
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
            }
            return matrix;
        }
        return (Matrix) invokeI.objValue;
    }

    public static boolean isExifOrientationAllowed(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static boolean isRotationAngleAllowed(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? i2 >= 0 && i2 <= 270 && i2 % 90 == 0 : invokeI.booleanValue;
    }

    @VisibleForTesting
    public static int roundNumerator(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (int) (f3 + (f2 * 8.0f)) : invokeCommon.intValue;
    }
}
