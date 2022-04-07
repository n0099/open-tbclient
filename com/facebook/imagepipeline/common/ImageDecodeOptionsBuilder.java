package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class ImageDecodeOptionsBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap.Config mBitmapConfig;
    @Nullable
    public BitmapTransformation mBitmapTransformation;
    @Nullable
    public ImageDecoder mCustomImageDecoder;
    public boolean mDecodeAllFrames;
    public boolean mDecodePreviewFrame;
    public boolean mForceStaticImage;
    public int mMinDecodeIntervalMs;
    public boolean mTransformToSRGB;
    public boolean mUseLastFrameForPreview;

    public ImageDecodeOptionsBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMinDecodeIntervalMs = 100;
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
    }

    public ImageDecodeOptions build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ImageDecodeOptions(this) : (ImageDecodeOptions) invokeV.objValue;
    }

    public Bitmap.Config getBitmapConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBitmapConfig : (Bitmap.Config) invokeV.objValue;
    }

    @Nullable
    public BitmapTransformation getBitmapTransformation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBitmapTransformation : (BitmapTransformation) invokeV.objValue;
    }

    @Nullable
    public ImageDecoder getCustomImageDecoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCustomImageDecoder : (ImageDecoder) invokeV.objValue;
    }

    public boolean getDecodeAllFrames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDecodeAllFrames : invokeV.booleanValue;
    }

    public boolean getDecodePreviewFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDecodePreviewFrame : invokeV.booleanValue;
    }

    public boolean getForceStaticImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mForceStaticImage : invokeV.booleanValue;
    }

    public int getMinDecodeIntervalMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mMinDecodeIntervalMs : invokeV.intValue;
    }

    public boolean getTransformToSRGB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mTransformToSRGB : invokeV.booleanValue;
    }

    public boolean getUseLastFrameForPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mUseLastFrameForPreview : invokeV.booleanValue;
    }

    public ImageDecodeOptionsBuilder setBitmapConfig(Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, config)) == null) {
            this.mBitmapConfig = config;
            return this;
        }
        return (ImageDecodeOptionsBuilder) invokeL.objValue;
    }

    public ImageDecodeOptionsBuilder setBitmapTransformation(@Nullable BitmapTransformation bitmapTransformation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bitmapTransformation)) == null) {
            this.mBitmapTransformation = bitmapTransformation;
            return this;
        }
        return (ImageDecodeOptionsBuilder) invokeL.objValue;
    }

    public ImageDecodeOptionsBuilder setCustomImageDecoder(@Nullable ImageDecoder imageDecoder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, imageDecoder)) == null) {
            this.mCustomImageDecoder = imageDecoder;
            return this;
        }
        return (ImageDecodeOptionsBuilder) invokeL.objValue;
    }

    public ImageDecodeOptionsBuilder setDecodeAllFrames(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            this.mDecodeAllFrames = z;
            return this;
        }
        return (ImageDecodeOptionsBuilder) invokeZ.objValue;
    }

    public ImageDecodeOptionsBuilder setDecodePreviewFrame(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            this.mDecodePreviewFrame = z;
            return this;
        }
        return (ImageDecodeOptionsBuilder) invokeZ.objValue;
    }

    public ImageDecodeOptionsBuilder setForceStaticImage(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            this.mForceStaticImage = z;
            return this;
        }
        return (ImageDecodeOptionsBuilder) invokeZ.objValue;
    }

    public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, imageDecodeOptions)) == null) {
            this.mDecodePreviewFrame = imageDecodeOptions.decodePreviewFrame;
            this.mUseLastFrameForPreview = imageDecodeOptions.useLastFrameForPreview;
            this.mDecodeAllFrames = imageDecodeOptions.decodeAllFrames;
            this.mForceStaticImage = imageDecodeOptions.forceStaticImage;
            this.mBitmapConfig = imageDecodeOptions.bitmapConfig;
            this.mCustomImageDecoder = imageDecodeOptions.customImageDecoder;
            this.mTransformToSRGB = imageDecodeOptions.transformToSRGB;
            this.mBitmapTransformation = imageDecodeOptions.bitmapTransformation;
            return this;
        }
        return (ImageDecodeOptionsBuilder) invokeL.objValue;
    }

    public ImageDecodeOptionsBuilder setMinDecodeIntervalMs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            this.mMinDecodeIntervalMs = i;
            return this;
        }
        return (ImageDecodeOptionsBuilder) invokeI.objValue;
    }

    public ImageDecodeOptionsBuilder setTransformToSRGB(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.mTransformToSRGB = z;
            return this;
        }
        return (ImageDecodeOptionsBuilder) invokeZ.objValue;
    }

    public ImageDecodeOptionsBuilder setUseLastFrameForPreview(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            this.mUseLastFrameForPreview = z;
            return this;
        }
        return (ImageDecodeOptionsBuilder) invokeZ.objValue;
    }
}
