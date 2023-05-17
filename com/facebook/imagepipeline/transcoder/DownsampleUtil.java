package com.facebook.imagepipeline.transcoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class DownsampleUtil {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    public static final float INTERVAL_ROUNDING = 0.33333334f;

    @VisibleForTesting
    public static int ratioToSampleSizeJPEG(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            int i2 = i * 2;
            double d = 1.0d / i2;
            if (d + (0.3333333432674408d * d) <= f) {
                return i;
            }
            i = i2;
        }
    }

    @VisibleForTesting
    public static int roundToPowerOfTwo(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 *= 2;
        }
        return i2;
    }

    @VisibleForTesting
    public static float determineDownsampleRatio(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage) {
        boolean z;
        int width;
        int height;
        Preconditions.checkArgument(EncodedImage.isMetaDataAvailable(encodedImage));
        if (resizeOptions != null && resizeOptions.height > 0 && resizeOptions.width > 0 && encodedImage.getWidth() != 0 && encodedImage.getHeight() != 0) {
            int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
            if (rotationAngle != 90 && rotationAngle != 270) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                width = encodedImage.getHeight();
            } else {
                width = encodedImage.getWidth();
            }
            if (z) {
                height = encodedImage.getWidth();
            } else {
                height = encodedImage.getHeight();
            }
            float f = resizeOptions.width / width;
            float f2 = resizeOptions.height / height;
            float max = Math.max(f, f2);
            FLog.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", Integer.valueOf(resizeOptions.width), Integer.valueOf(resizeOptions.height), Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(max));
            return max;
        }
        return 1.0f;
    }

    public static int determineSampleSize(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage, int i) {
        int ratioToSampleSize;
        float f;
        if (!EncodedImage.isMetaDataAvailable(encodedImage)) {
            return 1;
        }
        float determineDownsampleRatio = determineDownsampleRatio(rotationOptions, resizeOptions, encodedImage);
        if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
            ratioToSampleSize = ratioToSampleSizeJPEG(determineDownsampleRatio);
        } else {
            ratioToSampleSize = ratioToSampleSize(determineDownsampleRatio);
        }
        int max = Math.max(encodedImage.getHeight(), encodedImage.getWidth());
        if (resizeOptions != null) {
            f = resizeOptions.maxBitmapSize;
        } else {
            f = i;
        }
        while (max / ratioToSampleSize > f) {
            if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
                ratioToSampleSize *= 2;
            } else {
                ratioToSampleSize++;
            }
        }
        return ratioToSampleSize;
    }

    public static int determineSampleSizeJPEG(EncodedImage encodedImage, int i, int i2) {
        int sampleSize = encodedImage.getSampleSize();
        while ((((encodedImage.getWidth() * encodedImage.getHeight()) * i) / sampleSize) / sampleSize > i2) {
            sampleSize *= 2;
        }
        return sampleSize;
    }

    public static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        boolean z = false;
        if (!rotationOptions.useImageMetadata()) {
            return 0;
        }
        int rotationAngle = encodedImage.getRotationAngle();
        Preconditions.checkArgument((rotationAngle == 0 || rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) ? true : true);
        return rotationAngle;
    }

    @VisibleForTesting
    public static int ratioToSampleSize(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            double d = i;
            if ((1.0d / d) + ((1.0d / (Math.pow(d, 2.0d) - d)) * 0.3333333432674408d) <= f) {
                return i - 1;
            }
            i++;
        }
    }
}
