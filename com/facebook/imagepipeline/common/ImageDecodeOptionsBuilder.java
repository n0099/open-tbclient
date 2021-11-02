package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class ImageDecodeOptionsBuilder<T extends ImageDecodeOptionsBuilder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap.Config mBitmapConfig;
    @Nullable
    public BitmapTransformation mBitmapTransformation;
    @Nullable
    public ColorSpace mColorSpace;
    @Nullable
    public ImageDecoder mCustomImageDecoder;
    public boolean mDecodeAllFrames;
    public boolean mDecodePreviewFrame;
    public boolean mForceStaticImage;
    public int mMaxDimensionPx;
    public int mMinDecodeIntervalMs;
    public boolean mUseLastFrameForPreview;

    public ImageDecodeOptionsBuilder() {
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
        this.mMinDecodeIntervalMs = 100;
        this.mMaxDimensionPx = Integer.MAX_VALUE;
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
    public ColorSpace getColorSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mColorSpace : (ColorSpace) invokeV.objValue;
    }

    @Nullable
    public ImageDecoder getCustomImageDecoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCustomImageDecoder : (ImageDecoder) invokeV.objValue;
    }

    public boolean getDecodeAllFrames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDecodeAllFrames : invokeV.booleanValue;
    }

    public boolean getDecodePreviewFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mDecodePreviewFrame : invokeV.booleanValue;
    }

    public boolean getForceStaticImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mForceStaticImage : invokeV.booleanValue;
    }

    public int getMaxDimensionPx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mMaxDimensionPx : invokeV.intValue;
    }

    public int getMinDecodeIntervalMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mMinDecodeIntervalMs : invokeV.intValue;
    }

    public T getThis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : (T) invokeV.objValue;
    }

    public boolean getUseLastFrameForPreview() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mUseLastFrameForPreview : invokeV.booleanValue;
    }

    public T setBitmapConfig(Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, config)) == null) {
            this.mBitmapConfig = config;
            return getThis();
        }
        return (T) invokeL.objValue;
    }

    public T setBitmapTransformation(@Nullable BitmapTransformation bitmapTransformation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bitmapTransformation)) == null) {
            this.mBitmapTransformation = bitmapTransformation;
            return getThis();
        }
        return (T) invokeL.objValue;
    }

    public T setColorSpace(ColorSpace colorSpace) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, colorSpace)) == null) {
            this.mColorSpace = colorSpace;
            return getThis();
        }
        return (T) invokeL.objValue;
    }

    public T setCustomImageDecoder(@Nullable ImageDecoder imageDecoder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, imageDecoder)) == null) {
            this.mCustomImageDecoder = imageDecoder;
            return getThis();
        }
        return (T) invokeL.objValue;
    }

    public T setDecodeAllFrames(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            this.mDecodeAllFrames = z;
            return getThis();
        }
        return (T) invokeZ.objValue;
    }

    public T setDecodePreviewFrame(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            this.mDecodePreviewFrame = z;
            return getThis();
        }
        return (T) invokeZ.objValue;
    }

    public T setForceStaticImage(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.mForceStaticImage = z;
            return getThis();
        }
        return (T) invokeZ.objValue;
    }

    public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions imageDecodeOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, imageDecodeOptions)) == null) {
            this.mMinDecodeIntervalMs = imageDecodeOptions.minDecodeIntervalMs;
            this.mMaxDimensionPx = imageDecodeOptions.maxDimensionPx;
            this.mDecodePreviewFrame = imageDecodeOptions.decodePreviewFrame;
            this.mUseLastFrameForPreview = imageDecodeOptions.useLastFrameForPreview;
            this.mDecodeAllFrames = imageDecodeOptions.decodeAllFrames;
            this.mForceStaticImage = imageDecodeOptions.forceStaticImage;
            this.mBitmapConfig = imageDecodeOptions.bitmapConfig;
            this.mCustomImageDecoder = imageDecodeOptions.customImageDecoder;
            this.mBitmapTransformation = imageDecodeOptions.bitmapTransformation;
            this.mColorSpace = imageDecodeOptions.colorSpace;
            return getThis();
        }
        return (ImageDecodeOptionsBuilder) invokeL.objValue;
    }

    public T setMaxDimensionPx(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            this.mMaxDimensionPx = i2;
            return getThis();
        }
        return (T) invokeI.objValue;
    }

    public T setMinDecodeIntervalMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            this.mMinDecodeIntervalMs = i2;
            return getThis();
        }
        return (T) invokeI.objValue;
    }

    public T setUseLastFrameForPreview(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            this.mUseLastFrameForPreview = z;
            return getThis();
        }
        return (T) invokeZ.objValue;
    }
}
