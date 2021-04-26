package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class DefaultImageDecoder implements ImageDecoder {
    public final ImageDecoder mAnimatedGifDecoder;
    public final ImageDecoder mAnimatedWebPDecoder;
    @Nullable
    public final Map<ImageFormat, ImageDecoder> mCustomDecoders;
    public final ImageDecoder mDefaultDecoder;
    public final PlatformDecoder mPlatformDecoder;

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder) {
        this(imageDecoder, imageDecoder2, platformDecoder, null);
    }

    private void maybeApplyTransformation(@Nullable BitmapTransformation bitmapTransformation, CloseableReference<Bitmap> closeableReference) {
        if (bitmapTransformation == null) {
            return;
        }
        Bitmap bitmap = closeableReference.get();
        if (Build.VERSION.SDK_INT >= 12 && bitmapTransformation.modifiesTransparency()) {
            bitmap.setHasAlpha(true);
        }
        bitmapTransformation.transform(bitmap);
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public CloseableImage decode(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        ImageDecoder imageDecoder2 = imageDecodeOptions.customImageDecoder;
        if (imageDecoder2 != null) {
            return imageDecoder2.decode(encodedImage, i2, qualityInfo, imageDecodeOptions);
        }
        ImageFormat imageFormat = encodedImage.getImageFormat();
        if (imageFormat == null || imageFormat == ImageFormat.UNKNOWN) {
            imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
            encodedImage.setImageFormat(imageFormat);
        }
        Map<ImageFormat, ImageDecoder> map = this.mCustomDecoders;
        if (map != null && (imageDecoder = map.get(imageFormat)) != null) {
            return imageDecoder.decode(encodedImage, i2, qualityInfo, imageDecodeOptions);
        }
        return this.mDefaultDecoder.decode(encodedImage, i2, qualityInfo, imageDecodeOptions);
    }

    public CloseableImage decodeAnimatedWebp(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        return this.mAnimatedWebPDecoder.decode(encodedImage, i2, qualityInfo, imageDecodeOptions);
    }

    public CloseableImage decodeGif(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        if (!imageDecodeOptions.forceStaticImage && (imageDecoder = this.mAnimatedGifDecoder) != null) {
            return imageDecoder.decode(encodedImage, i2, qualityInfo, imageDecodeOptions);
        }
        return decodeStaticImage(encodedImage, imageDecodeOptions);
    }

    public CloseableStaticBitmap decodeJpeg(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeJPEGFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, i2, imageDecodeOptions.transformToSRGB);
        try {
            maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeJPEGFromEncodedImageWithColorSpace);
            return new CloseableStaticBitmap(decodeJPEGFromEncodedImageWithColorSpace, qualityInfo, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
        } finally {
            decodeJPEGFromEncodedImageWithColorSpace.close();
        }
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, imageDecodeOptions.transformToSRGB);
        try {
            maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeFromEncodedImageWithColorSpace);
            return new CloseableStaticBitmap(decodeFromEncodedImageWithColorSpace, ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
        } finally {
            decodeFromEncodedImageWithColorSpace.close();
        }
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder, @Nullable Map<ImageFormat, ImageDecoder> map) {
        this.mDefaultDecoder = new ImageDecoder() { // from class: com.facebook.imagepipeline.decoder.DefaultImageDecoder.1
            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            public CloseableImage decode(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                ImageFormat imageFormat = encodedImage.getImageFormat();
                if (imageFormat == DefaultImageFormats.JPEG) {
                    return DefaultImageDecoder.this.decodeJpeg(encodedImage, i2, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == DefaultImageFormats.GIF) {
                    return DefaultImageDecoder.this.decodeGif(encodedImage, i2, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                    return DefaultImageDecoder.this.decodeAnimatedWebp(encodedImage, i2, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat != ImageFormat.UNKNOWN) {
                    return DefaultImageDecoder.this.decodeStaticImage(encodedImage, imageDecodeOptions);
                }
                throw new DecodeException("unknown image format", encodedImage);
            }
        };
        this.mAnimatedGifDecoder = imageDecoder;
        this.mAnimatedWebPDecoder = imageDecoder2;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = map;
    }
}
