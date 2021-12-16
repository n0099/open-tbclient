package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.utils.ImageSizeUtils;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class BaseImageDecoder implements ImageDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    public static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    public static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    public static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
    public static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    public static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean loggingEnabled;

    /* loaded from: classes3.dex */
    public static class ExifInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean flipHorizontal;
        public final int rotation;

        public ExifInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.rotation = 0;
            this.flipHorizontal = false;
        }

        public ExifInfo(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.rotation = i2;
            this.flipHorizontal = z;
        }
    }

    /* loaded from: classes3.dex */
    public static class ImageFileInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ExifInfo exif;
        public final ImageSize imageSize;

        public ImageFileInfo(ImageSize imageSize, ExifInfo exifInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageSize, exifInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.imageSize = imageSize;
            this.exif = exifInfo;
        }
    }

    public BaseImageDecoder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.loggingEnabled = z;
    }

    private boolean canDefineExifParams(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) ? "image/jpeg".equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE : invokeLL.booleanValue;
    }

    public Bitmap considerExactScaleAndOrientatiton(Bitmap bitmap, ImageDecodingInfo imageDecodingInfo, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bitmap, imageDecodingInfo, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Matrix matrix = new Matrix();
            ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
            if (imageScaleType == ImageScaleType.EXACTLY || imageScaleType == ImageScaleType.EXACTLY_STRETCHED) {
                ImageSize imageSize = new ImageSize(bitmap.getWidth(), bitmap.getHeight(), i2);
                float computeImageScale = ImageSizeUtils.computeImageScale(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.EXACTLY_STRETCHED);
                if (Float.compare(computeImageScale, 1.0f) != 0) {
                    matrix.setScale(computeImageScale, computeImageScale);
                    if (this.loggingEnabled) {
                        L.d(LOG_SCALE_IMAGE, imageSize, imageSize.scale(computeImageScale), Float.valueOf(computeImageScale), imageDecodingInfo.getImageKey());
                    }
                }
            }
            if (z) {
                matrix.postScale(-1.0f, 1.0f);
                if (this.loggingEnabled) {
                    L.d(LOG_FLIP_IMAGE, imageDecodingInfo.getImageKey());
                }
            }
            if (i2 != 0) {
                matrix.postRotate(i2);
                if (this.loggingEnabled) {
                    L.d(LOG_ROTATE_IMAGE, Integer.valueOf(i2), imageDecodingInfo.getImageKey());
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.core.decode.ImageDecoder
    public DecodedResult decode(ImageDecodingInfo imageDecodingInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageDecodingInfo)) == null) {
            DecodedResult decodedResult = new DecodedResult();
            InputStream imageStream = getImageStream(imageDecodingInfo);
            if (imageStream == null) {
                L.e("No stream for image [%s]", imageDecodingInfo.getImageKey());
                return null;
            }
            try {
                if (imageDecodingInfo.getLoadListener() == null || !imageDecodingInfo.getLoadListener().onDecode(imageDecodingInfo.getImageUri(), imageStream, decodedResult)) {
                    ImageFileInfo defineImageSizeAndRotation = defineImageSizeAndRotation(imageStream, imageDecodingInfo);
                    imageStream = resetStream(imageStream, imageDecodingInfo);
                    decodedResult.mBitmap = BitmapFactory.decodeStream(imageStream, null, prepareDecodingOptions(defineImageSizeAndRotation.imageSize, imageDecodingInfo));
                    IoUtils.closeSilently(imageStream);
                    if (decodedResult.mBitmap == null && decodedResult.mFrameSequence == null) {
                        L.e(ERROR_CANT_DECODE_IMAGE, imageDecodingInfo.getImageKey());
                    } else {
                        Bitmap bitmap = decodedResult.mBitmap;
                        ExifInfo exifInfo = defineImageSizeAndRotation.exif;
                        decodedResult.mBitmap = considerExactScaleAndOrientatiton(bitmap, imageDecodingInfo, exifInfo.rotation, exifInfo.flipHorizontal);
                    }
                    return decodedResult;
                }
                return decodedResult;
            } finally {
                IoUtils.closeSilently(imageStream);
            }
        }
        return (DecodedResult) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: boolean */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public ExifInfo defineExifOrientation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int i2 = 0;
            boolean z = 1;
            try {
            } catch (IOException unused) {
                L.w("Can't read EXIF tags from file [%s]", str);
            }
            switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt("Orientation", 1)) {
                case 1:
                default:
                    z = 0;
                    break;
                case 2:
                    break;
                case 3:
                    z = i2;
                    i2 = 180;
                    break;
                case 4:
                    i2 = 1;
                    z = i2;
                    i2 = 180;
                    break;
                case 5:
                    i2 = 1;
                    z = i2;
                    i2 = 270;
                    break;
                case 6:
                    z = i2;
                    i2 = 90;
                    break;
                case 7:
                    i2 = 1;
                    z = i2;
                    i2 = 90;
                    break;
                case 8:
                    z = i2;
                    i2 = 270;
                    break;
            }
            return new ExifInfo(i2, z);
        }
        return (ExifInfo) invokeL.objValue;
    }

    public ImageFileInfo defineImageSizeAndRotation(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, inputStream, imageDecodingInfo)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
            String imageUri = imageDecodingInfo.getImageUri();
            ExifInfo defineExifOrientation = (imageDecodingInfo.shouldConsiderExifParams() && canDefineExifParams(imageUri, options.outMimeType)) ? defineExifOrientation(imageUri) : new ExifInfo();
            return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, defineExifOrientation.rotation), defineExifOrientation);
        }
        return (ImageFileInfo) invokeLL.objValue;
    }

    public InputStream getImageStream(ImageDecodingInfo imageDecodingInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageDecodingInfo)) == null) ? imageDecodingInfo.getDownloader().getStream(imageDecodingInfo.getImageUri(), imageDecodingInfo.getExtraForDownloader()) : (InputStream) invokeL.objValue;
    }

    public BitmapFactory.Options prepareDecodingOptions(ImageSize imageSize, ImageDecodingInfo imageDecodingInfo) {
        InterceptResult invokeLL;
        int computeImageSampleSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, imageSize, imageDecodingInfo)) == null) {
            ImageScaleType imageScaleType = imageDecodingInfo.getImageScaleType();
            if (imageScaleType == ImageScaleType.NONE) {
                computeImageSampleSize = 1;
            } else if (imageScaleType == ImageScaleType.NONE_SAFE) {
                computeImageSampleSize = ImageSizeUtils.computeMinImageSampleSize(imageSize);
            } else {
                computeImageSampleSize = ImageSizeUtils.computeImageSampleSize(imageSize, imageDecodingInfo.getTargetSize(), imageDecodingInfo.getViewScaleType(), imageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2);
            }
            if (computeImageSampleSize > 1 && this.loggingEnabled) {
                L.d(LOG_SUBSAMPLE_IMAGE, imageSize, imageSize.scaleDown(computeImageSampleSize), Integer.valueOf(computeImageSampleSize), imageDecodingInfo.getImageKey());
            }
            BitmapFactory.Options decodingOptions = imageDecodingInfo.getDecodingOptions();
            decodingOptions.inSampleSize = computeImageSampleSize;
            return decodingOptions;
        }
        return (BitmapFactory.Options) invokeLL.objValue;
    }

    public InputStream resetStream(InputStream inputStream, ImageDecodingInfo imageDecodingInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, inputStream, imageDecodingInfo)) == null) {
            if (inputStream.markSupported()) {
                try {
                    inputStream.reset();
                    return inputStream;
                } catch (IOException unused) {
                }
            }
            IoUtils.closeSilently(inputStream);
            return getImageStream(imageDecodingInfo);
        }
        return (InputStream) invokeLL.objValue;
    }
}
