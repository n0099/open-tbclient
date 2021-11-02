package com.facebook.imagepipeline.transcoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import com.facebook.imagepipeline.nativecode.NativeImageTranscoderFactory;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class MultiImageTranscoderFactory implements ImageTranscoderFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean mEnsureTranscoderLibraryLoaded;
    @Nullable
    public final Integer mImageTranscoderType;
    public final int mMaxBitmapSize;
    @Nullable
    public final ImageTranscoderFactory mPrimaryImageTranscoderFactory;
    public final boolean mUseDownSamplingRatio;

    public MultiImageTranscoderFactory(int i2, boolean z, @Nullable ImageTranscoderFactory imageTranscoderFactory, @Nullable Integer num, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), imageTranscoderFactory, num, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMaxBitmapSize = i2;
        this.mUseDownSamplingRatio = z;
        this.mPrimaryImageTranscoderFactory = imageTranscoderFactory;
        this.mImageTranscoderType = num;
        this.mEnsureTranscoderLibraryLoaded = z2;
    }

    @Nullable
    private ImageTranscoder getCustomImageTranscoder(ImageFormat imageFormat, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, imageFormat, z)) == null) {
            ImageTranscoderFactory imageTranscoderFactory = this.mPrimaryImageTranscoderFactory;
            if (imageTranscoderFactory == null) {
                return null;
            }
            return imageTranscoderFactory.createImageTranscoder(imageFormat, z);
        }
        return (ImageTranscoder) invokeLZ.objValue;
    }

    @Nullable
    private ImageTranscoder getImageTranscoderWithType(ImageFormat imageFormat, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, this, imageFormat, z)) == null) {
            Integer num = this.mImageTranscoderType;
            if (num == null) {
                return null;
            }
            int intValue = num.intValue();
            if (intValue != 0) {
                if (intValue == 1) {
                    return getSimpleImageTranscoder(imageFormat, z);
                }
                throw new IllegalArgumentException("Invalid ImageTranscoderType");
            }
            return getNativeImageTranscoder(imageFormat, z);
        }
        return (ImageTranscoder) invokeLZ.objValue;
    }

    @Nullable
    private ImageTranscoder getNativeImageTranscoder(ImageFormat imageFormat, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, this, imageFormat, z)) == null) ? NativeImageTranscoderFactory.getNativeImageTranscoderFactory(this.mMaxBitmapSize, this.mUseDownSamplingRatio, this.mEnsureTranscoderLibraryLoaded).createImageTranscoder(imageFormat, z) : (ImageTranscoder) invokeLZ.objValue;
    }

    private ImageTranscoder getSimpleImageTranscoder(ImageFormat imageFormat, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, imageFormat, z)) == null) ? new SimpleImageTranscoderFactory(this.mMaxBitmapSize).createImageTranscoder(imageFormat, z) : (ImageTranscoder) invokeLZ.objValue;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, imageFormat, z)) == null) {
            ImageTranscoder customImageTranscoder = getCustomImageTranscoder(imageFormat, z);
            if (customImageTranscoder == null) {
                customImageTranscoder = getImageTranscoderWithType(imageFormat, z);
            }
            if (customImageTranscoder == null && NativeCodeSetup.getUseNativeCode()) {
                customImageTranscoder = getNativeImageTranscoder(imageFormat, z);
            }
            return customImageTranscoder == null ? getSimpleImageTranscoder(imageFormat, z) : customImageTranscoder;
        }
        return (ImageTranscoder) invokeLZ.objValue;
    }
}
