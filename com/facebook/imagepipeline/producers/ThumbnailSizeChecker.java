package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
/* loaded from: classes9.dex */
public final class ThumbnailSizeChecker {
    public static final float ACCEPTABLE_REQUESTED_TO_ACTUAL_SIZE_RATIO = 1.3333334f;
    public static final int ROTATED_90_DEGREES_CLOCKWISE = 90;
    public static final int ROTATED_90_DEGREES_COUNTER_CLOCKWISE = 270;

    public static int getAcceptableSize(int i) {
        return (int) (i * 1.3333334f);
    }

    public static boolean isImageBigEnough(int i, int i2, ResizeOptions resizeOptions) {
        if (resizeOptions == null) {
            if (getAcceptableSize(i) >= 2048.0f && getAcceptableSize(i2) >= 2048) {
                return true;
            }
            return false;
        } else if (getAcceptableSize(i) >= resizeOptions.width && getAcceptableSize(i2) >= resizeOptions.height) {
            return true;
        } else {
            return false;
        }
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
