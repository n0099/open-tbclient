package com.facebook.imagepipeline.nativecode;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.transcoder.DownsampleUtil;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
@DoNotStrip
/* loaded from: classes4.dex */
public class NativeJpegTranscoder implements ImageTranscoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NativeJpegTranscoder";
    public transient /* synthetic */ FieldHolder $fh;
    public int mMaxBitmapSize;
    public boolean mResizingEnabled;
    public boolean mUseDownsamplingRatio;

    public NativeJpegTranscoder(boolean z, int i, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mResizingEnabled = z;
        this.mMaxBitmapSize = i;
        this.mUseDownsamplingRatio = z2;
        if (z3) {
            NativeJpegTranscoderSoLoader.ensure();
        }
    }

    @DoNotStrip
    public static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @DoNotStrip
    public static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @VisibleForTesting
    public static void transcodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{inputStream, outputStream, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            NativeJpegTranscoderSoLoader.ensure();
            boolean z = false;
            Preconditions.checkArgument(i2 >= 1);
            Preconditions.checkArgument(i2 <= 16);
            Preconditions.checkArgument(i3 >= 0);
            Preconditions.checkArgument(i3 <= 100);
            Preconditions.checkArgument(JpegTranscoderUtils.isRotationAngleAllowed(i));
            Preconditions.checkArgument((i2 == 8 && i == 0) ? true : true, "no transformation requested");
            nativeTranscodeJpeg((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i, i2, i3);
        }
    }

    @VisibleForTesting
    public static void transcodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{inputStream, outputStream, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            NativeJpegTranscoderSoLoader.ensure();
            boolean z = false;
            Preconditions.checkArgument(i2 >= 1);
            Preconditions.checkArgument(i2 <= 16);
            Preconditions.checkArgument(i3 >= 0);
            Preconditions.checkArgument(i3 <= 100);
            Preconditions.checkArgument(JpegTranscoderUtils.isExifOrientationAllowed(i));
            Preconditions.checkArgument((i2 == 8 && i == 1) ? true : true, "no transformation requested");
            nativeTranscodeJpegWithExifOrientation((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i, i2, i3);
        }
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(EncodedImage encodedImage, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, encodedImage, rotationOptions, resizeOptions)) == null) {
            if (rotationOptions == null) {
                rotationOptions = RotationOptions.autoRotate();
            }
            return JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.mResizingEnabled) < 8;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(ImageFormat imageFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFormat)) == null) ? imageFormat == DefaultImageFormats.JPEG : invokeL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public ImageTranscodeResult transcode(EncodedImage encodedImage, OutputStream outputStream, @Nullable RotationOptions rotationOptions, @Nullable ResizeOptions resizeOptions, @Nullable ImageFormat imageFormat, @Nullable Integer num) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{encodedImage, outputStream, rotationOptions, resizeOptions, imageFormat, num})) == null) {
            if (num == null) {
                num = 85;
            }
            if (rotationOptions == null) {
                rotationOptions = RotationOptions.autoRotate();
            }
            int determineSampleSize = DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.mMaxBitmapSize);
            try {
                int softwareNumerator = JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.mResizingEnabled);
                int calculateDownsampleNumerator = JpegTranscoderUtils.calculateDownsampleNumerator(determineSampleSize);
                if (this.mUseDownsamplingRatio) {
                    softwareNumerator = calculateDownsampleNumerator;
                }
                InputStream inputStream = encodedImage.getInputStream();
                if (JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
                    transcodeJpegWithExifOrientation(inputStream, outputStream, JpegTranscoderUtils.getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage), softwareNumerator, num.intValue());
                } else {
                    transcodeJpeg(inputStream, outputStream, JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage), softwareNumerator, num.intValue());
                }
                Closeables.closeQuietly(inputStream);
                return new ImageTranscodeResult(determineSampleSize != 1 ? 0 : 1);
            } catch (Throwable th) {
                Closeables.closeQuietly((InputStream) null);
                throw th;
            }
        }
        return (ImageTranscodeResult) invokeCommon.objValue;
    }
}
