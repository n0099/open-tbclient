package com.facebook.imagepipeline.transcoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class DownsampleUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    public static final float INTERVAL_ROUNDING = 0.33333334f;
    public transient /* synthetic */ FieldHolder $fh;

    public DownsampleUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @VisibleForTesting
    public static float determineDownsampleRatio(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, rotationOptions, resizeOptions, encodedImage)) == null) {
            Preconditions.checkArgument(EncodedImage.isMetaDataAvailable(encodedImage));
            if (resizeOptions == null || resizeOptions.height <= 0 || resizeOptions.width <= 0 || encodedImage.getWidth() == 0 || encodedImage.getHeight() == 0) {
                return 1.0f;
            }
            int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
            boolean z = rotationAngle == 90 || rotationAngle == 270;
            int height = z ? encodedImage.getHeight() : encodedImage.getWidth();
            int width = z ? encodedImage.getWidth() : encodedImage.getHeight();
            float f2 = resizeOptions.width / height;
            float f3 = resizeOptions.height / width;
            float max = Math.max(f2, f3);
            FLog.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", Integer.valueOf(resizeOptions.width), Integer.valueOf(resizeOptions.height), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(max));
            return max;
        }
        return invokeLLL.floatValue;
    }

    public static int determineSampleSize(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage, int i2) {
        InterceptResult invokeLLLI;
        int ratioToSampleSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65538, null, rotationOptions, resizeOptions, encodedImage, i2)) == null) {
            if (EncodedImage.isMetaDataAvailable(encodedImage)) {
                float determineDownsampleRatio = determineDownsampleRatio(rotationOptions, resizeOptions, encodedImage);
                if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
                    ratioToSampleSize = ratioToSampleSizeJPEG(determineDownsampleRatio);
                } else {
                    ratioToSampleSize = ratioToSampleSize(determineDownsampleRatio);
                }
                int max = Math.max(encodedImage.getHeight(), encodedImage.getWidth());
                float f2 = resizeOptions != null ? resizeOptions.maxBitmapSize : i2;
                while (max / ratioToSampleSize > f2) {
                    ratioToSampleSize = encodedImage.getImageFormat() == DefaultImageFormats.JPEG ? ratioToSampleSize * 2 : ratioToSampleSize + 1;
                }
                return ratioToSampleSize;
            }
            return 1;
        }
        return invokeLLLI.intValue;
    }

    public static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, rotationOptions, encodedImage)) == null) {
            boolean z = false;
            if (rotationOptions.useImageMetadata()) {
                int rotationAngle = encodedImage.getRotationAngle();
                Preconditions.checkArgument((rotationAngle == 0 || rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) ? true : true);
                return rotationAngle;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    @VisibleForTesting
    public static int ratioToSampleSize(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f2)) != null) {
            return invokeF.intValue;
        }
        if (f2 > 0.6666667f) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            double d2 = i2;
            if ((1.0d / d2) + ((1.0d / (Math.pow(d2, 2.0d) - d2)) * 0.3333333432674408d) <= f2) {
                return i2 - 1;
            }
            i2++;
        }
    }

    @VisibleForTesting
    public static int ratioToSampleSizeJPEG(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeF = interceptable.invokeF(65541, null, f2)) != null) {
            return invokeF.intValue;
        }
        if (f2 > 0.6666667f) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            int i3 = i2 * 2;
            double d2 = 1.0d / i3;
            if (d2 + (0.3333333432674408d * d2) <= f2) {
                return i2;
            }
            i2 = i3;
        }
    }

    @VisibleForTesting
    public static int roundToPowerOfTwo(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) {
            int i3 = 1;
            while (i3 < i2) {
                i3 *= 2;
            }
            return i3;
        }
        return invokeI.intValue;
    }
}
