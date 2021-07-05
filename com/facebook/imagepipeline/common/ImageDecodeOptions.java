package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes6.dex */
public class ImageDecodeOptions {
    public static /* synthetic */ Interceptable $ic;
    public static final ImageDecodeOptions DEFAULTS;
    public transient /* synthetic */ FieldHolder $fh;
    public final Bitmap.Config bitmapConfig;
    @Nullable
    public final BitmapTransformation bitmapTransformation;
    @Nullable
    public final ImageDecoder customImageDecoder;
    public final boolean decodeAllFrames;
    public final boolean decodePreviewFrame;
    public final boolean forceStaticImage;
    public final int minDecodeIntervalMs;
    public final boolean transformToSRGB;
    public final boolean useLastFrameForPreview;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1031101181, "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1031101181, "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;");
                return;
            }
        }
        DEFAULTS = newBuilder().build();
    }

    public ImageDecodeOptions(ImageDecodeOptionsBuilder imageDecodeOptionsBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageDecodeOptionsBuilder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.minDecodeIntervalMs = imageDecodeOptionsBuilder.getMinDecodeIntervalMs();
        this.decodePreviewFrame = imageDecodeOptionsBuilder.getDecodePreviewFrame();
        this.useLastFrameForPreview = imageDecodeOptionsBuilder.getUseLastFrameForPreview();
        this.decodeAllFrames = imageDecodeOptionsBuilder.getDecodeAllFrames();
        this.forceStaticImage = imageDecodeOptionsBuilder.getForceStaticImage();
        this.bitmapConfig = imageDecodeOptionsBuilder.getBitmapConfig();
        this.customImageDecoder = imageDecodeOptionsBuilder.getCustomImageDecoder();
        this.transformToSRGB = imageDecodeOptionsBuilder.getTransformToSRGB();
        this.bitmapTransformation = imageDecodeOptionsBuilder.getBitmapTransformation();
    }

    public static ImageDecodeOptions defaults() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? DEFAULTS : (ImageDecodeOptions) invokeV.objValue;
    }

    public static ImageDecodeOptionsBuilder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new ImageDecodeOptionsBuilder() : (ImageDecodeOptionsBuilder) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ImageDecodeOptions.class != obj.getClass()) {
                return false;
            }
            ImageDecodeOptions imageDecodeOptions = (ImageDecodeOptions) obj;
            return this.decodePreviewFrame == imageDecodeOptions.decodePreviewFrame && this.useLastFrameForPreview == imageDecodeOptions.useLastFrameForPreview && this.decodeAllFrames == imageDecodeOptions.decodeAllFrames && this.forceStaticImage == imageDecodeOptions.forceStaticImage && this.transformToSRGB == imageDecodeOptions.transformToSRGB && this.bitmapConfig == imageDecodeOptions.bitmapConfig && this.customImageDecoder == imageDecodeOptions.customImageDecoder && this.bitmapTransformation == imageDecodeOptions.bitmapTransformation;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int ordinal = ((((((((((((this.minDecodeIntervalMs * 31) + (this.decodePreviewFrame ? 1 : 0)) * 31) + (this.useLastFrameForPreview ? 1 : 0)) * 31) + (this.decodeAllFrames ? 1 : 0)) * 31) + (this.forceStaticImage ? 1 : 0)) * 31) + (this.transformToSRGB ? 1 : 0)) * 31) + this.bitmapConfig.ordinal()) * 31;
            ImageDecoder imageDecoder = this.customImageDecoder;
            int hashCode = (ordinal + (imageDecoder != null ? imageDecoder.hashCode() : 0)) * 31;
            BitmapTransformation bitmapTransformation = this.bitmapTransformation;
            return hashCode + (bitmapTransformation != null ? bitmapTransformation.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.format(null, "%d-%b-%b-%b-%b-%b-%s-%s-%s", Integer.valueOf(this.minDecodeIntervalMs), Boolean.valueOf(this.decodePreviewFrame), Boolean.valueOf(this.useLastFrameForPreview), Boolean.valueOf(this.decodeAllFrames), Boolean.valueOf(this.forceStaticImage), Boolean.valueOf(this.transformToSRGB), this.bitmapConfig.name(), this.customImageDecoder, this.bitmapTransformation) : (String) invokeV.objValue;
    }
}
