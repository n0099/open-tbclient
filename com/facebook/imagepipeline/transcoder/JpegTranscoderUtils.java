package com.facebook.imagepipeline.transcoder;

import android.graphics.Matrix;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class JpegTranscoderUtils {
    @VisibleForTesting
    public static final int DEFAULT_JPEG_QUALITY = 85;
    public static final int FULL_ROUND = 360;
    public static final ImmutableList<Integer> INVERTED_EXIF_ORIENTATIONS = ImmutableList.of((Object[]) new Integer[]{2, 7, 4, 5});
    public static final int MAX_QUALITY = 100;
    public static final int MAX_SCALE_NUMERATOR = 16;
    public static final int MIN_QUALITY = 0;
    public static final int MIN_SCALE_NUMERATOR = 1;
    public static final int SCALE_DENOMINATOR = 8;

    @VisibleForTesting
    public static int calculateDownsampleNumerator(int i) {
        return Math.max(1, 8 / i);
    }

    @VisibleForTesting
    public static float determineResizeRatio(ResizeOptions resizeOptions, int i, int i2) {
        if (resizeOptions == null) {
            return 1.0f;
        }
        float f2 = i;
        float f3 = i2;
        float max = Math.max(resizeOptions.width / f2, resizeOptions.height / f3);
        float f4 = resizeOptions.maxBitmapSize;
        if (f2 * max > f4) {
            max = f4 / f2;
        }
        float f5 = resizeOptions.maxBitmapSize;
        return f3 * max > f5 ? f5 / f3 : max;
    }

    public static int extractOrientationFromMetadata(EncodedImage encodedImage) {
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) {
            return encodedImage.getRotationAngle();
        }
        return 0;
    }

    public static int getForceRotatedInvertedExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        int indexOf = INVERTED_EXIF_ORIENTATIONS.indexOf(Integer.valueOf(encodedImage.getExifOrientation()));
        if (indexOf >= 0) {
            int forcedAngle = rotationOptions.useImageMetadata() ? 0 : rotationOptions.getForcedAngle();
            ImmutableList<Integer> immutableList = INVERTED_EXIF_ORIENTATIONS;
            return immutableList.get((indexOf + (forcedAngle / 90)) % immutableList.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    public static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (rotationOptions.rotationEnabled()) {
            int extractOrientationFromMetadata = extractOrientationFromMetadata(encodedImage);
            return rotationOptions.useImageMetadata() ? extractOrientationFromMetadata : (extractOrientationFromMetadata + rotationOptions.getForcedAngle()) % 360;
        }
        return 0;
    }

    public static int getSoftwareNumerator(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage, boolean z) {
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

    @Nullable
    public static Matrix getTransformationMatrix(EncodedImage encodedImage, RotationOptions rotationOptions) {
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

    @Nullable
    public static Matrix getTransformationMatrixFromInvertedExif(int i) {
        Matrix matrix = new Matrix();
        if (i == 2) {
            matrix.setScale(-1.0f, 1.0f);
        } else if (i == 7) {
            matrix.setRotate(-90.0f);
            matrix.postScale(-1.0f, 1.0f);
        } else if (i == 4) {
            matrix.setRotate(180.0f);
            matrix.postScale(-1.0f, 1.0f);
        } else if (i != 5) {
            return null;
        } else {
            matrix.setRotate(90.0f);
            matrix.postScale(-1.0f, 1.0f);
        }
        return matrix;
    }

    public static boolean isExifOrientationAllowed(int i) {
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

    public static boolean isRotationAngleAllowed(int i) {
        return i >= 0 && i <= 270 && i % 90 == 0;
    }

    @VisibleForTesting
    public static int roundNumerator(float f2, float f3) {
        return (int) (f3 + (f2 * 8.0f));
    }
}
