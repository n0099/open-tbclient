package com.facebook.imagepipeline.transcoder;

import android.graphics.Matrix;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
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

    @VisibleForTesting
    public static int roundNumerator(float f, float f2) {
        return (int) (f2 + (f * 8.0f));
    }

    @VisibleForTesting
    public static int calculateDownsampleNumerator(int i) {
        return Math.max(1, 8 / i);
    }

    public static int extractOrientationFromMetadata(EncodedImage encodedImage) {
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle != 90 && rotationAngle != 180 && rotationAngle != 270) {
            return 0;
        }
        return encodedImage.getRotationAngle();
    }

    public static boolean isRotationAngleAllowed(int i) {
        if (i >= 0 && i <= 270 && i % 90 == 0) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public static float determineResizeRatio(ResizeOptions resizeOptions, int i, int i2) {
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

    public static int getForceRotatedInvertedExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        int indexOf = INVERTED_EXIF_ORIENTATIONS.indexOf(Integer.valueOf(encodedImage.getExifOrientation()));
        if (indexOf >= 0) {
            int i = 0;
            if (!rotationOptions.useImageMetadata()) {
                i = rotationOptions.getForcedAngle();
            }
            ImmutableList<Integer> immutableList = INVERTED_EXIF_ORIENTATIONS;
            return immutableList.get((indexOf + (i / 90)) % immutableList.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    public static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (!rotationOptions.rotationEnabled()) {
            return 0;
        }
        int extractOrientationFromMetadata = extractOrientationFromMetadata(encodedImage);
        if (rotationOptions.useImageMetadata()) {
            return extractOrientationFromMetadata;
        }
        return (extractOrientationFromMetadata + rotationOptions.getForcedAngle()) % 360;
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

    public static int getSoftwareNumerator(RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, EncodedImage encodedImage, boolean z) {
        int i;
        int width;
        int height;
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

    @Nullable
    public static Matrix getTransformationMatrixFromInvertedExif(int i) {
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
}
