package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
/* loaded from: classes6.dex */
public final class ThumbnailSizeChecker {
    public static final float ACCEPTABLE_REQUESTED_TO_ACTUAL_SIZE_RATIO = 1.3333334f;
    public static final int ROTATED_90_DEGREES_CLOCKWISE = 90;
    public static final int ROTATED_90_DEGREES_COUNTER_CLOCKWISE = 270;

    public static int getAcceptableSize(int i2) {
        return (int) (i2 * 1.3333334f);
    }

    public static boolean isImageBigEnough(int i2, int i3, ResizeOptions resizeOptions) {
        return resizeOptions == null ? ((float) getAcceptableSize(i2)) >= 2048.0f && getAcceptableSize(i3) >= 2048 : getAcceptableSize(i2) >= resizeOptions.width && getAcceptableSize(i3) >= resizeOptions.height;
    }

    public static boolean isImageBigEnough(EncodedImage encodedImage, ResizeOptions resizeOptions) {
        if (encodedImage == null) {
            return false;
        }
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle != 90 && rotationAngle != 270) {
            return isImageBigEnough(encodedImage.getWidth(), encodedImage.getHeight(), resizeOptions);
        }
        return isImageBigEnough(encodedImage.getHeight(), encodedImage.getWidth(), resizeOptions);
    }
}
