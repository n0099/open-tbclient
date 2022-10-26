package com.facebook.imagepipeline.transcoder;

import android.graphics.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableList;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class JpegTranscoderUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_JPEG_QUALITY = 85;
    public static final int FULL_ROUND = 360;
    public static final ImmutableList INVERTED_EXIF_ORIENTATIONS;
    public static final int MAX_QUALITY = 100;
    public static final int MAX_SCALE_NUMERATOR = 16;
    public static final int MIN_QUALITY = 0;
    public static final int MIN_SCALE_NUMERATOR = 1;
    public static final int SCALE_DENOMINATOR = 8;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean isExifOrientationAllowed(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            switch (i) {
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

    public static int roundNumerator(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? (int) (f2 + (f * 8.0f)) : invokeCommon.intValue;
    }

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int calculateDownsampleNumerator(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return Math.max(1, 8 / i);
        }
        return invokeI.intValue;
    }

    public static int extractOrientationFromMetadata(EncodedImage encodedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, encodedImage)) == null) {
            int rotationAngle = encodedImage.getRotationAngle();
            if (rotationAngle != 90 && rotationAngle != 180 && rotationAngle != 270) {
                return 0;
            }
            return encodedImage.getRotationAngle();
        }
        return invokeL.intValue;
    }

    public static boolean isRotationAngleAllowed(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            if (i >= 0 && i <= 270 && i % 90 == 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static float determineResizeRatio(ResizeOptions resizeOptions, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, resizeOptions, i, i2)) == null) {
            if (resizeOptions == null) {
                return 1.0f;
            }
            float f = i;
            float f2 = i2;
            float max = Math.max(resizeOptions.width / f, resizeOptions.height / f2);
            float f3 = resizeOptions.maxBitmapSize;
            if (f * max > f3) {
                max = f3 / f;
            }
            float f4 = resizeOptions.maxBitmapSize;
            if (f2 * max > f4) {
                return f4 / f2;
            }
            return max;
        }
        return invokeLII.floatValue;
    }

    public static int getForceRotatedInvertedExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, rotationOptions, encodedImage)) == null) {
            int indexOf = INVERTED_EXIF_ORIENTATIONS.indexOf(Integer.valueOf(encodedImage.getExifOrientation()));
            if (indexOf >= 0) {
                int i = 0;
                if (!rotationOptions.useImageMetadata()) {
                    i = rotationOptions.getForcedAngle();
                }
                ImmutableList immutableList = INVERTED_EXIF_ORIENTATIONS;
                return ((Integer) immutableList.get((indexOf + (i / 90)) % immutableList.size())).intValue();
            }
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        return invokeLL.intValue;
    }

    public static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, rotationOptions, encodedImage)) == null) {
            if (!rotationOptions.rotationEnabled()) {
                return 0;
            }
            int extractOrientationFromMetadata = extractOrientationFromMetadata(encodedImage);
            if (rotationOptions.useImageMetadata()) {
                return extractOrientationFromMetadata;
            }
            return (extractOrientationFromMetadata + rotationOptions.getForcedAngle()) % 360;
        }
        return invokeLL.intValue;
    }

    public static int getSoftwareNumerator(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage, boolean z) {
        InterceptResult invokeCommon;
        int i;
        int width;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{rotationOptions, resizeOptions, encodedImage, Boolean.valueOf(z)})) == null) {
            if (!z || resizeOptions == null) {
                return 8;
            }
            int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
            boolean z2 = false;
            if (INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
                i = getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage);
            } else {
                i = 0;
            }
            z2 = (rotationAngle == 90 || rotationAngle == 270 || i == 5 || i == 7) ? true : true;
            if (z2) {
                width = encodedImage.getHeight();
            } else {
                width = encodedImage.getWidth();
            }
            if (z2) {
                height = encodedImage.getWidth();
            } else {
                height = encodedImage.getHeight();
            }
            int roundNumerator = roundNumerator(determineResizeRatio(resizeOptions, width, height), resizeOptions.roundUpFraction);
            if (roundNumerator > 8) {
                return 8;
            }
            if (roundNumerator < 1) {
                return 1;
            }
            return roundNumerator;
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
    public static Matrix getTransformationMatrixFromInvertedExif(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            Matrix matrix = new Matrix();
            if (i != 2) {
                if (i != 7) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        matrix.setRotate(90.0f);
                        matrix.postScale(-1.0f, 1.0f);
                    } else {
                        matrix.setRotate(180.0f);
                        matrix.postScale(-1.0f, 1.0f);
                    }
                } else {
                    matrix.setRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                }
            } else {
                matrix.setScale(-1.0f, 1.0f);
            }
            return matrix;
        }
        return (Matrix) invokeI.objValue;
    }
}
