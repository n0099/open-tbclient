package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
@DoNotStrip
/* loaded from: classes5.dex */
public class WebpTranscoderImpl implements WebpTranscoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WebpTranscoderImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @DoNotStrip
    public static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i2) throws IOException;

    @DoNotStrip
    public static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException;

    @Override // com.facebook.imagepipeline.nativecode.WebpTranscoder
    public boolean isWebpNativelySupported(ImageFormat imageFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFormat)) == null) {
            if (imageFormat == DefaultImageFormats.WEBP_SIMPLE) {
                return Build.VERSION.SDK_INT >= 14;
            } else if (imageFormat != DefaultImageFormats.WEBP_LOSSLESS && imageFormat != DefaultImageFormats.WEBP_EXTENDED && imageFormat != DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA) {
                if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                    return false;
                }
                throw new IllegalArgumentException("Image format is not a WebP.");
            } else {
                return WebpSupportStatus.sIsExtendedWebpSupported;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.nativecode.WebpTranscoder
    public void transcodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream, outputStream, i2) == null) {
            StaticWebpNativeLoader.ensure();
            nativeTranscodeWebpToJpeg((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i2);
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.WebpTranscoder
    public void transcodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, inputStream, outputStream) == null) {
            StaticWebpNativeLoader.ensure();
            nativeTranscodeWebpToPng((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream));
        }
    }
}
