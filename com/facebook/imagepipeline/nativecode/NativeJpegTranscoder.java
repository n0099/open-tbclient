package com.facebook.imagepipeline.nativecode;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
/* loaded from: classes12.dex */
public class NativeJpegTranscoder implements ImageTranscoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NativeJpegTranscoder";
    public transient /* synthetic */ FieldHolder $fh;
    public int mMaxBitmapSize;
    public boolean mResizingEnabled;
    public boolean mUseDownsamplingRatio;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-298362827, "Lcom/facebook/imagepipeline/nativecode/NativeJpegTranscoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-298362827, "Lcom/facebook/imagepipeline/nativecode/NativeJpegTranscoder;");
                return;
            }
        }
        NativeJpegTranscoderSoLoader.ensure();
    }

    public NativeJpegTranscoder(boolean z, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mResizingEnabled = z;
        this.mMaxBitmapSize = i2;
        this.mUseDownsamplingRatio = z2;
    }

    @DoNotStrip
    public static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;

    @DoNotStrip
    public static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;

    @VisibleForTesting
    public static void transcodeJpeg(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{inputStream, outputStream, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            NativeJpegTranscoderSoLoader.ensure();
            boolean z = false;
            Preconditions.checkArgument(i3 >= 1);
            Preconditions.checkArgument(i3 <= 16);
            Preconditions.checkArgument(i4 >= 0);
            Preconditions.checkArgument(i4 <= 100);
            Preconditions.checkArgument(JpegTranscoderUtils.isRotationAngleAllowed(i2));
            Preconditions.checkArgument((i3 == 8 && i2 == 0) ? true : true, "no transformation requested");
            nativeTranscodeJpeg((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i2, i3, i4);
        }
    }

    @VisibleForTesting
    public static void transcodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{inputStream, outputStream, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            NativeJpegTranscoderSoLoader.ensure();
            boolean z = false;
            Preconditions.checkArgument(i3 >= 1);
            Preconditions.checkArgument(i3 <= 16);
            Preconditions.checkArgument(i4 >= 0);
            Preconditions.checkArgument(i4 <= 100);
            Preconditions.checkArgument(JpegTranscoderUtils.isExifOrientationAllowed(i2));
            Preconditions.checkArgument((i3 == 8 && i2 == 1) ? true : true, "no transformation requested");
            nativeTranscodeJpegWithExifOrientation((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i2, i3, i4);
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
