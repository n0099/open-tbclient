package com.facebook.imagepipeline.transcoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.OutputStream;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class SimpleImageTranscoder implements ImageTranscoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SimpleImageTranscoder";
    public transient /* synthetic */ FieldHolder $fh;
    public final int mMaxBitmapSize;
    public final boolean mResizingEnabled;

    public SimpleImageTranscoder(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mResizingEnabled = z;
        this.mMaxBitmapSize = i2;
    }

    public static Bitmap.CompressFormat getOutputFormat(@Nullable ImageFormat imageFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, imageFormat)) == null) {
            if (imageFormat == null) {
                return Bitmap.CompressFormat.JPEG;
            }
            if (imageFormat == DefaultImageFormats.JPEG) {
                return Bitmap.CompressFormat.JPEG;
            }
            if (imageFormat == DefaultImageFormats.PNG) {
                return Bitmap.CompressFormat.PNG;
            }
            if (Build.VERSION.SDK_INT >= 14 && DefaultImageFormats.isStaticWebpFormat(imageFormat)) {
                return Bitmap.CompressFormat.WEBP;
            }
            return Bitmap.CompressFormat.JPEG;
        }
        return (Bitmap.CompressFormat) invokeL.objValue;
    }

    private int getSampleSize(EncodedImage encodedImage, RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, encodedImage, rotationOptions, resizeOptions)) == null) {
            if (this.mResizingEnabled) {
                return DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.mMaxBitmapSize);
            }
            return 1;
        }
        return invokeLLL.intValue;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(EncodedImage encodedImage, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, encodedImage, rotationOptions, resizeOptions)) == null) {
            if (rotationOptions == null) {
                rotationOptions = RotationOptions.autoRotate();
            }
            return this.mResizingEnabled && DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.mMaxBitmapSize) > 1;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(ImageFormat imageFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFormat)) == null) ? imageFormat == DefaultImageFormats.HEIF || imageFormat == DefaultImageFormats.JPEG : invokeL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public ImageTranscodeResult transcode(EncodedImage encodedImage, OutputStream outputStream, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, @Nullable ImageFormat imageFormat, @Nullable Integer num) {
        InterceptResult invokeCommon;
        SimpleImageTranscoder simpleImageTranscoder;
        RotationOptions rotationOptions2;
        Bitmap bitmap;
        Throwable th;
        OutOfMemoryError e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{encodedImage, outputStream, rotationOptions, resizeOptions, imageFormat, num})) == null) {
            Integer num2 = num == null ? 85 : num;
            if (rotationOptions == null) {
                rotationOptions2 = RotationOptions.autoRotate();
                simpleImageTranscoder = this;
            } else {
                simpleImageTranscoder = this;
                rotationOptions2 = rotationOptions;
            }
            int sampleSize = simpleImageTranscoder.getSampleSize(encodedImage, rotationOptions2, resizeOptions);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = sampleSize;
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
                if (decodeStream == null) {
                    FLog.e(TAG, "Couldn't decode the EncodedImage InputStream ! ");
                    return new ImageTranscodeResult(2);
                }
                Matrix transformationMatrix = JpegTranscoderUtils.getTransformationMatrix(encodedImage, rotationOptions2);
                if (transformationMatrix != null) {
                    try {
                        bitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), transformationMatrix, false);
                    } catch (OutOfMemoryError e3) {
                        e2 = e3;
                        bitmap = decodeStream;
                        FLog.e(TAG, "Out-Of-Memory during transcode", e2);
                        ImageTranscodeResult imageTranscodeResult = new ImageTranscodeResult(2);
                        bitmap.recycle();
                        decodeStream.recycle();
                        return imageTranscodeResult;
                    } catch (Throwable th2) {
                        th = th2;
                        bitmap = decodeStream;
                        bitmap.recycle();
                        decodeStream.recycle();
                        throw th;
                    }
                } else {
                    bitmap = decodeStream;
                }
                try {
                    try {
                        bitmap.compress(getOutputFormat(imageFormat), num2.intValue(), outputStream);
                        ImageTranscodeResult imageTranscodeResult2 = new ImageTranscodeResult(sampleSize > 1 ? 0 : 1);
                        bitmap.recycle();
                        decodeStream.recycle();
                        return imageTranscodeResult2;
                    } catch (OutOfMemoryError e4) {
                        e2 = e4;
                        FLog.e(TAG, "Out-Of-Memory during transcode", e2);
                        ImageTranscodeResult imageTranscodeResult3 = new ImageTranscodeResult(2);
                        bitmap.recycle();
                        decodeStream.recycle();
                        return imageTranscodeResult3;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bitmap.recycle();
                    decodeStream.recycle();
                    throw th;
                }
            } catch (OutOfMemoryError e5) {
                FLog.e(TAG, "Out-Of-Memory during transcode", e5);
                return new ImageTranscodeResult(2);
            }
        }
        return (ImageTranscodeResult) invokeCommon.objValue;
    }
}
