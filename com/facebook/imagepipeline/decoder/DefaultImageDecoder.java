package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ImageDecoder mAnimatedGifDecoder;
    public final ImageDecoder mAnimatedWebPDecoder;
    @Nullable
    public final Map<ImageFormat, ImageDecoder> mCustomDecoders;
    public final ImageDecoder mDefaultDecoder;
    public final PlatformDecoder mPlatformDecoder;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder) {
        this(imageDecoder, imageDecoder2, platformDecoder, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageDecoder, imageDecoder2, platformDecoder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ImageDecoder) objArr2[0], (ImageDecoder) objArr2[1], (PlatformDecoder) objArr2[2], (Map) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void maybeApplyTransformation(@Nullable BitmapTransformation bitmapTransformation, CloseableReference<Bitmap> closeableReference) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, bitmapTransformation, closeableReference) == null) || bitmapTransformation == null) {
            return;
        }
        Bitmap bitmap = closeableReference.get();
        if (Build.VERSION.SDK_INT >= 12 && bitmapTransformation.modifiesTransparency()) {
            bitmap.setHasAlpha(true);
        }
        bitmapTransformation.transform(bitmap);
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeLILL;
        ImageDecoder imageDecoder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048576, this, encodedImage, i, qualityInfo, imageDecodeOptions)) == null) {
            ImageDecoder imageDecoder2 = imageDecodeOptions.customImageDecoder;
            if (imageDecoder2 != null) {
                return imageDecoder2.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            ImageFormat imageFormat = encodedImage.getImageFormat();
            if (imageFormat == null || imageFormat == ImageFormat.UNKNOWN) {
                imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
                encodedImage.setImageFormat(imageFormat);
            }
            Map<ImageFormat, ImageDecoder> map = this.mCustomDecoders;
            if (map != null && (imageDecoder = map.get(imageFormat)) != null) {
                return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            return this.mDefaultDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return (CloseableImage) invokeLILL.objValue;
    }

    public CloseableImage decodeAnimatedWebp(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLILL = interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, encodedImage, i, qualityInfo, imageDecodeOptions)) == null) ? this.mAnimatedWebPDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions) : (CloseableImage) invokeLILL.objValue;
    }

    public CloseableImage decodeGif(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeLILL;
        ImageDecoder imageDecoder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, encodedImage, i, qualityInfo, imageDecodeOptions)) == null) {
            if (!imageDecodeOptions.forceStaticImage && (imageDecoder = this.mAnimatedGifDecoder) != null) {
                return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            return decodeStaticImage(encodedImage, imageDecodeOptions);
        }
        return (CloseableImage) invokeLILL.objValue;
    }

    public CloseableStaticBitmap decodeJpeg(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048579, this, encodedImage, i, qualityInfo, imageDecodeOptions)) == null) {
            CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeJPEGFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, i, imageDecodeOptions.transformToSRGB);
            try {
                maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeJPEGFromEncodedImageWithColorSpace);
                return new CloseableStaticBitmap(decodeJPEGFromEncodedImageWithColorSpace, qualityInfo, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            } finally {
                decodeJPEGFromEncodedImageWithColorSpace.close();
            }
        }
        return (CloseableStaticBitmap) invokeLILL.objValue;
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, encodedImage, imageDecodeOptions)) == null) {
            CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, imageDecodeOptions.transformToSRGB);
            try {
                maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeFromEncodedImageWithColorSpace);
                return new CloseableStaticBitmap(decodeFromEncodedImageWithColorSpace, ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            } finally {
                decodeFromEncodedImageWithColorSpace.close();
            }
        }
        return (CloseableStaticBitmap) invokeLL.objValue;
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder, @Nullable Map<ImageFormat, ImageDecoder> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageDecoder, imageDecoder2, platformDecoder, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDefaultDecoder = new ImageDecoder(this) { // from class: com.facebook.imagepipeline.decoder.DefaultImageDecoder.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DefaultImageDecoder this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            public CloseableImage decode(EncodedImage encodedImage, int i3, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                InterceptResult invokeLILL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLILL = interceptable2.invokeLILL(1048576, this, encodedImage, i3, qualityInfo, imageDecodeOptions)) == null) {
                    ImageFormat imageFormat = encodedImage.getImageFormat();
                    if (imageFormat == DefaultImageFormats.JPEG) {
                        return this.this$0.decodeJpeg(encodedImage, i3, qualityInfo, imageDecodeOptions);
                    }
                    if (imageFormat == DefaultImageFormats.GIF) {
                        return this.this$0.decodeGif(encodedImage, i3, qualityInfo, imageDecodeOptions);
                    }
                    if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                        return this.this$0.decodeAnimatedWebp(encodedImage, i3, qualityInfo, imageDecodeOptions);
                    }
                    if (imageFormat != ImageFormat.UNKNOWN) {
                        return this.this$0.decodeStaticImage(encodedImage, imageDecodeOptions);
                    }
                    throw new DecodeException("unknown image format", encodedImage);
                }
                return (CloseableImage) invokeLILL.objValue;
            }
        };
        this.mAnimatedGifDecoder = imageDecoder;
        this.mAnimatedWebPDecoder = imageDecoder2;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = map;
    }
}
