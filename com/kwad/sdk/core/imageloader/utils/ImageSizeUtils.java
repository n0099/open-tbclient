package com.kwad.sdk.core.imageloader.utils;

import android.opengl.GLES10;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
/* loaded from: classes5.dex */
public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        maxBitmapSize = new ImageSize(max, max);
    }

    private ImageSizeUtils() {
    }

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int min;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        switch (viewScaleType) {
            case FIT_INSIDE:
                if (!z) {
                    min = Math.max(width / width2, height / height2);
                    break;
                } else {
                    int i = width / 2;
                    int i2 = height / 2;
                    min = 1;
                    while (true) {
                        if (i / min <= width2 && i2 / min <= height2) {
                            break;
                        } else {
                            min *= 2;
                        }
                    }
                }
                break;
            case CROP:
                if (!z) {
                    min = Math.min(width / width2, height / height2);
                    break;
                } else {
                    int i3 = width / 2;
                    int i4 = height / 2;
                    min = 1;
                    while (i3 / min > width2 && i4 / min > height2) {
                        min *= 2;
                    }
                }
                break;
            default:
                min = 1;
                break;
        }
        return considerMaxTextureSize(width, height, min >= 1 ? min : 1, z);
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int i;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f = width / width2;
        float f2 = height / height2;
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f < f2) && (viewScaleType != ViewScaleType.CROP || f >= f2)) {
            width2 = (int) (width / f2);
            i = height2;
        } else {
            i = (int) (height / f);
        }
        if ((z || width2 >= width || i >= height) && (!z || width2 == width || i == height)) {
            return 1.0f;
        }
        return width2 / width;
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        return Math.max((int) Math.ceil(width / maxBitmapSize.getWidth()), (int) Math.ceil(height / maxBitmapSize.getHeight()));
    }

    private static int considerMaxTextureSize(int i, int i2, int i3, boolean z) {
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i / i3 <= width && i2 / i3 <= height) {
                return i3;
            }
            i3 = z ? i3 * 2 : i3 + 1;
        }
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
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
}
